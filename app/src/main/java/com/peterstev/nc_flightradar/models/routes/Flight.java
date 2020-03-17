
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;

import javax.inject.Inject;

public class Flight {

    @Expose
    private String codeshared;
    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String number;

    @Inject
    public Flight(String codeshared, String iata, String icao, String number) {
        this.codeshared = codeshared;
        this.iata = iata;
        this.icao = icao;
        this.number = number;
    }

    public String getCodeshared() {
        return codeshared;
    }

    public void setCodeshared(String codeshared) {
        this.codeshared = codeshared;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
