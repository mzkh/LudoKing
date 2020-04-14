package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class AFEvent {
    @Nullable

    /* renamed from: ʻ */
    String f3287;

    /* renamed from: ʻॱ */
    private final boolean f3288;

    /* renamed from: ʼ */
    Map<String, Object> f3289;

    /* renamed from: ʽ */
    public String f3290;

    /* renamed from: ˊ */
    public Context f3291;

    /* renamed from: ˊॱ */
    public int f3292;

    /* renamed from: ˋ */
    public Map<String, Object> f3293;

    /* renamed from: ˋॱ */
    boolean f3294;

    /* renamed from: ˎ */
    public WeakReference<Context> f3295;

    /* renamed from: ˏ */
    AppsFlyerTrackingRequestListener f3296;

    /* renamed from: ˏॱ */
    String f3297;

    /* renamed from: ͺ */
    public String f3298;
    @Nullable

    /* renamed from: ॱ */
    public Intent f3299;

    /* renamed from: ॱˊ */
    byte[] f3300;

    /* renamed from: ॱॱ */
    String f3301;

    /* renamed from: ᐝ */
    public String f3302;

    public AFEvent() {
        this(true);
    }

    protected AFEvent(boolean z) {
        this.f3288 = z;
    }

    public AFEvent context(Context context) {
        this.f3291 = context;
        return this;
    }

    /* access modifiers changed from: protected */
    public AFEvent urlString(String str) {
        this.f3297 = str;
        return this;
    }

    @Nullable
    public Intent intent() {
        return this.f3299;
    }

    public AFEvent post(byte[] bArr) {
        this.f3300 = bArr;
        return this;
    }

    public AFEvent cacheKey(String str) {
        this.f3301 = str;
        return this;
    }

    public boolean isEncrypt() {
        return this.f3288;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final AFEvent mo10644() {
        Context context = this.f3291;
        Context context2 = null;
        if (context == null) {
            WeakReference<Context> weakReference = this.f3295;
            context = weakReference != null ? (Context) weakReference.get() : null;
        }
        if (context != null) {
            Context context3 = this.f3291;
            if (context3 != null) {
                context2 = context3;
            } else {
                WeakReference<Context> weakReference2 = this.f3295;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                }
            }
            this.f3291 = context2.getApplicationContext();
        }
        return this;
    }
}
