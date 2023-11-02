[![](https://jitpack.io/v/alexfacciorusso/compose-desktop-toolbox.svg)](https://jitpack.io/#alexfacciorusso/compose-desktop-toolbox)

## Introduction

A set of tools for your Compose Desktop development delight.

## Features

- [x] `Modifier.bindWindowMinimumSize` - bind the minimum size of a window to a Composable's "relaxed state".

## Usage

### `Modifier.bindWindowMinimumSize`

See the [sample](sample/src/main/kotlin/Main.kt) for a full example.

```kotlin
Window(onCloseRequest = ::exitApplication) {
    App(modifier = Modifier.bindWindowMinimumSize(this))
}
```

### `WindowScope.WindowMinimumSize`

```kotlin
Window(onCloseRequest = ::exitApplication) {
    WindowMinimumSize(minimumWidth = 600.dp)
    // ...
}
```

## Download


### Snapshots

See instructions [here](https://jitpack.io/#alexfacciorusso/compose-desktop-toolbox/main-SNAPSHOT).

### Releases

WIP
<!--
Kotlin DSL:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.alexfacciorusso:compose-desktop-toolbox:0.1.0")
}
```
-->
