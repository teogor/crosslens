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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SynchronizedMapTest {

  @Test
  fun testInitialSize() {
    val map = SynchronizedMap<String, Int>()
    assertEquals(0, map.size, "Initial size should be 0")
  }

  @Test
  fun testPutElement() {
    val map = SynchronizedMap<String, Int>()
    assertEquals(null, map.put("key", 1), "Put should return null if no previous value")
    assertEquals(1, map.size, "Size should be 1 after adding an element")
    assertEquals(1, map["key"], "Map should return the correct value for the key")
  }

  @Test
  fun testContainsKey() {
    val map = SynchronizedMap<String, Int>()
    map["key"] = 1
    assertTrue(map.containsKey("key"), "Map should contain the key")
    assertFalse(map.containsKey("nonexistent"), "Map should not contain a non-existent key")
  }

  @Test
  fun testContainsValue() {
    val map = SynchronizedMap<String, Int>()
    map["key"] = 1
    assertTrue(map.containsValue(1), "Map should contain the value")
    assertFalse(map.containsValue(2), "Map should not contain a non-existent value")
  }

  @Test
  fun testRemove() {
    val map = SynchronizedMap<String, Int>()
    map["key"] = 1
    assertEquals(1, map.remove("key"), "Remove should return the removed value")
    assertFalse(map.containsKey("key"), "Map should not contain the removed key")
  }

  @Test
  fun testClear() {
    val map = SynchronizedMap<String, Int>()
    map["key"] = 1
    map.clear()
    assertEquals(0, map.size, "Size should be 0 after clearing the map")
    assertFalse(map.containsKey("key"), "Map should not contain any keys after clearing")
  }

  @Test
  fun testPutAll() {
    val map = SynchronizedMap<String, Int>()
    val entries = mapOf("a" to 1, "b" to 2, "c" to 3)
    map.putAll(entries)
    assertTrue(
      map.entries.containsAll(entries.entries),
      "Map should contain all entries after putAll"
    )
  }

  @Test
  fun testIterator() {
    val map = SynchronizedMap<String, Int>()
    map["a"] = 1
    map["b"] = 2
    val iterator = map.entries.iterator()
    assertTrue(iterator.hasNext(), "Iterator should have elements")
    val entry1 = iterator.next()
    assertEquals("a", entry1.key, "Iterator should return the correct key")
    assertEquals(1, entry1.value, "Iterator should return the correct value")
    assertTrue(iterator.hasNext(), "Iterator should have more elements")
    val entry2 = iterator.next()
    assertEquals("b", entry2.key, "Iterator should return the second key")
    assertEquals(2, entry2.value, "Iterator should return the second value")
    assertFalse(iterator.hasNext(), "Iterator should have no more elements")
  }

  @Test
  fun testMapCopy() {
    val map = SynchronizedMap<String, Int>()
    map["key"] = 1
    val copiedMap = map.copy()
    assertTrue(copiedMap.containsKey("key"), "Copied map should contain the original key")
    assertEquals(1, copiedMap["key"], "Copied map should return the same value for the original key")
    assertEquals(1, copiedMap.size, "Copied map should have the same size as the original map")
  }
}
