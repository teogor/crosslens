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
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class SynchronizedSetTest {

  @Test
  fun testInitialSize() {
    val set = SynchronizedSet<String>()
    assertEquals(0, set.size, "Initial size should be 0")
  }

  @Test
  fun testAddElement() {
    val set = SynchronizedSet<String>()
    assertTrue(set.add("element"), "Element should be added successfully")
    assertEquals(1, set.size, "Size should be 1 after adding an element")
  }

  @Test
  fun testContainsElement() {
    val set = SynchronizedSet<String>()
    set.add("element")
    assertTrue(set.contains("element"), "Set should contain the added element")
    assertFalse(set.contains("nonexistent"), "Set should not contain a non-existent element")
  }

  @Test
  fun testRemoveElement() {
    val set = SynchronizedSet<String>()
    set.add("element")
    assertTrue(set.remove("element"), "Element should be removed successfully")
    assertFalse(set.contains("element"), "Set should not contain the removed element")
  }

  @Test
  fun testClear() {
    val set = SynchronizedSet<String>()
    set.add("element")
    set.clear()
    assertEquals(0, set.size, "Size should be 0 after clearing the set")
    assertFalse(set.contains("element"), "Set should not contain any elements after clearing")
  }

  @Test
  fun testAddAll() {
    val set = SynchronizedSet<String>()
    val elements = setOf("a", "b", "c")
    assertTrue(set.addAll(elements), "All elements should be added successfully")
    assertTrue(set.containsAll(elements), "Set should contain all added elements")
  }

  @Test
  fun testRemoveAll() {
    val set = SynchronizedSet<String>()
    val elements = setOf("a", "b", "c")
    set.addAll(elements)
    assertTrue(set.removeAll(elements), "All elements should be removed successfully")
    assertFalse(set.containsAll(elements), "Set should not contain removed elements")
  }

  @Test
  fun testIterator() {
    val set = SynchronizedSet<String>()
    set.add("a")
    set.add("b")
    val iterator = set.iterator()
    assertTrue(iterator.hasNext(), "Iterator should have elements")
    assertEquals("a", iterator.next(), "Iterator should return the first element")
    assertTrue(iterator.hasNext(), "Iterator should have more elements")
    assertEquals("b", iterator.next(), "Iterator should return the second element")
    assertFalse(iterator.hasNext(), "Iterator should have no more elements")
  }

  @Test
  fun testSetCopy() {
    val set = SynchronizedSet<String>()
    set.add("element")
    val copiedSet = set.copy()
    assertTrue(copiedSet.contains("element"), "Copied set should contain the original elements")
    assertEquals(1, copiedSet.size, "Copied set should have the same size as the original set")
  }

}
