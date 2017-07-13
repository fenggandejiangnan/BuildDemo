package com.vcredit.android.vrouter.rout;

import android.content.Context;

public interface IRoute {

    /**
     * open route with uri by context
     * @param context The context to launch routing event
     */
    void open(Context context);

    IRoute EMPTY = new IRoute() {
        @Override
        public void open(Context context) {}
    };
}
