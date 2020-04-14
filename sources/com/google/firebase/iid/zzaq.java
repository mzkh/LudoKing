package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzaq {
    private final SharedPreferences zza;
    private final Context zzb;
    private final zzp zzc;
    @GuardedBy("this")
    private final Map<String, zzr> zzd;

    public zzaq(Context context) {
        this(context, new zzp());
    }

    private zzaq(Context context, zzp zzp) {
        String str = "FirebaseInstanceId";
        this.zzd = new ArrayMap();
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzc = zzp;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !zzc()) {
                    Log.i(str, "App restored, clearing state");
                    zzb();
                    FirebaseInstanceId.getInstance().zze();
                }
            } catch (IOException e) {
                if (Log.isLoggable(str, 3)) {
                    String str2 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    public final synchronized String zza() {
        return this.zza.getString("topic_operation_queue", "");
    }

    public final synchronized void zza(String str) {
        this.zza.edit().putString("topic_operation_queue", str).apply();
    }

    private final synchronized boolean zzc() {
        return this.zza.getAll().isEmpty();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void zzb() {
        this.zzd.clear();
        zzp.zza(this.zzb);
        this.zza.edit().clear().commit();
    }

    public final synchronized zzap zza(String str, String str2, String str3) {
        return zzap.zza(this.zza.getString(zzc(str, str2, str3), null));
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza2 = zzap.zza(str4, str5, System.currentTimeMillis());
        if (zza2 != null) {
            Editor edit = this.zza.edit();
            edit.putString(zzc(str, str2, str3), zza2);
            edit.commit();
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc2 = zzc(str, str2, str3);
        Editor edit = this.zza.edit();
        edit.remove(zzc2);
        edit.commit();
    }

    public final synchronized zzr zzb(String str) {
        zzr zzr;
        zzr zzr2 = (zzr) this.zzd.get(str);
        if (zzr2 != null) {
            return zzr2;
        }
        try {
            zzr = this.zzc.zza(this.zzb, str);
        } catch (zzs unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().zze();
            zzr = this.zzc.zzb(this.zzb, str);
        }
        this.zzd.put(str, zzr);
        return zzr;
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.zza.edit();
        for (String str2 : this.zza.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
