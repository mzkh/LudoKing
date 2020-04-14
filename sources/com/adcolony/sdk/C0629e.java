package com.adcolony.sdk;

import java.util.HashMap;

/* renamed from: com.adcolony.sdk.e */
class C0629e {

    /* renamed from: a */
    String f648a;

    /* renamed from: b */
    private HashMap<Integer, Boolean> f649b = new HashMap<>();

    /* renamed from: c */
    private C0507an f650c;

    /* renamed from: d */
    private C0478aa f651d;

    /* renamed from: e */
    private int f652e;

    C0629e(String str, int i) {
        this.f648a = str;
        this.f652e = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8527a(C0480ab abVar) {
        if (this.f650c == null) {
            this.f650c = new C0507an(this.f648a, this.f652e);
            this.f651d = new C0478aa(this.f648a, this.f652e);
        }
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        if (C0746u.m918d(abVar.mo8220c(), "use_sound_pool")) {
            this.f649b.put(Integer.valueOf(c), Boolean.valueOf(true));
            this.f650c.mo8305a(abVar);
            return;
        }
        this.f649b.put(Integer.valueOf(c), Boolean.valueOf(false));
        this.f651d.mo8205a(abVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8526a() {
        this.f650c.mo8304a().autoPause();
        this.f651d.mo8204a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8528b() {
        this.f650c.mo8304a().autoResume();
        this.f651d.mo8206b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8529b(C0480ab abVar) {
        if (((Boolean) this.f649b.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).booleanValue()) {
            this.f650c.mo8308d(abVar);
        } else {
            this.f651d.mo8207b(abVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8531c(C0480ab abVar) {
        if (((Boolean) this.f649b.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).booleanValue()) {
            this.f650c.mo8307c(abVar);
        } else {
            this.f651d.mo8209c(abVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8533d(C0480ab abVar) {
        if (((Boolean) this.f649b.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).booleanValue()) {
            this.f650c.mo8306b(abVar);
        } else {
            this.f651d.mo8210d(abVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8534e(C0480ab abVar) {
        if (((Boolean) this.f649b.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).booleanValue()) {
            this.f650c.mo8309e(abVar);
        } else {
            this.f651d.mo8211e(abVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0478aa mo8530c() {
        return this.f651d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C0507an mo8532d() {
        return this.f650c;
    }
}
