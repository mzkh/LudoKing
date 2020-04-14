package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.appsflyer.share.Constants;
import com.google.android.gms.ads.internal.zzq;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazq extends zzayu implements SurfaceTextureListener, zzbao {
    private Surface zzbhs;
    private final zzazm zzdxb;
    private final boolean zzdxc;
    private int zzdxh;
    private int zzdxi;
    private int zzdxk;
    private int zzdxl;
    private zzazh zzdxm;
    private final boolean zzdxn;
    private zzayr zzdxp;
    private final zzazj zzdya;
    private String[] zzdyn;
    private final zzazk zzebk;
    private zzbag zzebl;
    private String zzebm;
    private boolean zzebn;
    private int zzebo = 1;
    private boolean zzebp;
    private boolean zzebq;
    private float zzebr;

    public zzazq(Context context, zzazm zzazm, zzazj zzazj, boolean z, boolean z2, zzazk zzazk) {
        super(context);
        this.zzdxc = z2;
        this.zzdya = zzazj;
        this.zzdxb = zzazm;
        this.zzdxn = z;
        this.zzebk = zzazk;
        setSurfaceTextureListener(this);
        this.zzdxb.zzb(this);
    }

    private final zzbag zzxz() {
        return new zzbag(this.zzdya.getContext(), this.zzebk);
    }

    private final String zzya() {
        return zzq.zzkj().zzr(this.zzdya.getContext(), this.zzdya.zzxr().zzblz);
    }

    private final boolean zzyb() {
        return this.zzebl != null && !this.zzebn;
    }

    private final boolean zzyc() {
        return zzyb() && this.zzebo != 1;
    }

    private final void zzyd() {
        if (this.zzebl == null) {
            String str = this.zzebm;
            if (!(str == null || this.zzbhs == null)) {
                if (str.startsWith("cache:")) {
                    zzbax zzez = this.zzdya.zzez(this.zzebm);
                    if (zzez instanceof zzbbm) {
                        this.zzebl = ((zzbbm) zzez).zzyu();
                    } else if (zzez instanceof zzbbj) {
                        zzbbj zzbbj = (zzbbj) zzez;
                        String zzya = zzya();
                        ByteBuffer byteBuffer = zzbbj.getByteBuffer();
                        boolean zzys = zzbbj.zzys();
                        String url = zzbbj.getUrl();
                        if (url == null) {
                            zzaug.zzeu("Stream cache URL is null.");
                            return;
                        } else {
                            this.zzebl = zzxz();
                            this.zzebl.zza(new Uri[]{Uri.parse(url)}, zzya, byteBuffer, zzys);
                        }
                    } else {
                        String str2 = "Stream cache miss: ";
                        String valueOf = String.valueOf(this.zzebm);
                        zzaug.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        return;
                    }
                } else {
                    this.zzebl = zzxz();
                    String zzya2 = zzya();
                    Uri[] uriArr = new Uri[this.zzdyn.length];
                    int i = 0;
                    while (true) {
                        String[] strArr = this.zzdyn;
                        if (i >= strArr.length) {
                            break;
                        }
                        uriArr[i] = Uri.parse(strArr[i]);
                        i++;
                    }
                    this.zzebl.zza(uriArr, zzya2);
                }
                this.zzebl.zza((zzbao) this);
                zza(this.zzbhs, false);
                this.zzebo = this.zzebl.zzyo().getPlaybackState();
                if (this.zzebo == 3) {
                    zzye();
                }
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zza(surface, z);
        } else {
            zzaug.zzeu("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzb(f, z);
        } else {
            zzaug.zzeu("Trying to set volume before player is initalized.");
        }
    }

    public final void zzwu() {
        zza(this.zzdxy.getVolume(), false);
    }

    private final void zzye() {
        if (!this.zzebp) {
            this.zzebp = true;
            zzaul.zzdsu.post(new zzazp(this));
            zzwu();
            this.zzdxb.zzel();
            if (this.zzebq) {
                play();
            }
        }
    }

    public final String zzwq() {
        String str = this.zzdxn ? " spherical" : "";
        String str2 = "ExoPlayer/3";
        return str.length() != 0 ? str2.concat(str) : new String(str2);
    }

    public final void zza(zzayr zzayr) {
        this.zzdxp = zzayr;
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzebm = str;
            this.zzdyn = new String[]{str};
            zzyd();
        }
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzebm = str;
            this.zzdyn = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzyd();
        }
    }

    public final void play() {
        if (zzyc()) {
            if (this.zzebk.zzeai) {
                zzyg();
            }
            this.zzebl.zzyo().zze(true);
            this.zzdxb.zzxw();
            this.zzdxy.zzxw();
            this.zzdxx.zzww();
            zzaul.zzdsu.post(new zzazu(this));
            return;
        }
        this.zzebq = true;
    }

    public final void stop() {
        if (zzyb()) {
            this.zzebl.zzyo().stop();
            if (this.zzebl != null) {
                zza((Surface) null, true);
                zzbag zzbag = this.zzebl;
                if (zzbag != null) {
                    zzbag.zza((zzbao) null);
                    this.zzebl.release();
                    this.zzebl = null;
                }
                this.zzebo = 1;
                this.zzebn = false;
                this.zzebp = false;
                this.zzebq = false;
            }
        }
        this.zzdxb.zzxx();
        this.zzdxy.zzxx();
        this.zzdxb.onStop();
    }

    public final void pause() {
        if (zzyc()) {
            if (this.zzebk.zzeai) {
                zzyh();
            }
            this.zzebl.zzyo().zze(false);
            this.zzdxb.zzxx();
            this.zzdxy.zzxx();
            zzaul.zzdsu.post(new zzazt(this));
        }
    }

    public final void seekTo(int i) {
        if (zzyc()) {
            this.zzebl.zzyo().seekTo((long) i);
        }
    }

    public final void zzcs(int i) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzyr().zzcz(i);
        }
    }

    public final void zzct(int i) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzyr().zzda(i);
        }
    }

    public final void zzcu(int i) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzyr().zzcu(i);
        }
    }

    public final void zzcv(int i) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzyr().zzcv(i);
        }
    }

    public final void zzcw(int i) {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzcw(i);
        }
    }

    public final void zza(float f, float f2) {
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzb(f, f2);
        }
    }

    public final int getCurrentPosition() {
        if (zzyc()) {
            return (int) this.zzebl.zzyo().zzdw();
        }
        return 0;
    }

    public final int getDuration() {
        if (zzyc()) {
            return (int) this.zzebl.zzyo().getDuration();
        }
        return 0;
    }

    public final int getVideoWidth() {
        return this.zzdxh;
    }

    public final int getVideoHeight() {
        return this.zzdxi;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r0 != r12) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzebr
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzazh r2 = r10.zzdxm
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.zzebr
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzazh r0 = r10.zzdxm
            if (r0 == 0) goto L_0x0034
            r0.zzl(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a2
            int r0 = r10.zzdxk
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.zzdxl
            if (r0 <= 0) goto L_0x009e
            if (r0 == r12) goto L_0x009e
        L_0x0046:
            boolean r0 = r10.zzdxc
            if (r0 == 0) goto L_0x009e
            boolean r0 = r10.zzyb()
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbag r0 = r10.zzebl
            com.google.android.gms.internal.ads.zzgc r0 = r0.zzyo()
            long r2 = r0.zzdw()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009e
            boolean r2 = r0.zzdu()
            if (r2 == 0) goto L_0x0067
            goto L_0x009e
        L_0x0067:
            r2 = 1
            r10.zza(r1, r2)
            r0.zze(r2)
            long r1 = r0.zzdw()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzkq()
            long r3 = r3.currentTimeMillis()
        L_0x007a:
            boolean r5 = r10.zzyb()
            if (r5 == 0) goto L_0x0097
            long r5 = r0.zzdw()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzq.zzkq()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007a
        L_0x0097:
            r1 = 0
            r0.zze(r1)
            r10.zzwu()
        L_0x009e:
            r10.zzdxk = r11
            r10.zzdxl = r12
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazq.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzdxn) {
            this.zzdxm = new zzazh(getContext());
            this.zzdxm.zza(surfaceTexture, i, i2);
            this.zzdxm.start();
            SurfaceTexture zzxi = this.zzdxm.zzxi();
            if (zzxi != null) {
                surfaceTexture = zzxi;
            } else {
                this.zzdxm.zzxh();
                this.zzdxm = null;
            }
        }
        this.zzbhs = new Surface(surfaceTexture);
        if (this.zzebl == null) {
            zzyd();
        } else {
            zza(this.zzbhs, true);
            if (!this.zzebk.zzeai) {
                zzyg();
            }
        }
        if (this.zzdxh == 0 || this.zzdxi == 0) {
            zzn(i, i2);
        } else {
            zzyf();
        }
        zzaul.zzdsu.post(new zzazw(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzl(i, i2);
        }
        zzaul.zzdsu.post(new zzazv(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzdxb.zzc(this);
        this.zzdxx.zza(surfaceTexture, this.zzdxp);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzxh();
            this.zzdxm = null;
        }
        if (this.zzebl != null) {
            zzyh();
            Surface surface = this.zzbhs;
            if (surface != null) {
                surface.release();
            }
            this.zzbhs = null;
            zza((Surface) null, true);
        }
        zzaul.zzdsu.post(new zzazy(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzaug.zzdy(sb.toString());
        zzaul.zzdsu.post(new zzazx(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzb(boolean z, long j) {
        if (this.zzdya != null) {
            zzaxn.zzdwm.execute(new zzbaa(this, z, j));
        }
    }

    public final void zzcx(int i) {
        if (this.zzebo != i) {
            this.zzebo = i;
            if (i == 3) {
                zzye();
            } else if (i == 4) {
                if (this.zzebk.zzeai) {
                    zzyh();
                }
                this.zzdxb.zzxx();
                this.zzdxy.zzxx();
                zzaul.zzdsu.post(new zzazs(this));
            }
        }
    }

    public final void zzm(int i, int i2) {
        this.zzdxh = i;
        this.zzdxi = i2;
        zzyf();
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        String str2 = "ExoPlayerAdapter error: ";
        zzaug.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzebn = true;
        if (this.zzebk.zzeai) {
            zzyh();
        }
        zzaul.zzdsu.post(new zzazr(this, sb2));
    }

    private final void zzyf() {
        zzn(this.zzdxh, this.zzdxi);
    }

    private final void zzn(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzebr != f) {
            this.zzebr = f;
            requestLayout();
        }
    }

    private final void zzyg() {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzap(true);
        }
    }

    private final void zzyh() {
        zzbag zzbag = this.zzebl;
        if (zzbag != null) {
            zzbag.zzap(false);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzdya.zza(z, j);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcy(int i) {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzyi() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzwy();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzo(int i, int i2) {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzj(i, i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzyj() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzwv();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzyk() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.onPaused();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzyl() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzww();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzfa(String str) {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzn("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzym() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzwx();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzyn() {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.zzel();
        }
    }
}
