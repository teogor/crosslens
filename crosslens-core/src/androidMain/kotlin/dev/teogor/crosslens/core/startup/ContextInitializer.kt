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

import android.content.Context
import androidx.startup.Initializer
import dev.teogor.crosslens.core.binder.ContextBinder


/**
 * An [Initializer] for setting up the global application context.
 *
 * This class is used with AndroidX Startup to ensure the application context is initialized
 * before other components that might rely on it.
 *
 * @see ContextBinder
 * @see ContextBinder.context
 */
public class ContextInitializer : Initializer<Unit> {
  /**
   * Initializes the global application context.
   *
   * This method sets the global context using [ContextBinder].
   *
   * @param context The application context that will be set globally.
   */
  override fun create(context: Context) {
    ContextBinder.setApplicationContext(context)
  }

  /**
   * Specifies that this initializer has no dependencies.
   *
   * @return An empty list, indicating this initializer does not depend on any other initializers.
   */
  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
