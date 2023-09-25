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

## Download

Kotlin DSL:

### Snapshots

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.alexfacciorusso:compose-desktop-toolbox:0.1.0-SNAPSHOT")
}
```

### Stable

Not yet setup.

<del>

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.alexfacciorusso:compose-desktop-toolbox:0.1.0")
}
```

</del>

