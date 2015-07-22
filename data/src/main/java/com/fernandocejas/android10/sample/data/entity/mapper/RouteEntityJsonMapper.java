package com.fernandocejas.android10.sample.data.entity.mapper;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteEntityJsonMapper {

    public List<RouteEntity> transformRouteEntityCollection(String responseRouteEntities) {
        // FIXME mocking response
        List<RouteEntity> routes = new ArrayList<>();
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setId(1);
        routeEntity.setShortName("329");
        routeEntity.setLongName("Northbound Baby Bullet");
        routeEntity.setLastModifiedDate(new Date());

        routes.add(routeEntity);
        return routes;
    }
}
