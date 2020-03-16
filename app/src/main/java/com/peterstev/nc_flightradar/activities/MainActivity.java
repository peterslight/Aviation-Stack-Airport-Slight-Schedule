package com.peterstev.nc_flightradar.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.peterstev.nc_flightradar.R;
import com.peterstev.nc_flightradar.databinding.ActivityMainBinding;
import com.peterstev.nc_flightradar.fragment_contracts.DefaultFragmentsContract;
import com.peterstev.nc_flightradar.fragments.Defaultfragment;
import com.peterstev.nc_flightradar.view_models.MainViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.peterstev.nc_flightradar.utils.Constants.LOGGER;

public class MainActivity extends Base implements DefaultFragmentsContract.Departure {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        AppCompatImageView searchBtn = binding.mainSearch;
        AppCompatEditText etSearch = binding.mainEtSearch;
        TextView tvTitle = binding.mainTitle;
        searchBtn.setOnClickListener(v -> {
            etSearch.setVisibility(View.VISIBLE);
            searchBtn.setVisibility(View.INVISIBLE);
            tvTitle.setVisibility(View.INVISIBLE);
        });

        applyFragment(new Defaultfragment(), R.id.main_frame);
    }

    private void showSearchBar(){
//        etSearch.setVisibility(View.VISIBLE);
//        searchBtn.setVisibility(View.INVISIBLE);
//        tvTitle.setVisibility(View.INVISIBLE);
    }
    private void hideSearchBar(){

    }

    @Override
    public void onBackPressed() {
        onBackPressedImpl();
    }

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

//    viewModel.getAllAirPorts()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(airports -> LOGGER("database list size = " + airports.size()))

//    editComment.setOnTouchListener(new OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            final int DRAWABLE_LEFT = 0;
//            final int DRAWABLE_TOP = 1;
//            final int DRAWABLE_RIGHT = 2;
//            final int DRAWABLE_BOTTOM = 3;
//
//            if(event.getAction() == MotionEvent.ACTION_UP) {
//                if(event.getRawX() >= (editComment.getRight() - editComment.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
//                    // your action here
//
//                    return true;
//                }
//            }
//            return false;
//        }
//    });


}