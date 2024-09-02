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

package dev.teogor.crosslens.core.concurrent

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject
import kotlinx.coroutines.internal.synchronized

/**
 * A thread-safe implementation of a mutable set. This class provides synchronization
 * to ensure that all operations on the set are thread-safe.
 *
 * This class uses an internal lock (`SynchronizedObject`) to synchronize access to the
 * underlying mutable set (`delegate`). All methods are synchronized to prevent concurrent
 * modification issues.
 *
 * @param E The type of elements contained in the set.
 */
@OptIn(InternalCoroutinesApi::class)
public class SynchronizedSet<E> : MutableSet<E> {
  private val delegate = mutableSetOf<E>()
  private val lock: SynchronizedObject = SynchronizedObject()

  /**
   * Returns the number of elements in the set.
   * This operation is synchronized.
   */
  override val size: Int
    get() = synchronized(lock) { delegate.size }

  /**
   * Returns `true` if the set contains the specified element.
   * This operation is synchronized.
   *
   * @param element The element whose presence in the set is to be tested.
   */
  override fun contains(element: E): Boolean =
    synchronized(lock) { delegate.contains(element) }

  /**
   * Returns `true` if the set contains all elements in the specified collection.
   * This operation is synchronized.
   *
   * @param elements The collection whose elements are to be checked for containment in the set.
   */
  override fun containsAll(elements: Collection<E>): Boolean =
    synchronized(lock) { delegate.containsAll(elements) }

  /**
   * Returns `true` if the set is empty.
   * This operation is synchronized.
   */
  override fun isEmpty(): Boolean =
    synchronized(lock) { delegate.isEmpty() }

  /**
   * Adds the specified element to the set if it is not already present.
   * This operation is synchronized.
   *
   * @param element The element to be added to the set.
   * @return `true` if the set did not already contain the specified element.
   */
  override fun add(element: E): Boolean =
    synchronized(lock) { delegate.add(element) }

  /**
   * Adds all elements in the specified collection to the set.
   * This operation is synchronized.
   *
   * @param elements The collection containing elements to be added to the set.
   * @return `true` if the set was modified as a result of the call.
   */
  override fun addAll(elements: Collection<E>): Boolean =
    synchronized(lock) { delegate.addAll(elements) }

  /**
   * Removes all elements from the set.
   * This operation is synchronized.
   */
  override fun clear(): Unit =
    synchronized(lock) { delegate.clear() }

  /**
   * Returns an iterator over the elements in the set.
   * This operation is synchronized.
   */
  override fun iterator(): MutableIterator<E> =
    synchronized(lock) { delegate.toMutableSet().iterator() }

  /**
   * Removes the specified element from the set if it is present.
   * This operation is synchronized.
   *
   * @param element The element to be removed from the set.
   * @return `true` if the set contained the specified element.
   */
  override fun remove(element: E): Boolean =
    synchronized(lock) { delegate.remove(element) }

  /**
   * Removes all elements in the specified collection from the set.
   * This operation is synchronized.
   *
   * @param elements The collection containing elements to be removed from the set.
   * @return `true` if the set was modified as a result of the call.
   */
  override fun removeAll(elements: Collection<E>): Boolean =
    synchronized(lock) { delegate.removeAll(elements.toSet()) }

  /**
   * Retains only the elements in the set that are contained in the specified collection.
   * This operation is synchronized.
   *
   * @param elements The collection containing elements to be retained in the set.
   * @return `true` if the set was modified as a result of the call.
   */
  override fun retainAll(elements: Collection<E>): Boolean =
    synchronized(lock) { delegate.retainAll(elements.toSet()) }

  /**
   * Creates a shallow copy of the current `SynchronizedSet`.
   *
   * This method returns a new `SynchronizedSet` instance containing the same elements as the original set.
   * The new set is initialized with a copy of the elements of the original set, but it operates independently.
   *
   * The copy operation is thread-safe and ensures that the new set will have the same elements as the original set
   * at the time of copying, but subsequent modifications to the original set will not affect the copied set.
   *
   * @return A new `SynchronizedSet` instance containing the same elements as the original set.
   */
  public fun copy(): SynchronizedSet<E> {
    val newSet = SynchronizedSet<E>()
    synchronized(lock) {
      newSet.delegate.addAll(this.delegate)
    }
    return newSet
  }
}
