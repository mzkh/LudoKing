package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
@Class(creator = "ProxyRequestCreator")
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    @Field(mo15151id = 4)
    public final byte[] body;
    @Field(mo15151id = 2)
    public final int httpMethod;
    @Field(mo15151id = 3)
    public final long timeoutMillis;
    @Field(mo15151id = 1)
    public final String url;
    @VersionField(mo15157id = 1000)
    private final int versionCode;
    @Field(mo15151id = 5)
    private Bundle zzby;

    @KeepForSdkWithMembers
    public static class Builder {
        private String zzbz;
        private int zzca = ProxyRequest.HTTP_METHOD_GET;
        private long zzcb = 3000;
        private byte[] zzcc = null;
        private Bundle zzcd = new Bundle();

        public Builder(String str) {
            Preconditions.checkNotEmpty(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzbz = str;
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
            sb.append("The supplied url [ ");
            sb.append(str);
            sb.append("] is not match Patterns.WEB_URL!");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setHttpMethod(int i) {
            Preconditions.checkArgument(i >= 0 && i <= ProxyRequest.LAST_CODE, "Unrecognized http method code.");
            this.zzca = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            Preconditions.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.zzcb = j;
            return this;
        }

        public Builder putHeader(String str, String str2) {
            Preconditions.checkNotEmpty(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzcd;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzcc = bArr;
            return this;
        }

        public ProxyRequest build() {
            if (this.zzcc == null) {
                this.zzcc = new byte[0];
            }
            ProxyRequest proxyRequest = new ProxyRequest(2, this.zzbz, this.zzca, this.zzcb, this.zzcc, this.zzcd);
            return proxyRequest;
        }
    }

    @Constructor
    ProxyRequest(@Param(mo15154id = 1000) int i, @Param(mo15154id = 1) String str, @Param(mo15154id = 2) int i2, @Param(mo15154id = 3) long j, @Param(mo15154id = 4) byte[] bArr, @Param(mo15154id = 5) Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzby = bundle;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzby.size());
        for (String str : this.zzby.keySet()) {
            linkedHashMap.put(str, this.zzby.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        int i = this.httpMethod;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i);
        sb.append(" ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeInt(parcel, 2, this.httpMethod);
        SafeParcelWriter.writeLong(parcel, 3, this.timeoutMillis);
        SafeParcelWriter.writeByteArray(parcel, 4, this.body, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zzby, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
