package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbpn {
    private final Set<zzbqs<zztp>> zzfhk;
    private final Set<zzbqs<zzbna>> zzfhl;
    private final Set<zzbqs<zzbnj>> zzfhm;
    private final Set<zzbqs<zzbol>> zzfhn;
    private final Set<zzbqs<zzbog>> zzfho;
    private final Set<zzbqs<zzbnb>> zzfhp;
    private final Set<zzbqs<zzbnf>> zzfhq;
    private final Set<zzbqs<AdMetadataListener>> zzfhr;
    private final Set<zzbqs<AppEventListener>> zzfhs;
    private zzbmz zzfht;
    private zzcjf zzfhu;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public Set<zzbqs<zztp>> zzfhk = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbna>> zzfhl = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbnj>> zzfhm = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbol>> zzfhn = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbog>> zzfho = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbnb>> zzfhp = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<zzbnf>> zzfhq = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<AdMetadataListener>> zzfhr = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbqs<AppEventListener>> zzfhs = new HashSet();

        public final zza zza(zzbna zzbna, Executor executor) {
            this.zzfhl.add(new zzbqs(zzbna, executor));
            return this;
        }

        public final zza zza(zzbog zzbog, Executor executor) {
            this.zzfho.add(new zzbqs(zzbog, executor));
            return this;
        }

        public final zza zza(zzbnb zzbnb, Executor executor) {
            this.zzfhp.add(new zzbqs(zzbnb, executor));
            return this;
        }

        public final zza zza(zzbnf zzbnf, Executor executor) {
            this.zzfhq.add(new zzbqs(zzbnf, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfhr.add(new zzbqs(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfhs.add(new zzbqs(appEventListener, executor));
            return this;
        }

        public final zza zza(@Nullable zzvt zzvt, Executor executor) {
            if (this.zzfhs != null) {
                zzcml zzcml = new zzcml();
                zzcml.zzb(zzvt);
                this.zzfhs.add(new zzbqs(zzcml, executor));
            }
            return this;
        }

        public final zza zza(zztp zztp, Executor executor) {
            this.zzfhk.add(new zzbqs(zztp, executor));
            return this;
        }

        public final zza zza(zzbnj zzbnj, Executor executor) {
            this.zzfhm.add(new zzbqs(zzbnj, executor));
            return this;
        }

        public final zza zza(zzbol zzbol, Executor executor) {
            this.zzfhn.add(new zzbqs(zzbol, executor));
            return this;
        }

        public final zzbpn zzagm() {
            return new zzbpn(this);
        }
    }

    private zzbpn(zza zza2) {
        this.zzfhk = zza2.zzfhk;
        this.zzfhm = zza2.zzfhm;
        this.zzfhn = zza2.zzfhn;
        this.zzfhl = zza2.zzfhl;
        this.zzfho = zza2.zzfho;
        this.zzfhp = zza2.zzfhp;
        this.zzfhq = zza2.zzfhq;
        this.zzfhr = zza2.zzfhr;
        this.zzfhs = zza2.zzfhs;
    }

    public final Set<zzbqs<zzbna>> zzagd() {
        return this.zzfhl;
    }

    public final Set<zzbqs<zzbog>> zzage() {
        return this.zzfho;
    }

    public final Set<zzbqs<zzbnb>> zzagf() {
        return this.zzfhp;
    }

    public final Set<zzbqs<zzbnf>> zzagg() {
        return this.zzfhq;
    }

    public final Set<zzbqs<AdMetadataListener>> zzagh() {
        return this.zzfhr;
    }

    public final Set<zzbqs<AppEventListener>> zzagi() {
        return this.zzfhs;
    }

    public final Set<zzbqs<zztp>> zzagj() {
        return this.zzfhk;
    }

    public final Set<zzbqs<zzbnj>> zzagk() {
        return this.zzfhm;
    }

    public final Set<zzbqs<zzbol>> zzagl() {
        return this.zzfhn;
    }

    public final zzbmz zzc(Set<zzbqs<zzbnb>> set) {
        if (this.zzfht == null) {
            this.zzfht = new zzbmz(set);
        }
        return this.zzfht;
    }

    public final zzcjf zza(Clock clock) {
        if (this.zzfhu == null) {
            this.zzfhu = new zzcjf(clock);
        }
        return this.zzfhu;
    }
}
