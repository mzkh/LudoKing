package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bc */
/* compiled from: NativeAsset */
public class C2214bc {

    /* renamed from: z */
    private static final String f4520z = "bc";

    /* renamed from: a */
    String f4521a;

    /* renamed from: b */
    public String f4522b;

    /* renamed from: c */
    public C2215bd f4523c;

    /* renamed from: d */
    public String f4524d;

    /* renamed from: e */
    public Object f4525e;

    /* renamed from: f */
    JSONObject f4526f;

    /* renamed from: g */
    String f4527g;

    /* renamed from: h */
    public boolean f4528h;

    /* renamed from: i */
    public int f4529i;

    /* renamed from: j */
    public String f4530j;

    /* renamed from: k */
    public int f4531k;

    /* renamed from: l */
    public int f4532l;

    /* renamed from: m */
    public int f4533m;

    /* renamed from: n */
    int f4534n;

    /* renamed from: o */
    public int f4535o;

    /* renamed from: p */
    public int f4536p;

    /* renamed from: q */
    String f4537q;

    /* renamed from: r */
    public String f4538r;

    /* renamed from: s */
    public String f4539s;

    /* renamed from: t */
    public C2214bc f4540t;

    /* renamed from: u */
    public List<C2234bo> f4541u;

    /* renamed from: v */
    public Map<String, Object> f4542v;

    /* renamed from: w */
    public Object f4543w;

    /* renamed from: x */
    public int f4544x;

    /* renamed from: y */
    public C2214bc f4545y;

    public C2214bc() {
        this("", "root", "CONTAINER", new C2215bd());
    }

    public C2214bc(String str, String str2, String str3, C2215bd bdVar) {
        this(str, str2, str3, bdVar, new LinkedList());
    }

    public C2214bc(String str, String str2, String str3, C2215bd bdVar, List<C2234bo> list) {
        this.f4521a = str;
        this.f4524d = str2;
        this.f4522b = str3;
        this.f4523c = bdVar;
        this.f4525e = null;
        String str4 = "";
        this.f4527g = str4;
        this.f4528h = false;
        this.f4529i = 0;
        this.f4530j = str4;
        this.f4532l = 0;
        this.f4531k = 0;
        this.f4533m = 0;
        this.f4534n = 2;
        this.f4544x = 0;
        this.f4535o = -1;
        this.f4537q = str4;
        this.f4538r = str4;
        this.f4526f = new JSONObject();
        this.f4541u = new LinkedList();
        this.f4541u.addAll(list);
        this.f4542v = new HashMap();
    }

    /* renamed from: a */
    public final void mo27940a(String str, @Nullable Map<String, String> map) {
        if (this.f4541u.size() != 0) {
            for (C2234bo boVar : this.f4541u) {
                if (str.equals(boVar.f4631d)) {
                    m4470a(boVar, map);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27941a(List<C2234bo> list) {
        this.f4541u.addAll(list);
    }

    /* renamed from: a */
    public final void mo27939a(String str) {
        this.f4538r = str.trim();
    }

    /* renamed from: b */
    public final void mo27942b(@NonNull String str) {
        this.f4539s = str.trim();
    }

    /* renamed from: a */
    public static void m4470a(@NonNull C2234bo boVar, @Nullable Map<String, String> map) {
        C2185as.m4434a().mo27908a(C2515gi.m5347a(boVar.f4629b, map), boVar.f4632e, true);
    }
}
