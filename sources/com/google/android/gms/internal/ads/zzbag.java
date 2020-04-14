package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbag implements zzgf, zzlp, zzns<zzne>, zzow {
    @VisibleForTesting
    private static int zzeci;
    @VisibleForTesting
    private static int zzecj;
    private int bytesTransferred;
    private final zzazk zzebk;
    private final zzbad zzeck;
    private final zzgx zzecl;
    private final zzgx zzecm;
    private final zzms zzecn;
    private zzgc zzeco;
    private ByteBuffer zzecp;
    private boolean zzecq;
    private zzbao zzecr;
    private Set<WeakReference<zzazz>> zzecs = new HashSet();
    private final Context zzlk;

    public zzbag(Context context, zzazk zzazk) {
        this.zzlk = context;
        this.zzebk = zzazk;
        this.zzeck = new zzbad();
        zzoq zzoq = new zzoq(this.zzlk, zzkn.zzaza, 0, zzaul.zzdsu, this, -1);
        this.zzecl = zzoq;
        this.zzecm = new zzib(zzkn.zzaza);
        this.zzecn = new zzmn();
        if (zzaug.zzuu()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzaug.zzdy(sb.toString());
        }
        zzeci++;
        this.zzeco = zzgg.zza(new zzgx[]{this.zzecm, this.zzecl}, this.zzecn, this.zzeck);
        this.zzeco.zza((zzgf) this);
    }

    public final void zza(zzgu zzgu) {
    }

    public final void zza(zzgy zzgy, Object obj) {
    }

    public final void zza(zzmk zzmk, zzmv zzmv) {
    }

    public final void zzb(Surface surface) {
    }

    public final void zzd(String str, long j, long j2) {
    }

    public final void zzdx() {
    }

    public final void zze(zzil zzil) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final void zzf(int i, long j) {
    }

    public final void zzf(zzil zzil) {
    }

    public final void zzf(boolean z) {
    }

    public final void zzk(zzgo zzgo) {
    }

    public final zzgc zzyo() {
        return this.zzeco;
    }

    public static int zzyp() {
        return zzeci;
    }

    public static int zzyq() {
        return zzecj;
    }

    public final void zza(zzbao zzbao) {
        this.zzecr = zzbao;
    }

    public final zzbad zzyr() {
        return this.zzeck;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzlu zzlu;
        if (this.zzeco != null) {
            this.zzecp = byteBuffer;
            this.zzecq = z;
            if (uriArr.length == 1) {
                zzlu = zzb(uriArr[0], str);
            } else {
                zzlu[] zzluArr = new zzlu[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzluArr[i] = zzb(uriArr[i], str);
                }
                zzlu = new zzlv(zzluArr);
            }
            this.zzeco.zza(zzlu);
            zzecj++;
        }
    }

    public final void release() {
        zzgc zzgc = this.zzeco;
        if (zzgc != null) {
            zzgc.zzb((zzgf) this);
            this.zzeco.release();
            this.zzeco = null;
            zzecj--;
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    public final void zzb(IOException iOException) {
        zzbao zzbao = this.zzecr;
        if (zzbao != null) {
            zzbao.zza("onLoadError", iOException);
        }
    }

    public final void zzb(int i, int i2, int i3, float f) {
        zzbao zzbao = this.zzecr;
        if (zzbao != null) {
            zzbao.zzm(i, i2);
        }
    }

    public final void zza(boolean z, int i) {
        zzbao zzbao = this.zzecr;
        if (zzbao != null) {
            zzbao.zzcx(i);
        }
    }

    public final void zza(zzgd zzgd) {
        zzbao zzbao = this.zzecr;
        if (zzbao != null) {
            zzbao.zza("onPlayerError", zzgd);
        }
    }

    public final void zzcw(int i) {
        for (WeakReference weakReference : this.zzecs) {
            zzazz zzazz = (zzazz) weakReference.get();
            if (zzazz != null) {
                zzazz.setReceiveBufferSize(i);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Surface surface, boolean z) {
        if (this.zzeco != null) {
            zzgh zzgh = new zzgh(this.zzecl, 1, surface);
            if (z) {
                this.zzeco.zzb(zzgh);
                return;
            }
            this.zzeco.zza(zzgh);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(float f, boolean z) {
        if (this.zzeco != null) {
            zzgh zzgh = new zzgh(this.zzecm, 2, Float.valueOf(f));
            if (z) {
                this.zzeco.zzb(zzgh);
                return;
            }
            this.zzeco.zza(zzgh);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzap(boolean z) {
        if (this.zzeco != null) {
            for (int i = 0; i < this.zzeco.zzdv(); i++) {
                this.zzecn.zzf(i, !z);
            }
        }
    }

    @VisibleForTesting
    private final zzlu zzb(Uri uri, String str) {
        zznd zznd;
        zznd zznd2;
        if (!this.zzecq || this.zzecp.limit() <= 0) {
            if (this.zzebk.zzeaq > 0) {
                zznd2 = new zzbai(this, str);
            } else {
                zznd2 = new zzbah(this, str);
            }
            zznd zzbak = this.zzebk.zzear ? new zzbak(this, zznd2) : zznd2;
            if (this.zzecp.limit() > 0) {
                byte[] bArr = new byte[this.zzecp.limit()];
                this.zzecp.get(bArr);
                zzbak = new zzbaj(zzbak, bArr);
            }
            zznd = zzbak;
        } else {
            byte[] bArr2 = new byte[this.zzecp.limit()];
            this.zzecp.get(bArr2);
            zznd = new zzbaf(bArr2);
        }
        zzlq zzlq = new zzlq(uri, zznd, zzbam.zzecw, this.zzebk.zzeas, zzaul.zzdsu, this, null, this.zzebk.zzeao);
        return zzlq;
    }

    public final void finalize() throws Throwable {
        zzeci--;
        if (zzaug.zzuu()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzaug.zzdy(sb.toString());
        }
    }

    public final /* synthetic */ void zzc(Object obj, int i) {
        this.bytesTransferred += i;
    }

    public final /* synthetic */ void zza(Object obj, zznf zznf) {
        this.bytesTransferred = 0;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzne zza(zznd zznd) {
        return new zzbab(this.zzlk, zznd.zzib(), this, new zzbal(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbao zzbao = this.zzecr;
        if (zzbao != null) {
            zzbao.zzb(z, j);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzne zzfb(String str) {
        zznh zznh = new zznh(str, null, this.zzebk.zzear ? null : this, this.zzebk.zzeal, this.zzebk.zzean, true, null);
        return zznh;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzne zzfc(String str) {
        zzazz zzazz = new zzazz(str, this.zzebk.zzear ? null : this, this.zzebk.zzeal, this.zzebk.zzean, this.zzebk.zzeaq);
        this.zzecs.add(new WeakReference(zzazz));
        return zzazz;
    }
}
