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

package dev.teogor.crosslens.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Typealias for a provider function that creates a [VisibilityState.Factory] instance.
 *
 * @param T The type of [VisibilityState] to create.
 */
public typealias VisibilityStateFactoryProvider<T> = @DisallowComposableCalls () -> VisibilityState.Factory<T>

/**
 * Interface defining the contract for managing visibility state and behavior.
 *
 * Provides methods to control the visibility state:
 * - [show]: Sets the visibility to `true`.
 * - [hide]: Sets the visibility to `false`.
 * - [toggle]: Toggles the current visibility state.
 * - [isVisible]: Indicates whether the controlled entity is currently visible.
 */
public interface VisibilityState {

  /**
   * The [CoroutineScope] associated with this visibility state, used for launching coroutines.
   */
  public val scope: CoroutineScope

  /**
   * Indicates whether the controlled entity is currently visible.
   */
  public val isVisible: Boolean

  /**
   * Shows the controlled entity, setting its visibility to `true`.
   */
  public fun show()

  /**
   * Hides the controlled entity, setting its visibility to `false`.
   */
  public fun hide()

  /**
   * Toggles the visibility state of the controlled entity.
   * If currently visible, hides it; if hidden, shows it.
   */
  public fun toggle()

  /**
   * Factory interface for creating instances of [VisibilityState].
   */
  public interface Factory<T : VisibilityState> {
    /**
     * Creates a new instance of [VisibilityState] with the given initial state.
     *
     * @param initialState The initial visibility state of the controller.
     * @return A new instance of [VisibilityState] with the specified initial state.
     */
    public fun create(initialState: Boolean): T
  }
}

/**
 * Default implementation of [VisibilityState] that manages visibility state.
 *
 * Provides basic methods to control visibility: [show], [hide], and [toggle].
 *
 * @param initialState The initial visibility state. Defaults to `false`.
 */
private class VisibilityStateImpl(
  initialState: Boolean = false,
) : VisibilityState {
  private val _isVisible = mutableStateOf(initialState)
  override val isVisible: Boolean get() = _isVisible.value
  override val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

  override fun show() {
    _isVisible.value = true
  }

  override fun hide() {
    _isVisible.value = false
  }

  override fun toggle() {
    _isVisible.value = !_isVisible.value
  }
}

/**
 * Provides a [MutableState] of [VisibilityState] that is remembered across recompositions.
 *
 * This function creates and remembers a [VisibilityStateImpl] instance, which manages
 * the visibility state with the specified initial state.
 *
 * @param initialState The initial visibility state. Defaults to `false`.
 * @return A [MutableState] containing the remembered [VisibilityStateImpl] instance.
 */
@Composable
public fun rememberVisibilityState(
  initialState: Boolean = false
): MutableState<VisibilityState> {
  return remember {
    mutableStateOf(VisibilityStateImpl(initialState))
  }
}

/**
 * Provides a [MutableState] of [VisibilityState] using the provided [factory] to create it.
 *
 * This function is used to retain a mutable state of a [VisibilityState] within a Composable
 * function. The [factory] is responsible for creating instances of [VisibilityState],
 * allowing flexibility in how different types of visibility states are instantiated and managed.
 *
 * @param initialState The initial visibility state for the state.
 * @param factory A factory interface that creates instances of [VisibilityState].
 * @return A mutable state holding the instance of [VisibilityState].
 */
@Composable
public inline fun <reified T : VisibilityState> rememberVisibilityState(
  initialState: Boolean = false,
  factory: VisibilityState.Factory<T>
): MutableState<T> {
  return remember {
    mutableStateOf(factory.create(initialState))
  }
}

/**
 * Provides a [MutableState] of [VisibilityState] using a factory provider function to create it.
 *
 * This function retains a mutable state of a [VisibilityState] within a Composable function.
 * The [factoryProvider] function is used to create instances of [VisibilityState.Factory],
 * allowing for flexible instantiation.
 *
 * @param initialState The initial visibility state for the state.
 * @param factoryProvider A function to provide the [VisibilityState.Factory] for creating instances of [VisibilityState].
 * @return A mutable state holding the instance of [VisibilityState].
 */
@Composable
public inline fun <reified T : VisibilityState> rememberVisibilityState(
  initialState: Boolean = false,
  crossinline factoryProvider: VisibilityStateFactoryProvider<T>
): MutableState<T> {
  return remember {
    mutableStateOf(factoryProvider().create(initialState))
  }
}

/**
 * Configures a [MutableState] of type [VisibilityState] with a configuration block.
 *
 * Applies the provided configuration block to the [VisibilityState] instance,
 * ensuring that it is applied on recomposition.
 *
 * @param block The configuration block to apply to the [VisibilityState] instance.
 * @return The same [MutableState] with the applied configuration.
 */
@OptIn(ExperimentalContracts::class)
@Composable
public inline fun <reified T : VisibilityState> MutableState<T>.withConfiguration(
  noinline block: @DisallowComposableCalls T.() -> Unit,
): MutableState<T> {
  contract {
    returns() implies (this@withConfiguration is T)
  }

  // Remember the latest block to apply
  val updatedBlock by rememberUpdatedState(block)

  // Apply the configuration to the state
  LaunchedEffect(updatedBlock) {
    value.updatedBlock()
  }

  return this
}
