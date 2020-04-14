package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzfj {
    private static final String TAG = "zzfj";
    private final String className;
    private final String zzaaj;
    private final int zzaak = 2;
    private volatile Method zzaal = null;
    private final Class<?>[] zzaam;
    private CountDownLatch zzaan = new CountDownLatch(1);
    private final zzdx zzvo;

    public zzfj(zzdx zzdx, String str, String str2, Class<?>... clsArr) {
        this.zzvo = zzdx;
        this.className = str;
        this.zzaaj = str2;
        this.zzaam = clsArr;
        this.zzvo.zzce().submit(new zzfi(this));
    }

    /* access modifiers changed from: private */
    public final void zzcy() {
        try {
            Class loadClass = this.zzvo.zzcf().loadClass(zzb(this.zzvo.zzch(), this.className));
            if (loadClass != null) {
                this.zzaal = loadClass.getMethod(zzb(this.zzvo.zzch(), this.zzaaj), this.zzaam);
                if (this.zzaal == null) {
                    this.zzaan.countDown();
                } else {
                    this.zzaan.countDown();
                }
            }
        } catch (zzdk unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzaan.countDown();
        }
    }

    private final String zzb(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.zzvo.zzcg().zza(bArr, str), "UTF-8");
    }

    public final Method zzcz() {
        if (this.zzaal != null) {
            return this.zzaal;
        }
        Method method = null;
        try {
            if (!this.zzaan.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            method = this.zzaal;
            return method;
        } catch (InterruptedException unused) {
        }
    }
}
