package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdb implements zzdc {
    protected static volatile zzdx zzvo;
    protected MotionEvent zzvt;
    protected LinkedList<MotionEvent> zzvu = new LinkedList<>();
    protected long zzvv = 0;
    protected long zzvw = 0;
    protected long zzvx = 0;
    protected long zzvy = 0;
    protected long zzvz = 0;
    protected long zzwa = 0;
    protected long zzwb = 0;
    protected double zzwc;
    private double zzwd;
    private double zzwe;
    protected float zzwf;
    protected float zzwg;
    protected float zzwh;
    protected float zzwi;
    private boolean zzwj = false;
    protected boolean zzwk = false;
    protected DisplayMetrics zzwl;

    protected zzdb(Context context) {
        try {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcni)).booleanValue()) {
                zzci.zzbx();
            } else {
                zzed.zzb(zzvo);
            }
            this.zzwl = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzdw;

    /* access modifiers changed from: protected */
    public abstract zzb zza(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzb zza(Context context, zza zza);

    /* access modifiers changed from: protected */
    public abstract zzef zza(MotionEvent motionEvent) throws zzdw;

    /* access modifiers changed from: protected */
    public abstract zzb zzb(Context context, View view, Activity activity);

    public void zzb(View view) {
    }

    public final String zza(Context context) {
        if (zzee.isMainThread()) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcnk)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, zzdt.zzxk, null, null, null);
    }

    public final String zza(Context context, byte[] bArr) {
        if (zzee.isMainThread()) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcnk)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, zzdt.zzxk, null, null, bArr);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzdt.zzxm, view, activity, null);
    }

    public final void zzb(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzwj) {
            zzcc();
            this.zzwj = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwc = 0.0d;
            this.zzwd = (double) motionEvent.getRawX();
            this.zzwe = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.zzwd;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.zzwe;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.zzwc += Math.sqrt((d2 * d2) + (d4 * d4));
            this.zzwd = rawX;
            this.zzwe = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzwf = motionEvent.getX();
            this.zzwg = motionEvent.getY();
            this.zzwh = motionEvent.getRawX();
            this.zzwi = motionEvent.getRawY();
            this.zzvv++;
        } else if (action2 == 1) {
            this.zzvt = MotionEvent.obtain(motionEvent);
            this.zzvu.add(this.zzvt);
            if (this.zzvu.size() > 6) {
                ((MotionEvent) this.zzvu.remove()).recycle();
            }
            this.zzvx++;
            this.zzvz = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzvw += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzef zza = zza(motionEvent);
                if ((zza == null || zza.zzyt == null || zza.zzyw == null) ? false : true) {
                    this.zzwa += zza.zzyt.longValue() + zza.zzyw.longValue();
                }
                if (!(this.zzwl == null || zza == null || zza.zzyu == null || zza.zzyx == null)) {
                    z = true;
                }
                if (z) {
                    this.zzwb += zza.zzyu.longValue() + zza.zzyx.longValue();
                }
            } catch (zzdw unused) {
            }
        } else if (action2 == 3) {
            this.zzvy++;
        }
        this.zzwk = true;
    }

    public final void zza(int i, int i2, int i3) {
        if (this.zzvt != null) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcmv)).booleanValue()) {
                zzcc();
            } else {
                this.zzvt.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzwl;
        if (displayMetrics != null) {
            this.zzvt = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, this.zzwl.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzvt = null;
        }
        this.zzwk = false;
    }

    private final void zzcc() {
        this.zzvz = 0;
        this.zzvv = 0;
        this.zzvw = 0;
        this.zzvx = 0;
        this.zzvy = 0;
        this.zzwa = 0;
        this.zzwb = 0;
        if (this.zzvu.size() > 0) {
            Iterator it = this.zzvu.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzvu.clear();
        } else {
            MotionEvent motionEvent = this.zzvt;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzvt = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e A[Catch:{ Exception -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a A[Catch:{ Exception -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A[SYNTHETIC, Splitter:B:48:0x00c9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zza(android.content.Context r21, java.lang.String r22, int r23, android.view.View r24, android.app.Activity r25, byte[] r26) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = 0
            if (r5 == 0) goto L_0x001b
            int r7 = r5.length
            if (r7 <= 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzdqj r7 = com.google.android.gms.internal.ads.zzdqj.zzazb()     // Catch:{ zzdrg -> 0x001b }
            com.google.android.gms.internal.ads.zzbk$zza r5 = com.google.android.gms.internal.ads.zzbk.zza.zza(r5, r7)     // Catch:{ zzdrg -> 0x001b }
            goto L_0x001c
        L_0x001b:
            r5 = r6
        L_0x001c:
            long r7 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzza.zzcmx
            com.google.android.gms.internal.ads.zzyw r10 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r9 = r10.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzdx r10 = zzvo
            if (r10 == 0) goto L_0x003d
            com.google.android.gms.internal.ads.zzdx r10 = zzvo
            com.google.android.gms.internal.ads.zzda r10 = r10.zzcj()
            goto L_0x003e
        L_0x003d:
            r10 = r6
        L_0x003e:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzza.zzcni
            com.google.android.gms.internal.ads.zzyw r12 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r11 = r12.zzd(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0053
            java.lang.String r11 = "be"
            goto L_0x0058
        L_0x0053:
            java.lang.String r11 = "te"
            goto L_0x0058
        L_0x0056:
            r10 = r6
            r11 = r10
        L_0x0058:
            r19 = -1
            int r12 = com.google.android.gms.internal.ads.zzdt.zzxm     // Catch:{ Exception -> 0x0093 }
            if (r2 != r12) goto L_0x006a
            r5 = 1002(0x3ea, float:1.404E-42)
            com.google.android.gms.internal.ads.zzbo$zza$zzb r6 = r1.zza(r0, r3, r4)     // Catch:{ Exception -> 0x0093 }
            r0 = 1
            r1.zzwj = r0     // Catch:{ Exception -> 0x0093 }
            r13 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0081
        L_0x006a:
            int r12 = com.google.android.gms.internal.ads.zzdt.zzxl     // Catch:{ Exception -> 0x0093 }
            if (r2 != r12) goto L_0x0078
            r5 = 1008(0x3f0, float:1.413E-42)
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r1.zzb(r0, r3, r4)     // Catch:{ Exception -> 0x0093 }
            r6 = r0
            r13 = 1008(0x3f0, float:1.413E-42)
            goto L_0x0081
        L_0x0078:
            r3 = 1000(0x3e8, float:1.401E-42)
            com.google.android.gms.internal.ads.zzbo$zza$zzb r0 = r1.zza(r0, r5)     // Catch:{ Exception -> 0x0093 }
            r6 = r0
            r13 = 1000(0x3e8, float:1.401E-42)
        L_0x0081:
            if (r9 == 0) goto L_0x00c3
            if (r10 == 0) goto L_0x00c3
            r14 = -1
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0093 }
            long r15 = r3 - r7
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17)     // Catch:{ Exception -> 0x0093 }
            goto L_0x00c3
        L_0x0093:
            r0 = move-exception
            r18 = r0
            if (r9 == 0) goto L_0x00c3
            if (r10 == 0) goto L_0x00c3
            int r0 = com.google.android.gms.internal.ads.zzdt.zzxm
            if (r2 != r0) goto L_0x00a3
            r0 = 1003(0x3eb, float:1.406E-42)
            r13 = 1003(0x3eb, float:1.406E-42)
            goto L_0x00b6
        L_0x00a3:
            int r0 = com.google.android.gms.internal.ads.zzdt.zzxl
            if (r2 != r0) goto L_0x00ac
            r0 = 1009(0x3f1, float:1.414E-42)
            r13 = 1009(0x3f1, float:1.414E-42)
            goto L_0x00b6
        L_0x00ac:
            int r0 = com.google.android.gms.internal.ads.zzdt.zzxk
            if (r2 != r0) goto L_0x00b5
            r0 = 1001(0x3e9, float:1.403E-42)
            r13 = 1001(0x3e9, float:1.403E-42)
            goto L_0x00b6
        L_0x00b5:
            r13 = -1
        L_0x00b6:
            r14 = -1
            long r3 = java.lang.System.currentTimeMillis()
            long r15 = r3 - r7
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)
        L_0x00c3:
            long r3 = java.lang.System.currentTimeMillis()
            if (r6 == 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzdsg r0 = r6.zzazr()     // Catch:{ Exception -> 0x011a }
            com.google.android.gms.internal.ads.zzdqw r0 = (com.google.android.gms.internal.ads.zzdqw) r0     // Catch:{ Exception -> 0x011a }
            com.google.android.gms.internal.ads.zzbo$zza r0 = (com.google.android.gms.internal.ads.zzbo.zza) r0     // Catch:{ Exception -> 0x011a }
            int r0 = r0.zzazu()     // Catch:{ Exception -> 0x011a }
            if (r0 != 0) goto L_0x00d8
            goto L_0x0114
        L_0x00d8:
            com.google.android.gms.internal.ads.zzdsg r0 = r6.zzazr()     // Catch:{ Exception -> 0x011a }
            com.google.android.gms.internal.ads.zzdqw r0 = (com.google.android.gms.internal.ads.zzdqw) r0     // Catch:{ Exception -> 0x011a }
            com.google.android.gms.internal.ads.zzbo$zza r0 = (com.google.android.gms.internal.ads.zzbo.zza) r0     // Catch:{ Exception -> 0x011a }
            r5 = r22
            java.lang.String r0 = com.google.android.gms.internal.ads.zzci.zzj(r0, r5)     // Catch:{ Exception -> 0x011a }
            if (r9 == 0) goto L_0x014f
            if (r10 == 0) goto L_0x014f
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxm     // Catch:{ Exception -> 0x011a }
            if (r2 != r5) goto L_0x00f3
            r5 = 1006(0x3ee, float:1.41E-42)
            r13 = 1006(0x3ee, float:1.41E-42)
            goto L_0x0106
        L_0x00f3:
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxl     // Catch:{ Exception -> 0x011a }
            if (r2 != r5) goto L_0x00fc
            r5 = 1010(0x3f2, float:1.415E-42)
            r13 = 1010(0x3f2, float:1.415E-42)
            goto L_0x0106
        L_0x00fc:
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxk     // Catch:{ Exception -> 0x011a }
            if (r2 != r5) goto L_0x0105
            r5 = 1004(0x3ec, float:1.407E-42)
            r13 = 1004(0x3ec, float:1.407E-42)
            goto L_0x0106
        L_0x0105:
            r13 = -1
        L_0x0106:
            r14 = -1
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x011a }
            long r15 = r5 - r3
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17)     // Catch:{ Exception -> 0x011a }
            goto L_0x014f
        L_0x0114:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x011a }
            goto L_0x014f
        L_0x011a:
            r0 = move-exception
            r18 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r9 == 0) goto L_0x014f
            if (r10 == 0) goto L_0x014f
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxm
            if (r2 != r5) goto L_0x012f
            r2 = 1007(0x3ef, float:1.411E-42)
            r13 = 1007(0x3ef, float:1.411E-42)
            goto L_0x0142
        L_0x012f:
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxl
            if (r2 != r5) goto L_0x0138
            r2 = 1011(0x3f3, float:1.417E-42)
            r13 = 1011(0x3f3, float:1.417E-42)
            goto L_0x0142
        L_0x0138:
            int r5 = com.google.android.gms.internal.ads.zzdt.zzxk
            if (r2 != r5) goto L_0x0141
            r2 = 1005(0x3ed, float:1.408E-42)
            r13 = 1005(0x3ed, float:1.408E-42)
            goto L_0x0142
        L_0x0141:
            r13 = -1
        L_0x0142:
            r14 = -1
            long r5 = java.lang.System.currentTimeMillis()
            long r15 = r5 - r3
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)
        L_0x014f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdb.zza(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }
}
