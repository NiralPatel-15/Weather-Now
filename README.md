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

# 🌦️ WeatherNow

WeatherNow is an Android weather forecast app that displays a 1-month forecast with a horizontal scroll layout.

## 📂 Project Structure

- WeatherNow/
  - app/
    - build.gradle
    - src/
      - main/
        - java/com/yourpackagename/weathernow/
          - MainActivity.java
          - LocationHelper.java
          - WeatherService.java
          - ForecastAdapter.java
          - ForecastData.java
          - WeatherData.java
        - res/
          - layout/
            - activity_main.xml
            - item_forecast.xml
        - AndroidManifest.xml
  - build.gradle  (Project-level)
  - settings.gradle
  - .gitignore
  - README.md



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
