package com.peterstev.nc_flightradar.view_models;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.peterstev.nc_flightradar.contracts.RoutesContract;
import com.peterstev.nc_flightradar.interfaces.ApiInterface;
import com.peterstev.nc_flightradar.interfaces.ApiServiceGenerator;
import com.peterstev.nc_flightradar.models.routes.RouteData;
import com.peterstev.nc_flightradar.models.routes.Routes;
import com.peterstev.nc_flightradar.repos.RoutesRepo;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class RoutesViewModel extends AndroidViewModel {

    private List<Routes> routesList;
    private RoutesContract contract;

    public RoutesViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Routes> getRoutes() {
        return routesList;
    }

    public void requestData(Context context, String... data) {
        contract = (RoutesContract) context;
        fetchRemoteData(data[0], data[1]);
    }

    private void fetchRemoteData(String depCode, String arrCode) {
        LOGGER("started.........");
        ApiInterface apiInterface = ApiServiceGenerator.getRetrofit(getApplication());
        Single<RouteData> call = apiInterface.getRoutes(depCode, arrCode);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RouteData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LOGGER("onSubscribe");
                    }

                    @Override
                    public void onSuccess(RouteData routeDataCall) {
                        if (routeDataCall.getData() != null) {
                            routesList = routeDataCall.getData();
                            contract.onComplete();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        LOGGER(e.getMessage());
                        Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
