package com.xbpsolutions.android.gst_crudoilprices.ui.widget;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xbpsolutions.android.gst_crudoilprices.R;
import com.xbpsolutions.android.gst_crudoilprices.helpers.APIService;
import com.xbpsolutions.android.gst_crudoilprices.helpers.APIUtils;
import com.xbpsolutions.android.gst_crudoilprices.model.ResponsePriceDiesel;
import com.xbpsolutions.android.gst_crudoilprices.model.ResponsePricePetrol;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopPrice extends AppCompatDialog {


    private TextView txtCity;
    private LinearLayout linearLayoutPrices;
    private ProgressBar progressBar;
    private AppCompatTextView txtPetrol;
    private AppCompatTextView txtDiesel;

    public PopPrice(Context context) {
        super(context);
        init();
    }

    public PopPrice(Context context, int theme) {
        super(context, theme);
        init();
    }


    private void init() {
        //inflate(getContext(), R.layout.item_popup, this);
        setContentView(R.layout.item_popup);
        txtCity = (TextView) this.findViewById(R.id.txtCity);
        linearLayoutPrices = (LinearLayout) this.findViewById(R.id.linearPrices);
        progressBar = (ProgressBar)this.findViewById(R.id.progress);
        txtPetrol = (AppCompatTextView)this.findViewById(R.id.txtPetrolPrice);
        txtDiesel = (AppCompatTextView)this.findViewById(R.id.txtDieselPrice);
    }


    public void setCity(int color, String city) {

        txtCity.setText(city);
        txtCity.setBackgroundColor(color);
        fetchPricePetrol(city);
        fetchPriceDiesel(city);


    }

    private void fetchPricePetrol(String city) {

        APIService apiService = APIUtils.getAPIService();
        apiService.getPetrolPrice(city.toLowerCase(), "petrol", "price").enqueue(new Callback<ResponsePricePetrol>() {
            @Override
            public void onResponse(Call<ResponsePricePetrol> call, Response<ResponsePricePetrol> response) {

                Log.e("Response Petrol",response.body().toString());

                if (response.isSuccessful() && response.body().getPrice() != 0) {
                    progressBar.setVisibility(View.GONE);
                    txtPetrol.setText("INR "+response.body().getPrice());
                }
            }

            @Override
            public void onFailure(Call<ResponsePricePetrol> call, Throwable t) {

            }
        });

    }

    private void fetchPriceDiesel(String city) {

        APIService apiService = APIUtils.getAPIService();
        apiService.getDieselPrice(city.toLowerCase(), "diesel", "price").enqueue(new Callback<ResponsePriceDiesel>() {
            @Override
            public void onResponse(Call<ResponsePriceDiesel> call, Response<ResponsePriceDiesel> response) {
                Log.e("Response Diesel",response.body().toString());
                if (response.isSuccessful() && response.body().getPrice() != 0) {
                    progressBar.setVisibility(View.GONE);
                    txtDiesel.setText("INR "+response.body().getPrice());
                }
            }

            @Override
            public void onFailure(Call<ResponsePriceDiesel> call, Throwable t) {

            }
        });


    }


    public void removeLinearItems() {

      //  linearLayoutPrices.removeAllViews();

    }
}
