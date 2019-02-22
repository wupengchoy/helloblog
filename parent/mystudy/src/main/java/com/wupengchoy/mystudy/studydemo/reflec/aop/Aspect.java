package com.wupengchoy.mystudy.studydemo.reflec.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建新的注解
 */
@Target(ElementType.TYPE)//注解的目标
@Retention(RetentionPolicy.RUNTIME)//表示注解保留到什么时候SOURCE;CLASS;RUNTIME默认CLASS
public @interface Aspect {
    Class<?>[] values();//作用的类
}
