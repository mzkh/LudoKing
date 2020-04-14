package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyw implements OnSharedPreferenceChangeListener {
    private final Object lock = new Object();
    private Bundle metaData = new Bundle();
    private final ConditionVariable zzcfw = new ConditionVariable();
    @VisibleForTesting
    private volatile boolean zzcfx = false;
    @Nullable
    private SharedPreferences zzcfy = null;
    private Context zzcfz;
    private JSONObject zzcga = new JSONObject();
    private volatile boolean zzye = false;

    /* JADX WARNING: type inference failed for: r6v6, types: [com.google.android.gms.internal.ads.zzaao, com.google.android.gms.internal.ads.zzzb] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v6, types: [com.google.android.gms.internal.ads.zzaao, com.google.android.gms.internal.ads.zzzb]
      assigns: [com.google.android.gms.internal.ads.zzzb]
      uses: [com.google.android.gms.internal.ads.zzaao]
      mth insns count: 62
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
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r6) {
        /*
            r5 = this;
            boolean r0 = r5.zzye
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            boolean r1 = r5.zzye     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x000e:
            boolean r1 = r5.zzcfx     // Catch:{ all -> 0x0087 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r5.zzcfx = r2     // Catch:{ all -> 0x0087 }
        L_0x0015:
            android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x001d
            r1 = r6
            goto L_0x0021
        L_0x001d:
            android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x0087 }
        L_0x0021:
            r5.zzcfz = r1     // Catch:{ all -> 0x0087 }
            android.content.Context r1 = r5.zzcfz     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            android.content.Context r3 = r5.zzcfz     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
            r5.metaData = r1     // Catch:{ NameNotFoundException | NullPointerException -> 0x0039 }
        L_0x0039:
            r1 = 0
            android.content.Context r3 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r6)     // Catch:{ all -> 0x007e }
            if (r3 != 0) goto L_0x0049
            if (r6 == 0) goto L_0x0049
            android.content.Context r3 = r6.getApplicationContext()     // Catch:{ all -> 0x007e }
            if (r3 != 0) goto L_0x0049
            r3 = r6
        L_0x0049:
            if (r3 != 0) goto L_0x0054
            r5.zzcfx = r1     // Catch:{ all -> 0x0087 }
            android.os.ConditionVariable r6 = r5.zzcfw     // Catch:{ all -> 0x0087 }
            r6.open()     // Catch:{ all -> 0x0087 }
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0054:
            com.google.android.gms.internal.ads.zzuv.zzol()     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "google_ads_flags"
            android.content.SharedPreferences r6 = r3.getSharedPreferences(r6, r1)     // Catch:{ all -> 0x007e }
            r5.zzcfy = r6     // Catch:{ all -> 0x007e }
            android.content.SharedPreferences r6 = r5.zzcfy     // Catch:{ all -> 0x007e }
            if (r6 == 0) goto L_0x0068
            android.content.SharedPreferences r6 = r5.zzcfy     // Catch:{ all -> 0x007e }
            r6.registerOnSharedPreferenceChangeListener(r5)     // Catch:{ all -> 0x007e }
        L_0x0068:
            com.google.android.gms.internal.ads.zzzb r6 = new com.google.android.gms.internal.ads.zzzb     // Catch:{ all -> 0x007e }
            r6.<init>(r5)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.ads.zzaar.zza(r6)     // Catch:{ all -> 0x007e }
            r5.zzpt()     // Catch:{ all -> 0x007e }
            r5.zzye = r2     // Catch:{ all -> 0x007e }
            r5.zzcfx = r1     // Catch:{ all -> 0x0087 }
            android.os.ConditionVariable r6 = r5.zzcfw     // Catch:{ all -> 0x0087 }
            r6.open()     // Catch:{ all -> 0x0087 }
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x007e:
            r6 = move-exception
            r5.zzcfx = r1     // Catch:{ all -> 0x0087 }
            android.os.ConditionVariable r1 = r5.zzcfw     // Catch:{ all -> 0x0087 }
            r1.open()     // Catch:{ all -> 0x0087 }
            throw r6     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0087 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyw.initialize(android.content.Context):void");
    }

    public final <T> T zzd(zzyp<T> zzyp) {
        if (!this.zzcfw.block(5000)) {
            synchronized (this.lock) {
                if (!this.zzcfx) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzye || this.zzcfy == null) {
            synchronized (this.lock) {
                if (this.zzye) {
                    if (this.zzcfy == null) {
                    }
                }
                T zzpq = zzyp.zzpq();
                return zzpq;
            }
        }
        if (zzyp.getSource() == 2) {
            Bundle bundle = this.metaData;
            if (bundle == null) {
                return zzyp.zzpq();
            }
            return zzyp.zza(bundle);
        } else if (zzyp.getSource() != 1 || !this.zzcga.has(zzyp.getKey())) {
            return zzawq.zza(this.zzcfz, new zzyz(this, zzyp));
        } else {
            return zzyp.zza(this.zzcga);
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzpt();
        }
    }

    private final void zzpt() {
        if (this.zzcfy != null) {
            try {
                this.zzcga = new JSONObject((String) zzawq.zza(this.zzcfz, new zzyy(this)));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String zzpu() throws Exception {
        return this.zzcfy.getString("flag_configuration", "{}");
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zze(zzyp zzyp) throws Exception {
        return zzyp.zza(this.zzcfy);
    }
}
