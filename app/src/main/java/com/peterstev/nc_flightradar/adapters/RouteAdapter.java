package com.peterstev.nc_flightradar.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.peterstev.nc_flightradar.databinding.RoutesItemBinding;
import com.peterstev.nc_flightradar.models.routes.Routes;

public class RouteAdapter extends ListAdapter<Routes, RouteAdapter.RoutesViewHolder> {

    private OnClick listener;

    public RouteAdapter(OnClick listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static DiffUtil.ItemCallback<Routes> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Routes>() {
                @Override
                public boolean areItemsTheSame(@NonNull Routes oldItem, @NonNull Routes newItem) {
                    return false;

                }

                @Override
                public boolean areContentsTheSame(@NonNull Routes oldItem, @NonNull Routes newItem) {
                    return false;
                }
            };

    @NonNull
    @Override
    public RoutesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RoutesItemBinding binding = RoutesItemBinding.inflate(inflater, parent, false);
        return new RoutesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RoutesViewHolder holder, int position) {
        Routes routes = getItem(position);
        holder.bindItems(routes);
    }

    class RoutesViewHolder extends RecyclerView.ViewHolder {
        private RoutesItemBinding binding;

        RoutesViewHolder(RoutesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindItems(Routes routes) {
            binding.setRoute(routes);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(v -> listener.onItemClick(routes));
        }
    }

    public interface OnClick {
        void onItemClick(Routes routes);
    }
}
