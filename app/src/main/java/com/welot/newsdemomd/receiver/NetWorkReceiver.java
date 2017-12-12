package com.welot.newsdemomd.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.welot.newsdemomd.util.HttpNetUtil;


public class NetWorkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        HttpNetUtil.INSTANCE.setConnected(context);
    }
}