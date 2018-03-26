package com.example.mohamed.homedbschematics.data;

import android.provider.BaseColumns;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.NotNull;
import net.simonvt.schematic.annotation.PrimaryKey;

public final class HomeContract {

    private HomeContract() {}

    public static class PersonEntry implements BaseColumns {
        @DataType(DataType.Type.INTEGER)
        @PrimaryKey
        @AutoIncrement
        public static final String _ID = BaseColumns._ID;

        @DataType(DataType.Type.TEXT)
        @NotNull
        public static final String COLUMN_NAME = "name";
    }
}
