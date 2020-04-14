package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvm implements OnClickListener {
    private final Clock zzbmp;
    private final zzbyh zzfnd;
    @Nullable
    private zzadf zzfne;
    @Nullable
    private zzaer<Object> zzfnf;
    @VisibleForTesting
    @Nullable
    String zzfng;
    @VisibleForTesting
    @Nullable
    Long zzfnh;
    @VisibleForTesting
    @Nullable
    WeakReference<View> zzfni;

    public zzbvm(zzbyh zzbyh, Clock clock) {
        this.zzfnd = zzbyh;
        this.zzbmp = clock;
    }

    public final void zza(zzadf zzadf) {
        this.zzfne = zzadf;
        zzaer<Object> zzaer = this.zzfnf;
        String str = "/unconfirmedClick";
        if (zzaer != null) {
            this.zzfnd.zzb(str, zzaer);
        }
        this.zzfnf = new zzbvp(this, zzadf);
        this.zzfnd.zza(str, this.zzfnf);
    }

    @Nullable
    public final zzadf zzaiw() {
        return this.zzfne;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfne != null && this.zzfnh != null) {
            zzaix();
            try {
                this.zzfne.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzfni;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzfng == null || this.zzfnh == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzfng);
                hashMap.put("time_interval", String.valueOf(this.zzbmp.currentTimeMillis() - this.zzfnh.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzfnd.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            zzaix();
        }
    }

    private final void zzaix() {
        this.zzfng = null;
        this.zzfnh = null;
        WeakReference<View> weakReference = this.zzfni;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
                this.zzfni = null;
            }
        }
    }
}
