package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;

@Class(creator = "MessageCreator")
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Message> CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    private static final zzgs[] zzeu = {zzgs.zzgv};
    @Field(getter = "getContent", mo15151id = 1)
    private final byte[] content;
    @Field(getter = "getNamespace", mo15151id = 3)
    private final String namespace;
    @Field(getter = "getType", mo15151id = 2)
    private final String type;
    @VersionField(mo15157id = 1000)
    private final int versionCode;
    @Field(mo15151id = 4)
    @Deprecated
    private final zzgs[] zzev;
    @Field(getter = "getProjectId", mo15151id = 5)
    private final long zzew;

    @Constructor
    Message(@Param(mo15154id = 1000) int i, @Param(mo15154id = 1) @Nullable byte[] bArr, @Param(mo15154id = 3) @Nullable String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 4) @Nullable zzgs[] zzgsArr, @Param(mo15154id = 5) long j) {
        this.versionCode = i;
        this.type = (String) Preconditions.checkNotNull(str2);
        if (str == null) {
            str = "";
        }
        this.namespace = str;
        this.zzew = j;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        this.content = bArr;
        if (zzgsArr == null || zzgsArr.length == 0) {
            zzgsArr = zzeu;
        }
        this.zzev = zzgsArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), Integer.valueOf(32));
    }

    public Message(byte[] bArr) {
        String str = "";
        this(bArr, str, str);
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, zzeu);
    }

    private Message(byte[] bArr, String str, String str2, zzgs[] zzgsArr) {
        this(bArr, str, str2, zzgsArr, 0);
    }

    private Message(byte[] bArr, String str, String str2, zzgs[] zzgsArr, long j) {
        this(2, bArr, str, str2, zzgsArr, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.namespace, message.namespace) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content) && this.zzew == message.zzew;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hashCode(this.namespace, this.type, Integer.valueOf(Arrays.hashCode(this.content)), Long.valueOf(this.zzew));
    }

    public String toString() {
        String str = this.namespace;
        String str2 = this.type;
        byte[] bArr = this.content;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59 + String.valueOf(str2).length());
        sb.append("Message{namespace='");
        sb.append(str);
        sb.append("', type='");
        sb.append(str2);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzev, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzew);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzl(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }
}
