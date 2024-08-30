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

package dev.teogor.crosslens.core.startup

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import dev.teogor.crosslens.core.binder.ActivityBinder

/**
 * An [Initializer] for setting up the activity binder.
 *
 * This class is used with AndroidX Startup to ensure the activity binder is initialized
 * before other components that might rely on it.
 *
 * @see ActivityBinder
 */
public class ActivityInitializer : Initializer<Unit> {

  /**
   * Initializes the activity binder.
   *
   * This method ensures that [ActivityBinder] is part of the application startup
   * process, even though [ActivityBinder] is initialized in the [Application] class.
   *
   * @param context The application context.
   */
  override fun create(context: Context) {
    val application = context.applicationContext as Application
    application.registerActivityLifecycleCallbacks(ActivityBinder)
  }

  /**
   * Specifies that this initializer has no dependencies.
   *
   * @return An empty list, indicating this initializer does not depend on any other initializers.
   */
  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
