package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzoc {
    public byte[] data;
    private int limit;
    private int position;

    public zzoc() {
    }

    public zzoc(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public zzoc(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public final void reset(int i) {
        zzb(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void zzb(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final int zzim() {
        return this.limit - this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final void zzbf(int i) {
        zznr.checkArgument(i >= 0 && i <= this.data.length);
        this.limit = i;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final void zzbg(int i) {
        zznr.checkArgument(i >= 0 && i <= this.limit);
        this.position = i;
    }

    public final void zzbh(int i) {
        zzbg(this.position + i);
    }

    public final void zze(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    public final int zzin() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        byte b = bArr[i] & 255;
        int i2 = this.position;
        this.position = i2 + 1;
        return ((bArr[i2] & 255) << 8) | b;
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    public final long zzio() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i2 = this.position;
        this.position = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.position;
        this.position = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.position;
        this.position = i4 + 1;
        return j3 | (255 & ((long) bArr[i4]));
    }

    public final long zzip() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.position;
        this.position = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.position;
        this.position = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.position;
        this.position = i4 + 1;
        return j3 | ((255 & ((long) bArr[i4])) << 24);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.position;
        this.position = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << 16);
        int i4 = this.position;
        this.position = i4 + 1;
        byte b2 = b | ((bArr[i4] & 255) << 8);
        int i5 = this.position;
        this.position = i5 + 1;
        return (bArr[i5] & 255) | b2;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i2 = this.position;
        this.position = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.position;
        this.position = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.position;
        this.position = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.position;
        this.position = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.position;
        this.position = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.position;
        this.position = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.position;
        this.position = i8 + 1;
        return j7 | (255 & ((long) bArr[i8]));
    }

    public final int zziq() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.position;
        this.position = i3 + 1;
        byte b = (bArr[i3] & 255) | i2;
        this.position += 2;
        return b;
    }

    public final int zzir() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzis() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzbi(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.position + i) - 1;
        String str = new String(this.data, this.position, (i2 >= this.limit || this.data[i2] != 0) ? i : i - 1);
        this.position += i;
        return str;
    }
}
