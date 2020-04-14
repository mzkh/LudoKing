package com.tapjoy.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hd */
public final class C1836hd {

    /* renamed from: a */
    private final File f3847a;

    public C1836hd(File file) {
        this.f3847a = file;
    }

    /* renamed from: a */
    public final synchronized boolean mo18171a() {
        FileOutputStream fileOutputStream;
        if (mo18172b() != null) {
            return false;
        }
        try {
            File file = this.f3847a;
            String uuid = UUID.randomUUID().toString();
            fileOutputStream = new FileOutputStream(file);
            C1810bg.m3459a((OutputStream) fileOutputStream, uuid);
            C1854jz.m3672a(fileOutputStream);
            if (mo18172b() != null) {
                return true;
            }
            return false;
        } catch (IOException e) {
            try {
                this.f3847a.delete();
                throw e;
            } catch (IOException unused) {
                return false;
            }
        } catch (Throwable th) {
            C1854jz.m3672a(fileOutputStream);
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: b */
    public final String mo18172b() {
        if (this.f3847a.exists()) {
            try {
                String a = C1810bg.m3458a(this.f3847a, C2873ak.f6671c);
                if (a.length() > 0) {
                    return a;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
