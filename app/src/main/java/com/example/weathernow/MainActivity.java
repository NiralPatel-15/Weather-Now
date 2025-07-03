package com.example.weathernow;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_CODE = 101;
    private static final String API_KEY = "7e83b5350d45a7012b9908cfb595ee29"; // Replace with your OpenWeatherMap API key

    private TextView cityNameText, currentTempTextView, locationTextView,
            weatherConditionTextView, feelsLikeTextView, humidityTextView,
            windTextView, rainTextView, weatherConditionDetailTextView;

    private ImageView currentWeatherIcon, conditionIcon;
    private ProgressBar progressBar;
    private RecyclerView forecastRecyclerView;
    private ForecastAdapter forecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityNameText = findViewById(R.id.cityNameText);
        currentTempTextView = findViewById(R.id.currentTempTextView);
        locationTextView = findViewById(R.id.locationTextView);
        weatherConditionTextView = findViewById(R.id.weatherConditionTextView);f
        feelsLikeTextView = findViewById(R.id.feelsLikeTextView);
        humidityTextView = findViewById(R.id.humidityTextView);
        windTextView = findViewById(R.id.windTextView);
        rainTextView = findViewById(R.id.rainTextView);
        weatherConditionDetailTextView = findViewById(R.id.weatherConditionDetailTextView);
        currentWeatherIcon = findViewById(R.id.currentWeatherIcon);
        conditionIcon = findViewById(R.id.conditionIcon);
        progressBar = findViewById(R.id.progressBar);
        forecastRecyclerView = findViewById(R.id.forecastRecyclerView);
        forecastRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        checkPermissionAndFetchWeather();
    }

    private void checkPermissionAndFetchWeather() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_CODE);
        } else {
            fetchLocation();
        }
    }

    @SuppressLint("MissingPermission")
    private void fetchLocation() {
        progressBar.setVisibility(View.VISIBLE);
        new LocationHelper(this, (lat, lon) -> {
            getCityName(lat, lon);
            fetchForecast(lat, lon);
        }).startLocationUpdates();
    }

    private void getCityName(double lat, double lon) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(lat, lon, 1);
            if (!addressList.isEmpty()) {
                String city = addressList.get(0).getLocality();
                cityNameText.setText(city);
                locationTextView.setText(city);
            }
        } catch (Exception e) {
            cityNameText.setText("Unknown City");
        }
    }

    private void fetchForecast(double lat, double lon) {
        WeatherApi api = RetrofitClient.getInstance().getWeatherApi();
        api.getForecast(lat, lon, "metric", API_KEY).enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(@NonNull Call<ForecastResponse> call, @NonNull Response<ForecastResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    List<ForecastData> list = response.body().getList();
                    if (list == null || list.isEmpty()) return;

                    ForecastData current = list.get(0);
                    currentTempTextView.setText(String.format(Locale.getDefault(), "%.0f°C", current.getMain().getTemp()));
                    weatherConditionTextView.setText(current.getWeather().get(0).getMain());
                    feelsLikeTextView.setText(String.format(Locale.getDefault(), "%.0f°C", current.getMain().getFeelsLike()));
                    humidityTextView.setText(current.getMain().getHumidity() + "%");
                    windTextView.setText(String.format(Locale.getDefault(), "%.1f km/h", current.getWind().getSpeed()));
                    rainTextView.setText(current.getRain() != null ? current.getRain().get3h() + " mm" : "0 mm");
                    weatherConditionDetailTextView.setText("Currently: " + current.getWeather().get(0).getDescription());

                    String icon = current.getWeather().get(0).getIcon();
                    String iconUrl = "https://openweathermap.org/img/wn/" + icon + "@2x.png";
                    Glide.with(MainActivity.this).load(iconUrl).into(currentWeatherIcon);
                    Glide.with(MainActivity.this).load(iconUrl).into(conditionIcon);

                    forecastAdapter = new ForecastAdapter(list);
                    forecastRecyclerView.setAdapter(forecastAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get forecast", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ForecastResponse> call, @NonNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_CODE && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            fetchLocation();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}
