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
 * A thread-safe implementation of a mutable map. This class provides synchronization
 * to ensure that all operations on the map are thread-safe.
 *
 * This class uses an internal lock (`SynchronizedObject`) to synchronize access to the
 * underlying mutable map (`delegate`). All methods are synchronized to prevent concurrent
 * modification issues.
 *
 * @param K The type of keys maintained by the map.
 * @param V The type of values associated with the keys.
 */
@OptIn(InternalCoroutinesApi::class)
public class SynchronizedMap<K, V> : MutableMap<K, V> {
  private val delegate = mutableMapOf<K, V>()
  private val lock: SynchronizedObject = SynchronizedObject()

  /**
   * Returns the number of key-value pairs in the map.
   * This operation is synchronized.
   */
  override val size: Int
    get() = synchronized(lock) { delegate.size }

  /**
   * Returns `true` if the map is empty.
   * This operation is synchronized.
   */
  override fun isEmpty(): Boolean =
    synchronized(lock) { delegate.isEmpty() }

  /**
   * Returns `true` if the map contains the specified key.
   * This operation is synchronized.
   *
   * @param key The key whose presence in the map is to be tested.
   */
  override fun containsKey(key: K): Boolean =
    synchronized(lock) { delegate.containsKey(key) }

  /**
   * Returns `true` if the map contains the specified value.
   * This operation is synchronized.
   *
   * @param value The value whose presence in the map is to be tested.
   */
  override fun containsValue(value: V): Boolean =
    synchronized(lock) { delegate.containsValue(value) }

  /**
   * Returns the value associated with the specified key, or `null` if the map contains no mapping for the key.
   * This operation is synchronized.
   *
   * @param key The key whose associated value is to be returned.
   */
  override fun get(key: K): V? =
    synchronized(lock) { delegate[key] }

  /**
   * Returns a set of key-value pairs contained in the map.
   * This operation is synchronized.
   */
  override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
    get() = synchronized(lock) { delegate.entries }

  /**
   * Returns a set of keys contained in the map.
   * This operation is synchronized.
   */
  override val keys: MutableSet<K>
    get() = synchronized(lock) { delegate.keys }

  /**
   * Returns a collection of values contained in the map.
   * This operation is synchronized.
   */
  override val values: MutableCollection<V>
    get() = synchronized(lock) { delegate.values }

  /**
   * Removes all mappings from the map.
   * This operation is synchronized.
   */
  override fun clear(): Unit =
    synchronized(lock) { delegate.clear() }

  /**
   * Associates the specified value with the specified key in the map.
   * This operation is synchronized.
   *
   * @param key The key with which the specified value is to be associated.
   * @param value The value to be associated with the specified key.
   * @return The previous value associated with the key, or `null` if there was no mapping for the key.
   */
  override fun put(key: K, value: V): V? =
    synchronized(lock) { delegate.put(key, value) }

  /**
   * Copies all of the mappings from the specified map to this map.
   * This operation is synchronized.
   *
   * @param from The map whose mappings are to be copied to this map.
   */
  override fun putAll(from: Map<out K, V>): Unit =
    synchronized(lock) { delegate.putAll(from) }

  /**
   * Removes the mapping for the specified key from the map if present.
   * This operation is synchronized.
   *
   * @param key The key whose mapping is to be removed from the map.
   * @return The previous value associated with the key, or `null` if there was no mapping for the key.
   */
  override fun remove(key: K): V? =
    synchronized(lock) { delegate.remove(key) }

  /**
   * Creates a shallow copy of the current `SynchronizedMap`.
   *
   * This method returns a new `SynchronizedMap` instance containing the same key-value pairs as the original map.
   * The new map is initialized with a copy of the entries of the original map, but it operates independently.
   *
   * The copy operation is thread-safe and ensures that the new map will have the same entries as the original map
   * at the time of copying, but subsequent modifications to the original map will not affect the copied map.
   *
   * @return A new `SynchronizedMap` instance containing the same key-value pairs as the original map.
   */
  public fun copy(): SynchronizedMap<K, V> {
    val newMap = SynchronizedMap<K, V>()
    synchronized(lock) {
      newMap.delegate.putAll(this.delegate)
    }
    return newMap
  }
}
