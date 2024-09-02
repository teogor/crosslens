# Crosslens

Learn more: **[User Guide](../user-guide.md)** and **[Code Samples](../code-samples.md)**

🔍 CrossLens delivers precise platform insights for Kotlin Multiplatform projects, enabling seamless adaptation across diverse environments.


[//]: # (REGION-API-REFERENCE)

API Reference  
[`dev.teogor.crosslens:crosslens-*`](../html/)  
[`dev.teogor.crosslens:crosslens-compose`](../html/crosslens-compose)  
[`dev.teogor.crosslens:crosslens-core`](../html/crosslens-core)  
[`dev.teogor.crosslens:crosslens-ui`](../html/crosslens-ui)

[//]: # (REGION-API-REFERENCE)

[//]: # (REGION-RELEASE-TABLE)

| Latest Update        |  Stable Release  |  Release Candidate  |  Beta Release  |  Alpha Release  |
|:---------------------|:----------------:|:-------------------:|:--------------:|:---------------:|
| September 02, 2024   |        -         |          -          |       -        |  1.0.0-alpha02  |

[//]: # (REGION-RELEASE-TABLE)

[//]: # (REGION-DEPENDENCIES)

## Declaring dependencies

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

For comprehensive instructions on adding these dependencies, refer to the [Crosslens documentation](../index.md#getting-started-with-crosslens).

[//]: # (REGION-DEPENDENCIES)

[//]: # (REGION-FEEDBACK)

## Feedback

Your feedback helps make Crosslens better. Let us know if you discover new issues or have
ideas for improving this library. Please take a look at the [existing issues on GitHub](https://github.com/teogor/crosslens/issues)
for this library before you create a new one.

[Create a new issue](https://github.com/teogor/crosslens/issues/new){ .md-button }

[//]: # (REGION-FEEDBACK)

[//]: # (REGION-VERSION-CHANGELOG)

### Version 1.0.0

#### Version 1.0.0-alpha02

September 02, 2024

[`dev.teogor.crosslens:crosslens-*:1.0.0-alpha02`](https://github.com/teogor/crosslens/releases/1.0.0-alpha02) is released. [Version 1.0.0-alpha02 contains these commits](https://github.com/teogor/crosslens/compare/1.0.0-alpha01...1.0.0-alpha02)

**Enhancement**

* Implement Thread-Safe Collections `SynchronizedMap` and `SynchronizedSet` ([#5](https://github.com/teogor/crosslens/issues/5)) by [@teogor](https://github.com/teogor)
* Implement Configuration State Monitoring for Compose ([#4](https://github.com/teogor/crosslens/issues/4)) by [@teogor](https://github.com/teogor)
* Introduce Support for Platform-Specific Class Name Formats ([#3](https://github.com/teogor/crosslens/issues/3)) by [@teogor](https://github.com/teogor)
* Introduce HashCodeBuilder Utility and Lazy HashCode Functions ([#2](https://github.com/teogor/crosslens/issues/2)) by [@teogor](https://github.com/teogor)
* Introduce VisibilityState Interface and Composable Utilities for Visibility Management ([#1](https://github.com/teogor/crosslens/issues/1)) by [@teogor](https://github.com/teogor)

#### Version 1.0.0-alpha01

August 30, 2024

[`dev.teogor.crosslens:crosslens-*:1.0.0-alpha01`](https://github.com/teogor/crosslens/releases/1.0.0-alpha01) is released. [Version 1.0.0-alpha01 contains these commits](https://github.com/teogor/crosslens/commits/1.0.0-alpha01)

# 🎉 Introducing CrossLens v1.0.0-alpha01 🧩
🔍 **CrossLens** provides precise platform insights for Kotlin Multiplatform projects, ensuring seamless adaptation across various environments. Whether you're developing for mobile, desktop, or IoT, CrossLens helps you understand and manage platform-specific details with ease.
## Features - **Multi-Platform Support:** Get detailed information about the platform your code is running on, across different environments. - **Seamless Integration:** Easily integrate with your existing Kotlin Multiplatform projects. - **Up-to-Date Insights:** Stay informed with the latest platform information to ensure compatibility and optimal performance.

[//]: # (REGION-VERSION-CHANGELOG)

