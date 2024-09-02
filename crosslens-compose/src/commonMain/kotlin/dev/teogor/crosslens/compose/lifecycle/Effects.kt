/*
 * Copyright 2024 Teogor (Teodor Grigor)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.teogor.crosslens.compose.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffectResult
import androidx.compose.runtime.DisposableEffectScope
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember

/**
 * A Composable function that sets up a disposable effect while ignoring configuration changes.
 *
 * This variant uses a single key to determine when to recreate the effect.
 *
 * @param key1 The key to track changes for recreating the effect.
 * @param effect A lambda function defining the disposable effect to execute.
 */
@Composable
@NonRestartableComposable
public fun DisposableEffectIgnoringConfiguration(
  key1: Any?,
  effect: DisposableEffectScope.() -> DisposableEffectResult
) {
  val configurationChecker = getConfigurationStateMonitor()
  remember(configurationChecker, key1) {
    DisposableEffectIgnoringConfigurationImpl(
      configurationChecker,
      effect
    )
  }
}

/**
 * A Composable function that sets up a disposable effect while ignoring configuration changes.
 *
 * This variant uses two keys to track changes and determine when to recreate the effect.
 *
 * @param key1 The first key to track changes for recreating the effect.
 * @param key2 The second key to track changes for recreating the effect.
 * @param effect A lambda function defining the disposable effect to execute.
 */
@Composable
@NonRestartableComposable
public fun DisposableEffectIgnoringConfiguration(
  key1: Any?,
  key2: Any?,
  effect: DisposableEffectScope.() -> DisposableEffectResult
) {
  val configurationChecker = getConfigurationStateMonitor()
  remember(configurationChecker, key1, key2) {
    DisposableEffectIgnoringConfigurationImpl(configurationChecker, effect)
  }
}

/**
 * A Composable function that sets up a disposable effect while ignoring configuration changes.
 *
 * This variant uses three keys to track changes and determine when to recreate the effect.
 *
 * @param key1 The first key to track changes for recreating the effect.
 * @param key2 The second key to track changes for recreating the effect.
 * @param key3 The third key to track changes for recreating the effect.
 * @param effect A lambda function defining the disposable effect to execute.
 */
@Composable
@NonRestartableComposable
public fun DisposableEffectIgnoringConfiguration(
  key1: Any?,
  key2: Any?,
  key3: Any?,
  effect: DisposableEffectScope.() -> DisposableEffectResult
) {
  val configurationChecker = getConfigurationStateMonitor()
  remember(configurationChecker, key1, key2, key3) {
    DisposableEffectIgnoringConfigurationImpl(configurationChecker, effect)
  }
}

/**
 * A Composable function that sets up a disposable effect while ignoring configuration changes.
 *
 * This variant accepts a variable number of keys to track changes and determine when to recreate the effect.
 *
 * @param keys A variable number of keys to track changes for recreating the effect.
 * @param effect A lambda function defining the disposable effect to execute.
 */
@Composable
@NonRestartableComposable
@Suppress("ArrayReturn")
public fun DisposableEffectIgnoringConfiguration(
  vararg keys: Any?,
  effect: DisposableEffectScope.() -> DisposableEffectResult
) {
  val configurationChecker = getConfigurationStateMonitor()
  remember(configurationChecker, *keys) {
    DisposableEffectIgnoringConfigurationImpl(
      configurationChecker,
      effect
    )
  }
}

/**
 * A placeholder [DisposableEffectScope] used internally for managing disposables.
 */
private class DisposableEffectIgnoringConfigurationImpl(
  private val configurationChecker: ConfigurationStateMonitor,
  private val effect: DisposableEffectScope.() -> DisposableEffectResult
) : RememberObserver {
  private var onDispose: DisposableEffectResult? = null

  override fun onRemembered() {
    onDispose = InternalDisposableEffectScope.effect()
  }

  override fun onForgotten() {
    onDispose?.takeUnless { configurationChecker.isChanging() }?.dispose()
    onDispose = null
  }

  override fun onAbandoned() {
    // Nothing to do as [onRemembered] was not called.
  }
}

private val InternalDisposableEffectScope = DisposableEffectScope()
