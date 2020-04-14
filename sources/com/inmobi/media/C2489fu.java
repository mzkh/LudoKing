package com.inmobi.media;

import java.io.IOException;
import java.net.SocketTimeoutException;

/* renamed from: com.inmobi.media.fu */
/* compiled from: VastBitRateNetworkConnection */
public final class C2489fu extends C2484fp {
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ C2487fs mo28405a() {
        return super.mo28405a();
    }

    public C2489fu(C2486fr frVar) {
        super(frVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C2487fs mo28406b() {
        C2487fs fsVar = new C2487fs();
        try {
            this.f5426c.getResponseCode();
            fsVar.f5453b = this.f5426c.getContentLength();
            this.f5426c.disconnect();
        } catch (SocketTimeoutException unused) {
            fsVar.f5452a = new C2485fq(504, "HTTP_GATEWAY_TIMEOUT");
        } catch (IOException unused2) {
            fsVar.f5452a = new C2485fq(-2, "NETWORK_IO_ERROR");
        } catch (OutOfMemoryError unused3) {
            fsVar.f5452a = new C2485fq(-3, "OUT_OF_MEMORY_ERROR");
        } catch (Exception unused4) {
            fsVar.f5452a = new C2485fq(-1, "UNKNOWN_ERROR");
        } catch (Throwable th) {
            this.f5426c.disconnect();
            throw th;
        }
        return fsVar;
    }
}
