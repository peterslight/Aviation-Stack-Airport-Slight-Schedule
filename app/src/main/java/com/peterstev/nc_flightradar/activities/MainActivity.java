package com.peterstev.nc_flightradar.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.peterstev.nc_flightradar.R;
import com.peterstev.nc_flightradar.databinding.ActivityMainBinding;
import com.peterstev.nc_flightradar.fragment_contracts.DefaultFragmentsContract;
import com.peterstev.nc_flightradar.fragments.ArrivalFragment;
import com.peterstev.nc_flightradar.fragments.Departurefragment;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.view_models.MainViewModel;

import java.util.List;

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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint({"ClickableViewAccessibility", "CheckResult"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        searchBtn = binding.mainSearch;
        etSearch = binding.mainEtSearch;
        tvTitle = binding.mainTitle;
        backBtn = binding.mainBackKey;
        backBtn.setOnClickListener(v -> onBackPressed());
        searchBtn.setOnClickListener(v -> {
            showSearchBar();
//            new CountDownTimer(3000, 1000) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//                }
//
//                @Override
//                public void onFinish() {
//                    hideSearchBar();
//                }
//            }.start();
        });


        tvTitle.setOnClickListener(v -> viewModel.getAllAirPorts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(airports -> LOGGER("database list size = " + airports.size())));

        etSearch.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (event.getRawX() >= (etSearch.getRight() - etSearch.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    hideSearchBar();
                    return true;
                }
            }
            return false;
        });


        applyFragment(new Departurefragment(), R.id.main_frame);
    }

    private void showSearchBar() {
        etSearch.setVisibility(View.VISIBLE);
        searchBtn.setVisibility(View.INVISIBLE);
        tvTitle.setVisibility(View.INVISIBLE);
    }

    private void hideSearchBar() {
        etSearch.setVisibility(View.INVISIBLE);
        searchBtn.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
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

    @Override
    public void onDepartureAirportSelected(Airport airport) {
        tvTitle.setText(R.string.arrival);
        backBtn.setVisibility(View.VISIBLE);
        hideSearchBar();
        addAirportItem(airport);
        saveAndGotoNextFragment(new ArrivalFragment());
    }

    @Override
    public void onArrivalAirportSelected(Airport airport) {
        addAirportItem(airport);
        List<Airport> selectedItems = getSelectedItems();
        startActivity(new Intent(this, RouteActivity.class)
                .putExtra(DEPARTURES_KEY, selectedItems.get(0))
                .putExtra(ARRIVALS_KEY, selectedItems.get(1))
        );
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onComplete() {

    }
}