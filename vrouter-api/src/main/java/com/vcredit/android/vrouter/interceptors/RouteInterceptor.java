package com.vcredit.android.vrouter.interceptors;

import android.content.Context;
import android.net.Uri;

import com.vcredit.android.vrouter.extras.RouteBundleExtras;

/**
 * Created by zew on 17/7/10.
 */
public interface RouteInterceptor {

    boolean intercept (Uri uri, RouteBundleExtras extras, Context context);


    void onIntercepted(Uri uri, RouteBundleExtras extras, Context context);

}
