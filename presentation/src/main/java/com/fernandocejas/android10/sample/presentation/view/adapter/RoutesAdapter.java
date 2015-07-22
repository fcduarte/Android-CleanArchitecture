package com.fernandocejas.android10.sample.presentation.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fernandocejas.android10.sample.presentation.R;
import com.fernandocejas.android10.sample.presentation.model.RouteModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by felipeduarte on 7/21/15.
 */
public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.RouteViewHolder> {

    private List<RouteModel> routesCollection;
    private final LayoutInflater layoutInflater;

    public RoutesAdapter(Context context, Collection<RouteModel> routesCollection) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.routesCollection = (List<RouteModel>) routesCollection;
    }

    @Override
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.row_route, parent, false);
        RouteViewHolder routeViewHolder = new RouteViewHolder(view);

        return routeViewHolder;
    }

    @Override
    public void onBindViewHolder(RouteViewHolder holder, int position) {
        final RouteModel routeModel = this.routesCollection.get(position);
        holder.textViewTitle.setText(routeModel.getFullName());
    }

    @Override
    public int getItemCount() {
        return (this.routesCollection != null) ? this.routesCollection.size() : 0;
    }

    public void setRoutesCollection(Collection<RouteModel> routeModelCollection) {
        this.routesCollection = (List<RouteModel>) routeModelCollection;
        this.notifyDataSetChanged();
    }

    static class RouteViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title) TextView textViewTitle;

        public RouteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
