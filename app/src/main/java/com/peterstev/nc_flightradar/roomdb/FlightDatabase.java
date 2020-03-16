package com.peterstev.nc_flightradar.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.peterstev.nc_flightradar.models.airport.Airport;

import static com.peterstev.nc_flightradar.utils.Constants.DATABASE_NAME;

@Database(entities = Airport.class, version = 1)
public abstract class FlightDatabase extends RoomDatabase {

    private static FlightDatabase instance;
    public abstract AirportDao airportDao();

    public static synchronized FlightDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FlightDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
