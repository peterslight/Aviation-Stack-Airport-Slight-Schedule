package com.peterstev.nc_flightradar.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.peterstev.nc_flightradar.contracts.RoutesContract;
import com.peterstev.nc_flightradar.interfaces.ApiInterface;
import com.peterstev.nc_flightradar.interfaces.ApiServiceGenerator;
import com.peterstev.nc_flightradar.models.routes.RouteData;
import com.peterstev.nc_flightradar.models.routes.Routes;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class RoutesRepo {

    private Context appContext;
    private RoutesContract contract;

    public RoutesRepo(Context appContext) {
        this.appContext = appContext.getApplicationContext();
        contract = (RoutesContract) appContext;
    }

    private LiveData<List<Routes>> routes;

    public LiveData<List<Routes>> getRoutes() {
        return routes;
    }

    public void fetchRemoteData(String depCode, String arrCode) {
        LOGGER("started.........");
        ApiInterface apiInterface = ApiServiceGenerator.getRetrofit(appContext);
        Single<RouteData> call = apiInterface.getRoutes(depCode, arrCode);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RouteData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(RouteData routeDataCall) {
                        if (routeDataCall.getData() != null) {
                            LOGGER("size  =  " + routeDataCall.getData().size());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LOGGER(e.getMessage());
                    }
                });


//        call.enqueue(new Callback<RouteData>() {
//            @Override
//            public void onResponse(Call<RouteData> call, Response<RouteData> response) {
//                if (response.isSuccessful())
//                    if (response.body() != null) {
//                        RouteData routeData = response.body();
//                        if (routeData.getData() != null) {
//                            routes = routeData.getData();
//                            contract.onComplete();
//                            LOGGER("data fetched");
//                        }
//                    } else
//                        LOGGER("error occured");
//
//            }
//
//            @Override
//            public void onFailure(Call<RouteData> call, Throwable t) {
//                LOGGER(t.getMessage());
//            }
//        });
    }
}
