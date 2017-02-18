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

package com.facebook.buck.jvm.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.facebook.buck.model.BuildTargetFactory;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildRuleResolver;
import com.facebook.buck.rules.DefaultTargetNodeToBuildRuleTransformer;
import com.facebook.buck.rules.FakeBuildRuleParamsBuilder;
import com.facebook.buck.rules.FakeSourcePath;
import com.facebook.buck.rules.SourcePathResolver;
import com.facebook.buck.rules.SourcePathRuleFinder;
import com.facebook.buck.rules.TargetGraph;
import com.facebook.buck.testutil.FakeProjectFilesystem;
import com.facebook.buck.testutil.integration.TemporaryPaths;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

public class PrebuiltJarTest {

  @Rule
  public TemporaryPaths temp = new TemporaryPaths();

  private PrebuiltJar junitJarRule;
  private FakeProjectFilesystem filesystem;


  @Before
  public void setUp() throws IOException {
    filesystem = new FakeProjectFilesystem(temp.newFolder());

    BuildRuleParams buildRuleParams =
        new FakeBuildRuleParamsBuilder(BuildTargetFactory.newInstance("//lib:junit"))
            .setProjectFilesystem(filesystem)
            .build();

    junitJarRule = new PrebuiltJar(
        buildRuleParams,
        new SourcePathResolver(new SourcePathRuleFinder(
            new BuildRuleResolver(
              TargetGraph.EMPTY,
              new DefaultTargetNodeToBuildRuleTransformer())
        )),
        new FakeSourcePath("abi.jar"),
        Optional.of(new FakeSourcePath("lib/junit-4.11-sources.jar")),
        /* gwtJar */ Optional.empty(),
        Optional.of("http://junit-team.github.io/junit/javadoc/latest/"),
        /* mavenCoords */ Optional.empty(),
        /* provided */ false);
  }

  @Test
  public void testGetJavaSrcsIsEmpty() {
    assertTrue(junitJarRule.getJavaSrcs().isEmpty());
  }

  @Test
  public void testGetAnnotationProcessingDataIsEmpty() {
    assertFalse(junitJarRule.getGeneratedSourcePath().isPresent());
  }
}
