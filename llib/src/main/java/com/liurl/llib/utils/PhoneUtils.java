package com.liurl.llib.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;
/**
 * Created by liuruilin on 2017/10/10.
 */

public class PhoneUtils {
    public PhoneUtils() {
    }

    /**
     * SD 卡是否存在
     * @return
     */
    public static boolean isSdCardExists() {
        return "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    /**
     * 获取 SD 卡根目录
     * @return
     */
    public static String getSdCardRootPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * SD 卡空间是否足够存放当前文件
     * @param size 当前文件的大小
     * @return
     */
    public static boolean isSdCardAvailableSizeEnough(int size) {
        if (!isSdCardExists()) {
            return false;
        } else {
            StatFs var1 = new StatFs(getSdCardRootPath());
            long var2 = (long) var1.getBlockSize();
            long var4 = (long) var1.getAvailableBlocks();
            int var6 = (int) (var4 * var2 / 1024L / 1024L);
            return var6 > size;
        }
    }

    /**
     * 获取设备的 IMEI
     * @param context
     * @return
     */
    public static String getImeiId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "没有获取 IMEI 的权限";
        }
        return telephonyManager.getDeviceId();
    }


}
