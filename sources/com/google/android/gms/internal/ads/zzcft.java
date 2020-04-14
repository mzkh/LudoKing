package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsp.zzh;
import com.google.android.gms.internal.ads.zzsp.zzh.zza;
import com.google.android.gms.internal.ads.zzsp.zzh.zzb;
import com.google.android.gms.internal.ads.zzsp.zzj;
import com.google.android.gms.internal.ads.zzsp.zzj.zza.C3518zza;
import com.google.android.gms.internal.ads.zzsp.zzj.zzc;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcft {
    private static final SparseArray<zzc> zzfwu;
    private final zzcfp zzfuq;
    private final zzddi<Bundle> zzfwq;
    private final TelephonyManager zzfwr;
    /* access modifiers changed from: private */
    public final zzcfj zzfws;
    private zzsv zzfwt;
    private final Context zzlk;

    zzcft(Context context, zzddi<Bundle> zzddi, zzcfp zzcfp, zzcfj zzcfj) {
        this.zzlk = context;
        this.zzfwq = zzddi;
        this.zzfuq = zzcfp;
        this.zzfws = zzcfj;
        this.zzfwr = (TelephonyManager) context.getSystemService("phone");
    }

    private static zzsv zzba(boolean z) {
        return z ? zzsv.ENUM_TRUE : zzsv.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zzh zzj(Bundle bundle) {
        zza zza;
        zzb zzna = zzh.zzna();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzfwt = zzsv.ENUM_TRUE;
        } else {
            this.zzfwt = zzsv.ENUM_FALSE;
            if (i == 0) {
                zzna.zzb(zzh.zzc.CELL);
            } else if (i != 1) {
                zzna.zzb(zzh.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzna.zzb(zzh.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zza = zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zza = zza.THREE_G;
                    break;
                case 13:
                    zza = zza.LTE;
                    break;
                default:
                    zza = zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzna.zzb(zza);
        }
        return (zzh) ((zzdqw) zzna.zzazr());
    }

    /* access modifiers changed from: private */
    public static zzc zzk(Bundle bundle) {
        return (zzc) zzfwu.get(zzcwk.zza(zzcwk.zza(bundle, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX), "network").getInt("active_network_state", -1), zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzsp.zzb.zza> zzl(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r7 = (java.util.List) r7
            goto L_0x0017
        L_0x000d:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0024:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r7 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x004a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0080;
                case -1052618729: goto L_0x0076;
                case -239580146: goto L_0x006c;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0089
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 1
            goto L_0x0089
        L_0x006c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 3
            goto L_0x0089
        L_0x0076:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 2
            goto L_0x0089
        L_0x0080:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 0
        L_0x0089:
            if (r2 == 0) goto L_0x009d
            if (r2 == r6) goto L_0x009a
            if (r2 == r5) goto L_0x0097
            if (r2 == r4) goto L_0x0094
            com.google.android.gms.internal.ads.zzsp$zzb$zza r1 = com.google.android.gms.internal.ads.zzsp.zzb.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009f
        L_0x0094:
            com.google.android.gms.internal.ads.zzsp$zzb$zza r1 = com.google.android.gms.internal.ads.zzsp.zzb.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009f
        L_0x0097:
            com.google.android.gms.internal.ads.zzsp$zzb$zza r1 = com.google.android.gms.internal.ads.zzsp.zzb.zza.NATIVE_APP_INSTALL
            goto L_0x009f
        L_0x009a:
            com.google.android.gms.internal.ads.zzsp$zzb$zza r1 = com.google.android.gms.internal.ads.zzsp.zzb.zza.INTERSTITIAL
            goto L_0x009f
        L_0x009d:
            com.google.android.gms.internal.ads.zzsp$zzb$zza r1 = com.google.android.gms.internal.ads.zzsp.zzb.zza.BANNER
        L_0x009f:
            r0.add(r1)
            goto L_0x004a
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcft.zzl(android.os.Bundle):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzsp.zzb.zza> arrayList, zzh zzh, zzc zzc) {
        boolean z2 = true;
        C3518zza zzeo = zzj.zza.zzng().zzd(arrayList).zzh(zzba(zzq.zzkl().zzb(this.zzlk.getContentResolver()) != 0)).zzi(zzq.zzkl().zza(this.zzlk, this.zzfwr)).zzep(this.zzfuq.zzako()).zzeq(this.zzfuq.zzakq()).zzcb(this.zzfuq.getResponseCode()).zzb(zzc).zzb(zzh).zzj(this.zzfwt).zzf(zzba(z)).zzeo(zzq.zzkq().currentTimeMillis());
        if (zzq.zzkl().zza(this.zzlk.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzj.zza) ((zzdqw) zzeo.zzg(zzba(z2)).zzazr())).toByteArray();
    }

    public final void zzbb(boolean z) {
        zzdcy.zza(this.zzfwq, new zzcfs(this, z), zzaxn.zzdwn);
    }

    static {
        SparseArray<zzc> sparseArray = new SparseArray<>();
        zzfwu = sparseArray;
        sparseArray.put(DetailedState.CONNECTED.ordinal(), zzc.CONNECTED);
        zzfwu.put(DetailedState.AUTHENTICATING.ordinal(), zzc.CONNECTING);
        zzfwu.put(DetailedState.CONNECTING.ordinal(), zzc.CONNECTING);
        zzfwu.put(DetailedState.OBTAINING_IPADDR.ordinal(), zzc.CONNECTING);
        zzfwu.put(DetailedState.DISCONNECTING.ordinal(), zzc.DISCONNECTING);
        zzfwu.put(DetailedState.BLOCKED.ordinal(), zzc.DISCONNECTED);
        zzfwu.put(DetailedState.DISCONNECTED.ordinal(), zzc.DISCONNECTED);
        zzfwu.put(DetailedState.FAILED.ordinal(), zzc.DISCONNECTED);
        zzfwu.put(DetailedState.IDLE.ordinal(), zzc.DISCONNECTED);
        zzfwu.put(DetailedState.SCANNING.ordinal(), zzc.DISCONNECTED);
        zzfwu.put(DetailedState.SUSPENDED.ordinal(), zzc.SUSPENDED);
        if (VERSION.SDK_INT >= 17) {
            zzfwu.put(DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzc.CONNECTING);
        }
        if (VERSION.SDK_INT >= 16) {
            zzfwu.put(DetailedState.VERIFYING_POOR_LINK.ordinal(), zzc.CONNECTING);
        }
    }
}
