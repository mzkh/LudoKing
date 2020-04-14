package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzaqz extends zzfm implements zzara {
    public zzaqz() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzara zzam(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzara) {
            return (zzara) queryLocalInterface;
        }
        return new zzarc(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzari] */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzark] */
    /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzari] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzarb] */
    /* JADX WARNING: type inference failed for: r5v9, types: [com.google.android.gms.internal.ads.zzard] */
    /* JADX WARNING: type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzarb] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzarj] */
    /* JADX WARNING: type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzarm] */
    /* JADX WARNING: type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzarj] */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzard, com.google.android.gms.internal.ads.zzark, com.google.android.gms.internal.ads.zzari, com.google.android.gms.internal.ads.zzarb, com.google.android.gms.internal.ads.zzarm, com.google.android.gms.internal.ads.zzarj]
      uses: [com.google.android.gms.internal.ads.zzari, com.google.android.gms.internal.ads.zzarb, com.google.android.gms.internal.ads.zzarj]
      mth insns count: 75
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x00ba;
                case 2: goto L_0x0099;
                case 3: goto L_0x008e;
                case 4: goto L_0x0083;
                case 5: goto L_0x0074;
                case 6: goto L_0x0052;
                case 7: goto L_0x0042;
                case 8: goto L_0x0032;
                case 9: goto L_0x0026;
                case 10: goto L_0x0012;
                case 11: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            com.google.android.gms.internal.ads.zzaqv r2 = r1.zzpk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r4, r2)
            goto L_0x00e1
        L_0x0012:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            boolean r3 = com.google.android.gms.internal.ads.zzfp.zza(r3)
            r1.zza(r2, r3)
            r4.writeNoException()
            goto L_0x00e1
        L_0x0026:
            android.os.Bundle r2 = r1.getAdMetadata()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r4, r2)
            goto L_0x00e1
        L_0x0032:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzwm r2 = com.google.android.gms.internal.ads.zzwp.zzh(r2)
            r1.zza(r2)
            r4.writeNoException()
            goto L_0x00e1
        L_0x0042:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarr> r2 = com.google.android.gms.internal.ads.zzarr.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzfp.zza(r3, r2)
            com.google.android.gms.internal.ads.zzarr r2 = (com.google.android.gms.internal.ads.zzarr) r2
            r1.zza(r2)
            r4.writeNoException()
            goto L_0x00e1
        L_0x0052:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0059
            goto L_0x006c
        L_0x0059:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzarj
            if (r5 == 0) goto L_0x0067
            r5 = r3
            com.google.android.gms.internal.ads.zzarj r5 = (com.google.android.gms.internal.ads.zzarj) r5
            goto L_0x006c
        L_0x0067:
            com.google.android.gms.internal.ads.zzarm r5 = new com.google.android.gms.internal.ads.zzarm
            r5.<init>(r2)
        L_0x006c:
            r1.zza(r5)
            r4.writeNoException()
            goto L_0x00e1
        L_0x0074:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzl(r2)
            r4.writeNoException()
            goto L_0x00e1
        L_0x0083:
            java.lang.String r2 = r1.getMediationAdapterClassName()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x00e1
        L_0x008e:
            boolean r2 = r1.isLoaded()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r4, r2)
            goto L_0x00e1
        L_0x0099:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00a0
            goto L_0x00b3
        L_0x00a0:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzarb
            if (r5 == 0) goto L_0x00ae
            r5 = r3
            com.google.android.gms.internal.ads.zzarb r5 = (com.google.android.gms.internal.ads.zzarb) r5
            goto L_0x00b3
        L_0x00ae:
            com.google.android.gms.internal.ads.zzard r5 = new com.google.android.gms.internal.ads.zzard
            r5.<init>(r2)
        L_0x00b3:
            r1.zza(r5)
            r4.writeNoException()
            goto L_0x00e1
        L_0x00ba:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r2 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzfp.zza(r3, r2)
            com.google.android.gms.internal.ads.zztx r2 = (com.google.android.gms.internal.ads.zztx) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00c9
            goto L_0x00db
        L_0x00c9:
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzari
            if (r0 == 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzari r5 = (com.google.android.gms.internal.ads.zzari) r5
            goto L_0x00db
        L_0x00d6:
            com.google.android.gms.internal.ads.zzark r5 = new com.google.android.gms.internal.ads.zzark
            r5.<init>(r3)
        L_0x00db:
            r1.zza(r2, r5)
            r4.writeNoException()
        L_0x00e1:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqz.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
