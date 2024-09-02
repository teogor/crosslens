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
 * Provides the class name in a specified format. The [format] parameter allows for different
 * naming conventions, including fully qualified names, simple names, and platform-specific
 * formats.
 *
 * @param format Specifies the format for the class name. Defaults to [NameFormat.QUALIFIED].
 * @return The class name as a [String] in the specified format, or `null` if the name cannot
 * be determined.
 */
public actual fun KClass<*>.getFormattedName(format: NameFormat): String? {
  return when (format) {
    NameFormat.QUALIFIED -> simpleName
    NameFormat.SIMPLE -> simpleName
    NameFormat.MULTIPLATFORM -> simpleName
  }
}
