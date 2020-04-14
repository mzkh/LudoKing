package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcyp {
    private final Executor executor;
    private final String zzblz;
    private final Clock zzbmp;
    private final String zzcdr;
    private final String zzdix;
    private final zzcwc zzfgu;
    private final zzcjf zzfhu;
    private final zzaxm zzgmx;
    private final Context zzlk;

    public zzcyp(Executor executor2, zzaxm zzaxm, zzcjf zzcjf, zzaxl zzaxl, String str, String str2, Context context, @Nullable zzcwc zzcwc, Clock clock) {
        this.executor = executor2;
        this.zzgmx = zzaxm;
        this.zzfhu = zzcjf;
        this.zzblz = zzaxl.zzblz;
        this.zzdix = str;
        this.zzcdr = str2;
        this.zzlk = context;
        this.zzfgu = zzcwc;
        this.zzbmp = clock;
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, List<String> list) {
        zza(zzcvz, zzcvr, false, list);
    }

    public final void zza(zzcvz zzcvz, @Nullable zzcvr zzcvr, boolean z, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        for (String zzc : list) {
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adlocid@", zzcvz.zzgka.zzfga.zzgkh), "@gw_adnetrefresh@", str), "@gw_sdkver@", this.zzblz);
            if (zzcvr != null) {
                String str2 = "@gw_allocid@";
                zzc2 = zzate.zzd(zzc(zzc(zzc(zzc2, "@gw_qdata@", zzcvr.zzdce), "@gw_adnetid@", zzcvr.zzaex), str2, zzcvr.zzdcu), this.zzlk, zzcvr.zzdlr);
            }
            String str3 = "@gw_sessid@";
            arrayList.add(zzc(zzc(zzc(zzc2, "@gw_adnetstatus@", this.zzfhu.zzakw()), "@gw_seqnum@", this.zzdix), str3, this.zzcdr));
        }
        zzi(arrayList);
    }

    public final void zza(zzcvz zzcvz, zzcvr zzcvr, List<String> list, zzapy zzapy) {
        long currentTimeMillis = this.zzbmp.currentTimeMillis();
        try {
            String type = zzapy.getType();
            String num = Integer.toString(zzapy.getAmount());
            ArrayList arrayList = new ArrayList();
            zzcwc zzcwc = this.zzfgu;
            String str = "";
            String zzgj = zzcwc == null ? str : zzgj(zzcwc.zzdnz);
            zzcwc zzcwc2 = this.zzfgu;
            if (zzcwc2 != null) {
                str = zzgj(zzcwc2.zzdoa);
            }
            for (String zzc : list) {
                String str2 = "@gw_tmstmp@";
                String str3 = "@gw_rwd_itm@";
                String str4 = "@gw_sdkver@";
                arrayList.add(zzate.zzd(zzc(zzc(zzc(zzc(zzc(zzc(zzc, "@gw_rwd_userid@", Uri.encode(zzgj)), "@gw_rwd_custom_data@", Uri.encode(str)), str2, Long.toString(currentTimeMillis)), str3, Uri.encode(type)), "@gw_rwd_amt@", num), str4, this.zzblz), this.zzlk, zzcvr.zzdlr));
            }
            zzi(arrayList);
        } catch (RemoteException unused) {
        }
    }

    public final void zzi(List<String> list) {
        for (String zzei : list) {
            zzei(zzei);
        }
    }

    public final void zzei(String str) {
        this.executor.execute(new zzcys(this, str));
    }

    private static String zzc(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String zzgj(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzaxc.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzgk(String str) {
        this.zzgmx.zzei(str);
    }
}
