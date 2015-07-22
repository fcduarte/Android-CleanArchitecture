package com.fernandocejas.android10.sample.presentation.view.fragment;

import android.app.MediaRouteButton;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.internal.di.components.RouteComponent;
import com.fernandocejas.android10.sample.presentation.model.RouteModel;
import com.fernandocejas.android10.sample.presentation.presenter.RouteListPresenter;
import com.fernandocejas.android10.sample.presentation.view.RouteListView;
import com.fernandocejas.android10.sample.presentation.view.adapter.RoutesAdapter;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteListFragment extends BaseFragment implements RouteListView {

    @Inject RouteListPresenter routeListPresenter;

    @Bind(R.id.rv_routes) RecyclerView rvRoutes;
    @Bind(R.id.rl_progress) RelativeLayout rlProgress;
    @Bind(R.id.rl_retry) RelativeLayout rlRetry;
    @Bind(R.id.bt_retry) Button btRetry;

    private RoutesAdapter routesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_route_list, container, true);
        ButterKnife.bind(this, fragmentView);
        setupUI();

        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void setupUI() {
        this.routesAdapter = new RoutesAdapter(getActivity(), new ArrayList<RouteModel>());
        // FIXME check if new version of RecyclerView doesn't have the problem
        this.rvRoutes.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.rvRoutes.setAdapter(routesAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initialize();
        this.loadRouteList();
    }

    private void loadRouteList() {
        this.routeListPresenter.initialize();
    }

    private void initialize() {
        this.getComponent(RouteComponent.class).inject(this);
        this.routeListPresenter.setView(this);
    }

    @Override
    public void renderRouteList(Collection<RouteModel> routeModelCollection) {
        if (routeModelCollection != null) {
            this.routesAdapter.setRoutesCollection(routeModelCollection);
        }
    }

    @Override
    public void showLoading() {
        this.rlProgress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rlProgress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rlRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rlRetry.setVisibility(View.GONE);
    }


    @Override
    public void showError(String message) {
        // TODO
    }

    @Override
    public Context getContext() {
        return this.getActivity().getApplicationContext();
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        RouteListFragment.this.loadRouteList();
    }

}
