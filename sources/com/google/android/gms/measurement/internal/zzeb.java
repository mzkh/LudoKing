package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzeb extends zzg {
    private final zzea zzjv = new zzea(this, getContext(), "google_app_measurement_local.db");
    private boolean zzjw;

    zzeb(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzm();
        zzo();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzab().zzgs().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r13v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r10v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r10v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r13v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r10v9 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v13 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r0 = e;
        r8 = r8;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r8 = 0;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e1, code lost:
        if (r8.inTransaction() != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e3, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f6, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0100, code lost:
        r10 = r8;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x010c, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0111, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1, types: [int, boolean]
      assigns: []
      uses: [?[int, short, byte, char], int, boolean]
      mth insns count: 164
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00dd A[SYNTHETIC, Splitter:B:57:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013f  */
    /* JADX WARNING: Unknown variable types count: 19 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "Error writing entry to local database"
            r17.zzm()
            r17.zzo()
            boolean r0 = r1.zzjw
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.String r5 = "type"
            r4.put(r5, r0)
            java.lang.String r0 = "entry"
            r5 = r19
            r4.put(r0, r5)
            r5 = 5
            r6 = 0
            r7 = 5
        L_0x0028:
            if (r6 >= r5) goto L_0x0143
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r17.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0115, SQLiteDatabaseLockedException -> 0x0102, SQLiteException -> 0x00d8, all -> 0x00d2 }
            if (r10 != 0) goto L_0x0041
            r1.zzjw = r9     // Catch:{ SQLiteFullException -> 0x003e, SQLiteDatabaseLockedException -> 0x00cc, SQLiteException -> 0x003a }
            if (r10 == 0) goto L_0x0039
            r10.close()
        L_0x0039:
            return r3
        L_0x003a:
            r0 = move-exception
            r13 = r8
            goto L_0x00ca
        L_0x003e:
            r0 = move-exception
            goto L_0x0118
        L_0x0041:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00cf, SQLiteDatabaseLockedException -> 0x00cc, SQLiteException -> 0x00c7, all -> 0x00c2 }
            r11 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r13 = r10.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00cf, SQLiteDatabaseLockedException -> 0x00cc, SQLiteException -> 0x00c7, all -> 0x00c2 }
            if (r13 == 0) goto L_0x0063
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            if (r0 == 0) goto L_0x0063
            long r11 = r13.getLong(r3)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            goto L_0x0063
        L_0x0059:
            r0 = move-exception
            goto L_0x0138
        L_0x005c:
            r0 = move-exception
            goto L_0x00ca
        L_0x005f:
            r0 = move-exception
            r8 = r13
            goto L_0x0118
        L_0x0063:
            java.lang.String r0 = "messages"
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r16 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00aa
            com.google.android.gms.measurement.internal.zzef r16 = r17.zzab()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzeh r5 = r16.zzgk()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r8 = "Data loss, local db full"
            r5.zzao(r8)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            long r14 = r14 - r11
            r11 = 1
            long r14 = r14 + r11
            java.lang.String r5 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r8 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            r8[r3] = r11     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            int r5 = r10.delete(r0, r5, r8)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            long r11 = (long) r5     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00aa
            com.google.android.gms.measurement.internal.zzef r5 = r17.zzab()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r8 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            r5.zza(r8, r3, r9, r11)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
        L_0x00aa:
            r3 = 0
            r10.insertOrThrow(r0, r3, r4)     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x005f, SQLiteDatabaseLockedException -> 0x00c0, SQLiteException -> 0x005c, all -> 0x0059 }
            if (r13 == 0) goto L_0x00b9
            r13.close()
        L_0x00b9:
            if (r10 == 0) goto L_0x00be
            r10.close()
        L_0x00be:
            r2 = 1
            return r2
        L_0x00c0:
            r8 = r13
            goto L_0x0104
        L_0x00c2:
            r0 = move-exception
            r3 = r8
            r13 = r3
            goto L_0x0138
        L_0x00c7:
            r0 = move-exception
            r3 = r8
            r13 = r3
        L_0x00ca:
            r8 = r10
            goto L_0x00db
        L_0x00cc:
            r3 = r8
            r8 = r3
            goto L_0x0104
        L_0x00cf:
            r0 = move-exception
            r3 = r8
            goto L_0x0118
        L_0x00d2:
            r0 = move-exception
            r3 = r8
            r10 = r3
            r13 = r10
            goto L_0x0138
        L_0x00d8:
            r0 = move-exception
            r3 = r8
            r13 = r8
        L_0x00db:
            if (r8 == 0) goto L_0x00e6
            boolean r3 = r8.inTransaction()     // Catch:{ all -> 0x00ff }
            if (r3 == 0) goto L_0x00e6
            r8.endTransaction()     // Catch:{ all -> 0x00ff }
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzef r3 = r17.zzab()     // Catch:{ all -> 0x00ff }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x00ff }
            r3.zza(r2, r0)     // Catch:{ all -> 0x00ff }
            r3 = 1
            r1.zzjw = r3     // Catch:{ all -> 0x00ff }
            if (r13 == 0) goto L_0x00f9
            r13.close()
        L_0x00f9:
            if (r8 == 0) goto L_0x0130
            r8.close()
            goto L_0x0130
        L_0x00ff:
            r0 = move-exception
            r10 = r8
            goto L_0x0138
        L_0x0102:
            r3 = r8
            r10 = r8
        L_0x0104:
            long r11 = (long) r7
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0136 }
            int r7 = r7 + 20
            if (r8 == 0) goto L_0x010f
            r8.close()
        L_0x010f:
            if (r10 == 0) goto L_0x0130
            r10.close()
            goto L_0x0130
        L_0x0115:
            r0 = move-exception
            r3 = r8
            r10 = r8
        L_0x0118:
            com.google.android.gms.measurement.internal.zzef r3 = r17.zzab()     // Catch:{ all -> 0x0136 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0136 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0136 }
            r3 = 1
            r1.zzjw = r3     // Catch:{ all -> 0x0136 }
            if (r8 == 0) goto L_0x012b
            r8.close()
        L_0x012b:
            if (r10 == 0) goto L_0x0130
            r10.close()
        L_0x0130:
            int r6 = r6 + 1
            r3 = 0
            r5 = 5
            goto L_0x0028
        L_0x0136:
            r0 = move-exception
            r13 = r8
        L_0x0138:
            if (r13 == 0) goto L_0x013d
            r13.close()
        L_0x013d:
            if (r10 == 0) goto L_0x0142
            r10.close()
        L_0x0142:
            throw r0
        L_0x0143:
            com.google.android.gms.measurement.internal.zzef r0 = r17.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zzao(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzai zzai) {
        Parcel obtain = Parcel.obtain();
        zzai.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzab().zzgn().zzao("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzjn zzjn) {
        Parcel obtain = Parcel.obtain();
        zzjn.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzab().zzgn().zzao("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzq zzq) {
        zzz();
        byte[] zza = zzjs.zza((Parcelable) zzq);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzab().zzgn().zzao("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARNING: type inference failed for: r10v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r10v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r10v10, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v13, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v14 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r10v15 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v37 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:68|69|70|71) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:83|84|85|86) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:53|54|55|56|182) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01d8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d9, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01db, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01dc, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01de, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01e2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e3, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01f3, code lost:
        if (r3.inTransaction() != false) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01f5, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0207, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x020c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0210, code lost:
        r0 = th;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x021c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0221, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x024e, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0253, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        zzab().zzgk().zzao("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        zzab().zzgk().zzao(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        zzab().zzgk().zzao(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00f3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x0125 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0159 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01db A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01ef A[SYNTHETIC, Splitter:B:130:0x01ef] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0243 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0243 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0243 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzc(int r25) {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "Error reading entries from local database"
            r24.zzo()
            r24.zzm()
            boolean r0 = r1.zzjw
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r24.zzcg()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0020:
            if (r7 >= r5) goto L_0x0257
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r24.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0229, SQLiteDatabaseLockedException -> 0x0212, SQLiteException -> 0x01ea, all -> 0x01e6 }
            if (r15 != 0) goto L_0x0039
            r1.zzjw = r9     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x0031 }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            r10 = r3
            r3 = r15
            goto L_0x01ed
        L_0x0036:
            r0 = move-exception
            goto L_0x022c
        L_0x0039:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            com.google.android.gms.measurement.internal.zzs r0 = r24.zzad()     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzjd     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            boolean r0 = r0.zza(r10)     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            java.lang.String r11 = "entry"
            java.lang.String r12 = "type"
            java.lang.String r13 = "rowid"
            r19 = -1
            r14 = 3
            r5 = 2
            if (r0 == 0) goto L_0x0095
            long r16 = zza(r15)     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            int r0 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0065, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x0065, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r3[r6] = r16     // Catch:{ SQLiteFullException -> 0x0065, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            goto L_0x006a
        L_0x0065:
            r0 = move-exception
            goto L_0x01e4
        L_0x0068:
            r0 = 0
            r3 = 0
        L_0x006a:
            java.lang.String r16 = "messages"
            java.lang.String[] r10 = new java.lang.String[r14]     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r10[r6] = r13     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r10[r9] = r12     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r10[r5] = r11     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r18 = 0
            r21 = 0
            java.lang.String r22 = "rowid asc"
            r11 = 100
            java.lang.String r23 = java.lang.Integer.toString(r11)     // Catch:{ SQLiteFullException -> 0x01e2, SQLiteDatabaseLockedException -> 0x01de, SQLiteException -> 0x01db, all -> 0x01d8 }
            r12 = r10
            r10 = r15
            r11 = r16
            r13 = r0
            r0 = 3
            r14 = r3
            r3 = r15
            r15 = r18
            r16 = r21
            r17 = r22
            r18 = r23
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            goto L_0x00c1
        L_0x0095:
            r3 = r15
            r0 = 3
            java.lang.String r14 = "messages"
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            r15[r6] = r13     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            r15[r9] = r12     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            r15[r5] = r11     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            r13 = 0
            r16 = 0
            r18 = 0
            r21 = 0
            java.lang.String r22 = "rowid asc"
            r10 = 100
            java.lang.String r23 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
            r10 = r3
            r11 = r14
            r12 = r15
            r14 = r16
            r15 = r18
            r16 = r21
            r17 = r22
            r18 = r23
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x01d5, SQLiteDatabaseLockedException -> 0x01df, SQLiteException -> 0x01d3, all -> 0x01d1 }
        L_0x00c1:
            boolean r11 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            if (r11 == 0) goto L_0x0193
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r11 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            byte[] r12 = r10.getBlob(r5)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            if (r11 != 0) goto L_0x0108
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r13 = r12.length     // Catch:{ ParseException -> 0x00f3 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x00f3 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00f3 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r12 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ ParseException -> 0x00f3 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x00f3 }
            com.google.android.gms.measurement.internal.zzai r12 = (com.google.android.gms.measurement.internal.zzai) r12     // Catch:{ ParseException -> 0x00f3 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            if (r12 == 0) goto L_0x00c1
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x00f1:
            r0 = move-exception
            goto L_0x0104
        L_0x00f3:
            com.google.android.gms.measurement.internal.zzef r12 = r24.zzab()     // Catch:{ all -> 0x00f1 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzgk()     // Catch:{ all -> 0x00f1 }
            java.lang.String r13 = "Failed to load event from local database"
            r12.zzao(r13)     // Catch:{ all -> 0x00f1 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x0104:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
        L_0x0108:
            java.lang.String r13 = "Failed to load user property from local database"
            if (r11 != r9) goto L_0x013e
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r14 = r12.length     // Catch:{ ParseException -> 0x0125 }
            r11.unmarshall(r12, r6, r14)     // Catch:{ ParseException -> 0x0125 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0125 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzjn> r12 = com.google.android.gms.measurement.internal.zzjn.CREATOR     // Catch:{ ParseException -> 0x0125 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzjn r12 = (com.google.android.gms.measurement.internal.zzjn) r12     // Catch:{ ParseException -> 0x0125 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x0134
        L_0x0123:
            r0 = move-exception
            goto L_0x013a
        L_0x0125:
            com.google.android.gms.measurement.internal.zzef r12 = r24.zzab()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzgk()     // Catch:{ all -> 0x0123 }
            r12.zzao(r13)     // Catch:{ all -> 0x0123 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            r12 = 0
        L_0x0134:
            if (r12 == 0) goto L_0x00c1
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x013a:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
        L_0x013e:
            if (r11 != r5) goto L_0x0173
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r14 = r12.length     // Catch:{ ParseException -> 0x0159 }
            r11.unmarshall(r12, r6, r14)     // Catch:{ ParseException -> 0x0159 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0159 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzq> r12 = com.google.android.gms.measurement.internal.zzq.CREATOR     // Catch:{ ParseException -> 0x0159 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzq r12 = (com.google.android.gms.measurement.internal.zzq) r12     // Catch:{ ParseException -> 0x0159 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x0168
        L_0x0157:
            r0 = move-exception
            goto L_0x016f
        L_0x0159:
            com.google.android.gms.measurement.internal.zzef r12 = r24.zzab()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzgk()     // Catch:{ all -> 0x0157 }
            r12.zzao(r13)     // Catch:{ all -> 0x0157 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            r12 = 0
        L_0x0168:
            if (r12 == 0) goto L_0x00c1
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x016f:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
        L_0x0173:
            if (r11 != r0) goto L_0x0184
            com.google.android.gms.measurement.internal.zzef r11 = r24.zzab()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            java.lang.String r12 = "Skipping app launch break"
            r11.zzao(r12)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x0184:
            com.google.android.gms.measurement.internal.zzef r11 = r24.zzab()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgk()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            java.lang.String r12 = "Unknown record type in local database"
            r11.zzao(r12)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            goto L_0x00c1
        L_0x0193:
            java.lang.String r0 = "messages"
            java.lang.String r5 = "rowid <= ?"
            java.lang.String[] r11 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            java.lang.String r12 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            r11[r6] = r12     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r0 = r3.delete(r0, r5, r11)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            int r5 = r4.size()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            if (r0 >= r5) goto L_0x01b6
            com.google.android.gms.measurement.internal.zzef r0 = r24.zzab()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            java.lang.String r5 = "Fewer entries removed from local database than expected"
            r0.zzao(r5)     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
        L_0x01b6:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x01cc, SQLiteDatabaseLockedException -> 0x01c9, SQLiteException -> 0x01c7 }
            if (r10 == 0) goto L_0x01c1
            r10.close()
        L_0x01c1:
            if (r3 == 0) goto L_0x01c6
            r3.close()
        L_0x01c6:
            return r4
        L_0x01c7:
            r0 = move-exception
            goto L_0x01ed
        L_0x01c9:
            r5 = r3
            r3 = r10
            goto L_0x0214
        L_0x01cc:
            r0 = move-exception
            r15 = r3
            r3 = r10
            goto L_0x022c
        L_0x01d1:
            r0 = move-exception
            goto L_0x01e8
        L_0x01d3:
            r0 = move-exception
            goto L_0x01ec
        L_0x01d5:
            r0 = move-exception
            r15 = r3
            goto L_0x01e4
        L_0x01d8:
            r0 = move-exception
            r3 = r15
            goto L_0x01e8
        L_0x01db:
            r0 = move-exception
            r3 = r15
            goto L_0x01ec
        L_0x01de:
            r3 = r15
        L_0x01df:
            r5 = r3
            r3 = 0
            goto L_0x0214
        L_0x01e2:
            r0 = move-exception
            r3 = r15
        L_0x01e4:
            r3 = 0
            goto L_0x022c
        L_0x01e6:
            r0 = move-exception
            r3 = 0
        L_0x01e8:
            r10 = 0
            goto L_0x024c
        L_0x01ea:
            r0 = move-exception
            r3 = 0
        L_0x01ec:
            r10 = 0
        L_0x01ed:
            if (r3 == 0) goto L_0x01f8
            boolean r5 = r3.inTransaction()     // Catch:{ all -> 0x0210 }
            if (r5 == 0) goto L_0x01f8
            r3.endTransaction()     // Catch:{ all -> 0x0210 }
        L_0x01f8:
            com.google.android.gms.measurement.internal.zzef r5 = r24.zzab()     // Catch:{ all -> 0x0210 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x0210 }
            r5.zza(r2, r0)     // Catch:{ all -> 0x0210 }
            r1.zzjw = r9     // Catch:{ all -> 0x0210 }
            if (r10 == 0) goto L_0x020a
            r10.close()
        L_0x020a:
            if (r3 == 0) goto L_0x0243
            r3.close()
            goto L_0x0243
        L_0x0210:
            r0 = move-exception
            goto L_0x024c
        L_0x0212:
            r3 = 0
            r5 = 0
        L_0x0214:
            long r9 = (long) r8
            android.os.SystemClock.sleep(r9)     // Catch:{ all -> 0x0225 }
            int r8 = r8 + 20
            if (r3 == 0) goto L_0x021f
            r3.close()
        L_0x021f:
            if (r5 == 0) goto L_0x0243
            r5.close()
            goto L_0x0243
        L_0x0225:
            r0 = move-exception
            r10 = r3
            r3 = r5
            goto L_0x024c
        L_0x0229:
            r0 = move-exception
            r3 = 0
            r15 = 0
        L_0x022c:
            com.google.android.gms.measurement.internal.zzef r5 = r24.zzab()     // Catch:{ all -> 0x0249 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x0249 }
            r5.zza(r2, r0)     // Catch:{ all -> 0x0249 }
            r1.zzjw = r9     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x023e
            r3.close()
        L_0x023e:
            if (r15 == 0) goto L_0x0243
            r15.close()
        L_0x0243:
            int r7 = r7 + 1
            r3 = 0
            r5 = 5
            goto L_0x0020
        L_0x0249:
            r0 = move-exception
            r10 = r3
            r3 = r15
        L_0x024c:
            if (r10 == 0) goto L_0x0251
            r10.close()
        L_0x0251:
            if (r3 == 0) goto L_0x0256
            r3.close()
        L_0x0256:
            throw r0
        L_0x0257:
            com.google.android.gms.measurement.internal.zzef r0 = r24.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zzao(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zzc(int):java.util.List");
    }

    @WorkerThread
    public final boolean zzgh() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r3 = r3 + 1;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzgi() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzo()
            r11.zzm()
            boolean r1 = r11.zzjw
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            boolean r1 = r11.zzcg()
            if (r1 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0018:
            if (r3 >= r1) goto L_0x0092
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 != 0) goto L_0x002a
            r11.zzjw = r6     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0029
            r5.close()
        L_0x0029:
            return r2
        L_0x002a:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0048
            r5.close()
        L_0x0048:
            return r6
        L_0x0049:
            r0 = move-exception
            goto L_0x008c
        L_0x004b:
            r7 = move-exception
            if (r5 == 0) goto L_0x0057
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0049 }
            if (r8 == 0) goto L_0x0057
            r5.endTransaction()     // Catch:{ all -> 0x0049 }
        L_0x0057:
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzjw = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x006a:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x0076:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzjw = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
        L_0x0089:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x008c:
            if (r5 == 0) goto L_0x0091
            r5.close()
        L_0x0091:
            throw r0
        L_0x0092:
            com.google.android.gms.measurement.internal.zzef r0 = r11.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zzao(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zzgi():boolean");
    }

    /* JADX INFO: finally extract failed */
    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                if (query != null) {
                    query.close();
                }
                return j;
            }
            if (query != null) {
                query.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzjw) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzjv.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzjw = true;
        return null;
    }

    @VisibleForTesting
    private final boolean zzcg() {
        return getContext().getDatabasePath("google_app_measurement_local.db").exists();
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

    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
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
