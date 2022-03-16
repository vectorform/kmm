// Generated by view binder compiler. Do not edit!
package com.example.kmmshared.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kmmshared.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentJokeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonLoginGetJoke;

  @NonNull
  public final TextView textLoginResult;

  private FragmentJokeBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonLoginGetJoke, @NonNull TextView textLoginResult) {
    this.rootView = rootView;
    this.buttonLoginGetJoke = buttonLoginGetJoke;
    this.textLoginResult = textLoginResult;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentJokeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentJokeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_joke, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentJokeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonLoginGetJoke;
      Button buttonLoginGetJoke = ViewBindings.findChildViewById(rootView, id);
      if (buttonLoginGetJoke == null) {
        break missingId;
      }

      id = R.id.textLoginResult;
      TextView textLoginResult = ViewBindings.findChildViewById(rootView, id);
      if (textLoginResult == null) {
        break missingId;
      }

      return new FragmentJokeBinding((ConstraintLayout) rootView, buttonLoginGetJoke,
          textLoginResult);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
