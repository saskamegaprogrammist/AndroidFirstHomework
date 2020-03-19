package com.spiridonova.testapplication4.fragments.first;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.spiridonova.testapplication4.MainActivity;
import com.spiridonova.testapplication4.R;

public class ViewHolderFirst extends RecyclerView.ViewHolder  {

    private TextView numberView;
    public ViewHolderFirst(@NonNull View itemView, Fragment fragment) {
        super(itemView);
        numberView = itemView.findViewById(R.id.number);
        numberView.setOnClickListener(v-> {
            ColorDrawable viewColor = (ColorDrawable) numberView.getBackground();
            int colorId = viewColor.getColor();
            String numberText = numberView.getText().toString();
            int numberTextColor = numberView.getCurrentTextColor();
            ((FirstFragment)fragment).getEventListenerActivity().onNumberSelected(colorId, numberText, numberTextColor);
        });
    }
    public TextView getNumberView() {
        return numberView;
    }

}
