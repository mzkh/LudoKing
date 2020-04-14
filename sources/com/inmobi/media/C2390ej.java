package com.inmobi.media;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2154ad.C2155a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.media.ej */
/* compiled from: NativeVideoView */
public class C2390ej extends TextureView implements MediaPlayerControl {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f5086f = "ej";

    /* renamed from: A */
    private OnInfoListener f5087A = new OnInfoListener() {
        @TargetApi(17)
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (VERSION.SDK_INT >= 17 && 3 == i) {
                C2390ej.this.mo28270a(8, 8);
            }
            return true;
        }
    };

    /* renamed from: B */
    private OnBufferingUpdateListener f5088B = new OnBufferingUpdateListener() {
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            C2390ej.this.f5111v = i;
        }
    };

    /* renamed from: C */
    private OnErrorListener f5089C = new OnErrorListener() {
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C2390ej.f5086f;
            if (C2390ej.this.f5107r != null) {
                C2390ej.this.f5107r.mo28252a();
            }
            if (C2390ej.this.f5091a != null) {
                C2390ej.this.f5091a.f5067a = -1;
                C2390ej.this.f5091a.f5068b = -1;
            }
            if (C2390ej.this.f5110u != null) {
                C2390ej.this.f5110u.mo28259b();
            }
            C2390ej.m4988h(C2390ej.this);
            return true;
        }
    };

    /* renamed from: D */
    private final SurfaceTextureListener f5090D = new SurfaceTextureListener() {
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @TargetApi(16)
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C2390ej.this.f5098i = new Surface(surfaceTexture);
            C2390ej.this.m4986g();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            boolean z = true;
            boolean z2 = C2390ej.this.f5091a != null && C2390ej.this.f5091a.f5068b == 3;
            if (i <= 0 || i2 <= 0) {
                z = false;
            }
            if (C2390ej.this.f5091a != null && z2 && z) {
                if (C2390ej.this.getTag() != null) {
                    int intValue = ((Integer) ((C2235bp) C2390ej.this.getTag()).f4542v.get("seekPosition")).intValue();
                    if (intValue != 0) {
                        C2390ej.this.mo28269a(intValue);
                    }
                }
                C2390ej.this.start();
            }
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (C2390ej.this.f5098i != null) {
                C2390ej.this.f5098i.release();
                C2390ej.this.f5098i = null;
            }
            if (C2390ej.this.f5110u != null) {
                C2390ej.this.f5110u.mo28259b();
            }
            C2390ej.this.mo28273c();
            return true;
        }
    };

    /* renamed from: a */
    public C2381ed f5091a = null;
    @Nullable

    /* renamed from: b */
    public Handler f5092b;

    /* renamed from: c */
    public boolean f5093c;

    /* renamed from: d */
    OnVideoSizeChangedListener f5094d = new OnVideoSizeChangedListener() {
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            C2390ej.this.f5100k = mediaPlayer.getVideoWidth();
            C2390ej.this.f5101l = mediaPlayer.getVideoHeight();
            if (C2390ej.this.f5100k != 0 && C2390ej.this.f5101l != 0) {
                C2390ej.this.requestLayout();
            }
        }
    };

    /* renamed from: e */
    OnPreparedListener f5095e = new OnPreparedListener() {
        public final void onPrepared(MediaPlayer mediaPlayer) {
            if (C2390ej.this.f5091a != null) {
                C2390ej.this.f5091a.f5067a = 2;
                C2390ej ejVar = C2390ej.this;
                ejVar.f5112w = ejVar.f5113x = ejVar.f5114y = true;
                if (C2390ej.this.f5110u != null) {
                    C2390ej.this.f5110u.setEnabled(true);
                }
                C2390ej.this.f5100k = mediaPlayer.getVideoWidth();
                C2390ej.this.f5101l = mediaPlayer.getVideoHeight();
                C2235bp bpVar = (C2235bp) C2390ej.this.getTag();
                String str = "didCompleteQ4";
                int i = 0;
                if (bpVar != null && ((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                    C2390ej.this.mo28270a(8, 0);
                    if (((Integer) bpVar.f4542v.get("placementType")).intValue() == 1) {
                        return;
                    }
                }
                if (C2390ej.this.getPlaybackEventListener() != null) {
                    C2390ej.this.getPlaybackEventListener().mo28251a(0);
                }
                if (bpVar != null && !((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                    i = ((Integer) bpVar.f4542v.get("seekPosition")).intValue();
                }
                String str2 = "isFullScreen";
                if (C2390ej.this.f5100k == 0 || C2390ej.this.f5101l == 0) {
                    if (3 == C2390ej.this.f5091a.f5068b && bpVar != null && ((Boolean) bpVar.f4542v.get(str2)).booleanValue()) {
                        C2390ej.this.start();
                    }
                } else if (3 == C2390ej.this.f5091a.f5068b) {
                    if (bpVar != null && ((Boolean) bpVar.f4542v.get(str2)).booleanValue()) {
                        C2390ej.this.start();
                    }
                    if (C2390ej.this.f5110u != null) {
                        C2390ej.this.f5110u.mo28258a();
                    }
                } else if (!C2390ej.this.isPlaying() && ((i != 0 || C2390ej.this.getCurrentPosition() > 0) && C2390ej.this.f5110u != null)) {
                    C2390ej.this.f5110u.mo28258a();
                }
            }
        }
    };

    /* renamed from: g */
    private Uri f5096g;

    /* renamed from: h */
    private Map<String, String> f5097h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Surface f5098i = null;

    /* renamed from: j */
    private int f5099j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f5100k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f5101l;

    /* renamed from: m */
    private int f5102m;

    /* renamed from: n */
    private int f5103n = Integer.MIN_VALUE;

    /* renamed from: o */
    private int f5104o = 0;

    /* renamed from: p */
    private C2401c f5105p;

    /* renamed from: q */
    private C2400b f5106q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C2399a f5107r;

    /* renamed from: s */
    private boolean f5108s;

    /* renamed from: t */
    private C2402d f5109t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C2387ei f5110u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f5111v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f5112w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f5113x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f5114y;

    /* renamed from: z */
    private OnCompletionListener f5115z = new OnCompletionListener() {
        public final void onCompletion(MediaPlayer mediaPlayer) {
            try {
                C2390ej.m4984f(C2390ej.this);
            } catch (Exception e) {
                C2390ej.f5086f;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
    };

    /* renamed from: com.inmobi.media.ej$a */
    /* compiled from: NativeVideoView */
    interface C2399a {
        /* renamed from: a */
        void mo28252a();
    }

    /* renamed from: com.inmobi.media.ej$b */
    /* compiled from: NativeVideoView */
    public interface C2400b {
        /* renamed from: a */
        void mo28251a(int i);
    }

    /* renamed from: com.inmobi.media.ej$c */
    /* compiled from: NativeVideoView */
    interface C2401c {
        /* renamed from: a */
        void mo28250a(int i);
    }

    /* renamed from: com.inmobi.media.ej$d */
    /* compiled from: NativeVideoView */
    static final class C2402d extends Handler {

        /* renamed from: a */
        private final WeakReference<C2390ej> f5124a;

        C2402d(C2390ej ejVar) {
            this.f5124a = new WeakReference<>(ejVar);
        }

        public final void handleMessage(Message message) {
            C2390ej ejVar = (C2390ej) this.f5124a.get();
            if (ejVar != null && message.what == 1) {
                int duration = ejVar.getDuration();
                int currentPosition = ejVar.getCurrentPosition();
                if (!(duration == -1 || currentPosition == 0)) {
                    C2235bp bpVar = (C2235bp) ejVar.getTag();
                    String str = "didCompleteQ1";
                    if (!((Boolean) bpVar.f4542v.get(str)).booleanValue() && (currentPosition * 4) - duration >= 0) {
                        bpVar.f4542v.put(str, Boolean.TRUE);
                        ejVar.getQuartileCompletedListener().mo28250a(0);
                    }
                    String str2 = "didCompleteQ2";
                    if (!((Boolean) bpVar.f4542v.get(str2)).booleanValue() && (currentPosition * 2) - duration >= 0) {
                        bpVar.f4542v.put(str2, Boolean.TRUE);
                        ejVar.getQuartileCompletedListener().mo28250a(1);
                    }
                    String str3 = "didCompleteQ3";
                    if (!((Boolean) bpVar.f4542v.get(str3)).booleanValue() && (currentPosition * 4) - (duration * 3) >= 0) {
                        bpVar.f4542v.put(str3, Boolean.TRUE);
                        ejVar.getQuartileCompletedListener().mo28250a(2);
                    }
                    boolean booleanValue = ((Boolean) bpVar.f4542v.get("didQ4Fire")).booleanValue();
                    if ((((float) currentPosition) / ((float) duration)) * 100.0f > ((float) bpVar.f4638E) && !booleanValue) {
                        ejVar.getPlaybackEventListener().mo28251a(5);
                    }
                }
                sendEmptyMessageDelayed(1, 1000);
            }
            super.handleMessage(message);
        }
    }

    public void seekTo(int i) {
    }

    public C2390ej(Context context) {
        super(context);
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public final void mo28271a(@NonNull C2235bp bpVar) {
        C2381ed edVar;
        this.f5100k = 0;
        this.f5101l = 0;
        this.f5096g = Uri.parse(((C2297cr) bpVar.f4525e).mo28138b());
        if (1 == ((Integer) bpVar.f4542v.get("placementType")).intValue()) {
            edVar = new C2381ed();
        } else {
            edVar = C2381ed.m4959a();
        }
        this.f5091a = edVar;
        int i = this.f5099j;
        if (i != 0) {
            this.f5091a.setAudioSessionId(i);
        } else {
            this.f5099j = this.f5091a.getAudioSessionId();
        }
        try {
            this.f5091a.setDataSource(getContext().getApplicationContext(), this.f5096g, this.f5097h);
            setTag(bpVar);
            this.f5109t = new C2402d(this);
            setSurfaceTextureListener(this.f5090D);
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        } catch (IOException unused) {
            C2381ed edVar2 = this.f5091a;
            edVar2.f5067a = -1;
            edVar2.f5068b = -1;
        }
    }

    public C2381ed getMediaPlayer() {
        return this.f5091a;
    }

    /* renamed from: a */
    public final void mo28268a() {
        Surface surface = this.f5098i;
        if (surface != null) {
            surface.release();
            this.f5098i = null;
        }
        mo28273c();
    }

    public int getState() {
        C2381ed edVar = this.f5091a;
        if (edVar != null) {
            return edVar.f5067a;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        try {
            int defaultSize = getDefaultSize(this.f5100k, i);
            int defaultSize2 = getDefaultSize(this.f5101l, i2);
            if (this.f5100k <= 0 || this.f5101l <= 0) {
                i4 = defaultSize;
            } else {
                int mode = MeasureSpec.getMode(i);
                i4 = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                i3 = MeasureSpec.getSize(i2);
                if (mode != 1073741824 || mode2 != 1073741824) {
                    if (mode == 1073741824) {
                        int i6 = (this.f5101l * i4) / this.f5100k;
                        if (mode2 != Integer.MIN_VALUE || i6 <= i3) {
                            i3 = i6;
                        }
                    } else {
                        if (mode2 == 1073741824) {
                            i5 = (this.f5100k * i3) / this.f5101l;
                            if (mode == Integer.MIN_VALUE && i5 > i4) {
                            }
                        } else {
                            int i7 = this.f5100k;
                            int i8 = this.f5101l;
                            if (mode2 != Integer.MIN_VALUE || i8 <= i3) {
                                i5 = i7;
                                i3 = i8;
                            } else {
                                i5 = (this.f5100k * i3) / this.f5101l;
                            }
                            if (mode == Integer.MIN_VALUE && i5 > i4) {
                                defaultSize2 = (this.f5101l * i4) / this.f5100k;
                            }
                        }
                        i4 = i5;
                    }
                    setMeasuredDimension(i4, i3);
                } else if (this.f5100k * i3 < this.f5101l * i4) {
                    defaultSize2 = (this.f5101l * i4) / this.f5100k;
                } else {
                    if (this.f5100k * i3 > this.f5101l * i4) {
                        i4 = (this.f5100k * i3) / this.f5101l;
                    }
                    setMeasuredDimension(i4, i3);
                }
            }
            i3 = defaultSize2;
            setMeasuredDimension(i4, i3);
        } catch (Exception unused) {
        }
    }

    @Nullable
    public C2387ei getMediaController() {
        return this.f5110u;
    }

    /* renamed from: b */
    public final boolean mo28272b() {
        C2381ed edVar = this.f5091a;
        return (edVar == null || edVar.f5067a == -1 || this.f5091a.f5067a == 0 || this.f5091a.f5067a == 1) ? false : true;
    }

    public void setIsLockScreen(boolean z) {
        this.f5108s = z;
    }

    @TargetApi(20)
    public void start() {
        boolean z;
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        if (VERSION.SDK_INT < 20) {
            z = powerManager.isScreenOn();
        } else {
            z = powerManager.isInteractive();
        }
        boolean b = mo28272b();
        C2235bp bpVar = (C2235bp) getTag();
        int i = 0;
        boolean z2 = bpVar == null || ((Boolean) bpVar.f4542v.get("shouldAutoPlay")).booleanValue();
        if (b && !z2) {
            mo28270a(8, 0);
        }
        if (b && z && !this.f5091a.isPlaying() && z2 && (this.f5108s || !inKeyguardRestrictedInputMode)) {
            String str = "didCompleteQ4";
            if (bpVar != null && !((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                i = ((Integer) bpVar.f4542v.get("seekPosition")).intValue();
            }
            mo28277d();
            mo28269a(i);
            this.f5091a.start();
            this.f5091a.f5067a = 3;
            mo28270a(8, 8);
            if (bpVar != null) {
                bpVar.f4542v.put(str, Boolean.FALSE);
                if (bpVar.mo27981a()) {
                    mo28278e();
                }
                String str2 = "didPause";
                if (((Boolean) bpVar.f4542v.get(str2)).booleanValue()) {
                    getPlaybackEventListener().mo28251a(3);
                    bpVar.f4542v.put(str2, Boolean.FALSE);
                } else {
                    getPlaybackEventListener().mo28251a(1);
                }
                C2402d dVar = this.f5109t;
                if (dVar != null && !dVar.hasMessages(1)) {
                    this.f5109t.sendEmptyMessage(1);
                }
            }
            C2387ei eiVar = this.f5110u;
            if (eiVar != null) {
                eiVar.mo28258a();
            }
        }
        C2381ed edVar = this.f5091a;
        if (edVar != null) {
            edVar.f5068b = 3;
        }
    }

    public void pause() {
        if (mo28272b() && this.f5091a.isPlaying()) {
            this.f5091a.pause();
            this.f5091a.f5067a = 4;
            if (getTag() != null) {
                C2235bp bpVar = (C2235bp) getTag();
                bpVar.f4542v.put("didPause", Boolean.TRUE);
                bpVar.f4542v.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            getPlaybackEventListener().mo28251a(2);
        }
        C2381ed edVar = this.f5091a;
        if (edVar != null) {
            edVar.f5068b = 4;
        }
        this.f5093c = false;
    }

    public int getDuration() {
        if (mo28272b()) {
            return this.f5091a.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (mo28272b()) {
            return this.f5091a.getCurrentPosition();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28269a(int i) {
        if (mo28272b()) {
            this.f5091a.seekTo(i);
        }
    }

    public boolean isPlaying() {
        return mo28272b() && this.f5091a.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f5091a != null) {
            return this.f5111v;
        }
        return 0;
    }

    public boolean canPause() {
        return this.f5112w;
    }

    public boolean canSeekBackward() {
        return this.f5113x;
    }

    public boolean canSeekForward() {
        return this.f5114y;
    }

    public int getAudioSessionId() {
        if (this.f5099j == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f5099j = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f5099j;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m4986g() {
        C2381ed edVar;
        if (!(this.f5096g == null || this.f5098i == null)) {
            if (this.f5091a == null) {
                C2235bp bpVar = (C2235bp) getTag();
                if (1 == (bpVar != null ? ((Integer) bpVar.f4542v.get("placementType")).intValue() : 1)) {
                    edVar = new C2381ed();
                } else {
                    edVar = C2381ed.m4959a();
                }
                this.f5091a = edVar;
                int i = this.f5099j;
                if (i != 0) {
                    this.f5091a.setAudioSessionId(i);
                } else {
                    this.f5099j = this.f5091a.getAudioSessionId();
                }
                try {
                    this.f5091a.setDataSource(getContext().getApplicationContext(), this.f5096g, this.f5097h);
                } catch (IOException unused) {
                    C2381ed edVar2 = this.f5091a;
                    edVar2.f5067a = -1;
                    edVar2.f5068b = -1;
                    return;
                }
            }
            try {
                C2235bp bpVar2 = (C2235bp) getTag();
                this.f5091a.setOnPreparedListener(this.f5095e);
                this.f5091a.setOnVideoSizeChangedListener(this.f5094d);
                this.f5091a.setOnCompletionListener(this.f5115z);
                this.f5091a.setOnErrorListener(this.f5089C);
                this.f5091a.setOnInfoListener(this.f5087A);
                this.f5091a.setOnBufferingUpdateListener(this.f5088B);
                this.f5091a.setSurface(this.f5098i);
                if (VERSION.SDK_INT >= 26) {
                    this.f5091a.setAudioAttributes(new Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build());
                } else {
                    this.f5091a.setAudioStreamType(3);
                }
                this.f5091a.prepareAsync();
                this.f5111v = 0;
                this.f5091a.f5067a = 1;
                m4989i();
                if (bpVar2 != null) {
                    if (((Boolean) bpVar2.f4542v.get("shouldAutoPlay")).booleanValue()) {
                        this.f5091a.f5068b = 3;
                    }
                    if (((Boolean) bpVar2.f4542v.get("didCompleteQ4")).booleanValue()) {
                        mo28270a(8, 0);
                        return;
                    }
                }
                mo28270a(0, 0);
            } catch (Exception e) {
                C2381ed edVar3 = this.f5091a;
                edVar3.f5067a = -1;
                edVar3.f5068b = -1;
                this.f5089C.onError(edVar3, 1, 0);
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
    }

    /* renamed from: c */
    public final void mo28273c() {
        if (this.f5091a != null) {
            C2402d dVar = this.f5109t;
            if (dVar != null) {
                dVar.removeMessages(1);
            }
            if (getTag() != null) {
                ((C2235bp) getTag()).f4542v.put("seekPosition", Integer.valueOf(getCurrentPosition()));
            }
            C2381ed edVar = this.f5091a;
            edVar.f5067a = 0;
            edVar.f5068b = 0;
            edVar.reset();
            m4987h();
            if (getTag() == null) {
                this.f5091a.mo28253b();
            } else if (((Integer) ((C2235bp) getTag()).f4542v.get("placementType")).intValue() == 0) {
                this.f5091a.mo28253b();
            }
            AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
            this.f5091a = null;
        }
    }

    /* renamed from: h */
    private void m4987h() {
        this.f5091a.setOnPreparedListener(null);
        this.f5091a.setOnVideoSizeChangedListener(null);
        this.f5091a.setOnCompletionListener(null);
        this.f5091a.setOnErrorListener(null);
        this.f5091a.setOnInfoListener(null);
        this.f5091a.setOnBufferingUpdateListener(null);
    }

    /* renamed from: d */
    public final void mo28277d() {
        C2381ed edVar = this.f5091a;
        if (edVar != null) {
            this.f5102m = 0;
            edVar.setVolume(0.0f, 0.0f);
            if (getTag() != null) {
                ((C2235bp) getTag()).f4542v.put("currentMediaVolume", Integer.valueOf(0));
            }
        }
    }

    /* renamed from: e */
    public final void mo28278e() {
        C2381ed edVar = this.f5091a;
        if (edVar != null) {
            this.f5102m = 1;
            edVar.setVolume(1.0f, 1.0f);
            if (getTag() != null) {
                ((C2235bp) getTag()).f4542v.put("currentMediaVolume", Integer.valueOf(15));
            }
        }
    }

    public int getVolume() {
        if (mo28272b()) {
            return this.f5102m;
        }
        return -1;
    }

    /* renamed from: i */
    private void m4989i() {
        if (this.f5091a != null) {
            C2387ei eiVar = this.f5110u;
            if (eiVar != null) {
                eiVar.setMediaPlayer(this);
                this.f5110u.setEnabled(mo28272b());
                this.f5110u.mo28258a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28270a(int i, int i2) {
        if (this.f5091a != null) {
            ProgressBar progressBar = ((C2403ek) getParent()).getProgressBar();
            ImageView poster = ((C2403ek) getParent()).getPoster();
            progressBar.setVisibility(i);
            poster.setVisibility(i2);
        }
    }

    public int getVideoVolume() {
        if (isPlaying()) {
            return this.f5102m;
        }
        return -1;
    }

    public int getLastVolume() {
        return this.f5103n;
    }

    public void setLastVolume(int i) {
        this.f5103n = i;
    }

    public void setMediaController(C2387ei eiVar) {
        if (eiVar != null) {
            this.f5110u = eiVar;
            m4989i();
        }
    }

    public C2401c getQuartileCompletedListener() {
        return this.f5105p;
    }

    public void setQuartileCompletedListener(C2401c cVar) {
        this.f5105p = cVar;
    }

    public C2400b getPlaybackEventListener() {
        return this.f5106q;
    }

    public void setPlaybackEventListener(C2400b bVar) {
        this.f5106q = bVar;
    }

    public void setMediaErrorListener(C2399a aVar) {
        this.f5107r = aVar;
    }

    public void setVideoURI(Uri uri) {
        this.f5096g = uri;
        this.f5097h = null;
        m4986g();
        requestLayout();
        invalidate();
    }

    /* renamed from: f */
    static /* synthetic */ void m4984f(C2390ej ejVar) {
        C2381ed edVar = ejVar.f5091a;
        if (edVar != null) {
            edVar.f5067a = 5;
            edVar.f5068b = 5;
        }
        C2387ei eiVar = ejVar.f5110u;
        if (eiVar != null) {
            eiVar.mo28259b();
        }
        C2402d dVar = ejVar.f5109t;
        if (dVar != null) {
            dVar.removeMessages(1);
        }
        if (ejVar.getTag() != null) {
            C2235bp bpVar = (C2235bp) ejVar.getTag();
            String str = "didCompleteQ4";
            if (!((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                bpVar.f4542v.put(str, Boolean.TRUE);
                if (ejVar.getQuartileCompletedListener() != null) {
                    ejVar.getQuartileCompletedListener().mo28250a(3);
                }
            }
            bpVar.f4542v.put("didSignalVideoCompleted", Boolean.TRUE);
            if (bpVar != null) {
                bpVar.f4542v.put("didCompleteQ1", Boolean.FALSE);
                bpVar.f4542v.put("didCompleteQ2", Boolean.FALSE);
                bpVar.f4542v.put("didCompleteQ3", Boolean.FALSE);
                bpVar.f4542v.put("didPause", Boolean.FALSE);
                bpVar.f4542v.put("didStartPlaying", Boolean.FALSE);
                bpVar.f4542v.put("didQ4Fire", Boolean.FALSE);
            }
            if (bpVar.f4636C) {
                ejVar.start();
            } else if (((Boolean) bpVar.f4542v.get("isFullScreen")).booleanValue()) {
                ejVar.mo28270a(8, 0);
            }
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m4988h(C2390ej ejVar) {
        try {
            if (ejVar.f5096g != null) {
                String uri = ejVar.f5096g.toString();
                C2169am.m4358a();
                C2493fx a = C2493fx.m5237a();
                List a2 = a.mo28429a("asset", C2169am.f4410a, "disk_uri=? ", new String[]{uri}, null, null, "created_ts DESC ", "1");
                a.mo28434b();
                C2154ad a3 = a2.isEmpty() ? null : C2169am.m4356a((ContentValues) a2.get(0));
                C2155a aVar = new C2155a();
                if (a3 != null) {
                    C2154ad a4 = aVar.mo27836a(a3.f4336d, 0, 0).mo27838a();
                    C2169am.m4358a();
                    C2169am.m4359b(a4);
                }
            }
        } catch (Exception unused) {
        }
    }
}
