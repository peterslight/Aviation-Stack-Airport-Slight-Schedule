
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class Arrival {

    @Expose
    private String actual;
    @SerializedName("actual_runway")
    private String actualRunway;
    @Expose
    private String airport;
    @Expose
    private String baggage;
    @Expose
    private String delay;
    @Expose
    private String estimated;
    @SerializedName("estimated_runway")
    private String estimatedRunway;
    @Expose
    private String gate;
    @Expose
    private String iata;
    @Expose
    private String icao;
    @Expose
    private String scheduled;
    @Expose
    private String terminal;
    @Expose
    private String timezone;

    @Inject
    public Arrival(String actual, String actualRunway, String airport, String baggage, String delay, String estimated, String estimatedRunway, String gate, String iata, String icao, String scheduled, String terminal, String timezone) {
        this.actual = actual;
        this.actualRunway = actualRunway;
        this.airport = airport;
        this.baggage = baggage;
        this.delay = delay;
        this.estimated = estimated;
        this.estimatedRunway = estimatedRunway;
        this.gate = gate;
        this.iata = iata;
        this.icao = icao;
        this.scheduled = scheduled;
        this.terminal = terminal;
        this.timezone = timezone;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getActualRunway() {
        return actualRunway;
    }

    public void setActualRunway(String actualRunway) {
        this.actualRunway = actualRunway;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public String getEstimatedRunway() {
        return estimatedRunway;
    }

    public void setEstimatedRunway(String estimatedRunway) {
        this.estimatedRunway = estimatedRunway;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
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

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
