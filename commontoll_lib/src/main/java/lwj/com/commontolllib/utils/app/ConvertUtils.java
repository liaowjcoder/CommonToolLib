package lwj.com.commontolllib.utils.app;

import android.text.TextUtils;

/**
 * @作者 廖伟健
 * @创建时间 2016/10/10 13:54
 * @描述 ${TODO} 
 */
public class ConvertUtils {
    /**
     * 将一个字符串转化为整型。
     * @param value
     * @param defaultVal
     * @return
     */
    public static int convertStringToInt(String value, int defaultVal) {
        if (TextUtils.isEmpty(value)) {
            return defaultVal;
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            try {
                //若是出现小数
                return Double.valueOf(value).intValue();
            } catch (Exception e1) {
                //value不是数字类型则会出现异常
                return defaultVal;
            }
        }
    }
}
