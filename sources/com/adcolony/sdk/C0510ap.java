package com.adcolony.sdk;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.adcolony.sdk.ap */
class C0510ap extends InputStream {

    /* renamed from: a */
    InputStream f328a;

    /* renamed from: b */
    int f329b;

    C0510ap(InputStream inputStream, int i, int i2) throws IOException {
        this.f328a = inputStream;
        while (i > 0) {
            i -= (int) inputStream.skip((long) i);
        }
        this.f329b = i2;
    }

    public int available() throws IOException {
        int available = this.f328a.available();
        int i = this.f329b;
        return available <= i ? available : i;
    }

    public void close() throws IOException {
        this.f328a.close();
    }

    public int read() throws IOException {
        int i = this.f329b;
        if (i == 0) {
            return -1;
        }
        this.f329b = i - 1;
        return this.f328a.read();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f329b;
        if (i3 == 0) {
            return -1;
        }
        if (i2 > i3) {
            i2 = i3;
        }
        int read = this.f328a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.f329b -= read;
        return read;
    }

    public long skip(long j) throws IOException {
        int i = (int) j;
        if (i <= 0) {
            return 0;
        }
        int i2 = this.f329b;
        if (i > i2) {
            i = i2;
        }
        this.f329b -= i;
        while (i > 0) {
            i -= (int) this.f328a.skip(j);
        }
        return j;
    }
}
