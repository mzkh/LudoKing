package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.p */
class C0883p extends FrameLayout implements SurfaceTextureListener, C0890t {

    /* renamed from: a */
    private final C1227o f1597a;

    /* renamed from: b */
    private final TextureView f1598b;

    /* renamed from: c */
    private final MediaPlayer f1599c = new MediaPlayer();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0885a f1600d;

    /* renamed from: e */
    private int f1601e;

    /* renamed from: f */
    private int f1602f;

    /* renamed from: g */
    private int f1603g;

    /* renamed from: com.applovin.impl.adview.p$a */
    interface C0885a {
        /* renamed from: a */
        void mo9151a(String str);
    }

    C0883p(C1192i iVar, Context context, C0885a aVar) {
        super(context);
        this.f1597a = iVar.mo10249v();
        this.f1600d = aVar;
        this.f1598b = new TextureView(context);
        this.f1598b.setLayoutParams(new LayoutParams(-1, -1, 17));
        this.f1598b.setSurfaceTextureListener(this);
        addView(this.f1598b);
    }

    /* renamed from: a */
    private void m1342a(final String str) {
        this.f1597a.mo10382e("TextureVideoView", str);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0883p.this.f1600d.mo9151a(str);
            }
        }, 250);
    }

    public int getCurrentPosition() {
        return this.f1599c.getCurrentPosition();
    }

    public int getDuration() {
        return this.f1599c.getDuration();
    }

    public boolean isPlaying() {
        return this.f1599c.isPlaying();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        try {
            this.f1599c.setSurface(surface);
            this.f1599c.setAudioStreamType(3);
            this.f1599c.prepareAsync();
        } catch (Throwable unused) {
            surface.release();
            m1342a("Failed to prepare media player");
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        this.f1599c.pause();
    }

    public void seekTo(int i) {
        this.f1599c.seekTo(i);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f1599c.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f1599c.setOnErrorListener(onErrorListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f1599c.setOnPreparedListener(onPreparedListener);
    }

    public void setVideoSize(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int d = C1281o.m3108d(getContext());
        int i6 = this.f1601e;
        if (i6 == 0) {
            i4 = this.f1598b.getWidth();
            i3 = this.f1598b.getHeight();
            this.f1601e = d;
            this.f1602f = i4;
            this.f1603g = i3;
        } else if (d == i6) {
            i4 = this.f1602f;
            i3 = this.f1603g;
        } else {
            i4 = this.f1603g;
            i3 = this.f1602f;
        }
        float f = ((float) i2) / ((float) i);
        float f2 = (float) i4;
        int i7 = (int) (f2 * f);
        if (i3 >= i7) {
            i5 = i4;
        } else {
            i5 = (int) (((float) i3) / f);
            i7 = i3;
        }
        try {
            int i8 = (i4 - i5) / 2;
            int i9 = (i3 - i7) / 2;
            Matrix matrix = new Matrix();
            this.f1598b.getTransform(matrix);
            matrix.setScale(((float) i5) / f2, ((float) i7) / ((float) i3));
            matrix.postTranslate((float) i8, (float) i9);
            this.f1598b.setTransform(matrix);
            invalidate();
            requestLayout();
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to set video size to width: ");
            sb.append(i);
            sb.append(" height: ");
            sb.append(i2);
            m1342a(sb.toString());
        }
    }

    public void setVideoURI(Uri uri) {
        try {
            this.f1599c.setDataSource(uri.toString());
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to set video URI: ");
            sb.append(uri);
            sb.append(" at ");
            sb.append(th);
            m1342a(sb.toString());
        }
    }

    public void start() {
        this.f1599c.start();
    }

    public void stopPlayback() {
        this.f1599c.stop();
    }
}
