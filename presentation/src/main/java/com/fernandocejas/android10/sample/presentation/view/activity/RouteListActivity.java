package com.fernandocejas.android10.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.HasComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.DaggerRouteComponent;
import com.fernandocejas.android10.sample.presentation.internal.di.components.RouteComponent;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteListActivity extends BaseActivity implements HasComponent<RouteComponent> {

    private RouteComponent routeComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, RouteListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);

        this.initializeInjector();
    }

    private void initializeInjector() {
        this.routeComponent = DaggerRouteComponent.builder().applicationComponent(getApplicationComponent()).activityModule(getActivityModule()).build();
    }

    @Override
    public RouteComponent getComponent() {
        return routeComponent;
    }
}
