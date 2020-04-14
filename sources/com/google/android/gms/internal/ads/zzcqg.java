package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqg implements zzcru<zzcqd> {
    private final PackageInfo zzdiv;
    private final zzaui zzdrp;
    private final zzcwe zzfga;
    private final zzddl zzfoa;

    public zzcqg(zzddl zzddl, zzcwe zzcwe, @Nullable PackageInfo packageInfo, zzaui zzaui) {
        this.zzfoa = zzddl;
        this.zzfga = zzcwe;
        this.zzdiv = packageInfo;
        this.zzdrp = zzaui;
    }

    public final zzddi<zzcqd> zzalv() {
        return this.zzfoa.zzd(new zzcqf(this));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r8, android.os.Bundle r9) {
        /*
            r7 = this;
            r0 = 3
            java.lang.String r1 = "native_version"
            r9.putInt(r1, r0)
            java.lang.String r1 = "native_templates"
            r9.putStringArrayList(r1, r8)
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            java.util.ArrayList<java.lang.String> r8 = r8.zzgkj
            java.lang.String r1 = "native_custom_templates"
            r9.putStringArrayList(r1, r8)
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzza.zzcog
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r8 = r1.zzd(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.String r1 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            r4 = 2
            java.lang.String r5 = "unknown"
            r6 = 1
            if (r8 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzaay r8 = r8.zzdeh
            int r8 = r8.versionCode
            if (r8 <= r0) goto L_0x0061
            java.lang.String r8 = "enable_native_media_orientation"
            r9.putBoolean(r8, r6)
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzaay r8 = r8.zzdeh
            int r8 = r8.zzbjw
            if (r8 == r6) goto L_0x0055
            if (r8 == r4) goto L_0x0053
            if (r8 == r0) goto L_0x0051
            r0 = 4
            if (r8 == r0) goto L_0x004e
            r8 = r5
            goto L_0x0056
        L_0x004e:
            java.lang.String r8 = "square"
            goto L_0x0056
        L_0x0051:
            r8 = r2
            goto L_0x0056
        L_0x0053:
            r8 = r1
            goto L_0x0056
        L_0x0055:
            r8 = r3
        L_0x0056:
            boolean r0 = r5.equals(r8)
            if (r0 != 0) goto L_0x0061
            java.lang.String r0 = "native_media_orientation"
            r9.putString(r0, r8)
        L_0x0061:
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzaay r8 = r8.zzdeh
            int r8 = r8.zzbjv
            if (r8 == 0) goto L_0x0071
            if (r8 == r6) goto L_0x006f
            if (r8 == r4) goto L_0x0072
            r1 = r5
            goto L_0x0072
        L_0x006f:
            r1 = r2
            goto L_0x0072
        L_0x0071:
            r1 = r3
        L_0x0072:
            boolean r8 = r5.equals(r1)
            if (r8 != 0) goto L_0x007d
            java.lang.String r8 = "native_image_orientation"
            r9.putString(r8, r1)
        L_0x007d:
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzaay r8 = r8.zzdeh
            boolean r8 = r8.zzbjx
            java.lang.String r0 = "native_multiple_images"
            r9.putBoolean(r0, r8)
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzaay r8 = r8.zzdeh
            boolean r8 = r8.zzbka
            java.lang.String r0 = "use_custom_mute"
            r9.putBoolean(r0, r8)
            android.content.pm.PackageInfo r8 = r7.zzdiv
            if (r8 != 0) goto L_0x0099
            r8 = 0
            goto L_0x009b
        L_0x0099:
            int r8 = r8.versionCode
        L_0x009b:
            com.google.android.gms.internal.ads.zzaui r0 = r7.zzdrp
            int r0 = r0.zzvd()
            if (r8 <= r0) goto L_0x00ad
            com.google.android.gms.internal.ads.zzaui r0 = r7.zzdrp
            r0.zzvj()
            com.google.android.gms.internal.ads.zzaui r0 = r7.zzdrp
            r0.zzcm(r8)
        L_0x00ad:
            com.google.android.gms.internal.ads.zzaui r8 = r7.zzdrp
            org.json.JSONObject r8 = r8.zzvi()
            if (r8 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzcwe r0 = r7.zzfga
            java.lang.String r0 = r0.zzgkh
            org.json.JSONArray r8 = r8.optJSONArray(r0)
            if (r8 == 0) goto L_0x00c4
            java.lang.String r8 = r8.toString()
            goto L_0x00c5
        L_0x00c4:
            r8 = 0
        L_0x00c5:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "native_advanced_settings"
            r9.putString(r0, r8)
        L_0x00d0:
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            int r8 = r8.zzgdf
            if (r8 <= r6) goto L_0x00df
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            int r8 = r8.zzgdf
            java.lang.String r0 = "max_num_ads"
            r9.putInt(r0, r8)
        L_0x00df:
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzagd r8 = r8.zzdkl
            if (r8 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzagd r8 = r8.zzdkl
            int r0 = r8.zzcyt
            java.lang.String r1 = "l"
            if (r0 == r6) goto L_0x0111
            if (r0 == r4) goto L_0x010f
            int r8 = r8.zzcyt
            r0 = 52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Instream ad video aspect ratio "
            r2.append(r0)
            r2.append(r8)
            java.lang.String r8 = " is wrong."
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.google.android.gms.internal.ads.zzaxi.zzes(r8)
            goto L_0x0111
        L_0x010f:
            java.lang.String r1 = "p"
        L_0x0111:
            java.lang.String r8 = "ia_var"
            r9.putString(r8, r1)
            java.lang.String r8 = "instr"
            r9.putBoolean(r8, r6)
        L_0x011b:
            com.google.android.gms.internal.ads.zzcwe r8 = r7.zzfga
            com.google.android.gms.internal.ads.zzada r8 = r8.zzana()
            if (r8 == 0) goto L_0x0128
            java.lang.String r8 = "has_delayed_banner_listener"
            r9.putBoolean(r8, r6)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqg.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcqd zzamc() throws Exception {
        ArrayList<String> arrayList = this.zzfga.zzgki;
        if (arrayList == null) {
            return zzcqi.zzgfk;
        }
        if (arrayList.isEmpty()) {
            return zzcqh.zzgfk;
        }
        return new zzcqk(this, arrayList);
    }
}
