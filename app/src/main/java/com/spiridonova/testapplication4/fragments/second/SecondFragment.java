package com.spiridonova.testapplication4.fragments.second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spiridonova.testapplication4.R;
import com.spiridonova.testapplication4.fragments.first.DataAdapterFirst;
import com.spiridonova.testapplication4.fragments.first.data.NumColor;

public class SecondFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.second_fragment, container, false);
        TextView textView = mainView.findViewById(R.id.number);
        Bundle arguments = this.getArguments();
        NumColor numColor = (NumColor) arguments.getSerializable("data");
        textView.setBackgroundColor(numColor.getColor());
        textView.setText(numColor.getNumber());
        textView.setTextColor(numColor.getNumberColor());
        return mainView;
    }
}
