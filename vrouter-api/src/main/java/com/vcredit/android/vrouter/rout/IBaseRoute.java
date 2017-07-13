package com.vcredit.android.vrouter.rout;

import android.content.Context;
import android.os.Bundle;

import com.vcredit.android.vrouter.interceptors.RouteInterceptor;
import com.vcredit.android.vrouter.interceptors.RouteInterceptorAction;

import java.util.ArrayList;
import java.util.List;


public interface IBaseRoute<T extends IBaseRoute> extends IRoute, RouteInterceptorAction<T> {

    T addExtras(Bundle extras);

    /**
     * Add a interceptor to container
     * @param interceptor interceptor instance
     * @return The real type
     */
    T addInterceptor(RouteInterceptor interceptor);

    /**
     * Remove a interceptor from container
     * @param interceptor interceptor instance
     * @return The real type
     */
    T removeInterceptor(RouteInterceptor interceptor);

    /**
     * remove all of interceptors you has set before
     * @return The real type
     */
    T removeAllInterceptors();

    /**
     * get all interceptors you has set before
     * @return all of interceptors
     */
    List<RouteInterceptor> getInterceptors();

    IBaseRoute EMPTY = new IBaseRoute<IBaseRoute>() {
        @Override
        public IBaseRoute addExtras(Bundle extras) {
            return this;
        }

        @Override
        public void open(Context context) {}

        @Override
        public IBaseRoute addInterceptor(RouteInterceptor interceptor) {
            return this;
        }

        @Override
        public IBaseRoute removeInterceptor(RouteInterceptor interceptor) {
            return this;
        }

        @Override
        public IBaseRoute removeAllInterceptors() {
            return this;
        }

        @Override
        public List<RouteInterceptor> getInterceptors() {
            return new ArrayList<>();
        }
    };
}
