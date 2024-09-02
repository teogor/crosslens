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
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerToolOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
  alias(libs.plugins.jetbrains.kotlin.multiplatform)
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.compose)
  alias(libs.plugins.jetbrains.compose.compiler)
  alias(libs.plugins.teogor.winds)
}

winds {
  moduleMetadata {
    artifactDescriptor {
      name = "UI"
    }
  }
}

kotlin {
  explicitApi()

  applyDefaultHierarchyTemplate()

  jvm {
    kotlin {
      jvmToolchain(11)
    }
  }

  js(IR) {
    browser()
    nodejs()
  }

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
    nodejs()
    binaries.executable()
  }

  androidTarget {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_11)
    }
  }

  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach { target ->
    target.binaries.framework {
      baseName = "crosslens-ui"
    }
  }

  macosX64()
  macosArm64()

  sourceSets {
    commonMain.dependencies {
      implementation(compose.runtime)
      implementation(compose.ui)

      implementation(libs.kotlinx.coroutines.core)
    }
  }
}

android {
  namespace = "dev.teogor.crosslens.ui"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlin {
    jvmToolchain(11)
  }
}

tasks.withType<KotlinJvmCompile>().configureEach {
  compilerOptions {
    jvmTarget.set(JvmTarget.JVM_11)
  }
}
