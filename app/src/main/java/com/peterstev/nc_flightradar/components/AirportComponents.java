package com.peterstev.nc_flightradar.components;

import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.models.routes.Routes;
import com.peterstev.nc_flightradar.provider_modules.StringProviderModule;

import dagger.Component;

@Component(modules = StringProviderModule.class)
public interface AirportComponents {

    Airport getAirport();

    Routes getRoutes();
}
