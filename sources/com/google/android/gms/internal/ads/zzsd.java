package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsf.zza.C3512zza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzsd {
    private final zzsi zzbsa;
    @GuardedBy("this")
    private final zztl zzbsb;
    private final boolean zzbsc;

    public static zzsd zzmm() {
        return new zzsd();
    }

    public zzsd(zzsi zzsi) {
        this.zzbsa = zzsi;
        this.zzbsc = ((Boolean) zzuv.zzon().zzd(zzza.zzcql)).booleanValue();
        this.zzbsb = new zztl();
        zzmn();
    }

    private zzsd() {
        this.zzbsc = false;
        this.zzbsa = new zzsi();
        this.zzbsb = new zztl();
        zzmn();
    }

    public final synchronized void zza(C3512zza zza) {
        if (this.zzbsc) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcqm)).booleanValue()) {
                zzc(zza);
            } else {
                zzb(zza);
            }
        }
    }

    private final synchronized void zzb(C3512zza zza) {
        this.zzbsb.zzcat = zzmo();
        this.zzbsa.zzf(zzdus.zzb(this.zzbsb)).zzbq(zza.zzab()).zzdh();
        String str = "Logging Event with event code : ";
        String valueOf = String.valueOf(Integer.toString(zza.zzab(), 10));
        zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    private final synchronized void zzc(C3512zza zza) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzaug.zzdy("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzaug.zzdy("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzaug.zzdy("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzaug.zzdy("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzaug.zzdy("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzd(C3512zza zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzbsb.zzcap, Long.valueOf(zzq.zzkq().elapsedRealtime()), Integer.valueOf(zza.zzab()), Base64.encodeToString(zzdus.zzb(this.zzbsb), 3)});
    }

    public final synchronized void zza(zzsg zzsg) {
        if (this.zzbsc) {
            try {
                zzsg.zza(this.zzbsb);
            } catch (NullPointerException e) {
                zzq.zzkn().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private final synchronized void zzmn() {
        this.zzbsb.zzcax = new zzth();
        this.zzbsb.zzcax.zzbzv = new zztg();
        this.zzbsb.zzcau = new zztj();
    }

    private static long[] zzmo() {
        int i;
        List zzps = zzza.zzps();
        ArrayList arrayList = new ArrayList();
        Iterator it = zzps.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = ((String) it.next()).split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException unused) {
                    zzaug.zzdy("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }
}
