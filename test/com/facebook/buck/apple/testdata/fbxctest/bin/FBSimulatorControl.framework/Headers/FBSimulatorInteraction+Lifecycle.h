/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

#import <Foundation/Foundation.h>

#import <FBSimulatorControl/FBSimulatorInteraction.h>

NS_ASSUME_NONNULL_BEGIN

@class FBSimulatorBootConfiguration;

/**
 Interactions for the Lifecycle of the Simulator.
 */
@interface FBSimulatorInteraction (Lifecycle)

/**
 Boots the Simulator with the default Simulator Launch Configuration.\
 Will fail if the Simulator is currently booted.

 @return the reciever, for chaining.
 */
- (instancetype)bootSimulator;

/**
 Boots the Simulator with the default Simulator Launch Configuration.
 Will fail if the Simulator is currently booted.

 @return the reciever, for chaining.
 */
- (instancetype)bootSimulator:(FBSimulatorBootConfiguration *)configuration;

/**
 Shuts the Simulator down.
 Will fail if the Simulator is not booted.

 @return the reciever, for chaining.
 */
- (instancetype)shutdownSimulator;

/**
 Opens the provided URL on the Simulator.

 @param url the URL to open.
 @return the reciever, for chaining.
 */
- (instancetype)openURL:(NSURL *)url;

/**
 Terminates a Subprocess of the Simulator.

 @param process the process to terminate.
 @return the reciever, for chaining.
 */
- (instancetype)terminateSubprocess:(FBProcessInfo *)process;

@end

NS_ASSUME_NONNULL_END
