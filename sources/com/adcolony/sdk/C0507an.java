package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.HashMap;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.adcolony.sdk.an */
class C0507an {

    /* renamed from: a */
    final String f309a;

    /* renamed from: b */
    private final int f310b;

    /* renamed from: c */
    private HashMap<Integer, Integer> f311c = new HashMap<>();

    /* renamed from: d */
    private HashMap<Integer, Integer> f312d = new HashMap<>();

    /* renamed from: e */
    private HashMap<Integer, Boolean> f313e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HashMap<Integer, Integer> f314f = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public HashMap<Integer, Integer> f315g = new HashMap<>();

    /* renamed from: h */
    private HashMap<String, Integer> f316h = new HashMap<>();

    /* renamed from: i */
    private SoundPool f317i;

    C0507an(final String str, final int i) {
        this.f309a = str;
        this.f310b = i;
        this.f317i = new SoundPool(50, 3, 0);
        this.f317i.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                JSONObject a = C0746u.m892a();
                C0746u.m912b(a, "id", ((Integer) C0507an.this.f314f.get(Integer.valueOf(i))).intValue());
                C0746u.m902a(a, "ad_session_id", str);
                if (i2 == 0) {
                    new C0480ab("AudioPlayer.on_ready", i, a).mo8217b();
                    C0507an.this.f315g.put(C0507an.this.f314f.get(Integer.valueOf(i)), Integer.valueOf(i));
                    return;
                }
                new C0480ab("AudioPlayer.on_error", i, a).mo8217b();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8305a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        int load = this.f317i.load(C0746u.m908b(c, "filepath"), 1);
        int i = C0746u.m918d(c, "repeats") ? -1 : 0;
        this.f314f.put(Integer.valueOf(load), Integer.valueOf(C0746u.m914c(c, "id")));
        new C0749a().mo8726a("Load audio with id = ").mo8724a(load).mo8728a(C0748w.f1168d);
        this.f312d.put(Integer.valueOf(load), Integer.valueOf(i));
        this.f313e.put(Integer.valueOf(load), Boolean.valueOf(false));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8306b(C0480ab abVar) {
        this.f317i.unload(((Integer) this.f315g.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).intValue());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8307c(C0480ab abVar) {
        String str = "id";
        int intValue = ((Integer) this.f315g.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), str)))).intValue();
        if (!((Boolean) this.f313e.get(Integer.valueOf(intValue))).booleanValue()) {
            int play = this.f317i.play(intValue, 1.0f, 1.0f, 0, ((Integer) this.f312d.get(Integer.valueOf(intValue))).intValue(), 1.0f);
            if (play != 0) {
                this.f311c.put(Integer.valueOf(intValue), Integer.valueOf(play));
                return;
            }
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, str, C0746u.m914c(abVar.mo8220c(), str));
            C0746u.m902a(a, "ad_session_id", this.f309a);
            new C0480ab("AudioPlayer.on_error", this.f310b, a).mo8217b();
            return;
        }
        this.f317i.resume(((Integer) this.f311c.get(Integer.valueOf(intValue))).intValue());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8308d(C0480ab abVar) {
        int intValue = ((Integer) this.f315g.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id")))).intValue();
        this.f317i.pause(((Integer) this.f311c.get(Integer.valueOf(intValue))).intValue());
        this.f313e.put(Integer.valueOf(intValue), Boolean.valueOf(true));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8309e(C0480ab abVar) {
        this.f317i.stop(((Integer) this.f311c.get(this.f315g.get(Integer.valueOf(C0746u.m914c(abVar.mo8220c(), "id"))))).intValue());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public SoundPool mo8304a() {
        return this.f317i;
    }
}
