# PopupMsgLibrary

## Description
This is a simple library to make pop-up messages in your app.

## How to import the library 
**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

**Step 2.** Add the dependency
```
dependencies {
  implementation 'com.github.L10n42:PopupMsgLibrary:0.4.0'
}
```
## Builder metods
**Metods for both builder:**
- `setCornerRadius` - uses to set corner radius for pop up window. As a parameter you must put some float value, by the default it is: 33f 
- `setBackgroundDrawResource` - 

