package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.drive.zzet;
import com.google.android.gms.internal.drive.zzfj;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class DriveEventService extends Service implements ChangeListener, CompletionListener, zzd, zzi {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    /* access modifiers changed from: private */
    public static final GmsLogger zzbx = new GmsLogger("DriveEventService", "");
    private final String name;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public CountDownLatch zzch;
    @GuardedBy("this")
    @VisibleForTesting
    zza zzci;
    @GuardedBy("this")
    boolean zzcj;
    @VisibleForTesting
    private int zzck;

    static final class zza extends Handler {
        private final WeakReference<DriveEventService> zzcn;

        private zza(DriveEventService driveEventService) {
            this.zzcn = new WeakReference<>(driveEventService);
        }

        /* synthetic */ zza(DriveEventService driveEventService, zzh zzh) {
            this(driveEventService);
        }

        /* access modifiers changed from: private */
        public final Message zzb(zzfj zzfj) {
            return obtainMessage(1, zzfj);
        }

        /* access modifiers changed from: private */
        public final Message zzx() {
            return obtainMessage(2);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DriveEventService driveEventService = (DriveEventService) this.zzcn.get();
                if (driveEventService != null) {
                    driveEventService.zza((zzfj) message.obj);
                } else {
                    getLooper().quit();
                }
            } else if (i != 2) {
                DriveEventService.zzbx.wfmt("DriveEventService", "Unexpected message type: %s", Integer.valueOf(message.what));
            } else {
                getLooper().quit();
            }
        }
    }

    @VisibleForTesting
    final class zzb extends zzet {
        private zzb() {
        }

        /* synthetic */ zzb(DriveEventService driveEventService, zzh zzh) {
            this();
        }

        public final void zzc(zzfj zzfj) throws RemoteException {
            synchronized (DriveEventService.this) {
                DriveEventService.this.zzv();
                if (DriveEventService.this.zzci != null) {
                    DriveEventService.this.zzci.sendMessage(DriveEventService.this.zzci.zzb(zzfj));
                } else {
                    DriveEventService.zzbx.mo15089e("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.zzcj = false;
        this.zzck = -1;
        this.name = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzfj zzfj) {
        String str = "DriveEventService";
        DriveEvent zzak = zzfj.zzak();
        try {
            int type = zzak.getType();
            if (type == 1) {
                onChange((ChangeEvent) zzak);
            } else if (type == 2) {
                onCompletion((CompletionEvent) zzak);
            } else if (type == 4) {
                zza((zzb) zzak);
            } else if (type != 7) {
                zzbx.wfmt(str, "Unhandled event: %s", zzak);
            } else {
                zzbx.wfmt(str, "Unhandled transfer state event in %s: %s", this.name, (zzv) zzak);
            }
        } catch (Exception e) {
            zzbx.mo15090e(str, String.format("Error handling event in %s", new Object[]{this.name}), e);
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzck) {
            if (UidVerifier.isGooglePlayServicesUid(this, callingUid)) {
                this.zzck = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (!ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            return null;
        }
        if (this.zzci == null && !this.zzcj) {
            this.zzcj = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zzch = new CountDownLatch(1);
            new zzh(this, countDownLatch).start();
            try {
                if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                    zzbx.mo15089e("DriveEventService", "Failed to synchronously initialize event handler.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Unable to start event handler", e);
            }
        }
        return new zzb(this, null).asBinder();
    }

    public void onChange(ChangeEvent changeEvent) {
        zzbx.wfmt("DriveEventService", "Unhandled change event in %s: %s", this.name, changeEvent);
    }

    public void onCompletion(CompletionEvent completionEvent) {
        zzbx.wfmt("DriveEventService", "Unhandled completion event in %s: %s", this.name, completionEvent);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|(1:8)|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDestroy() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.drive.events.DriveEventService$zza r0 = r5.zzci     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.drive.events.DriveEventService$zza r0 = r5.zzci     // Catch:{ all -> 0x002f }
            android.os.Message r0 = r0.zzx()     // Catch:{ all -> 0x002f }
            com.google.android.gms.drive.events.DriveEventService$zza r1 = r5.zzci     // Catch:{ all -> 0x002f }
            r1.sendMessage(r0)     // Catch:{ all -> 0x002f }
            r0 = 0
            r5.zzci = r0     // Catch:{ all -> 0x002f }
            java.util.concurrent.CountDownLatch r1 = r5.zzch     // Catch:{ InterruptedException -> 0x0028 }
            r2 = 5000(0x1388, double:2.4703E-320)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0028 }
            boolean r1 = r1.await(r2, r4)     // Catch:{ InterruptedException -> 0x0028 }
            if (r1 != 0) goto L_0x0028
            com.google.android.gms.common.internal.GmsLogger r1 = zzbx     // Catch:{ InterruptedException -> 0x0028 }
            java.lang.String r2 = "DriveEventService"
            java.lang.String r3 = "Failed to synchronously quit event handler. Will quit itself"
            r1.mo15098w(r2, r3)     // Catch:{ InterruptedException -> 0x0028 }
        L_0x0028:
            r5.zzch = r0     // Catch:{ all -> 0x002f }
        L_0x002a:
            super.onDestroy()     // Catch:{ all -> 0x002f }
            monitor-exit(r5)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.events.DriveEventService.onDestroy():void");
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public final void zza(zzb zzb2) {
        zzbx.wfmt("DriveEventService", "Unhandled changes available event in %s: %s", this.name, zzb2);
    }
}
