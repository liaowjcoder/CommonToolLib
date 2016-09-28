package lwj.com.commontolllib.utils.ui;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 廖伟健
 * @time 2016/6/8 14:55
 * @des 键盘工具类
 */
public class KeyBoardToolUtils {
    /**
     * 隐藏虚拟键盘
     *
     * @param v 需要提供一个可以获取焦点的view 例如editext若是其他view有可能隐藏不成功
     */
    public static void HideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

        }
    }

    /**
     * 显示虚拟键盘tooltool
     *
     * @param v 需要提供一个可以获取焦点的view 例如editext若是其他view有可能隐藏不成功
     */
    public static void ShowKeyboard(final View v) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
            }
        };
        timer.schedule(task, 500);
    }


}
