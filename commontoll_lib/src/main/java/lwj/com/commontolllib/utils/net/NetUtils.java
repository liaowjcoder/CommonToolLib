package lwj.com.commontolllib.utils.net;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:29
 * @描述 网络相关的工具类
 */
public class NetUtils {
    /**
     * 是否网络连接
     *
     * @param context
     *
     * @return
     */
    public static boolean hasConnectedNetwork(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        return connectivity.getActiveNetworkInfo() != null;
    }


}
