package com.peterstev.nc_flightradar.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.roomdb.AirportDao;
import com.peterstev.nc_flightradar.roomdb.FlightDatabase;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AirportRepo {

    private AirportDao airportDao;
    private Flowable<List<Airport>> airportList;

    public AirportRepo(Context appContext) {
        FlightDatabase database = FlightDatabase.getInstance(appContext.getApplicationContext());
        airportDao = database.airportDao();
        airportList = airportDao.getAllAirports();
    }

    public void insert(Airport airport) {
        airportDao.insert(airport)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void insertAll(List<Airport> airports) {
        airportDao.insertAll(airports)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void deleteAllAirports(){
        airportDao.deleteAllAirports()
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public Flowable<List<Airport>> getAllAirports() {
        return airportList;
    }

}
