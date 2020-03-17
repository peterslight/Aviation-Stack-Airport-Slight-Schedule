package com.peterstev.nc_flightradar.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.peterstev.nc_flightradar.components.AirportComponents;
import com.peterstev.nc_flightradar.components.DaggerAirportComponents;
import com.peterstev.nc_flightradar.databinding.AirportItemBinding;
import com.peterstev.nc_flightradar.models.airport.Airport;

public class AirportAdapter extends ListAdapter<Airport, AirportAdapter.DefaultviewHolder> {

    private OnClick listener;
    public AirportAdapter(OnClick listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static DiffUtil.ItemCallback<Airport> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Airport>() {
                @Override
                public boolean areItemsTheSame(@NonNull Airport oldItem, @NonNull Airport newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Airport oldItem, @NonNull Airport newItem) {
                    return oldItem.getAirportName().equals(newItem.getAirportName()) && oldItem.getTimezone().equals(newItem.getTimezone());
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

    class DefaultviewHolder extends RecyclerView.ViewHolder {
        private AirportItemBinding binding;

        DefaultviewHolder(AirportItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindItems(Airport airport) {
            binding.setAirport(airport);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(v -> listener.onItemClick(airport));
        }
    }

    public interface OnClick {
        void onItemClick(Airport airport);
    }
}
