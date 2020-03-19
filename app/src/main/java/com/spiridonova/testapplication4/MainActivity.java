package com.spiridonova.testapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.spiridonova.testapplication4.fragments.first.EventListenerActivity;
import com.spiridonova.testapplication4.fragments.first.FirstFragment;
import com.spiridonova.testapplication4.fragments.first.data.NumColor;
import com.spiridonova.testapplication4.fragments.second.SecondFragment;

public class MainActivity extends AppCompatActivity implements EventListenerActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_container, new FirstFragment(), "tag");
            transaction.commit();
        }
        Log.d("activity", "onCreate");
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof FirstFragment) {
            ((FirstFragment) fragment).setEventListenerActivity(this);
        }
    }

    @Override
    public void onNumberSelected(int color, String number, int numberColor) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", new NumColor(number, color,numberColor));
        secondFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container, secondFragment, "tag");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
