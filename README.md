### 说明
方便在Android中使用Interpolator一些常见的CubicBezier贝塞尔曲线动画效果。

### 示意图如下
![image](img/yisibl.github.io_cubic-bezier_.png)

### 使用
1. 将 [CubicBezierInterpolators.kt](app/src/main/java/com/logan/cubicbezierandroidinterpolators/interpolators/CubicBezierInterpolators.kt) 类Copy到你项目中。

2. 使用如下：
```kotlin
val animator: ObjectAnimator = ObjectAnimator.ofFloat(yourView, "translationX", 0, 500)
animator.duration = 1000
animator.interpolator = CubicBezierInterpolators.Type.EASE.create()
animator.start()
```
### DEMO
1. Demo.apk [点击下载](apk/app-debug.apk)
2. Demo的Gif效果图 ![image](img/yisibl.github.io_cubic-bezier_.png)

### 感谢
http://yisibl.github.io/cubic-bezier/#.25,.1,.25,1
