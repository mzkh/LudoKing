package com.google.ads.mediation.inmobi;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class InMobiMemoryCache {
    private static final String TAG = "MemoryCache";
    private final Map<String, Drawable> mCache = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
    private long mLimit = 1000000;
    private long mSize = 0;

    InMobiMemoryCache() {
        setLimit(Runtime.getRuntime().maxMemory() / 4);
    }

    private void setLimit(long j) {
        this.mLimit = j;
        StringBuilder sb = new StringBuilder();
        sb.append("MemoryCache will use up to ");
        double d = (double) this.mLimit;
        Double.isNaN(d);
        sb.append((d / 1024.0d) / 1024.0d);
        sb.append("MB");
        Log.i(TAG, sb.toString());
    }

    public Drawable get(String str) {
        try {
            if (!this.mCache.containsKey(str)) {
                return null;
            }
            return (Drawable) this.mCache.get(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void put(String str, Drawable drawable) {
        try {
            if (this.mCache.containsKey(str)) {
                this.mSize -= getSizeInBytes(((BitmapDrawable) this.mCache.get(str)).getBitmap());
            }
            this.mCache.put(str, drawable);
            this.mSize += getSizeInBytes(((BitmapDrawable) drawable).getBitmap());
            checkSize();
            Log.d(TAG, "Drawable used from cache");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void checkSize() {
        StringBuilder sb = new StringBuilder();
        sb.append("cache size=");
        sb.append(this.mSize);
        sb.append(" length=");
        sb.append(this.mCache.size());
        String sb2 = sb.toString();
        String str = TAG;
        Log.i(str, sb2);
        if (this.mSize > this.mLimit) {
            Iterator it = this.mCache.entrySet().iterator();
            while (it.hasNext()) {
                this.mSize -= getSizeInBytes(((BitmapDrawable) ((Entry) it.next()).getValue()).getBitmap());
                it.remove();
                if (this.mSize <= this.mLimit) {
                    break;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Clean cache. New size ");
            sb3.append(this.mCache.size());
            Log.i(str, sb3.toString());
        }
    }

    public void clear() {
        try {
            this.mCache.clear();
            this.mSize = 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private long getSizeInBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return (long) (bitmap.getRowBytes() * bitmap.getHeight());
    }
}
