package com.sf.rxjava.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author  shufei.li on 2016/9/1.
 */
public class FileUtils {
    private static final String KEY_SDCARD = "/sdcard";
    private static byte[] readDeleteSynckey = new byte[0];
    /**
     * 获取SD卡根目录
     */
    public static String getSDPath() {
        if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            File sdDir = Environment.getExternalStorageDirectory();
            return sdDir.getPath();
        }
        return KEY_SDCARD;
    }

    /**
     * 保存资源路径
     * @return
     */
    public static String getLSFNewsootPath() {
        String sdcardPath = getSDPath();
        StringBuffer fileSB = new StringBuffer();
        fileSB.append(sdcardPath).append(File.separator).append("LSFNews");
        String rootPath = fileSB.toString();
        File destDir = new File(rootPath);
        if (!destDir.exists() || destDir.getAbsoluteFile() == null) {
            boolean flag = destDir.mkdirs();
            if (!flag) {
                destDir.delete();
                getLSFNewsootPath();
            }
        }
        return rootPath;
    }

    /**
     * 获取资源名称
     * @param strUrl
     * @return
     */
    public static String getResourceName(String strUrl) {
        String fileName = "";
        try {
            if (!strUrl.equals("")) {
                fileName = strUrl.substring(strUrl.lastIndexOf("/") + 1);
                if ("".equals(fileName)) {
                    return null;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return fileName;
    }

    /**
     * 获取本地缓存图片路径
     * @return
     */
    public static String getCacheImageFolderPath() {
        String sdcardPath = getLSFNewsootPath();
        StringBuffer fileSB = new StringBuffer();
        fileSB.append(sdcardPath).append(File.separator).append("test");
        String rootPath = fileSB.toString();
        File destDir = new File(rootPath);
        if (!destDir.exists() || destDir.getAbsoluteFile() == null) {
            destDir.mkdirs();
        }
        return rootPath;
    }

    /**
     * 根据文件路径读取图片
     *
     * @param fileLocalPath
     * @return
     */
    @SuppressWarnings("resource")
    public static Bitmap readLocalCacheImage(String fileLocalPath) {
        Bitmap bm = null;
        synchronized (readDeleteSynckey) {
            try {
                BitmapFactory.Options bfOptions = new BitmapFactory.Options();
                bfOptions.inDither = false;
                bfOptions.inPurgeable = true;
                bfOptions.inInputShareable = true;
                bfOptions.inTempStorage = new byte[32 * 1024];
                FileInputStream fin = new FileInputStream(fileLocalPath);
                bm = BitmapFactory.decodeFileDescriptor(fin.getFD(), null,bfOptions);
            } catch (Exception e) {
                e.printStackTrace();
                return bm;
            }
        }
        return bm;
    }
}
