package xyz.dengjunbo.chapter2.util;

/**
 * 转型操作工具类
 */
public class CastUtil {
    /**
     * 转为String型
     */
    public static String castString(Object object){
        return CastUtil.castString(object,"");
    }
    public static String castString(Object object,String defaultValue){
        return object != null ? String.valueOf(object):defaultValue;
    }
    /**
     * 转为double型
     */
    public static double castDouble(Object object){
        return CastUtil.castDouble(object,0);
    }
    public static double castDouble(Object object,double defaultValue){
        double doubleValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }
    /**
     * 转为long型
     */
    public static long castLong(Object object){
        return CastUtil.castLong(object,0);
    }
    public static long castLong(Object object,long defaultValue){
        long longValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
    /**
     * 转为int型
     */
    public static int castInt(Object object){
        return CastUtil.castInt(object,0);
    }
    public static int castInt(Object object,int defaultValue){
        int intValue = defaultValue;
        if (object != null){
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }
    /**
     * 转为布尔型
     */
    public static boolean castBoolean(Object object){
        return CastUtil.castBoolean(object,false);
    }
    public static boolean castBoolean(Object object,boolean defaultValue){
        boolean booleanValue = defaultValue;
        if (object != null){
            booleanValue = Boolean.parseBoolean(castString(object));
        }
        return booleanValue;
    }
}
