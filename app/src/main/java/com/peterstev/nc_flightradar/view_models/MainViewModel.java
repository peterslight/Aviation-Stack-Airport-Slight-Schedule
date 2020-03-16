package com.peterstev.nc_flightradar.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.peterstev.nc_flightradar.interfaces.ApiInterface;
import com.peterstev.nc_flightradar.interfaces.ApiServiceGenerator;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.models.airport.Data;
import com.peterstev.nc_flightradar.repos.AirportRepo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class MainViewModel extends AndroidViewModel {

    private AirportRepo repository;
    private Flowable<List<Airport>> airportList;
    private Application application;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
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

    public Flowable<List<Airport>> getAllAirPorts() {
        return airportList;
    }

    public void fetchRemoteData() {
        LOGGER("started.........");
        ApiInterface apiInterface = ApiServiceGenerator.getRetrofit(application);
        Call<Data> call = apiInterface.getAirports(0);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful())
                    if (response.body() != null) {
                        Data data = response.body();
                        if (data.getData() != null) {
//                            insertAll(data.getData());
                            LOGGER("data inserted");
                        }
                    } else
                        LOGGER("error occured");
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                LOGGER(t.getMessage());
            }
        });
    }
}
