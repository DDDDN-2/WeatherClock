// Generated by view binder compiler. Do not edit!
package com.weather.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.weather.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView rvForecast;

  @NonNull
  public final TextView tvCurrentTime;

  @NonNull
  public final TextView tvLocation;

  @NonNull
  public final TextView tvTemperature;

  @NonNull
  public final TextView tvWeatherDescription;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull RecyclerView rvForecast,
      @NonNull TextView tvCurrentTime, @NonNull TextView tvLocation,
      @NonNull TextView tvTemperature, @NonNull TextView tvWeatherDescription) {
    this.rootView = rootView;
    this.rvForecast = rvForecast;
    this.tvCurrentTime = tvCurrentTime;
    this.tvLocation = tvLocation;
    this.tvTemperature = tvTemperature;
    this.tvWeatherDescription = tvWeatherDescription;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rvForecast;
      RecyclerView rvForecast = ViewBindings.findChildViewById(rootView, id);
      if (rvForecast == null) {
        break missingId;
      }

      id = R.id.tvCurrentTime;
      TextView tvCurrentTime = ViewBindings.findChildViewById(rootView, id);
      if (tvCurrentTime == null) {
        break missingId;
      }

      id = R.id.tvLocation;
      TextView tvLocation = ViewBindings.findChildViewById(rootView, id);
      if (tvLocation == null) {
        break missingId;
      }

      id = R.id.tvTemperature;
      TextView tvTemperature = ViewBindings.findChildViewById(rootView, id);
      if (tvTemperature == null) {
        break missingId;
      }

      id = R.id.tvWeatherDescription;
      TextView tvWeatherDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvWeatherDescription == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, rvForecast, tvCurrentTime,
          tvLocation, tvTemperature, tvWeatherDescription);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}