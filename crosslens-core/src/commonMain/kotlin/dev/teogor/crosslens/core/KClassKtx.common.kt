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

import kotlin.reflect.KClass

/**
 * Defines the various formats for class name representation.
 */
public enum class NameFormat {
  /**
   * Fully qualified name of the class, including the package.
   */
  QUALIFIED,

  /**
   * Simple name of the class, without the package.
   */
  SIMPLE,

  /**
   * A platform-specific name format. This can be used to implement custom naming
   * conventions that may vary by platform or environment.
   */
  MULTIPLATFORM
}

/**
 * Provides the class name in a specified format. The [format] parameter allows for different
 * naming conventions, including fully qualified names, simple names, and platform-specific
 * formats.
 *
 * @param format Specifies the format for the class name. Defaults to [NameFormat.QUALIFIED].
 * @return The class name as a [String] in the specified format, or `null` if the name cannot
 * be determined.
 */
public expect fun KClass<*>.getFormattedName(format: NameFormat = NameFormat.QUALIFIED): String?

/**
 * Extension property that provides the platform-specific name for the class.
 *
 * This property retrieves the class name in a format that is tailored to be
 * appropriate for the current platform or environment. It is a shorthand for
 * calling [getFormattedName] with the [NameFormat.MULTIPLATFORM] format.
 *
 * The `MULTIPLATFORM` format is intended to support naming conventions that may vary
 * depending on the platform or use case. This can be useful when different platforms
 * require different representations of class names for various reasons, such as logging,
 * serialization, or platform-specific APIs.
 *
 * @return The platform-specific name of the class as a [String], or `null` if the name
 * cannot be determined or is not applicable in the current context.
 *
 * @see getFormattedName
 * @see NameFormat.MULTIPLATFORM
 */
public val KClass<*>.multiplatformName: String?
  get() = getFormattedName(NameFormat.MULTIPLATFORM)
