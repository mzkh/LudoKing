package com.inmobi.media;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.hl */
/* compiled from: CellTowerInfo */
public class C2571hl {

    /* renamed from: d */
    private static final String f5669d = "hl";

    /* renamed from: a */
    String f5670a;

    /* renamed from: b */
    int f5671b;

    /* renamed from: c */
    int f5672c;

    public C2571hl() {
    }

    @TargetApi(18)
    public C2571hl(CellInfo cellInfo, String str, String str2, int i) {
        if (cellInfo instanceof CellInfoGsm) {
            this.f5672c = i;
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            this.f5671b = cellInfoGsm.getCellSignalStrength().getDbm();
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            this.f5670a = m5591a(str, str2, cellIdentity.getLac(), cellIdentity.getCid(), -1, Integer.MAX_VALUE);
        } else if (cellInfo instanceof CellInfoCdma) {
            this.f5672c = i;
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            this.f5671b = cellInfoCdma.getCellSignalStrength().getDbm();
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            this.f5670a = m5590a(str, cellIdentity2.getSystemId(), cellIdentity2.getNetworkId(), cellIdentity2.getBasestationId());
        } else {
            if (VERSION.SDK_INT >= 18) {
                if (cellInfo instanceof CellInfoWcdma) {
                    this.f5672c = i;
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    this.f5671b = cellInfoWcdma.getCellSignalStrength().getDbm();
                    CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                    this.f5670a = m5591a(str, str2, cellIdentity3.getLac(), cellIdentity3.getCid(), cellIdentity3.getPsc(), Integer.MAX_VALUE);
                }
            } else if (cellInfo instanceof CellInfoLte) {
                this.f5672c = i;
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                this.f5671b = cellInfoLte.getCellSignalStrength().getDbm();
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                this.f5670a = m5591a(str, str2, cellIdentity4.getTac(), cellIdentity4.getCi(), -1, cellIdentity4.getPci());
            }
        }
    }

    /* renamed from: a */
    public static String m5590a(String str, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = "#";
        sb.append(str2);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m5591a(String str, String str2, int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = "#";
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
        sb.append(str3);
        sb.append(i2);
        sb.append(str3);
        Object obj = "";
        sb.append(i3 == -1 ? obj : Integer.valueOf(i3));
        sb.append(str3);
        if (i4 != Integer.MAX_VALUE) {
            obj = Integer.valueOf(i4);
        }
        sb.append(obj);
        return sb.toString();
    }

    /* renamed from: a */
    public final JSONObject mo28569a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f5670a);
            if (this.f5671b != Integer.MAX_VALUE) {
                jSONObject.put("ss", this.f5671b);
            }
            jSONObject.put("nt", this.f5672c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
