package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzh implements zzdc, Runnable {
    private final List<Object[]> zzblf = new Vector();
    private final AtomicReference<zzdc> zzblg = new AtomicReference<>();
    private zzaxl zzblh;
    private CountDownLatch zzbli = new CountDownLatch(1);
    private Context zzlk;

    public zzh(Context context, zzaxl zzaxl) {
        this.zzlk = context;
        this.zzblh = zzaxl;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnl)).booleanValue()) {
            zzaxn.zzdwi.execute(this);
            return;
        }
        zzuv.zzoj();
        if (zzawy.zzwk()) {
            zzaxn.zzdwi.execute(this);
        } else {
            run();
        }
    }

    private final boolean zzjn() {
        try {
            this.zzbli.await();
            return true;
        } catch (InterruptedException e) {
            zzaug.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzjo() {
        if (!this.zzblf.isEmpty()) {
            for (Object[] objArr : this.zzblf) {
                if (objArr.length == 1) {
                    ((zzdc) this.zzblg.get()).zzb((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzdc) this.zzblg.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzblf.clear();
        }
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final String zza(Context context) {
        if (zzjn()) {
            zzdc zzdc = (zzdc) this.zzblg.get();
            if (zzdc != null) {
                zzjo();
                return zzdc.zza(zze(context));
            }
        }
        return "";
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        if (zzjn()) {
            zzdc zzdc = (zzdc) this.zzblg.get();
            if (zzdc != null) {
                zzjo();
                return zzdc.zza(zze(context), str, view, activity);
            }
        }
        return "";
    }

    public final void zzb(View view) {
        zzdc zzdc = (zzdc) this.zzblg.get();
        if (zzdc != null) {
            zzdc.zzb(view);
        }
    }

    public final void zzb(MotionEvent motionEvent) {
        zzdc zzdc = (zzdc) this.zzblg.get();
        if (zzdc != null) {
            zzjo();
            zzdc.zzb(motionEvent);
            return;
        }
        this.zzblf.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdc zzdc = (zzdc) this.zzblg.get();
        if (zzdc != null) {
            zzjo();
            zzdc.zza(i, i2, i3);
            return;
        }
        this.zzblf.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzblh.zzdwg;
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzckr)).booleanValue() && z2) {
                z = true;
            }
            this.zzblg.set(zzdg.zza(this.zzblh.zzblz, zze(this.zzlk), z));
        } finally {
            this.zzbli.countDown();
            this.zzlk = null;
            this.zzblh = null;
        }
    }
}
