package com.vcredit.android.vrouter.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.vcredit.android.vrouter.exception.InterceptorException;
import com.vcredit.android.vrouter.extras.RouteBundleExtras;
import com.vcredit.android.vrouter.interceptors.RouteInterceptor;
import com.vcredit.android.vrouter.module.RouteRule;
import com.vcredit.android.vrouter.parser.BundleWrapper;
import com.vcredit.android.vrouter.parser.ListBundle;
import com.vcredit.android.vrouter.parser.SimpleBundle;
import com.vcredit.android.vrouter.parser.URIParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

    public static final boolean PARCELER_SUPPORT;

    /**
     * Adjust if the scheme is http or https
     * @param scheme scheme for uri
     * @return return true if is http or https
     */
    public static boolean isHttp (String scheme) {
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    public static String wrapScheme (String scheme) {
        if (TextUtils.isEmpty(scheme) || !scheme.endsWith("/")) return scheme;

        return scheme.substring(0,scheme.lastIndexOf("/"));
    }

    public static String unwrapScheme (String scheme) {
        return scheme + "/";
    }

    /**
     * To check and complete a uri.check if is not set scheme.a default scheme: <b><i>http</i></b> will be used
     * @param uri source uri
     * @return complete uri
     */
    public static Uri completeUri(Uri uri) {
        String url = uri.toString();
        if (!url.contains("://")) {
            return Uri.parse("http://" + url);
        }
        return uri;
    }

    public static boolean checkInterceptor(Uri uri, RouteBundleExtras extras, Context context, List<RouteInterceptor> interceptors) {
        for (RouteInterceptor interceptor : interceptors) {
            if (interceptor.intercept(uri,extras,context)) {
                interceptor.onIntercepted(uri,extras,context);
                throw new InterceptorException(interceptor);
            }
        }
        return false;
    }

    public static Bundle parseRouteMapToBundle(URIParser parser, RouteRule routeRule) {
        Map<String, Integer> keyMap = routeRule.getParams();
        Bundle bundle = new Bundle();
        Map<String, String> params = parser.getParams();
        Set<String> keySet = params.keySet();
        Map<String,BundleWrapper> wrappers = new HashMap<>();
        for (String key : keySet) {
            Integer type = keyMap.get(key);
            type = type == null ? RouteRule.STRING : type;

            BundleWrapper wrapper = wrappers.get(key);
            if (wrapper == null) {
                wrapper = createBundleWrapper(type);
                wrappers.put(key,wrapper);
            }
            wrapper.set(params.get(key));
        }
        keySet = wrappers.keySet();
        for (String key : keySet) {
            wrappers.get(key).put(bundle,key);
        }
        return bundle;
    }


    private static BundleWrapper createBundleWrapper (int type) {
        switch (type) {
            case RouteRule.STRING:
            case RouteRule.BYTE:
            case RouteRule.SHORT:
            case RouteRule.INT:
            case RouteRule.LONG:
            case RouteRule.FLOAT:
            case RouteRule.DOUBLE:
            case RouteRule.BOOLEAN:
            case RouteRule.CHAR:
                return new SimpleBundle(type);
            case RouteRule.INT_LIST:
            case RouteRule.STRING_LIST:
                return new ListBundle(type);
            default:
                return new SimpleBundle(RouteRule.STRING);
        }
    }

    static {
        boolean isSupport = true;
        try {
            Class parceler = Class.forName("com.lzh.compiler.parceler.Parceler");
            parceler.getMethod("toEntity", Object.class, Bundle.class);
            isSupport = true;
        } catch (Throwable e) {
            isSupport = false;
        } finally {
            PARCELER_SUPPORT = isSupport;
        }
    }
}
