package com.fernandocejas.android10.sample.presentation.presenter;

import com.fernandocejas.android10.sample.domain.Route;
import com.fernandocejas.android10.sample.domain.exception.DefaultErrorBundle;
import com.fernandocejas.android10.sample.domain.interactor.DefaultSubscriber;
import com.fernandocejas.android10.sample.domain.interactor.UseCase;
import com.fernandocejas.android10.sample.presentation.exception.ErrorMessageFactory;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.mapper.RouteModelDataMapper;
import com.fernandocejas.android10.sample.presentation.model.RouteModel;
import com.fernandocejas.android10.sample.presentation.view.RouteListView;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by felipeduarte on 7/21/15.
 */
@PerActivity
public class RouteListPresenter extends DefaultSubscriber<List<Route>> implements Presenter {

    private RouteListView routeListView;

    private final UseCase routeListUseCase;
    private final RouteModelDataMapper routeModelDataMapper;

    @Inject
    public RouteListPresenter(@Named("routeList") UseCase routeListUseCase, RouteModelDataMapper routeModelDataMapper) {
        this.routeListUseCase = routeListUseCase;
        this.routeModelDataMapper = routeModelDataMapper;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.routeListUseCase.unsubscribe();
    }

    /**
     * Initializes the presenter by start retrieving the route list.
     */
    public void initialize() {
        this.loadRouteList();
    }

    /**
     * Loads all routes.
     */
    private void loadRouteList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getRouteList();
    }

    private void getRouteList() {
        this.routeListUseCase.execute(new RouteListSubscriber());
    }

    // FIXME lot of boilerplate code, maybe refactor?
    private void showViewLoading() {
        this.routeListView.showLoading();
    }

    private void hideViewLoading() {
        this.routeListView.hideLoading();
    }

    private void showViewRetry() {
        this.routeListView.showRetry();
    }

    private void hideViewRetry() {
        this.routeListView.hideRetry();
    }

    private void showErrorMessage(DefaultErrorBundle defaultErrorBundle) {
        // FIXME extend error to create a specific for Route model
        String errorMessage = ErrorMessageFactory.create(this.routeListView.getContext(), defaultErrorBundle.getException());
        this.routeListView.showError(errorMessage);
    }

    private void showRouteCollectionInView(List<Route> routes) {
        final Collection<RouteModel> routeModelsCollection = this.routeModelDataMapper.transform(routes);
        this.routeListView.renderRouteList(routeModelsCollection);

    }

    public void setView(RouteListView routeListView) {
        this.routeListView = routeListView;
    }

    private final class RouteListSubscriber extends DefaultSubscriber<List<Route>> {

        @Override
        public void onCompleted() {
            RouteListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            RouteListPresenter.this.hideViewLoading();
            RouteListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            RouteListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<Route> routes) {
            RouteListPresenter.this.showRouteCollectionInView(routes);
        }
    }

}
