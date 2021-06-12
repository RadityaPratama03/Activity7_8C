package com.example.activity6.app;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DBController extends Application {
    public static final String TAG = DBController.class.getSimpleName();
    private RequestQueue mrq;
    private static DBController mInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
    }

    public static synchronized DBController getInstance(){
        return mInstance;
    }
    public RequestQueue getRequestQueue(){
        if (mrq == null){
            mrq = Volley.newRequestQueue(getApplicationContext());
        }
        return mrq;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag)? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request <T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequest(Object tag){
        if(mrq != null){
            mrq.cancelAll(tag);
        }
    }
}