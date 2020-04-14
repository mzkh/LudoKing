package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbkk {
    protected final zzcvz zzfbd;
    protected final zzcvr zzfet;
    private final zzbnl zzffg;
    private final zzbob zzffh;
    private final String zzffi;

    protected zzbkk(zzbkn zzbkn) {
        this.zzfbd = zzbkn.zzfbd;
        this.zzfet = zzbkn.zzfet;
        this.zzffg = zzbkn.zzffg;
        this.zzffh = zzbkn.zzffh;
        this.zzffi = zzbkn.zzffi;
    }

    public final zzbnl zzafm() {
        return this.zzffg;
    }

    public void zzafa() {
        this.zzffh.onAdLoaded();
    }

    public final String getMediationAdapterClassName() {
        return this.zzffi;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzju() {
        /*
            r2 = this;
            java.lang.String r0 = r2.zzffi
            java.lang.String r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r2.zzffi
            java.lang.String r1 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            if (r0 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzcvr r0 = r2.zzfet
            java.lang.String r0 = zzb(r0)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r2.zzffi
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkk.zzju():java.lang.String");
    }

    public void destroy() {
        this.zzffg.zzbw(null);
    }

    private static String zzb(zzcvr zzcvr) {
        try {
            return zzcvr.zzgjh.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }
}
