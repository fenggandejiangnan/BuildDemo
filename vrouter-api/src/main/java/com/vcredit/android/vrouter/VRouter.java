package com.vcredit.android.vrouter;

import android.content.Context;
import android.net.Uri;

import com.vcredit.android.vrouter.exception.NotFoundException;
import com.vcredit.android.vrouter.extras.ActionRouteBundleExtras;
import com.vcredit.android.vrouter.extras.ActivityRouteBundleExtras;
import com.vcredit.android.vrouter.extras.RouteBundleExtras;
import com.vcredit.android.vrouter.interceptors.RouteInterceptor;
import com.vcredit.android.vrouter.module.RouteCreator;
import com.vcredit.android.vrouter.rout.ActionRoute;
import com.vcredit.android.vrouter.rout.ActivityRoute;
import com.vcredit.android.vrouter.rout.BrowserRoute;
import com.vcredit.android.vrouter.rout.IActionRoute;
import com.vcredit.android.vrouter.rout.IActivityRoute;
import com.vcredit.android.vrouter.rout.IBaseRoute;
import com.vcredit.android.vrouter.rout.IRoute;
import com.vcredit.android.vrouter.rout.RouteCallback;
import com.vcredit.android.vrouter.utils.Utils;

/**
 * Created by zew on 17/7/10.
 */
public class VRouter {
    /**
     * The key of raw uri. you can obtains it uri by this key, for eg:
     * <pre>
     *      <i><b>bundle.getParcelable(Router.RAW_URI)</b></i>
     * </pre>
     */
    public static final String RAW_URI = "_ROUTER_RAW_URI_KEY_";

    private Uri uri;
    private RouteCallback callback;
    private RouteCallback.InternalCallback internalCallback;

    private VRouter(Uri uri) {
        this.uri = Utils.completeUri(uri);
    }

    /**
     * Create Router by url string
     * @param url The url to create Router
     * @return new Router
     */
    public static VRouter create(String url) {
        return new VRouter(Uri.parse(url));
    }

    /**
     * Create Router by uri
     * @param uri the uri to create Router
     * @return new Router
     */
    public static VRouter create(Uri uri) {
        return new VRouter(uri);
    }

    public VRouter setCallback (RouteCallback callback) {
        this.callback = callback;
        return this;
    }

    private RouteCallback.InternalCallback getCallback () {
        if (internalCallback == null) {
            internalCallback = new RouteCallback.InternalCallback();
            internalCallback.setCallback(callback);
        }
        return internalCallback;
    }


    public static IRoute resume(Uri uri, RouteBundleExtras extras) {
        IRoute route = VRouter.create(uri).getRoute();
        if (route instanceof ActivityRoute && extras instanceof ActivityRouteBundleExtras) {
            ((ActivityRoute) route).replaceExtras((ActivityRouteBundleExtras) extras);
        } else if (route instanceof ActionRoute && extras instanceof ActionRouteBundleExtras) {
            ((ActionRoute) route).replaceExtras((ActionRouteBundleExtras) extras);
        }
        return route;
    }

    /**
     * launch routing task.
     * @param context context to launched
     */
    public void open(Context context) {
        getRoute().open(context);
    }


    public IRoute getRoute () {
        if (ActionRoute.canOpenRouter(uri)) {
            return new ActionRoute().create(uri, getCallback());
        } else if (ActivityRoute.canOpenRouter(uri)) {
            return new ActivityRoute().create(uri, getCallback());
        } else if (BrowserRoute.canOpenRouter(uri)) {
            return BrowserRoute.getInstance().setUri(uri);
        } else {
            notifyNotFound(String.format("find Route by %s failed:",uri));
            return IRoute.EMPTY;
        }
    }

    /**
     * <p>
     * Get {@link IBaseRoute} by uri, it could be one of {@link IActivityRoute} or {@link IActionRoute}.
     * and you can add some {@link android.os.Bundle} data and {@link RouteInterceptor} into it.
     * </p>
     * @return returns an {@link IBaseRoute} finds by uri or {@link IBaseRoute#EMPTY} for not found
     */
    public IBaseRoute getBaseRoute() {
        IRoute route = getRoute();
        if (route instanceof IBaseRoute) {
            return (IBaseRoute) route;
        }

        notifyNotFound(String.format("find BaseRoute by %s failed:",uri));
        return IBaseRoute.EMPTY;
    }

    /**
     * Get {@link IActivityRoute} by uri,you should get a route by this way and set some extras data before open
     * @return returns an {@link IActivityRoute} finds by uri or {@link IActivityRoute#EMPTY} for not found.
     */
    public IActivityRoute getActivityRoute() {
        IRoute route = getRoute();
        if (route instanceof IActivityRoute) {
            return (IActivityRoute) route;
        }

        // return an empty route to avoid NullPointException
        notifyNotFound(String.format("find Activity Route by %s failed:",uri));
        return IActivityRoute.EMPTY;
    }

    /**
     * Get {@link IActionRoute} by uri,you should get a route by this way and set some extras data before open
     * @return returns an {@link IActionRoute} finds by uri or {@link IActionRoute#EMPTY} for not found.
     */
    public IActionRoute getActionRoute() {
        IRoute route = getRoute();
        if (route instanceof IActionRoute) {
            return (IActionRoute) route;
        }

        notifyNotFound(String.format("find Action Route by %s failed:",uri));
        // return a empty route to avoid NullPointException
        return IActionRoute.EMPTY;
    }

    /**
     * Set a global route callback to invoked when open a uri
     * @param callback can't be null
     */
    public static void setGlobalRouteCallback (RouteCallback callback) {
        VRouteManager.get().setCallback(callback);
    }

    public static void setGlobalRouteInterceptor (RouteInterceptor interceptor) {
        VRouteManager.get().setInterceptor(interceptor);
    }

    /**
     * Set to create route rules
     * @param creator Route rules creator.can't be null
     */
    public static void addRouteCreator(RouteCreator creator) {
        VRouteManager.get().addCreator(creator);
    }

    private void notifyNotFound(String msg) {
        getCallback().notFound(uri, new NotFoundException(msg, NotFoundException.TYPE_SCHEMA, uri.toString()));
    }
}
