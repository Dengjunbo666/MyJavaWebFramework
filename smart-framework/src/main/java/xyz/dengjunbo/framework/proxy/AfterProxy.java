package xyz.dengjunbo.framework.proxy;

import java.lang.reflect.Method;

public class AfterProxy extends AspectProxy{
    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        System.out.println("call after");
    }
}
