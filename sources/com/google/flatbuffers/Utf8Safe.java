package com.google.flatbuffers;

import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Unpaired surrogate at index ");
            sb.append(i);
            sb.append(" of ");
            sb.append(i2);
            super(sb.toString());
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = charSequence.charAt(i);
            if (charAt >= 2048) {
                i2 += encodedLengthGeneral(charSequence, i);
                break;
            }
            i2 += (127 - charAt) >>> 31;
            i++;
        }
        if (i2 >= length) {
            return i2;
        }
        long j = ((long) i2) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new UnpairedSurrogateException(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    private static String decodeUtf8Array(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r12 < i3) {
                byte b = bArr[r12];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i = r12 + 1;
                int i5 = i4 + 1;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4 = i5;
            }
            int i6 = i4;
            while (r12 < i3) {
                int i7 = r12 + 1;
                byte b2 = bArr[r12];
                if (DecodeUtil.isOneByte(b2)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    while (i7 < i3) {
                        byte b3 = bArr[i7];
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i7++;
                        int i9 = i8 + 1;
                        DecodeUtil.handleOneByte(b3, cArr, i8);
                        i8 = i9;
                    }
                    r12 = i7;
                    i6 = i8;
                } else {
                    String str = "Invalid UTF-8";
                    if (DecodeUtil.isTwoBytes(b2)) {
                        if (i7 < i3) {
                            int i10 = i7 + 1;
                            int i11 = i6 + 1;
                            DecodeUtil.handleTwoBytes(b2, bArr[i7], cArr, i6);
                            r12 = i10;
                            i6 = i11;
                        } else {
                            throw new IllegalArgumentException(str);
                        }
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i7 < i3 - 1) {
                            int i12 = i7 + 1;
                            int i13 = i12 + 1;
                            int i14 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, bArr[i7], bArr[i12], cArr, i6);
                            r12 = i13;
                            i6 = i14;
                        } else {
                            throw new IllegalArgumentException(str);
                        }
                    } else if (i7 < i3 - 2) {
                        int i15 = i7 + 1;
                        byte b4 = bArr[i7];
                        int i16 = i15 + 1;
                        int i17 = i16 + 1;
                        int i18 = i6 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, bArr[i15], bArr[i16], cArr, i6);
                        r12 = i17;
                        i6 = i18 + 1;
                    } else {
                        throw new IllegalArgumentException(str);
                    }
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    private static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r12 < i3) {
                byte b = byteBuffer.get(r12);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i = r12 + 1;
                int i5 = i4 + 1;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4 = i5;
            }
            int i6 = i4;
            while (r12 < i3) {
                int i7 = r12 + 1;
                byte b2 = byteBuffer.get(r12);
                if (DecodeUtil.isOneByte(b2)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b2, cArr, i6);
                    while (i7 < i3) {
                        byte b3 = byteBuffer.get(i7);
                        if (!DecodeUtil.isOneByte(b3)) {
                            break;
                        }
                        i7++;
                        int i9 = i8 + 1;
                        DecodeUtil.handleOneByte(b3, cArr, i8);
                        i8 = i9;
                    }
                    r12 = i7;
                    i6 = i8;
                } else {
                    String str = "Invalid UTF-8";
                    if (DecodeUtil.isTwoBytes(b2)) {
                        if (i7 < i3) {
                            int i10 = i7 + 1;
                            int i11 = i6 + 1;
                            DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i7), cArr, i6);
                            r12 = i10;
                            i6 = i11;
                        } else {
                            throw new IllegalArgumentException(str);
                        }
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i7 < i3 - 1) {
                            int i12 = i7 + 1;
                            int i13 = i12 + 1;
                            int i14 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i7), byteBuffer.get(i12), cArr, i6);
                            r12 = i13;
                            i6 = i14;
                        } else {
                            throw new IllegalArgumentException(str);
                        }
                    } else if (i7 < i3 - 2) {
                        int i15 = i7 + 1;
                        byte b4 = byteBuffer.get(i7);
                        int i16 = i15 + 1;
                        int i17 = i16 + 1;
                        int i18 = i6 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, byteBuffer.get(i15), byteBuffer.get(i16), cArr, i6);
                        r12 = i17;
                        i6 = i18 + 1;
                    } else {
                        throw new IllegalArgumentException(str);
                    }
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return decodeUtf8Buffer(byteBuffer, i, i2);
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i2, (byte) charAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                int position2 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                char charAt2 = charSequence.charAt(i2);
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(position2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
        }
        if (i2 == length) {
            byteBuffer.position(position + i2);
            return;
        }
        position += i2;
        while (i2 < length) {
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                i = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i, (byte) ((charAt3 & '?') | 128));
                    position = i;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i;
                    int position22 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                    char charAt22 = charSequence.charAt(i2);
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Failed writing ");
                    sb2.append(charAt22);
                    sb2.append(" at index ");
                    sb2.append(position22);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else if (charAt3 < 55296 || 57343 < charAt3) {
                i = position + 1;
                byteBuffer.put(position, (byte) ((charAt3 >>> 12) | 224));
                position = i + 1;
                byteBuffer.put(i, (byte) (((charAt3 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
            } else {
                int i3 = i2 + 1;
                if (i3 != length) {
                    try {
                        char charAt4 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            int i4 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                position = i4 + 1;
                                byteBuffer.put(i4, (byte) (((codePoint >>> 12) & 63) | 128));
                                i4 = position + 1;
                                byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i4, (byte) ((codePoint & 63) | 128));
                                position = i4;
                                i2 = i3;
                            } catch (IndexOutOfBoundsException unused3) {
                                position = i4;
                                i2 = i3;
                                int position222 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                                char charAt222 = charSequence.charAt(i2);
                                StringBuilder sb22 = new StringBuilder(37);
                                sb22.append("Failed writing ");
                                sb22.append(charAt222);
                                sb22.append(" at index ");
                                sb22.append(position222);
                                throw new ArrayIndexOutOfBoundsException(sb22.toString());
                            }
                        } else {
                            i2 = i3;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i2 = i3;
                        int position2222 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                        char charAt2222 = charSequence.charAt(i2);
                        StringBuilder sb222 = new StringBuilder(37);
                        sb222.append("Failed writing ");
                        sb222.append(charAt2222);
                        sb222.append(" at index ");
                        sb222.append(position2222);
                        throw new ArrayIndexOutOfBoundsException(sb222.toString());
                    }
                }
                throw new UnpairedSurrogateException(i2, length);
            }
            i2++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = i2 + i;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + i;
            if (i6 >= i4) {
                break;
            }
            char charAt = charSequence.charAt(i5);
            if (charAt >= 128) {
                break;
            }
            bArr[i6] = (byte) charAt;
            i5++;
        }
        if (i5 == length) {
            return i + length;
        }
        int i7 = i + i5;
        while (i5 < length) {
            char charAt2 = charSequence.charAt(i5);
            if (charAt2 < 128 && i7 < i4) {
                i3 = i7 + 1;
                bArr[i7] = (byte) charAt2;
            } else if (charAt2 < 2048 && i7 <= i4 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
                i5++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i4 - 3) {
                int i9 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
            } else if (i7 <= i4 - 4) {
                int i11 = i5 + 1;
                if (i11 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i11);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i12 = i7 + 1;
                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 = i14 + 1;
                        bArr[i14] = (byte) ((codePoint & 63) | 128);
                        i5 = i11;
                        i5++;
                    } else {
                        i5 = i11;
                    }
                }
                throw new UnpairedSurrogateException(i5 - 1, length);
            } else {
                if (55296 <= charAt2 && charAt2 <= 57343) {
                    int i15 = i5 + 1;
                    if (i15 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i15))) {
                        throw new UnpairedSurrogateException(i5, length);
                    }
                }
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i7);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            i7 = i3;
            i5++;
        }
        return i7;
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }
}
