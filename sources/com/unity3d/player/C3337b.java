package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.b */
class C3337b {

    /* renamed from: a */
    protected C3356n f7994a = null;

    /* renamed from: b */
    protected C3341e f7995b = null;

    /* renamed from: c */
    protected Context f7996c = null;

    /* renamed from: d */
    protected String f7997d = null;

    /* renamed from: e */
    protected String f7998e = "";

    C3337b(String str, C3341e eVar) {
        this.f7998e = str;
        this.f7995b = eVar;
    }

    /* access modifiers changed from: protected */
    public void reportError(String str) {
        C3341e eVar = this.f7995b;
        String str2 = " Error [";
        if (eVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7998e);
            sb.append(str2);
            sb.append(this.f7997d);
            sb.append("]");
            eVar.reportError(sb.toString(), str);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7998e);
        sb2.append(str2);
        sb2.append(this.f7997d);
        sb2.append("]: ");
        sb2.append(str);
        C3342f.Log(6, sb2.toString());
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        Context context = this.f7996c;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
            return;
        }
        StringBuilder sb = new StringBuilder("Not running ");
        sb.append(this.f7998e);
        sb.append(" from an Activity; Ignoring execution request...");
        C3342f.Log(5, sb.toString());
    }

    /* access modifiers changed from: protected */
    public boolean runOnUiThreadWithSync(final Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        boolean z = false;
        final Semaphore semaphore = new Semaphore(0);
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    C3337b bVar = C3337b.this;
                    StringBuilder sb = new StringBuilder("Exception unloading Google VR on UI Thread. ");
                    sb.append(e.getLocalizedMessage());
                    bVar.reportError(sb.toString());
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
            }
        });
        try {
            if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                reportError("Timeout waiting for vr state change!");
            } else {
                z = true;
            }
        } catch (InterruptedException e) {
            StringBuilder sb = new StringBuilder("Interrupted while trying to acquire sync lock. ");
            sb.append(e.getLocalizedMessage());
            reportError(sb.toString());
        }
        return z;
    }
}
