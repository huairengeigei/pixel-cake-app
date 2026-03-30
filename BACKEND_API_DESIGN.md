```markdown
# Pixel Cake Backend API Design

## Base URL
https://api.pixcake.com/v1
## Authentication
使用 JWT Token 进行身份验证

### Headers
Authorization: Bearer <token>
Content-Type: application/json
---

## API Endpoints

### 1. Authentication

#### Login
- **Endpoint**: `POST /auth/login`
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
Response:
{
  "success": true,
  "data": {
    "token": "string",
    "refreshToken": "string",
    "user": {
      "id": "string",
      "username": "string",
      "email": "string",
      "avatar": "string"
    }
  }
}
Register
Endpoint: POST /auth/register
Request Body:
{
  "username": "string",
  "email": "string",
  "password": "string"
}
Response: Same as Login
Refresh Token
Endpoint: POST /auth/refresh
Request Body:
{
  "refreshToken": "string"
}
Logout
Endpoint: POST /auth/logout
2. Users
Get User
Endpoint: GET /users/{userId}
Update User
Endpoint: PUT /users/{userId}
Request Body: User object
Upload Avatar
Endpoint: POST /users/{userId}/avatar
Request Body:
{
  "image": "base64 string"
}
3. Presets
Get All Presets
Endpoint: GET /presets
Query Parameters:
category (optional): Filter by category
page (default: 1)
limit (default: 20)
Response:
{
  "success": true,
  "data": {
    "presets": [...],
    "total": 79,
    "page": 1,
    "limit": 20
  }
}
Get Preset by ID
Endpoint: GET /presets/{presetId}
Favorite Preset
Endpoint: POST /presets/{presetId}/favorite
Unfavorite Preset
Endpoint: DELETE /presets/{presetId}/favorite
4. Edits
Upload Image
Endpoint: POST /edits/upload
Request Body:{
  "image": "base64 string",
  "name": "string"
}

Response:
{
  "success": true,
  "data": {
    "imageId": "string",
    "url": "string",
    "thumbnailUrl": "string"
  }
}
Apply Preset
Endpoint: POST /edits/apply-preset
Request Body:
{
  "imageId": "string",
  "presetId": "string",
  "intensity": 1.0
}
Response:
{
  "success": true,
  "data": {
    "editedImageId": "string",
    "url": "string",
    "downloadUrl": "string"
  }
}
Pixel Cake Android App - GitHub 完整部署指南
本文档包含所有文件的详细说明、代码内容和逐步上传步骤
📋 目录
阶段一：准备工作
阶段二：根目录文件（3个）
阶段三：配置文件（5个）
阶段四：Android配置文件（6个）
阶段五：Kotlin代码文件（28个）
阶段六：验证清单
阶段一：准备工作
步骤 1：创建 GitHub 仓库
访问 https://github.com 并登录你的账号
点击右上角 "+" → "New repository"
填写仓库信息：
Repository name: pixel-cake-app
Description: Pixel Cake Android App with AI Image Processing
Public/Private: 选择 Public（公开）
勾选 "Add a README file"
点击 "Create repository"
步骤 2：进入仓库页面
仓库创建后，你将看到初始的 README.md 文件。接下来我们将创建完整的项目结构。
阶段二：根目录文件（3个）
文件 1：README.md
作用：项目说明文档，介绍项目功能、架构和开发指南
存放路径：pixel-cake-app/README.md
完整代码：
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

**上传步骤**：
1. 点击仓库中的 "README.md" 文件
2. 点击右侧铅笔图标 ✏️ 进行编辑
3. 删除原有内容，粘贴上述代码
4. 在下方的 "Commit changes" 框中输入：`Update README.md`
5. 点击 "Commit changes" 按钮

---

### 文件 2：BACKEND_API_DESIGN.md

**作用**：后端API设计文档，定义所有API接口规范

**存放路径**：`pixel-cake-app/BACKEND_API_DESIGN.md`

**完整代码**：

```markdown
# Pixel Cake Backend API Design

## Base URL
https://api.pixcake.com/v1

## Authentication
使用 JWT Token 进行身份验证

### Headers
Authorization: Bearer <token>
Content-Type: application/json

---

## API Endpoints

### 1. Authentication

#### Login
- **Endpoint**: `POST /auth/login`
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
Response:
{
  "success": true,
  "data": {
    "token": "string",
    "refreshToken": "string",
    "user": {
      "id": "string",
      "username": "string",
      "email": "string",
      "avatar": "string"
    }
  }
}
Register
Endpoint: POST /auth/register
Request Body:
{
  "username": "string",
  "email": "string",
  "password": "string"
}
Response: Same as Login
Refresh Token
Endpoint: POST /auth/refresh
Request Body:
{
  "refreshToken": "string"
}
Logout
Endpoint: POST /auth/logout
2. Users
Get User
Endpoint: GET /users/{userId}
Update User
Endpoint: PUT /users/{userId}
Request Body: User object
Upload Avatar
Endpoint: POST /users/{userId}/avatar
Request Body:
{
  "image": "base64 string"
}
3. Presets
Get All Presets
Endpoint: GET /presets
Query Parameters:
category (optional): Filter by category
page (default: 1)
limit (default: 20)
Response:
{
  "success": true,
  "data": {
    "presets": [...],
    "total": 79,
    "page": 1,
    "limit": 20
  }
}
Get Preset by ID
Endpoint: GET /presets/{presetId}
Favorite Preset
Endpoint: POST /presets/{presetId}/favorite
Unfavorite Preset
Endpoint: DELETE /presets/{presetId}/favorite
4. Edits
Upload Image
Endpoint: POST /edits/upload
Request Body:
{
  "image": "base64 string",
  "name": "string"
}
Response:
{
  "success": true,
  "data": {
    "imageId": "string",
    "url": "string",
    "thumbnailUrl": "string"
  }
}
Apply Preset
Endpoint: POST /edits/apply-preset
Request Body:
{
  "imageId": "string",
  "presetId": "string",
  "intensity": 1.0
}
Response:
{
  "success": true,
  "data": {
    "editedImageId": "string",
    "url": "string",
    "downloadUrl": "string"
  }
}
Get Edit History
Endpoint: GET /edits/history
Query Parameters:
page (default: 1)
limit (default: 20)
Save Edit
Endpoint: POST /edits/save
Request Body: EditHistory object
Download Edit
Endpoint: GET /edits/{editId}/download
5. AI Services
AI Restore
Endpoint: POST /ai/restore
Request Body:{
  "imageId": "string",
  "options": {
    "denoise": true,
    "enhance": true
  }
}
Pixel Cake Android App - GitHub 完整部署指南
本文档包含所有文件的详细说明、代码内容和逐步上传步骤
📋 目录
阶段一：准备工作
阶段二：根目录文件（3个）
阶段三：配置文件（5个）
阶段四：Android配置文件（6个）
阶段五：Kotlin代码文件（28个）
阶段六：验证清单
阶段一：准备工作
步骤 1：创建 GitHub 仓库
访问 https://github.com 并登录你的账号
点击右上角 "+" → "New repository"
填写仓库信息：
Repository name: pixel-cake-app
Description: Pixel Cake Android App with AI Image Processing
Public/Private: 选择 Public（公开）
勾选 "Add a README file"
点击 "Create repository"
步骤 2：进入仓库页面
仓库创建后，你将看到初始的 README.md 文件。接下来我们将创建完整的项目结构。
阶段二：根目录文件（3个）
文件 1：README.md
作用：项目说明文档，介绍项目功能、架构和开发指南
存放路径：pixel-cake-app/README.md
完整代码：
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

**上传步骤**：
1. 点击仓库中的 "README.md" 文件
2. 点击右侧铅笔图标 ✏️ 进行编辑
3. 删除原有内容，粘贴上述代码
4. 在下方的 "Commit changes" 框中输入：`Update README.md`
5. 点击 "Commit changes" 按钮

---

### 文件 2：BACKEND_API_DESIGN.md

**作用**：后端API设计文档，定义所有API接口规范

**存放路径**：`pixel-cake-app/BACKEND_API_DESIGN.md`

**完整代码**：

```markdown
# Pixel Cake Backend API Design

## Base URL
https://api.pixcake.com/v1

## Authentication
使用 JWT Token 进行身份验证

### Headers
Authorization: Bearer <token>
Content-Type: application/json

---

## API Endpoints

### 1. Authentication

#### Login
- **Endpoint**: `POST /auth/login`
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
Response:
{
  "success": true,
  "data": {
    "token": "string",
    "refreshToken": "string",
    "user": {
      "id": "string",
      "username": "string",
      "email": "string",
      "avatar": "string"
    }
  }
}
Register
Endpoint: POST /auth/register
Request Body:
{
  "username": "string",
  "email": "string",
  "password": "string"
}
Response: Same as Login
Refresh Token
Endpoint: POST /auth/refresh
Request Body:
{
  "refreshToken": "string"
}
Logout
Endpoint: POST /auth/logout
2. Users
Get User
Endpoint: GET /users/{userId}
Update User
Endpoint: PUT /users/{userId}
Request Body: User object
Upload Avatar
Endpoint: POST /users/{userId}/avatar
Request Body:
{
  "image": "base64 string"
}
3. Presets
Get All Presets
Endpoint: GET /presets
Query Parameters:
category (optional): Filter by category
page (default: 1)
limit (default: 20)
Response:
{
  "success": true,
  "data": {
    "presets": [...],
    "total": 79,
    "page": 1,
    "limit": 20
  }
}
Get Preset by ID
Endpoint: GET /presets/{presetId}
Favorite Preset
Endpoint: POST /presets/{presetId}/favorite
Unfavorite Preset
Endpoint: DELETE /presets/{presetId}/favorite
4. Edits
Upload Image
Endpoint: POST /edits/upload
Request Body:
{
  "image": "base64 string",
  "name": "string"
}
Response:
{
  "success": true,
  "data": {
    "imageId": "string",
    "url": "string",
    "thumbnailUrl": "string"
  }
}
Apply Preset
Endpoint: POST /edits/apply-preset
Request Body:
{
  "imageId": "string",
  "presetId": "string",
  "intensity": 1.0
}
Response:
{
  "success": true,
  "data": {
    "editedImageId": "string",
    "url": "string",
    "downloadUrl": "string"
  }
}
Get Edit History
Endpoint: GET /edits/history
Query Parameters:
page (default: 1)
limit (default: 20)
Save Edit
Endpoint: POST /edits/save
Request Body: EditHistory object
Download Edit
Endpoint: GET /edits/{editId}/download
5. AI Services
AI Restore
Endpoint: POST /ai/restore
Request Body:
{
  "imageId": "string",
  "options": {
    "denoise": true,
    "enhance": true
  }
}
Pixel Cake Android App - GitHub 完整部署指南
本文档包含所有文件的详细说明、代码内容和逐步上传步骤
📋 目录
阶段一：准备工作
阶段二：根目录文件（3个）
阶段三：配置文件（5个）
阶段四：Android配置文件（6个）
阶段五：Kotlin代码文件（28个）
阶段六：验证清单
阶段一：准备工作
步骤 1：创建 GitHub 仓库
访问 https://github.com 并登录你的账号
点击右上角 "+" → "New repository"
填写仓库信息：
Repository name: pixel-cake-app
Description: Pixel Cake Android App with AI Image Processing
Public/Private: 选择 Public（公开）
勾选 "Add a README file"
点击 "Create repository"
步骤 2：进入仓库页面
仓库创建后，你将看到初始的 README.md 文件。接下来我们将创建完整的项目结构。
阶段二：根目录文件（3个）
文件 1：README.md
作用：项目说明文档，介绍项目功能、架构和开发指南
存放路径：pixel-cake-app/README.md
完整代码：
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

**上传步骤**：
1. 点击仓库中的 "README.md" 文件
2. 点击右侧铅笔图标 ✏️ 进行编辑
3. 删除原有内容，粘贴上述代码
4. 在下方的 "Commit changes" 框中输入：`Update README.md`
5. 点击 "Commit changes" 按钮

---

### 文件 2：BACKEND_API_DESIGN.md

**作用**：后端API设计文档，定义所有API接口规范

**存放路径**：`pixel-cake-app/BACKEND_API_DESIGN.md`

**完整代码**：

```markdown
# Pixel Cake Backend API Design

## Base URL
https://api.pixcake.com/v1

## Authentication
使用 JWT Token 进行身份验证

### Headers
Authorization: Bearer <token>
Content-Type: application/json

---

## API Endpoints

### 1. Authentication

#### Login
- **Endpoint**: `POST /auth/login`
- **Request Body**:
  ```json
  {
    "username": "string",
    "password": "string"
  }
Response:
{
  "success": true,
  "data": {
    "token": "string",
    "refreshToken": "string",
    "user": {
      "id": "string",
      "username": "string",
      "email": "string",
      "avatar": "string"
    }
  }
}
Register
Endpoint: POST /auth/register
Request Body:
{
  "username": "string",
  "email": "string",
  "password": "string"
}
Response: Same as Login
Refresh Token
Endpoint: POST /auth/refresh
Request Body:
{
  "refreshToken": "string"
}
Logout
Endpoint: POST /auth/logout
2. Users
Get User
Endpoint: GET /users/{userId}
Update User
Endpoint: PUT /users/{userId}
Request Body: User object
Upload Avatar
Endpoint: POST /users/{userId}/avatar
Request Body:
{
  "image": "base64 string"
}
3. Presets
Get All Presets
Endpoint: GET /presets
Query Parameters:
category (optional): Filter by category
page (default: 1)
limit (default: 20)
Response:
{
  "success": true,
  "data": {
    "presets": [...],
    "total": 79,
    "page": 1,
    "limit": 20
  }
}
Get Preset by ID
Endpoint: GET /presets/{presetId}
Favorite Preset
Endpoint: POST /presets/{presetId}/favorite
Unfavorite Preset
Endpoint: DELETE /presets/{presetId}/favorite
4. Edits
Upload Image
Endpoint: POST /edits/upload
Request Body:
{
  "image": "base64 string",
  "name": "string"
}
Response:
{
  "success": true,
  "data": {
    "imageId": "string",
    "url": "string",
    "thumbnailUrl": "string"
  }
}
Apply Preset
Endpoint: POST /edits/apply-preset
Request Body:
{
  "imageId": "string",
  "presetId": "string",
  "intensity": 1.0
}
Response:
{
  "success": true,
  "data": {
    "editedImageId": "string",
    "url": "string",
    "downloadUrl": "string"
  }
}
Get Edit History
Endpoint: GET /edits/history
Query Parameters:
page (default: 1)
limit (default: 20)
Save Edit
Endpoint: POST /edits/save
Request Body: EditHistory object
Download Edit
Endpoint: GET /edits/{editId}/download
5. AI Services
AI Restore
Endpoint: POST /ai/restore
Request Body:
{
  "imageId": "string",
  "options": {
    "denoise": true,
    "enhance": true
  }
}
Style Transfer
Endpoint: POST /ai/style-transfer
Request Body: Same as Apply Preset
Portrait Enhance
Endpoint: POST /ai/portrait-enhance
Replace Background
Endpoint: POST /ai/replace-background
6. Cloud Storage
Get Cloud Images
Endpoint: GET /cloud/images
Upload to Cloud
Endpoint: POST /cloud/upload
Delete Cloud Image
Endpoint: DELETE /cloud/images/{imageId}
7. Settings
Get App Config
Endpoint: GET /settings/config
Response:{
  "success": true,
  "data": {
    "theme": "light",
    "language": "zh-CN",
    "autoSave": true,
    "exportQuality": "high",
    "maxUploadSize": 10485760
  }
}
Update User Settings
Endpoint: PUT /users/{userId}/settings
8. Analytics
Track Event
Endpoint: POST /analytics/events
Request Body:
{
  "eventName": "string",
  "properties": {}
}
Get Statistics
Endpoint: GET /analytics/stats
Error Codes
Code	Description
200	Success
400	Bad Request
401	Unauthorized
403	Forbidden
404	Not Found
500	Internal Server ErrorRate Limiting
Free users: 100 requests/hour
Premium users: 1000 requests/hour
