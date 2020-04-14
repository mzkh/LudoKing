package com.unity3d.ads.metadata;

import android.content.Context;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageEvent;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.StorageManager.StorageType;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import java.util.Iterator;
import org.json.JSONObject;

public class MetaData extends JsonStorage {
    private String _category;
    protected Context _context;

    public MetaData(Context context) {
        this._context = context.getApplicationContext();
    }

    public void setCategory(String str) {
        this._category = str;
    }

    public String getCategory() {
        return this._category;
    }

    public synchronized boolean set(String str, Object obj) {
        boolean z;
        initData();
        z = false;
        StringBuilder sb = new StringBuilder();
        sb.append(getActualKey(str));
        sb.append(".value");
        if (super.set(sb.toString(), obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getActualKey(str));
            sb2.append(".ts");
            if (super.set(sb2.toString(), Long.valueOf(System.currentTimeMillis()))) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean setRaw(String str, Object obj) {
        initData();
        return super.set(getActualKey(str), obj);
    }

    public void commit() {
        if (StorageManager.init(this._context)) {
            Storage storage = StorageManager.getStorage(StorageType.PUBLIC);
            if (getData() != null && storage != null) {
                Iterator keys = getData().keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Object obj = get(str);
                    if (storage.get(str) != null && (storage.get(str) instanceof JSONObject) && (get(str) instanceof JSONObject)) {
                        try {
                            obj = Utilities.mergeJsonObjects((JSONObject) obj, (JSONObject) storage.get(str));
                        } catch (Exception e) {
                            DeviceLog.exception("Exception merging JSONs", e);
                        }
                    }
                    storage.set(str, obj);
                }
                storage.writeStorage();
                storage.sendEvent(StorageEvent.SET, getData());
                return;
            }
            return;
        }
        DeviceLog.error("Unity Ads could not commit metadata due to storage error");
    }

    private String getActualKey(String str) {
        if (getCategory() == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getCategory());
        sb.append(".");
        sb.append(str);
        return sb.toString();
    }
}
