package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzwy {
    /* access modifiers changed from: private */
    public int zzabj = -1;
    /* access modifiers changed from: private */
    public int zzabk = -1;
    /* access modifiers changed from: private */
    public String zzabl;
    /* access modifiers changed from: private */
    public boolean zzbkg = false;
    /* access modifiers changed from: private */
    public int zzcby = -1;
    /* access modifiers changed from: private */
    public String zzccb;
    /* access modifiers changed from: private */
    public String zzccd;
    /* access modifiers changed from: private */
    public final Bundle zzccf = new Bundle();
    /* access modifiers changed from: private */
    public String zzcch;
    /* access modifiers changed from: private */
    public boolean zzccj;
    /* access modifiers changed from: private */
    public final HashSet<String> zzceb = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzcec = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzced = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcee = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcef = new HashSet<>();
    /* access modifiers changed from: private */
    public Date zznc;
    /* access modifiers changed from: private */
    public Location zzng;

    public final void zzca(String str) {
        this.zzceb.add(str);
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzced.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcec.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        String str = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        if (this.zzcec.getBundle(str) == null) {
            this.zzcec.putBundle(str, new Bundle());
        }
        this.zzcec.getBundle(str).putBundle(cls.getName(), bundle);
    }

    public final void zzcb(String str) {
        this.zzcee.add(str);
    }

    public final void zzcc(String str) {
        this.zzcee.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zznc = date;
    }

    public final void zzcd(String str) {
        this.zzccd = str;
    }

    @Deprecated
    public final void zzcg(int i) {
        this.zzcby = i;
    }

    public final void zza(Location location) {
        this.zzng = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbkg = z;
    }

    public final void zzce(String str) {
        this.zzccb = str;
    }

    public final void zzcf(String str) {
        this.zzcch = str;
    }

    @Deprecated
    public final void zzs(boolean z) {
        this.zzabj = z ? 1 : 0;
    }

    public final void zzg(String str, String str2) {
        this.zzccf.putString(str, str2);
    }

    public final void zzcg(String str) {
        this.zzcef.add(str);
    }

    @Deprecated
    public final void zzt(boolean z) {
        this.zzccj = z;
    }

    @Deprecated
    public final void zzch(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzabk = i;
        }
    }

    @Deprecated
    public final void zzch(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzabl = str;
        }
    }
}
