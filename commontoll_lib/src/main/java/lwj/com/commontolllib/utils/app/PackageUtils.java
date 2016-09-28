package lwj.com.commontolllib.utils.app;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:14
 * @描述 包相关的工具
 */
public class PackageUtils {
    /**
     * app VersionName
     * @param context
     * @return
     */
    public static String getAppVerName(Context context) {
        StringBuffer version_detail = new StringBuffer();
        String version = "";
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            version = pi.versionName;
        } catch (Exception e) {
            version = "1.0.0";
        }
        return version_detail.append(version).toString();
    }

    /**
     * app Ver版本号
     * @param context
     * @return
     */
    public static int getAppVerCode(Context context) {
        int version = 1;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            version = pi.versionCode;
        } catch (Exception e) {
            version = 1;
        }
        return version;
    }
}
