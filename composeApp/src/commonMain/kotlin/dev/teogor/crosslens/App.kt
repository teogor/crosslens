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

package dev.teogor.crosslens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.teogor.crosslens.core.buildHashCode
import dev.teogor.crosslens.ui.rememberVisibilityState
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val VERSION = "1.0.0-alpha01"
private val FEATURES = listOf(
  "Multi-Platform Support",
  "Seamless Integration",
  "Up-to-Date Insights"
)

@Composable
@Preview
public fun App() {
  val visibility by rememberVisibilityState(true)
  LaunchedEffect(Unit) {
    visibility.hide()
    visibility.show()
    visibility.toggle()
  }
  remember {
    buildHashCode {
      append(visibility.isVisible)
      append(visibility.scope)
    }.let {
      println("HashCode: $it")
    }
  }
  MaterialTheme {
    Surface(
      modifier = Modifier.fillMaxSize(),
    ) {
      Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Surface(
          modifier = Modifier.padding(16.dp),
          shape = MaterialTheme.shapes.large,
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            // Displaying CrossLens information
            Text(
              text = "\uD83D\uDD0D CrossLens delivers precise platform insights for Kotlin Multiplatform projects, enabling seamless adaptation across diverse environments.",
              style = MaterialTheme.typography.bodyLarge
            )
            Text(
              text = "Current Version: $VERSION",
              style = MaterialTheme.typography.bodyMedium
            )

            Text(
              text = "Features:",
              style = MaterialTheme.typography.titleSmall
            )
            FEATURES.forEach { feature ->
              Text("- $feature", style = MaterialTheme.typography.bodyMedium)
            }
          }
        }
      }
    }
  }
}
