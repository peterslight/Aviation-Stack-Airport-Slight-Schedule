package com.peterstev.nc_flightradar.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.peterstev.nc_flightradar.R;
import com.peterstev.nc_flightradar.contracts.DefaultFragmentsContract;
import com.peterstev.nc_flightradar.databinding.ActivityMainBinding;
import com.peterstev.nc_flightradar.fragments.ArrivalFragment;
import com.peterstev.nc_flightradar.fragments.Departurefragment;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.view_models.MainViewModel;

import dagger.internal.DaggerCollections;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.peterstev.nc_flightradar.utils.Constants.ARRIVALS_KEY;
import static com.peterstev.nc_flightradar.utils.Constants.DEPARTURES_KEY;
import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class MainActivity extends Base implements DefaultFragmentsContract {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private AppCompatImageView searchBtn;
    private ImageView backBtn;
    private AppCompatEditText etSearch;
    private TextView tvTitle;
    private String searchQuery;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint({"ClickableViewAccessibility", "CheckResult"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        tvTitle = binding.mainTitle;
        backBtn = binding.mainBackKey;
        backBtn.setOnClickListener(v -> onBackPressed());
        tvTitle.setOnClickListener(v -> viewModel.getAllAirPorts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(airports -> LOGGER("database list size = " + airports.size())));

        applyFragment(new Departurefragment(), R.id.main_frame);
    }

    @Override
    public void onBackPressed() {
        tvTitle.setText(R.string.departure);
        backBtn.setVisibility(View.GONE);
        onBackPressedImpl();
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    private Airport depAirport;
    private Airport arrAirport;

    @Override
    public void onDepartureAirportSelected(Airport airport) {
        tvTitle.setText(R.string.arrival);
        backBtn.setVisibility(View.VISIBLE);
        depAirport = airport;
        saveAndGotoNextFragment(new ArrivalFragment());
    }

    @Override
    public void onArrivalAirportSelected(Airport airport) {
        arrAirport = airport;
        startActivity(new Intent(this, RouteActivity.class)
                .putExtra(DEPARTURES_KEY, depAirport)
                .putExtra(ARRIVALS_KEY, arrAirport)
        );
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}