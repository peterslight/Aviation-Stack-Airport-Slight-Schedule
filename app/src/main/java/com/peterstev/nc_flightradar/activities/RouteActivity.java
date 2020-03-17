package com.peterstev.nc_flightradar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.peterstev.nc_flightradar.R;
import com.peterstev.nc_flightradar.adapters.RouteAdapter;
import com.peterstev.nc_flightradar.contracts.RoutesContract;
import com.peterstev.nc_flightradar.databinding.ActivityRouteBinding;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.models.routes.Routes;
import com.peterstev.nc_flightradar.utils.Constants;
import com.peterstev.nc_flightradar.view_models.RoutesViewModel;

import java.util.List;

import static com.peterstev.nc_flightradar.utils.Constants.ARRIVALS_KEY;
import static com.peterstev.nc_flightradar.utils.Constants.ARRIVALS_LAT;
import static com.peterstev.nc_flightradar.utils.Constants.ARRIVALS_LON;
import static com.peterstev.nc_flightradar.utils.Constants.ARRIVALS_NAME;
import static com.peterstev.nc_flightradar.utils.Constants.DEPARTURES_KEY;
import static com.peterstev.nc_flightradar.utils.Constants.DEPARTURE_LAT;
import static com.peterstev.nc_flightradar.utils.Constants.DEPARTURE_LON;
import static com.peterstev.nc_flightradar.utils.Constants.DEPARTURE_NAME;
import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class RouteActivity extends AppCompatActivity implements RoutesContract, RouteAdapter.OnClick {

    private RoutesViewModel viewModel;
    private ActivityRouteBinding binding;
    private RouteAdapter adapter;
    private MaterialCardView dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_route);
        viewModel = new ViewModelProvider(this).get(RoutesViewModel.class);

        setupViews();
        dialog.setVisibility(View.VISIBLE);
        viewModel.requestData(this, depAirport.getIataCode(), arrAirport.getIataCode());
    }

    private Airport depAirport;
    private Airport arrAirport;

    private void setupViews() {
        depAirport = getAirport(Constants.DEPARTURES_KEY);
        arrAirport = getAirport(Constants.ARRIVALS_KEY);

        ImageView backBtn = binding.routeBackKey;
        AppCompatTextView tvDep = binding.routeTvDeparture;
        AppCompatTextView tvArr = binding.routeTvDestination;
        dialog = binding.homeProgress;

        LOGGER(depAirport.getLatitude() + ", " + depAirport.getLongitude());
        LOGGER(arrAirport.getLatitude() + ", " + arrAirport.getLongitude());

        tvDep.setText(depAirport.getAirportName());
        tvArr.setText(arrAirport.getAirportName());
        backBtn.setOnClickListener(v -> onBackPressed());

        RecyclerView recyclerView = binding.routeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new RouteAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    private Airport getAirport(String KEY) {
        return (Airport) getIntent().getSerializableExtra(KEY);
    }

    @Override
    public void onComplete() {
        dialog.setVisibility(View.INVISIBLE);
        List<Routes> routesList = viewModel.getRoutes();
        if (routesList.size() < 1) {
            new AlertDialog.Builder(this, R.style.Theme_MaterialComponents_Dialog)
                    .setMessage("There are no available flights for this route, click okay and select another route.\n\n" +
                            "try searching for Nigeria using the search button on the previous page and select \n\n" +
                            "Dep: Raf Station\n" +
                            "Arr: Nnamdi Azikiwe Intl Airport")
                    .setCancelable(false)
                    .setPositiveButton("Ok", (dialog, which) -> {
                        dialog.dismiss();
                        onBackPressed();
                        this.finish();
                    }).show();
        } else {
            adapter.submitList(routesList);
        }
    }

    @Override
    public void onItemClick(Routes routes) {
        //send to map activity
        startActivity(new Intent(this, PolyActivity.class)
                .putExtra(DEPARTURE_LAT, depAirport.getLatitude())
                .putExtra(DEPARTURE_LON, depAirport.getLongitude())
                .putExtra(DEPARTURE_NAME, depAirport.getAirportName())
                .putExtra(ARRIVALS_LAT, arrAirport.getLatitude())
                .putExtra(ARRIVALS_LON, arrAirport.getLongitude())
                .putExtra(ARRIVALS_NAME, arrAirport.getAirportName()));
    }


}
