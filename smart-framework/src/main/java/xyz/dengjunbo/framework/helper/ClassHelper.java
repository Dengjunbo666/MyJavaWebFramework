package xyz.dengjunbo.framework.helper;

import xyz.dengjunbo.framework.annotation.Controller;
import xyz.dengjunbo.framework.annotation.Service;
import xyz.dengjunbo.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 */
public final class ClassHelper {

    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>>CLASS_SET;
    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }
    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>>getClassSet(){
        return CLASS_SET;
    }
    /**
     * 获取应用包名下所有service类
     */
    public static Set<Class<?>>getServiceClassSet(){
        Set<Class<?>>classSet = new HashSet<>();
        for (Class<?>cls:CLASS_SET){
            if (cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    /**
     * 获取应用包下所有Controller类
     */
    public static Set<Class<?>>getControllerClassSet(){
        Set<Class<?>>classSet = new HashSet<>();
        for (Class<?>cls:CLASS_SET){
            if (cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    /**
     * 获取应用包名下所有的Bean类（包括：Service，Controller类）
     */
    public static Set<Class<?>>getBeanClassSet(){
        Set<Class<?>>beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
