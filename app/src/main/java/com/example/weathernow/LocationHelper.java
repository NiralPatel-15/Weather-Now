package com.example.weathernow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;

import com.google.android.gms.location.*;

public class LocationHelper {

    public interface LocationCallback {
        void onLocationReceived(double latitude, double longitude);
    }

    private final Context context;
    private final LocationCallback callback;
    private final FusedLocationProviderClient fusedLocationClient;
    private final LocationRequest locationRequest;

    public LocationHelper(Context context, LocationCallback callback) {
        this.context = context;
        this.callback = callback;
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);

        locationRequest = LocationRequest.create()
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .setInterval(5000)
                .setFastestInterval(2000);
    }

    @SuppressLint("MissingPermission")
    public void startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }

    private final com.google.android.gms.location.LocationCallback locationCallback =
            new com.google.android.gms.location.LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult != null && !locationResult.getLocations().isEmpty()) {
                        android.location.Location location = locationResult.getLastLocation();
                        callback.onLocationReceived(location.getLatitude(), location.getLongitude());
                        stopLocationUpdates();
                    }
                }
            };

    public void stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }
}
