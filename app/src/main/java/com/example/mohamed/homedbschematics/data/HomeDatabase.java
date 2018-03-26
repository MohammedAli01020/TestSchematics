package com.example.mohamed.homedbschematics.data;


import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

@Database(version = HomeDatabase.DATABASE_VERSION)
final class HomeDatabase {
    static final int DATABASE_VERSION = 1;

    @Table(HomeContract.PersonEntry.class)
    static final String TABLE_PERSONS = "persons";
}
