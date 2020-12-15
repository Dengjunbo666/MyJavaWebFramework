package xyz.dengjunbo.framework.helper;

import xyz.dengjunbo.framework.annotation.Inject;
import xyz.dengjunbo.framework.util.ArrayUtil;
import xyz.dengjunbo.framework.util.CollectionUtil;
import xyz.dengjunbo.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 */
public final class IocHelper {
static {
    Map<Class<?>,Object>beanMap = BeanHelper.getBeanMap();
    if (CollectionUtil.isNotEmpty(beanMap)){
        //遍历Bean Map
        for (Map.Entry<Class<?>,Object>beanEntry:beanMap.entrySet()){
            //从BeanMap中获取Bean类与Bean实例
            Class<?>beanClass = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();
            //获取Bean类定义的所有成员变量（简称Bean Field）
            Field[]beanFields = beanClass.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(beanFields)){
                //遍历Bean Field
                for (Field beanField:beanFields){
                    //判断当前Bean Field 是否带有Inject注解
                    if (beanField.isAnnotationPresent(Inject.class)){
                        //在Bean Map中获取Bean Field对应的实例
                        Class<?>beanFieldClass = beanField.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if (beanFieldInstance != null){
                            //通过反射初始化BeanField的值
                            ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
}
