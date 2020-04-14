package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.zzq;
import com.unity.purchasing.googleplay.IabHelper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzayh extends zzayu implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> zzdxa = new HashMap();
    private final zzazm zzdxb;
    private final boolean zzdxc;
    private int zzdxd = 0;
    private int zzdxe = 0;
    private MediaPlayer zzdxf;
    private Uri zzdxg;
    private int zzdxh;
    private int zzdxi;
    private int zzdxj;
    private int zzdxk;
    private int zzdxl;
    private zzazh zzdxm;
    private boolean zzdxn;
    private int zzdxo;
    /* access modifiers changed from: private */
    public zzayr zzdxp;

    public zzayh(Context context, boolean z, boolean z2, zzazk zzazk, zzazm zzazm) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzdxb = zzazm;
        this.zzdxn = z;
        this.zzdxc = z2;
        this.zzdxb.zzb(this);
    }

    public final String zzwq() {
        String str = this.zzdxn ? " spherical" : "";
        String str2 = "MediaPlayer";
        return str.length() != 0 ? str2.concat(str) : new String(str2);
    }

    public final void zza(zzayr zzayr) {
        this.zzdxp = zzayr;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzrp zze = zzrp.zze(parse);
        if (zze == null || zze.url != null) {
            if (zze != null) {
                parse = Uri.parse(zze.url);
            }
            this.zzdxg = parse;
            this.zzdxo = 0;
            zzwr();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzaug.zzdy("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzdxf.release();
            this.zzdxf = null;
            zzcq(0);
            this.zzdxe = 0;
        }
        this.zzdxb.onStop();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzaug.zzdy(sb.toString());
        this.zzdxh = mediaPlayer.getVideoWidth();
        this.zzdxi = mediaPlayer.getVideoHeight();
        if (this.zzdxh != 0 && this.zzdxi != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzaug.zzdy("AdMediaPlayerView prepared");
        zzcq(2);
        this.zzdxb.zzel();
        zzaul.zzdsu.post(new zzayj(this));
        this.zzdxh = mediaPlayer.getVideoWidth();
        this.zzdxi = mediaPlayer.getVideoHeight();
        int i = this.zzdxo;
        if (i != 0) {
            seekTo(i);
        }
        zzws();
        int i2 = this.zzdxh;
        int i3 = this.zzdxi;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzaug.zzet(sb.toString());
        if (this.zzdxe == 3) {
            play();
        }
        zzwu();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzaug.zzdy("AdMediaPlayerView completion");
        zzcq(5);
        this.zzdxe = 5;
        zzaul.zzdsu.post(new zzaym(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) zzdxa.get(Integer.valueOf(i));
        String str2 = (String) zzdxa.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaug.zzdy(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) zzdxa.get(Integer.valueOf(i));
        String str2 = (String) zzdxa.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaug.zzeu(sb.toString());
        zzcq(-1);
        this.zzdxe = -1;
        zzaul.zzdsu.post(new zzayl(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzdxj = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaug.zzdy("AdMediaPlayerView surface created");
        zzwr();
        zzaul.zzdsu.post(new zzayo(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaug.zzdy("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzdxe == 3;
        if (!(this.zzdxh == i && this.zzdxi == i2)) {
            z = false;
        }
        if (this.zzdxf != null && z2 && z) {
            int i3 = this.zzdxo;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzl(i, i2);
        }
        zzaul.zzdsu.post(new zzayn(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaug.zzdy("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null && this.zzdxo == 0) {
            this.zzdxo = mediaPlayer.getCurrentPosition();
        }
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzxh();
        }
        zzaul.zzdsu.post(new zzayq(this));
        zzam(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzdxb.zzc(this);
        this.zzdxx.zza(surfaceTexture, this.zzdxp);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzaug.zzdy(sb.toString());
        zzaul.zzdsu.post(new zzayk(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r7 != r1) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzdxh
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.zzdxi
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.zzdxh
            if (r2 <= 0) goto L_0x0088
            int r2 = r5.zzdxi
            if (r2 <= 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzazh r2 = r5.zzdxm
            if (r2 != 0) goto L_0x0088
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0048
            if (r1 != r2) goto L_0x0048
            int r0 = r5.zzdxh
            int r1 = r0 * r7
            int r2 = r5.zzdxi
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003d
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L_0x0088
        L_0x003d:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x0069
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0089
        L_0x0048:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x005a
            int r0 = r5.zzdxi
            int r0 = r0 * r6
            int r2 = r5.zzdxh
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0058
            if (r0 <= r7) goto L_0x0058
            goto L_0x0067
        L_0x0058:
            r1 = r0
            goto L_0x0089
        L_0x005a:
            if (r1 != r2) goto L_0x006b
            int r1 = r5.zzdxh
            int r1 = r1 * r7
            int r2 = r5.zzdxi
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0068
            if (r1 <= r6) goto L_0x0068
        L_0x0067:
            goto L_0x0069
        L_0x0068:
            r6 = r1
        L_0x0069:
            r1 = r7
            goto L_0x0089
        L_0x006b:
            int r2 = r5.zzdxh
            int r4 = r5.zzdxi
            if (r1 != r3) goto L_0x0078
            if (r4 <= r7) goto L_0x0078
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L_0x0079
        L_0x0078:
            r1 = r4
        L_0x0079:
            if (r0 != r3) goto L_0x0086
            if (r2 <= r6) goto L_0x0086
            int r7 = r5.zzdxi
            int r7 = r7 * r6
            int r0 = r5.zzdxh
            int r1 = r7 / r0
            goto L_0x0089
        L_0x0086:
            r6 = r2
            goto L_0x0089
        L_0x0088:
            r6 = r0
        L_0x0089:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzazh r7 = r5.zzdxm
            if (r7 == 0) goto L_0x0093
            r7.zzl(r6, r1)
        L_0x0093:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto L_0x00ac
            int r7 = r5.zzdxk
            if (r7 <= 0) goto L_0x009f
            if (r7 != r6) goto L_0x00a5
        L_0x009f:
            int r7 = r5.zzdxl
            if (r7 <= 0) goto L_0x00a8
            if (r7 == r1) goto L_0x00a8
        L_0x00a5:
            r5.zzws()
        L_0x00a8:
            r5.zzdxk = r6
            r5.zzdxl = r1
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayh.onMeasure(int, int):void");
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzwr() {
        zzaug.zzdy("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (!(this.zzdxg == null || surfaceTexture == null)) {
            zzam(false);
            try {
                zzq.zzkz();
                this.zzdxf = new MediaPlayer();
                this.zzdxf.setOnBufferingUpdateListener(this);
                this.zzdxf.setOnCompletionListener(this);
                this.zzdxf.setOnErrorListener(this);
                this.zzdxf.setOnInfoListener(this);
                this.zzdxf.setOnPreparedListener(this);
                this.zzdxf.setOnVideoSizeChangedListener(this);
                this.zzdxj = 0;
                if (this.zzdxn) {
                    this.zzdxm = new zzazh(getContext());
                    this.zzdxm.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzdxm.start();
                    SurfaceTexture zzxi = this.zzdxm.zzxi();
                    if (zzxi != null) {
                        surfaceTexture = zzxi;
                    } else {
                        this.zzdxm.zzxh();
                        this.zzdxm = null;
                    }
                }
                this.zzdxf.setDataSource(getContext(), this.zzdxg);
                zzq.zzla();
                this.zzdxf.setSurface(new Surface(surfaceTexture));
                this.zzdxf.setAudioStreamType(3);
                this.zzdxf.setScreenOnWhilePlaying(true);
                this.zzdxf.prepareAsync();
                zzcq(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzdxg);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzaug.zzd(sb.toString(), e);
                onError(this.zzdxf, 1, 0);
            }
        }
    }

    private final void zzws() {
        if (this.zzdxc && zzwt() && this.zzdxf.getCurrentPosition() > 0 && this.zzdxe != 3) {
            zzaug.zzdy("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzdxf.start();
            int currentPosition = this.zzdxf.getCurrentPosition();
            long currentTimeMillis = zzq.zzkq().currentTimeMillis();
            while (zzwt() && this.zzdxf.getCurrentPosition() == currentPosition) {
                if (zzq.zzkq().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.zzdxf.pause();
            zzwu();
        }
    }

    private final void zzam(boolean z) {
        zzaug.zzdy("AdMediaPlayerView release");
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzxh();
            this.zzdxm = null;
        }
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzdxf.release();
            this.zzdxf = null;
            zzcq(0);
            if (z) {
                this.zzdxe = 0;
                this.zzdxe = 0;
            }
        }
    }

    public final void play() {
        zzaug.zzdy("AdMediaPlayerView play");
        if (zzwt()) {
            this.zzdxf.start();
            zzcq(3);
            this.zzdxx.zzww();
            zzaul.zzdsu.post(new zzayp(this));
        }
        this.zzdxe = 3;
    }

    public final void pause() {
        zzaug.zzdy("AdMediaPlayerView pause");
        if (zzwt() && this.zzdxf.isPlaying()) {
            this.zzdxf.pause();
            zzcq(4);
            zzaul.zzdsu.post(new zzays(this));
        }
        this.zzdxe = 4;
    }

    public final int getDuration() {
        if (zzwt()) {
            return this.zzdxf.getDuration();
        }
        return -1;
    }

    public final int getCurrentPosition() {
        if (zzwt()) {
            return this.zzdxf.getCurrentPosition();
        }
        return 0;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzaug.zzdy(sb.toString());
        if (zzwt()) {
            this.zzdxf.seekTo(i);
            this.zzdxo = 0;
            return;
        }
        this.zzdxo = i;
    }

    private final boolean zzwt() {
        if (this.zzdxf != null) {
            int i = this.zzdxd;
            if (!(i == -1 || i == 0 || i == 1)) {
                return true;
            }
        }
        return false;
    }

    public final void zza(float f, float f2) {
        zzazh zzazh = this.zzdxm;
        if (zzazh != null) {
            zzazh.zzb(f, f2);
        }
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final void zzwu() {
        zzd(this.zzdxy.getVolume());
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzdxf;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzaug.zzeu("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzcq(int i) {
        if (i == 3) {
            this.zzdxb.zzxw();
            this.zzdxy.zzxw();
        } else if (this.zzdxd == 3) {
            this.zzdxb.zzxx();
            this.zzdxy.zzxx();
        }
        this.zzdxd = i;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzcr(int i) {
        zzayr zzayr = this.zzdxp;
        if (zzayr != null) {
            zzayr.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            zzdxa.put(Integer.valueOf(IabHelper.IABHELPER_SEND_INTENT_FAILED), "MEDIA_ERROR_IO");
            zzdxa.put(Integer.valueOf(IabHelper.IABHELPER_MISSING_TOKEN), "MEDIA_ERROR_MALFORMED");
            zzdxa.put(Integer.valueOf(IabHelper.IABHELPER_INVALID_CONSUMPTION), "MEDIA_ERROR_UNSUPPORTED");
            zzdxa.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            zzdxa.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzdxa.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        zzdxa.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        zzdxa.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        zzdxa.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzdxa.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        zzdxa.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        zzdxa.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        zzdxa.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        zzdxa.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            zzdxa.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzdxa.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
