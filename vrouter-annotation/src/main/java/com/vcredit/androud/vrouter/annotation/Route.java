package com.vcredit.androud.vrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 路由路径配置
 * Created by zew on 17/7/10.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Route {
    /**
     * value of scheme.should be unique and nonNull
     * @return scheme
     */
    String[] value();

    /**
     * Set a package name of generate class.if not set,it'll be <i>com.lzh.router</i>
     * @return package name
     */
    String pack () default "";
}
