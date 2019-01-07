package com.example.admin.myapplicationantai_71.inject;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Admin on 2019/1/5.
 */

public class ToastUtils {

    private Context mContext;

    public ToastUtils(Context context) {

        mContext = context;
    }

    public void ShowMsg( String value) {
        Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show();

    }
}
