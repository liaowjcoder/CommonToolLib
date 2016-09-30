package lwj.com.commontolllib.utils.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;

import java.io.File;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:14
 * @描述 包相关的工具
 */
public class PackageUtils {
    /**
     * app VersionName
     *
     * @param context
     *
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
     *
     * @param context
     *
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

    /**
     * 安装APK
     *
     * @param context
     * @param file
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("application/vnd.android.package-archive");
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
