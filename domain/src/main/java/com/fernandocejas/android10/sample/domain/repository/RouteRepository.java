package com.fernandocejas.android10.sample.domain.repository;

import com.fernandocejas.android10.sample.domain.Route;
import java.util.List;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public interface RouteRepository {

    Observable<List<Route>> getRoutes();

}
