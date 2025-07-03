package com.example.weathernow;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherData {
    private String name;
    private Sys sys;
    private Main main;
    private Wind wind;
    private List<Weather> weather;
    private Rain rain;

    public String getName() { return name; }
    public Sys getSys() { return sys; }
    public Main getMain() { return main; }
    public Wind getWind() { return wind; }
    public List<Weather> getWeather() { return weather; }
    public Rain getRain() { return rain; }

    public static class Sys {
        private String country;
        public String getCountry() { return country; }
    }

    public static class Main {
        private double temp;
        @SerializedName("feels_like")
        private double feelsLike;
        private int humidity;
        private int pressure;

        public double getTemp() { return temp; }
        public double getFeelsLike() { return feelsLike; }
        public int getHumidity() { return humidity; }
        public int getPressure() { return pressure; }
    }

    public static class Wind {
        private double speed;
        public double getSpeed() { return speed; }
    }

    public static class Weather {
        private String main;
        private String description;
        private String icon;

        public String getMain() { return main; }
        public String getDescription() { return description; }
        public String getIcon() { return icon; }
    }

    public static class Rain {
        @SerializedName("1h")
        private double h1;
        public double get1h() { return h1; }
    }
}
