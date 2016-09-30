package lwj.com.commontolllib.utils.app;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;

import java.util.List;

/**
 * @作者 廖伟健
 * @创建时间 2016/9/28 10:29
 * @描述 获得系统服务管理器
 */
public class ServiceManagerUtils {

    private static ConnectivityManager cm;
    private static LocationManager locationManager;
    private static TelephonyManager telephonyManager;
    private static InputMethodManager inputMethodManager;
    private static Vibrator vibrator;
    private static SensorManager sensorManager;
    private static Sensor accelerometerSensor;
    private static Sensor lightSensor;//光线传感器引用
    private static LayoutInflater inflater;

    private ServiceManagerUtils() {
    }

    ;

    /**
     * 获得ConnectivityManager
     *
     * @param context
     *
     * @return
     */
    public static ConnectivityManager getConnectivityManager(Context context) {

        if (cm == null) {
            synchronized (ServiceManagerUtils.class) {
                if (cm == null) {
                    cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                }
            }
        }
        return cm;
    }

    /**
     * 获得LocationManager
     *
     * @param context
     *
     * @return
     */
    public static LocationManager getLocationManager(Context context) {
        if (locationManager == null) {
            synchronized (ServiceManagerUtils.class) {
                if (locationManager == null) {
                    locationManager = ((LocationManager) context.getSystemService(Context.LOCATION_SERVICE));
                }
            }
        }
        return locationManager;
    }

    /**
     * 获得TelephonyManager
     *
     * @param context
     *
     * @return
     */
    public static TelephonyManager getTelephonyManager(Context context) {
        if (telephonyManager == null) {
            synchronized (ServiceManagerUtils.class) {
                if (telephonyManager == null) {
                    telephonyManager = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE));
                }
            }
        }
        return telephonyManager;
    }

    /**
     * 获得InputMethodManager
     *
     * @param context
     *
     * @return
     */
    public static InputMethodManager getInputMethodManager(Context context) {
        if (inputMethodManager == null) {
            synchronized (ServiceManagerUtils.class) {
                if (inputMethodManager == null) {
                    inputMethodManager = ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE));
                }
            }
        }
        return inputMethodManager;
    }

    /**
     * 获得震动的控制器
     *
     * @param context
     *
     * @return
     */
    public static Vibrator getVibrator(Context context) {
        if (vibrator == null) {
            synchronized (ServiceManagerUtils.class) {
                if (vibrator == null) {
                    vibrator = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
                }
            }
        }
        return vibrator;
    }

    /**
     * 获得传感器管理器
     *
     * @param context
     *
     * @return
     */
    public static SensorManager getSensorManager(Context context) {
        if (sensorManager == null) {
            synchronized (ServiceManagerUtils.class) {
                if (sensorManager == null) {
                    sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
                }
            }
        }
        return sensorManager;
    }

    /**
     * 获得加速管理器
     *
     * @param context
     *
     * @return
     */
    public static Sensor getAccelerometerSensor(Context context) {
        if (accelerometerSensor == null) {
            synchronized (ServiceManagerUtils.class) {
                if (accelerometerSensor == null) {
                    accelerometerSensor = getSensorManager(context).getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                }
            }
        }
        return accelerometerSensor;
    }

    public static Sensor getLightSensor(Context context) {
        if (lightSensor == null) {
            synchronized (ServiceManagerUtils.class) {
                if (lightSensor == null) {
                    lightSensor = getSensorManager(context).getDefaultSensor(Sensor.TYPE_LIGHT);
                }
            }
        }
        return lightSensor;
    }

    public static LayoutInflater getLayoutInflate(Context context) {
        if (inflater == null) {
            synchronized (ServiceManagerUtils.class) {
                if (inflater == null) {
                    inflater = LayoutInflater.from(context);
                }
            }
        }
        return inflater;
    }

    /**
     * 判断当前App是否处于前台
     *
     * @param context
     *
     * @return 权限：<uses-permission android:name="android.permission.GET_TASKS" />
     */
    public static boolean isApplicationBackground(final Context context) {
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        @SuppressWarnings("deprecation")
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断当前设备是否为手机
     *
     * @param context
     *
     * @return
     */
    public static boolean isPhone(Context context) {
        TelephonyManager telephony = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (telephony.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE) {
            return false;
        } else {
            return true;
        }
    }
}
