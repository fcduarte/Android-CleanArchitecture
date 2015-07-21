package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.entity.mapper.RouteEntityJsonMapper;
import com.fernandocejas.android10.sample.data.net.RouteRestApi;
import com.fernandocejas.android10.sample.data.net.RouteRestApiImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by felipeduarte on 7/21/15.
 */
@Singleton
public class RouteDataStoreFactory {

    @Inject
    public RouteDataStoreFactory() {
        // no-op
    }

    public RouteDataStore createCloudDataStore() {
        // FIXME injection?
        RouteEntityJsonMapper routeEntityJsonMapper = new RouteEntityJsonMapper();
        RouteRestApi restApi = new RouteRestApiImpl(routeEntityJsonMapper);

        return new CloudRouteDataStore(restApi);
    }


}
