# CrossLens UI

`crosslens-ui` is a Kotlin-based package designed for managing UI components and their visibility
states within a Jetpack Compose application. It provides a set of utilities and classes that
simplify the control and handling of visibility states, ensuring a smooth user experience.

## Installation

To use the `crosslens-ui` package, add the following dependency to your `build.gradle.kts`:

```kotlin
dependencies {
  implementation("dev.teogor.crosslens:crosslens-ui:$version")
}
```

## Usage

### VisibilityState

The `VisibilityState` interface is a core component of the `crosslens-ui` package. It defines a
contract for managing the visibility of UI components, allowing developers to show, hide, and toggle
visibility with ease.

#### Defining a VisibilityState

The default implementation of `VisibilityState` is `VisibilityStateImpl`, which can be remembered
across recompositions using the `rememberVisibilityState` function.

```kotlin
@Composable
fun MyComponent() {
  val visibilityState by rememberVisibilityState()

  // Show the component
  visibilityState.show()

  // Hide the component
  visibilityState.hide()

  // Toggle the component's visibility
  visibilityState.toggle()
}
```

#### Custom VisibilityState

You can create your own implementation of `VisibilityState` by extending the interface. This is
useful when you need to manage additional properties alongside visibility.

For example, here’s a custom implementation called `MenuVisibility`:

```kotlin
class MenuVisibility(
  initialState: Boolean = false,
) : VisibilityState {
  // Custom properties
  private val _isVisible = mutableStateOf(initialState)
  override val isVisible: Boolean get() = _isVisible.value

  override val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

  override fun show() {
    _isVisible.value = true
  }

  override fun hide() {
    _isVisible.value = false
  }

  override fun toggle() {
    _isVisible.value = !isVisible
  }

  companion object Factory : VisibilityState.Factory<MenuVisibility> {
    override fun create(initialState: Boolean): MenuVisibility {
      return MenuVisibility(initialState)
    }
  }
}
```

#### Remembering a Custom VisibilityState

To remember a custom `VisibilityState` instance, use the `rememberVisibilityState` function with a
factory or factory provider:

```kotlin
@Composable
fun MyMenuComponent() {
  val menuVisibility by rememberVisibilityState(factory = MenuVisibility)
  // Or
  val menuVisibility by rememberVisibilityState { MenuVisibility }

  // Use the visibility state
  if (menuVisibility.isVisible) {
    // Render your menu
  }
}
```

### Advanced Configuration

You can apply additional configurations to your `VisibilityState` instance by using
the `withConfiguration` extension function:

```kotlin
@Composable
fun MyConfigurableComponent() {
  val visibilityState = rememberVisibilityState()
    .withConfiguration {
      // Apply custom configurations here
      toggle()
    }

  // Use the configured visibility state
}
```
