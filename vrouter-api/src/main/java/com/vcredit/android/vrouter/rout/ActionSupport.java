package com.vcredit.android.vrouter.rout;

import android.content.Context;
import android.os.Bundle;

/**
 * <p>You can inherit from this class to create action routing event.
 *
 * @author haoge
 */
public abstract class ActionSupport {


    public abstract void onRouteTrigger(Context context, Bundle bundle);
}
