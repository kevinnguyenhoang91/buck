/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.android;

import com.facebook.buck.jvm.java.AnnotationProcessingParams;
import com.facebook.buck.jvm.java.CalculateAbi;
import com.facebook.buck.jvm.java.JavacOptions;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.Flavor;
import com.facebook.buck.model.ImmutableFlavor;
import com.facebook.buck.parser.NoSuchBuildTargetException;
import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildRuleResolver;
import com.facebook.buck.rules.BuildTargetSourcePath;
import com.facebook.buck.rules.SourcePathResolver;
import com.facebook.buck.util.DependencyMode;
import com.google.common.base.Preconditions;
import com.google.common.base.Suppliers;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import java.util.Optional;

public class AndroidLibraryGraphEnhancer {

  public static final Flavor DUMMY_R_DOT_JAVA_FLAVOR = ImmutableFlavor.of("dummy_r_dot_java");

  private final BuildTarget dummyRDotJavaBuildTarget;
  private final BuildRuleParams originalBuildRuleParams;
  private final JavacOptions javacOptions;
  private final DependencyMode resourceDependencyMode;
  private final boolean forceFinalResourceIds;
  private final Optional<String> resourceUnionPackage;
  private final Optional<String> finalRName;

  public AndroidLibraryGraphEnhancer(
      BuildTarget buildTarget,
      BuildRuleParams buildRuleParams,
      JavacOptions javacOptions,
      DependencyMode resourceDependencyMode,
      boolean forceFinalResourceIds,
      Optional<String> resourceUnionPackage,
      Optional<String> finalRName) {
    this.dummyRDotJavaBuildTarget = getDummyRDotJavaTarget(buildTarget);
    this.originalBuildRuleParams = buildRuleParams;
    // Override javacoptions because DummyRDotJava doesn't require annotation processing.
    this.javacOptions = JavacOptions.builder(javacOptions)
        .setAnnotationProcessingParams(AnnotationProcessingParams.EMPTY)
        .build();
    this.resourceDependencyMode = resourceDependencyMode;
    this.forceFinalResourceIds = forceFinalResourceIds;
    this.resourceUnionPackage = resourceUnionPackage;
    this.finalRName = finalRName;
  }

  public static BuildTarget getDummyRDotJavaTarget(BuildTarget buildTarget) {
    return BuildTarget.builder(buildTarget)
        .addFlavors(DUMMY_R_DOT_JAVA_FLAVOR)
        .build();
  }

  public Optional<DummyRDotJava> getBuildableForAndroidResources(
      BuildRuleResolver ruleResolver,
      boolean createBuildableIfEmptyDeps) {
    Preconditions.checkState(!dummyRDotJavaBuildTarget.getFlavors().contains(CalculateAbi.FLAVOR));
    Optional<BuildRule> previouslyCreated = ruleResolver.getRuleOptional(dummyRDotJavaBuildTarget);
    if (previouslyCreated.isPresent()) {
      return previouslyCreated.map(input -> (DummyRDotJava) input);
    }
    ImmutableSortedSet<BuildRule> originalDeps = originalBuildRuleParams.getDeps();
    ImmutableSet<HasAndroidResourceDeps> androidResourceDeps;

    switch (resourceDependencyMode) {
      case FIRST_ORDER:
        androidResourceDeps = FluentIterable.from(originalDeps)
            .filter(HasAndroidResourceDeps.class)
            .filter(input -> input.getRes() != null)
            .toSet();
        break;
      case TRANSITIVE:
        androidResourceDeps = UnsortedAndroidResourceDeps.createFrom(
            originalDeps,
            Optional.empty())
            .getResourceDeps();
        break;
      default:
        throw new IllegalStateException(
            "Invalid resource dependency mode: " + resourceDependencyMode);
    }

    if (androidResourceDeps.isEmpty() && !createBuildableIfEmptyDeps) {
      return Optional.empty();
    }

    SourcePathResolver pathResolver = new SourcePathResolver(ruleResolver);

    BuildRuleParams dummyRDotJavaParams = originalBuildRuleParams.copyWithChanges(
        dummyRDotJavaBuildTarget,
        // Add dependencies from `SourcePaths` in `JavacOptions`.
        Suppliers.ofInstance(
            ImmutableSortedSet.copyOf(
                pathResolver.filterBuildRuleInputs(javacOptions.getInputs(pathResolver)))),
        /* extraDeps */ Suppliers.ofInstance(ImmutableSortedSet.of()));

    BuildTarget abiJarTarget =
        dummyRDotJavaParams.getBuildTarget().withAppendedFlavors(CalculateAbi.FLAVOR);

    DummyRDotJava dummyRDotJava = new DummyRDotJava(
        dummyRDotJavaParams,
        pathResolver,
        androidResourceDeps,
        abiJarTarget,
        javacOptions,
        forceFinalResourceIds,
        resourceUnionPackage,
        finalRName);
    ruleResolver.addToIndex(dummyRDotJava);

    return Optional.of(dummyRDotJava);
  }

  public CalculateAbi getBuildableForAndroidResourcesAbi(
      BuildRuleResolver resolver,
      SourcePathResolver pathResolver) throws NoSuchBuildTargetException {
    Preconditions.checkState(dummyRDotJavaBuildTarget.getFlavors().contains(CalculateAbi.FLAVOR));
    BuildTarget resourcesTarget = dummyRDotJavaBuildTarget.withoutFlavors(CalculateAbi.FLAVOR);
    resolver.requireRule(resourcesTarget);
    return CalculateAbi.of(
        dummyRDotJavaBuildTarget,
        pathResolver,
        originalBuildRuleParams,
        new BuildTargetSourcePath(resourcesTarget));
  }
}
