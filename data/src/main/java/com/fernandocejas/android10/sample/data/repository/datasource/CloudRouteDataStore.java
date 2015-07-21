package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import com.fernandocejas.android10.sample.data.net.RouteRestApi;
import java.util.List;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class CloudRouteDataStore implements RouteDataStore {

    private final RouteRestApi routeRestApi;

    public CloudRouteDataStore(RouteRestApi restApi) {
        this.routeRestApi = restApi;
    }

    @Override
    public Observable<List<RouteEntity>> getRouteEntityList() {
        return routeRestApi.getRouteEntityList();
    }
}
