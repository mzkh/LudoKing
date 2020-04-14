package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzzr {
    private File file;
    @VisibleForTesting
    private String zzblz;
    @VisibleForTesting
    private String zzcub;
    @VisibleForTesting
    private BlockingQueue<zzaab> zzcue = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private LinkedHashMap<String, String> zzcuf = new LinkedHashMap<>();
    @VisibleForTesting
    private Map<String, zzzv> zzcug = new HashMap();
    private final HashSet<String> zzcuh = new HashSet<>(Arrays.asList(new String[]{"noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"}));
    private AtomicBoolean zzcui;
    @VisibleForTesting
    private Context zzlk;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        this.zzlk = context;
        this.zzblz = str;
        this.zzcub = str2;
        this.zzcui = new AtomicBoolean(false);
        this.zzcui.set(((Boolean) zzuv.zzon().zzd(zzza.zzcim)).booleanValue());
        if (this.zzcui.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.zzcuf.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzaxn.zzdwi.execute(new zzzq(this));
        this.zzcug.put(NativeProtocol.WEB_DIALOG_ACTION, zzzv.zzcuk);
        this.zzcug.put("ad_format", zzzv.zzcuk);
        this.zzcug.put("e", zzzv.zzcul);
    }

    public final boolean zza(zzaab zzaab) {
        return this.zzcue.offer(zzaab);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[SYNTHETIC, Splitter:B:32:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092 A[SYNTHETIC, Splitter:B:38:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            java.lang.String r1 = r4.zzcub
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.appendQueryParameter(r3, r2)
            goto L_0x0014
        L_0x0030:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            android.net.Uri r1 = r1.build()
            java.lang.String r1 = r1.toString()
            r5.<init>(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = "&it="
            r5.append(r1)
            r5.append(r6)
        L_0x004b:
            java.lang.String r5 = r5.toString()
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.zzcui
            boolean r6 = r6.get()
            if (r6 == 0) goto L_0x00a1
            java.io.File r6 = r4.file
            if (r6 == 0) goto L_0x009b
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007f }
            r3 = 1
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x007f }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r2.write(r5)     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r5 = 10
            r2.write(r5)     // Catch:{ IOException -> 0x007a, all -> 0x0077 }
            r2.close()     // Catch:{ IOException -> 0x0072 }
            return
        L_0x0072:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzd(r0, r5)
            return
        L_0x0077:
            r5 = move-exception
            r1 = r2
            goto L_0x0090
        L_0x007a:
            r5 = move-exception
            r1 = r2
            goto L_0x0080
        L_0x007d:
            r5 = move-exception
            goto L_0x0090
        L_0x007f:
            r5 = move-exception
        L_0x0080:
            java.lang.String r6 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.ads.zzaug.zzd(r6, r5)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzd(r0, r5)
        L_0x008f:
            return
        L_0x0090:
            if (r1 == 0) goto L_0x009a
            r1.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaug.zzd(r0, r6)
        L_0x009a:
            throw r5
        L_0x009b:
            java.lang.String r5 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.ads.zzaug.zzeu(r5)
            return
        L_0x00a1:
            com.google.android.gms.ads.internal.zzq.zzkj()
            android.content.Context r6 = r4.zzlk
            java.lang.String r0 = r4.zzblz
            com.google.android.gms.internal.ads.zzaul.zzb(r6, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzr.zza(java.util.Map, java.lang.String):void");
    }

    /* access modifiers changed from: 0000 */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzcl(str).zzi(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public final zzzv zzcl(String str) {
        zzzv zzzv = (zzzv) this.zzcug.get(str);
        if (zzzv != null) {
            return zzzv;
        }
        return zzzv.zzcuj;
    }

    public final void zzcm(String str) {
        if (!this.zzcuh.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdkVersion", this.zzblz);
            linkedHashMap.put("ue", str);
            zza(zza((Map<String, String>) this.zzcuf, (Map<String, String>) linkedHashMap), "");
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzpx() {
        while (true) {
            try {
                zzaab zzaab = (zzaab) this.zzcue.take();
                String zzqc = zzaab.zzqc();
                if (!TextUtils.isEmpty(zzqc)) {
                    zza(zza((Map<String, String>) this.zzcuf, zzaab.zzqd()), zzqc);
                }
            } catch (InterruptedException e) {
                zzaug.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }
}
