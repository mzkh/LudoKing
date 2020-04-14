package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {

    /* renamed from: h */
    private static int f8104h = 0;

    /* renamed from: i */
    private static int f8105i = 1;

    /* renamed from: j */
    private static int f8106j = 2;

    /* renamed from: k */
    private static int f8107k = 3;

    /* renamed from: a */
    private volatile Thread f8108a = null;

    /* renamed from: b */
    private volatile boolean f8109b = false;

    /* renamed from: c */
    private AudioTrack f8110c = null;

    /* renamed from: d */
    private boolean f8111d = false;

    /* renamed from: e */
    private ByteBuffer f8112e = null;

    /* renamed from: f */
    private byte[] f8113f = null;

    /* renamed from: g */
    private volatile C3496a f8114g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f8110c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f8110c.stop();
            }
            this.f8110c.release();
            this.f8110c = null;
        }
        this.f8112e = null;
        this.f8113f = null;
        this.f8111d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* access modifiers changed from: 0000 */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f8108a != null && this.f8108a.isAlive();
    }

    public void run() {
        int i = 3;
        while (this.f8109b) {
            if (!this.f8111d && i > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f8104h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f8105i);
                int fmodGetInfo3 = fmodGetInfo(f8106j) * fmodGetInfo2 * 4;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, 3, 2, fmodGetInfo3 > round ? fmodGetInfo3 : round, 1);
                this.f8110c = audioTrack;
                this.f8111d = this.f8110c.getState() == 1;
                if (this.f8111d) {
                    this.f8112e = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f8113f = new byte[this.f8112e.capacity()];
                    this.f8110c.play();
                    i = 3;
                } else {
                    StringBuilder sb = new StringBuilder("AudioTrack failed to initialize (status ");
                    sb.append(this.f8110c.getState());
                    sb.append(")");
                    Log.e("FMOD", sb.toString());
                    releaseAudioTrack();
                    i--;
                }
            }
            if (this.f8111d) {
                if (fmodGetInfo(f8107k) == 1) {
                    fmodProcess(this.f8112e);
                    ByteBuffer byteBuffer = this.f8112e;
                    byteBuffer.get(this.f8113f, 0, byteBuffer.capacity());
                    this.f8110c.write(this.f8113f, 0, this.f8112e.capacity());
                    this.f8112e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f8108a != null) {
            stop();
        }
        this.f8108a = new Thread(this, "FMODAudioDevice");
        this.f8108a.setPriority(10);
        this.f8109b = true;
        this.f8108a.start();
        if (this.f8114g != null) {
            this.f8114g.mo31669b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f8114g == null) {
            this.f8114g = new C3496a(this, i, i2);
            this.f8114g.mo31669b();
        }
        return this.f8114g.mo31668a();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:16:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stop() {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            java.lang.Thread r0 = r1.f8108a     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
            r0 = 0
            r1.f8109b = r0     // Catch:{ all -> 0x001c }
            java.lang.Thread r0 = r1.f8108a     // Catch:{ InterruptedException -> 0x0001 }
            r0.join()     // Catch:{ InterruptedException -> 0x0001 }
            r0 = 0
            r1.f8108a = r0     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0011:
            org.fmod.a r0 = r1.f8114g     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            org.fmod.a r0 = r1.f8114g     // Catch:{ all -> 0x001c }
            r0.mo31670c()     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fmod.FMODAudioDevice.stop():void");
    }

    public synchronized void stopAudioRecord() {
        if (this.f8114g != null) {
            this.f8114g.mo31670c();
            this.f8114g = null;
        }
    }
}
