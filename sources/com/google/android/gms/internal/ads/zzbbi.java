package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbbi extends zzbax {
    private static final Set<String> zzedr = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzeds = new DecimalFormat("#,###");
    private File zzedt;
    private boolean zzedu;

    public zzbbi(zzazj zzazj) {
        super(zzazj);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzaug.zzeu("Context.getCacheDir() returned null");
            return;
        }
        this.zzedt = new File(cacheDir, "admobVideoStreams");
        if (!this.zzedt.isDirectory() && !this.zzedt.mkdirs()) {
            String str = "Could not create preload cache directory at ";
            String valueOf = String.valueOf(this.zzedt.getAbsolutePath());
            zzaug.zzeu(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzedt = null;
        } else if (!this.zzedt.setReadable(true, false) || !this.zzedt.setExecutable(true, false)) {
            String str2 = "Could not set cache file permissions at ";
            String valueOf2 = String.valueOf(this.zzedt.getAbsolutePath());
            zzaug.zzeu(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            this.zzedt = null;
        }
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v34, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r1v41 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r1v42 */
    /* JADX WARNING: type inference failed for: r1v43 */
    /* JADX WARNING: type inference failed for: r1v47 */
    /* JADX WARNING: type inference failed for: r1v50 */
    /* JADX WARNING: type inference failed for: r24v5, types: [int] */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r1v55 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r1v62 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r1v75 */
    /* JADX WARNING: type inference failed for: r2v60, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r1v82, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: type inference failed for: r1v92 */
    /* JADX WARNING: type inference failed for: r1v93 */
    /* JADX WARNING: type inference failed for: r1v94 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r24v21 */
    /* JADX WARNING: type inference failed for: r1v95 */
    /* JADX WARNING: type inference failed for: r1v96 */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r24v23 */
    /* JADX WARNING: type inference failed for: r24v24 */
    /* JADX WARNING: type inference failed for: r1v97 */
    /* JADX WARNING: type inference failed for: r24v25 */
    /* JADX WARNING: type inference failed for: r24v26 */
    /* JADX WARNING: type inference failed for: r24v27 */
    /* JADX WARNING: type inference failed for: r24v28 */
    /* JADX WARNING: type inference failed for: r24v29 */
    /* JADX WARNING: type inference failed for: r24v30 */
    /* JADX WARNING: type inference failed for: r24v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f0, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fb, code lost:
        if (r1 < 400) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fd, code lost:
        r15 = "badUrl";
        r0 = "HTTP request failed. Code: ";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x020d, code lost:
        if (r2.length() == 0) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x020f, code lost:
        r2 = r0.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0215, code lost:
        r2 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0242, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0243, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024b, code lost:
        if (r7 >= 0) goto L_0x0276;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024d, code lost:
        r0 = "Stream cache aborted, missing content-length header at ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0257, code lost:
        if (r1.length() == 0) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0259, code lost:
        r0 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025e, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0264, code lost:
        com.google.android.gms.internal.ads.zzaug.zzeu(r0);
        zza(r9, r12.getAbsolutePath(), "contentLengthMissing", null);
        zzedr.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0275, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r1 = zzeds.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzuv.zzon().zzd(com.google.android.gms.internal.ads.zzza.zzchh)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028d, code lost:
        if (r7 <= r3) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r9);
        com.google.android.gms.internal.ads.zzaug.zzeu(r2.toString());
        r0 = "File too big for full file cache. Size: ";
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c8, code lost:
        if (r1.length() == 0) goto L_0x02cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02ca, code lost:
        r0 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02cf, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d5, code lost:
        zza(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        zzedr.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02e3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzaug.zzdv(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzq.zzkq();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x033d, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r6 = new com.google.android.gms.internal.ads.zzawo(((java.lang.Long) com.google.android.gms.internal.ads.zzuv.zzon().zzd(com.google.android.gms.internal.ads.zzza.zzchk)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzuv.zzon().zzd(com.google.android.gms.internal.ads.zzza.zzchj)).longValue();
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0357, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x035b, code lost:
        if (r20 < 0) goto L_0x0477;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x035d, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x035f, code lost:
        if (r11 <= r3) goto L_0x0394;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0361, code lost:
        r15 = "sizeExceeded";
        r0 = "File too big for full file cache. Size: ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0371, code lost:
        if (r1.length() == 0) goto L_0x0379;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0373, code lost:
        r1 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0379, code lost:
        r1 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0385, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0386, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0389, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x038c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x038f, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0391, code lost:
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x039b, code lost:
        if (r2.write(r1) > 0) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039d, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03ac, code lost:
        if (r24 > 0) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ae, code lost:
        r20 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03b2, code lost:
        if (r8.zzedu != false) goto L_0x0417;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03b8, code lost:
        if (r6.tryAcquire() == false) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03c0, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03c2, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03c4, code lost:
        r24 = r10;
        r10 = com.google.android.gms.internal.ads.zzawy.zzzb;
        r1 = r1;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03e2, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzbba(r30, r31, r12.getAbsolutePath(), r11, r7, false);
        r10.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ec, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03f1, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0403, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0417, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0426, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0427, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x042f, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x045a, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x045b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x045e, code lost:
        r2 = r2.toString();
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0465, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x046d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0470, code lost:
        r27 = r4;
        r22 = r15;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0477, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0486, code lost:
        if (com.google.android.gms.internal.ads.zzaug.isLoggable(3) == false) goto L_0x04c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0488, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        r1 = zzeds.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzaug.zzdv(r3.toString());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04bf, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04c1, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:?, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04d0, code lost:
        if (r0.isFile() == false) goto L_0x04da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04d2, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04da, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        r0.createNewFile();
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        zza(r9, r12.getAbsolutePath(), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x04e6, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        zzedr.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04ec, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04ed, code lost:
        r0 = e;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04f1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04f4, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04f6, code lost:
        r15 = r22;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04fc, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0500, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0503, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0506, code lost:
        r22 = r15;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x050c, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0516, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0517, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0521, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0522, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0525, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0528, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x052b, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x052e, code lost:
        r2 = null;
        r10 = null;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0534, code lost:
        com.google.android.gms.ads.internal.zzq.zzkn().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0544, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzaug.zzet(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0568, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzaug.zzd(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05a7, code lost:
        r0 = r0.concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x05ac, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0403, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012f, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzkv();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzuv.zzon().zzd(com.google.android.gms.internal.ads.zzza.zzchl)).intValue();
        r3 = new java.net.URL(r9);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014b, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x014e, code lost:
        if (r2 > 20) goto L_0x0517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0150, code lost:
        r5 = r3.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015c, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x050c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015e, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzaxc();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0175, code lost:
        if ((r7 / 100) != 3) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4 = r5.getHeaderField(com.appsflyer.share.Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017d, code lost:
        if (r4 == null) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017f, code lost:
        r6 = new java.net.URL(r3, r4);
        r3 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0188, code lost:
        if (r3 == null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0190, code lost:
        if (r3.equals("http") != false) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0198, code lost:
        if (r3.equals("https") != false) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019a, code lost:
        r1 = "Unsupported scheme: ";
        r2 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a6, code lost:
        if (r2.length() == 0) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a8, code lost:
        r1 = r1.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ad, code lost:
        r1 = new java.lang.String(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b6, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b7, code lost:
        r3 = "Redirecting to ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c1, code lost:
        if (r4.length() == 0) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c3, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c8, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ce, code lost:
        com.google.android.gms.internal.ads.zzaug.zzdv(r3);
        r5.disconnect();
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01de, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e6, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ea, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01eb, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:217:0x04dd */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v9
      assigns: []
      uses: []
      mth insns count: 574
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
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04bf A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v16 java.lang.String), (r22v16 java.lang.String) binds: [B:215:0x04da, B:216:?, B:213:0x04d2, B:214:?, B:203:0x0488, B:204:?, B:172:0x03c2, B:175:0x03e2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 ?) = (r24v12 ?), (r24v13 ?), (r24v15 ?), (r24v17 ?), (r24v19 ?), (r24v21 ?), (r24v26 ?), (r24v30 ?) binds: [B:215:0x04da, B:216:?, B:213:0x04d2, B:214:?, B:203:0x0488, B:204:?, B:172:0x03c2, B:175:0x03e2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v10 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v18 java.io.FileOutputStream), (r27v15 java.io.FileOutputStream) binds: [B:215:0x04da, B:216:?, B:213:0x04d2, B:214:?, B:203:0x0488, B:204:?, B:175:0x03e2, B:172:0x03c2] A[DONT_GENERATE, DONT_INLINE], Splitter:B:175:0x03e2] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0534  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0544  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0568  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x05a7  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x05ac  */
    /* JADX WARNING: Unknown variable types count: 24 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfd(java.lang.String r31) {
        /*
            r30 = this;
            r8 = r30
            r9 = r31
            java.io.File r0 = r8.zzedt
            r10 = 0
            r11 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "noCacheDir"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0010:
            java.io.File r0 = r8.zzedt
            if (r0 != 0) goto L_0x0016
            r3 = 0
            goto L_0x0032
        L_0x0016:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001d:
            if (r2 >= r1) goto L_0x0032
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x002f
            int r3 = r3 + 1
        L_0x002f:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x0032:
            com.google.android.gms.internal.ads.zzyp<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzza.zzchg
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0096
            java.io.File r0 = r8.zzedt
            if (r0 != 0) goto L_0x004a
        L_0x0048:
            r0 = 0
            goto L_0x0089
        L_0x004a:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = r1
            r2 = r10
            r1 = 0
        L_0x0057:
            if (r1 >= r3) goto L_0x0074
            r6 = r0[r1]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0071
            long r12 = r6.lastModified()
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0071
            r2 = r6
            r4 = r12
        L_0x0071:
            int r1 = r1 + 1
            goto L_0x0057
        L_0x0074:
            if (r2 == 0) goto L_0x0048
            boolean r0 = r2.delete()
            java.io.File r1 = r8.zzc(r2)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0089
            boolean r1 = r1.delete()
            r0 = r0 & r1
        L_0x0089:
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)
            java.lang.String r0 = "expireFailed"
            r8.zza(r9, r10, r0, r10)
            return r11
        L_0x0096:
            java.lang.String r0 = r30.zzfe(r31)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzedt
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzc(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d9
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00d9
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00c8
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00ce
        L_0x00c8:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00ce:
            com.google.android.gms.internal.ads.zzaug.zzdv(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r1)
            return r13
        L_0x00d9:
            java.io.File r1 = r8.zzedt
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00f3
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x00f9
        L_0x00f3:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x00f9:
            java.util.Set<java.lang.String> r1 = zzedr
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = zzedr     // Catch:{ all -> 0x05c3 }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x05c3 }
            if (r2 == 0) goto L_0x0129
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ all -> 0x05c3 }
            int r3 = r2.length()     // Catch:{ all -> 0x05c3 }
            if (r3 == 0) goto L_0x0115
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x05c3 }
            goto L_0x011b
        L_0x0115:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x05c3 }
            r2.<init>(r0)     // Catch:{ all -> 0x05c3 }
            r0 = r2
        L_0x011b:
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ all -> 0x05c3 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x05c3 }
            java.lang.String r2 = "inProgress"
            r8.zza(r9, r0, r2, r10)     // Catch:{ all -> 0x05c3 }
            monitor-exit(r1)     // Catch:{ all -> 0x05c3 }
            return r11
        L_0x0129:
            java.util.Set<java.lang.String> r2 = zzedr     // Catch:{ all -> 0x05c3 }
            r2.add(r14)     // Catch:{ all -> 0x05c3 }
            monitor-exit(r1)     // Catch:{ all -> 0x05c3 }
            java.lang.String r15 = "error"
            com.google.android.gms.ads.internal.zzq.zzkv()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzza.zzchl     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzyw r2 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r3 = r2
            r2 = 0
        L_0x014b:
            int r2 = r2 + r13
            r4 = 20
            if (r2 > r4) goto L_0x0517
            java.net.URLConnection r5 = r3.openConnection()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r5.setConnectTimeout(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r5.setReadTimeout(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            if (r6 == 0) goto L_0x050c
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzaxc r6 = new com.google.android.gms.internal.ads.zzaxc     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r6.<init>()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r6.zza(r5, r10)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r7 = r5.getResponseCode()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r6.zza(r5, r7)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01ee
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r4 == 0) goto L_0x01df
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r6.<init>(r3, r4)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r3 = r6.getProtocol()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r3 == 0) goto L_0x01d7
            java.lang.String r7 = "http"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r7 != 0) goto L_0x01b7
            java.lang.String r7 = "https"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r7 != 0) goto L_0x01b7
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r1 = "Unsupported scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r3 == 0) goto L_0x01ad
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            goto L_0x01b3
        L_0x01ad:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r1 = r2
        L_0x01b3:
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            throw r0     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
        L_0x01b7:
            java.lang.String r3 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r7 == 0) goto L_0x01c8
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            goto L_0x01ce
        L_0x01c8:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r3 = r4
        L_0x01ce:
            com.google.android.gms.internal.ads.zzaug.zzdv(r3)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r5.disconnect()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r3 = r6
            goto L_0x014b
        L_0x01d7:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r1 = "Protocol is null"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            throw r0     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
        L_0x01df:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r1 = "Missing Location header in redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            throw r0     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
        L_0x01e7:
            r0 = move-exception
            goto L_0x01ea
        L_0x01e9:
            r0 = move-exception
        L_0x01ea:
            r2 = r10
        L_0x01eb:
            r1 = r14
            goto L_0x0530
        L_0x01ee:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            if (r1 == 0) goto L_0x0247
            r1 = r5
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r1 = r1.getResponseCode()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x0247
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r3 == 0) goto L_0x0215
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2 = r0
            goto L_0x021a
        L_0x0215:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
        L_0x021a:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            r4.append(r1)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            java.lang.String r1 = " at "
            r4.append(r1)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            r4.append(r9)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
            throw r0     // Catch:{ IOException -> 0x0245, RuntimeException -> 0x0243 }
        L_0x0243:
            r0 = move-exception
            goto L_0x01eb
        L_0x0245:
            r0 = move-exception
            goto L_0x01eb
        L_0x0247:
            int r7 = r5.getContentLength()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            if (r7 >= 0) goto L_0x0276
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r2 == 0) goto L_0x025e
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            goto L_0x0264
        L_0x025e:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r0 = r1
        L_0x0264:
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r1 = "contentLengthMissing"
            r8.zza(r9, r0, r1, r10)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.util.Set<java.lang.String> r0 = zzedr     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            return r11
        L_0x0276:
            java.text.DecimalFormat r1 = zzeds     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            long r2 = (long) r7     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzza.zzchh     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzyw r3 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r3 = r2.intValue()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            if (r7 <= r3) goto L_0x02e4
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r0 = "Content length "
            r2.append(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2.append(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r2.append(r9)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            if (r2 == 0) goto L_0x02cf
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            goto L_0x02d5
        L_0x02cf:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r0 = r1
        L_0x02d5:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.lang.String r2 = "sizeExceeded"
            r8.zza(r9, r1, r2, r0)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            java.util.Set<java.lang.String> r0 = zzedr     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01e9, RuntimeException -> 0x01e7 }
            return r11
        L_0x02e4:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.String r2 = "Caching "
            r4.append(r2)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r4.append(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r4.append(r9)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            com.google.android.gms.internal.ads.zzaug.zzdv(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x052a, RuntimeException -> 0x0528 }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzza.zzchk     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            com.google.android.gms.internal.ads.zzyw r10 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            java.lang.Object r6 = r10.zzd(r6)     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x0502, RuntimeException -> 0x0500 }
            r10 = r14
            long r13 = r6.longValue()     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            com.google.android.gms.internal.ads.zzawo r6 = new com.google.android.gms.internal.ads.zzawo     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            r6.<init>(r13)     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r13 = com.google.android.gms.internal.ads.zzza.zzchj     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            com.google.android.gms.internal.ads.zzyw r14 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            java.lang.Object r13 = r14.zzd(r13)     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            long r13 = r13.longValue()     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
        L_0x0357:
            int r20 = r5.read(r1)     // Catch:{ IOException -> 0x04fb, RuntimeException -> 0x04f9 }
            if (r20 < 0) goto L_0x0477
            int r11 = r11 + r20
            if (r11 <= r3) goto L_0x0394
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r11)     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
            int r2 = r1.length()     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
            if (r2 == 0) goto L_0x0379
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
            r1 = r0
            goto L_0x037e
        L_0x0379:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
            r1.<init>(r0)     // Catch:{ IOException -> 0x038e, RuntimeException -> 0x038c }
        L_0x037e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0388, RuntimeException -> 0x0386 }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0388, RuntimeException -> 0x0386 }
            throw r0     // Catch:{ IOException -> 0x0388, RuntimeException -> 0x0386 }
        L_0x0386:
            r0 = move-exception
            goto L_0x0389
        L_0x0388:
            r0 = move-exception
        L_0x0389:
            r2 = r1
            r1 = r10
            goto L_0x0391
        L_0x038c:
            r0 = move-exception
            goto L_0x038f
        L_0x038e:
            r0 = move-exception
        L_0x038f:
            r1 = r10
            r2 = 0
        L_0x0391:
            r10 = r4
            goto L_0x0530
        L_0x0394:
            r1.flip()     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
        L_0x0397:
            int r20 = r2.write(r1)     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            if (r20 > 0) goto L_0x0469
            r1.clear()     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            long r20 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            long r20 = r20 - r17
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r13
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 > 0) goto L_0x0427
            r20 = r1
            boolean r1 = r8.zzedu     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            if (r1 != 0) goto L_0x0417
            boolean r1 = r6.tryAcquire()     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            if (r1 == 0) goto L_0x03f1
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzawy.zzzb     // Catch:{ IOException -> 0x046f, RuntimeException -> 0x046d }
            r22 = r15
            com.google.android.gms.internal.ads.zzbba r15 = new com.google.android.gms.internal.ads.zzbba     // Catch:{ IOException -> 0x03eb, RuntimeException -> 0x03e9 }
            r23 = 0
            r24 = r10
            r10 = r1
            r1 = r15
            r25 = r2
            r2 = r30
            r26 = r3
            r3 = r31
            r27 = r4
            r4 = r21
            r21 = r5
            r5 = r11
            r19 = r6
            r28 = 3
            r6 = r7
            r29 = r7
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            r10.post(r15)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            goto L_0x0403
        L_0x03e9:
            r0 = move-exception
            goto L_0x03ec
        L_0x03eb:
            r0 = move-exception
        L_0x03ec:
            r27 = r4
            r1 = r10
            goto L_0x04f6
        L_0x03f1:
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
        L_0x0403:
            r6 = r19
            r1 = r20
            r5 = r21
            r15 = r22
            r10 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r29
            goto L_0x0357
        L_0x0417:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            throw r0     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
        L_0x0427:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r13)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            r2.append(r0)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.lang.String r10 = r2.toString()     // Catch:{ IOException -> 0x0467, RuntimeException -> 0x0465 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x045d, RuntimeException -> 0x045b }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x045d, RuntimeException -> 0x045b }
            throw r0     // Catch:{ IOException -> 0x045d, RuntimeException -> 0x045b }
        L_0x045b:
            r0 = move-exception
            goto L_0x045e
        L_0x045d:
            r0 = move-exception
        L_0x045e:
            r2 = r10
            r1 = r24
            r10 = r27
            goto L_0x0530
        L_0x0465:
            r0 = move-exception
            goto L_0x04c4
        L_0x0467:
            r0 = move-exception
            goto L_0x04c4
        L_0x0469:
            r28 = 3
            goto L_0x0397
        L_0x046d:
            r0 = move-exception
            goto L_0x0470
        L_0x046f:
            r0 = move-exception
        L_0x0470:
            r27 = r4
            r22 = r15
            r1 = r10
            goto L_0x0508
        L_0x0477:
            r27 = r4
            r24 = r10
            r22 = r15
            r28 = 3
            r27.close()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            boolean r1 = com.google.android.gms.internal.ads.zzaug.isLoggable(r28)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            if (r1 == 0) goto L_0x04c7
            java.text.DecimalFormat r1 = zzeds     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            long r2 = (long) r11     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            int r2 = r2.length()     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            int r3 = r3.length()     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            r3.<init>(r2)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            r3.append(r1)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            r3.append(r9)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            com.google.android.gms.internal.ads.zzaug.zzdv(r1)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            goto L_0x04c7
        L_0x04bf:
            r0 = move-exception
            goto L_0x04c2
        L_0x04c1:
            r0 = move-exception
        L_0x04c2:
            r15 = r22
        L_0x04c4:
            r1 = r24
            goto L_0x0508
        L_0x04c7:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            if (r1 == 0) goto L_0x04da
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x04c1, RuntimeException -> 0x04bf }
            goto L_0x04dd
        L_0x04da:
            r0.createNewFile()     // Catch:{ IOException -> 0x04dd, RuntimeException -> 0x04bf }
        L_0x04dd:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            r8.zza(r9, r0, r11)     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            java.util.Set<java.lang.String> r0 = zzedr     // Catch:{ IOException -> 0x04f3, RuntimeException -> 0x04f1 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x04ef, RuntimeException -> 0x04ed }
            r0 = 1
            return r0
        L_0x04ed:
            r0 = move-exception
            goto L_0x04f6
        L_0x04ef:
            r0 = move-exception
            goto L_0x04f6
        L_0x04f1:
            r0 = move-exception
            goto L_0x04f4
        L_0x04f3:
            r0 = move-exception
        L_0x04f4:
            r1 = r24
        L_0x04f6:
            r15 = r22
            goto L_0x0508
        L_0x04f9:
            r0 = move-exception
            goto L_0x04fc
        L_0x04fb:
            r0 = move-exception
        L_0x04fc:
            r27 = r4
            r1 = r10
            goto L_0x0506
        L_0x0500:
            r0 = move-exception
            goto L_0x0503
        L_0x0502:
            r0 = move-exception
        L_0x0503:
            r27 = r4
            r1 = r14
        L_0x0506:
            r22 = r15
        L_0x0508:
            r10 = r27
            r2 = 0
            goto L_0x0530
        L_0x050c:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            java.lang.String r2 = "Invalid protocol."
            r0.<init>(r2)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            throw r0     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
        L_0x0517:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            java.lang.String r2 = "Too many redirects (20)"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
            throw r0     // Catch:{ IOException -> 0x0524, RuntimeException -> 0x0522 }
        L_0x0522:
            r0 = move-exception
            goto L_0x0525
        L_0x0524:
            r0 = move-exception
        L_0x0525:
            r15 = r22
            goto L_0x052e
        L_0x0528:
            r0 = move-exception
            goto L_0x052b
        L_0x052a:
            r0 = move-exception
        L_0x052b:
            r1 = r14
            r22 = r15
        L_0x052e:
            r2 = 0
            r10 = 0
        L_0x0530:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x053d
            com.google.android.gms.internal.ads.zzatr r3 = com.google.android.gms.ads.internal.zzq.zzkn()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zza(r0, r4)
        L_0x053d:
            r10.close()     // Catch:{ IOException | NullPointerException -> 0x0540 }
        L_0x0540:
            boolean r3 = r8.zzedu
            if (r3 == 0) goto L_0x0568
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r3.append(r0)
            r3.append(r9)
            java.lang.String r0 = "\""
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.ads.zzaug.zzet(r0)
            goto L_0x058b
        L_0x0568:
            java.lang.String r3 = java.lang.String.valueOf(r31)
            int r3 = r3.length()
            int r3 = r3 + 25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Preload failed for URL \""
            r4.append(r3)
            r4.append(r9)
            java.lang.String r3 = "\""
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.google.android.gms.internal.ads.zzaug.zzd(r3, r0)
        L_0x058b:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x05b5
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x05b5
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x05ac
            java.lang.String r0 = r0.concat(r3)
            goto L_0x05b2
        L_0x05ac:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0)
            r0 = r3
        L_0x05b2:
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)
        L_0x05b5:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zza(r9, r0, r15, r2)
            java.util.Set<java.lang.String> r0 = zzedr
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x05c3:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x05c3 }
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbi.zzfd(java.lang.String):boolean");
    }

    public final void abort() {
        this.zzedu = true;
    }

    private final File zzc(File file) {
        return new File(this.zzedt, String.valueOf(file.getName()).concat(".done"));
    }
}
