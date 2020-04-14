package com.inmobi.media;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.be */
/* compiled from: NativeContainerAsset */
public final class C2216be extends C2214bc implements Iterable<C2214bc> {

    /* renamed from: A */
    public int f4557A;
    /* access modifiers changed from: 0000 */

    /* renamed from: B */
    public C2214bc[] f4558B;
    /* access modifiers changed from: 0000 */

    /* renamed from: C */
    public int f4559C;

    /* renamed from: z */
    public long f4560z;

    /* renamed from: com.inmobi.media.be$a */
    /* compiled from: NativeContainerAsset */
    class C2217a implements Iterator<C2214bc> {

        /* renamed from: b */
        private int f4562b = 0;

        public C2217a() {
        }

        public final boolean hasNext() {
            return this.f4562b < C2216be.this.f4559C;
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final /* synthetic */ Object next() {
            C2214bc[] b = C2216be.this.f4558B;
            int i = this.f4562b;
            this.f4562b = i + 1;
            return b[i];
        }
    }

    public final Iterator<C2214bc> iterator() {
        return new C2217a();
    }

    public C2216be(String str, String str2, C2215bd bdVar, int i, JSONObject jSONObject, int i2) {
        this(str, str2, bdVar, new LinkedList(), i, jSONObject, i2);
    }

    public C2216be(String str, String str2, C2215bd bdVar, List<C2234bo> list, int i, JSONObject jSONObject, int i2) {
        super(str, str2, "CONTAINER", bdVar, list);
        this.f4560z = 0;
        this.f4526f = jSONObject;
        this.f4558B = new C2214bc[1];
        this.f4529i = i;
        this.f4559C = 0;
        this.f4557A = i2;
    }

    /* renamed from: a */
    public final boolean mo27951a() {
        return "root".equalsIgnoreCase(this.f4524d);
    }

    /* renamed from: b */
    public final boolean mo27952b() {
        return "card_scrollable".equalsIgnoreCase(this.f4524d);
    }

    /* renamed from: a */
    public final C2214bc mo27950a(int i) {
        if (i < 0 || i >= this.f4559C) {
            return null;
        }
        return this.f4558B[i];
    }
}
