package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public enum zzdue {
    DOUBLE(zzduh.DOUBLE, 1),
    FLOAT(zzduh.FLOAT, 5),
    INT64(zzduh.LONG, 0),
    UINT64(zzduh.LONG, 0),
    INT32(zzduh.INT, 0),
    FIXED64(zzduh.LONG, 1),
    FIXED32(zzduh.INT, 5),
    BOOL(zzduh.BOOLEAN, 0),
    STRING(zzduh.STRING, 2),
    GROUP(zzduh.MESSAGE, 3),
    MESSAGE(zzduh.MESSAGE, 2),
    BYTES(zzduh.BYTE_STRING, 2),
    UINT32(zzduh.INT, 0),
    ENUM(zzduh.ENUM, 0),
    SFIXED32(zzduh.INT, 5),
    SFIXED64(zzduh.LONG, 1),
    SINT32(zzduh.INT, 0),
    SINT64(zzduh.LONG, 0);
    
    private final zzduh zzhqj;
    private final int zzhqk;

    private zzdue(zzduh zzduh, int i) {
        this.zzhqj = zzduh;
        this.zzhqk = i;
    }

    public final zzduh zzbcg() {
        return this.zzhqj;
    }

    public final int zzbch() {
        return this.zzhqk;
    }
}
