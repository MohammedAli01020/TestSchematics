package com.example.mohamed.homedbschematics.data;

import android.net.Uri;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;

@ContentProvider(authority = HomeContentProvider.AUTHORITY, database = HomeDatabase.class)
public final class HomeContentProvider {

    static final String AUTHORITY = "com.example.mohamed.homedbschematics";

    @TableEndpoint(table = HomeDatabase.TABLE_PERSONS)
    public static class Persons {

        @ContentUri(
                path = HomeDatabase.TABLE_PERSONS,
                type = "vnd.android.cursor.dir/" + HomeDatabase.TABLE_PERSONS)
        public static final Uri CONTENT_URI_PERSONS = Uri.parse("content://" +
                AUTHORITY + "/" + HomeDatabase.TABLE_PERSONS);
    }
}
