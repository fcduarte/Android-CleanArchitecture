package com.fernandocejas.android10.sample.data.net;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import com.fernandocejas.android10.sample.data.entity.mapper.RouteEntityJsonMapper;
import com.fernandocejas.android10.sample.data.exception.NetworkConnectionException;
import java.net.MalformedURLException;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteRestApiImpl implements RouteRestApi {

    private final RouteEntityJsonMapper routeEntityJsonMapper;

    public RouteRestApiImpl(RouteEntityJsonMapper routeEntityJsonMapper) {
        this.routeEntityJsonMapper = routeEntityJsonMapper;
    }

    @Override
    public Observable<List<RouteEntity>> getRouteEntityList() {
        return Observable.create(new Observable.OnSubscribe<List<RouteEntity>>() {
            @Override
            public void call(Subscriber<? super List<RouteEntity>> subscriber) {

                if (isThereInternetConnection()) {
                    try {
                        String responseRouteEntities = getRouteEntitiesFromApi();
                        if (responseRouteEntities != null) {
                            subscriber.onNext(routeEntityJsonMapper.transformRouteEntityCollection(responseRouteEntities));
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new NetworkConnectionException());
                        }
                    } catch (Exception e) {
                        subscriber.onError(new NetworkConnectionException(e.getCause()));
                    }
                } else {
                    subscriber.onError(new NetworkConnectionException());
                }
            }
        });
    }

    private String getRouteEntitiesFromApi() throws MalformedURLException {
        // FIXME mocking server response
        return "[{ id: 1, shortName: \"test\" }]";
    }

    private boolean isThereInternetConnection() {
        // FIXME mock
        return true;
    }
}
