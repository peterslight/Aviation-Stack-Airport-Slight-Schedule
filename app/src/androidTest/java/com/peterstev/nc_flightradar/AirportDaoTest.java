package com.peterstev.nc_flightradar;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;

import com.peterstev.nc_flightradar.components.AirportComponents;
import com.peterstev.nc_flightradar.components.DaggerAirportComponents;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.repos.AirportRepo;
import com.peterstev.nc_flightradar.roomdb.AirportDao;
import com.peterstev.nc_flightradar.roomdb.FlightDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AirportDaoTest {
    private AirportDao dao;
    private FlightDatabase database;
    private List<Airport> testData;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, FlightDatabase.class).build();
        dao = database.airportDao();
        AirportRepo repository = new AirportRepo(context);
//
//        AirportComponents components = DaggerAirportComponents.create();
//        Airport airport = components.getAirport();
//        airport.setAirportName("Lagos Airport");
//        airport.setCountryName("Nigeria");
//
//        Airport air = components.getAirport();
//        air.setAirportName("LAX");
//        air.setCountryName("USA");
//
//        List<Airport> airports = new ArrayList<>();
//        airports.add(airport);
//        airports.add(air);

//        repository.insertAll(airports);
        testData = repository.getAllAirportsTest();
    }

    @Test
    public void testUserExist_corect_true()  {
        assertThat(testData.get(0).getAirportName()).isEqualTo("Lagos Airport");
        assertThat(testData.get(1).getCountryName()).isEqualTo("USA");
    }

    @Test
    public void testUserExist_null_false() {
        assertThat(testData.get(0).getAirportName()).isNotEqualTo(null);
    }

    @Test
    public void testUserExist_empty_false() {
        assertThat(testData.get(0).getAirportName()).isNotEqualTo("");
    }


    @Test
    public void testExist_true(){
        assertThat(testData.get(0).getGeonameId()).isEmpty();
    }

    @Test
    public void testNullUser_null_false()  {
        assertThat(testData.get(0).getGeonameId()).isNotEqualTo(null);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

}
