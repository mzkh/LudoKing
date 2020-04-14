package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

@TargetApi(14)
/* renamed from: com.adcolony.sdk.au */
class C0546au extends TextureView implements OnCompletionListener, OnErrorListener, OnPreparedListener, OnSeekCompleteListener, SurfaceTextureListener {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f409A;

    /* renamed from: B */
    private boolean f410B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f411C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f412D;

    /* renamed from: E */
    private boolean f413E;

    /* renamed from: F */
    private String f414F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f415G;

    /* renamed from: H */
    private FileInputStream f416H;

    /* renamed from: I */
    private C0480ab f417I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C0580c f418J;

    /* renamed from: K */
    private Surface f419K;

    /* renamed from: L */
    private SurfaceTexture f420L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public RectF f421M = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: N */
    public C0556a f422N;

    /* renamed from: O */
    private ProgressBar f423O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public MediaPlayer f424P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public JSONObject f425Q = C0746u.m892a();

    /* renamed from: R */
    private ExecutorService f426R = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C0480ab f427S;

    /* renamed from: a */
    private float f428a;

    /* renamed from: b */
    private float f429b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f430c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f431d;

    /* renamed from: e */
    private float f432e;

    /* renamed from: f */
    private float f433f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f434g;

    /* renamed from: h */
    private boolean f435h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Paint f436i = new Paint();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Paint f437j = new Paint(1);

    /* renamed from: k */
    private int f438k;

    /* renamed from: l */
    private int f439l;

    /* renamed from: m */
    private int f440m;

    /* renamed from: n */
    private int f441n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f442o;

    /* renamed from: p */
    private int f443p;

    /* renamed from: q */
    private int f444q;

    /* renamed from: r */
    private int f445r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public double f446s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public double f447t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f448u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f449v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f450w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f451x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f452y;

    /* renamed from: z */
    private boolean f453z;

    /* renamed from: com.adcolony.sdk.au$a */
    private class C0556a extends View {
        C0556a(Context context) {
            super(context);
            setWillNotDraw(false);
            try {
                getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
            } catch (Exception unused) {
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(C0546au.this.f421M, 270.0f, C0546au.this.f431d, false, C0546au.this.f436i);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(C0546au.this.f434g);
            String sb2 = sb.toString();
            float centerX = C0546au.this.f421M.centerX();
            double centerY = (double) C0546au.this.f421M.centerY();
            double d = (double) C0546au.this.f437j.getFontMetrics().bottom;
            Double.isNaN(d);
            double d2 = d * 1.35d;
            Double.isNaN(centerY);
            canvas.drawText(sb2, centerX, (float) (centerY + d2), C0546au.this.f437j);
            invalidate();
        }
    }

    private C0546au(Context context) {
        super(context);
    }

    C0546au(Context context, C0480ab abVar, int i, C0580c cVar) {
        super(context);
        this.f418J = cVar;
        this.f417I = abVar;
        this.f442o = i;
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8377a() {
        if (this.f420L != null) {
            this.f409A = true;
        }
        this.f426R.shutdown();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8378b() {
        JSONObject c = this.f417I.mo8220c();
        this.f415G = C0746u.m908b(c, "ad_session_id");
        String str = "x";
        this.f438k = C0746u.m914c(c, str);
        this.f439l = C0746u.m914c(c, "y");
        this.f440m = C0746u.m914c(c, "width");
        this.f441n = C0746u.m914c(c, "height");
        this.f411C = C0746u.m918d(c, "enable_timer");
        this.f413E = C0746u.m918d(c, "enable_progress");
        this.f414F = C0746u.m908b(c, "filepath");
        this.f443p = C0746u.m914c(c, "video_width");
        this.f444q = C0746u.m914c(c, "video_height");
        this.f433f = C0476a.m77a().mo8579m().mo8640p();
        new C0749a().mo8726a("Original video dimensions = ").mo8724a(this.f443p).mo8726a(str).mo8724a(this.f444q).mo8728a(C0748w.f1166b);
        setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(this.f440m, this.f441n);
        layoutParams.setMargins(this.f438k, this.f439l, 0, 0);
        layoutParams.gravity = 0;
        this.f418J.addView(this, layoutParams);
        if (this.f413E) {
            Context c2 = C0476a.m85c();
            if (c2 != null) {
                this.f423O = new ProgressBar(c2);
                C0580c cVar = this.f418J;
                ProgressBar progressBar = this.f423O;
                float f = this.f433f;
                cVar.addView(progressBar, new LayoutParams((int) (f * 100.0f), (int) (f * 100.0f), 17));
            }
        }
        this.f424P = new MediaPlayer();
        this.f453z = false;
        try {
            if (!this.f414F.startsWith("http")) {
                this.f416H = new FileInputStream(this.f414F);
                this.f424P.setDataSource(this.f416H.getFD());
            } else {
                this.f410B = true;
                this.f424P.setDataSource(this.f414F);
            }
            this.f424P.setOnErrorListener(this);
            this.f424P.setOnPreparedListener(this);
            this.f424P.setOnCompletionListener(this);
            this.f424P.prepareAsync();
        } catch (IOException e) {
            new C0749a().mo8726a("Failed to create/prepare MediaPlayer: ").mo8726a(e.toString()).mo8728a(C0748w.f1171g);
            m371l();
        }
        String str2 = "VideoView.play";
        this.f418J.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.mo8381e();
                }
            }
        }, true));
        String str3 = "VideoView.set_bounds";
        this.f418J.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.m350b(abVar);
                }
            }
        }, true));
        String str4 = "VideoView.set_visible";
        this.f418J.mo8488m().add(C0476a.m76a(str4, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.m354c(abVar);
                }
            }
        }, true));
        String str5 = "VideoView.pause";
        this.f418J.mo8488m().add(C0476a.m76a(str5, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.mo8382f();
                }
            }
        }, true));
        String str6 = "VideoView.seek_to_time";
        this.f418J.mo8488m().add(C0476a.m76a(str6, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.m360e(abVar);
                }
            }
        }, true));
        String str7 = "VideoView.set_volume";
        this.f418J.mo8488m().add(C0476a.m76a(str7, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0546au.this.m345a(abVar)) {
                    C0546au.this.m357d(abVar);
                }
            }
        }, true));
        this.f418J.mo8489n().add(str2);
        this.f418J.mo8489n().add(str3);
        this.f418J.mo8489n().add(str4);
        this.f418J.mo8489n().add(str5);
        this.f418J.mo8489n().add(str6);
        this.f418J.mo8489n().add(str7);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m345a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f442o && C0746u.m914c(c, "container_id") == this.f418J.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f418J.mo8463b());
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (surfaceTexture == null || this.f409A) {
            new C0749a().mo8726a("Null texture provided by system's onSurfaceTextureAvailable or ").mo8726a("MediaPlayer has been destroyed.").mo8728a(C0748w.f1172h);
            return;
        }
        this.f419K = new Surface(surfaceTexture);
        try {
            this.f424P.setSurface(this.f419K);
        } catch (IllegalStateException unused) {
            new C0749a().mo8726a("IllegalStateException thrown when calling MediaPlayer.setSurface()").mo8728a(C0748w.f1171g);
            m371l();
        }
        this.f420L = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f420L = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f420L = surfaceTexture;
        if (!this.f409A) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f420L = surfaceTexture;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        C0666j a = C0476a.m77a();
        C0595d l = a.mo8578l();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject a2 = C0746u.m892a();
        C0746u.m912b(a2, "view_id", this.f442o);
        C0746u.m902a(a2, "ad_session_id", this.f415G);
        String str = "container_x";
        C0746u.m912b(a2, str, this.f438k + x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, this.f439l + y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f418J.mo8470d());
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            if (action == 1) {
                if (!this.f418J.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f415G));
                }
                new C0480ab(str6, this.f418J.mo8467c(), a2).mo8217b();
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f418J.mo8467c(), a2).mo8217b();
            } else if (action == 3) {
                new C0480ab("AdContainer.on_touch_cancelled", this.f418J.mo8467c(), a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action2)) + this.f438k);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action2)) + this.f439l);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f418J.mo8467c(), a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action3)) + this.f438k);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action3)) + this.f439l);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                if (!this.f418J.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f415G));
                }
                new C0480ab(str6, this.f418J.mo8467c(), a2).mo8217b();
            }
        } else {
            new C0480ab(str5, this.f418J.mo8467c(), a2).mo8217b();
        }
        return true;
    }

    /* renamed from: k */
    private void m369k() {
        double d = (double) this.f440m;
        double d2 = (double) this.f443p;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) this.f441n;
        double d5 = (double) this.f444q;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d3 > d6) {
            d3 = d6;
        }
        double d7 = (double) this.f443p;
        Double.isNaN(d7);
        int i = (int) (d7 * d3);
        double d8 = (double) this.f444q;
        Double.isNaN(d8);
        int i2 = (int) (d8 * d3);
        new C0749a().mo8726a("setMeasuredDimension to ").mo8724a(i).mo8726a(" by ").mo8724a(i2).mo8728a(C0748w.f1168d);
        setMeasuredDimension(i, i2);
        if (this.f410B) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    public void onMeasure(int i, int i2) {
        m369k();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m371l() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "id", this.f415G);
        new C0480ab("AdSession.on_error", this.f418J.mo8467c(), a).mo8217b();
        this.f449v = true;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        m371l();
        C0749a aVar = new C0749a();
        StringBuilder sb = new StringBuilder();
        sb.append("MediaPlayer error: ");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        aVar.mo8726a(sb.toString()).mo8728a(C0748w.f1171g);
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f453z = true;
        if (this.f413E) {
            this.f418J.removeView(this.f423O);
        }
        if (this.f410B) {
            this.f443p = mediaPlayer.getVideoWidth();
            this.f444q = mediaPlayer.getVideoHeight();
            m369k();
            new C0749a().mo8726a("MediaPlayer getVideoWidth = ").mo8724a(mediaPlayer.getVideoWidth()).mo8728a(C0748w.f1168d);
            new C0749a().mo8726a("MediaPlayer getVideoHeight = ").mo8724a(mediaPlayer.getVideoHeight()).mo8728a(C0748w.f1168d);
        }
        JSONObject a = C0746u.m892a();
        C0746u.m912b(a, "id", this.f442o);
        C0746u.m912b(a, "container_id", this.f418J.mo8470d());
        C0746u.m902a(a, "ad_session_id", this.f415G);
        new C0749a().mo8726a("ADCVideoView is prepared").mo8728a(C0748w.f1166b);
        new C0480ab("VideoView.on_ready", this.f418J.mo8467c(), a).mo8217b();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f449v = true;
        this.f446s = this.f447t;
        C0746u.m912b(this.f425Q, "id", this.f442o);
        C0746u.m912b(this.f425Q, "container_id", this.f418J.mo8470d());
        C0746u.m902a(this.f425Q, "ad_session_id", this.f415G);
        C0746u.m900a(this.f425Q, "elapsed", this.f446s);
        C0746u.m900a(this.f425Q, "duration", this.f447t);
        new C0480ab("VideoView.on_progress", this.f418J.mo8467c(), this.f425Q).mo8217b();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ExecutorService executorService = this.f426R;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.f426R.submit(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (C0546au.this.f427S != null) {
                            JSONObject a = C0746u.m892a();
                            C0746u.m912b(a, "id", C0546au.this.f442o);
                            C0746u.m902a(a, "ad_session_id", C0546au.this.f415G);
                            C0746u.m913b(a, "success", true);
                            C0546au.this.f427S.mo8216a(a).mo8217b();
                            C0546au.this.f427S = null;
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
                m371l();
            }
        }
    }

    /* renamed from: m */
    private void m373m() {
        try {
            this.f426R.submit(new Runnable() {
                public void run() {
                    C0546au.this.f448u = 0;
                    while (!C0546au.this.f449v && !C0546au.this.f452y && C0476a.m86d()) {
                        Context c = C0476a.m85c();
                        if (!C0546au.this.f449v && !C0546au.this.f409A && c != null && (c instanceof Activity)) {
                            if (C0546au.this.f424P.isPlaying()) {
                                if (C0546au.this.f448u == 0 && C0476a.f151b) {
                                    C0546au.this.f448u = System.currentTimeMillis();
                                }
                                C0546au.this.f451x = true;
                                C0546au auVar = C0546au.this;
                                double currentPosition = (double) auVar.f424P.getCurrentPosition();
                                Double.isNaN(currentPosition);
                                auVar.f446s = currentPosition / 1000.0d;
                                C0546au auVar2 = C0546au.this;
                                double duration = (double) auVar2.f424P.getDuration();
                                Double.isNaN(duration);
                                auVar2.f447t = duration / 1000.0d;
                                if (System.currentTimeMillis() - C0546au.this.f448u > 1000 && !C0546au.this.f412D && C0476a.f151b) {
                                    if (C0546au.this.f446s == 0.0d) {
                                        new C0749a().mo8726a("getCurrentPosition() not working, firing ").mo8726a("AdSession.on_error").mo8728a(C0748w.f1172h);
                                        C0546au.this.m371l();
                                    } else {
                                        C0546au.this.f412D = true;
                                    }
                                }
                                if (C0546au.this.f411C) {
                                    C0546au.this.mo8379c();
                                }
                            }
                            if (C0546au.this.f451x && !C0546au.this.f449v && !C0546au.this.f452y) {
                                C0746u.m912b(C0546au.this.f425Q, "id", C0546au.this.f442o);
                                C0746u.m912b(C0546au.this.f425Q, "container_id", C0546au.this.f418J.mo8470d());
                                C0746u.m902a(C0546au.this.f425Q, "ad_session_id", C0546au.this.f415G);
                                C0746u.m900a(C0546au.this.f425Q, "elapsed", C0546au.this.f446s);
                                C0746u.m900a(C0546au.this.f425Q, "duration", C0546au.this.f447t);
                                new C0480ab("VideoView.on_progress", C0546au.this.f418J.mo8467c(), C0546au.this.f425Q).mo8217b();
                            }
                            if (C0546au.this.f450w || ((Activity) c).isFinishing()) {
                                C0546au.this.f450w = false;
                                C0546au.this.mo8380d();
                            } else {
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException unused) {
                                    C0546au.this.m371l();
                                    new C0749a().mo8726a("InterruptedException in ADCVideoView's update thread.").mo8728a(C0748w.f1171g);
                                }
                            }
                        }
                        return;
                    }
                    if (C0546au.this.f450w) {
                        C0546au.this.mo8380d();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            m371l();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8379c() {
        if (this.f435h) {
            this.f432e = (float) (360.0d / this.f447t);
            this.f437j.setColor(-3355444);
            this.f437j.setShadowLayer((float) ((int) (this.f433f * 2.0f)), 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
            this.f437j.setTextAlign(Align.CENTER);
            this.f437j.setLinearText(true);
            this.f437j.setTextSize(this.f433f * 12.0f);
            this.f436i.setStyle(Style.STROKE);
            float f = this.f433f;
            float f2 = 6.0f;
            if (f * 2.0f <= 6.0f) {
                f2 = f * 2.0f;
            }
            float f3 = 4.0f;
            if (f2 >= 4.0f) {
                f3 = f2;
            }
            this.f436i.setStrokeWidth(f3);
            this.f436i.setShadowLayer((float) ((int) (this.f433f * 3.0f)), 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
            this.f436i.setColor(-3355444);
            Rect rect = new Rect();
            this.f437j.getTextBounds("0123456789", 0, 9, rect);
            this.f430c = (float) rect.height();
            final Context c = C0476a.m85c();
            if (c != null) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        C0546au auVar = C0546au.this;
                        auVar.f422N = new C0556a(c);
                        LayoutParams layoutParams = new LayoutParams((int) (C0546au.this.f430c * 4.0f), (int) (C0546au.this.f430c * 4.0f));
                        layoutParams.setMargins(0, C0546au.this.f418J.mo8490o() - ((int) (C0546au.this.f430c * 4.0f)), 0, 0);
                        layoutParams.gravity = 0;
                        C0546au.this.f418J.addView(C0546au.this.f422N, layoutParams);
                    }
                });
            }
            this.f435h = false;
        }
        this.f434g = (int) (this.f447t - this.f446s);
        float f4 = this.f430c;
        this.f428a = (float) ((int) f4);
        this.f429b = (float) ((int) (3.0f * f4));
        RectF rectF = this.f421M;
        float f5 = this.f428a;
        float f6 = f5 - (f4 / 2.0f);
        float f7 = this.f429b;
        rectF.set(f6, f7 - (f4 * 2.0f), f5 + (f4 * 2.0f), f7 + (f4 / 2.0f));
        double d = (double) this.f432e;
        double d2 = this.f447t - this.f446s;
        Double.isNaN(d);
        this.f431d = (float) (d * d2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8380d() {
        new C0749a().mo8726a("MediaPlayer stopped and released.").mo8728a(C0748w.f1168d);
        try {
            if (!this.f449v && this.f453z && this.f424P.isPlaying()) {
                this.f424P.stop();
            }
        } catch (IllegalStateException unused) {
            new C0749a().mo8726a("Caught IllegalStateException when calling stop on MediaPlayer").mo8728a(C0748w.f1170f);
        }
        ProgressBar progressBar = this.f423O;
        if (progressBar != null) {
            this.f418J.removeView(progressBar);
        }
        this.f449v = true;
        this.f453z = false;
        this.f424P.release();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m350b(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f438k = C0746u.m914c(c, "x");
        this.f439l = C0746u.m914c(c, "y");
        this.f440m = C0746u.m914c(c, "width");
        this.f441n = C0746u.m914c(c, "height");
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f438k, this.f439l, 0, 0);
        layoutParams.width = this.f440m;
        layoutParams.height = this.f441n;
        setLayoutParams(layoutParams);
        if (this.f411C && this.f422N != null) {
            float f = this.f430c;
            LayoutParams layoutParams2 = new LayoutParams((int) (f * 4.0f), (int) (f * 4.0f));
            layoutParams2.setMargins(0, this.f418J.mo8490o() - ((int) (this.f430c * 4.0f)), 0, 0);
            layoutParams2.gravity = 0;
            this.f422N.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m354c(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
            if (this.f411C) {
                C0556a aVar = this.f422N;
                if (aVar != null) {
                    aVar.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        setVisibility(4);
        if (this.f411C) {
            C0556a aVar2 = this.f422N;
            if (aVar2 != null) {
                aVar2.setVisibility(4);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m357d(C0480ab abVar) {
        boolean z = false;
        if (!this.f453z) {
            return false;
        }
        float e = (float) C0746u.m919e(abVar.mo8220c(), "volume");
        AdColonyInterstitial v = C0476a.m77a().mo8588v();
        if (v != null) {
            if (((double) e) <= 0.0d) {
                z = true;
            }
            v.mo8136b(z);
        }
        this.f424P.setVolume(e, e);
        JSONObject a = C0746u.m892a();
        C0746u.m913b(a, "success", true);
        abVar.mo8216a(a).mo8217b();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8381e() {
        if (!this.f453z) {
            return false;
        }
        if (!this.f452y && C0476a.f151b) {
            this.f424P.start();
            m373m();
            new C0749a().mo8726a("MediaPlayer is prepared - ADCVideoView play() called.").mo8728a(C0748w.f1166b);
        } else if (!this.f449v && C0476a.f151b) {
            this.f424P.start();
            this.f452y = false;
            if (!this.f426R.isShutdown()) {
                m373m();
            }
            C0556a aVar = this.f422N;
            if (aVar != null) {
                aVar.invalidate();
            }
        }
        setWillNotDraw(false);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo8382f() {
        if (!this.f453z) {
            new C0749a().mo8726a("ADCVideoView pause() called while MediaPlayer is not prepared.").mo8728a(C0748w.f1170f);
            return false;
        } else if (!this.f451x) {
            new C0749a().mo8726a("Ignoring ADCVideoView pause due to invalid MediaPlayer state.").mo8728a(C0748w.f1168d);
            return false;
        } else {
            this.f445r = this.f424P.getCurrentPosition();
            this.f447t = (double) this.f424P.getDuration();
            this.f424P.pause();
            this.f452y = true;
            new C0749a().mo8726a("Video view paused").mo8728a(C0748w.f1166b);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m360e(C0480ab abVar) {
        if (!this.f453z) {
            return false;
        }
        if (this.f449v) {
            this.f449v = false;
        }
        this.f427S = abVar;
        int c = C0746u.m914c(abVar.mo8220c(), "time");
        int i = c * 1000;
        int duration = this.f424P.getDuration() / 1000;
        this.f424P.setOnSeekCompleteListener(this);
        this.f424P.seekTo(i);
        if (duration == c) {
            this.f449v = true;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8383g() {
        this.f450w = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo8384h() {
        return this.f424P != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public MediaPlayer mo8385i() {
        return this.f424P;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo8386j() {
        return this.f449v;
    }
}
