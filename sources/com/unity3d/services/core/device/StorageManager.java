package com.unity3d.services.core.device;

import android.content.Context;
import com.appsflyer.share.Constants;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageManager {
    private static final Map<StorageType, String> _storageFileMap = Collections.synchronizedMap(new HashMap());
    private static final List<Storage> _storages = Collections.synchronizedList(new ArrayList());

    public enum StorageType {
        PRIVATE,
        PUBLIC
    }

    public static boolean init(Context context) {
        if (context == null) {
            return false;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return false;
        }
        StorageType storageType = StorageType.PUBLIC;
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir);
        String str = Constants.URL_PATH_DELIMITER;
        sb.append(str);
        sb.append(SdkProperties.getLocalStorageFilePrefix());
        sb.append("public-data.json");
        addStorageLocation(storageType, sb.toString());
        if (!setupStorage(StorageType.PUBLIC)) {
            return false;
        }
        StorageType storageType2 = StorageType.PRIVATE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(filesDir);
        sb2.append(str);
        sb2.append(SdkProperties.getLocalStorageFilePrefix());
        sb2.append("private-data.json");
        addStorageLocation(storageType2, sb2.toString());
        if (!setupStorage(StorageType.PRIVATE)) {
            return false;
        }
        return true;
    }

    public static void initStorage(StorageType storageType) {
        if (hasStorage(storageType)) {
            Storage storage = getStorage(storageType);
            if (storage != null) {
                storage.initStorage();
            }
        } else if (_storageFileMap.containsKey(storageType)) {
            Storage storage2 = new Storage((String) _storageFileMap.get(storageType), storageType);
            storage2.initStorage();
            _storages.add(storage2);
        }
    }

    private static boolean setupStorage(StorageType storageType) {
        if (!hasStorage(storageType)) {
            initStorage(storageType);
            Storage storage = getStorage(storageType);
            if (storage != null && !storage.storageFileExists()) {
                storage.writeStorage();
            }
            if (storage == null) {
                return false;
            }
        }
        return true;
    }

    public static Storage getStorage(StorageType storageType) {
        List<Storage> list = _storages;
        if (list != null) {
            synchronized (list) {
                for (Storage storage : _storages) {
                    if (storage.getType().equals(storageType)) {
                        return storage;
                    }
                }
            }
        }
        return null;
    }

    public static boolean hasStorage(StorageType storageType) {
        List<Storage> list = _storages;
        if (list != null) {
            synchronized (list) {
                for (Storage type : _storages) {
                    if (type.getType().equals(storageType)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static synchronized void addStorageLocation(StorageType storageType, String str) {
        synchronized (StorageManager.class) {
            if (!_storageFileMap.containsKey(storageType)) {
                _storageFileMap.put(storageType, str);
            }
        }
    }

    public static synchronized void removeStorage(StorageType storageType) {
        synchronized (StorageManager.class) {
            if (getStorage(storageType) != null) {
                _storages.remove(getStorage(storageType));
            }
            if (_storageFileMap != null) {
                _storageFileMap.remove(storageType);
            }
        }
    }
}
