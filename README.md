<p align="center"><img width="512" src="https://user-images.githubusercontent.com/2095991/103446942-5f68d800-4c85-11eb-945f-f82cd6e150e0.png" alt="Banner"></p>

**Elmyra** allows you to assign custom actions for the **Active Edge** shortcut on **Google Pixel** devices. On Pixel devices, Active Edge is configured to trigger the Google Assitant by default. For many Pixel users, this feature feels wasted by the Google's will to enfore their assistant to users while **it could be reassigned to something much more handy** !

## Active Edge

Active Edge is arguably one of the best (original) feature of Google Pixel smartphone devices that creates a force-sensitive interaction surface along their sides, allowing users to perform gestures by holding and squeezing their device. Basically, pressing the edges of your phone allows you to perform an action.

<p align="center"><img width="800" alt="Active Edge" src="https://user-images.githubusercontent.com/2095991/103447559-23d20c00-4c8d-11eb-8d9c-1f23cabc0d85.png">
</p>

This technology was first seen on HTC smartphone and was then adapted by Google on its Pixel devices. Sensors are located on each side of the device and can measure the pression applied on the edges when the user squeeze their smartphone. You can read more about it on the [research paper](https://dl.acm.org/doi/pdf/10.1145/3290605.3300504) published by Google.

Unfortunately this feature is highly underrated because Google did not provided any way to customize the action triggered by a squeeze. Until Android Q, there was no way to bypass hardcoded Google Assistant other than root your device and replace the `SystemUIGoogle.apk` by a custom one.

### Supported Pixels

* Pixel 2/XL
* Pixel 3/XL
* Pixel 3a/XL
* Pixel 4/XL

Sadly Google discontinued Active Edge for future Pixel devices :(

## How To

Since Android Q, Google has provided a hidden menu to remap the Active Edge action. You'll need to have **a supported Pixel running stock Android 10 or newer**. 
Please install the Elmyra app on your Pixel. 

For the time being, there is no icon on the app drawer to avoid polluting your device with unecessary icons, but you can still configure Elmyra through the hidden menu. To enable this menu, you'll need to execute this command though an **ADB shell**.

```
adb shell settings put secure assist_gesture_any_assistant 1
```
Then you should get access to a hidden menu in `Settings > Apps & notifications > Default apps > Digital assistant apps` and replace the Google Assistant with Elmyra you just installed.

## FAQ

> [Edge Sense Plus](https://play.google.com/store/apps/details?id=eu.duong.edgesenseplus) and [Button Mapper](https://play.google.com/store/apps/details?id=flar2.homebutton) do the same job better, why did you came with this ?

**Edge Sense Plus** relies on creating fake shortcuts triggering a custom action and replacing the Google Assistant in the same menu shown above, which creates unecessary icons in the app drawer and I feel it pollutes the user experience, or at least mine.

**Button Mapper** relies on reading the logcat and execute the custom action when an Active Edge event is detected. This is a less intrusive method but not entirely reliable and some event may be missed by the app, especially when the screen is off. And such a mechanism forces the user to return to the homescreen each time Active Edge is pressed.

Finally, both of these solutions are closed-source and no public documention is available to learn how to exploit the Active Edge APIs. That's why I wanted to design a solution that could suit my needs while providing everyone with an open-source proof-of-concept. Reinventing the wheel. Again.

> Why did you named it Elmyra ?

**Elmyra** is the codename used by Google to designate Active Edge. So while the name is temporary, I felt it was a great idea to start with this app name and change it later.

> Gimme some usage ideas ?

* Squeeze for torch
* Squeeze for camera
* Squeeze to turn screen off
* Squeeze to show homescreen
