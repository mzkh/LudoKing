package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavm {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private String zzdtr;
    @GuardedBy("lock")
    private String zzdts;
    @GuardedBy("lock")
    private boolean zzdtt;
    @VisibleForTesting
    private String zzdtu;

    public zzavm() {
        String str = "";
        this.zzdtr = str;
        this.zzdts = str;
        this.zzdtt = false;
        this.zzdtu = str;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.zzdtu)) {
            zzaug.zzdv("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
            return;
        }
        if ("1".equals(this.zzdtu)) {
            zzaug.zzdv("The app is not linked for creative preview.");
            zzi(context, str, str2);
            return;
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.zzdtu)) {
            zzaug.zzdv("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzwa = zzwa();
        if (zzg(context, str, str2)) {
            if (!zzwa && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzaug.zzdv("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzuv.zzon().zzd(zzza.zzcqc), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzaug.zzdv("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzdtu = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzdts = optString;
            }
            return true;
        } catch (JSONException e) {
            zzaug.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzuv.zzon().zzd(zzza.zzcqd), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzaug.zzdv("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzdtt = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzaug.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzq.zzkj().zzr(context, str2));
        zzddi zzc = new zzavy(context).zzc(str, hashMap);
        try {
            return (String) zzc.get((long) ((Integer) zzuv.zzon().zzd(zzza.zzcqf)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String str3 = "Timeout while retriving a response from: ";
            String valueOf = String.valueOf(str);
            zzaug.zzc(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String str4 = "Interrupted while retriving a response from: ";
            String valueOf2 = String.valueOf(str);
            zzaug.zzc(valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), e2);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String str5 = "Error retriving a response from: ";
            String valueOf3 = String.valueOf(str);
            zzaug.zzc(valueOf3.length() != 0 ? str5.concat(valueOf3) : new String(str5), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzq.zzkj();
        zzaul.zza(context, zzd(context, (String) zzuv.zzon().zzd(zzza.zzcqb), str, str2));
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzq.zzkt().zzwa()) {
            return false;
        }
        zzaug.zzdv("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Builder buildUpon = zzd(context, (String) zzuv.zzon().zzd(zzza.zzcqe), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzq.zzkj();
        zzaul.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbf(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String zzbf(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzdtr)) {
                zzq.zzkj();
                this.zzdtr = zzaul.zzs(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzdtr)) {
                    zzq.zzkj();
                    this.zzdtr = zzaul.zzvm();
                    zzq.zzkj();
                    zzaul.zzc(context, "debug_signals_id.txt", this.zzdtr);
                }
            }
            str = this.zzdtr;
        }
        return str;
    }

    public final String zzvz() {
        String str;
        synchronized (this.lock) {
            str = this.zzdts;
        }
        return str;
    }

    public final boolean zzwa() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdtt;
        }
        return z;
    }

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzaug.zzet("Can not create dialog without Activity Context");
            return;
        }
        Handler handler = zzaul.zzdsu;
        zzavl zzavl = new zzavl(this, context, str, z, z2);
        handler.post(zzavl);
    }
}
