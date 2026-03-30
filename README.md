# Pixel Cake Android App (像素蛋糕应用)

带AI图像处理的Android应用 - 预设滤镜与人像修图

## 项目简介

Pixel Cake是一款专业的图像处理应用，提供79种预设滤镜风格，涵盖户外、胶片、电影感、商拍等多个类别。

## 功能模块

### 核心功能
- 🎨 **79种预设滤镜**
  - 户外系列：日色慢、秋日鎏金、秋意浓、纯白冬日等
  - 胶片系列：富士NC、富士NN、理光正片等
  - 电影感系列：蓝桥、重庆森林、绿意等
  - 商拍系列：证件照、婚纱照、全家福等
  - 主题系列：拯救废片、夏日主题、油画风格等

- 👤 **人像修图**
  - 智能磨皮
  - 面部重塑
  - 肤色优化
  - 眼部增强

### 技术架构
- **UI框架**: Jetpack Compose
- **架构模式**: MVVM + Clean Architecture
- **异步处理**: Kotlin Coroutines + Flow
- **图像处理**: OpenCV + TensorFlow Lite
- **依赖注入**: Hilt

## 项目结构
pixel-cake-app/
├── android_native_project/
│ ├── app/
│ │ ├── src/
│ │ │ ├── main/
│ │ │ │ ├── java/com/pixcake/
│ │ │ │ │ ├── MainActivity.kt
│ │ │ │ │ ├── PixCakeApp.kt
│ │ │ │ │ ├── ui/
│ │ │ │ │ ├── viewmodel/
│ │ │ │ │ ├── data/
│ │ │ │ │ └── di/
│ │ │ │ ├── res/
│ │ │ │ └── AndroidManifest.xml
│ │ ├── build.gradle.kts
│ │ └── proguard-rules.pro
│ ├── gradle/
│ ├── build.gradle.kts
│ └── settings.gradle.kts
└── README.md
## 构建状态

当前版本：v0.1.0 (空壳版本)

✅ 基础架构搭建  
✅ Jetpack Compose UI框架  
✅ MVVM架构  
🚧 预设滤镜模块（开发中）  
🚧 人像修图模块（开发中）  
🚧 AI图像处理（开发中）

## 开发计划

### 阶段一：空壳版本（当前）
- [x] 项目结构搭建
- [x] 基础UI框架
- [x] 导航系统
- [ ] 预设列表展示
- [ ] 图片选择功能

### 阶段二：预设滤镜
- [ ] 79种预设实现
- [ ] 调色算法集成
- [ ] 参数配置系统

### 阶段三：人像修图
- [ ] 人像识别
- [ ] 磨皮算法
- [ ] 面部重塑

### 阶段四：AI增强
- [ ] TensorFlow Lite集成
- [ ] 神经风格迁移
- [ ] 智能优化

## 开发环境要求

- Android Studio Arctic Fox或更高版本
- JDK 17
- Android SDK 33 (Android 13)
- Gradle 8.3
- Kotlin 1.9.20

## 构建说明

### 方式一：使用Android Studio
1. 克隆仓库
2. 使用Android Studio打开项目
3. 等待Gradle同步完成
4. 运行到模拟器或真机

### 方式二：使用命令行
```bash
cd android_native_project
./gradlew assembleDebug
生成的APK位置：app/build/outputs/apk/debug/app-debug.apk
贡献指南
欢迎提交Issue和Pull Request！
许可证
Copyright © 2026 Pixel Cake Team
