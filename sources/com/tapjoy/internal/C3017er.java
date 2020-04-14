package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.er */
public abstract class C3017er {

    /* renamed from: c */
    private static final C3017er f6945c;

    /* renamed from: d */
    private static C3017er f6946d;

    /* renamed from: a */
    protected volatile boolean f6947a = false;

    /* renamed from: b */
    protected volatile boolean f6948b = false;

    /* renamed from: a */
    public abstract TJPlacement mo30022a(String str, TJPlacementListener tJPlacementListener);

    /* renamed from: a */
    public abstract void mo30023a(float f);

    /* renamed from: a */
    public abstract void mo30024a(int i);

    /* renamed from: a */
    public abstract void mo30025a(int i, TJAwardCurrencyListener tJAwardCurrencyListener);

    /* renamed from: a */
    public abstract void mo30026a(int i, TJSpendCurrencyListener tJSpendCurrencyListener);

    /* renamed from: a */
    public abstract void mo30027a(int i, String str);

    /* renamed from: a */
    public abstract void mo30028a(Activity activity);

    /* renamed from: a */
    public abstract void mo30029a(Context context, Map map);

    /* renamed from: a */
    public abstract void mo30030a(GLSurfaceView gLSurfaceView);

    /* renamed from: a */
    public abstract void mo30031a(TJEarnedCurrencyListener tJEarnedCurrencyListener);

    /* renamed from: a */
    public abstract void mo30032a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener);

    /* renamed from: a */
    public abstract void mo30033a(TJVideoListener tJVideoListener);

    /* renamed from: a */
    public abstract void mo30034a(String str);

    /* renamed from: a */
    public abstract void mo30035a(String str, long j);

    /* renamed from: a */
    public abstract void mo30036a(String str, TJSetUserIDListener tJSetUserIDListener);

    /* renamed from: a */
    public abstract void mo30037a(String str, String str2);

    /* renamed from: a */
    public abstract void mo30038a(String str, String str2, double d, String str3);

    /* renamed from: a */
    public abstract void mo30039a(String str, String str2, long j);

    /* renamed from: a */
    public abstract void mo30040a(String str, String str2, String str3, String str4);

    /* renamed from: a */
    public abstract void mo30041a(String str, String str2, String str3, String str4, long j);

    /* renamed from: a */
    public abstract void mo30042a(String str, String str2, String str3, String str4, String str5, long j);

    /* renamed from: a */
    public abstract void mo30043a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2);

    /* renamed from: a */
    public abstract void mo30044a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3);

    /* renamed from: a */
    public abstract void mo30045a(String str, String str2, String str3, String str4, Map map);

    /* renamed from: a */
    public abstract void mo30046a(Set set);

    /* renamed from: a */
    public abstract void mo30047a(boolean z);

    /* renamed from: a */
    public abstract boolean mo30048a(Context context, String str);

    /* renamed from: a */
    public abstract boolean mo30049a(Context context, String str, TJConnectListener tJConnectListener);

    /* renamed from: a */
    public abstract boolean mo30050a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    /* renamed from: b */
    public abstract TJPlacement mo30051b(String str, TJPlacementListener tJPlacementListener);

    /* renamed from: b */
    public abstract String mo30052b();

    /* renamed from: b */
    public abstract void mo30053b(int i);

    /* renamed from: b */
    public abstract void mo30054b(Activity activity);

    /* renamed from: b */
    public abstract void mo30055b(String str);

    /* renamed from: b */
    public abstract void mo30056b(String str, String str2, String str3, String str4);

    /* renamed from: b */
    public abstract void mo30057b(boolean z);

    /* renamed from: c */
    public abstract float mo30058c();

    /* renamed from: c */
    public abstract void mo30059c(Activity activity);

    /* renamed from: c */
    public abstract void mo30060c(String str);

    /* renamed from: c */
    public abstract void mo30061c(boolean z);

    /* renamed from: d */
    public abstract void mo30062d();

    /* renamed from: d */
    public abstract void mo30063d(String str);

    /* renamed from: d */
    public abstract void mo30064d(boolean z);

    /* renamed from: e */
    public abstract void mo30065e();

    /* renamed from: e */
    public abstract void mo30066e(String str);

    /* renamed from: f */
    public abstract Set mo30067f();

    /* renamed from: f */
    public abstract void mo30068f(String str);

    /* renamed from: g */
    public abstract String mo30069g(String str);

    /* renamed from: g */
    public abstract void mo30070g();

    /* renamed from: h */
    public abstract void mo30071h(String str);

    /* renamed from: h */
    public abstract boolean mo30072h();

    /* renamed from: i */
    public abstract void mo30073i(String str);

    /* renamed from: i */
    public abstract boolean mo30074i();

    /* renamed from: j */
    public abstract void mo30075j(String str);

    /* renamed from: j */
    public abstract boolean mo30076j();

    /* renamed from: k */
    public abstract String mo30077k();

    /* renamed from: l */
    public abstract String mo30078l();

    C3017er() {
    }

    static {
        C3086fx.m7117a();
        C3076fp.m7102a();
        C3021et etVar = new C3021et();
        f6945c = etVar;
        f6946d = etVar;
    }

    /* renamed from: a */
    public static C3017er m6904a() {
        return f6946d;
    }
}
