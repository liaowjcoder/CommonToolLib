package lwj.com.commontolllib.utils.ui;

import android.content.Context;
import android.os.Build;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:39
 * @描述 资源相关的工具类
 */
public class ResUtils {
    /**
     * 得到color.xml中定义的颜色值
     */
    public static int getColor(Context context, int resId) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return context.getResources().getColor(resId, null);
        } else {
            return context.getResources().getColor(resId);
        }
    }

    /**
     * 得到String.xml中定义的字符
     */
    public static String getString(Context context,int resId) {
        return context.getResources().getString(resId);
    }

    /**
     * 得到String.xml中定义的字符,带占位符
     */
    public static String getString(Context context,int resId, Object... formatArgs) {
        return context.getResources().getString(resId, formatArgs);
    }

    /**
     * 得到String.xml中定义的字符数组
     */
    public static String[] getStringArr(Context context,int resId) {
        return context.getResources().getStringArray(resId);
    }
}
