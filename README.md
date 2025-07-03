# 🌦️ WeatherNow Android App

> A sleek and modern Android weather forecast application that shows current weather conditions and 5-day forecasts using the OpenWeatherMap API. Built with Java, Retrofit, Glide, and modern Android architecture.


---

## 🚀 Features

✅ Get real-time weather for your **current location**  
✅ View **5-day forecast** with upcoming months & 24-hour format  
✅ Smooth **RecyclerView** UI for forecast display  
✅ Supports **runtime permissions** and **location services**  
✅ Auto fallback to **default location (London)** if permission denied  
✅ Dynamic weather icons using **Glide**  
✅ Handles **Android 12+ `android:exported`** requirements

---

## 🛠 Tech Stack

- **Java (Android)**
- **Retrofit2** – HTTP networking
- **Glide** – Image loading
- **Google Play Services Location API**
- **GSON** – JSON deserialization
- **RecyclerView & CardView** – Forecast UI
- **AndroidX** Components

---

## 📦 Project Structure
📁 app/
 └── 📁 src/
      └── 📁 main/
           ├── 📁 java/
           │    └── 📁 com/yourpackagename/weathernow/
           │         ├── 📁 data/           # Models (POJOs)
           │         │     ├── WeatherData.java
           │         │     ├── ForecastData.java
           │         │
           │         ├── 📁 network/        # API helpers/services
           │         │     ├── WeatherService.java
           │         │
           │         ├── 📁 adapter/        # RecyclerView adapters
           │         │     ├── ForecastAdapter.java
           │         │
           │         ├── 📁 util/           # Utility/helper classes
           │         │     ├── LocationHelper.java
           │         │
           │         └── MainActivity.java  # Main Activity
           │
           ├── 📁 res/
           │    ├── 📁 layout/
           │    │     ├── activity_main.xml
           │    │     ├── item_forecast.xml
           │    │
           │    ├── 📁 drawable/           # Icons/images
           │    ├── 📁 values/             # strings.xml, colors.xml, themes.xml
           │
           ├── AndroidManifest.xml
           ├── build.gradle


---


## 🧪 Getting Started

### 📲 Prerequisites
- Android Studio (latest version)
- Android SDK (API 35+ recommended)
- OpenWeatherMap API key: [Get one here](https://openweathermap.org/api)

---

### 🛠 Installation


1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/weathernow.git
   cd weathernow
