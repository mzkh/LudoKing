package com.iab.omid.library.inmobi.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.inmobi.p033c.C2087a;
import com.iab.omid.library.inmobi.p033c.C2087a.C2088a;
import com.iab.omid.library.inmobi.p033c.C2089b;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.p034d.C2096d;
import com.iab.omid.library.inmobi.p034d.C2098f;
import com.iab.omid.library.inmobi.walking.p036a.C2113c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C2088a {

    /* renamed from: a */
    private static TreeWalker f4166a = new TreeWalker();

    /* renamed from: b */
    private static Handler f4167b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f4168c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f4169j = new Runnable() {
        public final void run() {
            TreeWalker.getInstance().m4096h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f4170k = new Runnable() {
        public final void run() {
            if (TreeWalker.f4168c != null) {
                TreeWalker.f4168c.post(TreeWalker.f4169j);
                TreeWalker.f4168c.postDelayed(TreeWalker.f4170k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f4171d = new ArrayList();

    /* renamed from: e */
    private int f4172e;

    /* renamed from: f */
    private C2089b f4173f = new C2089b();

    /* renamed from: g */
    private C2108a f4174g = new C2108a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2117b f4175h = new C2117b(new C2113c());

    /* renamed from: i */
    private long f4176i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m4087a(long j) {
        if (this.f4171d.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f4171d) {
                treeWalkerTimeLogger.onTreeProcessed(this.f4172e, TimeUnit.NANOSECONDS.toMillis(j));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f4172e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m4088a(View view, C2087a aVar, JSONObject jSONObject, C2118c cVar) {
        aVar.mo27589a(view, jSONObject, this, cVar == C2118c.PARENT_VIEW);
    }

    /* renamed from: a */
    private void m4089a(String str, View view, JSONObject jSONObject) {
        C2087a b = this.f4173f.mo27592b();
        String a = this.f4174g.mo27629a(str);
        if (a != null) {
            JSONObject a2 = b.mo27588a(view);
            C2093b.m4029a(a2, str);
            C2093b.m4035b(a2, a);
            C2093b.m4032a(jSONObject, a2);
        }
    }

    /* renamed from: a */
    private boolean m4090a(View view, JSONObject jSONObject) {
        String a = this.f4174g.mo27628a(view);
        if (a == null) {
            return false;
        }
        C2093b.m4029a(jSONObject, a);
        this.f4174g.mo27637e();
        return true;
    }

    /* renamed from: b */
    private void m4091b(View view, JSONObject jSONObject) {
        ArrayList b = this.f4174g.mo27632b(view);
        if (b != null) {
            C2093b.m4031a(jSONObject, (List<String>) b);
        }
    }

    public static TreeWalker getInstance() {
        return f4166a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m4096h() {
        m4097i();
        mo27621d();
        m4098j();
    }

    /* renamed from: i */
    private void m4097i() {
        this.f4172e = 0;
        this.f4176i = C2096d.m4043a();
    }

    /* renamed from: j */
    private void m4098j() {
        m4087a(C2096d.m4043a() - this.f4176i);
    }

    /* renamed from: k */
    private void m4099k() {
        if (f4168c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f4168c = handler;
            handler.post(f4169j);
            f4168c.postDelayed(f4170k, 200);
        }
    }

    /* renamed from: l */
    private void m4100l() {
        Handler handler = f4168c;
        if (handler != null) {
            handler.removeCallbacks(f4170k);
            f4168c = null;
        }
    }

    /* renamed from: a */
    public void mo27617a() {
        m4099k();
    }

    /* renamed from: a */
    public void mo27590a(View view, C2087a aVar, JSONObject jSONObject) {
        if (C2098f.m4060d(view)) {
            C2118c c = this.f4174g.mo27634c(view);
            if (c != C2118c.UNDERLYING_VIEW) {
                JSONObject a = aVar.mo27588a(view);
                C2093b.m4032a(jSONObject, a);
                if (!m4090a(view, a)) {
                    m4091b(view, a);
                    m4088a(view, aVar, a, c);
                }
                this.f4172e++;
            }
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f4171d.contains(treeWalkerTimeLogger)) {
            this.f4171d.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo27619b() {
        mo27620c();
        this.f4171d.clear();
        f4167b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f4175h.mo27652a();
            }
        });
    }

    /* renamed from: c */
    public void mo27620c() {
        m4100l();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: d */
    public void mo27621d() {
        this.f4174g.mo27635c();
        long a = C2096d.m4043a();
        C2087a a2 = this.f4173f.mo27591a();
        if (this.f4174g.mo27633b().size() > 0) {
            Iterator it = this.f4174g.mo27633b().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a3 = a2.mo27588a(null);
                m4089a(str, this.f4174g.mo27631b(str), a3);
                C2093b.m4028a(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.f4175h.mo27654b(a3, hashSet, a);
            }
        }
        if (this.f4174g.mo27630a().size() > 0) {
            JSONObject a4 = a2.mo27588a(null);
            m4088a(null, a2, a4, C2118c.PARENT_VIEW);
            C2093b.m4028a(a4);
            this.f4175h.mo27653a(a4, this.f4174g.mo27630a(), a);
        } else {
            this.f4175h.mo27652a();
        }
        this.f4174g.mo27636d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f4171d.contains(treeWalkerTimeLogger)) {
            this.f4171d.remove(treeWalkerTimeLogger);
        }
    }
}
