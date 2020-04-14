package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbk.zzb;
import com.google.android.gms.internal.measurement.zzbk.zzd;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbs.zzc;
import com.google.android.gms.internal.measurement.zzbs.zze;
import com.google.android.gms.internal.measurement.zzbs.zzf;
import com.google.android.gms.internal.measurement.zzbs.zzg;
import com.google.android.gms.internal.measurement.zzbs.zzi;
import com.google.android.gms.internal.measurement.zzbs.zzj;
import com.google.android.gms.internal.measurement.zzbs.zzk;
import com.google.android.gms.internal.measurement.zzbs.zzk.zza;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzjo extends zzjh {
    zzjo(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zzqz().zzra().zzrb();
        if (obj instanceof String) {
            zza.zzdc((String) obj);
        } else if (obj instanceof Long) {
            zza.zzbl(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zzc(((Double) obj).doubleValue());
        } else {
            zzab().zzgk().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zzmu().zzmv().zzmw();
        if (obj instanceof String) {
            zza.zzca((String) obj);
        } else if (obj instanceof Long) {
            zza.zzam(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzab().zzgk().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    static zze zza(zzc zzc, String str) {
        for (zze zze : zzc.zzmj()) {
            if (zze.getName().equals(str)) {
                return zze;
            }
        }
        return null;
    }

    static Object zzb(zzc zzc, String str) {
        zze zza = zza(zzc, str);
        if (zza != null) {
            if (zza.zzmx()) {
                return zza.zzmy();
            }
            if (zza.zzna()) {
                return Long.valueOf(zza.zznb());
            }
            if (zza.zznd()) {
                return Double.valueOf(zza.zzne());
            }
        }
        return null;
    }

    static void zza(zzc.zza zza, String str, Object obj) {
        List zzmj = zza.zzmj();
        int i = 0;
        while (true) {
            if (i >= zzmj.size()) {
                i = -1;
                break;
            } else if (str.equals(((zze) zzmj.get(i)).getName())) {
                break;
            } else {
                i++;
            }
        }
        zze.zza zzbz = zze.zzng().zzbz(str);
        if (obj instanceof Long) {
            zzbz.zzam(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzbz.zzca((String) obj);
        } else if (obj instanceof Double) {
            zzbz.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zza.zza(i, zzbz);
        } else {
            zza.zza(zzbz);
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        Iterator it = zzf.zzni().iterator();
        while (true) {
            String str = "}\n";
            if (it.hasNext()) {
                zzg zzg = (zzg) it.next();
                if (zzg != null) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    if (zzg.zznx()) {
                        zza(sb, 1, "protocol_version", (Object) Integer.valueOf(zzg.zzny()));
                    }
                    zza(sb, 1, TapjoyConstants.TJC_PLATFORM, (Object) zzg.zzom());
                    if (zzg.zzoq()) {
                        zza(sb, 1, "gmp_version", (Object) Long.valueOf(zzg.zzao()));
                    }
                    if (zzg.zzor()) {
                        zza(sb, 1, "uploading_gmp_version", (Object) Long.valueOf(zzg.zzos()));
                    }
                    if (zzg.zzpq()) {
                        zza(sb, 1, "dynamite_version", (Object) Long.valueOf(zzg.zzaq()));
                    }
                    if (zzg.zzpi()) {
                        zza(sb, 1, "config_version", (Object) Long.valueOf(zzg.zzpj()));
                    }
                    zza(sb, 1, "gmp_app_id", (Object) zzg.getGmpAppId());
                    zza(sb, 1, "admob_app_id", (Object) zzg.zzpp());
                    zza(sb, 1, "app_id", (Object) zzg.zzag());
                    zza(sb, 1, TapjoyConstants.TJC_APP_VERSION_NAME, (Object) zzg.zzal());
                    if (zzg.zzpf()) {
                        zza(sb, 1, "app_version_major", (Object) Integer.valueOf(zzg.zzpg()));
                    }
                    zza(sb, 1, "firebase_instance_id", (Object) zzg.getFirebaseInstanceId());
                    if (zzg.zzow()) {
                        zza(sb, 1, "dev_cert_hash", (Object) Long.valueOf(zzg.zzap()));
                    }
                    zza(sb, 1, "app_store", (Object) zzg.zzan());
                    if (zzg.zzoc()) {
                        zza(sb, 1, "upload_timestamp_millis", (Object) Long.valueOf(zzg.zzod()));
                    }
                    if (zzg.zzoe()) {
                        zza(sb, 1, "start_timestamp_millis", (Object) Long.valueOf(zzg.zznq()));
                    }
                    if (zzg.zzof()) {
                        zza(sb, 1, "end_timestamp_millis", (Object) Long.valueOf(zzg.zznr()));
                    }
                    if (zzg.zzog()) {
                        zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(zzg.zzoh()));
                    }
                    if (zzg.zzoj()) {
                        zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(zzg.zzok()));
                    }
                    zza(sb, 1, "app_instance_id", (Object) zzg.getAppInstanceId());
                    zza(sb, 1, "resettable_device_id", (Object) zzg.zzot());
                    zza(sb, 1, "device_id", (Object) zzg.zzph());
                    zza(sb, 1, "ds_id", (Object) zzg.zzpl());
                    if (zzg.zzou()) {
                        zza(sb, 1, "limited_ad_tracking", (Object) Boolean.valueOf(zzg.zzov()));
                    }
                    zza(sb, 1, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, (Object) zzg.getOsVersion());
                    zza(sb, 1, "device_model", (Object) zzg.zzon());
                    zza(sb, 1, "user_default_language", (Object) zzg.zzcr());
                    if (zzg.zzoo()) {
                        zza(sb, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(zzg.zzop()));
                    }
                    if (zzg.zzox()) {
                        zza(sb, 1, "bundle_sequential_index", (Object) Integer.valueOf(zzg.zzoy()));
                    }
                    if (zzg.zzpb()) {
                        zza(sb, 1, "service_upload", (Object) Boolean.valueOf(zzg.zzpc()));
                    }
                    zza(sb, 1, "health_monitor", (Object) zzg.zzoz());
                    if (zzg.zzpk() && zzg.zzbd() != 0) {
                        zza(sb, 1, TapjoyConstants.TJC_ANDROID_ID, (Object) Long.valueOf(zzg.zzbd()));
                    }
                    if (zzg.zzpn()) {
                        zza(sb, 1, "retry_counter", (Object) Integer.valueOf(zzg.zzpo()));
                    }
                    List<zzk> zzno = zzg.zzno();
                    String str2 = "double_value";
                    String str3 = "int_value";
                    String str4 = "string_value";
                    String str5 = "name";
                    int i = 2;
                    if (zzno != null) {
                        for (zzk zzk : zzno) {
                            if (zzk != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zza(sb, 2, "set_timestamp_millis", (Object) zzk.zzqs() ? Long.valueOf(zzk.zzqt()) : null);
                                zza(sb, 2, str5, (Object) zzy().zzal(zzk.getName()));
                                zza(sb, 2, str4, (Object) zzk.zzmy());
                                zza(sb, 2, str3, (Object) zzk.zzna() ? Long.valueOf(zzk.zznb()) : null);
                                zza(sb, 2, str2, (Object) zzk.zznd() ? Double.valueOf(zzk.zzne()) : null);
                                zza(sb, 2);
                                sb.append(str);
                            }
                        }
                    }
                    List<zzbs.zza> zzpd = zzg.zzpd();
                    String zzag = zzg.zzag();
                    if (zzpd != null) {
                        for (zzbs.zza zza : zzpd) {
                            if (zza != null) {
                                zza(sb, i);
                                sb.append("audience_membership {\n");
                                if (zza.zzly()) {
                                    zza(sb, i, "audience_id", (Object) Integer.valueOf(zza.zzlz()));
                                }
                                if (zza.zzma()) {
                                    zza(sb, i, "new_audience", (Object) Boolean.valueOf(zza.zzmb()));
                                }
                                StringBuilder sb2 = sb;
                                String str6 = zzag;
                                zza(sb2, 2, "current_data", zza.zzlv(), str6);
                                zza(sb2, 2, "previous_data", zza.zzlx(), str6);
                                zza(sb, 2);
                                sb.append(str);
                                i = 2;
                            }
                        }
                    }
                    List<zzc> zznl = zzg.zznl();
                    if (zznl != null) {
                        for (zzc zzc : zznl) {
                            if (zzc != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, str5, (Object) zzy().zzaj(zzc.getName()));
                                if (zzc.zzml()) {
                                    zza(sb, 2, "timestamp_millis", (Object) Long.valueOf(zzc.getTimestampMillis()));
                                }
                                if (zzc.zzmo()) {
                                    zza(sb, 2, "previous_timestamp_millis", (Object) Long.valueOf(zzc.zzmm()));
                                }
                                if (zzc.zzmp()) {
                                    zza(sb, 2, "count", (Object) Integer.valueOf(zzc.getCount()));
                                }
                                if (zzc.zzmk() != 0) {
                                    List<zze> zzmj = zzc.zzmj();
                                    if (zzmj != null) {
                                        for (zze zze : zzmj) {
                                            if (zze != null) {
                                                zza(sb, 3);
                                                sb.append("param {\n");
                                                zza(sb, 3, str5, (Object) zzy().zzak(zze.getName()));
                                                zza(sb, 3, str4, (Object) zze.zzmy());
                                                zza(sb, 3, str3, (Object) zze.zzna() ? Long.valueOf(zze.zznb()) : null);
                                                zza(sb, 3, str2, (Object) zze.zznd() ? Double.valueOf(zze.zzne()) : null);
                                                zza(sb, 3);
                                                sb.append(str);
                                            }
                                        }
                                    }
                                }
                                zza(sb, 2);
                                sb.append(str);
                            }
                        }
                    }
                    zza(sb, 1);
                    sb.append(str);
                }
            } else {
                sb.append(str);
                return sb.toString();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzbk.zza zza) {
        if (zza == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zza.zzkb()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zza.getId()));
        }
        zza(sb, 0, "event_name", (Object) zzy().zzaj(zza.zzjz()));
        String zza2 = zza(zza.zzkf(), zza.zzkg(), zza.zzki());
        if (!zza2.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza2);
        }
        zza(sb, 1, "event_count_filter", zza.zzke());
        sb.append("  filters {\n");
        for (zzb zza3 : zza.zzkc()) {
            zza(sb, 2, zza3);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzd zzd) {
        if (zzd == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzd.zzkb()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zzd.getId()));
        }
        zza(sb, 0, "property_name", (Object) zzy().zzal(zzd.getPropertyName()));
        String zza = zza(zzd.zzkf(), zzd.zzkg(), zzd.zzki());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza);
        }
        zza(sb, 1, zzd.zzli());
        sb.append("}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void zza(StringBuilder sb, int i, String str, zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            String str3 = ", ";
            if (zzi.zzpz() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : zzi.zzpy()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(str3);
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzi.zzpw() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : zzi.zzpv()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(str3);
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append(10);
            }
            boolean zzq = zzad().zzq(str2);
            String str4 = "}\n";
            if (zzq) {
                if (zzi.zzqc() != 0) {
                    zza(sb, 4);
                    sb.append("dynamic_filter_timestamps: {");
                    int i6 = 0;
                    for (zzbs.zzb zzb : zzi.zzqb()) {
                        int i7 = i6 + 1;
                        if (i6 != 0) {
                            sb.append(str3);
                        }
                        sb.append(zzb.zzme() ? Integer.valueOf(zzb.getIndex()) : null);
                        sb.append(":");
                        sb.append(zzb.zzmf() ? Long.valueOf(zzb.zzmg()) : null);
                        i6 = i7;
                    }
                    sb.append(str4);
                }
                if (zzi.zzqf() != 0) {
                    zza(sb, 4);
                    sb.append("sequence_filter_timestamps: {");
                    int i8 = 0;
                    for (zzj zzj : zzi.zzqe()) {
                        int i9 = i8 + 1;
                        if (i8 != 0) {
                            sb.append(str3);
                        }
                        sb.append(zzj.zzme() ? Integer.valueOf(zzj.getIndex()) : null);
                        sb.append(": [");
                        int i10 = 0;
                        for (Long longValue : zzj.zzqk()) {
                            long longValue2 = longValue.longValue();
                            int i11 = i10 + 1;
                            if (i10 != 0) {
                                sb.append(str3);
                            }
                            sb.append(longValue2);
                            i10 = i11;
                        }
                        sb.append("]");
                        i8 = i9;
                    }
                    sb.append(str4);
                }
            }
            zza(sb, 3);
            sb.append(str4);
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzbk.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzc.zzku()) {
                zza(sb, i, "comparison_type", (Object) zzc.zzkv().name());
            }
            if (zzc.zzkw()) {
                zza(sb, i, "match_as_float", (Object) Boolean.valueOf(zzc.zzkx()));
            }
            zza(sb, i, "comparison_value", (Object) zzc.zzkz());
            zza(sb, i, "min_comparison_value", (Object) zzc.zzlb());
            zza(sb, i, "max_comparison_value", (Object) zzc.zzld());
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzb zzb) {
        if (zzb != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzb.zzkp()) {
                zza(sb, i, "complement", (Object) Boolean.valueOf(zzb.zzkq()));
            }
            zza(sb, i, "param_name", (Object) zzy().zzak(zzb.zzkr()));
            int i2 = i + 1;
            zzbk.zze zzkm = zzb.zzkm();
            String str = "}\n";
            if (zzkm != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzkm.zzlk()) {
                    zza(sb, i2, "match_type", (Object) zzkm.zzll().name());
                }
                zza(sb, i2, "expression", (Object) zzkm.zzln());
                if (zzkm.zzlo()) {
                    zza(sb, i2, "case_sensitive", (Object) Boolean.valueOf(zzkm.zzlp()));
                }
                if (zzkm.zzlr() > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str2 : zzkm.zzlq()) {
                        zza(sb, i2 + 2);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append(str);
                }
                zza(sb, i2);
                sb.append(str);
            }
            zza(sb, i2, "number_filter", zzb.zzko());
            zza(sb, i);
            sb.append(str);
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzab().zzgk().zzao("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzef r5 = r4.zzab()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zzao(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjo.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zze(zzai zzai, zzn zzn) {
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotNull(zzn);
        if (!TextUtils.isEmpty(zzn.zzcg) || !TextUtils.isEmpty(zzn.zzcu)) {
            return true;
        }
        zzae();
        return false;
    }

    static boolean zzbj(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i < (list.size() << 6)) {
            if (((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0) {
                return true;
            }
        }
        return false;
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzab().zzgn().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzab().zzgn().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzx().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzz().zzo();
        MessageDigest messageDigest = zzjs.getMessageDigest();
        if (messageDigest != null) {
            return zzjs.zzd(messageDigest.digest(bArr));
        }
        zzab().zzgk().zzao("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzab().zzgk().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzab().zzgk().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final List<Integer> zzju() {
        Map zzk = zzak.zzk(this.zzkz.getContext());
        if (zzk == null || zzk.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = ((Integer) zzak.zzhr.get(null)).intValue();
        Iterator it = zzk.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzab().zzgn().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzab().zzgn().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ zzjo zzgw() {
        return super.zzgw();
    }

    public final /* bridge */ /* synthetic */ zzp zzgx() {
        return super.zzgx();
    }

    public final /* bridge */ /* synthetic */ zzx zzgy() {
        return super.zzgy();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgz() {
        return super.zzgz();
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
