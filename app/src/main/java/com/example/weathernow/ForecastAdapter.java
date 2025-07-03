package com.example.weathernow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private final List<ForecastData> forecastList;

    public ForecastAdapter(List<ForecastData> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        ForecastData item = forecastList.get(position);

        String dateTime = item.getDtTxt();
        String iconCode = item.getWeather().get(0).getIcon();
        String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";

        // Convert to 24-hour format
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM, HH:mm", Locale.getDefault());

        try {
            Date date = inputFormat.parse(dateTime);
            holder.dateText.setText(outputFormat.format(date));
        } catch (Exception e) {
            holder.dateText.setText(dateTime);
        }

        holder.tempText.setText(String.format(Locale.getDefault(), "%.0f°C", item.getMain().getTemp()));
        holder.descriptionText.setText(item.getWeather().get(0).getDescription());
        Glide.with(holder.itemView.getContext()).load(iconUrl).into(holder.weatherIcon);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView dateText, tempText, descriptionText;
        ImageView weatherIcon;

        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            tempText = itemView.findViewById(R.id.tempText);
            descriptionText = itemView.findViewById(R.id.descriptionText);
            weatherIcon = itemView.findViewById(R.id.weatherIcon);
        }
    }
}
