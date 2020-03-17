package com.peterstev.nc_flightradar.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.peterstev.nc_flightradar.models.airport.Airport;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface AirportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Airport airport);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<Airport> airport);

    @Query("DELETE FROM airport_table")
    Completable deleteAllAirports();

    @Query("SELECT * FROM airport_table ORDER BY id ASC")
    Flowable<List<Airport>> getAllAirports();

    @Query("SELECT * FROM airport_table ORDER BY id ASC")
    List<Airport> getAllAirportsTest();
}
