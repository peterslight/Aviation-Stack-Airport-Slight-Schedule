package com.peterstev.nc_flightradar.contracts;

import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.view_models.MainViewModel;

public interface DefaultFragmentsContract {

    MainViewModel getViewModel();

    void onDepartureAirportSelected(Airport airport);

    void onArrivalAirportSelected(Airport airport);
}