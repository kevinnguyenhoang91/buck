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
import com.facebook.buck.intellij.plugin.config.BuckSettingsProvider;
import com.facebook.buck.intellij.plugin.ui.BuckEventsConsumer;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;

import icons.BuckIcons;

/**
 * Run buck install command.
 */
public class BuckInstallAction extends BuckBaseAction {

  public static final String ACTION_TITLE = "Run buck install";
  public static final String ACTION_DESCRIPTION = "Run buck install command";
  public static final Icon ICON = BuckIcons.ACTION_INSTALL;

  public BuckInstallAction() {
    this(ACTION_TITLE, ACTION_DESCRIPTION, ICON);
  }

  public BuckInstallAction(String actionTitle, String actionDescription, Icon icon) {
    super(actionTitle, actionDescription, icon);
  }

  @Override
  public void actionPerformed(AnActionEvent e) {
    BuckBuildManager buildManager = BuckBuildManager.getInstance(e.getProject());
    String target = buildManager.getCurrentSavedTarget(e.getProject());
    if (target == null) {
      buildManager.showNoTargetMessage(e.getProject());
      return;
    }

    BuckSettingsProvider.State state = BuckSettingsProvider.getInstance().getState();
    if (state == null) {
      return;
    }

    // Initiate a buck install
    BuckEventsConsumer buckEventsConsumer = new BuckEventsConsumer(e.getProject());
    BuckModule buckModule = e.getProject().getComponent(BuckModule.class);
    buckModule.attach(buckEventsConsumer, target);

    BuckBuildCommandHandler handler = new BuckBuildCommandHandler(
        e.getProject(),
        e.getProject().getBaseDir(),
        BuckCommand.INSTALL,
        buckEventsConsumer);
    if (state.customizedInstallSetting) {
      // Split the whole command line into different parameters.
      String commands = state.customizedInstallSettingCommand;
      Matcher matcher = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(commands);
      while (matcher.find()) {
        handler.command().addParameter(matcher.group(1));
      }
    } else {
      if (state.runAfterInstall) {
        handler.command().addParameter("-r");
      }
      if (state.multiInstallMode) {
        handler.command().addParameter("-x");
      }
      if (state.uninstallBeforeInstalling) {
        handler.command().addParameter("-u");
      }
    }
    handler.command().addParameter(target);
    buildManager.runBuckCommandWhileConnectedToBuck(handler, ACTION_TITLE, buckModule);
  }
}
