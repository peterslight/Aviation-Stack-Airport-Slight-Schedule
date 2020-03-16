package com.peterstev.nc_flightradar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.peterstev.nc_flightradar.databinding.AirportItemBinding;
import com.peterstev.nc_flightradar.models.airport.Airport;

public class DefaultAdapter extends ListAdapter<Airport, DefaultAdapter.DefaultviewHolder> {


    public DefaultAdapter() {
        super(DIFF_CALLBACK);
    }

    private static DiffUtil.ItemCallback<Airport> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Airport>() {
                @Override
                public boolean areItemsTheSame(@NonNull Airport oldItem, @NonNull Airport newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Airport oldItem, @NonNull Airport newItem) {
                    return oldItem.getAirportName().equals(newItem.getAirportName()) && oldItem.getCountryName().equals(newItem.getCountryName())
                            && oldItem.getTimezone().equals(newItem.getTimezone());
                }
            };

    @NonNull
    @Override
    public DefaultviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AirportItemBinding binding = AirportItemBinding.inflate(inflater, parent, false);
        return new DefaultviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultviewHolder holder, int position) {
        Airport airport = getItem(position);
        holder.bindItems(airport);
    }

    static class DefaultviewHolder extends RecyclerView.ViewHolder {
        private AirportItemBinding binding;

        DefaultviewHolder(AirportItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindItems(Airport airport) {
            binding.setAirport(airport);
            binding.executePendingBindings();
        }
    }
}
