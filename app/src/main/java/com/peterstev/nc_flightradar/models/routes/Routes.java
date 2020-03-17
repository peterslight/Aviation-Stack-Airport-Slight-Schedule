
package com.peterstev.nc_flightradar.models.routes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class Routes {

    @Expose
    private String  aircraft;
    @Expose
    private Airline airline;
    @Expose
    private Arrival arrival;
    @Expose
    private Departure departure;
    @Expose
    private Flight flight;
    @SerializedName("flight_date")
    private String flightDate;
    @SerializedName("flight_status")
    private String flightStatus;
    @Expose
    private String live;
    
    public Routes(){

    }

    @Inject
    public Routes(String  aircraft, Airline airline, Arrival arrival, Departure departure, Flight flight, String flightDate, String flightStatus, String live) {
        this.aircraft = aircraft;
        this.airline = airline;
        this.arrival = arrival;
        this.departure = departure;
        this.flight = flight;
        this.flightDate = flightDate;
        this.flightStatus = flightStatus;
        this.live = live;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

}
