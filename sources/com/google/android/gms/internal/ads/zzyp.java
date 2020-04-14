package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzyp<T> {
    private final String zzce;
    private final int zzcfp;
    private final T zzcfq;

    private zzyp(int i, String str, T t) {
        this.zzcfp = i;
        this.zzce = str;
        this.zzcfq = t;
        zzuv.zzom().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract T zza(JSONObject jSONObject);

    public abstract void zza(Editor editor, T t);

    public final String getKey() {
        return this.zzce;
    }

    public final T zzpq() {
        return this.zzcfq;
    }

    public static zzyp<Boolean> zza(int i, String str, Boolean bool) {
        return new zzyo(i, str, bool);
    }

    public static zzyp<Integer> zza(int i, String str, int i2) {
        return new zzyr(i, str, Integer.valueOf(i2));
    }

    public static zzyp<Long> zza(int i, String str, long j) {
        return new zzyq(i, str, Long.valueOf(j));
    }

    public static zzyp<Float> zza(int i, String str, float f) {
        return new zzyt(i, str, Float.valueOf(f));
    }

    public static zzyp<String> zza(int i, String str, String str2) {
        return new zzys(i, str, str2);
    }

    public static zzyp<String> zzb(int i, String str) {
        zzyp<String> zza = zza(i, str, (String) null);
        zzuv.zzom().zzb(zza);
        return zza;
    }

    public static zzyp<String> zzc(int i, String str) {
        zzyp<String> zza = zza(i, str, (String) null);
        zzuv.zzom().zzc(zza);
        return zza;
    }

    public final int getSource() {
        return this.zzcfp;
    }

    /* synthetic */ zzyp(int i, String str, Object obj, zzyo zzyo) {
        this(i, str, obj);
    }
}
