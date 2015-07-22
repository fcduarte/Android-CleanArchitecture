package com.fernandocejas.android10.sample.data.net;

import com.fernandocejas.android10.sample.data.entity.RouteEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RouteRestService {

    private static final String SERVER_URL = "http://www.mocky.io/";
    private static final String TIMESTAMP_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    private RouteRestApi routeRestApi;

    public interface RouteRestApi {

        @GET("/v2/55af1cd7bf6e056b2166fb28")
        Observable<List<RouteEntity>> getRouteEntityList();

    }

    public RouteRestService() {
        Gson gson = new GsonBuilder()
            .setDateFormat(TIMESTAMP_DATE_FORMAT)
            .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(SERVER_URL)
            .setConverter(new GsonConverter(gson))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

        routeRestApi = restAdapter.create(RouteRestApi.class);
    }

    public Observable<List<RouteEntity>> getRouteEntityList() {
        return routeRestApi.getRouteEntityList();
    }

}
