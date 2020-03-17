
package com.peterstev.nc_flightradar.models.airport;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Data {

    @Expose
    private List<Airport> data;
    @Expose
    private Pagination pagination;

    public List<Airport> getData() {
        return data;
    }

    public void setData(List<Airport> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
