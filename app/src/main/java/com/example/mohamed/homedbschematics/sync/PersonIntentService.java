package com.example.mohamed.homedbschematics.sync;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.mohamed.homedbschematics.data.HomeContentProvider;
import com.example.mohamed.homedbschematics.utils.DataUtils;

public class PersonIntentService extends IntentService {

    public static final String ACTION_SYNC = "action-sync";

    public PersonIntentService() {
        super("PersonIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        assert intent != null;
        String action = intent.getAction();

        assert action != null;
        if (action.equals(ACTION_SYNC)) {
            syncData();
        }

    }

    private void syncData() {
        try {
            ContentValues[] values = DataUtils.getFakeData();

            if (values != null && values.length != 0) {

                getContentResolver().delete(
                        HomeContentProvider.Persons.CONTENT_URI_PERSONS,
                        null,
                        null);

                getContentResolver().bulkInsert(
                        HomeContentProvider.Persons.CONTENT_URI_PERSONS,
                        values);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
