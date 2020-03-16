package com.peterstev.nc_flightradar.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.peterstev.nc_flightradar.models.airport.Airport;

import java.util.List;

@Dao
public interface AirportDao {
    @Insert
    void insert(Airport airport);

    @Query("DELETE FROM airport_table")
    void deleteAllAirports();

    @Query("SELECT * FROM airport_table ORDER BY id DESC")
    LiveData<List<Airport>> getAllAirports();
}
