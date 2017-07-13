package com.vcredit.android.vrouter.rout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.vcredit.android.vrouter.VRouteManager;
import com.vcredit.android.vrouter.extras.ActivityRouteBundleExtras;
import com.vcredit.android.vrouter.module.RouteRule;
import com.vcredit.android.vrouter.parser.URIParser;

/**
 * A route tool to check route rule by uri and launch activity
 * Created by lzh on 16/9/5.
 */
public class ActivityRoute extends BaseRoute<IActivityRoute, ActivityRouteBundleExtras> implements IActivityRoute {

    @Override
    public Intent createIntent(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, routeRule.getRuleClz());
        intent.putExtras(bundle);
        intent.putExtras(extras.getExtras());
        if (extras instanceof ActivityRouteBundleExtras) {
            intent.addFlags(extras.getFlags());
        }
        return intent;
    }

    @Override
    public IActivityRoute requestCode(int requestCode) {
        this.extras.setRequestCode(requestCode);
        return this;
    }

    @Override
    public IActivityRoute setAnim(int enterAnim, int exitAnim) {
        this.extras.setInAnimation(enterAnim);
        this.extras.setOutAnimation(exitAnim);
        return this;
    }

    @Override
    public IActivityRoute addFlags(int flag) {
        this.extras.addFlags(flag);
        return this;
    }

    @Override
    protected ActivityRouteBundleExtras createExtras() {
        return new ActivityRouteBundleExtras();
    }

    @Override
    protected RouteRule obtainRouteMap() {
        return VRouteManager.get().getRouteMapByUri(parser, VRouteManager.TYPE_ACTIVITY_ROUTE);
    }

    @Override
    protected void realOpen(Context context) throws Throwable {
        Intent intent = createIntent(context);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent,extras.getRequestCode());
            int inAnimation = extras.getInAnimation();
            int outAnimation = extras.getOutAnimation();
            if (inAnimation >= 0 && outAnimation >= 0) {
                ((Activity) context).overridePendingTransition(inAnimation,outAnimation);
            }
        }
        else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public static boolean canOpenRouter(Uri uri) {
        try {
            return VRouteManager.get().getRouteMapByUri(new URIParser(uri), VRouteManager.TYPE_ACTIVITY_ROUTE) != null;
        } catch (Throwable e) {
            return false;
        }
    }
}
