package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzot implements Callback, FrameCallback {
    private static final zzot zzbiq = new zzot();
    private final Handler handler;
    public volatile long zzbip;
    private final HandlerThread zzbir = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer zzbis;
    private int zzbit;

    public static zzot zzja() {
        return zzbiq;
    }

    private zzot() {
        this.zzbir.start();
        this.handler = new Handler(this.zzbir.getLooper(), this);
        this.handler.sendEmptyMessage(0);
    }

    public final void zzjb() {
        this.handler.sendEmptyMessage(1);
    }

    public final void zzjc() {
        this.handler.sendEmptyMessage(2);
    }

    public final void doFrame(long j) {
        this.zzbip = j;
        this.zzbis.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbis = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            this.zzbit++;
            if (this.zzbit == 1) {
                this.zzbis.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.zzbit--;
            if (this.zzbit == 0) {
                this.zzbis.removeFrameCallback(this);
                this.zzbip = 0;
            }
            return true;
        }
    }
}
