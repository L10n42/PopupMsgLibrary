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
## Builder additional functions
**Functions for both Builder:**
- `setCornerRadius()` - is used to set corner radius for pop up window. As a parameter you must put some `Float` value, by the default it is: 33f 
Example: `setCornerRadius(50f)`

- `setBackgroundDrawResource()` - is used to set drawable by the id as a background for pop-up window. As a parameter you must put id of your drawable. 
Example: `setBackgroundDrawResource(R.drawable.yourDrawable)`

- `setBackgroundDrawable()` - is used to set drawable as a background for pop-up window. As a parameter you must put some drawable.
Example: `setBackgroundDrawable(yourDrawable)`

- `setDuration()` - is used to set visibility duration for your pop-up msg. As a parameter you must put some time value in millisec, by the default it is: 2000 millisec or 2 sec. Or you can also use default constants DURATION_SHORT = 2000 millisec or 2 sec and DURATION_LONG = 3500 millisec or 3,5 sec.
Examples: 
millisec - `setDuration(5000)`,
constants - `setDuration(PopupMsg.DURATION_LONG)`

- `setBackgroundColor()` - is used to set color as a background for pop-up window. As a parameter you must put some `Int` color.
Examples: `setBackgroundColor(Color.RED)` or `setBackgroundColor(Color.parsColor("#FF0000"))` or `setBackgroundColor(resource.getColor(R.color.red))`

- `setBackgroundResourceColor()` - is used to set color by the id as a background for pop-up window. As a parameter you must put id of your color.
Example: `setBackgroundResourceColor(R.color.green)`

- `setTextColor()` - is used to set color for text at pop-up window. As a parameter you must put some `Int` color.
Examples: `setTextColor(Color.RED)` or `setTextColor(Color.parsColor("#FF0000"))` or `setTextColor(resource.getColor(R.color.red))`

- `setTextResourceColor()` - is used to set color by the id for text at pop-up window. As a parameter you must put id of your color.
Example: `setTextResourceColor(R.color.green)`

- `setGravity()` - is used to set place for your pop-up msg. As a first parameter you must put `Gravity` of your msg, as second and third you must put `X` and `Y`.
Example: `setGravity(Gravity.CENTER, 0, 0)`

- `setTextSize()` - is used to set text size at your pop-up msg. As a parameter you must put some `Float` value, by the default it is: 14f
Example: `setTextSize(18f)`

- `setElevation()` - is used to set elevation for your pop-up msg. As a parameter you must put some `Float` value, by the default it is: 10f
Example: `setElevation(5f)`

- `setTextAlignment()` - is used to set text alignment at your pop-up msg. As a parameter you must put `View.TEXT_ALIGNMENT...`, by the default it is: `View.TEXT_ALIGNMENT_CENTER`
Example: `setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START)`

- `setStroke()` - is used to set a stroke for your pop-up window. As a first parameter you must put `Int` width of stroke, as second you must put `Int` color of stoke.
Example: `setStroke(4, Color.RED)`

**Functions for TextBuilder:**
- `setDrawable(left/ right/ top/ bottom)()` - is used to set a drawable (left/ right/ top/ bottom) of text. As a parameter you must put some drawable.
Example: `setDrawableLeft(yourDrawable1)` , `setDrawableTop(yourDrawable2)`

- `setDrawable(left/ right/ top/ bottom)Resource()` - is used to set a drawable by the id (left/ right/ top/ bottom) of text. As a parameter you must put id of your drawable.
Example: `setDrawableLeftResource(R.drawable.yourDrawable1)` , `setDrawableTopResource(R.drawable.yourDrawable2)`

- `setDrawable(left/ right/ top/ bottom)Size()` - is used to set drawable (left/ right/ top/ bottom) size. As a first parameter you must put `Int` width of drawable, as second you must put `Int` height of drawable.
Example: `setDrawableLeftSize(100, 100)` , `setDrawableBottomSize(230, 125)`

- `setTextPadding()` - is used to set padding for text. As parameters you must put 4 `Int` value (left, right, top, bottom).
Example: `setTextPadding(10, 10, 20, 20)`

**Functions for ImgBuilder:**
- `setType()` - is used when you need set type of msg (image or gif). As a parameter you need put one of the constants `TYPE_DRAWABLE` or `TYPE_GIF`, by the default it is: `TYPE_DRAWABLE`
Example: `setType(PopupMsg.TYPE_DRAWABLE)` or `setType(PopupMsg.TYPE_GIF)`

- `setGifImgResource()` - is used to set gif image resource when you choose type Gif. As a parameter you must put id of your Gif image.
Example: `setGifImgResource(R.drawable.yourGif)`

- `setDrawable()` - is used to set drawable when you choose type Drawable. As a parameter you must put some drawable.
Example: `setDrawable(yourDrawable)`

- `setImgPadding()` - is used to set padding for drawable(/gif). As parameters you must put 4 `Int` value (left, right, top, bottom).
Example: `setImgPadding(15, 15, 30, 30)`

- `setImgSize()` - is used to set drawable(/gif) size. As a first parameter you must put `Int` width of drawable, as second you must put `Int` height of drawable.
Example: `setImgSize(100, 100)`

- `set(bottom/ top)Msg` - is used to set text msg bottom or top of drawable. As a parameter you need put some `String` msg.
Example: `setBottomMsg("Hello world!")`




