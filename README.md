# LiveStream-Kt (Android) 📱
LiveStream is a data holder class which can observe ***change*** of data in real-time and ***emit values*** too. Unlike other observables, LiveStream uses different approach. Here's emitter subscriber pattern. It's developed in Kotlin and fully compatible with Java.

![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg)
[![JavaDoc](https://img.shields.io/badge/JavaDoc-LiveStreamKt-blue.svg)](https://patilshreyas.github.io/LiveStream-kt/docs/)

![Github Followers](https://img.shields.io/github/followers/PatilShreyas?label=Follow&style=social)
![GitHub stars](https://img.shields.io/github/stars/PatilShreyas/LiveStream-kt?style=social)
![GitHub forks](https://img.shields.io/github/forks/PatilShreyas/LiveStream-kt?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/PatilShreyas/LiveStream-kt?style=social)
![Twitter Follow](https://img.shields.io/twitter/follow/imShreyasPatil?label=Follow&style=social)

## Getting Started ⚡️
This library is fully compatible with **Java**. Here we've demonstrated using Kotlin.

### Add Dependency
Add below dependency in [`build.gradle`](app/build.gradle) of your app module.
```gradle
dependencies {
    implementation 'com.shreyaspatil:LiveStream-kt:0.1'
}
```

### Initialize `LiveStream` Class
`LiveStream` is a generic class. You can create instance as below.

```kotlin
        private val liveStream = LiveStream<String>()
```

### Subscribe to Stream / Add Observer
`LiveStream` event will be dispatched when data is changed. See below code to add observer / subscriber.

*Imagine, this code is in UI class of Android (e.g. MainActivity). Whenever value from background task (e.g. Service Class) is emitted, subscriber will listen live changes in data.*

```kotlin
        val observer = liveStream.subscribe("httpResponse") { response ->
            showToast("This is HTTP response: $response")
        }
```
`LiveStream#subscribe()` method will return instance of `StreamObserver`. This instance will be useful to unsubscribe from `LiveStream`.

### Emit Values/Data
You can emit values in `LiveData` from anywhere in the application. See below code.

#### From Main Thread :
To emit values from main thread, use `LiveStream#set()` method.
```kotlin
        val response = getResponse()
        liveStream.set("httpResponse", response)
```

#### From Other Thread :
To emit values from other thread, use `LiveStream#post()` method.
```kotlin
        val response = getResponse()
        liveStream.post("httpResponse", response)
```

### Unsubscribe 
To unsubscribe stream observer, use `LiveStream#unsubscribe()` method. It has to pass instance of `StreamObserver` which is obtained when you called `subscribe()` method. See below code.

```kotlin
    override fun onStop() {
        super.onStop()
        liveStream.unsubscribe(observer)
    }
```

## Sample Usage 🚀
Sample code is available in [`/app`](/app) directory. Both Java & Kotlin code sample available.
- [Kotlin Sample](https://github.com/PatilShreyas/LiveStream-kt/tree/master/app/src/main/java/com/shreyaspatil/livestream/example/kotlin)
- [Java Sample](https://github.com/PatilShreyas/LiveStream-kt/tree/master/app/src/main/java/com/shreyaspatil/livestream/example/java)

## Contribute 🤝
If you want to contribute to this library, you're always welcome!
See [Contributing Guidelines](CONTRIBUTING.md). 

## Contact ✉️
If you need any help, you can connect with me.

Visit:- [shreyaspatil.dev](https://shreyaspatil.dev)

## License 📃
```
MIT License

Copyright (c) 2020 Shreyas Patil

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
