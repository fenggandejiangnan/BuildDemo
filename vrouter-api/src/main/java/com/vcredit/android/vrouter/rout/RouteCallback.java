package com.vcredit.android.vrouter.rout;

import android.net.Uri;

import com.vcredit.android.vrouter.VRouteManager;
import com.vcredit.android.vrouter.exception.NotFoundException;
import com.vcredit.android.vrouter.module.RouteRule;

/**
 * Created by zew on 17/7/10.
 */
public interface RouteCallback {

    void notFound(Uri uri, NotFoundException e);


    void onOpenSuccess(Uri uri,RouteRule rule);


    void onOpenFailed(Uri uri,Throwable e);

    RouteCallback EMPTY = new RouteCallback() {

        @Override
        public void notFound(Uri uri, NotFoundException e) {}

        @Override
        public void onOpenSuccess(Uri uri, RouteRule rule) {}

        @Override
        public void onOpenFailed(Uri uri, Throwable e) {}
    };

    // ===========internal apis================
    final class InternalCallback implements RouteCallback {

        boolean hasCalled = false;
        RouteCallback callback;

        public void setCallback(RouteCallback callback) {
            this.callback = callback;
        }

        public RouteCallback getCallback() {
            return callback;
        }

        @Override
        public void notFound(Uri uri, NotFoundException e) {
            if (hasCalled) {
                return;
            }
            hasCalled = true;
            RouteCallback global = VRouteManager.get().getCallback();
            global.notFound(uri, e);
            if (callback != null && callback != global) {
                callback.notFound(uri, e);
            }
            callback = null;
        }

        @Override
        public void onOpenSuccess(Uri uri, RouteRule rule) {
            if (hasCalled) {
                return;
            }
            hasCalled = true;
            RouteCallback global = VRouteManager.get().getCallback();
            global.onOpenSuccess(uri, rule);
            if (callback != null && callback != global) {
                callback.onOpenSuccess(uri, rule);
            }
            callback = null;
        }

        @Override
        public void onOpenFailed(Uri uri, Throwable e) {
            if (hasCalled) {
                return;
            }
            hasCalled = true;
            RouteCallback global = VRouteManager.get().getCallback();
            global.onOpenFailed(uri, e);
            if (callback != null && callback != global) {
                callback.onOpenFailed(uri, e);
            }
            callback = null;
        }
    }
}
