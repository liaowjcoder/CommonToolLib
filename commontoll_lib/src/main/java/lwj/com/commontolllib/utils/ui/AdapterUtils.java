package lwj.com.commontolllib.utils.ui;

import android.content.Context;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:33
 * @描述 适配相关工具类
 */
public class AdapterUtils {
    /**
     * 将dip转化为px
     *
     * @param context
     * @param dipValue
     *
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        // px/dp = density;
        // px和dp比例关系
        float density = context.getResources().getDisplayMetrics().density;

        // ppi
        // float densityDpi = getResources().getDisplayMetrics().densityDpi;

        // LogUtils.s("density: " + density);
        // LogUtils.s("densityDpi: " + densityDpi);
        int px = (int) (density * dipValue + .5f);
        return px;
        // dp = px/(ppi/160)

        // 320x480 ppi = 160 1px = 1dp
        // 480x800 ppi = 240 1.5px = 1dp
        // 1280 x720 ppi = 320 2px = 1dp
    }

    /**
     * px-->dp
     *
     * @param px
     *
     * @return
     */
    public static int px2Dip(Context context, int px) {
        // px/dp = density;
        float density = context.getResources().getDisplayMetrics().density;
        int dp = (int) (px / density + .5f);
        return dp;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     *
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     *
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
