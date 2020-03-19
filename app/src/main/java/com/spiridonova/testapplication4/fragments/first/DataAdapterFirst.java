package com.spiridonova.testapplication4.fragments.first;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.spiridonova.testapplication4.R;
import com.spiridonova.testapplication4.fragments.first.data.NumColor;
import com.spiridonova.testapplication4.fragments.first.data.RandomData;

import java.util.ArrayList;

public class DataAdapterFirst extends RecyclerView.Adapter<ViewHolderFirst> {

    private ArrayList<NumColor> numColors;
    private FirstFragment fragment;

    public DataAdapterFirst(Fragment fragment, ArrayList<NumColor> data) {
        this.fragment = (FirstFragment)fragment;
        this.numColors = data;
    }

    public void incrementNumbers() {
        RandomData.getInstance().increment();
        this.numColors = RandomData.getInstance().getData();
    }

    @NonNull
    @Override
    public ViewHolderFirst onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolderFirst(listItem, this.fragment);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFirst holder, int position) {
        TextView numberView = holder.getNumberView();
        NumColor numColor = numColors.get(position);
        numberView.setText(numColor.getNumber());
        numberView.setBackgroundColor(numColor.getColor());
        numberView.setTextColor(numColor.getNumberColor());
    }

    @Override
    public int getItemCount() {
        return numColors.size();
    }


}
