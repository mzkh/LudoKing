package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazm {
    private final zzaxl zzdio;
    private final String zzdje;
    @Nullable
    private final zzaab zzdyc;
    private boolean zzdyg;
    @Nullable
    private final zzzz zzeat;
    private final zzavu zzeau = new zzavv().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzwc();
    private final long[] zzeav;
    private final String[] zzeaw;
    private boolean zzeax = false;
    private boolean zzeay = false;
    private boolean zzeaz = false;
    private boolean zzeba = false;
    private zzayu zzebb;
    private boolean zzebc;
    private boolean zzebd;
    private long zzebe = -1;
    private final Context zzlk;

    public zzazm(Context context, zzaxl zzaxl, String str, @Nullable zzaab zzaab, @Nullable zzzz zzzz) {
        this.zzlk = context;
        this.zzdio = zzaxl;
        this.zzdje = str;
        this.zzdyc = zzaab;
        this.zzeat = zzzz;
        String str2 = (String) zzuv.zzon().zzd(zzza.zzchn);
        if (str2 == null) {
            this.zzeaw = new String[0];
            this.zzeav = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzeaw = new String[split.length];
        this.zzeav = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeav[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzaug.zzd("Unable to parse frame hash target time number.", e);
                this.zzeav[i] = -1;
            }
        }
    }

    public final void zzb(zzayu zzayu) {
        zzzs.zza(this.zzdyc, this.zzeat, "vpc2");
        this.zzeax = true;
        zzaab zzaab = this.zzdyc;
        if (zzaab != null) {
            zzaab.zzj("vpn", zzayu.zzwq());
        }
        this.zzebb = zzayu;
    }

    public final void zzel() {
        if (this.zzeax && !this.zzeay) {
            zzzs.zza(this.zzdyc, this.zzeat, "vfr2");
            this.zzeay = true;
        }
    }

    public final void onStop() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzchm)).booleanValue() && !this.zzebc) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.zzdje);
            bundle.putString("player", this.zzebb.zzwq());
            for (zzavw zzavw : this.zzeau.zzwb()) {
                String str = "fps_c_";
                String valueOf = String.valueOf(zzavw.name);
                bundle.putString(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.toString(zzavw.count));
                String str2 = "fps_p_";
                String valueOf2 = String.valueOf(zzavw.name);
                bundle.putString(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), Double.toString(zzavw.zzduh));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzeav;
                if (i < jArr.length) {
                    String str3 = this.zzeaw[i];
                    if (str3 != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString(sb.toString(), str3);
                    }
                    i++;
                } else {
                    zzq.zzkj().zza(this.zzlk, this.zzdio.zzblz, "gmob-apps", bundle, true);
                    this.zzebc = true;
                    return;
                }
            }
        }
    }

    public final void zzc(zzayu zzayu) {
        if (this.zzeaz && !this.zzeba) {
            if (zzaug.zzuu() && !this.zzeba) {
                zzaug.zzdy("VideoMetricsMixin first frame");
            }
            zzzs.zza(this.zzdyc, this.zzeat, "vff2");
            this.zzeba = true;
        }
        long nanoTime = zzq.zzkq().nanoTime();
        if (this.zzdyg && this.zzebd && this.zzebe != -1) {
            double nanos = (double) TimeUnit.SECONDS.toNanos(1);
            double d = (double) (nanoTime - this.zzebe);
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.zzeau.zza(nanos / d);
        }
        this.zzebd = this.zzdyg;
        this.zzebe = nanoTime;
        long longValue = ((Long) zzuv.zzon().zzd(zzza.zzcho)).longValue();
        long currentPosition = (long) zzayu.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzeaw;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.zzeav[i])) {
                zzayu zzayu2 = zzayu;
                i++;
            } else {
                String[] strArr2 = this.zzeaw;
                int i2 = 8;
                Bitmap bitmap = zzayu.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzxw() {
        this.zzdyg = true;
        if (this.zzeay && !this.zzeaz) {
            zzzs.zza(this.zzdyc, this.zzeat, "vfp2");
            this.zzeaz = true;
        }
    }

    public final void zzxx() {
        this.zzdyg = false;
    }
}
