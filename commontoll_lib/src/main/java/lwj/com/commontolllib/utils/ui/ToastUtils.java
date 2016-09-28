package lwj.com.commontolllib.utils.ui;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static Toast toast = null;

    //	public static void showToast(Context cxt, String str) {
    //		Toast.makeText(PrintApplication.getInstance(), str, Toast.LENGTH_SHORT).show();
    //	}
    //
    //
    //	private ToastDialog(){
    //
    //	}
    //
    //	/**
    //	 * 提示前取消之前正在显示的提示,然后显示
    //	 * @param context
    //	 * @param text
    //	 * @param duration
    //	 */
    //	public static void showToast(Context context, String text, int duration){
    //
    //		if(toast != null){
    //			toast.cancel();
    //			toast = null;
    //		}
    //
    //		toast = Toast.makeText(PrintApplication.getInstance(), text, duration);
    //		toast.show();
    //	}
    //
    //	/**
    //	 * 提示前取消之前正在显示的提示,然后显示
    //	 * @gravity:toast显示的位置
    //	 */
    //	public static void showToast(Context context, String text, int duration, int gravity){
    //
    //		if(toast != null){
    //			toast.cancel();
    //			toast = null;
    //		}
    //
    //		toast = Toast.makeText(PrintApplication.getInstance(), text, duration);
    //
    //		switch (gravity) {
    //
    //			case Gravity.TOP://顶部居中显示
    //			case Gravity.TOP|Gravity.CENTER_HORIZONTAL:
    //				toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 20);
    //				break;
    //
    //			default:
    //				break;
    //		}
    //
    //		toast.show();
    //	}
    //
    //
    //	/**
    //	 * 取消正在显示的提示
    //	 */
    //	public static void dismiss(){
    //
    //		if(toast != null){
    //			toast.cancel();
    //			toast = null;
    //		}
    //	}


    /**
     * 显示土司
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}