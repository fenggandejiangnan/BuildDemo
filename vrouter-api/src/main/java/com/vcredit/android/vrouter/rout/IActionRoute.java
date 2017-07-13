package com.vcredit.android.vrouter.rout;

import android.content.Context;
import android.os.Bundle;

import com.vcredit.android.vrouter.interceptors.RouteInterceptor;

import java.util.ArrayList;
import java.util.List;


public interface IActionRoute extends IBaseRoute<IActionRoute>{

    IActionRoute EMPTY = new IActionRoute() {
        @Override
        public IActionRoute addInterceptor(RouteInterceptor interceptor) {
            return this;
        }

        @Override
        public IActionRoute removeInterceptor(RouteInterceptor interceptor) {
            return this;
        }

        @Override
        public IActionRoute removeAllInterceptors() {
            return this;
        }

        @Override
        public List<RouteInterceptor> getInterceptors() {
            return new ArrayList<>();
        }

        @Override
        public void open(Context context) {}

        @Override
        public IActionRoute addExtras(Bundle extras) {
            return this;
        }
    };
}
