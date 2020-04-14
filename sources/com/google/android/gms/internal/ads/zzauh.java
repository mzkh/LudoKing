package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzauh implements zzaui {
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private SharedPreferences zzcfy;
    @GuardedBy("lock")
    private boolean zzdjb = true;
    @GuardedBy("lock")
    private boolean zzdjo = false;
    @GuardedBy("lock")
    private String zzdjr = "";
    @GuardedBy("lock")
    private boolean zzdla = true;
    @GuardedBy("lock")
    private boolean zzdll = true;
    private boolean zzdsa;
    private final List<Runnable> zzdsb = new ArrayList();
    private zzddi<?> zzdsc;
    @GuardedBy("lock")
    @Nullable
    private zzpz zzdsd = null;
    @GuardedBy("lock")
    @Nullable
    private Editor zzdse;
    @GuardedBy("lock")
    private boolean zzdsf = false;
    @GuardedBy("lock")
    @Nullable
    private String zzdsg;
    @GuardedBy("lock")
    @Nullable
    private String zzdsh;
    @GuardedBy("lock")
    private long zzdsi = 0;
    @GuardedBy("lock")
    private long zzdsj = 0;
    @GuardedBy("lock")
    private long zzdsk = 0;
    @GuardedBy("lock")
    private int zzdsl = -1;
    @GuardedBy("lock")
    private int zzdsm = 0;
    @GuardedBy("lock")
    private Set<String> zzdsn = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzdso = new JSONObject();
    @GuardedBy("lock")
    private String zzdsp = null;
    @GuardedBy("lock")
    private int zzdsq = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r0 = "admob__";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r4.length() == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r4 = r0.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r4 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2.zzdsc = com.google.android.gms.internal.ads.zzaxn.zzdwi.zzf(new com.google.android.gms.internal.ads.zzauk(r2, r3, r4));
        r2.zzdsa = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        if (r4 != null) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r4 = com.applovin.sdk.AppLovinMediationProvider.ADMOB;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r2.zzcfy     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x000f
            java.lang.String r4 = "admob"
            goto L_0x0025
        L_0x000f:
            java.lang.String r0 = "admob__"
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r4.length()
            if (r1 == 0) goto L_0x0020
            java.lang.String r4 = r0.concat(r4)
            goto L_0x0025
        L_0x0020:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x0025:
            com.google.android.gms.internal.ads.zzddl r0 = com.google.android.gms.internal.ads.zzaxn.zzdwi
            com.google.android.gms.internal.ads.zzauk r1 = new com.google.android.gms.internal.ads.zzauk
            r1.<init>(r2, r3, r4)
            com.google.android.gms.internal.ads.zzddi r3 = r0.zzf(r1)
            r2.zzdsc = r3
            r2.zzdsa = r5
            return
        L_0x0035:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zza(android.content.Context, java.lang.String, boolean):void");
    }

    private final void zzuv() {
        zzddi<?> zzddi = this.zzdsc;
        if (zzddi != null && !zzddi.isDone()) {
            try {
                this.zzdsc.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzaug.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzaug.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzuw() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdjb);
            bundle.putBoolean("content_url_opted_out", this.zzdla);
            bundle.putBoolean("content_vertical_opted_out", this.zzdll);
            bundle.putBoolean("auto_collect_location", this.zzdjo);
            bundle.putInt("version_code", this.zzdsm);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdsn.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdjr);
            bundle.putLong("app_settings_last_update_ms", this.zzdsi);
            bundle.putLong("app_last_background_time_ms", this.zzdsj);
            bundle.putInt("request_in_session_count", this.zzdsl);
            bundle.putLong("first_ad_req_time_ms", this.zzdsk);
            bundle.putString("native_advanced_settings", this.zzdso.toString());
            bundle.putString("display_cutout", this.zzdsp);
            bundle.putInt("app_measurement_npa", this.zzdsq);
            if (this.zzdsg != null) {
                bundle.putString("content_url_hashes", this.zzdsg);
            }
            if (this.zzdsh != null) {
                bundle.putString("content_vertical_hashes", this.zzdsh);
            }
        }
        return bundle;
    }

    private final void zzc(Bundle bundle) {
        zzaxn.zzdwi.execute(new zzauj(this));
    }

    @Nullable
    public final zzpz zzux() {
        if (!this.zzdsa || !PlatformVersion.isAtLeastIceCreamSandwich()) {
            return null;
        }
        if (zzuy() && zzva()) {
            return null;
        }
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcin)).booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzdsd == null) {
                this.zzdsd = new zzpz();
            }
            this.zzdsd.zzlu();
            zzaug.zzet("start fetching content...");
            zzpz zzpz = this.zzdsd;
            return zzpz;
        }
    }

    public final void zzah(boolean z) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdla != z) {
                this.zzdla = z;
                if (this.zzdse != null) {
                    this.zzdse.putBoolean("content_url_opted_out", z);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdla);
                bundle.putBoolean("content_vertical_opted_out", this.zzdll);
                zzc(bundle);
            }
        }
    }

    public final boolean zzuy() {
        boolean z;
        zzuv();
        synchronized (this.lock) {
            z = this.zzdla;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzdz(@androidx.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzuv()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdsg     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdsg = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzdz(java.lang.String):void");
    }

    @Nullable
    public final String zzuz() {
        String str;
        zzuv();
        synchronized (this.lock) {
            str = this.zzdsg;
        }
        return str;
    }

    public final void zzai(boolean z) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdll != z) {
                this.zzdll = z;
                if (this.zzdse != null) {
                    this.zzdse.putBoolean("content_vertical_opted_out", z);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdla);
                bundle.putBoolean("content_vertical_opted_out", this.zzdll);
                zzc(bundle);
            }
        }
    }

    public final boolean zzva() {
        boolean z;
        zzuv();
        synchronized (this.lock) {
            z = this.zzdll;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzea(@androidx.annotation.Nullable java.lang.String r4) {
        /*
            r3 = this;
            r3.zzuv()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0032
            java.lang.String r1 = r3.zzdsh     // Catch:{ all -> 0x0034 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0032
        L_0x0011:
            r3.zzdsh = r4     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r1 = r3.zzdse     // Catch:{ all -> 0x0034 }
            r1.apply()     // Catch:{ all -> 0x0034 }
        L_0x0023:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x0034 }
            r3.zzc(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzea(java.lang.String):void");
    }

    @Nullable
    public final String zzvb() {
        String str;
        zzuv();
        synchronized (this.lock) {
            str = this.zzdsh;
        }
        return str;
    }

    public final void zzaj(boolean z) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdjo != z) {
                this.zzdjo = z;
                if (this.zzdse != null) {
                    this.zzdse.putBoolean("auto_collect_location", z);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzc(bundle);
            }
        }
    }

    public final boolean zzvc() {
        boolean z;
        zzuv();
        synchronized (this.lock) {
            z = this.zzdjo;
        }
        return z;
    }

    public final void zzcm(int i) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdsm != i) {
                this.zzdsm = i;
                if (this.zzdse != null) {
                    this.zzdse.putInt("version_code", i);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzc(bundle);
            }
        }
    }

    public final int zzvd() {
        int i;
        zzuv();
        synchronized (this.lock) {
            i = this.zzdsm;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzeb(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzuv()
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ all -> 0x0060 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r5.zzdsi = r1     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x005e
            java.lang.String r3 = r5.zzdjr     // Catch:{ all -> 0x0060 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            r5.zzdjr = r6     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdse     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.zzdse     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdse     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_last_update_ms"
            r3.putLong(r4, r1)     // Catch:{ all -> 0x0060 }
            android.content.SharedPreferences$Editor r3 = r5.zzdse     // Catch:{ all -> 0x0060 }
            r3.apply()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0060 }
            r3.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "app_settings_last_update_ms"
            r3.putLong(r6, r1)     // Catch:{ all -> 0x0060 }
            r5.zzc(r3)     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Runnable> r6 = r5.zzdsb     // Catch:{ all -> 0x0060 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0060 }
        L_0x004c:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0060 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0060 }
            r1.run()     // Catch:{ all -> 0x0060 }
            goto L_0x004c
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzeb(java.lang.String):void");
    }

    public final zzats zzve() {
        zzats zzats;
        zzuv();
        synchronized (this.lock) {
            zzats = new zzats(this.zzdjr, this.zzdsi);
        }
        return zzats;
    }

    public final void zzb(Runnable runnable) {
        this.zzdsb.add(runnable);
    }

    public final void zzet(long j) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdsj != j) {
                this.zzdsj = j;
                if (this.zzdse != null) {
                    this.zzdse.putLong("app_last_background_time_ms", j);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final long zzvf() {
        long j;
        zzuv();
        synchronized (this.lock) {
            j = this.zzdsj;
        }
        return j;
    }

    public final void zzcn(int i) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdsl != i) {
                this.zzdsl = i;
                if (this.zzdse != null) {
                    this.zzdse.putInt("request_in_session_count", i);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzc(bundle);
            }
        }
    }

    public final int zzvg() {
        int i;
        zzuv();
        synchronized (this.lock) {
            i = this.zzdsl;
        }
        return i;
    }

    public final void zzeu(long j) {
        zzuv();
        synchronized (this.lock) {
            if (this.zzdsk != j) {
                this.zzdsk = j;
                if (this.zzdse != null) {
                    this.zzdse.putLong("first_ad_req_time_ms", j);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final long zzvh() {
        long j;
        zzuv();
        synchronized (this.lock) {
            j = this.zzdsk;
        }
        return j;
    }

    public final void zzc(String str, String str2, boolean z) {
        zzuv();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzdso.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzq.zzkq().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzdso.put(str, optJSONArray);
            } catch (JSONException e) {
                zzaug.zzd("Could not update native advanced settings", e);
            }
            if (this.zzdse != null) {
                this.zzdse.putString("native_advanced_settings", this.zzdso.toString());
                this.zzdse.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzdso.toString());
            zzc(bundle);
        }
    }

    public final JSONObject zzvi() {
        JSONObject jSONObject;
        zzuv();
        synchronized (this.lock) {
            jSONObject = this.zzdso;
        }
        return jSONObject;
    }

    public final void zzvj() {
        zzuv();
        synchronized (this.lock) {
            this.zzdso = new JSONObject();
            if (this.zzdse != null) {
                this.zzdse.remove("native_advanced_settings");
                this.zzdse.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    public final String zzvk() {
        String str;
        zzuv();
        synchronized (this.lock) {
            str = this.zzdsp;
        }
        return str;
    }

    public final void zzec(String str) {
        zzuv();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzdsp, str)) {
                this.zzdsp = str;
                if (this.zzdse != null) {
                    this.zzdse.putString("display_cutout", str);
                    this.zzdse.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                zzc(bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzp(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcfy = sharedPreferences;
            this.zzdse = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdsf = z;
            this.zzdjb = this.zzcfy.getBoolean("use_https", this.zzdjb);
            this.zzdla = this.zzcfy.getBoolean("content_url_opted_out", this.zzdla);
            this.zzdsg = this.zzcfy.getString("content_url_hashes", this.zzdsg);
            this.zzdjo = this.zzcfy.getBoolean("auto_collect_location", this.zzdjo);
            this.zzdll = this.zzcfy.getBoolean("content_vertical_opted_out", this.zzdll);
            this.zzdsh = this.zzcfy.getString("content_vertical_hashes", this.zzdsh);
            this.zzdsm = this.zzcfy.getInt("version_code", this.zzdsm);
            this.zzdjr = this.zzcfy.getString("app_settings_json", this.zzdjr);
            this.zzdsi = this.zzcfy.getLong("app_settings_last_update_ms", this.zzdsi);
            this.zzdsj = this.zzcfy.getLong("app_last_background_time_ms", this.zzdsj);
            this.zzdsl = this.zzcfy.getInt("request_in_session_count", this.zzdsl);
            this.zzdsk = this.zzcfy.getLong("first_ad_req_time_ms", this.zzdsk);
            this.zzdsn = this.zzcfy.getStringSet("never_pool_slots", this.zzdsn);
            this.zzdsp = this.zzcfy.getString("display_cutout", this.zzdsp);
            this.zzdsq = this.zzcfy.getInt("app_measurement_npa", this.zzdsq);
            try {
                this.zzdso = new JSONObject(this.zzcfy.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzaug.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzuw());
        }
    }
}
