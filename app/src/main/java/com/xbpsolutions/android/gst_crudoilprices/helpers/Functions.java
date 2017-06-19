package com.xbpsolutions.android.gst_crudoilprices.helpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

/**
 * Created by excellent-3 on 15/06/17.
 */

public class Functions {
    public static int HUD_THEME = android.R.style.Theme_Translucent_NoTitleBar;
    public static int getMatColor(Context context, String typeColor) {
        int returnColor = Color.BLACK;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }

}
