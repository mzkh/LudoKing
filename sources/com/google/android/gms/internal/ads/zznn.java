package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zznq;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zznn<T extends zznq> extends Handler implements Runnable {
    private volatile boolean zzaei;
    private final T zzbfr;
    private final zzno<T> zzbfs;
    public final int zzbft;
    private final long zzbfu;
    private IOException zzbfv;
    private int zzbfw;
    private volatile Thread zzbfx;
    private final /* synthetic */ zznl zzbfy;

    public zznn(zznl zznl, Looper looper, T t, zzno<T> zzno, int i, long j) {
        this.zzbfy = zznl;
        super(looper);
        this.zzbfr = t;
        this.zzbfs = zzno;
        this.zzbft = i;
        this.zzbfu = j;
    }

    public final void zzbb(int i) throws IOException {
        IOException iOException = this.zzbfv;
        if (iOException != null && this.zzbfw > i) {
            throw iOException;
        }
    }

    public final void zzee(long j) {
        zznr.checkState(this.zzbfy.zzbfn == null);
        this.zzbfy.zzbfn = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzk(boolean z) {
        this.zzaei = z;
        this.zzbfv = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbfr.cancelLoad();
            if (this.zzbfx != null) {
                this.zzbfx.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbfs.zza(this.zzbfr, elapsedRealtime, elapsedRealtime - this.zzbfu, true);
        }
    }

    public final void run() {
        String str = "LoadTask";
        try {
            this.zzbfx = Thread.currentThread();
            if (!this.zzbfr.zzhj()) {
                String str2 = "load:";
                String valueOf = String.valueOf(this.zzbfr.getClass().getSimpleName());
                zzog.beginSection(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                this.zzbfr.zzhk();
                zzog.endSection();
            }
            if (!this.zzaei) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzaei) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zznr.checkState(this.zzbfr.zzhj());
            if (!this.zzaei) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e(str, "Unexpected exception loading stream", e2);
            if (!this.zzaei) {
                obtainMessage(3, new zznp(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e(str, "OutOfMemory error loading stream", e3);
            if (!this.zzaei) {
                obtainMessage(3, new zznp(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e(str, "Unexpected error loading stream", e4);
            if (!this.zzaei) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzog.endSection();
            throw th;
        }
    }

    public final void handleMessage(Message message) {
        int i;
        if (!this.zzaei) {
            if (message.what == 0) {
                execute();
            } else if (message.what != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zzbfu;
                if (this.zzbfr.zzhj()) {
                    this.zzbfs.zza(this.zzbfr, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.zzbfs.zza(this.zzbfr, elapsedRealtime, j, false);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.zzbfv = (IOException) message.obj;
                        int zza = this.zzbfs.zza(this.zzbfr, elapsedRealtime, j, this.zzbfv);
                        if (zza == 3) {
                            this.zzbfy.zzbfo = this.zzbfv;
                        } else if (zza != 2) {
                            if (zza == 1) {
                                i = 1;
                            } else {
                                i = this.zzbfw + 1;
                            }
                            this.zzbfw = i;
                            zzee((long) Math.min((this.zzbfw - 1) * 1000, 5000));
                        }
                    }
                } else {
                    this.zzbfs.zza(this.zzbfr, elapsedRealtime, j);
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    private final void execute() {
        this.zzbfv = null;
        this.zzbfy.zzbfm.execute(this.zzbfy.zzbfn);
    }

    private final void finish() {
        this.zzbfy.zzbfn = null;
    }
}
