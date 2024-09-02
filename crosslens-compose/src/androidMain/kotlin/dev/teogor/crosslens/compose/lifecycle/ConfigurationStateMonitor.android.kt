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

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

private tailrec fun Context.getActivity(): Activity? = when (this) {
  is Activity -> this
  is ContextWrapper -> baseContext.getActivity()
  else -> null
}

/**
 * Retrieves the [ConfigurationStateMonitor] instance for checking configuration changes.
 *
 * @return An instance of [ConfigurationStateMonitor].
 */
@Composable
@NonRestartableComposable
public actual fun getConfigurationStateMonitor(): ConfigurationStateMonitor {
  val context = LocalContext.current
  return remember(context) { ConfigurationStateMonitor(context.getActivity()) }
}

/**
 * Monitors the state of configuration changes.
 *
 * This class provides functionality to determine if the application is currently
 * undergoing a configuration change, such as screen rotations or other system-level
 * changes that affect the application's state.
 */
@Stable
public actual class ConfigurationStateMonitor(
  private val activity: Activity?
) {
  /**
   * Checks if a configuration change is currently ongoing.
   *
   * @return `true` if a configuration change is in progress; `false` otherwise.
   */
  public actual fun isChanging(): Boolean {
    return activity?.isChangingConfigurations ?: false
  }

}