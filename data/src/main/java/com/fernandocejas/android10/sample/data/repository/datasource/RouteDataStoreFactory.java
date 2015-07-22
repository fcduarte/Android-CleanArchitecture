package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.net.RouteRestService;
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
        RouteRestService restApi = new RouteRestService();
        return new CloudRouteDataStore(restApi);
    }


}
