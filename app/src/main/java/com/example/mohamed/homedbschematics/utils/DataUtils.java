package com.example.mohamed.homedbschematics.utils;


import android.content.ContentValues;

import com.example.mohamed.homedbschematics.data.HomeContract;

public final class DataUtils {

    public static ContentValues[] getFakeData() {

        ContentValues[] values = new ContentValues[10];

        for (int i = 0; i < values.length; i++) {
            ContentValues currentValues = new ContentValues();
            currentValues.put(HomeContract.PersonEntry.COLUMN_NAME, "Name " + (i+ 1));
            values[i] =currentValues;
        }

        return values;
    }
}

