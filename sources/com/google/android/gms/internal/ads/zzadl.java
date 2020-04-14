package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.MediaContent;
import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzadl extends UnifiedNativeAd {
    private final VideoController zzcen = new VideoController();
    private final List<Image> zzcwg = new ArrayList();
    private final zzabn zzcwh;
    private final AdChoicesInfo zzcwi;
    private final zzadg zzcwq;
    private final List<MuteThisAdReason> zzcwr = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[Catch:{ RemoteException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2 A[Catch:{ RemoteException -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzadl(com.google.android.gms.internal.ads.zzadg r6) {
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
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzcwr = r1
            r5.zzcwq = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzadg r1 = r5.zzcwq     // Catch:{ RemoteException -> 0x005e }
            java.util.List r1 = r1.getImages()     // Catch:{ RemoteException -> 0x005e }
            if (r1 == 0) goto L_0x0062
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x005e }
        L_0x0029:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x005e }
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x005e }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005e }
            if (r3 == 0) goto L_0x0050
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005e }
            if (r2 == 0) goto L_0x0050
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005e }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzabi     // Catch:{ RemoteException -> 0x005e }
            if (r4 == 0) goto L_0x0049
            r2 = r3
            com.google.android.gms.internal.ads.zzabi r2 = (com.google.android.gms.internal.ads.zzabi) r2     // Catch:{ RemoteException -> 0x005e }
            goto L_0x0051
        L_0x0049:
            com.google.android.gms.internal.ads.zzabk r3 = new com.google.android.gms.internal.ads.zzabk     // Catch:{ RemoteException -> 0x005e }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005e }
            r2 = r3
            goto L_0x0051
        L_0x0050:
            r2 = r6
        L_0x0051:
            if (r2 == 0) goto L_0x0029
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.zzcwg     // Catch:{ RemoteException -> 0x005e }
            com.google.android.gms.internal.ads.zzabn r4 = new com.google.android.gms.internal.ads.zzabn     // Catch:{ RemoteException -> 0x005e }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x005e }
            r3.add(r4)     // Catch:{ RemoteException -> 0x005e }
            goto L_0x0029
        L_0x005e:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x0062:
            com.google.android.gms.internal.ads.zzadg r1 = r5.zzcwq     // Catch:{ RemoteException -> 0x0091 }
            java.util.List r1 = r1.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x0091 }
            if (r1 == 0) goto L_0x0095
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RemoteException -> 0x0091 }
        L_0x006e:
            boolean r2 = r1.hasNext()     // Catch:{ RemoteException -> 0x0091 }
            if (r2 == 0) goto L_0x0095
            java.lang.Object r2 = r1.next()     // Catch:{ RemoteException -> 0x0091 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0091 }
            if (r3 == 0) goto L_0x0083
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzwi r2 = com.google.android.gms.internal.ads.zzwl.zzg(r2)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x0084
        L_0x0083:
            r2 = r6
        L_0x0084:
            if (r2 == 0) goto L_0x006e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzcwr     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzwn r4 = new com.google.android.gms.internal.ads.zzwn     // Catch:{ RemoteException -> 0x0091 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0091 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x006e
        L_0x0091:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x0095:
            com.google.android.gms.internal.ads.zzadg r1 = r5.zzcwq     // Catch:{ RemoteException -> 0x00a3 }
            com.google.android.gms.internal.ads.zzabi r1 = r1.zzqn()     // Catch:{ RemoteException -> 0x00a3 }
            if (r1 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzabn r2 = new com.google.android.gms.internal.ads.zzabn     // Catch:{ RemoteException -> 0x00a3 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x00a3 }
            goto L_0x00a8
        L_0x00a3:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x00a7:
            r2 = r6
        L_0x00a8:
            r5.zzcwh = r2
            com.google.android.gms.internal.ads.zzadg r1 = r5.zzcwq     // Catch:{ RemoteException -> 0x00bf }
            com.google.android.gms.internal.ads.zzaba r1 = r1.zzqo()     // Catch:{ RemoteException -> 0x00bf }
            if (r1 == 0) goto L_0x00c3
            com.google.android.gms.internal.ads.zzabf r1 = new com.google.android.gms.internal.ads.zzabf     // Catch:{ RemoteException -> 0x00bf }
            com.google.android.gms.internal.ads.zzadg r2 = r5.zzcwq     // Catch:{ RemoteException -> 0x00bf }
            com.google.android.gms.internal.ads.zzaba r2 = r2.zzqo()     // Catch:{ RemoteException -> 0x00bf }
            r1.<init>(r2)     // Catch:{ RemoteException -> 0x00bf }
            r6 = r1
            goto L_0x00c3
        L_0x00bf:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzaxi.zzc(r0, r1)
        L_0x00c3:
            r5.zzcwi = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadl.<init>(com.google.android.gms.internal.ads.zzadg):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzqm */
    public final IObjectWrapper zzjd() {
        try {
            return this.zzcwq.zzqm();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Object zzji() {
        try {
            IObjectWrapper zzqp = this.zzcwq.zzqp();
            if (zzqp != null) {
                return ObjectWrapper.unwrap(zzqp);
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return null;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzcwq.performClick(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcwq.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcwq.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final String getHeadline() {
        try {
            return this.zzcwq.getHeadline();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final List<Image> getImages() {
        return this.zzcwg;
    }

    public final String getBody() {
        try {
            return this.zzcwq.getBody();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Image getIcon() {
        return this.zzcwh;
    }

    public final String getCallToAction() {
        try {
            return this.zzcwq.getCallToAction();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzcwq.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zzcwq.getStore();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final String getPrice() {
        try {
            return this.zzcwq.getPrice();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzcwq.getVideoController() != null) {
                this.zzcen.zza(this.zzcwq.getVideoController());
            }
        } catch (RemoteException e) {
            zzaxi.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcen;
    }

    public final AdChoicesInfo getAdChoicesInfo() {
        return this.zzcwi;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzcwq.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzcwq.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return new Bundle();
    }

    public final void enableCustomClickGesture() {
        try {
            this.zzcwq.zzqw();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzcwq.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return false;
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zzcwq.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzcwr;
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzcwq.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return false;
        }
    }

    public final void destroy() {
        try {
            this.zzcwq.destroy();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void setUnconfirmedClickListener(UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzcwq.zza((zzadf) new zzadu(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzaxi.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzaxi.zzes("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzcwq.zza((zzwi) null);
            } else if (muteThisAdReason instanceof zzwn) {
                this.zzcwq.zza(((zzwn) muteThisAdReason).zzow());
            } else {
                zzaxi.zzes("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzcwq.zza((zzwe) new zzwj(muteThisAdListener));
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zzcwq.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzaxi.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final String getAdvertiser() {
        try {
            return this.zzcwq.getAdvertiser();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zzcwq.zzqx() != null) {
                return new zzadk(this.zzcwq.zzqx());
            }
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
        return null;
    }
}
