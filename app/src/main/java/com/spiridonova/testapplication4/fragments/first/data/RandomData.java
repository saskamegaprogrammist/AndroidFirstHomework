package com.spiridonova.testapplication4.fragments.first.data;
import android.graphics.Color;

import com.spiridonova.testapplication4.R;

import java.util.ArrayList;
import java.util.Random;

public class RandomData {
    private ArrayList<NumColor> dataList;
    private static RandomData selfInstance;
    private Random random = new Random();

    public RandomData(){
        dataList = new ArrayList<>();
        for (int i=1; i < Constants.listSize; i++) {
            dataList.add(new NumColor(String.valueOf(i), random.nextInt(), getTextColor(i)));
        }
    }

    private int getTextColor(int i) {
        switch (i % 2) {
            case 0:
                return Color.parseColor(Constants.redColor);
            case 1:
                return Color.parseColor(Constants.blueColor);
        }
        return 0;
    }

    public void increment() {
        int i = dataList.size()+1;
        dataList.add(new NumColor(String.valueOf(dataList.size()+1), random.nextInt(), getTextColor(i)));
    }
    public ArrayList<NumColor> getData() {
        return dataList;
    }
    public synchronized static RandomData getInstance() {
        if (selfInstance == null) {
            selfInstance = new RandomData();
        }
        return selfInstance;
    }

    public void setData(ArrayList<NumColor> dataList) {
        this.dataList = dataList;
    }

}
