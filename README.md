Android Services Sample

# Android Platform Architecture
<img src="https://developer.android.com/static/guide/platform/images/android-stack_2x.png" alt="Platform Architecture" width="600" height="auto">

# Application Components
* **Activities**
* **Services**
* **Broadcast receivers**
* **Content providers:** https://developer.android.com/guide/topics/providers/content-providers

## Services
Services Overview: https://developer.android.com/guide/components/services
> A service is a general-purpose entry point for keeping an app running in the background for all kinds 
> of reasons. It is a component that runs in the background to perform long-running operations or to perform
> work for remote processes. A service does not provide a user interface.

Ref: Services https://developer.android.com/guide/components/fundamentals#Components

### What types of Service are there?
1. Foreground: https://developer.android.com/guide/components/foreground-services
2. Background
3. Bound: https://developer.android.com/guide/components/bound-services

### Foreground Service 
> A foreground services performs some operation that is noticeable to the user. For example, an audio app
> would use a foreground service to play an audio track. Foreground services must display a Notification.
> Foreground services continue running even when the user isn't interacting with the app.

Ref: Type of Services > Foreground https://developer.android.com/guide/components/services

<img src="https://developer.android.com/static/images/guide/components/fgs-manager.svg" alt="Foreground Service" width="600" height="auto">

### Background
> A background service performs an operation that isn't directly noticed by the user. For example, 
> if an app used a service to compact its storage, that would usually be a background service.

Ref: Type of Services > Background https://developer.android.com/guide/components/services

### Service lifecycle
The following diagram shows on the left the lifecycle when the service is created with `startService()` 
and on the right it shows when the service is created with `bindService()`.
<div><img src="https://developer.android.com/static/images/service_lifecycle.png" alt="Service Lifecycle" /></div>


## Broadcast receivers
Broadcast Overview: https://developer.android.com/guide/components/broadcasts
> A broadcast receiver is a component that lets the system deliver events to the app outside of a regular 
user flow so the app can respond to system-wide broadcast announcements. Because broadcast receivers 
are another well-defined entry into the app, the system can deliver broadcasts even to apps that aren't 
currently running.

Ref: Broadcast Receivers https://developer.android.com/guide/components/fundamentals#Components

### Broadcast Actions
1. **ACTION_AIRPLANE_MODE_CHANGED:** The user has switched the phone into or out of Airplane Mode.
2. **ACTION_APPLICATION_LOCALE_CHANGED:** Local of a particular app has changed.
3. **ACTION_APPLICATION_RESTRICTIONS_CHANGED:** Sent after application restrictions are changed.
4. **ACTION_BATTERY_CHANGED:** This is a sticky broadcast containing the changing state, level, and other information about the battery.
5. **ACTION_BATTERY_LOW:** Indicates low battery condition on the device.
6. **ACTION_BATTERY_OKAY:** Indicates the battery is now okay after being low.
7. **ACTION_BOOT_COMPLETED:** This is broadcast once, after user has finished booting.
8. **ACTION_CAMERA_BUTTON:** The "Camera Button" was pressed.
9. **ACTION_CONFIGURATION_CHANGED:** The current device Configuration (orientation, locale, etc) has changed.
10. **ACTION_DATE_CHANGED:** The date has changed.
11. **ACTION_DOCK_EVENT:** A sticky broadcast for changes in the physical docking state of the device.
12. 


## What can you find here
| Services               | Broadcast Receivers   | Content Providers |  
|------------------------|-----------------------|-------------------|  
| DemoForegroundService  | AirPlaneModeReceiver  |                   |  
|                        |                       |                   |
