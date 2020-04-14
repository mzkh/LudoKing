package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import com.google.android.gms.internal.ads.zzbo.zza.zzd;
import com.google.android.gms.internal.ads.zzbo.zza.zze;
import com.google.android.gms.internal.ads.zzbo.zza.zze.C3502zza;
import com.google.android.gms.internal.ads.zzbo.zzf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdd extends zzdb {
    private static final String TAG = zzdd.class.getSimpleName();
    private static long startTime = 0;
    private static final Object zzwm = new Object();
    @VisibleForTesting
    private static boolean zzwn = false;
    protected boolean zzwo = false;
    private String zzwp;
    private boolean zzwq = false;
    private boolean zzwr = false;
    @VisibleForTesting
    private zzeg zzws;

    protected static synchronized void zza(Context context, boolean z) {
        synchronized (zzdd.class) {
            if (!zzwn) {
                startTime = System.currentTimeMillis() / 1000;
                zzvo = zzb(context, z);
                zzwn = true;
            }
        }
    }

    protected zzdd(Context context, String str, boolean z) {
        super(context);
        this.zzwp = str;
        this.zzwo = z;
    }

    protected zzdd(Context context, String str) {
        super(context);
        this.zzwp = str;
        this.zzwo = false;
    }

    private static zzdx zzb(Context context, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (zzvo == null) {
            synchronized (zzwm) {
                if (zzvo == null) {
                    zzdx zza = zzdx.zza(context, "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", z);
                    if (zza.isInitialized()) {
                        try {
                            z2 = ((Boolean) zzuv.zzon().zzd(zzza.zzcng)).booleanValue();
                        } catch (IllegalStateException unused) {
                            z2 = false;
                        }
                        if (z2) {
                            zza.zza("OevwuCyaBOVW9Ln+QX7fmyTTWbeJYcctGFCVTrXabQZ00sMfUmORvoOrZvhdRFVu", "TTGXRr2x4uLkjJPzQqm9kQskRo6Bo/N0qnlRgwhhknY=", new Class[0]);
                        }
                        zza.zza("1ZdlqvbjLHrlsj3y/9QBfBegKjUOs/o1A88UhYHQ4Jmy6BR/w0ghZ+Zr+YvoOH1m", "dIiWdqkuIrENjYXIlbMEe8d+ulqMtIBUuOR2KqmaBXc=", Context.class);
                        zza.zza("Czcr3yoY+pOKNODh2xT/FExa1SgsokPEePN5uXEMMoBW0cGikmkROODxowoOsIp5", "g9mysso6zH+elh8p2e3D0ucSvZboI1XRhESOWGeKrb4=", Context.class);
                        zza.zza("A+Q531BKZvfOeka4SSbIi98VRx3EvZeq3QcPAJig4b7/SJvJ4/TtTO+lCbnRqGZl", "zAXEiWGEMeBKPZCR0+Wk6A1K9nuND23TP+R43DeQ+JU=", Context.class);
                        zza.zza("O8rdkeMt5QoFNXJjW5QCfqYHYGa3mIfQI8CtBHwRmKoACknsbs4GGEE8fxnP5Yoy", "y+6hRaNMOGZhxSEedIl6KIpCNfA+vCFiKY9NAV8mv+M=", Context.class);
                        zza.zza("/U7lmoo91nlZ7CXs6EZAlBe4BS4a6Z9kIAqe+P2iZJXpWpucrABhslj/SpsYf6UV", "8phKyaz1GoNRBjdWkSPTH2EdpboiSfEibzQDoMxa8iY=", Context.class);
                        zza.zza("nPtzXSuU+qktnQkvD2Xhs8JhAWT03LQKh81HOymmhvaoBKzMtF1OqdTJn8I7ucyF", "zhTEaWf7N42ZX9XmpP+4WCaO87v5SAeTw81eS1XA4J4=", Context.class, Boolean.TYPE);
                        zza.zza("KVf06HR7LPRikwiUfdTCx0mR6lQ6oD0cDNWgtFganKEt0/oWeDMOhKuhW5MRwMPD", "f1zzBLr4Ds3qcB254ff+50uMW8nPULjA7RwfsMVqI7c=", Context.class);
                        zza.zza("rQmNAvxV4vUoXR0mMGYmLq9kAz9hDSoWR6yW2mczJH/c1hwjoR2CytKuR1XsoVho", "UpBY2ygeAK8qQ/jcW8L/0QJFFFip/WVGN2rq8flo4XY=", Context.class);
                        zza.zza("PfrEPb9rkoh4YJv2k7z9eC1OOXKri4Htzh1daqageEAa/Sukv93d134hnOpe8LFJ", "aSngTEYgwbSNKtFDzGNVIPuaMxxip43dXpd3nqNhNDc=", MotionEvent.class, DisplayMetrics.class);
                        zza.zza("4CdHFNYn5+c7AqMUB3qcITbVVCzzl788RQr8Q4uzAkZY6SjUZkIle9XX2m/8SmAI", "6MGBhcJM4bOqwWqGpT84v31UdYzks0tzvKG9JKP/JQ0=", MotionEvent.class, DisplayMetrics.class);
                        zza.zza("VXSVTWR5Q+Ql8nXd4ut1JTezdQTLyI9FL7W8NEKmv/ItF/EDabkr4MBOi18woU3o", "VPraLoovAHYOuU235McwsGBEthfwRlWhFzo09VwWfl8=", new Class[0]);
                        zza.zza("K2/o+yAeqOodXeLaliXkB/bmVo77YUZhyjPZ3XrrktN0ZqTNHicrfht9z3HyXSe6", "aJGQaLbp+D+3UiIyM1/58due9U6jZk73iOFEX8NymCE=", new Class[0]);
                        zza.zza("HB5hYpdDWWYPh8xjN/QMHSxBjnwrp91Q0UtK22xocqDpB0ky3Wln7efw6pam/GSb", "ti8Ym9/GEvxZE4gtPT1thSzvv3O2aWq5eDV8JrekaaQ=", new Class[0]);
                        zza.zza("ooJom7dhqsxzDvdeCG2cyC1tpeJNdbuwb31K8yrc3wIgeaHvm0jDQT8Y8hGczjcb", "j0OZITyHdX/L7+h6G/PyfgyeIqmZjGFxucjFV0SvysA=", new Class[0]);
                        zza.zza("jmsbTB23xBLXME1jUq4dTCZC3vHB+dVGB+ZP9+XsjFXJC7mIgp/JquONQgJ7AafS", "C++mzV4T+5ygJv6fsvu2zXYbGtzexRODdJ/B8Ay4Mrs=", new Class[0]);
                        zza.zza("FyU+rja/Lh1W7P/TLff9RYGhiCqg1F5N3fOvWg9l7fHZgotHJX11povIsnBak2fF", "cnWGFsigIN8LFZbQ7IHZler9sjWFBvyae72txGefDK0=", new Class[0]);
                        zza.zza("ve6lIfiITbdrZNoHCmfLiAlzX5pPzJeaYnSSxy++wkSqNqbcrTpeErH1kColsxwx", "VngvQQcVMO0hOftCpXBS5wVmRur5LuW5LroOBg3kU7A=", Context.class, Boolean.TYPE, Boolean.TYPE);
                        zza.zza("zlXUbZgbgwMaill5zgr8cd+zhL4CR8d3/y4U9qW3Aw2OUvMVDO9t0Rnk5UYg4PTz", "Udr7bQcn2LirgawBycwQ/uCvupHUBlSX53Ja+V/IxxU=", StackTraceElement[].class);
                        zza.zza("Q2kZQx3np/22iVvQtL8L6W+o3vBz1XWm/QTajzST0NWOo4ixVRxZbvPz0yneh1nu", "qjI/8KPz1x7tjaYpddn89GzQJQmhUHZolABfXHNafT0=", View.class, DisplayMetrics.class, Boolean.TYPE);
                        zza.zza("6dUJX9gtL2a0L+9p2soQN/OuWpIGg61GD5R5KL8bP7g7V/7DN27jVbYstkRsHcmF", "daXoc8IpLGqF4MzYKY6HBt032uHqphAROK9tARIFd9k=", Context.class, Boolean.TYPE);
                        zza.zza("gaJwYHuOGuVfXnns5P0fkK/Ainj7ch3o9l9YBuU+BJ22PLUxYS8nRJcrYkzX0qQ+", "dWTLVEHJimYYNfpcruwSnR52ji7jgxLgQ8VHTKaDFpw=", View.class, Activity.class, Boolean.TYPE);
                        zza.zza("Nuw1pNdarBc/cDLvOqEZPcvh4V2z+egOoZiSN4ZnvUSQnq2+ggEgklwBenBh8zkM", "JVwKStyDRx2cYm27U37fG1PrLLhBeDlEDYBB9Vent0s=", Long.TYPE);
                        try {
                            z3 = ((Boolean) zzuv.zzon().zzd(zzza.zzcnm)).booleanValue();
                        } catch (IllegalStateException unused2) {
                            z3 = false;
                        }
                        if (z3) {
                            zza.zza("4tb1v2ElfR8UyWjlJ8orXMTpsLMppPETu4yaaVf2oDCSpuG1mbnohI9eDOl8W68j", "4NDnMkWQ2AITPVsDE6SIAZtRT6WXMdxRr+93MsYOTsY=", Context.class);
                        }
                        try {
                            z4 = ((Boolean) zzuv.zzon().zzd(zzza.zzcnn)).booleanValue();
                        } catch (IllegalStateException unused3) {
                            z4 = false;
                        }
                        if (z4) {
                            zza.zza("cDMky5n2Id54MSxb7Tg5DrrZJmf6qZKx7SCLf/q0EKjGnvmAeeZMtBzP8TQYnWVR", "vrGUZJwgLt62AqnzGwuU+h35ttDGCqwjX3529c+lI4E=", Context.class);
                        }
                    }
                    zzvo = zza;
                }
            }
        }
        return zzvo;
    }

    private static zzef zza(zzdx zzdx, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzdw {
        Method zzc = zzdx.zzc("PfrEPb9rkoh4YJv2k7z9eC1OOXKri4Htzh1daqageEAa/Sukv93d134hnOpe8LFJ", "aSngTEYgwbSNKtFDzGNVIPuaMxxip43dXpd3nqNhNDc=");
        if (zzc == null || motionEvent == null) {
            throw new zzdw();
        }
        try {
            return new zzef((String) zzc.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdw(e);
        }
    }

    /* access modifiers changed from: protected */
    public final zzb zza(Context context, zza zza) {
        zzb zzal = zzbo.zza.zzal();
        if (!TextUtils.isEmpty(this.zzwp)) {
            zzal.zzaa(this.zzwp);
        }
        zzb(zzb(context, this.zzwo), context, zzal, zza);
        if (zza != null && zza.zzv()) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcnc)).booleanValue() && !zzee.zzat(zza.zzw().zzae())) {
                zzal.zzb((zzf) ((zzdqw) zzf.zzbh().zzai(zza.zzw().zzae()).zzazr()));
            }
        }
        return zzal;
    }

    /* access modifiers changed from: protected */
    public zzb zzb(Context context, View view, Activity activity) {
        zzb zzaa = zzbo.zza.zzal().zzaa(this.zzwp);
        zza(zzb(context, this.zzwo), zzaa, view, activity, false);
        return zzaa;
    }

    /* access modifiers changed from: protected */
    public zzb zza(Context context, View view, Activity activity) {
        zzb zzal = zzbo.zza.zzal();
        if (!TextUtils.isEmpty(this.zzwp)) {
            zzal.zzaa(this.zzwp);
        }
        zza(zzb(context, this.zzwo), zzal, view, activity, true);
        return zzal;
    }

    /* access modifiers changed from: protected */
    public List<Callable<Void>> zza(zzdx zzdx, Context context, zzb zzb, zza zza) {
        int zzbz = zzdx.zzbz();
        ArrayList arrayList = new ArrayList();
        if (!zzdx.isInitialized()) {
            zzb.zzau((long) zzd.PSN_INITIALIZATION_FAIL.zzab());
            return arrayList;
        }
        zzb zzb2 = zzb;
        zzdx zzdx2 = zzdx;
        zzb zzb3 = zzb;
        zzem zzem = new zzem(zzdx2, "ve6lIfiITbdrZNoHCmfLiAlzX5pPzJeaYnSSxy++wkSqNqbcrTpeErH1kColsxwx", "VngvQQcVMO0hOftCpXBS5wVmRur5LuW5LroOBg3kU7A=", zzb3, zzbz, 27, context, zza);
        arrayList.add(zzem);
        zzeq zzeq = new zzeq(zzdx2, "VXSVTWR5Q+Ql8nXd4ut1JTezdQTLyI9FL7W8NEKmv/ItF/EDabkr4MBOi18woU3o", "VPraLoovAHYOuU235McwsGBEthfwRlWhFzo09VwWfl8=", zzb3, startTime, zzbz, 25);
        arrayList.add(zzeq);
        int i = zzbz;
        zzew zzew = new zzew(zzdx2, "HB5hYpdDWWYPh8xjN/QMHSxBjnwrp91Q0UtK22xocqDpB0ky3Wln7efw6pam/GSb", "ti8Ym9/GEvxZE4gtPT1thSzvv3O2aWq5eDV8JrekaaQ=", zzb3, i, 1);
        arrayList.add(zzew);
        zzfb zzfb = new zzfb(zzdx2, "A+Q531BKZvfOeka4SSbIi98VRx3EvZeq3QcPAJig4b7/SJvJ4/TtTO+lCbnRqGZl", "zAXEiWGEMeBKPZCR0+Wk6A1K9nuND23TP+R43DeQ+JU=", zzb3, i, 31);
        arrayList.add(zzfb);
        zzfe zzfe = new zzfe(zzdx2, "K2/o+yAeqOodXeLaliXkB/bmVo77YUZhyjPZ3XrrktN0ZqTNHicrfht9z3HyXSe6", "aJGQaLbp+D+3UiIyM1/58due9U6jZk73iOFEX8NymCE=", zzb3, i, 33);
        arrayList.add(zzfe);
        zzen zzen = new zzen(zzdx2, "Czcr3yoY+pOKNODh2xT/FExa1SgsokPEePN5uXEMMoBW0cGikmkROODxowoOsIp5", "g9mysso6zH+elh8p2e3D0ucSvZboI1XRhESOWGeKrb4=", zzb3, i, 29, context);
        arrayList.add(zzen);
        zzeo zzeo = new zzeo(zzdx2, "O8rdkeMt5QoFNXJjW5QCfqYHYGa3mIfQI8CtBHwRmKoACknsbs4GGEE8fxnP5Yoy", "y+6hRaNMOGZhxSEedIl6KIpCNfA+vCFiKY9NAV8mv+M=", zzb3, i, 5);
        arrayList.add(zzeo);
        zzex zzex = new zzex(zzdx2, "/U7lmoo91nlZ7CXs6EZAlBe4BS4a6Z9kIAqe+P2iZJXpWpucrABhslj/SpsYf6UV", "8phKyaz1GoNRBjdWkSPTH2EdpboiSfEibzQDoMxa8iY=", zzb3, i, 12);
        arrayList.add(zzex);
        zzez zzez = new zzez(zzdx2, "nPtzXSuU+qktnQkvD2Xhs8JhAWT03LQKh81HOymmhvaoBKzMtF1OqdTJn8I7ucyF", "zhTEaWf7N42ZX9XmpP+4WCaO87v5SAeTw81eS1XA4J4=", zzb3, i, 3);
        arrayList.add(zzez);
        zzer zzer = new zzer(zzdx2, "ooJom7dhqsxzDvdeCG2cyC1tpeJNdbuwb31K8yrc3wIgeaHvm0jDQT8Y8hGczjcb", "j0OZITyHdX/L7+h6G/PyfgyeIqmZjGFxucjFV0SvysA=", zzb3, i, 44);
        arrayList.add(zzer);
        zzev zzev = new zzev(zzdx2, "jmsbTB23xBLXME1jUq4dTCZC3vHB+dVGB+ZP9+XsjFXJC7mIgp/JquONQgJ7AafS", "C++mzV4T+5ygJv6fsvu2zXYbGtzexRODdJ/B8Ay4Mrs=", zzb3, i, 22);
        arrayList.add(zzev);
        zzfh zzfh = new zzfh(zzdx2, "KVf06HR7LPRikwiUfdTCx0mR6lQ6oD0cDNWgtFganKEt0/oWeDMOhKuhW5MRwMPD", "f1zzBLr4Ds3qcB254ff+50uMW8nPULjA7RwfsMVqI7c=", zzb3, i, 48);
        arrayList.add(zzfh);
        zzek zzek = new zzek(zzdx2, "rQmNAvxV4vUoXR0mMGYmLq9kAz9hDSoWR6yW2mczJH/c1hwjoR2CytKuR1XsoVho", "UpBY2ygeAK8qQ/jcW8L/0QJFFFip/WVGN2rq8flo4XY=", zzb3, i, 49);
        arrayList.add(zzek);
        zzfc zzfc = new zzfc(zzdx2, "FyU+rja/Lh1W7P/TLff9RYGhiCqg1F5N3fOvWg9l7fHZgotHJX11povIsnBak2fF", "cnWGFsigIN8LFZbQ7IHZler9sjWFBvyae72txGefDK0=", zzb3, i, 51);
        arrayList.add(zzfc);
        zzfa zzfa = new zzfa(zzdx2, "6dUJX9gtL2a0L+9p2soQN/OuWpIGg61GD5R5KL8bP7g7V/7DN27jVbYstkRsHcmF", "daXoc8IpLGqF4MzYKY6HBt032uHqphAROK9tARIFd9k=", zzb3, i, 61);
        arrayList.add(zzfa);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnn)).booleanValue()) {
            zzeu zzeu = new zzeu(zzdx, "cDMky5n2Id54MSxb7Tg5DrrZJmf6qZKx7SCLf/q0EKjGnvmAeeZMtBzP8TQYnWVR", "vrGUZJwgLt62AqnzGwuU+h35ttDGCqwjX3529c+lI4E=", zzb, zzbz, 11);
            arrayList.add(zzeu);
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnm)).booleanValue()) {
            zzey zzey = new zzey(zzdx, "4tb1v2ElfR8UyWjlJ8orXMTpsLMppPETu4yaaVf2oDCSpuG1mbnohI9eDOl8W68j", "4NDnMkWQ2AITPVsDE6SIAZtRT6WXMdxRr+93MsYOTsY=", zzb, zzbz, 73);
            arrayList.add(zzey);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void zzb(zzdx zzdx, Context context, zzb zzb, zza zza) {
        if (zzdx.zzce() != null) {
            zza(zza(zzdx, context, zzb, zza));
        }
    }

    private final void zza(zzdx zzdx, zzb zzb, View view, Activity activity, boolean z) {
        List list;
        Long l;
        zzdx zzdx2 = zzdx;
        zzb zzb2 = zzb;
        if (!zzdx.isInitialized()) {
            zzb2.zzau((long) zzd.PSN_INITIALIZATION_FAIL.zzab());
            list = Arrays.asList(new Callable[]{new zzes(zzdx2, zzb2)});
        } else {
            try {
                zzef zza = zza(zzdx2, this.zzvt, this.zzwl);
                if (zza.zzyq != null) {
                    zzb2.zzaq(zza.zzyq.longValue());
                }
                if (zza.zzyr != null) {
                    zzb2.zzar(zza.zzyr.longValue());
                }
                if (zza.zzys != null) {
                    zzb2.zzas(zza.zzys.longValue());
                }
                if (this.zzwk) {
                    if (zza.zzyt != null) {
                        zzb2.zzbb(zza.zzyt.longValue());
                    }
                    if (zza.zzyu != null) {
                        zzb2.zzbc(zza.zzyu.longValue());
                    }
                }
            } catch (zzdw unused) {
            }
            C3502zza zzap = zze.zzap();
            if (this.zzvv > 0 && zzee.zza(this.zzwl)) {
                zzap.zzcv(zzee.zza(this.zzwc, this.zzwl));
                zzap.zzcw(zzee.zza((double) (this.zzwh - this.zzwf), this.zzwl)).zzcx(zzee.zza((double) (this.zzwi - this.zzwg), this.zzwl)).zzda(zzee.zza((double) this.zzwf, this.zzwl)).zzdb(zzee.zza((double) this.zzwg, this.zzwl));
                if (this.zzwk && this.zzvt != null) {
                    long zza2 = zzee.zza((double) (((this.zzwf - this.zzwh) + this.zzvt.getRawX()) - this.zzvt.getX()), this.zzwl);
                    if (zza2 != 0) {
                        zzap.zzcy(zza2);
                    }
                    long zza3 = zzee.zza((double) (((this.zzwg - this.zzwi) + this.zzvt.getRawY()) - this.zzvt.getY()), this.zzwl);
                    if (zza3 != 0) {
                        zzap.zzcz(zza3);
                    }
                }
            }
            try {
                zzef zza4 = zza(this.zzvt);
                if (zza4.zzyq != null) {
                    zzap.zzcl(zza4.zzyq.longValue());
                }
                if (zza4.zzyr != null) {
                    zzap.zzcm(zza4.zzyr.longValue());
                }
                zzap.zzcr(zza4.zzys.longValue());
                if (this.zzwk) {
                    if (zza4.zzyu != null) {
                        zzap.zzcn(zza4.zzyu.longValue());
                    }
                    if (zza4.zzyt != null) {
                        zzap.zzcp(zza4.zzyt.longValue());
                    }
                    if (zza4.zzyv != null) {
                        zzap.zzk(zza4.zzyv.longValue() != 0 ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
                    }
                    if (this.zzvw > 0) {
                        if (zzee.zza(this.zzwl)) {
                            double d = (double) this.zzwb;
                            double d2 = (double) this.zzvw;
                            Double.isNaN(d);
                            Double.isNaN(d2);
                            l = Long.valueOf(Math.round(d / d2));
                        } else {
                            l = null;
                        }
                        if (l != null) {
                            zzap.zzco(l.longValue());
                        } else {
                            zzap.zzat();
                        }
                        double d3 = (double) this.zzwa;
                        double d4 = (double) this.zzvw;
                        Double.isNaN(d3);
                        Double.isNaN(d4);
                        zzap.zzcq(Math.round(d3 / d4));
                    }
                    if (zza4.zzyy != null) {
                        zzap.zzct(zza4.zzyy.longValue());
                    }
                    if (zza4.zzyz != null) {
                        zzap.zzcs(zza4.zzyz.longValue());
                    }
                    if (zza4.zzza != null) {
                        zzap.zzl(zza4.zzza.longValue() != 0 ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
                    }
                }
            } catch (zzdw unused2) {
            }
            if (this.zzvz > 0) {
                zzap.zzcu(this.zzvz);
            }
            zzb2.zzc((zze) ((zzdqw) zzap.zzazr()));
            if (this.zzvv > 0) {
                zzb2.zzbf(this.zzvv);
            }
            if (this.zzvw > 0) {
                zzb2.zzbe(this.zzvw);
            }
            if (this.zzvx > 0) {
                zzb2.zzbd(this.zzvx);
            }
            if (this.zzvy > 0) {
                zzb2.zzbg(this.zzvy);
            }
            try {
                int size = this.zzvu.size() - 1;
                if (size > 0) {
                    zzb.zzan();
                    for (int i = 0; i < size; i++) {
                        zzef zza5 = zza(zzvo, (MotionEvent) this.zzvu.get(i), this.zzwl);
                        zzb2.zzd((zze) ((zzdqw) zze.zzap().zzcl(zza5.zzyq.longValue()).zzcm(zza5.zzyr.longValue()).zzazr()));
                    }
                }
            } catch (zzdw unused3) {
                zzb.zzan();
            }
            list = new ArrayList();
            if (zzdx.zzce() != null) {
                int zzbz = zzdx.zzbz();
                list.add(new zzes(zzdx2, zzb2));
                zzdx zzdx3 = zzdx;
                zzb zzb3 = zzb;
                zzew zzew = new zzew(zzdx3, "HB5hYpdDWWYPh8xjN/QMHSxBjnwrp91Q0UtK22xocqDpB0ky3Wln7efw6pam/GSb", "ti8Ym9/GEvxZE4gtPT1thSzvv3O2aWq5eDV8JrekaaQ=", zzb3, zzbz, 1);
                list.add(zzew);
                zzeq zzeq = new zzeq(zzdx3, "VXSVTWR5Q+Ql8nXd4ut1JTezdQTLyI9FL7W8NEKmv/ItF/EDabkr4MBOi18woU3o", "VPraLoovAHYOuU235McwsGBEthfwRlWhFzo09VwWfl8=", zzb3, startTime, zzbz, 25);
                list.add(zzeq);
                int i2 = zzbz;
                zzer zzer = new zzer(zzdx3, "ooJom7dhqsxzDvdeCG2cyC1tpeJNdbuwb31K8yrc3wIgeaHvm0jDQT8Y8hGczjcb", "j0OZITyHdX/L7+h6G/PyfgyeIqmZjGFxucjFV0SvysA=", zzb3, i2, 44);
                list.add(zzer);
                zzex zzex = new zzex(zzdx3, "/U7lmoo91nlZ7CXs6EZAlBe4BS4a6Z9kIAqe+P2iZJXpWpucrABhslj/SpsYf6UV", "8phKyaz1GoNRBjdWkSPTH2EdpboiSfEibzQDoMxa8iY=", zzb3, i2, 12);
                list.add(zzex);
                zzez zzez = new zzez(zzdx3, "nPtzXSuU+qktnQkvD2Xhs8JhAWT03LQKh81HOymmhvaoBKzMtF1OqdTJn8I7ucyF", "zhTEaWf7N42ZX9XmpP+4WCaO87v5SAeTw81eS1XA4J4=", zzb3, i2, 3);
                list.add(zzez);
                zzev zzev = new zzev(zzdx3, "jmsbTB23xBLXME1jUq4dTCZC3vHB+dVGB+ZP9+XsjFXJC7mIgp/JquONQgJ7AafS", "C++mzV4T+5ygJv6fsvu2zXYbGtzexRODdJ/B8Ay4Mrs=", zzb3, i2, 22);
                list.add(zzev);
                zzeo zzeo = new zzeo(zzdx3, "O8rdkeMt5QoFNXJjW5QCfqYHYGa3mIfQI8CtBHwRmKoACknsbs4GGEE8fxnP5Yoy", "y+6hRaNMOGZhxSEedIl6KIpCNfA+vCFiKY9NAV8mv+M=", zzb3, i2, 5);
                list.add(zzeo);
                zzfh zzfh = new zzfh(zzdx3, "KVf06HR7LPRikwiUfdTCx0mR6lQ6oD0cDNWgtFganKEt0/oWeDMOhKuhW5MRwMPD", "f1zzBLr4Ds3qcB254ff+50uMW8nPULjA7RwfsMVqI7c=", zzb3, i2, 48);
                list.add(zzfh);
                zzek zzek = new zzek(zzdx3, "rQmNAvxV4vUoXR0mMGYmLq9kAz9hDSoWR6yW2mczJH/c1hwjoR2CytKuR1XsoVho", "UpBY2ygeAK8qQ/jcW8L/0QJFFFip/WVGN2rq8flo4XY=", zzb3, i2, 49);
                list.add(zzek);
                zzfc zzfc = new zzfc(zzdx3, "FyU+rja/Lh1W7P/TLff9RYGhiCqg1F5N3fOvWg9l7fHZgotHJX11povIsnBak2fF", "cnWGFsigIN8LFZbQ7IHZler9sjWFBvyae72txGefDK0=", zzb3, i2, 51);
                list.add(zzfc);
                zzfd zzfd = new zzfd(zzdx3, "zlXUbZgbgwMaill5zgr8cd+zhL4CR8d3/y4U9qW3Aw2OUvMVDO9t0Rnk5UYg4PTz", "Udr7bQcn2LirgawBycwQ/uCvupHUBlSX53Ja+V/IxxU=", zzb3, i2, 45, new Throwable().getStackTrace());
                list.add(zzfd);
                zzfg zzfg = new zzfg(zzdx3, "Q2kZQx3np/22iVvQtL8L6W+o3vBz1XWm/QTajzST0NWOo4ixVRxZbvPz0yneh1nu", "qjI/8KPz1x7tjaYpddn89GzQJQmhUHZolABfXHNafT0=", zzb3, i2, 57, view);
                list.add(zzfg);
                zzfa zzfa = new zzfa(zzdx3, "6dUJX9gtL2a0L+9p2soQN/OuWpIGg61GD5R5KL8bP7g7V/7DN27jVbYstkRsHcmF", "daXoc8IpLGqF4MzYKY6HBt032uHqphAROK9tARIFd9k=", zzb3, i2, 61);
                list.add(zzfa);
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcmz)).booleanValue()) {
                    zzel zzel = new zzel(zzdx, "gaJwYHuOGuVfXnns5P0fkK/Ainj7ch3o9l9YBuU+BJ22PLUxYS8nRJcrYkzX0qQ+", "dWTLVEHJimYYNfpcruwSnR52ji7jgxLgQ8VHTKaDFpw=", zzb, zzbz, 62, view, activity);
                    list.add(zzel);
                }
                if (z) {
                    if (((Boolean) zzuv.zzon().zzd(zzza.zzcnb)).booleanValue()) {
                        zzff zzff = new zzff(zzdx, "Nuw1pNdarBc/cDLvOqEZPcvh4V2z+egOoZiSN4ZnvUSQnq2+ggEgklwBenBh8zkM", "JVwKStyDRx2cYm27U37fG1PrLLhBeDlEDYBB9Vent0s=", zzb, zzbz, 53, this.zzws);
                        list.add(zzff);
                    }
                }
            }
        }
        zza(list);
    }

    protected static void zza(List<Callable<Void>> list) {
        if (zzvo != null) {
            ExecutorService zzce = zzvo.zzce();
            if (zzce != null && !list.isEmpty()) {
                try {
                    zzce.invokeAll(list, ((Long) zzuv.zzon().zzd(zzza.zzcmy)).longValue(), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Log.d(TAG, String.format("class methods got exception: %s", new Object[]{zzee.zza((Throwable) e)}));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final zzef zza(MotionEvent motionEvent) throws zzdw {
        Method zzc = zzvo.zzc("4CdHFNYn5+c7AqMUB3qcITbVVCzzl788RQr8Q4uzAkZY6SjUZkIle9XX2m/8SmAI", "6MGBhcJM4bOqwWqGpT84v31UdYzks0tzvKG9JKP/JQ0=");
        if (zzc == null || motionEvent == null) {
            throw new zzdw();
        }
        try {
            return new zzef((String) zzc.invoke(null, new Object[]{motionEvent, this.zzwl}));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdw(e);
        }
    }

    /* access modifiers changed from: protected */
    public final long zza(StackTraceElement[] stackTraceElementArr) throws zzdw {
        Method zzc = zzvo.zzc("zlXUbZgbgwMaill5zgr8cd+zhL4CR8d3/y4U9qW3Aw2OUvMVDO9t0Rnk5UYg4PTz", "Udr7bQcn2LirgawBycwQ/uCvupHUBlSX53Ja+V/IxxU=");
        if (zzc == null || stackTraceElementArr == null) {
            throw new zzdw();
        }
        try {
            return new zzdv((String) zzc.invoke(null, new Object[]{stackTraceElementArr})).zzxo.longValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new zzdw(e);
        }
    }

    public final void zzb(View view) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnb)).booleanValue()) {
            zzeg zzeg = this.zzws;
            if (zzeg == null) {
                this.zzws = new zzeg(zzvo, view);
            } else {
                zzeg.zzd(view);
            }
        }
    }
}
