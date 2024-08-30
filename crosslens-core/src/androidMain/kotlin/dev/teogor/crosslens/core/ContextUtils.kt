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

package dev.teogor.crosslens.core

import android.app.Activity
import android.content.Context
import dev.teogor.crosslens.core.binder.ActivityBinder
import dev.teogor.crosslens.core.binder.ContextBinder

/**
 * Retrieves the current [Activity] context.
 *
 * @return The current activity context if available, otherwise null.
 *
 * @see ActivityBinder.currentActivity
 * @see currentActivity
 */
public val currentActivity: Activity?
  get() = ActivityBinder.currentActivity

/**
 * Retrieves the global [Context].
 *
 * @return The global application context.
 * @throws IllegalStateException if the application context is not initialized.
 *
 * @see ContextBinder.setApplicationContext
 * @see ContextBinder.applicationContext
 * @see currentActivity
 */
public val applicationContext: Context
  get() = ContextBinder.applicationContext
