package com.peterstev.nc_flightradar.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.peterstev.nc_flightradar.interfaces.ApiInterface;
import com.peterstev.nc_flightradar.interfaces.ApiServiceGenerator;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.models.airport.Data;
import com.peterstev.nc_flightradar.roomdb.AirportDao;
import com.peterstev.nc_flightradar.roomdb.FlightDatabase;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class AirportRepo {

    private AirportDao airportDao;
    private Flowable<List<Airport>> airportList;
    private Context appContext;

    public AirportRepo(Context appContext) {
        this.appContext = appContext.getApplicationContext();
        FlightDatabase database = FlightDatabase.getInstance(this.appContext);
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

    public void deleteAllAirports() {
        airportDao.deleteAllAirports()
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public Flowable<List<Airport>> getAllAirports() {
        return airportList;
    }


    public void fetchRemoteData() {
        LOGGER("started.........");
        ApiInterface apiInterface = ApiServiceGenerator.getRetrofit(appContext);
        Call<Data> call = apiInterface.getAirports(0);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful())
                    if (response.body() != null) {
                        Data data = response.body();
                        if (data.getData() != null) {
                            insertAll(data.getData());
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
