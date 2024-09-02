# 🔍 CrossLens 🔍

## Overview

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/dev.teogor.crosslens/crosslens-core.svg?label=Maven%20Central)](https://central.sonatype.com/search?q=g%3Adev.teogor.crosslens+a%3Acrosslens-core&smo=true)
[![Profile](https://source.teogor.dev/badges/teogor-github.svg)](https://github.com/teogor)
[![Open-Source Directory](https://source.teogor.dev/badges/teogor-dev.svg)](https://source.teogor.dev)

🔍 **CrossLens** delivers precise platform insights for Kotlin Multiplatform projects, enabling seamless adaptation across diverse environments.

## Features
- **Multi-Platform Support:** Access detailed information about the platform your code runs on, across various environments.
- **Seamless Integration:** Integrate smoothly with your existing Kotlin Multiplatform projects.
- **Up-to-Date Insights:** Keep informed with the latest platform information for compatibility and optimal performance.

[//]: # (REGION-DEPENDENCIES)

## Getting Started with Crosslens

**Adding Dependencies:**

* **Manual Setup:**  This section guides you through adding Crosslens dependencies directly to your project's `build.gradle` files. ([Link to Manual Dependency Setup Section](#adding-crosslens-dependencies-manually))
* **Version Catalog (Recommended):** For a more streamlined approach, consider integrating a version catalog. This allows for centralized version management and easier updates. ([Link to Version Catalog Section](#managing-crosslens-versions-with-version-catalog-recommended))

**Note:** If you prefer manual dependency setup, follow the instructions in the "Manual Setup" section. Otherwise, jump to the "Version Catalog" section for centralized management.

For information on using the KAPT plugin, see the [KAPT documentation](https://kotlinlang.org/docs/kapt.html).  
For information on using the KSP plugin, see the [KSP quick-start documentation](https://kotlinlang.org/docs/ksp-quickstart.html).  
For more information about dependencies, see [Add Build Dependencies](https://developer.android.com/studio/build/dependencies).  

### Adding Crosslens Dependencies Manually

To use Crosslens in your app, add the following dependencies to your app's `build.gradle` file:

=== "Groovy"

    ```groovy title="build.gradle"
    dependencies {
        def teogorCrosslens = "1.0.0-alpha02"
        
        implementation "dev.teogor.crosslens:crosslens-compose:$teogorCrosslens"
        implementation "dev.teogor.crosslens:crosslens-core:$teogorCrosslens"
        implementation "dev.teogor.crosslens:crosslens-ui:$teogorCrosslens"
    }
    ```

=== "Kotlin"

    ```kotlin title="build.gradle.kts"
    dependencies {
        val teogorCrosslens = "1.0.0-alpha02"
        
        implementation("dev.teogor.crosslens:crosslens-compose:$teogorCrosslens")
        implementation("dev.teogor.crosslens:crosslens-core:$teogorCrosslens")
        implementation("dev.teogor.crosslens:crosslens-ui:$teogorCrosslens")
    }
    ```

### Managing Crosslens Versions with Version Catalog (Recommended)

This section guides you through utilizing a version catalog for centralized management of Crosslens dependencies in your project. This approach simplifies updates and ensures consistency.

First, define the dependencies in the `libs.versions.toml` file:

- **Group-Name Based:** This approach is used for declaring libraries referenced by group and artifact name.
- **Module Based:** This approach is used for declaring libraries referenced by their module.

=== "Group-Name Based"

    ```toml title="gradle/libs.versions.toml"
    [versions]
    teogor-crosslens = "1.0.0-alpha02"
    
    [libraries]
    teogor-crosslens-compose = { group = "dev.teogor.crosslens", name = "crosslens-compose", version.ref = "teogor-crosslens" }
    teogor-crosslens-core = { group = "dev.teogor.crosslens", name = "crosslens-core", version.ref = "teogor-crosslens" }
    teogor-crosslens-ui = { group = "dev.teogor.crosslens", name = "crosslens-ui", version.ref = "teogor-crosslens" }
    ```

=== "Module Based"

    ```toml title="gradle/libs.versions.toml"
    [versions]
    teogor-crosslens = "1.0.0-alpha02"
    
    [libraries]
    teogor-crosslens-compose = { module = "dev.teogor.crosslens:crosslens-compose", version.ref = "teogor-crosslens" }
    teogor-crosslens-core = { module = "dev.teogor.crosslens:crosslens-core", version.ref = "teogor-crosslens" }
    teogor-crosslens-ui = { module = "dev.teogor.crosslens:crosslens-ui", version.ref = "teogor-crosslens" }
    ```

Then, add these dependencies in your app's `build.gradle` file:

=== "Groovy"

    ```groovy title="build.gradle"
    dependencies {
        implementation libs.teogor.crosslens.compose
        implementation libs.teogor.crosslens.core
        implementation libs.teogor.crosslens.ui
    }
    ```

=== "Kotlin"

    ```kotlin title="build.gradle.kts"
    dependencies {
        implementation(libs.teogor.crosslens.compose)
        implementation(libs.teogor.crosslens.core)
        implementation(libs.teogor.crosslens.ui)
    }
    ```

[//]: # (REGION-DEPENDENCIES)

## Kotlin Multiplatform Support

CrossLens supports the following platforms:

- **JVM:** Full support for JVM with Kotlin toolchain version 11.
- **JavaScript (JS):** Compatible with both browser and Node.js environments using Kotlin/JS IR backend.
- **WASM:** WebAssembly support for browser and Node.js environments.
- **iOS:** Native support for iOS devices, including x64, Arm64, and Simulator Arm64.
- **macOS:** Native support for macOS devices, including x64 and Arm64.
- **Linux:** Native support for Linux devices, including x64 and Arm64.
- **tvOS:** Native support for tvOS devices, including x64, Arm64, and Simulator Arm64.
- **watchOS:** Native support for watchOS devices, including x64, Arm32, Arm64, Device Arm64, and Simulator Arm64.

## Contributing

Contributions are welcome! If you have ideas, bug reports, or feature requests, please open an issue or submit a pull request. For more details, refer to our [Contributing Guidelines](CONTRIBUTING.md).

## Find this repository useful? :heart:

Support it by joining the __[stargazers](https://github.com/teogor/crosslens/stargazers)__ for this repository. :star: <br>
Also, __[follow me](https://github.com/teogor)__ on GitHub for updates on my next creations! 🤩

## License

```xml
  Designed and developed by 2024 teogor (Teodor Grigor)

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```
