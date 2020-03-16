package com.peterstev.nc_flightradar.roomdb;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import static com.peterstev.nc_flightradar.utils.Constants.DATABASE_NAME;

public abstract class AirportDatabase extends RoomDatabase {

    private static AirportDatabase instance;
    public abstract AirportDao airportDao();

    public static synchronized AirportDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AirportDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
