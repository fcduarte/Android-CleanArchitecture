package com.fernandocejas.android10.sample.data.net;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public interface RouteRestApi {

    Observable<List<RouteEntity>> getRouteEntityList();

}
