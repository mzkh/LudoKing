package com.unity3d.services.core.cache;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CacheDirectory {
    private static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    private String _cacheDirName;
    private File _cacheDirectory = null;
    private boolean _initialized = false;
    private CacheDirectoryType _type = null;

    public CacheDirectory(String str) {
        this._cacheDirName = str;
    }

    public File getCacheDirectory(Context context) {
        File file;
        if (this._initialized) {
            return this._cacheDirectory;
        }
        this._initialized = true;
        if (VERSION.SDK_INT > 18) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                try {
                    file = createCacheDirectory(context.getExternalCacheDir(), this._cacheDirName);
                } catch (Exception e) {
                    DeviceLog.exception("Creating external cache directory failed", e);
                    file = null;
                }
                if (testCacheDirectory(file)) {
                    createNoMediaFile(file);
                    this._cacheDirectory = file;
                    this._type = CacheDirectoryType.EXTERNAL;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unity Ads is using external cache directory: ");
                    sb.append(file.getAbsolutePath());
                    DeviceLog.debug(sb.toString());
                    return this._cacheDirectory;
                }
            } else {
                DeviceLog.debug("External media not mounted");
            }
        }
        File filesDir = context.getFilesDir();
        if (testCacheDirectory(filesDir)) {
            this._cacheDirectory = filesDir;
            this._type = CacheDirectoryType.INTERNAL;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unity Ads is using internal cache directory: ");
            sb2.append(filesDir.getAbsolutePath());
            DeviceLog.debug(sb2.toString());
            return this._cacheDirectory;
        }
        DeviceLog.error("Unity Ads failed to initialize cache directory");
        return null;
    }

    public CacheDirectoryType getType() {
        return this._type;
    }

    public File createCacheDirectory(File file, String str) {
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        if (file2.isDirectory()) {
            return file2;
        }
        return null;
    }

    public boolean testCacheDirectory(File file) {
        String str = "UTF-8";
        String str2 = "test";
        if (file != null && file.isDirectory()) {
            try {
                byte[] bytes = str2.getBytes(str);
                byte[] bArr = new byte[bytes.length];
                File file2 = new File(file, TEST_FILE_NAME);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                FileInputStream fileInputStream = new FileInputStream(file2);
                int read = fileInputStream.read(bArr, 0, bArr.length);
                fileInputStream.close();
                if (!file2.delete()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete testfile ");
                    sb.append(file2.getAbsoluteFile());
                    DeviceLog.debug(sb.toString());
                    return false;
                } else if (read != bArr.length) {
                    DeviceLog.debug("Read buffer size mismatch");
                    return false;
                } else if (new String(bArr, str).equals(str2)) {
                    return true;
                } else {
                    DeviceLog.debug("Read buffer content mismatch");
                    return false;
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unity Ads exception while testing cache directory ");
                sb2.append(file.getAbsolutePath());
                sb2.append(": ");
                sb2.append(e.getMessage());
                DeviceLog.debug(sb2.toString());
            }
        }
        return false;
    }

    private void createNoMediaFile(File file) {
        try {
            if (new File(file, ".nomedia").createNewFile()) {
                DeviceLog.debug("Successfully created .nomedia file");
            } else {
                DeviceLog.debug("Using existing .nomedia file");
            }
        } catch (Exception e) {
            DeviceLog.exception("Failed to create .nomedia file", e);
        }
    }
}
