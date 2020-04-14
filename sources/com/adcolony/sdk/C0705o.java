package com.adcolony.sdk;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.o */
class C0705o implements C0704a {

    /* renamed from: a */
    private BlockingQueue<Runnable> f1058a = new LinkedBlockingQueue();

    /* renamed from: b */
    private ThreadPoolExecutor f1059b;

    /* renamed from: c */
    private LinkedList<C0703n> f1060c;

    /* renamed from: d */
    private String f1061d;

    C0705o() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 16, 60, TimeUnit.SECONDS, this.f1058a);
        this.f1059b = threadPoolExecutor;
        this.f1060c = new LinkedList<>();
        this.f1061d = C0476a.m77a().mo8579m().mo8616G();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8668a() {
        C0476a.m81a("WebServices.download", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0705o oVar = C0705o.this;
                oVar.mo8670a(new C0703n(abVar, oVar));
            }
        });
        C0476a.m81a("WebServices.get", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0705o oVar = C0705o.this;
                oVar.mo8670a(new C0703n(abVar, oVar));
            }
        });
        C0476a.m81a("WebServices.post", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0705o oVar = C0705o.this;
                oVar.mo8670a(new C0703n(abVar, oVar));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8670a(C0703n nVar) {
        if (this.f1061d.equals("")) {
            this.f1060c.push(nVar);
            return;
        }
        try {
            this.f1059b.execute(nVar);
        } catch (RejectedExecutionException unused) {
            C0749a a = new C0749a().mo8726a("RejectedExecutionException: ThreadPoolExecutor unable to ");
            StringBuilder sb = new StringBuilder();
            sb.append("execute download for url ");
            sb.append(nVar.f1042a);
            a.mo8726a(sb.toString()).mo8728a(C0748w.f1172h);
            mo8554a(nVar, nVar.mo8666a(), null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8671a(String str) {
        this.f1061d = str;
        while (!this.f1060c.isEmpty()) {
            mo8670a((C0703n) this.f1060c.removeLast());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8669a(int i) {
        this.f1059b.setCorePoolSize(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo8672b() {
        return this.f1059b.getCorePoolSize();
    }

    /* renamed from: a */
    public void mo8554a(C0703n nVar, C0480ab abVar, Map<String, List<String>> map) {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "url", nVar.f1042a);
        C0746u.m913b(a, "success", nVar.f1044c);
        C0746u.m912b(a, "status", nVar.f1046e);
        C0746u.m902a(a, "body", nVar.f1043b);
        C0746u.m912b(a, "size", nVar.f1045d);
        if (map != null) {
            JSONObject a2 = C0746u.m892a();
            for (Entry entry : map.entrySet()) {
                String obj = ((List) entry.getValue()).toString();
                String substring = obj.substring(1, obj.length() - 1);
                if (entry.getKey() != null) {
                    C0746u.m902a(a2, (String) entry.getKey(), substring);
                }
            }
            C0746u.m904a(a, "headers", a2);
        }
        abVar.mo8216a(a).mo8217b();
    }
}
