package xyz.dengjunbo.framework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 */
public final class CollectionUtil {
/**
 * 判断Collection是否为空
 */
public static boolean isEmpty(Collection<?>collection){
    return CollectionUtils.isEmpty(collection);
}
/**
 * 判断Collection是否非空
 */
public static boolean isNotEmpty(Collection<?>collection){
    return !isEmpty(collection);
}
/**
 * 判断Map是否为空
 */
public static boolean isEmpty(Map<?,?> Map){
    return MapUtils.isEmpty(Map);
}
/**
 * 判断Map是否非空
 */
public static boolean isNotEmpty(Map<?,?> Map){
    return !isEmpty(Map);
}
}
