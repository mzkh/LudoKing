package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;

final class zzy extends zzb {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzx;
    private final /* synthetic */ String zzy;
    private final /* synthetic */ Bundle zzz;

    zzy(zzz zzz2, String str, String str2, Context context, Bundle bundle) {
        this.zzaa = zzz2;
        this.zzx = str;
        this.zzy = str2;
        this.val$context = context;
        this.zzz = bundle;
        super(zzz2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r4 < r3) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ RemoteException -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[Catch:{ RemoteException -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ RemoteException -> 0x009e }
            r3.<init>()     // Catch:{ RemoteException -> 0x009e }
            r2.zzaf = r3     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r3 = r14.zzx     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r4 = r14.zzy     // Catch:{ RemoteException -> 0x009e }
            boolean r2 = com.google.android.gms.internal.measurement.zzz.zza(r3, r4)     // Catch:{ RemoteException -> 0x009e }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = r14.zzy     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r2 = r14.zzx     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz r4 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r4 = r4.zzu     // Catch:{ RemoteException -> 0x009e }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002a
        L_0x0027:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002a:
            android.content.Context r2 = r14.val$context     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz.zze(r2)     // Catch:{ RemoteException -> 0x009e }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzz.zzai     // Catch:{ RemoteException -> 0x009e }
            boolean r2 = r2.booleanValue()     // Catch:{ RemoteException -> 0x009e }
            if (r2 != 0) goto L_0x003e
            if (r10 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz r4 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            android.content.Context r5 = r14.val$context     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzk r4 = r4.zza(r5, r2)     // Catch:{ RemoteException -> 0x009e }
            r3.zzar = r4     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzk r3 = 
            // error: 0x004e: INVOKE  (r3 I:com.google.android.gms.internal.measurement.zzk) = (r3 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            if (r3 != 0) goto L_0x0060
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r2 = r2.zzu     // Catch:{ RemoteException -> 0x009e }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ RemoteException -> 0x009e }
            return
        L_0x0060:
            android.content.Context r3 = r14.val$context     // Catch:{ RemoteException -> 0x009e }
            int r3 = com.google.android.gms.internal.measurement.zzz.zzd(r3)     // Catch:{ RemoteException -> 0x009e }
            android.content.Context r4 = r14.val$context     // Catch:{ RemoteException -> 0x009e }
            int r4 = com.google.android.gms.internal.measurement.zzz.zzc(r4)     // Catch:{ RemoteException -> 0x009e }
            if (r2 == 0) goto L_0x0079
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ RemoteException -> 0x009e }
            if (r4 >= r3) goto L_0x0076
        L_0x0074:
            r3 = 1
            goto L_0x0077
        L_0x0076:
            r3 = 0
        L_0x0077:
            r8 = r3
            goto L_0x0081
        L_0x0079:
            if (r3 <= 0) goto L_0x007d
            r2 = r3
            goto L_0x007e
        L_0x007d:
            r2 = r4
        L_0x007e:
            if (r3 <= 0) goto L_0x0076
            goto L_0x0074
        L_0x0081:
            com.google.android.gms.internal.measurement.zzx r13 = new com.google.android.gms.internal.measurement.zzx     // Catch:{ RemoteException -> 0x009e }
            r4 = 16250(0x3f7a, double:8.0286E-320)
            long r6 = (long) r2     // Catch:{ RemoteException -> 0x009e }
            android.os.Bundle r12 = r14.zzz     // Catch:{ RemoteException -> 0x009e }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzz r2 = r14.zzaa     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.internal.measurement.zzk r2 = 
            // error: 0x008e: INVOKE  (r2 I:com.google.android.gms.internal.measurement.zzk) = (r2 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            android.content.Context r3 = r14.val$context     // Catch:{ RemoteException -> 0x009e }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ RemoteException -> 0x009e }
            long r4 = r14.timestamp     // Catch:{ RemoteException -> 0x009e }
            r2.initialize(r3, r13, r4)     // Catch:{ RemoteException -> 0x009e }
            return
        L_0x009e:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzz r3 = r14.zzaa
            r3.zza(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzy.zzf():void");
    }
}
