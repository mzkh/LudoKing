package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.drive.query.internal.zzx;

public final class zzd implements zzj<String> {
    public final /* synthetic */ Object zza(zzb zzb, Object obj) {
        return String.format("contains(%s,%s)", new Object[]{zzb.getName(), obj});
    }

    public final /* synthetic */ Object zza(zzx zzx, MetadataField metadataField, Object obj) {
        return String.format("cmp(%s,%s,%s)", new Object[]{zzx.getTag(), metadataField.getName(), obj});
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r4v0, types: [java.util.List, java.util.List<java.lang.String>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza(com.google.android.gms.drive.query.internal.zzx r3, java.util.List<java.lang.String> r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = r3.getTag()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "("
            java.lang.String r3 = r3.concat(r1)
            r0.<init>(r3)
            java.util.Iterator r3 = r4.iterator()
            java.lang.String r4 = ""
        L_0x0019:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r3.next()
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = ","
            goto L_0x0019
        L_0x002e:
            java.lang.String r3 = ")"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.query.zzd.zza(com.google.android.gms.drive.query.internal.zzx, java.util.List):java.lang.Object");
    }

    public final /* synthetic */ Object zza(Object obj) {
        return String.format("not(%s)", new Object[]{(String) obj});
    }

    public final /* synthetic */ Object zzbb() {
        return "ownedByMe()";
    }

    public final /* synthetic */ Object zzbc() {
        return "all()";
    }

    public final /* synthetic */ Object zzc(MetadataField metadataField, Object obj) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), obj});
    }

    public final /* synthetic */ Object zze(MetadataField metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    public final /* synthetic */ Object zzg(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }
}
