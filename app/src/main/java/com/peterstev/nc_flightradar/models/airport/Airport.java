
package com.peterstev.nc_flightradar.models.airport;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.inject.Inject;

import static com.peterstev.nc_flightradar.utils.Constants.AIRPORT_TABLE;

@Entity(tableName = AIRPORT_TABLE, indices = {@Index(value = {"airportName", "timezone"},
        unique = true)})
public class Airport implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("airport_name")
    private String airportName;
    @SerializedName("country_name")
    private String countryName;
    @Expose
    private String timezone;
    @Expose
    private String latitude;
    @Expose
    private String longitude;

    @SerializedName("city_iata_code")
    private String cityIataCode;
    @SerializedName("country_iso2")
    private String countryIso2;

    @SerializedName("geoname_id")
    private String geonameId;
    @Expose
    private String gmt;
    @SerializedName("iata_code")
    private String iataCode;
    @SerializedName("icao_code")
    private String icaoCode;

    @SerializedName("phone_number")
    private String phoneNumber;

    public Airport(){

    }

    @Inject
    public Airport(String airportName, String countryName, String timezone, String latitude, String longitude, String cityIataCode, String countryIso2, String geonameId, String gmt, String iataCode, String icaoCode, String phoneNumber) {
        this.airportName = airportName;
        this.countryName = countryName;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityIataCode = cityIataCode;
        this.countryIso2 = countryIso2;
        this.geonameId = geonameId;
        this.gmt = gmt;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.phoneNumber = phoneNumber;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCityIataCode() {
        return cityIataCode;
    }

    public void setCityIataCode(String cityIataCode) {
        this.cityIataCode = cityIataCode;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportName='" + airportName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", timezone='" + timezone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
