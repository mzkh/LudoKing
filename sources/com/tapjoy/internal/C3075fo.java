package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.TapjoyUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.fo */
public final class C3075fo {

    /* renamed from: a */
    public final C1820a f7249a;

    /* renamed from: b */
    public final String f7250b;

    /* renamed from: c */
    public final String f7251c;

    /* renamed from: d */
    public final String f7252d;

    /* renamed from: e */
    private final String f7253e;

    /* renamed from: f */
    private final int f7254f;

    /* renamed from: com.tapjoy.internal.fo$a */
    public enum C1820a {
        SDK_ANDROID(2),
        RPC_ANALYTICS(49);
        

        /* renamed from: a */
        public byte f3783a;

        private C1820a(byte b) {
            this.f3783a = b;
        }

        @Nullable
        /* renamed from: a */
        public static C1820a m3510a(byte b) {
            C1820a[] values;
            for (C1820a aVar : values()) {
                if (aVar.f3783a == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C3075fo(String str) {
        int length = str.length();
        String str2 = "The given API key was malformed.";
        if (!str.matches("[A-Za-z0-9\\-_]*") || length < 60 || (length & 3) != 0) {
            throw new IllegalArgumentException(str2);
        }
        try {
            byte[] decode = Base64.decode(str, 8);
            int length2 = decode.length;
            ByteBuffer wrap = ByteBuffer.wrap(decode);
            wrap.order(ByteOrder.BIG_ENDIAN);
            int length3 = decode.length - 4;
            int i = wrap.getInt(length3);
            CRC32 crc32 = new CRC32();
            crc32.update(decode, 0, length3);
            int value = (int) crc32.getValue();
            String str3 = "The given API key was invalid.";
            if (i == value) {
                this.f7253e = str;
                this.f7250b = new UUID(wrap.getLong(0), wrap.getLong(8)).toString();
                this.f7254f = wrap.get(16);
                this.f7249a = C1820a.m3510a(wrap.get(17));
                this.f7251c = str.substring(24, 44);
                int i2 = this.f7254f;
                if (i2 == 1) {
                    this.f7252d = null;
                } else if (i2 != 2 || this.f7249a != C1820a.SDK_ANDROID) {
                    throw new IllegalArgumentException("The given API key was not supported.");
                } else if (length2 >= 57) {
                    byte[] bArr = new byte[12];
                    System.arraycopy(decode, 33, bArr, 0, 12);
                    this.f7252d = TapjoyUtil.convertToHex(bArr);
                } else {
                    throw new IllegalArgumentException(str3);
                }
            } else {
                throw new IllegalArgumentException(str3);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(str2, e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C3075fo) {
            return this.f7253e.equals(((C3075fo) obj).f7253e);
        }
        return false;
    }

    public final String toString() {
        return this.f7253e;
    }

    /* renamed from: a */
    public static String m7101a(String str) {
        if (str.regionMatches(13, "-8000-8000-", 0, 11)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 8));
            stringBuffer.append(str.substring(24, 30));
            stringBuffer.append(str.substring(9, 13));
            stringBuffer.append(str.substring(30));
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
    }
}
