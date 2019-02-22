package com.wupengchoy.mystudy.studydemo.reflec.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class CGLibContainer {

    //获取被注解的类，正常情况下应该通过扫描，此处写死
    static Class<?>[] aspects = new Class<?>[]{ServiceLogAspect.class, ServiceExceptionAspect.class};

    //可能一个类会被多个切面修饰，使用list保存
    static Map<Class<?>, Map<AspectPoint, List<Method>>> interceptMehondMap = new HashMap<>();

    //初始化
    static {
        init();
    }

    private static void init() {
        for (Class<?> clz : aspects) {
            Aspect aspect = clz.getAnnotation(Aspect.class);
            if (null == aspect) {
                continue;
            }
            //获取各个切面方法
            Method before = getMethod(clz, "before", new Class<?>[]{Object.class, Method.class, Object[].class});
            Method after = getMethod(clz, "after", new Class<?>[]{Object.class, Method.class, Object[].class, Object.class});
            Method exception = getMethod(clz, "exception", new Class<?>[]{Object.class, Method.class, Object[].class, Throwable.class});
            //获取注解的value，也就是需要修饰的类
            Class<?>[] clzs = aspect.values();
            for (Class<?> intercepted : clzs) {
                addInterceptedMethodMap(intercepted, AspectPoint.BEFORE, before);
                addInterceptedMethodMap(intercepted, AspectPoint.AFTER, after);
                addInterceptedMethodMap(intercepted, AspectPoint.EXCEPTION, exception);
            }
        }
    }

    private static Method getMethod(Class<?> clz, String methodName, Class<?>[] parameterTypes) {
        try {
            return clz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static void addInterceptedMethodMap(Class<?> clz, AspectPoint point, Method method) {
        if (method == null) {
            return;
        }
        if (!interceptMehondMap.containsKey(clz)) {
            interceptMehondMap.put(clz, new HashMap<>());
        }
        Map<AspectPoint, List<Method>> aspectPointListMap = interceptMehondMap.get(clz);
        if (!aspectPointListMap.containsKey(point)) {
            aspectPointListMap.put(point, new ArrayList<>());
        }
        aspectPointListMap.get(point).add(method);
    }


    static class AspectInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //执行before方法
            List<Method> befores = getInterceptMethod(AspectPoint.BEFORE, o.getClass().getSuperclass());
            for (Method m : befores) {
                //方法为静态的时候obj可以被忽略，用null
                m.invoke(null, new Object[]{o, method, objects});
            }

            //执行代理方法
            Object result = null;
            try {
                result = methodProxy.invokeSuper(o, objects);

                //执行after方法
                List<Method> afters = getInterceptMethod(AspectPoint.AFTER, o.getClass().getSuperclass());
                for (Method m : afters) {
                    m.invoke(null, new Object[]{o, method, objects, result});
                }
            } catch (Exception e) {
                //执行exception方法
                List<Method> exceptions = getInterceptMethod(AspectPoint.EXCEPTION, o.getClass().getSuperclass());
                for (Method m : exceptions) {
                    m.invoke(null, new Object[]{o, method, objects, e});
                }
            }

            return result;
        }

        private static List<Method> getInterceptMethod(AspectPoint point, Class<?> clz) {
            if (!interceptMehondMap.containsKey(clz)) {
                return Collections.emptyList();
            }

            Map<AspectPoint, List<Method>> map = interceptMehondMap.get(clz);
            if (map.containsKey(point)) {
                return map.get(point);
            }
            return Collections.emptyList();
        }
    }

    //获取对象
    public static <T> T getInstance(Class<T> clz) {
        try {
            T obj = createInstance(clz);
            //处理依赖
            Field[] fields = obj.getClass().getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(SimpleInject.class)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, getInstance(field.getType()));
            }

            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static <T> T createInstance(Class<T> clz) throws Exception {
        //如果没有被修饰，则直接返回，不需要代理
        if (!interceptMehondMap.containsKey(clz)) {
            return (T) clz.newInstance();
        }

        //获取CGLib代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(new AspectInterceptor());
        return (T) enhancer.create();
    }

}
