package xyz.dengjunbo.framework;

import xyz.dengjunbo.framework.helper.BeanHelper;
import xyz.dengjunbo.framework.helper.ClassHelper;
import xyz.dengjunbo.framework.helper.ControllerHelper;
import xyz.dengjunbo.framework.helper.IocHelper;
import xyz.dengjunbo.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 */
public final class HelperLoader {
public static void init(){
    Class<?>[]classList = {
            ClassHelper.class,
            BeanHelper.class,
            IocHelper.class,
            ControllerHelper.class
    };
    for (Class<?>cls:classList){
        ClassUtil.loadClass(cls.getName(),true);
    }
}
}
