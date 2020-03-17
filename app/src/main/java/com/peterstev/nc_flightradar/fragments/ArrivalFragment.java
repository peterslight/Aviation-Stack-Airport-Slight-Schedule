package com.peterstev.nc_flightradar.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.peterstev.nc_flightradar.adapters.DefaultAdapter;
import com.peterstev.nc_flightradar.databinding.DefaultFragmentBinding;
import com.peterstev.nc_flightradar.fragment_contracts.DefaultFragmentsContract;
import com.peterstev.nc_flightradar.models.airport.Airport;
import com.peterstev.nc_flightradar.view_models.MainViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class ArrivalFragment extends Fragment implements DefaultAdapter.OnClick {

    private DefaultFragmentBinding binding;
    private Context context;
    private DefaultFragmentsContract departureContract;
    private MainViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            departureContract = (DefaultFragmentsContract) context;
        } catch (ClassCastException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        binding = DefaultFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = binding.mainRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        DefaultAdapter adapter = new DefaultAdapter(this);
        recyclerView.setAdapter(adapter);
        viewModel = departureContract.getViewModel();
        viewModel.getAllAirPorts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::submitList);
    }


    @Override
    public void onItemClick(Airport airport) {
        departureContract.onArrivalAirportSelected(airport);
    }
}
