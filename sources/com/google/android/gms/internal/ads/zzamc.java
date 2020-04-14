package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzamc extends zzfm implements zzamd {
    public zzamc() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzamd zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzamd) {
            return (zzamd) queryLocalInterface;
        }
        return new zzamf(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v6, types: [com.google.android.gms.internal.ads.zzalt] */
    /* JADX WARNING: type inference failed for: r2v7, types: [com.google.android.gms.internal.ads.zzalr] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzalr] */
    /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.ads.zzalu] */
    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzals] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r5v8, types: [com.google.android.gms.internal.ads.zzals] */
    /* JADX WARNING: type inference failed for: r2v18, types: [com.google.android.gms.internal.ads.zzama] */
    /* JADX WARNING: type inference failed for: r2v19, types: [com.google.android.gms.internal.ads.zzaly] */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r5v11, types: [com.google.android.gms.internal.ads.zzaly] */
    /* JADX WARNING: type inference failed for: r2v24, types: [com.google.android.gms.internal.ads.zzalz] */
    /* JADX WARNING: type inference failed for: r2v25, types: [com.google.android.gms.internal.ads.zzalx] */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzalx] */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: type inference failed for: r2v34 */
    /* JADX WARNING: type inference failed for: r2v35 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 17 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r14, android.os.Parcel r15, android.os.Parcel r16, int r17) throws android.os.RemoteException {
        /*
            r13 = this;
            r8 = r13
            r0 = r14
            r1 = r15
            r9 = r16
            r10 = 1
            r2 = 0
            if (r0 == r10) goto L_0x01cf
            r3 = 2
            if (r0 == r3) goto L_0x01c4
            r3 = 3
            if (r0 == r3) goto L_0x01b9
            r3 = 5
            if (r0 == r3) goto L_0x01ad
            r3 = 10
            if (r0 == r3) goto L_0x019d
            r3 = 11
            if (r0 == r3) goto L_0x0189
            switch(r0) {
                case 13: goto L_0x0134;
                case 14: goto L_0x00e9;
                case 15: goto L_0x00d5;
                case 16: goto L_0x008a;
                case 17: goto L_0x0076;
                case 18: goto L_0x002b;
                case 19: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            r0 = 0
            return r0
        L_0x001f:
            java.lang.String r0 = r15.readString()
            r13.zzdh(r0)
            r16.writeNoException()
            goto L_0x021e
        L_0x002b:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r0 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zztx r5 = (com.google.android.gms.internal.ads.zztx) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x004c
        L_0x004a:
            r7 = r2
            goto L_0x005f
        L_0x004c:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzalx
            if (r7 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzalx r2 = (com.google.android.gms.internal.ads.zzalx) r2
            goto L_0x004a
        L_0x0059:
            com.google.android.gms.internal.ads.zzalz r2 = new com.google.android.gms.internal.ads.zzalz
            r2.<init>(r0)
            goto L_0x004a
        L_0x005f:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzakd r11 = com.google.android.gms.internal.ads.zzakc.zzab(r0)
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza(r1, r2, r3, r4, r5, r6)
            r16.writeNoException()
            goto L_0x021e
        L_0x0076:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r13.zzad(r0)
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r9, r0)
            goto L_0x021e
        L_0x008a:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r0 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zztx r5 = (com.google.android.gms.internal.ads.zztx) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x00ab
        L_0x00a9:
            r7 = r2
            goto L_0x00be
        L_0x00ab:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzaly
            if (r7 == 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzaly r2 = (com.google.android.gms.internal.ads.zzaly) r2
            goto L_0x00a9
        L_0x00b8:
            com.google.android.gms.internal.ads.zzama r2 = new com.google.android.gms.internal.ads.zzama
            r2.<init>(r0)
            goto L_0x00a9
        L_0x00be:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzakd r11 = com.google.android.gms.internal.ads.zzakc.zzab(r0)
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza(r1, r2, r3, r4, r5, r6)
            r16.writeNoException()
            goto L_0x021e
        L_0x00d5:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r13.zzac(r0)
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzfp.writeBoolean(r9, r0)
            goto L_0x021e
        L_0x00e9:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r0 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zztx r5 = (com.google.android.gms.internal.ads.zztx) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x010a
        L_0x0108:
            r7 = r2
            goto L_0x011d
        L_0x010a:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzals
            if (r7 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzals r2 = (com.google.android.gms.internal.ads.zzals) r2
            goto L_0x0108
        L_0x0117:
            com.google.android.gms.internal.ads.zzalu r2 = new com.google.android.gms.internal.ads.zzalu
            r2.<init>(r0)
            goto L_0x0108
        L_0x011d:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzakd r11 = com.google.android.gms.internal.ads.zzakc.zzab(r0)
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza(r1, r2, r3, r4, r5, r6)
            r16.writeNoException()
            goto L_0x021e
        L_0x0134:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zztx> r0 = com.google.android.gms.internal.ads.zztx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zztx r5 = (com.google.android.gms.internal.ads.zztx) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x0155
        L_0x0153:
            r7 = r2
            goto L_0x0168
        L_0x0155:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzalr
            if (r7 == 0) goto L_0x0162
            com.google.android.gms.internal.ads.zzalr r2 = (com.google.android.gms.internal.ads.zzalr) r2
            goto L_0x0153
        L_0x0162:
            com.google.android.gms.internal.ads.zzalt r2 = new com.google.android.gms.internal.ads.zzalt
            r2.<init>(r0)
            goto L_0x0153
        L_0x0168:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzakd r11 = com.google.android.gms.internal.ads.zzakc.zzab(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzua> r0 = com.google.android.gms.internal.ads.zzua.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r12 = r0
            com.google.android.gms.internal.ads.zzua r12 = (com.google.android.gms.internal.ads.zzua) r12
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r7 = r12
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            r16.writeNoException()
            goto L_0x021e
        L_0x0189:
            java.lang.String[] r0 = r15.createStringArray()
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            java.lang.Object[] r1 = r15.createTypedArray(r2)
            android.os.Bundle[] r1 = (android.os.Bundle[]) r1
            r13.zza(r0, r1)
            r16.writeNoException()
            goto L_0x021e
        L_0x019d:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r13.zzr(r0)
            r16.writeNoException()
            goto L_0x021e
        L_0x01ad:
            com.google.android.gms.internal.ads.zzwr r0 = r13.getVideoController()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zza(r9, r0)
            goto L_0x021e
        L_0x01b9:
            com.google.android.gms.internal.ads.zzamr r0 = r13.zzsh()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r9, r0)
            goto L_0x021e
        L_0x01c4:
            com.google.android.gms.internal.ads.zzamr r0 = r13.zzsg()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzfp.zzb(r9, r0)
            goto L_0x021e
        L_0x01cf:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r5 = r0
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r6 = r0
            android.os.Bundle r6 = (android.os.Bundle) r6
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzua> r0 = com.google.android.gms.internal.ads.zzua.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzfp.zza(r15, r0)
            r7 = r0
            com.google.android.gms.internal.ads.zzua r7 = (com.google.android.gms.internal.ads.zzua) r7
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x01fe
            r11 = r2
            goto L_0x0211
        L_0x01fe:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzame
            if (r2 == 0) goto L_0x020b
            com.google.android.gms.internal.ads.zzame r1 = (com.google.android.gms.internal.ads.zzame) r1
            goto L_0x0210
        L_0x020b:
            com.google.android.gms.internal.ads.zzamg r1 = new com.google.android.gms.internal.ads.zzamg
            r1.<init>(r0)
        L_0x0210:
            r11 = r1
        L_0x0211:
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza(r1, r2, r3, r4, r5, r6)
            r16.writeNoException()
        L_0x021e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamc.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
