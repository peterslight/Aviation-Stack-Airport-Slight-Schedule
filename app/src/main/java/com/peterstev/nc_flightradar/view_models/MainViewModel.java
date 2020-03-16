package com.peterstev.nc_flightradar.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.repos.AirportRepo;

import java.util.List;

import io.reactivex.Flowable;

public class MainViewModel extends AndroidViewModel {

    private AirportRepo repository;
    private Flowable<List<Airport>> airportList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new AirportRepo(application);
        airportList = repository.getAllAirports();
    }

    public void insert(Airport airport) {
        repository.insert(airport);
    }
    public void insertAll(List<Airport> airports) {
        repository.insertAll(airports);
    }

    public void deleteAll() {
        repository.deleteAllAirports();
    }

    public Flowable<List<Airport>> getAllAirPorts(){
        return airportList;
    }
}
