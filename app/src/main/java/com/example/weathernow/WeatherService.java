package com.example.weathernow;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "7e83b5350d45a7012b9908cfb595ee29";

    private final WeatherApi weatherApi;

    public WeatherService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    public void getCurrentWeather(double lat, double lon, Callback<WeatherData> callback) {
        Call<WeatherData> call = weatherApi.getCurrentWeather(lat, lon, API_KEY, "metric");
        call.enqueue(callback);
    }

    public void getForecast(double lat, double lon, Callback<ForecastResponse> callback) {
        Call<ForecastResponse> call = weatherApi.getForecast(lat, lon, "metric", API_KEY);
        call.enqueue(callback);
    }
}
