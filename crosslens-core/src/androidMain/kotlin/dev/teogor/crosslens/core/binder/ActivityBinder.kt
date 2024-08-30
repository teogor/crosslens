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

import android.app.Activity
import android.app.Application
import android.os.Bundle
import dev.teogor.crosslens.core.binder.ActivityBinder.currentActivity
import java.lang.ref.WeakReference

/**
 * A singleton object for managing and tracking the current activity context.
 *
 * This object provides a way to get the most recent activity context through
 * [currentActivity]. It uses [Application.ActivityLifecycleCallbacks] to keep track of
 * activity lifecycle events.
 */
internal object ActivityBinder : Application.ActivityLifecycleCallbacks {
  private var _currentActivity: WeakReference<Activity>? = null

  /**
   * Gets the current activity context.
   *
   * @return The current activity context or null if no activity is currently active.
   */
  internal val currentActivity: Activity?
    get() = _currentActivity?.get()

  /**
   * Called when an activity is created.
   *
   * @param activity The activity that was created.
   * @param savedInstanceState The saved instance state of the activity.
   */
  override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?): Unit = Unit

  /**
   * Called when an activity is started.
   *
   * @param activity The activity that was started.
   */
  override fun onActivityStarted(activity: Activity): Unit = Unit

  /**
   * Called when an activity is resumed.
   *
   * @param activity The activity that was resumed.
   */
  override fun onActivityResumed(activity: Activity) {
    _currentActivity = WeakReference(activity)
  }

  /**
   * Called when an activity is paused.
   *
   * @param activity The activity that was paused.
   */
  override fun onActivityPaused(activity: Activity) {
    if (_currentActivity?.get() === activity) {
      _currentActivity = null
    }
  }

  /**
   * Called when an activity is stopped.
   *
   * @param activity The activity that was stopped.
   */
  override fun onActivityStopped(activity: Activity): Unit = Unit

  /**
   * Called when an activity is saved.
   *
   * @param activity The activity that was saved.
   * @param outState The bundle to save the activity's state.
   */
  override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle): Unit = Unit

  /**
   * Called when an activity is destroyed.
   *
   * @param activity The activity that was destroyed.
   */
  override fun onActivityDestroyed(activity: Activity): Unit = Unit
}
