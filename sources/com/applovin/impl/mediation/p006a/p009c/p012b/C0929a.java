package com.applovin.impl.mediation.p006a.p009c.p012b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.ListView;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p009c.p012b.C0934b.C0935a;
import com.applovin.sdk.C1314R;

/* renamed from: com.applovin.impl.mediation.a.c.b.a */
public class C0929a extends Activity {

    /* renamed from: a */
    private ListView f1750a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1314R.layout.mediation_debugger_detail_activity);
        this.f1750a = (ListView) findViewById(C1314R.C1316id.listView);
    }

    public void setNetwork(C0913c cVar) {
        setTitle(cVar.mo9325d());
        C0934b bVar = new C0934b(cVar, this);
        bVar.mo9383a((C0935a) new C0935a() {
            /* renamed from: a */
            public void mo9368a(String str) {
                new Builder(C0929a.this, 16974130).setTitle(C1314R.string.applovin_instructions_dialog_title).setMessage(str).setNegativeButton(17039370, null).create().show();
            }
        });
        this.f1750a.setAdapter(bVar);
    }
}
