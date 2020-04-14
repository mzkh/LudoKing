package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: org.fmod.a */
final class C3496a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f8115a;

    /* renamed from: b */
    private final ByteBuffer f8116b;

    /* renamed from: c */
    private final int f8117c;

    /* renamed from: d */
    private final int f8118d;

    /* renamed from: e */
    private final int f8119e = 2;

    /* renamed from: f */
    private volatile Thread f8120f;

    /* renamed from: g */
    private volatile boolean f8121g;

    /* renamed from: h */
    private AudioRecord f8122h;

    /* renamed from: i */
    private boolean f8123i;

    C3496a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f8115a = fMODAudioDevice;
        this.f8117c = i;
        this.f8118d = i2;
        this.f8116b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: d */
    private void m7794d() {
        AudioRecord audioRecord = this.f8122h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f8122h.stop();
            }
            this.f8122h.release();
            this.f8122h = null;
        }
        this.f8116b.position(0);
        this.f8123i = false;
    }

    /* renamed from: a */
    public final int mo31668a() {
        return this.f8116b.capacity();
    }

    /* renamed from: b */
    public final void mo31669b() {
        if (this.f8120f != null) {
            mo31670c();
        }
        this.f8121g = true;
        this.f8120f = new Thread(this);
        this.f8120f.start();
    }

    /* renamed from: c */
    public final void mo31670c() {
        while (this.f8120f != null) {
            this.f8121g = false;
            try {
                this.f8120f.join();
                this.f8120f = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void run() {
        int i = 3;
        while (this.f8121g) {
            if (!this.f8123i && i > 0) {
                m7794d();
                AudioRecord audioRecord = new AudioRecord(1, this.f8117c, this.f8118d, this.f8119e, this.f8116b.capacity());
                this.f8122h = audioRecord;
                boolean z = true;
                if (this.f8122h.getState() != 1) {
                    z = false;
                }
                this.f8123i = z;
                if (this.f8123i) {
                    this.f8116b.position(0);
                    this.f8122h.startRecording();
                    i = 3;
                } else {
                    StringBuilder sb = new StringBuilder("AudioRecord failed to initialize (status ");
                    sb.append(this.f8122h.getState());
                    sb.append(")");
                    Log.e("FMOD", sb.toString());
                    i--;
                    m7794d();
                }
            }
            if (this.f8123i && this.f8122h.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.f8122h;
                ByteBuffer byteBuffer = this.f8116b;
                this.f8115a.fmodProcessMicData(this.f8116b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f8116b.position(0);
            }
        }
        m7794d();
    }
}
