package com.liurl.llib.utils;

import android.content.res.AssetManager;

import com.liurl.llib.x;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Modify by liuruilin on 2017/10/10.
 */
public class FileUtils {

    /**
     * 获取文件大小
     * @param file
     * @return
     */
    public static long getFileOrDirSize(File file) {
        if (!file.exists()) return 0;
        if (!file.isDirectory()) return file.length();

        long length = 0;
        File[] list = file.listFiles();

        // 文件夹被删除时, 子文件正在被写入, 文件属性异常返回null.
        if (list != null) {
            for (File item : list) {
                length += getFileOrDirSize(item);
            }
        }
        return length;
    }

    /**
     * 拷贝程序自带的文件至指定文件
     *
     * @param assetName  程序自带的文件名称
     * @param outputPath 拷贝到指定文件的路径
     */
    public static void copyAssetFile(String assetName, String outputPath) {
        InputStream in = null;
        FileOutputStream out = null;

        try {
            AssetManager assetManager = x.app().getAssets();
            String[] names = assetManager.list("");
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(assetName.trim())) {
                    in = x.app().getAssets().open(assetName);
                    out = new FileOutputStream(outputPath);
                    IOUtils.copy(in, out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 复制文件到指定文件
     *
     * @param fromPath 源文件
     * @param toPath   复制到的文件
     * @return true 成功，false 失败
     */
    public static boolean copy(String fromPath, String toPath) {
        boolean result = false;
        File from = new File(fromPath);
        if (!from.exists()) {
            return result;
        }

        File toFile = new File(toPath);
        deleteFileOrDir(toFile);
        File toDir = toFile.getParentFile();
        if (toDir.exists() || toDir.mkdirs()) {
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                in = new FileInputStream(from);
                out = new FileOutputStream(toFile);
                IOUtils.copy(in, out);
                result = true;
            } catch (Throwable ex) {
                LogUtils.d(ex.getMessage(), ex);
                result = false;
            } finally {
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
            }
        }
        return result;
    }

    /**
     * 删除文件/文件夹
     *
     * @param path
     * @return
     */
    public static boolean deleteFileOrDir(File path) {
        if (path == null || !path.exists()) {
            return true;
        }
        if (path.isFile()) {
            return path.delete();
        }
        File[] files = path.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteFileOrDir(file);
            }
        }
        return path.delete();
    }
}
