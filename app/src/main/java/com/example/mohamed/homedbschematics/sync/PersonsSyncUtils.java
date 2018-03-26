package com.example.mohamed.homedbschematics.sync;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;

import com.example.mohamed.homedbschematics.data.HomeContentProvider.Persons;

public final class PersonsSyncUtils {
    private static boolean sInitialized;

    @SuppressLint("StaticFieldLeak")
    public static void initialize(final Context context) {

        if (sInitialized) return;
        sInitialized = true;

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Cursor cursor = context.getContentResolver().query(
                        Persons.CONTENT_URI_PERSONS,
                        null,
                        null,
                        null,
                        null);

                if (null == cursor || cursor.getCount() == 0) {
                    Intent intent = new Intent(context, PersonIntentService.class);
                    intent.setAction(PersonIntentService.ACTION_SYNC);
                    context.startService(intent);
                }

                assert cursor != null;
                cursor.close();
                return null;
            }
        }.execute();
    }
}
