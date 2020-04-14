package com.tapjoy.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.hl */
public final class C1838hl implements Flushable {

    /* renamed from: a */
    final Object f3853a = this;

    /* renamed from: b */
    C2886ax f3854b;

    /* renamed from: c */
    private final File f3855c;

    public C1838hl(File file) {
        this.f3855c = file;
        try {
            this.f3854b = C2883au.m6583a((C2886ax) new C3090g(file, new C2892bd() {
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ void mo18182a(OutputStream outputStream, Object obj) {
                    C3026ev.f6973c.mo29993a(outputStream, (Object) (C3026ev) obj);
                }

                /* renamed from: b */
                public final /* synthetic */ Object mo18183b(InputStream inputStream) {
                    return (C3026ev) C3026ev.f6973c.mo29990a(inputStream);
                }
            }));
        } catch (Exception unused) {
            mo18176a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18176a() {
        this.f3855c.delete();
        C2886ax axVar = this.f3854b;
        if (axVar instanceof Closeable) {
            try {
                ((Closeable) axVar).close();
            } catch (Exception unused) {
            }
        }
        this.f3854b = new C2884av(new LinkedList());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void flush() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3853a
            monitor-enter(r0)
            com.tapjoy.internal.ax r1 = r2.f3854b     // Catch:{ all -> 0x0016 }
            boolean r1 = r1 instanceof java.io.Flushable     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0014
            com.tapjoy.internal.ax r1 = r2.f3854b     // Catch:{ Exception -> 0x0011 }
            java.io.Flushable r1 = (java.io.Flushable) r1     // Catch:{ Exception -> 0x0011 }
            r1.flush()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r2.mo18176a()     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1838hl.flush():void");
    }

    /* renamed from: b */
    public final int mo18178b() {
        int size;
        synchronized (this.f3853a) {
            try {
                size = this.f3854b.size();
            } catch (Exception unused) {
                mo18176a();
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    /* renamed from: c */
    public final boolean mo18180c() {
        boolean isEmpty;
        synchronized (this.f3853a) {
            try {
                isEmpty = this.f3854b.isEmpty();
            } catch (Exception unused) {
                mo18176a();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return isEmpty;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18177a(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3853a
            monitor-enter(r0)
            com.tapjoy.internal.ax r1 = r2.f3854b     // Catch:{ Exception -> 0x000b }
            r1.mo29818b(r3)     // Catch:{ Exception -> 0x000b }
            goto L_0x000e
        L_0x0009:
            r3 = move-exception
            goto L_0x0010
        L_0x000b:
            r2.mo18176a()     // Catch:{ all -> 0x0009 }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0010:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1838hl.mo18177a(int):void");
    }

    @Nullable
    /* renamed from: b */
    public final C3026ev mo18179b(int i) {
        C3026ev evVar;
        synchronized (this.f3853a) {
            try {
                evVar = (C3026ev) this.f3854b.mo29817a(i);
            } catch (Exception unused) {
                mo18176a();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return evVar;
    }
}
