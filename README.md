# 🌦️ WeatherNow Android App

> A sleek and modern Android weather forecast application that shows current weather conditions and 5-day forecasts using the OpenWeatherMap API. Built with Java, Retrofit, Glide, and modern Android architecture.

![WeatherNow Banner]([https://via.placeholder.com/800x300?text=WeatherNow+Android+App](https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.shutterstock.com%2Fsearch%2Fweather-banner&psig=AOvVaw1KnzGpDEUOwz_EVjlSn_07&ust=1750599243095000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCPiM8MDQgo4DFQAAAAAdAAAAABAE))

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

📁 WeatherNow
├── MainActivity.java
├── LocationHelper.java
├── WeatherService.java
├── ForecastAdapter.java
├── ForecastData.java
├── WeatherData.java
├── layout/
│ ├── activity_main.xml
│ └── item_forecast.xml
├── AndroidManifest.xml
└── build.gradle

---



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
