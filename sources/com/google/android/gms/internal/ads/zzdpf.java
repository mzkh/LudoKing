package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpe;
import com.google.android.gms.internal.ads.zzdpf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public abstract class zzdpf<MessageType extends zzdpf<MessageType, BuilderType>, BuilderType extends zzdpe<MessageType, BuilderType>> implements zzdsg {
    protected int zzhfq = 0;

    public final zzdpm zzaxg() {
        try {
            zzdpu zzfo = zzdpm.zzfo(zzazu());
            zzb(zzfo.zzaxt());
            return zzfo.zzaxs();
        } catch (IOException e) {
            String str = "ByteString";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + str.length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzazu()];
            zzdqf zzaa = zzdqf.zzaa(bArr);
            zzb(zzaa);
            zzaa.zzayv();
            return bArr;
        } catch (IOException e) {
            String str = "byte array";
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + str.length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append(str);
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzaxh() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public void zzfi(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzdqx.checkNotNull(iterable);
        String str = " is null.";
        String str2 = "Element at index ";
        if (iterable instanceof zzdrn) {
            List zzban = ((zzdrn) iterable).zzban();
            zzdrn zzdrn = (zzdrn) list;
            int size = list.size();
            for (Object next : zzban) {
                if (next == null) {
                    int size2 = zzdrn.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append(str2);
                    sb.append(size2);
                    sb.append(str);
                    String sb2 = sb.toString();
                    for (int size3 = zzdrn.size() - 1; size3 >= size; size3--) {
                        zzdrn.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzdpm) {
                    zzdrn.zzdb((zzdpm) next);
                } else {
                    zzdrn.add((String) next);
                }
            }
        } else if (iterable instanceof zzdss) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size() - size4;
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append(str2);
                    sb3.append(size5);
                    sb3.append(str);
                    String sb4 = sb3.toString();
                    for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                        list.remove(size6);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
