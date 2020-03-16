package com.peterstev.nc_flightradar.fragment_contracts;

import com.peterstev.nc_flightradar.view_models.MainViewModel;

public interface DefaultFragmentsContract {

    interface Departure{
        MainViewModel getViewModel();
    }
}
