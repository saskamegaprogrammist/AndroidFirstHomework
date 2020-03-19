package com.spiridonova.testapplication4.fragments.first;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.spiridonova.testapplication4.R;

public class FirstFragment extends Fragment {

    private EventListenerActivity activity;

    public void setEventListenerActivity(EventListenerActivity activity) {
        this.activity = activity;
    }

    public EventListenerActivity getEventListenerActivity() {
        return this.activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("fragment", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Log.d("fragment", "onCreateView");

        View mainView = inflater.inflate(R.layout.first_fragment, container, false);
        RecyclerView recyclerView = mainView.findViewById(R.id.list);
        DataAdapterFirst adapter = new DataAdapterFirst(this);
        recyclerView.setAdapter(adapter);

        int spanCount = getResources().getInteger(R.integer.spanCount);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), spanCount);
        recyclerView.setLayoutManager(layoutManager);

        Button buttonMore = mainView.findViewById(R.id.moreButton);
        buttonMore.setOnClickListener(v -> {
            adapter.incrementNumbers();
            adapter.notifyItemInserted(adapter.getItemCount());
        });

        return mainView;
    }
}
