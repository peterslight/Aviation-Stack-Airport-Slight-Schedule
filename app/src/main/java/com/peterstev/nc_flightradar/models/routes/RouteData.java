
package com.peterstev.nc_flightradar.models.routes;

import java.util.List;
import com.google.gson.annotations.Expose;


public class RouteData {

    @Expose
    private List<Routes> data;
    @Expose
    private Pagination pagination;

    public List<Routes> getData() {
        return data;
    }

    public void setData(List<Routes> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
