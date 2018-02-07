package com.nazarii_moshenskyi.countryinfo.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class InternetManager {

    private static final String TAG = "InternetManager";

    private BroadcastReceiver receiver;
    private Subject<Boolean> connection;
    private boolean isConnected = false;


    public void registerReceiver(Context context) {
        if (context != null) {
            connection = BehaviorSubject.createDefault(isConnected);
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Log.d(TAG, "onReceive: ");
                    ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (manager != null) {
                        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
                        Log.d(TAG, "onReceive: " + isConnected);
                        connection.onNext(isConnected);
                    }
                }
            };

            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            context.registerReceiver(receiver, filter);
        }
    }

    public void unregisterReceiver(Context context) {
        if (receiver != null && context != null) {
            context.unregisterReceiver(receiver);
        }
    }

    /**
     * Pay attention subscribeOn(AndroidSchedulers.mainThread())
     */
    public Observable<Boolean> getConnectionObservable() {
        Log.d(TAG, "getConnectionObservable: " + isConnected);
        return connection.subscribeOn(AndroidSchedulers.mainThread());
    }

}
