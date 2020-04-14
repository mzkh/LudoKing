package com.google.android.gms.internal.ads;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzain implements zzagv, zzaik {
    private final zzail zzdas;
    private final HashSet<SimpleEntry<String, zzaer<? super zzail>>> zzdat = new HashSet<>();

    public zzain(zzail zzail) {
        this.zzdas = zzail;
    }

    public final void zza(String str, Map map) {
        zzagu.zza((zzagv) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzagu.zza((zzagv) this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzagu.zzb(this, str, jSONObject);
    }

    public final void zzk(String str, String str2) {
        zzagu.zza((zzagv) this, str, str2);
    }

    public final void zzct(String str) {
        this.zzdas.zzct(str);
    }

    public final void zza(String str, zzaer<? super zzail> zzaer) {
        this.zzdas.zza(str, zzaer);
        this.zzdat.add(new SimpleEntry(str, zzaer));
    }

    public final void zzb(String str, zzaer<? super zzail> zzaer) {
        this.zzdas.zzb(str, zzaer);
        this.zzdat.remove(new SimpleEntry(str, zzaer));
    }

    public final void zzrk() {
        Iterator it = this.zzdat.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((zzaer) simpleEntry.getValue()).toString());
            zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzdas.zzb((String) simpleEntry.getKey(), (zzaer) simpleEntry.getValue());
        }
        this.zzdat.clear();
    }
}
