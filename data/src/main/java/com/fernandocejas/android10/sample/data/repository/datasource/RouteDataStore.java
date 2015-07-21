package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public interface RouteDataStore {

    Observable<List<RouteEntity>> getRouteEntityList();
}
