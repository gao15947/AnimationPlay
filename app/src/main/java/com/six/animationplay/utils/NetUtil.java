package com.six.animationplay.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.six.animationplay.application.AnimationApplication;

/**
 * Created by Administrator on 2017/4/10.
 */

public class NetUtil {

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @return true 表示网络可用
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) AnimationApplication.getInstance()
                .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
