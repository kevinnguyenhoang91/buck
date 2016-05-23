/*
 * Copyright 2015-present Facebook, Inc.
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

package com.facebook.buck.intellij.plugin.actions;

import com.facebook.buck.intellij.plugin.build.BuckBuildCommandHandler;
import com.facebook.buck.intellij.plugin.build.BuckBuildManager;
import com.facebook.buck.intellij.plugin.build.BuckCommand;
import com.facebook.buck.intellij.plugin.config.BuckModule;
import com.facebook.buck.intellij.plugin.ui.BuckEventsConsumer;
import com.intellij.openapi.actionSystem.AnActionEvent;

import icons.BuckIcons;

/**
 * Run buck test command.
 */
public class BuckTestAction extends BuckBaseAction {

  public static final String ACTION_TITLE = "Run buck test";
  public static final String ACTION_DESCRIPTION = "Run buck test command";

  public BuckTestAction() {
    super(ACTION_TITLE, ACTION_DESCRIPTION, BuckIcons.ACTION_TEST);
  }

  @Override
  public void actionPerformed(AnActionEvent e) {
    BuckBuildManager buildManager = BuckBuildManager.getInstance(e.getProject());

    String target = buildManager.getCurrentSavedTarget(e.getProject());
    if (target == null) {
      buildManager.showNoTargetMessage(e.getProject());
      return;
    }

    // Initiate a buck test
    BuckEventsConsumer buckEventsConsumer = new BuckEventsConsumer(e.getProject());
    BuckModule buckModule = e.getProject().getComponent(BuckModule.class);
    buckModule.attach(buckEventsConsumer, target);

    BuckBuildCommandHandler handler = new BuckBuildCommandHandler(
        e.getProject(),
        e.getProject().getBaseDir(),
        BuckCommand.TEST,
        buckEventsConsumer);
    handler.command().addParameter(target);
    buildManager.runBuckCommandWhileConnectedToBuck(handler, ACTION_TITLE, buckModule);
  }
}
