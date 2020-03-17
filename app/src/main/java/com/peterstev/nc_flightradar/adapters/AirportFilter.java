package com.peterstev.nc_flightradar.adapters;

import android.widget.Filter;

import com.peterstev.nc_flightradar.models.airport.Airport;

import java.util.ArrayList;
import java.util.List;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class AirportFilter extends Filter {

    private List<Airport> airportList;
    private AirportAdapter adapter;

    AirportFilter(List<Airport> list, AirportAdapter adapter) {
        airportList = list;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length() > 0) {
            ArrayList<Airport> airports = new ArrayList<>();
            for (int x = 0; x < airportList.size(); x++) {
                if (airportList.get(x).getAirportName().toLowerCase()
                        .contains(constraint.toString().toLowerCase())) {
                    airports.add(airportList.get(x));
                }
//                if (airportList.get(x).getCountryName().toLowerCase()
//                        .contains(constraint.toString().toLowerCase())
//                        || airportList.get(x).getAirportName().toLowerCase()
//                        .contains(constraint.toString().toLowerCase())) {
//                    airports.add(airportList.get(x));
//                }
            }
            LOGGER("filtered list size = " + airports.size());
            results.count = airports.size();
            results.values = airports;
        } else {
            LOGGER("non filtered list size = " + airportList.size());
            results.count = airportList.size();
            results.values = airportList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
//        adapter.itemList = (List<Airport>) results.values;
//        LOGGER("published list size = " + adapter.itemList.size());
//        adapter.notifyDataSetChanged();

    }
}