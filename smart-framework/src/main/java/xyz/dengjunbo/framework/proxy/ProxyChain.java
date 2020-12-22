package xyz.dengjunbo.framework.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**
 * 代理链
 */
public class ProxyChain {
    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method tatgetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private List<Proxy>proxyList = new ArrayList<>();
    private int proxyIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method tatgetMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.tatgetMethod = tatgetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTatgetMethod() {
        return tatgetMethod;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }
    public Object doProxyChain()throws Throwable{
        Object methodResult;
        if (proxyIndex<proxyList.size()){
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        }else{
            methodResult = methodProxy.invokeSuper(targetObject,methodParams);
        }
        return methodResult;
    }
}
