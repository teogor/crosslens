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

package dev.teogor.crosslens.core.binder

import android.content.Context
import java.lang.ref.WeakReference

/**
 * A singleton object for managing and providing the global application context.
 *
 * This object maintains a weak reference to the application context to avoid memory leaks.
 * It provides a way to access the global context from anywhere in the app.
 */
internal object ContextBinder {
  private lateinit var _applicationContext: WeakReference<Context>

  /**
   * Initializes the global context.
   *
   * @param context The application context to be set as the global context.
   * It is recommended to call this method early in the application lifecycle,
   * such as in the `Application` class or using AndroidX Startup.
   */
  internal fun setApplicationContext(context: Context) {
    _applicationContext = WeakReference(context.applicationContext)
  }

  /**
   * Retrieves the global application context.
   *
   * @return The global application context.
   * @throws IllegalStateException If the application context has not been initialized or has been cleared.
   */
  internal val applicationContext: Context
    get() {
      if (!ContextBinder::_applicationContext.isInitialized) {
        throw IllegalStateException(
          "Application context has not been initialized."
        )
      }

      return _applicationContext.get() ?: throw IllegalStateException(
        "Application context has been cleared."
      )
    }
}
