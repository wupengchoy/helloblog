package com.wupengchoy.mystudy.studydemo.reflec.aop;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleInjectContainer {

    private static Map<Class<?>, Object> instances = new HashMap<>();

    /**
     * 普通
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class<T> cls) {
        try {
            T obj = cls.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SimpleInject.class)) {
                    field.setAccessible(true);
                    field.set(obj, getInstance(field.getType()));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 单例
     *
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getSingleton(Class<T> clz) {
        if (!clz.isAnnotationPresent(SimpleSingleton.class)) {
            return getInstance(clz);
        }
        Object obj = instances.get(clz);
        if (obj == null) {
            synchronized (clz) {
                obj = instances.get(clz);
                if (obj == null) {
                    obj = getInstance(clz);
                    instances.put(clz, obj);
                }
            }
        }
        obj = instances.get(clz);
        return (T) obj;
    }

}
