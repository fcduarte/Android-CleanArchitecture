package com.fernandocejas.android10.sample.data.repository;

import com.fernandocejas.android10.sample.data.entity.mapper.RouteEntityDataMapper;
import com.fernandocejas.android10.sample.data.repository.datasource.RouteDataStore;
import com.fernandocejas.android10.sample.data.repository.datasource.RouteDataStoreFactory;
import com.fernandocejas.android10.sample.domain.Route;
import com.fernandocejas.android10.sample.domain.repository.RouteRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
@Singleton
public class RouteDataRepository implements RouteRepository {

    private final RouteDataStoreFactory routeDataStoreFactory;
    private final RouteEntityDataMapper routeEntityDataMapper;

    @Inject
    public RouteDataRepository(RouteDataStoreFactory routeDataStoreFactory, RouteEntityDataMapper routeEntityDataMapper) {
        this.routeDataStoreFactory = routeDataStoreFactory;
        this.routeEntityDataMapper = routeEntityDataMapper;
    }

    @Override
    public Observable<List<Route>> getRoutes() {
        final RouteDataStore routeDataStore = this.routeDataStoreFactory.createCloudDataStore();
        return routeDataStore.getRouteEntityList().map(routeEntities -> this.routeEntityDataMapper.transform(routeEntities));
    }
}
