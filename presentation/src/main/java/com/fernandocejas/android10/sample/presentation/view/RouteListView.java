/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.presentation.view;

import com.fernandocejas.android10.sample.presentation.model.RouteModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import com.fernandocejas.android10.sample.presentation.view.LoadDataView;
import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link UserModel}.
 */
public interface RouteListView extends LoadDataView {
    /**
     * Render a route list in the UI.
     *
     * @param routeModelCollection The collection of {@link RouteModel} that will be shown.
     */
    void renderRouteList(Collection<RouteModel> routeModelCollection);

}
