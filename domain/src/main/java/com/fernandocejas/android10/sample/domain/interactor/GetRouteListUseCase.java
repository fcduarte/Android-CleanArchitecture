package com.fernandocejas.android10.sample.domain.interactor;

import com.fernandocejas.android10.sample.domain.repository.RouteRepository;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class GetRouteListUseCase extends UseCase {

    private final RouteRepository routeRepository;

    @Inject
    public GetRouteListUseCase(RouteRepository routeRepository) {
        super();
        this.routeRepository = routeRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.routeRepository.getRoutes();
    }
}
