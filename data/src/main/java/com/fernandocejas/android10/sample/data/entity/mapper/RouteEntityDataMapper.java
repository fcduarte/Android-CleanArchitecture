package com.fernandocejas.android10.sample.data.entity.mapper;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import com.fernandocejas.android10.sample.domain.Route;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by felipeduarte on 7/21/15.
 */
@Singleton
public class RouteEntityDataMapper {

    @Inject
    public RouteEntityDataMapper() {
        // no-op
    }

    public List<Route> transform(List<RouteEntity> routeEntities) {
        List<Route> routeList = new ArrayList<>();
        Route route;
        for (RouteEntity routeEntity : routeEntities) {
            route = transform(routeEntity);
            if (route != null) {
                routeList.add(route);
            }
        }

        return routeList;
    }

    private Route transform(RouteEntity routeEntity) {
        Route route = new Route();

        if (routeEntity != null) {
            route.setId(routeEntity.getId());
            route.setShortName(routeEntity.getShortName());
            route.setLongName(routeEntity.getLongName());
            route.setLastModifiedDate(routeEntity.getLastModifiedDate());
        }

        return route;
    }
}
