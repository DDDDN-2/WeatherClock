// Generated by view binder compiler. Do not edit!
package com.weather.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.weather.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAlarmSettingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnSave;

  @NonNull
  public final Chip chipFriday;

  @NonNull
  public final ChipGroup chipGroupWeekdays;

  @NonNull
  public final Chip chipMonday;

  @NonNull
  public final Chip chipSaturday;

  @NonNull
  public final Chip chipSunday;

  @NonNull
  public final Chip chipThursday;

  @NonNull
  public final Chip chipTuesday;

  @NonNull
  public final Chip chipWednesday;

  @NonNull
  public final TextInputEditText etLabel;

  @NonNull
  public final TextInputLayout labelInputLayout;

  @NonNull
  public final MaterialCardView repeatCard;

  @NonNull
  public final TimePicker timePicker;

  @NonNull
  public final MaterialToolbar toolbar;

  private FragmentAlarmSettingBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnSave, @NonNull Chip chipFriday,
      @NonNull ChipGroup chipGroupWeekdays, @NonNull Chip chipMonday, @NonNull Chip chipSaturday,
      @NonNull Chip chipSunday, @NonNull Chip chipThursday, @NonNull Chip chipTuesday,
      @NonNull Chip chipWednesday, @NonNull TextInputEditText etLabel,
      @NonNull TextInputLayout labelInputLayout, @NonNull MaterialCardView repeatCard,
      @NonNull TimePicker timePicker, @NonNull MaterialToolbar toolbar) {
    this.rootView = rootView;
    this.btnSave = btnSave;
    this.chipFriday = chipFriday;
    this.chipGroupWeekdays = chipGroupWeekdays;
    this.chipMonday = chipMonday;
    this.chipSaturday = chipSaturday;
    this.chipSunday = chipSunday;
    this.chipThursday = chipThursday;
    this.chipTuesday = chipTuesday;
    this.chipWednesday = chipWednesday;
    this.etLabel = etLabel;
    this.labelInputLayout = labelInputLayout;
    this.repeatCard = repeatCard;
    this.timePicker = timePicker;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAlarmSettingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAlarmSettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_alarm_setting, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAlarmSettingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSave;
      MaterialButton btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.chipFriday;
      Chip chipFriday = ViewBindings.findChildViewById(rootView, id);
      if (chipFriday == null) {
        break missingId;
      }

      id = R.id.chipGroupWeekdays;
      ChipGroup chipGroupWeekdays = ViewBindings.findChildViewById(rootView, id);
      if (chipGroupWeekdays == null) {
        break missingId;
      }

      id = R.id.chipMonday;
      Chip chipMonday = ViewBindings.findChildViewById(rootView, id);
      if (chipMonday == null) {
        break missingId;
      }

      id = R.id.chipSaturday;
      Chip chipSaturday = ViewBindings.findChildViewById(rootView, id);
      if (chipSaturday == null) {
        break missingId;
      }

      id = R.id.chipSunday;
      Chip chipSunday = ViewBindings.findChildViewById(rootView, id);
      if (chipSunday == null) {
        break missingId;
      }

      id = R.id.chipThursday;
      Chip chipThursday = ViewBindings.findChildViewById(rootView, id);
      if (chipThursday == null) {
        break missingId;
      }

      id = R.id.chipTuesday;
      Chip chipTuesday = ViewBindings.findChildViewById(rootView, id);
      if (chipTuesday == null) {
        break missingId;
      }

      id = R.id.chipWednesday;
      Chip chipWednesday = ViewBindings.findChildViewById(rootView, id);
      if (chipWednesday == null) {
        break missingId;
      }

      id = R.id.etLabel;
      TextInputEditText etLabel = ViewBindings.findChildViewById(rootView, id);
      if (etLabel == null) {
        break missingId;
      }

      id = R.id.labelInputLayout;
      TextInputLayout labelInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (labelInputLayout == null) {
        break missingId;
      }

      id = R.id.repeatCard;
      MaterialCardView repeatCard = ViewBindings.findChildViewById(rootView, id);
      if (repeatCard == null) {
        break missingId;
      }

      id = R.id.timePicker;
      TimePicker timePicker = ViewBindings.findChildViewById(rootView, id);
      if (timePicker == null) {
        break missingId;
      }

      id = R.id.toolbar;
      MaterialToolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FragmentAlarmSettingBinding((ConstraintLayout) rootView, btnSave, chipFriday,
          chipGroupWeekdays, chipMonday, chipSaturday, chipSunday, chipThursday, chipTuesday,
          chipWednesday, etLabel, labelInputLayout, repeatCard, timePicker, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
