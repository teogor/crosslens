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

## Getting Started
1. Add CrossLens to your Kotlin Multiplatform project.
2. Utilize the provided APIs to fetch platform-specific details.
3. Adapt your code based on the insights provided by CrossLens.

## Installation
Add the following to your `build.gradle.kts`:
```kotlin
dependencies {
  implementation("dev.teogor.crosslens:crosslens-core:1.0.0-alpha01")
}
```

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
