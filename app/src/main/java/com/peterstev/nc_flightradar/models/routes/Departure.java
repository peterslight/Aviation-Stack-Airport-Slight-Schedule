
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Departure {

    @Expose
    private Object actual;
    @SerializedName("actual_runway")
    private Object actualRunway;
    @Expose
    private String airport;
    @Expose
    private Object delay;
    @Expose
    private String estimated;
    @SerializedName("estimated_runway")
    private Object estimatedRunway;
    @Expose
    private Object gate;
    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String scheduled;
    @Expose
    private Object terminal;
    @Expose
    private String timezone;

    public Object getActual() {
        return actual;
    }

    public void setActual(Object actual) {
        this.actual = actual;
    }

    public Object getActualRunway() {
        return actualRunway;
    }

    public void setActualRunway(Object actualRunway) {
        this.actualRunway = actualRunway;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Object getDelay() {
        return delay;
    }

    public void setDelay(Object delay) {
        this.delay = delay;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public Object getEstimatedRunway() {
        return estimatedRunway;
    }

    public void setEstimatedRunway(Object estimatedRunway) {
        this.estimatedRunway = estimatedRunway;
    }

    public Object getGate() {
        return gate;
    }

    public void setGate(Object gate) {
        this.gate = gate;
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

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public Object getTerminal() {
        return terminal;
    }

    public void setTerminal(Object terminal) {
        this.terminal = terminal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
