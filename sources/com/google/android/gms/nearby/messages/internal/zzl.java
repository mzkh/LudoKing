package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class zzl extends zzc {
    public zzl(UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
        int i = 0;
        int i2 = (sh == null ? 0 : 2) + 16;
        if (sh2 != null) {
            i = 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + i);
        allocate.putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
        if (sh != null) {
            allocate.putShort(sh.shortValue());
        }
        if (sh2 != null) {
            allocate.putShort(sh2.shortValue());
        }
        this(allocate.array());
    }

    public zzl(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        super(bArr);
    }

    public final UUID getProximityUuid() {
        ByteBuffer wrap = ByteBuffer.wrap(getBytes());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public final String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        String valueOf2 = String.valueOf(zzaf());
        String valueOf3 = String.valueOf(zzag());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("IBeaconIdPrefix{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append(valueOf2);
        sb.append(", minor=");
        sb.append(valueOf3);
        sb.append('}');
        return sb.toString();
    }

    public final Short zzaf() {
        byte[] bytes = getBytes();
        if (bytes.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(16));
        }
        return null;
    }

    public final Short zzag() {
        byte[] bytes = getBytes();
        if (bytes.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(18));
        }
        return null;
    }
}
