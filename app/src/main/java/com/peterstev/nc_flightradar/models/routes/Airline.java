
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;

import javax.inject.Inject;

@SuppressWarnings("unused")
public class Airline {

    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String name;

    @Inject
    public Airline(String iata, String icao, String name) {
        this.iata = iata;
        this.icao = icao;
        this.name = name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
