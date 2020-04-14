package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzwz {
    private final int zzabj;
    private final int zzabk;
    private final String zzabl;
    private final boolean zzbkg;
    private final int zzcby;
    private final String zzccb;
    private final String zzccd;
    private final Bundle zzccf;
    private final String zzcch;
    private final boolean zzccj;
    private final Bundle zzcec;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzceg;
    private final SearchAdRequest zzceh;
    private final Set<String> zzcei;
    private final Set<String> zzcej;
    private final zzcyw zzcek;
    private final Date zznc;
    private final Set<String> zzne;
    private final Location zzng;

    public zzwz(zzwy zzwy) {
        this(zzwy, null);
    }

    public zzwz(zzwy zzwy, SearchAdRequest searchAdRequest) {
        this.zznc = zzwy.zznc;
        this.zzccd = zzwy.zzccd;
        this.zzcby = zzwy.zzcby;
        this.zzne = Collections.unmodifiableSet(zzwy.zzceb);
        this.zzng = zzwy.zzng;
        this.zzbkg = zzwy.zzbkg;
        this.zzcec = zzwy.zzcec;
        this.zzceg = Collections.unmodifiableMap(zzwy.zzced);
        this.zzccb = zzwy.zzccb;
        this.zzcch = zzwy.zzcch;
        this.zzceh = searchAdRequest;
        this.zzabj = zzwy.zzabj;
        this.zzcei = Collections.unmodifiableSet(zzwy.zzcee);
        this.zzccf = zzwy.zzccf;
        this.zzcej = Collections.unmodifiableSet(zzwy.zzcef);
        this.zzccj = zzwy.zzccj;
        this.zzcek = null;
        this.zzabk = zzwy.zzabk;
        this.zzabl = zzwy.zzabl;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zznc;
    }

    public final String getContentUrl() {
        return this.zzccd;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcby;
    }

    public final Set<String> getKeywords() {
        return this.zzne;
    }

    public final Location getLocation() {
        return this.zzng;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbkg;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzceg.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcec.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcec.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.zzccb;
    }

    public final String zzpa() {
        return this.zzcch;
    }

    public final SearchAdRequest zzpb() {
        return this.zzceh;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzcei;
        zzuv.zzoj();
        return set.contains(zzawy.zzbi(context));
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzpc() {
        return this.zzceg;
    }

    public final Bundle zzpd() {
        return this.zzcec;
    }

    public final int zzpe() {
        return this.zzabj;
    }

    public final Bundle getCustomTargeting() {
        return this.zzccf;
    }

    public final Set<String> zzpf() {
        return this.zzcej;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzccj;
    }

    public final int zzpg() {
        return this.zzabk;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.zzabl;
    }
}
