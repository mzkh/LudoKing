package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbg extends zzdvm {
    private Date zzcr;
    private Date zzcs;
    private long zzct;
    private long zzcu;
    private double zzcv = 1.0d;
    private float zzcw = 1.0f;
    private zzdvw zzcx = zzdvw.zzhxh;
    private long zzcy;
    private int zzcz;
    private int zzda;
    private int zzdb;
    private int zzdc;
    private int zzdd;
    private int zzde;

    public zzbg() {
        super("mvhd");
    }

    public final long zzq() {
        return this.zzct;
    }

    public final long getDuration() {
        return this.zzcu;
    }

    public final void zzg(ByteBuffer byteBuffer) {
        zzo(byteBuffer);
        if (getVersion() == 1) {
            this.zzcr = zzdvp.zzfp(zzbc.zzc(byteBuffer));
            this.zzcs = zzdvp.zzfp(zzbc.zzc(byteBuffer));
            this.zzct = zzbc.zza(byteBuffer);
            this.zzcu = zzbc.zzc(byteBuffer);
        } else {
            this.zzcr = zzdvp.zzfp(zzbc.zza(byteBuffer));
            this.zzcs = zzdvp.zzfp(zzbc.zza(byteBuffer));
            this.zzct = zzbc.zza(byteBuffer);
            this.zzcu = zzbc.zza(byteBuffer);
        }
        this.zzcv = zzbc.zzd(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzcw = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)))))) / 256.0f;
        zzbc.zzb(byteBuffer);
        zzbc.zza(byteBuffer);
        zzbc.zza(byteBuffer);
        this.zzcx = zzdvw.zzp(byteBuffer);
        this.zzcz = byteBuffer.getInt();
        this.zzda = byteBuffer.getInt();
        this.zzdb = byteBuffer.getInt();
        this.zzdc = byteBuffer.getInt();
        this.zzdd = byteBuffer.getInt();
        this.zzde = byteBuffer.getInt();
        this.zzcy = zzbc.zza(byteBuffer);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieHeaderBox[");
        sb.append("creationTime=");
        sb.append(this.zzcr);
        String str = ";";
        sb.append(str);
        sb.append("modificationTime=");
        sb.append(this.zzcs);
        sb.append(str);
        sb.append("timescale=");
        sb.append(this.zzct);
        sb.append(str);
        sb.append("duration=");
        sb.append(this.zzcu);
        sb.append(str);
        sb.append("rate=");
        sb.append(this.zzcv);
        sb.append(str);
        sb.append("volume=");
        sb.append(this.zzcw);
        sb.append(str);
        sb.append("matrix=");
        sb.append(this.zzcx);
        sb.append(str);
        sb.append("nextTrackId=");
        sb.append(this.zzcy);
        sb.append("]");
        return sb.toString();
    }
}
