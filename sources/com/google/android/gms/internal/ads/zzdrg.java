package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public class zzdrg extends IOException {
    private zzdsg zzhlo = null;

    public zzdrg(String str) {
        super(str);
    }

    public final zzdrg zzo(zzdsg zzdsg) {
        this.zzhlo = zzdsg;
        return this;
    }

    static zzdrg zzbac() {
        return new zzdrg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzdrg zzbad() {
        return new zzdrg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzdrg zzbae() {
        return new zzdrg("CodedInputStream encountered a malformed varint.");
    }

    static zzdrg zzbaf() {
        return new zzdrg("Protocol message contained an invalid tag (zero).");
    }

    static zzdrg zzbag() {
        return new zzdrg("Protocol message end-group tag did not match expected tag.");
    }

    static zzdrf zzbah() {
        return new zzdrf("Protocol message tag had invalid wire type.");
    }

    static zzdrg zzbai() {
        return new zzdrg("Failed to parse the message.");
    }

    static zzdrg zzbaj() {
        return new zzdrg("Protocol message had invalid UTF-8.");
    }
}
