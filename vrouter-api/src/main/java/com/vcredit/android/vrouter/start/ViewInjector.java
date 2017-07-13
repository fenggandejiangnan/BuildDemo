package com.vcredit.android.vrouter.start;

/**
 * Created by zew on 17/7/8.
 */
public interface ViewInjector<T> {
    void inject(T t, Object source);
}
