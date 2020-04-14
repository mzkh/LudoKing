package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpe;
import com.google.android.gms.internal.ads.zzdpf;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public abstract class zzdpe<MessageType extends zzdpf<MessageType, BuilderType>, BuilderType extends zzdpe<MessageType, BuilderType>> implements zzdsf {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzdpy zzdpy, zzdqj zzdqj) throws IOException;

    /* renamed from: zzaxf */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzdqj zzdqj) throws zzdrg {
        try {
            zzdpy zzc = zzdpy.zzc(bArr, 0, i2, false);
            zza(zzc, zzdqj);
            zzc.zzfp(0);
            return this;
        } catch (zzdrg e) {
            throw e;
        } catch (IOException e2) {
            String str = "byte array";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + str.length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ zzdsf zzi(zzdsg zzdsg) {
        if (zzazs().getClass().isInstance(zzdsg)) {
            return zza((zzdpf) zzdsg);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
