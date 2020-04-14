package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchm {
    private final AtomicReference<zzajx> zzfyg = new AtomicReference<>();

    zzchm() {
    }

    public final void zzb(zzajx zzajx) {
        this.zzfyg.compareAndSet(null, zzajx);
    }

    public final zzcwm zze(String str, JSONObject jSONObject) throws zzcwh {
        zzajy zzajy;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzajy = new zzakt((MediationAdapter) new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzajy = new zzakt((MediationAdapter) new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzajy = new zzakt((MediationAdapter) new zzamt());
            } else {
                zzajy = zzf(str, jSONObject);
            }
            return new zzcwm(zzajy);
        } catch (Throwable th) {
            throw new zzcwh(th);
        }
    }

    public final zzamd zzdd(String str) throws RemoteException {
        return zzaku().zzdd(str);
    }

    public final boolean zzakt() {
        return this.zzfyg.get() != null;
    }

    private final zzajy zzf(String str, JSONObject jSONObject) throws RemoteException {
        zzajx zzaku = zzaku();
        String str2 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        String str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        if (str2.equals(str) || str3.equals(str)) {
            try {
                if (zzaku.zzda(jSONObject.getString("class_name"))) {
                    return zzaku.zzcz(str3);
                }
                return zzaku.zzcz(str2);
            } catch (JSONException e) {
                zzaug.zzc("Invalid custom event.", e);
            }
        }
        return zzaku.zzcz(str);
    }

    private final zzajx zzaku() throws RemoteException {
        zzajx zzajx = (zzajx) this.zzfyg.get();
        if (zzajx != null) {
            return zzajx;
        }
        zzaug.zzeu("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
