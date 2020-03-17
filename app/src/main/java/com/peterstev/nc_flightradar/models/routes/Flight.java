
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;

public class Flight {

    @Expose
    private Object codeshared;
    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String number;

    public Object getCodeshared() {
        return codeshared;
    }

    public void setCodeshared(Object codeshared) {
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
