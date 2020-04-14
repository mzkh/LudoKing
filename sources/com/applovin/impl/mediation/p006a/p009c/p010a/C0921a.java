package com.applovin.impl.mediation.p006a.p009c.p010a;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.applovin.impl.adview.C0799a;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p009c.p010a.C0926b.C0928a;
import com.applovin.impl.mediation.p006a.p009c.p012b.C0929a;
import com.applovin.impl.sdk.C1061a;
import com.applovin.impl.sdk.utils.C1239a;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.sdk.C1314R;

/* renamed from: com.applovin.impl.mediation.a.c.a.a */
public class C0921a extends Activity {

    /* renamed from: a */
    private C0926b f1731a;

    /* renamed from: b */
    private DataSetObserver f1732b;

    /* renamed from: c */
    private FrameLayout f1733c;

    /* renamed from: d */
    private ListView f1734d;

    /* renamed from: e */
    private C0799a f1735e;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1478a() {
        startActivity(new Intent(this, MaxDebuggerDetailActivity.class));
    }

    /* renamed from: b */
    private void m1480b() {
        m1482c();
        this.f1735e = new C0799a(this, 50, 16842874);
        this.f1735e.setColor(-3355444);
        this.f1733c.addView(this.f1735e, new LayoutParams(-1, -1, 17));
        this.f1733c.bringChildToFront(this.f1735e);
        this.f1735e.mo8994a();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1482c() {
        C0799a aVar = this.f1735e;
        if (aVar != null) {
            aVar.mo8995b();
            this.f1733c.removeView(this.f1735e);
            this.f1735e = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(C1314R.layout.mediation_debugger_activity);
        this.f1733c = (FrameLayout) findViewById(16908290);
        this.f1734d = (ListView) findViewById(C1314R.C1316id.listView);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f1731a.unregisterDataSetObserver(this.f1732b);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f1734d.setAdapter(this.f1731a);
        if (!this.f1731a.mo9363a()) {
            m1480b();
        }
    }

    public void setListAdapter(C0926b bVar, final C1061a aVar) {
        C0926b bVar2 = this.f1731a;
        if (bVar2 != null) {
            DataSetObserver dataSetObserver = this.f1732b;
            if (dataSetObserver != null) {
                bVar2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1731a = bVar;
        this.f1732b = new DataSetObserver() {
            public void onChanged() {
                C0921a.this.m1482c();
            }
        };
        this.f1731a.registerDataSetObserver(this.f1732b);
        this.f1731a.mo9361a((C0928a) new C0928a() {
            /* renamed from: a */
            public void mo9358a(final C0913c cVar) {
                aVar.mo9736a(new C1239a() {
                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof C0929a) {
                            aVar.mo9737b(this);
                        }
                    }

                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof C0929a) {
                            ((C0929a) activity).setNetwork(cVar);
                        }
                    }
                });
                C0921a.this.m1478a();
            }
        });
    }
}
