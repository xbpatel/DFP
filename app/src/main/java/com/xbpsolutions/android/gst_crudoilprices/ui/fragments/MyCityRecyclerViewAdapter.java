package com.xbpsolutions.android.gst_crudoilprices.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xbpsolutions.android.gst_crudoilprices.R;
import com.xbpsolutions.android.gst_crudoilprices.helpers.Functions;
import com.xbpsolutions.android.gst_crudoilprices.ui.widget.PopPrice;

import java.util.List;


public class MyCityRecyclerViewAdapter extends RecyclerView.Adapter<MyCityRecyclerViewAdapter.ViewHolder> {

    private final List<String> mValues;
    private Context context;
    private String[] colors;

    public MyCityRecyclerViewAdapter(Context context, List<String> items) {
        mValues = items;
        this.context = context;
        colors = context.getResources().getStringArray(R.array.mdcolor_50);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mView.setBackgroundColor(Color.parseColor(colors[position].toString()));
        holder.txtCity.setText(mValues.get(position));

        final PopPrice popPrice = new PopPrice(context, Functions.HUD_THEME);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popPrice.setCity(Color.parseColor(colors[position].toString()), mValues.get(position));
                popPrice.show();
            }
        });


//        final LongPressPopup popup = new LongPressPopupBuilder(context)// A Context object for the builder constructor
//                .setTarget(holder.mView)// The View which will open the popup if long pressed
//                .setPopupView(popPrice)// The View to show when long pressed
//                .setPopupListener(new PopupStateListener() {
//                    @Override
//                    public void onPopupShow(@Nullable String popupTag) {
//
//                    }
//
//                    @Override
//                    public void onPopupDismiss(@Nullable String popupTag) {
//                        popPrice.removeLinearItems();
//                    }
//                })
//                .build();// This will give you a LongPressPopup object
//
//        // You can also chain it to the .build() mehod call above without declaring the "popup" variable before
//        popup.register();// From this moment, the touch events are registered and, if long pressed, will show the given view inside the popup, call unregister() to stop


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtCity;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtCity = (TextView) view.findViewById(R.id.txtCity);
        }
    }
}
