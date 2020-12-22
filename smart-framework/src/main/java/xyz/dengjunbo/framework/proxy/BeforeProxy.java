package xyz.dengjunbo.framework.proxy;

import java.lang.reflect.Method;

public class BeforeProxy extends AspectProxy {
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        System.out.println("call before");
    }
}
