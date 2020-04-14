package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbs.zzc;
import com.google.android.gms.internal.measurement.zzbs.zzd;
import com.google.android.gms.internal.measurement.zzbs.zze;
import com.google.android.gms.internal.measurement.zzbs.zzf;
import com.google.android.gms.internal.measurement.zzbs.zzf.zza;
import com.google.android.gms.internal.measurement.zzbs.zzg;
import com.google.android.gms.internal.measurement.zzbs.zzh;
import com.google.android.gms.internal.measurement.zzbs.zzk;
import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzhp extends zzjh {
    public zzhp(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    @WorkerThread
    public final byte[] zzb(@NonNull zzai zzai, @Size(min = 1) String str) {
        zzjp zzjp;
        zza zza;
        zzg.zza zza2;
        zzf zzf;
        byte[] bArr;
        Bundle bundle;
        zzae zzae;
        long j;
        zzai zzai2 = zzai;
        String str2 = str;
        String str3 = "_r";
        zzo();
        this.zzj.zzl();
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str2, zzak.zzio)) {
            zzab().zzgr().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        }
        if (!"_iap".equals(zzai2.name)) {
            if (!"_iapx".equals(zzai2.name)) {
                zzab().zzgr().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzai2.name);
                return null;
            }
        }
        zza zznj = zzf.zznj();
        zzgy().beginTransaction();
        try {
            zzf zzab = zzgy().zzab(str2);
            if (zzab == null) {
                zzab().zzgr().zza("Log and bundle not available. package_name", str2);
                return new byte[0];
            } else if (!zzab.isMeasurementEnabled()) {
                zzab().zzgr().zza("Log and bundle disabled. package_name", str2);
                byte[] bArr2 = new byte[0];
                zzgy().endTransaction();
                return bArr2;
            } else {
                zzg.zza zzcc = zzg.zzpr().zzp(1).zzcc("android");
                if (!TextUtils.isEmpty(zzab.zzag())) {
                    zzcc.zzch(zzab.zzag());
                }
                if (!TextUtils.isEmpty(zzab.zzan())) {
                    zzcc.zzcg(zzab.zzan());
                }
                if (!TextUtils.isEmpty(zzab.zzal())) {
                    zzcc.zzci(zzab.zzal());
                }
                if (zzab.zzam() != -2147483648L) {
                    zzcc.zzv((int) zzab.zzam());
                }
                zzcc.zzas(zzab.zzao()).zzax(zzab.zzaq());
                if (!TextUtils.isEmpty(zzab.getGmpAppId())) {
                    zzcc.zzcm(zzab.getGmpAppId());
                } else if (!TextUtils.isEmpty(zzab.zzah())) {
                    zzcc.zzcq(zzab.zzah());
                }
                zzcc.zzau(zzab.zzap());
                if (this.zzj.isEnabled() && zzs.zzbv() && zzad().zzl(zzcc.zzag())) {
                    zzcc.zzag();
                    if (!TextUtils.isEmpty(null)) {
                        zzcc.zzcp(null);
                    }
                }
                Pair zzap = zzac().zzap(zzab.zzag());
                if (zzab.zzbe() && zzap != null && !TextUtils.isEmpty((CharSequence) zzap.first)) {
                    zzcc.zzcj(zzo((String) zzap.first, Long.toString(zzai2.zzfu)));
                    if (zzap.second != null) {
                        zzcc.zzm(((Boolean) zzap.second).booleanValue());
                    }
                }
                zzw().zzbi();
                zzg.zza zzce = zzcc.zzce(Build.MODEL);
                zzw().zzbi();
                zzce.zzcd(VERSION.RELEASE).zzt((int) zzw().zzcq()).zzcf(zzw().zzcr());
                try {
                    zzcc.zzck(zzo(zzab.getAppInstanceId(), Long.toString(zzai2.zzfu)));
                    if (!TextUtils.isEmpty(zzab.getFirebaseInstanceId())) {
                        zzcc.zzcn(zzab.getFirebaseInstanceId());
                    }
                    String zzag = zzab.zzag();
                    List zzaa = zzgy().zzaa(zzag);
                    Iterator it = zzaa.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzjp = null;
                            break;
                        }
                        zzjp = (zzjp) it.next();
                        if ("_lte".equals(zzjp.name)) {
                            break;
                        }
                    }
                    if (zzjp == null || zzjp.value == null) {
                        zzjp zzjp2 = new zzjp(zzag, "auto", "_lte", zzx().currentTimeMillis(), Long.valueOf(0));
                        zzaa.add(zzjp2);
                        zzgy().zza(zzjp2);
                    }
                    if (zzad().zze(zzag, zzak.zzij)) {
                        zzjo zzgw = zzgw();
                        zzgw.zzab().zzgs().zzao("Checking account type status for ad personalization signals");
                        if (zzgw.zzw().zzcu()) {
                            String zzag2 = zzab.zzag();
                            if (zzab.zzbe() && zzgw.zzgz().zzba(zzag2)) {
                                zzgw.zzab().zzgr().zzao("Turning off ad personalization due to account type");
                                Iterator it2 = zzaa.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    } else if ("_npa".equals(((zzjp) it2.next()).name)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                zzjp zzjp3 = new zzjp(zzag2, "auto", "_npa", zzgw.zzx().currentTimeMillis(), Long.valueOf(1));
                                zzaa.add(zzjp3);
                            }
                        }
                    }
                    zzk[] zzkArr = new zzk[zzaa.size()];
                    for (int i = 0; i < zzaa.size(); i++) {
                        zzk.zza zzbk = zzk.zzqu().zzdb(((zzjp) zzaa.get(i)).name).zzbk(((zzjp) zzaa.get(i)).zztr);
                        zzgw().zza(zzbk, ((zzjp) zzaa.get(i)).value);
                        zzkArr[i] = (zzk) ((zzey) zzbk.zzug());
                    }
                    zzcc.zzb(Arrays.asList(zzkArr));
                    Bundle zzcv = zzai2.zzfq.zzcv();
                    zzcv.putLong("_c", 1);
                    zzab().zzgr().zzao("Marking in-app purchase as real-time");
                    zzcv.putLong(str3, 1);
                    zzcv.putString("_o", zzai2.origin);
                    if (zzz().zzbr(zzcc.zzag())) {
                        zzz().zza(zzcv, "_dbg", (Object) Long.valueOf(1));
                        zzz().zza(zzcv, str3, (Object) Long.valueOf(1));
                    }
                    zzae zzc = zzgy().zzc(str2, zzai2.name);
                    if (zzc == null) {
                        zzf = zzab;
                        zza2 = zzcc;
                        zza = zznj;
                        bundle = zzcv;
                        bArr = null;
                        zzae zzae2 = new zzae(str, zzai2.name, 0, 0, zzai2.zzfu, 0, null, null, null, null);
                        zzae = zzae2;
                        j = 0;
                    } else {
                        zzf = zzab;
                        zza2 = zzcc;
                        zza = zznj;
                        bundle = zzcv;
                        bArr = null;
                        j = zzc.zzfj;
                        zzae = zzc.zzw(zzai2.zzfu);
                    }
                    zzgy().zza(zzae);
                    zzaf zzaf = new zzaf(this.zzj, zzai2.origin, str, zzai2.name, zzai2.zzfu, j, bundle);
                    zzc.zza zzah = zzc.zzmq().zzag(zzaf.timestamp).zzbx(zzaf.name).zzah(zzaf.zzfp);
                    Iterator it3 = zzaf.zzfq.iterator();
                    while (it3.hasNext()) {
                        String str4 = (String) it3.next();
                        zze.zza zzbz = zze.zzng().zzbz(str4);
                        zzgw().zza(zzbz, zzaf.zzfq.get(str4));
                        zzah.zza(zzbz);
                    }
                    zzg.zza zza3 = zza2;
                    zza3.zza(zzah).zza(zzh.zzpt().zza(zzd.zzms().zzak(zzae.zzfg).zzby(zzai2.name)));
                    zza3.zzc(zzgx().zza(zzf.zzag(), Collections.emptyList(), zza3.zzno()));
                    if (zzah.zzml()) {
                        zza3.zzao(zzah.getTimestampMillis()).zzap(zzah.getTimestampMillis());
                    }
                    long zzak = zzf.zzak();
                    if (zzak != 0) {
                        zza3.zzar(zzak);
                    }
                    long zzaj = zzf.zzaj();
                    if (zzaj != 0) {
                        zza3.zzaq(zzaj);
                    } else if (zzak != 0) {
                        zza3.zzaq(zzak);
                    }
                    zzf.zzau();
                    zza3.zzu((int) zzf.zzar()).zzat(zzad().zzao()).zzan(zzx().currentTimeMillis()).zzn(Boolean.TRUE.booleanValue());
                    zza zza4 = zza;
                    zza4.zza(zza3);
                    zzf zzf2 = zzf;
                    zzf2.zze(zza3.zznq());
                    zzf2.zzf(zza3.zznr());
                    zzgy().zza(zzf2);
                    zzgy().setTransactionSuccessful();
                    zzgy().endTransaction();
                    try {
                        return zzgw().zzc(((zzf) ((zzey) zza4.zzug())).toByteArray());
                    } catch (IOException e) {
                        zzab().zzgk().zza("Data loss. Failed to bundle and serialize. appId", zzef.zzam(str), e);
                        return bArr;
                    }
                } catch (SecurityException e2) {
                    zzab().zzgr().zza("app instance id encryption failed", e2.getMessage());
                    byte[] bArr3 = new byte[0];
                    zzgy().endTransaction();
                    return bArr3;
                }
            }
        } catch (SecurityException e3) {
            zzab().zzgr().zza("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzgy().endTransaction();
        }
    }

    private static String zzo(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
