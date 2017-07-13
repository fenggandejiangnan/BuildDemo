package com.vcredit.android.vrouter.rout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.vcredit.android.vrouter.utils.Utils;


/**
 * A route tool to open uri by browser
 * Created by lzh on 16/9/5.
 */
public class BrowserRoute implements IRoute {

    Uri uri;

    private static final BrowserRoute route = new BrowserRoute();

    public static BrowserRoute getInstance () {
        return route;
    }

    @Override
    public void open(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static boolean canOpenRouter(Uri uri) {
        return Utils.isHttp(uri.getScheme());
    }

    public IRoute setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

}
