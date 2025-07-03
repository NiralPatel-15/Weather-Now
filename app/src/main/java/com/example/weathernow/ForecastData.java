package com.example.weathernow;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastData {
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private Rain rain;

    @SerializedName("dt_txt")
    private String dtTxt;

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public static class Main {
        private float temp;

        @SerializedName("feels_like")
        private float feelsLike;

        private int humidity;

        public float getTemp() {
            return temp;
        }

        public float getFeelsLike() {
            return feelsLike;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public static class Weather {
        private String main;
        private String description;
        private String icon;

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    public static class Wind {
        private float speed;

        public float getSpeed() {
            return speed;
        }
    }

    public static class Rain {
        @SerializedName("3h")
        private float threeHour;

        public float get3h() {
            return threeHour;
        }
    }
}
