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
- `setCornerRadius()` - uses to set corner radius for pop up window. As a parameter you must put some float value, by the default it is: 33f 

- `setBackgroundDrawResource()` - uses to set drawable by the id as a background for pop-up window. As a parameter you must put id of your drawable. 
Example: `setBackgroundDrawResource(R.drawable.yourDrawable)`

- `setBackgroundDrawable()` - uses to set drawable as a background for pop-up window. As a parameter you must put some drawable.
Example: `setBackgroundDrawable(yourDrawable)`

- `setDuration()` - uses to set visibility duration for your pop-up msg. As a parameter you must put some time value in millisec, by the default it is: 2000 millisec or 2 sec. Or you can also use default constants DURATION_SHORT = 2000 millisec or 2 sec and DURATION_LONG = 3500 millisec or 3,5 sec.
Examples: 
millisec - `setDuration(5000)`,
constants - `setDuration(PopupMsg.DURATION_LONG)`

- `setBackgroundColor()` - uses to set color as a background for pop-up window. As a parameter you must put some `Int` color.
Examples: `setBackgroundColor(Color.RED)` or `setBackgroundColor(Color.parsColor("#FF0000"))` or `setBackgroundColor(resource.getColor(R.color.red))`

- `setBackgroundResourceColor()` - uses to set color by the id as a background for pop-up window. As a parameter you must put id of your color.
Example: `setBackgroundResourceColor(R.color.green)`

- `setTextColor()` - uses to set color for text at pop-up window. As a parameter you must put some `Int` color.
Examples: `setTextColor(Color.RED)` or `setTextColor(Color.parsColor("#FF0000"))` or `setTextColor(resource.getColor(R.color.red))`

- `setTextResourceColor()` - uses to set color by the id for text at pop-up window. As a parameter you must put id of your color.
Example: `setTextResourceColor(R.color.green)`

- `setGravity()` - uses to set place for your pop-up msg. As a first parameter you must put `Gravity` of your msg, as second and third you must put `X` and `Y`.
Example: `setGravity(Gravity.CENTER, 0, 0)`


