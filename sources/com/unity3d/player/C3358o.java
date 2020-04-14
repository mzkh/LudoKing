package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;

/* renamed from: com.unity3d.player.o */
public final class C3358o extends FrameLayout implements OnBufferingUpdateListener, OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener, Callback, MediaPlayerControl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f8040a = false;

    /* renamed from: b */
    private final Context f8041b;

    /* renamed from: c */
    private final SurfaceView f8042c;

    /* renamed from: d */
    private final SurfaceHolder f8043d;

    /* renamed from: e */
    private final String f8044e;

    /* renamed from: f */
    private final int f8045f;

    /* renamed from: g */
    private final int f8046g;

    /* renamed from: h */
    private final boolean f8047h;

    /* renamed from: i */
    private final long f8048i;

    /* renamed from: j */
    private final long f8049j;

    /* renamed from: k */
    private final FrameLayout f8050k;

    /* renamed from: l */
    private final Display f8051l;

    /* renamed from: m */
    private int f8052m;

    /* renamed from: n */
    private int f8053n;

    /* renamed from: o */
    private int f8054o;

    /* renamed from: p */
    private int f8055p;

    /* renamed from: q */
    private MediaPlayer f8056q;

    /* renamed from: r */
    private MediaController f8057r;

    /* renamed from: s */
    private boolean f8058s = false;

    /* renamed from: t */
    private boolean f8059t = false;

    /* renamed from: u */
    private int f8060u = 0;

    /* renamed from: v */
    private boolean f8061v = false;

    /* renamed from: w */
    private boolean f8062w = false;

    /* renamed from: x */
    private C3359a f8063x;

    /* renamed from: y */
    private C3360b f8064y;

    /* renamed from: z */
    private volatile int f8065z = 0;

    /* renamed from: com.unity3d.player.o$a */
    public interface C3359a {
        /* renamed from: a */
        void mo30776a(int i);
    }

    /* renamed from: com.unity3d.player.o$b */
    public class C3360b implements Runnable {

        /* renamed from: b */
        private C3358o f8067b;

        /* renamed from: c */
        private boolean f8068c = false;

        public C3360b(C3358o oVar) {
            this.f8067b = oVar;
        }

        /* renamed from: a */
        public final void mo30777a() {
            this.f8068c = true;
        }

        public final void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (!this.f8068c) {
                if (C3358o.f8040a) {
                    C3358o.m7768b("Stopping the video player due to timeout.");
                }
                this.f8067b.CancelOnPrepare();
            }
        }
    }

    protected C3358o(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C3359a aVar) {
        super(context);
        this.f8063x = aVar;
        this.f8041b = context;
        this.f8050k = this;
        this.f8042c = new SurfaceView(context);
        this.f8043d = this.f8042c.getHolder();
        this.f8043d.addCallback(this);
        this.f8050k.setBackgroundColor(i);
        this.f8050k.addView(this.f8042c);
        this.f8051l = ((WindowManager) this.f8041b.getSystemService("window")).getDefaultDisplay();
        this.f8044e = str;
        this.f8045f = i2;
        this.f8046g = i3;
        this.f8047h = z;
        this.f8048i = j;
        this.f8049j = j2;
        if (f8040a) {
            StringBuilder sb = new StringBuilder("fileName: ");
            sb.append(this.f8044e);
            m7768b(sb.toString());
        }
        if (f8040a) {
            StringBuilder sb2 = new StringBuilder("backgroundColor: ");
            sb2.append(i);
            m7768b(sb2.toString());
        }
        if (f8040a) {
            StringBuilder sb3 = new StringBuilder("controlMode: ");
            sb3.append(this.f8045f);
            m7768b(sb3.toString());
        }
        if (f8040a) {
            StringBuilder sb4 = new StringBuilder("scalingMode: ");
            sb4.append(this.f8046g);
            m7768b(sb4.toString());
        }
        if (f8040a) {
            StringBuilder sb5 = new StringBuilder("isURL: ");
            sb5.append(this.f8047h);
            m7768b(sb5.toString());
        }
        if (f8040a) {
            StringBuilder sb6 = new StringBuilder("videoOffset: ");
            sb6.append(this.f8048i);
            m7768b(sb6.toString());
        }
        if (f8040a) {
            StringBuilder sb7 = new StringBuilder("videoLength: ");
            sb7.append(this.f8049j);
            m7768b(sb7.toString());
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m7766a(int i) {
        this.f8065z = i;
        C3359a aVar = this.f8063x;
        if (aVar != null) {
            aVar.mo30776a(this.f8065z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7768b(String str) {
        StringBuilder sb = new StringBuilder("VideoPlayer: ");
        sb.append(str);
        Log.i("Video", sb.toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007f */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7770c() {
        /*
            r8 = this;
            android.media.MediaPlayer r0 = r8.f8056q
            if (r0 == 0) goto L_0x001c
            android.view.SurfaceHolder r1 = r8.f8043d
            r0.setDisplay(r1)
            boolean r0 = r8.f8061v
            if (r0 != 0) goto L_0x001b
            boolean r0 = f8040a
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "Resuming playback"
            m7768b(r0)
        L_0x0016:
            android.media.MediaPlayer r0 = r8.f8056q
            r0.start()
        L_0x001b:
            return
        L_0x001c:
            r0 = 0
            r8.m7766a(r0)
            r8.doCleanUp()
            android.media.MediaPlayer r0 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x00ce }
            r0.<init>()     // Catch:{ Exception -> 0x00ce }
            r8.f8056q = r0     // Catch:{ Exception -> 0x00ce }
            boolean r0 = r8.f8047h     // Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x003c
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            android.content.Context r1 = r8.f8041b     // Catch:{ Exception -> 0x00ce }
            java.lang.String r2 = r8.f8044e     // Catch:{ Exception -> 0x00ce }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00ce }
            r0.setDataSource(r1, r2)     // Catch:{ Exception -> 0x00ce }
            goto L_0x0090
        L_0x003c:
            long r0 = r8.f8049j     // Catch:{ Exception -> 0x00ce }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f8044e     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r2 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ Exception -> 0x00ce }
            long r4 = r8.f8048i     // Catch:{ Exception -> 0x00ce }
            long r6 = r8.f8049j     // Catch:{ Exception -> 0x00ce }
            r2.setDataSource(r3, r4, r6)     // Catch:{ Exception -> 0x00ce }
        L_0x0058:
            r0.close()     // Catch:{ Exception -> 0x00ce }
            goto L_0x0090
        L_0x005c:
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ Exception -> 0x00ce }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f8044e     // Catch:{ IOException -> 0x007f }
            android.content.res.AssetFileDescriptor r0 = r0.openFd(r1)     // Catch:{ IOException -> 0x007f }
            android.media.MediaPlayer r1 = r8.f8056q     // Catch:{ IOException -> 0x007f }
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch:{ IOException -> 0x007f }
            long r3 = r0.getStartOffset()     // Catch:{ IOException -> 0x007f }
            long r5 = r0.getLength()     // Catch:{ IOException -> 0x007f }
            r1.setDataSource(r2, r3, r5)     // Catch:{ IOException -> 0x007f }
            r0.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0090
        L_0x007f:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = r8.f8044e     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r1 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            java.io.FileDescriptor r2 = r0.getFD()     // Catch:{ Exception -> 0x00ce }
            r1.setDataSource(r2)     // Catch:{ Exception -> 0x00ce }
            goto L_0x0058
        L_0x0090:
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            android.view.SurfaceHolder r1 = r8.f8043d     // Catch:{ Exception -> 0x00ce }
            r0.setDisplay(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r1 = 1
            r0.setScreenOnWhilePlaying(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r0.setOnBufferingUpdateListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r0.setOnCompletionListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r0.setOnPreparedListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r0.setOnVideoSizeChangedListener(r8)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r1 = 3
            r0.setAudioStreamType(r1)     // Catch:{ Exception -> 0x00ce }
            android.media.MediaPlayer r0 = r8.f8056q     // Catch:{ Exception -> 0x00ce }
            r0.prepareAsync()     // Catch:{ Exception -> 0x00ce }
            com.unity3d.player.o$b r0 = new com.unity3d.player.o$b     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r8)     // Catch:{ Exception -> 0x00ce }
            r8.f8064y = r0     // Catch:{ Exception -> 0x00ce }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x00ce }
            com.unity3d.player.o$b r1 = r8.f8064y     // Catch:{ Exception -> 0x00ce }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ce }
            r0.start()     // Catch:{ Exception -> 0x00ce }
            return
        L_0x00ce:
            r0 = move-exception
            boolean r1 = f8040a
            if (r1 == 0) goto L_0x00eb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            m7768b(r0)
        L_0x00eb:
            r0 = 2
            r8.m7766a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C3358o.m7770c():void");
    }

    /* renamed from: d */
    private void m7771d() {
        if (!isPlaying()) {
            m7766a(1);
            if (f8040a) {
                m7768b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f8061v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        m7766a(2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo30753a() {
        return this.f8061v;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void destroyPlayer() {
        if (f8040a) {
            m7768b("destroyPlayer");
        }
        if (!this.f8061v) {
            pause();
        }
        doCleanUp();
    }

    /* access modifiers changed from: protected */
    public final void doCleanUp() {
        C3360b bVar = this.f8064y;
        if (bVar != null) {
            bVar.mo30777a();
            this.f8064y = null;
        }
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f8056q = null;
        }
        this.f8054o = 0;
        this.f8055p = 0;
        this.f8059t = false;
        this.f8058s = false;
    }

    public final int getBufferPercentage() {
        if (this.f8047h) {
            return this.f8060u;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public final int getDuration() {
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f8059t && this.f8058s;
        MediaPlayer mediaPlayer = this.f8056q;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f8040a) {
            StringBuilder sb = new StringBuilder("onBufferingUpdate percent:");
            sb.append(i);
            m7768b(sb.toString());
        }
        this.f8060u = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f8040a) {
            m7768b("onCompletion called");
        }
        destroyPlayer();
        m7766a(3);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || (this.f8045f == 2 && i != 0 && !keyEvent.isSystem())) {
            destroyPlayer();
            m7766a(3);
            return true;
        }
        MediaController mediaController = this.f8057r;
        return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f8040a) {
            m7768b("onPrepared called");
        }
        C3360b bVar = this.f8064y;
        if (bVar != null) {
            bVar.mo30777a();
            this.f8064y = null;
        }
        int i = this.f8045f;
        if (i == 0 || i == 1) {
            this.f8057r = new MediaController(this.f8041b);
            this.f8057r.setMediaPlayer(this);
            this.f8057r.setAnchorView(this);
            this.f8057r.setEnabled(true);
            Context context = this.f8041b;
            if (context instanceof Activity) {
                this.f8057r.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.f8057r.show();
        }
        this.f8059t = true;
        if (this.f8059t && this.f8058s) {
            m7771d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f8045f == 2 && action == 0) {
            destroyPlayer();
            m7766a(3);
            return true;
        }
        MediaController mediaController = this.f8057r;
        return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f8040a) {
            StringBuilder sb = new StringBuilder("onVideoSizeChanged called ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            m7768b(sb.toString());
        }
        if (i == 0 || i2 == 0) {
            if (f8040a) {
                StringBuilder sb2 = new StringBuilder("invalid video width(");
                sb2.append(i);
                sb2.append(") or height(");
                sb2.append(i2);
                sb2.append(")");
                m7768b(sb2.toString());
            }
            return;
        }
        this.f8058s = true;
        this.f8054o = i;
        this.f8055p = i2;
        if (this.f8059t && this.f8058s) {
            m7771d();
        }
    }

    public final void pause() {
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer != null) {
            if (this.f8062w) {
                mediaPlayer.pause();
            }
            this.f8061v = true;
        }
    }

    public final void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public final void start() {
        if (f8040a) {
            m7768b("Start");
        }
        MediaPlayer mediaPlayer = this.f8056q;
        if (mediaPlayer != null) {
            if (this.f8062w) {
                mediaPlayer.start();
            }
            this.f8061v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f8040a) {
            StringBuilder sb = new StringBuilder("surfaceChanged called ");
            sb.append(i);
            sb.append(" ");
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            m7768b(sb.toString());
        }
        if (this.f8052m != i2 || this.f8053n != i3) {
            this.f8052m = i2;
            this.f8053n = i3;
            if (this.f8062w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f8040a) {
            m7768b("surfaceCreated called");
        }
        this.f8062w = true;
        m7770c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f8040a) {
            m7768b("surfaceDestroyed called");
        }
        this.f8062w = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r5 <= r3) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r0 = (int) (((float) r1) * r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r5 >= r3) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateVideoLayout() {
        /*
            r8 = this;
            boolean r0 = f8040a
            if (r0 == 0) goto L_0x0009
            java.lang.String r0 = "updateVideoLayout"
            m7768b(r0)
        L_0x0009:
            android.media.MediaPlayer r0 = r8.f8056q
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            int r0 = r8.f8052m
            if (r0 == 0) goto L_0x0016
            int r0 = r8.f8053n
            if (r0 != 0) goto L_0x0034
        L_0x0016:
            android.content.Context r0 = r8.f8041b
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            r8.f8052m = r0
            int r0 = r1.heightPixels
            r8.f8053n = r0
        L_0x0034:
            int r0 = r8.f8052m
            int r1 = r8.f8053n
            boolean r2 = r8.f8058s
            if (r2 == 0) goto L_0x0065
            int r2 = r8.f8054o
            float r3 = (float) r2
            int r4 = r8.f8055p
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r5 = r5 / r6
            int r6 = r8.f8046g
            r7 = 1
            if (r6 != r7) goto L_0x0058
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0053
        L_0x004f:
            float r1 = (float) r0
            float r1 = r1 / r3
            int r1 = (int) r1
            goto L_0x006e
        L_0x0053:
            float r0 = (float) r1
            float r0 = r0 * r3
            int r0 = (int) r0
            goto L_0x006e
        L_0x0058:
            r7 = 2
            if (r6 != r7) goto L_0x0060
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0053
            goto L_0x004f
        L_0x0060:
            if (r6 != 0) goto L_0x006e
            r0 = r2
            r1 = r4
            goto L_0x006e
        L_0x0065:
            boolean r2 = f8040a
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = "updateVideoLayout: Video size is not known yet"
            m7768b(r2)
        L_0x006e:
            int r2 = r8.f8052m
            if (r2 != r0) goto L_0x0076
            int r2 = r8.f8053n
            if (r2 == r1) goto L_0x00a1
        L_0x0076:
            boolean r2 = f8040a
            if (r2 == 0) goto L_0x0093
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "frameWidth = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = "; frameHeight = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            m7768b(r2)
        L_0x0093:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r0, r1, r3)
            android.widget.FrameLayout r0 = r8.f8050k
            android.view.SurfaceView r1 = r8.f8042c
            r0.updateViewLayout(r1, r2)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.C3358o.updateVideoLayout():void");
    }
}
