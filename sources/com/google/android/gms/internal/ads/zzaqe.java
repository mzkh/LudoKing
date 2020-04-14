package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzaqe extends zzfm implements zzaqb {
    public zzaqe() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzaqb zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzaqb) {
            return (zzaqb) queryLocalInterface;
        }
        return new zzaqd(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzaqi] */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.google.android.gms.internal.ads.zzaqk] */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.internal.ads.zzaqi] */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.internal.ads.zzapz] */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.internal.ads.zzaqc] */
    /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzapz] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzaqc, com.google.android.gms.internal.ads.zzaqk, com.google.android.gms.internal.ads.zzaqi, com.google.android.gms.internal.ads.zzapz]
      uses: [com.google.android.gms.internal.ads.zzaqi, com.google.android.gms.internal.ads.zzapz]
      mth insns count: 91
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
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x011f
            r0 = 2
            if (r3 == r0) goto L_0x0118
            r0 = 3
            r1 = 0
            if (r3 == r0) goto L_0x00f7
            r0 = 34
            if (r3 == r0) goto L_0x00ec
            switch(r3) {
                case 5: goto L_0x00e1;
                case 6: goto L_0x00da;
                case 7: goto L_0x00d3;
                case 8: goto L_0x00cc;
                case 9: goto L_0x00bd;
                case 10: goto L_0x00ad;
                case 11: goto L_0x009d;
                case 12: goto L_0x0091;
                case 13: goto L_0x0085;
                case 14: goto L_0x0075;
                case 15: goto L_0x0069;
                case 16: goto L_0x0047;
                case 17: goto L_0x003b;
                case 18: goto L_0x002b;
                case 19: goto L_0x001f;
                case 20: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            return r3
        L_0x0013:
            boolean r3 = r2.zzpl()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r5, r3)
            goto L_0x012d
        L_0x001f:
            java.lang.String r3 = r4.readString()
            r2.setCustomData(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x002b:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzm(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x003b:
            java.lang.String r3 = r4.readString()
            r2.setAppPackageName(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x0047:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzapz
            if (r0 == 0) goto L_0x005c
            r1 = r4
            com.google.android.gms.internal.ads.zzapz r1 = (com.google.android.gms.internal.ads.zzapz) r1
            goto L_0x0061
        L_0x005c:
            com.google.android.gms.internal.ads.zzaqc r1 = new com.google.android.gms.internal.ads.zzaqc
            r1.<init>(r3)
        L_0x0061:
            r2.zza(r1)
            r5.writeNoException()
            goto L_0x012d
        L_0x0069:
            android.os.Bundle r3 = r2.getAdMetadata()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r5, r3)
            goto L_0x012d
        L_0x0075:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzvo r3 = com.google.android.gms.internal.ads.zzvr.zzd(r3)
            r2.zza(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x0085:
            java.lang.String r3 = r4.readString()
            r2.setUserId(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x0091:
            java.lang.String r3 = r2.getMediationAdapterClassName()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x012d
        L_0x009d:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzp(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x00ad:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzo(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x00bd:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzn(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x00cc:
            r2.destroy()
            r5.writeNoException()
            goto L_0x012d
        L_0x00d3:
            r2.resume()
            r5.writeNoException()
            goto L_0x012d
        L_0x00da:
            r2.pause()
            r5.writeNoException()
            goto L_0x012d
        L_0x00e1:
            boolean r3 = r2.isLoaded()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r5, r3)
            goto L_0x012d
        L_0x00ec:
            boolean r3 = com.google.android.gms.internal.ads.zzfp.zza(r4)
            r2.setImmersiveMode(r3)
            r5.writeNoException()
            goto L_0x012d
        L_0x00f7:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00fe
            goto L_0x0111
        L_0x00fe:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzaqi
            if (r0 == 0) goto L_0x010c
            r1 = r4
            com.google.android.gms.internal.ads.zzaqi r1 = (com.google.android.gms.internal.ads.zzaqi) r1
            goto L_0x0111
        L_0x010c:
            com.google.android.gms.internal.ads.zzaqk r1 = new com.google.android.gms.internal.ads.zzaqk
            r1.<init>(r3)
        L_0x0111:
            r2.zza(r1)
            r5.writeNoException()
            goto L_0x012d
        L_0x0118:
            r2.show()
            r5.writeNoException()
            goto L_0x012d
        L_0x011f:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaqo> r3 = com.google.android.gms.internal.ads.zzaqo.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzfp.zza(r4, r3)
            com.google.android.gms.internal.ads.zzaqo r3 = (com.google.android.gms.internal.ads.zzaqo) r3
            r2.zza(r3)
            r5.writeNoException()
        L_0x012d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqe.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
