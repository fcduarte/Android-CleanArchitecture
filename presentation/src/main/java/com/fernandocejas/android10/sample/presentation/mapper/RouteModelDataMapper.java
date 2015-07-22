package com.fernandocejas.android10.sample.presentation.mapper;

import com.fernandocejas.android10.sample.domain.Route;
import com.fernandocejas.android10.sample.domain.User;
import com.fernandocejas.android10.sample.presentation.model.RouteModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteModelDataMapper {

    @Inject
    public RouteModelDataMapper() {
        // no-op
    }

    public Collection<RouteModel> transform(List<Route> routes) {
        Collection<RouteModel> routeModelsCollection;

        if (routes != null && !routes.isEmpty()) {
            routeModelsCollection = new ArrayList<>();
            for (Route route : routes) {
                routeModelsCollection.add(transform(route));
            }
        } else {
            routeModelsCollection = Collections.emptyList();
        }

        return routeModelsCollection;
    }

    private RouteModel transform(Route route) {
        RouteModel routeModel = new RouteModel();
        routeModel.setFullName(String.format("# %s - %s", route.getShortName(), route.getLongName()));
        return routeModel;
    }
}
