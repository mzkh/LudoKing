package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzq<T> implements Comparable<zzq<T>> {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zza zzae;
    private final int zzaf;
    private final String zzag;
    private final int zzah;
    @GuardedBy("mLock")
    @Nullable
    private zzy zzai;
    private Integer zzaj;
    private zzu zzak;
    private boolean zzal;
    @GuardedBy("mLock")
    private boolean zzam;
    @GuardedBy("mLock")
    private boolean zzan;
    private boolean zzao;
    private zzad zzap;
    private zzd zzaq;
    @GuardedBy("mLock")
    private zzs zzar;

    public zzq(int i, String str, @Nullable zzy zzy) {
        this.zzae = zza.zzbl ? new zza() : null;
        this.mLock = new Object();
        this.zzal = true;
        int i2 = 0;
        this.zzam = false;
        this.zzan = false;
        this.zzao = false;
        this.zzaq = null;
        this.zzaf = i;
        this.zzag = str;
        this.zzai = zzy;
        this.zzap = new zzg();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.zzah = i2;
    }

    /* access modifiers changed from: protected */
    public abstract zzz<T> zza(zzo zzo);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    public byte[] zzf() throws zzb {
        return null;
    }

    public final int getMethod() {
        return this.zzaf;
    }

    public final int zzc() {
        return this.zzah;
    }

    public final void zzb(String str) {
        if (zza.zzbl) {
            this.zzae.zza(str, Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(String str) {
        zzu zzu = this.zzak;
        if (zzu != null) {
            zzu.zzf(this);
        }
        if (zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzt(this, str, id));
            } else {
                this.zzae.zza(str, id);
                this.zzae.zzc(toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i) {
        zzu zzu = this.zzak;
        if (zzu != null) {
            zzu.zza(this, i);
        }
    }

    public final zzq<?> zza(zzu zzu) {
        this.zzak = zzu;
        return this;
    }

    public final zzq<?> zzb(int i) {
        this.zzaj = Integer.valueOf(i);
        return this;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final String zzd() {
        String str = this.zzag;
        int i = this.zzaf;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzq<?> zza(zzd zzd) {
        this.zzaq = zzd;
        return this;
    }

    public final zzd zze() {
        return this.zzaq;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public Map<String, String> getHeaders() throws zzb {
        return Collections.emptyMap();
    }

    public final boolean zzg() {
        return this.zzal;
    }

    public final int zzh() {
        return this.zzap.zza();
    }

    public final zzad zzi() {
        return this.zzap;
    }

    public final void zzj() {
        synchronized (this.mLock) {
            this.zzan = true;
        }
    }

    public final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzan;
        }
        return z;
    }

    public final void zzb(zzae zzae2) {
        zzy zzy;
        synchronized (this.mLock) {
            zzy = this.zzai;
        }
        if (zzy != null) {
            zzy.zzc(zzae2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzs zzs) {
        synchronized (this.mLock) {
            this.zzar = zzs;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzz<?> zzz) {
        zzs zzs;
        synchronized (this.mLock) {
            zzs = this.zzar;
        }
        if (zzs != null) {
            zzs.zza(this, zzz);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzl() {
        zzs zzs;
        synchronized (this.mLock) {
            zzs = this.zzar;
        }
        if (zzs != null) {
            zzs.zza(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzah));
        String str = "0x";
        String concat = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        isCanceled();
        String str2 = "[ ] ";
        String str3 = this.zzag;
        String valueOf2 = String.valueOf(zzv.NORMAL);
        String valueOf3 = String.valueOf(this.zzaj);
        StringBuilder sb = new StringBuilder(str2.length() + 3 + String.valueOf(str3).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(str2);
        sb.append(str3);
        String str4 = " ";
        sb.append(str4);
        sb.append(concat);
        sb.append(str4);
        sb.append(valueOf2);
        sb.append(str4);
        sb.append(valueOf3);
        return sb.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzq zzq = (zzq) obj;
        zzv zzv = zzv.NORMAL;
        zzv zzv2 = zzv.NORMAL;
        return zzv == zzv2 ? this.zzaj.intValue() - zzq.zzaj.intValue() : zzv2.ordinal() - zzv.ordinal();
    }
}
