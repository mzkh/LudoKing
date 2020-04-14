package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzacb extends NativeAppInstallAd {
    private final VideoController zzcen = new VideoController();
    private final zzabw zzcwf;
    private final List<Image> zzcwg = new ArrayList();
    private final zzabn zzcwh;
    private final AdChoicesInfo zzcwi;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ RemoteException -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[Catch:{ RemoteException -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0022 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzacb(com.google.android.gms.internal.ads.zzabw r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzcwg = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcen = r1
            r5.zzcwf = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzabw r1 = r5.zzcwf     // Catch:{ RemoteException -> 0x0057 }
            java.util.List r1 = r1.getImages()     // Catch:{ RemoteException -> 0x0057 }
            if (r1 == 0) goto L_0x005b
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0057 }
        L_0x0022:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0057 }
            if (r2 == 0) goto L_0x005b
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0057 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0057 }
            if (r3 == 0) goto L_0x0049
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0057 }
            if (r2 == 0) goto L_0x0049
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x0057 }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzabi     // Catch:{ RemoteException -> 0x0057 }
            if (r4 == 0) goto L_0x0042
            r2 = r3
            com.google.android.gms.internal.ads.zzabi r2 = (com.google.android.gms.internal.ads.zzabi) r2     // Catch:{ RemoteException -> 0x0057 }
            goto L_0x004a
        L_0x0042:
            com.google.android.gms.internal.ads.zzabk r3 = new com.google.android.gms.internal.ads.zzabk     // Catch:{ RemoteException -> 0x0057 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0057 }
            r2 = r3
            goto L_0x004a
        L_0x0049:
            r2 = r6
        L_0x004a:
            if (r2 == 0) goto L_0x0022
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.zzcwg     // Catch:{ RemoteException -> 0x0057 }
            com.google.android.gms.internal.ads.zzabn r4 = new com.google.android.gms.internal.ads.zzabn     // Catch:{ RemoteException -> 0x0057 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0057 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0057 }
            goto L_0x0022
        L_0x0057:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x005b:
            com.google.android.gms.internal.ads.zzabw r1 = r5.zzcwf     // Catch:{ RemoteException -> 0x0069 }
            com.google.android.gms.internal.ads.zzabi r1 = r1.zzqn()     // Catch:{ RemoteException -> 0x0069 }
            if (r1 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzabn r2 = new com.google.android.gms.internal.ads.zzabn     // Catch:{ RemoteException -> 0x0069 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0069 }
            goto L_0x006e
        L_0x0069:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x006d:
            r2 = r6
        L_0x006e:
            r5.zzcwh = r2
            com.google.android.gms.internal.ads.zzabw r1 = r5.zzcwf     // Catch:{ RemoteException -> 0x0085 }
            com.google.android.gms.internal.ads.zzaba r1 = r1.zzqo()     // Catch:{ RemoteException -> 0x0085 }
            if (r1 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzabf r1 = new com.google.android.gms.internal.ads.zzabf     // Catch:{ RemoteException -> 0x0085 }
            com.google.android.gms.internal.ads.zzabw r2 = r5.zzcwf     // Catch:{ RemoteException -> 0x0085 }
            com.google.android.gms.internal.ads.zzaba r2 = r2.zzqo()     // Catch:{ RemoteException -> 0x0085 }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x0085 }
            r6 = r1
            goto L_0x0089
        L_0x0085:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x0089:
            r5.zzcwi = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacb.<init>(com.google.android.gms.internal.ads.zzabw):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzqm */
    public final IObjectWrapper zzjd() {
        try {
            return this.zzcwf.zzqm();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzcwf.performClick(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcwf.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcwf.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzcwf.getHeadline();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final List<Image> getImages() {
        return this.zzcwg;
    }

    public final CharSequence getBody() {
        try {
            return this.zzcwf.getBody();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Image getIcon() {
        return this.zzcwh;
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzcwf.getCallToAction();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzcwf.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final CharSequence getStore() {
        try {
            return this.zzcwf.getStore();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final CharSequence getPrice() {
        try {
            return this.zzcwf.getPrice();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzcwf.getVideoController() != null) {
                this.zzcen.zza(this.zzcwf.getVideoController());
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcen;
    }

    public final AdChoicesInfo getAdChoicesInfo() {
        return this.zzcwi;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzcwf.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzcwf.getExtras();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzcwf.destroy();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
