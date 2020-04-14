package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbnz;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckm<AdT, AdapterT, ListenerT extends zzbnz> implements zzcga<AdT> {
    private final zzcge<AdapterT, ListenerT> zzfai;
    private final zzcyg zzfgb;
    private final zzcgh<AdT, AdapterT, ListenerT> zzgaf;
    private final zzddl zzgag;

    public zzckm(zzcyg zzcyg, zzddl zzddl, zzcge<AdapterT, ListenerT> zzcge, zzcgh<AdT, AdapterT, ListenerT> zzcgh) {
        this.zzfgb = zzcyg;
        this.zzgag = zzddl;
        this.zzgaf = zzcgh;
        this.zzfai = zzcge;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return !zzcvr.zzgjf.isEmpty();
    }

    public final zzddi<AdT> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzcgf zzcgf;
        Iterator it = zzcvr.zzgjf.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcgf = null;
                break;
            }
            try {
                zzcgf = this.zzfai.zzd((String) it.next(), zzcvr.zzgjh);
                break;
            } catch (zzcwh unused) {
            }
        }
        if (zzcgf == null) {
            return zzdcy.zzi(new zzciv("unable to instantiate mediation adapter class"));
        }
        zzaxv zzaxv = new zzaxv();
        zzcgf.zzfxg.zza(new zzckr(this, zzaxv, zzcgf));
        if (zzcvr.zzdnj) {
            Bundle bundle = zzcvz.zzgka.zzfga.zzgkg.zzcce;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfgb.zzu(zzcyd.ADAPTER_LOAD_AD_SYN).zza((zzcxq) new zzckp(this, zzcvz, zzcvr, zzcgf), this.zzgag).zzw(zzcyd.ADAPTER_LOAD_AD_ACK).zzb((zzddi<O2>) zzaxv).zzw(zzcyd.ADAPTER_WRAP_ADAPTER).zzb((zzcxn<O, O2>) new zzcko<O,O2>(this, zzcvz, zzcvr, zzcgf)).zzant();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zza(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf, Void voidR) throws Exception {
        return this.zzgaf.zzb(zzcvz, zzcvr, zzcgf);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzd(zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) throws Exception {
        this.zzgaf.zza(zzcvz, zzcvr, zzcgf);
    }
}
