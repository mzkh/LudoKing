package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.inmobi.media.C2353dw.C2354a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.inmobi.media.dx */
/* compiled from: GifMovieObject */
public final class C2355dx implements C2353dw {

    /* renamed from: a */
    Movie f4993a;

    /* renamed from: b */
    int f4994b = 0;

    /* renamed from: c */
    private long f4995c;

    /* renamed from: d */
    private volatile boolean f4996d = false;

    /* renamed from: e */
    private C2354a f4997e;

    /* renamed from: f */
    private ExecutorService f4998f;

    /* renamed from: g */
    private Runnable f4999g;

    public C2355dx(String str) throws IOException {
        File file = new File(str);
        byte[] bArr = new byte[((int) file.length())];
        FileInputStream fileInputStream = new FileInputStream(file);
        int read = fileInputStream.read(bArr);
        fileInputStream.close();
        this.f4993a = Movie.decodeByteArray(bArr, 0, read);
        if (this.f4993a == null) {
            throw new IllegalStateException("Cannot decode gif byte array");
        }
    }

    /* renamed from: a */
    public final void mo28200a() {
        this.f4998f = Executors.newSingleThreadExecutor();
        this.f4999g = new Runnable() {
            public final void run() {
                if (C2355dx.this.f4994b + 20 >= C2355dx.this.f4993a.duration()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            C2355dx dxVar = C2355dx.this;
                            dxVar.f4994b = 0;
                            dxVar.mo28203a(false);
                        }
                    });
                }
            }
        };
    }

    /* renamed from: a */
    public final void mo28203a(boolean z) {
        this.f4996d = z;
        if (!this.f4996d) {
            this.f4995c = SystemClock.uptimeMillis() - ((long) this.f4994b);
        }
        C2354a aVar = this.f4997e;
        if (aVar != null) {
            aVar.mo28216a();
        }
    }

    /* renamed from: b */
    public final int mo28204b() {
        return this.f4993a.width();
    }

    /* renamed from: c */
    public final int mo28205c() {
        return this.f4993a.height();
    }

    /* renamed from: a */
    public final void mo28201a(Canvas canvas, float f, float f2) {
        this.f4993a.draw(canvas, f, f2);
        this.f4998f.execute(this.f4999g);
    }

    /* renamed from: d */
    public final boolean mo28206d() {
        return !this.f4996d;
    }

    /* renamed from: e */
    public final void mo28207e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f4995c == 0) {
            this.f4995c = uptimeMillis;
        }
        int duration = this.f4993a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f4994b = (int) ((uptimeMillis - this.f4995c) % ((long) duration));
        this.f4993a.setTime(this.f4994b);
    }

    /* renamed from: a */
    public final void mo28202a(C2354a aVar) {
        this.f4997e = aVar;
    }
}
