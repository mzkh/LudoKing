package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzvk extends zzfm implements zzvl {
    public zzvk() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzvl zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzvl) {
            return (zzvl) queryLocalInterface;
        }
        return new zzvn(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzuy] */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.google.android.gms.internal.ads.zzva] */
    /* JADX WARNING: type inference failed for: r4v6, types: [com.google.android.gms.internal.ads.zzuy] */
    /* JADX WARNING: type inference failed for: r4v7, types: [com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzvv] */
    /* JADX WARNING: type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARNING: type inference failed for: r4v12, types: [com.google.android.gms.internal.ads.zzux] */
    /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.zzuz] */
    /* JADX WARNING: type inference failed for: r4v16, types: [com.google.android.gms.internal.ads.zzux] */
    /* JADX WARNING: type inference failed for: r4v17, types: [com.google.android.gms.internal.ads.zzvz] */
    /* JADX WARNING: type inference failed for: r4v19, types: [com.google.android.gms.internal.ads.zzvy] */
    /* JADX WARNING: type inference failed for: r4v21, types: [com.google.android.gms.internal.ads.zzvz] */
    /* JADX WARNING: type inference failed for: r4v22, types: [com.google.android.gms.internal.ads.zzvo] */
    /* JADX WARNING: type inference failed for: r4v24, types: [com.google.android.gms.internal.ads.zzvq] */
    /* JADX WARNING: type inference failed for: r4v26, types: [com.google.android.gms.internal.ads.zzvo] */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r4v28 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v1
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.ads.zzvv, com.google.android.gms.internal.ads.zzva, com.google.android.gms.internal.ads.zzuy, com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzuz, com.google.android.gms.internal.ads.zzux, com.google.android.gms.internal.ads.zzvy, com.google.android.gms.internal.ads.zzvz, com.google.android.gms.internal.ads.zzvq, com.google.android.gms.internal.ads.zzvo]
      uses: [com.google.android.gms.internal.ads.zzuy, com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzux, com.google.android.gms.internal.ads.zzvz, com.google.android.gms.internal.ads.zzvo]
      mth insns count: 173
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0229;
                case 2: goto L_0x0222;
                case 3: goto L_0x0217;
                case 4: goto L_0x0204;
                case 5: goto L_0x01fd;
                case 6: goto L_0x01f6;
                case 7: goto L_0x01d5;
                case 8: goto L_0x01b4;
                case 9: goto L_0x01ac;
                case 10: goto L_0x01a4;
                case 11: goto L_0x019c;
                case 12: goto L_0x0190;
                case 13: goto L_0x0180;
                case 14: goto L_0x0170;
                case 15: goto L_0x015c;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0150;
                case 19: goto L_0x0140;
                case 20: goto L_0x011e;
                case 21: goto L_0x00fc;
                case 22: goto L_0x00f0;
                case 23: goto L_0x00e4;
                case 24: goto L_0x00d4;
                case 25: goto L_0x00c8;
                case 26: goto L_0x00bc;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x00ac;
                case 30: goto L_0x009c;
                case 31: goto L_0x0090;
                case 32: goto L_0x0084;
                case 33: goto L_0x0078;
                case 34: goto L_0x006c;
                case 35: goto L_0x0060;
                case 36: goto L_0x003e;
                case 37: goto L_0x0032;
                case 38: goto L_0x0026;
                case 39: goto L_0x0016;
                case 40: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzqx r1 = com.google.android.gms.internal.ads.zzra.zzb(r1)
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0016:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzuf> r1 = com.google.android.gms.internal.ads.zzuf.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfp.zza(r2, r1)
            com.google.android.gms.internal.ads.zzuf r1 = (com.google.android.gms.internal.ads.zzuf) r1
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0026:
            java.lang.String r1 = r2.readString()
            r0.zzbm(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0032:
            android.os.Bundle r1 = r0.getAdMetadata()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r3, r1)
            goto L_0x0233
        L_0x003e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0045
            goto L_0x0058
        L_0x0045:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvo
            if (r4 == 0) goto L_0x0053
            r4 = r2
            com.google.android.gms.internal.ads.zzvo r4 = (com.google.android.gms.internal.ads.zzvo) r4
            goto L_0x0058
        L_0x0053:
            com.google.android.gms.internal.ads.zzvq r4 = new com.google.android.gms.internal.ads.zzvq
            r4.<init>(r1)
        L_0x0058:
            r0.zza(r4)
            r3.writeNoException()
            goto L_0x0233
        L_0x0060:
            java.lang.String r1 = r0.zzju()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0233
        L_0x006c:
            boolean r1 = com.google.android.gms.internal.ads.zzfp.zza(r2)
            r0.setImmersiveMode(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0078:
            com.google.android.gms.internal.ads.zzuy r1 = r0.zzjw()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r3, r1)
            goto L_0x0233
        L_0x0084:
            com.google.android.gms.internal.ads.zzvt r1 = r0.zzjv()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r3, r1)
            goto L_0x0233
        L_0x0090:
            java.lang.String r1 = r0.getAdUnitId()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0233
        L_0x009c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzwx> r1 = com.google.android.gms.internal.ads.zzwx.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfp.zza(r2, r1)
            com.google.android.gms.internal.ads.zzwx r1 = (com.google.android.gms.internal.ads.zzwx) r1
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x00ac:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyj> r1 = com.google.android.gms.internal.ads.zzyj.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfp.zza(r2, r1)
            com.google.android.gms.internal.ads.zzyj r1 = (com.google.android.gms.internal.ads.zzyj) r1
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x00bc:
            com.google.android.gms.internal.ads.zzwr r1 = r0.getVideoController()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r3, r1)
            goto L_0x0233
        L_0x00c8:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x00d4:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqi r1 = com.google.android.gms.internal.ads.zzaqh.zzaj(r1)
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x00e4:
            boolean r1 = r0.isLoading()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r3, r1)
            goto L_0x0233
        L_0x00f0:
            boolean r1 = com.google.android.gms.internal.ads.zzfp.zza(r2)
            r0.setManualImpressionsEnabled(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x00fc:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0103
            goto L_0x0116
        L_0x0103:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvz
            if (r4 == 0) goto L_0x0111
            r4 = r2
            com.google.android.gms.internal.ads.zzvz r4 = (com.google.android.gms.internal.ads.zzvz) r4
            goto L_0x0116
        L_0x0111:
            com.google.android.gms.internal.ads.zzvy r4 = new com.google.android.gms.internal.ads.zzvy
            r4.<init>(r1)
        L_0x0116:
            r0.zza(r4)
            r3.writeNoException()
            goto L_0x0233
        L_0x011e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0125
            goto L_0x0138
        L_0x0125:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzux
            if (r4 == 0) goto L_0x0133
            r4 = r2
            com.google.android.gms.internal.ads.zzux r4 = (com.google.android.gms.internal.ads.zzux) r4
            goto L_0x0138
        L_0x0133:
            com.google.android.gms.internal.ads.zzuz r4 = new com.google.android.gms.internal.ads.zzuz
            r4.<init>(r1)
        L_0x0138:
            r0.zza(r4)
            r3.writeNoException()
            goto L_0x0233
        L_0x0140:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaah r1 = com.google.android.gms.internal.ads.zzaag.zzk(r1)
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0150:
            java.lang.String r1 = r0.getMediationAdapterClassName()
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x0233
        L_0x015c:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzanz r1 = com.google.android.gms.internal.ads.zzaoc.zzah(r1)
            java.lang.String r2 = r2.readString()
            r0.zza(r1, r2)
            r3.writeNoException()
            goto L_0x0233
        L_0x0170:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzant r1 = com.google.android.gms.internal.ads.zzanw.zzaf(r1)
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0180:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzua> r1 = com.google.android.gms.internal.ads.zzua.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfp.zza(r2, r1)
            com.google.android.gms.internal.ads.zzua r1 = (com.google.android.gms.internal.ads.zzua) r1
            r0.zza(r1)
            r3.writeNoException()
            goto L_0x0233
        L_0x0190:
            com.google.android.gms.internal.ads.zzua r1 = r0.zzjt()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r3, r1)
            goto L_0x0233
        L_0x019c:
            r0.zzjs()
            r3.writeNoException()
            goto L_0x0233
        L_0x01a4:
            r0.stopLoading()
            r3.writeNoException()
            goto L_0x0233
        L_0x01ac:
            r0.showInterstitial()
            r3.writeNoException()
            goto L_0x0233
        L_0x01b4:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x01bb
            goto L_0x01ce
        L_0x01bb:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvt
            if (r4 == 0) goto L_0x01c9
            r4 = r2
            com.google.android.gms.internal.ads.zzvt r4 = (com.google.android.gms.internal.ads.zzvt) r4
            goto L_0x01ce
        L_0x01c9:
            com.google.android.gms.internal.ads.zzvv r4 = new com.google.android.gms.internal.ads.zzvv
            r4.<init>(r1)
        L_0x01ce:
            r0.zza(r4)
            r3.writeNoException()
            goto L_0x0233
        L_0x01d5:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x01dc
            goto L_0x01ef
        L_0x01dc:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzuy
            if (r4 == 0) goto L_0x01ea
            r4 = r2
            com.google.android.gms.internal.ads.zzuy r4 = (com.google.android.gms.internal.ads.zzuy) r4
            goto L_0x01ef
        L_0x01ea:
            com.google.android.gms.internal.ads.zzva r4 = new com.google.android.gms.internal.ads.zzva
            r4.<init>(r1)
        L_0x01ef:
            r0.zza(r4)
            r3.writeNoException()
            goto L_0x0233
        L_0x01f6:
            r0.resume()
            r3.writeNoException()
            goto L_0x0233
        L_0x01fd:
            r0.pause()
            r3.writeNoException()
            goto L_0x0233
        L_0x0204:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r1 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzfp.zza(r2, r1)
            com.google.android.gms.internal.ads.zztx r1 = (com.google.android.gms.internal.ads.zztx) r1
            boolean r1 = r0.zza(r1)
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r3, r1)
            goto L_0x0233
        L_0x0217:
            boolean r1 = r0.isReady()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r3, r1)
            goto L_0x0233
        L_0x0222:
            r0.destroy()
            r3.writeNoException()
            goto L_0x0233
        L_0x0229:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzjr()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r3, r1)
        L_0x0233:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvk.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
