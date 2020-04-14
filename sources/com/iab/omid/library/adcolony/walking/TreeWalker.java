package com.iab.omid.library.adcolony.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.adcolony.p027c.C2039a;
import com.iab.omid.library.adcolony.p027c.C2039a.C2040a;
import com.iab.omid.library.adcolony.p027c.C2041b;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.p028d.C2048d;
import com.iab.omid.library.adcolony.p028d.C2050f;
import com.iab.omid.library.adcolony.walking.p030a.C2065c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements C2040a {

    /* renamed from: a */
    private static TreeWalker f4066a = new TreeWalker();

    /* renamed from: b */
    private static Handler f4067b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f4068c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f4069j = new Runnable() {
        public void run() {
            TreeWalker.getInstance().m3888h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f4070k = new Runnable() {
        public void run() {
            if (TreeWalker.f4068c != null) {
                TreeWalker.f4068c.post(TreeWalker.f4069j);
                TreeWalker.f4068c.postDelayed(TreeWalker.f4070k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f4071d = new ArrayList();

    /* renamed from: e */
    private int f4072e;

    /* renamed from: f */
    private C2041b f4073f = new C2041b();

    /* renamed from: g */
    private C2060a f4074g = new C2060a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2069b f4075h = new C2069b(new C2065c());

    /* renamed from: i */
    private long f4076i;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m3880a(long j) {
        if (this.f4071d.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f4071d) {
                treeWalkerTimeLogger.onTreeProcessed(this.f4072e, TimeUnit.NANOSECONDS.toMillis(j));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f4072e, j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3881a(View view, C2039a aVar, JSONObject jSONObject, C2070c cVar) {
        aVar.mo27426a(view, jSONObject, this, cVar == C2070c.PARENT_VIEW);
    }

    /* renamed from: a */
    private boolean m3882a(View view, JSONObject jSONObject) {
        String a = this.f4074g.mo27464a(view);
        if (a == null) {
            return false;
        }
        C2045b.m3824a(jSONObject, a);
        this.f4074g.mo27471e();
        return true;
    }

    /* renamed from: b */
    private void m3883b(View view, JSONObject jSONObject) {
        ArrayList b = this.f4074g.mo27466b(view);
        if (b != null) {
            C2045b.m3826a(jSONObject, (List<String>) b);
        }
    }

    public static TreeWalker getInstance() {
        return f4066a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m3888h() {
        m3889i();
        mo27457d();
        m3890j();
    }

    /* renamed from: i */
    private void m3889i() {
        this.f4072e = 0;
        this.f4076i = C2048d.m3837a();
    }

    /* renamed from: j */
    private void m3890j() {
        m3880a(C2048d.m3837a() - this.f4076i);
    }

    /* renamed from: k */
    private void m3891k() {
        if (f4068c == null) {
            f4068c = new Handler(Looper.getMainLooper());
            f4068c.post(f4069j);
            f4068c.postDelayed(f4070k, 200);
        }
    }

    /* renamed from: l */
    private void m3892l() {
        Handler handler = f4068c;
        if (handler != null) {
            handler.removeCallbacks(f4070k);
            f4068c = null;
        }
    }

    /* renamed from: a */
    public void mo27453a() {
        m3891k();
    }

    /* renamed from: a */
    public void mo27427a(View view, C2039a aVar, JSONObject jSONObject) {
        if (C2050f.m3854d(view)) {
            C2070c c = this.f4074g.mo27468c(view);
            if (c != C2070c.UNDERLYING_VIEW) {
                JSONObject a = aVar.mo27425a(view);
                C2045b.m3827a(jSONObject, a);
                if (!m3882a(view, a)) {
                    m3883b(view, a);
                    m3881a(view, aVar, a, c);
                }
                this.f4072e++;
            }
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f4071d.contains(treeWalkerTimeLogger)) {
            this.f4071d.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo27455b() {
        mo27456c();
        this.f4071d.clear();
        f4067b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f4075h.mo27486a();
            }
        });
    }

    /* renamed from: c */
    public void mo27456c() {
        m3892l();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: d */
    public void mo27457d() {
        this.f4074g.mo27469c();
        long a = C2048d.m3837a();
        C2039a a2 = this.f4073f.mo27428a();
        if (this.f4074g.mo27467b().size() > 0) {
            this.f4075h.mo27488b(a2.mo27425a(null), this.f4074g.mo27467b(), a);
        }
        if (this.f4074g.mo27465a().size() > 0) {
            JSONObject a3 = a2.mo27425a(null);
            m3881a(null, a2, a3, C2070c.PARENT_VIEW);
            C2045b.m3823a(a3);
            this.f4075h.mo27487a(a3, this.f4074g.mo27465a(), a);
        } else {
            this.f4075h.mo27486a();
        }
        this.f4074g.mo27470d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f4071d.contains(treeWalkerTimeLogger)) {
            this.f4071d.remove(treeWalkerTimeLogger);
        }
    }
}
