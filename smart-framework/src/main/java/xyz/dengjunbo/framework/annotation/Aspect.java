package xyz.dengjunbo.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     * @return
     */
    Class<? extends Annotation>value();
}
