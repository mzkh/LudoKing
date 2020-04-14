package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TapjoyCacheMap extends ConcurrentHashMap {

    /* renamed from: a */
    private Context f6466a;

    /* renamed from: b */
    private int f6467b = -1;

    public TapjoyCacheMap(Context context, int i) {
        this.f6466a = context;
        this.f6467b = i;
    }

    /* renamed from: a */
    private String m6516a() {
        long j = -1;
        String str = "";
        for (Entry entry : entrySet()) {
            long timestampInSeconds = ((TapjoyCachedAssetData) entry.getValue()).getTimestampInSeconds();
            if (j == 0 || timestampInSeconds < j) {
                str = (String) entry.getKey();
                j = timestampInSeconds;
            }
        }
        return str;
    }

    public TapjoyCachedAssetData put(String str, TapjoyCachedAssetData tapjoyCachedAssetData) {
        StringBuilder sb = new StringBuilder("TapjoyCacheMap::put() -- key: ");
        sb.append(str);
        sb.append(" assetURL: ");
        sb.append(tapjoyCachedAssetData.getAssetURL());
        TapjoyLog.m6550d("TapjoyCacheMap", sb.toString());
        if (tapjoyCachedAssetData == null || tapjoyCachedAssetData.getTimeOfDeathInSeconds() <= System.currentTimeMillis() / 1000) {
            return null;
        }
        if (size() == this.f6467b) {
            remove((Object) m6516a());
        }
        Editor edit = this.f6466a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
        edit.putString(tapjoyCachedAssetData.getLocalFilePath(), tapjoyCachedAssetData.toRawJSONString());
        edit.apply();
        return (TapjoyCachedAssetData) super.put(str, tapjoyCachedAssetData);
    }

    public TapjoyCachedAssetData remove(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        Editor edit = this.f6466a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
        edit.remove(((TapjoyCachedAssetData) get(obj)).getLocalFilePath());
        edit.apply();
        String localFilePath = ((TapjoyCachedAssetData) get(obj)).getLocalFilePath();
        if (localFilePath != null && localFilePath.length() > 0) {
            TapjoyUtil.deleteFileOrDirectory(new File(localFilePath));
        }
        StringBuilder sb = new StringBuilder("TapjoyCacheMap::remove() -- key: ");
        sb.append(obj);
        TapjoyLog.m6550d("TapjoyCacheMap", sb.toString());
        return (TapjoyCachedAssetData) super.remove(obj);
    }

    public boolean replace(String str, TapjoyCachedAssetData tapjoyCachedAssetData, TapjoyCachedAssetData tapjoyCachedAssetData2) {
        throw new UnsupportedOperationException();
    }

    public TapjoyCachedAssetData replace(String str, TapjoyCachedAssetData tapjoyCachedAssetData) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }
}
