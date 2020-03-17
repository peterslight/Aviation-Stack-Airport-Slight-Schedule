
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Airline {

    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String name;

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
