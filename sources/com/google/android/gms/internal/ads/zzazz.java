package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzazz implements zzne {
    private static final Pattern zzbem = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzben = new AtomicReference<>();
    private final int zzbep;
    private final int zzbeq;
    private final String zzber;
    private final zznm zzbeu;
    private final zzns<? super zzazz> zzbev;
    private zznf zzbew;
    private HttpURLConnection zzbex;
    private InputStream zzbey;
    private boolean zzbez;
    private long zzbfa;
    private long zzbfb;
    private long zzbfc;
    private long zzcc;
    private SSLSocketFactory zzebs = new zzbac(this);
    /* access modifiers changed from: private */
    public int zzebt;
    private Set<Socket> zzebu = new HashSet();

    zzazz(String str, zzns<? super zzazz> zzns, int i, int i2, int i3) {
        this.zzber = zznr.checkNotEmpty(str);
        this.zzbev = zzns;
        this.zzbeu = new zznm();
        this.zzbep = i;
        this.zzbeq = i2;
        this.zzebt = i3;
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbex;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x012d A[EDGE_INSN: B:122:0x012d->B:50:0x012d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db A[Catch:{ IOException -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[Catch:{ IOException -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ea A[Catch:{ IOException -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f0 A[Catch:{ IOException -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0123 A[Catch:{ IOException -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zznf r24) throws com.google.android.gms.internal.ads.zznk {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "Unable to connect to "
            r1.zzbew = r2
            r4 = 0
            r1.zzcc = r4
            r1.zzbfc = r4
            r6 = 1
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0249 }
            android.net.Uri r7 = r2.uri     // Catch:{ IOException -> 0x0249 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0249 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0249 }
            byte[] r7 = r2.zzbek     // Catch:{ IOException -> 0x0249 }
            long r8 = r2.zzamq     // Catch:{ IOException -> 0x0249 }
            long r10 = r2.zzcb     // Catch:{ IOException -> 0x0249 }
            boolean r12 = r2.zzaz(r6)     // Catch:{ IOException -> 0x0249 }
            r14 = r7
            r7 = r0
            r0 = 0
        L_0x0027:
            int r15 = r0 + 1
            r6 = 20
            if (r0 > r6) goto L_0x0230
            java.net.URLConnection r0 = r7.openConnection()     // Catch:{ IOException -> 0x0249 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0249 }
            boolean r13 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x0249 }
            if (r13 == 0) goto L_0x003f
            r13 = r0
            javax.net.ssl.HttpsURLConnection r13 = (javax.net.ssl.HttpsURLConnection) r13     // Catch:{ IOException -> 0x0249 }
            javax.net.ssl.SSLSocketFactory r6 = r1.zzebs     // Catch:{ IOException -> 0x0249 }
            r13.setSSLSocketFactory(r6)     // Catch:{ IOException -> 0x0249 }
        L_0x003f:
            int r6 = r1.zzbep     // Catch:{ IOException -> 0x0249 }
            r0.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0249 }
            int r6 = r1.zzbeq     // Catch:{ IOException -> 0x0249 }
            r0.setReadTimeout(r6)     // Catch:{ IOException -> 0x0249 }
            com.google.android.gms.internal.ads.zznm r6 = r1.zzbeu     // Catch:{ IOException -> 0x0249 }
            java.util.Map r6 = r6.zzif()     // Catch:{ IOException -> 0x0249 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x0249 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0249 }
        L_0x0057:
            boolean r13 = r6.hasNext()     // Catch:{ IOException -> 0x0249 }
            if (r13 == 0) goto L_0x0077
            java.lang.Object r13 = r6.next()     // Catch:{ IOException -> 0x0249 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x0249 }
            java.lang.Object r17 = r13.getKey()     // Catch:{ IOException -> 0x0249 }
            r4 = r17
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0249 }
            java.lang.Object r5 = r13.getValue()     // Catch:{ IOException -> 0x0249 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0249 }
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0249 }
            r4 = 0
            goto L_0x0057
        L_0x0077:
            r4 = -1
            r17 = 0
            int r6 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r6 != 0) goto L_0x0087
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r16 = r8
            goto L_0x00d2
        L_0x0087:
            r6 = 27
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0249 }
            r13.<init>(r6)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r6 = "bytes="
            r13.append(r6)     // Catch:{ IOException -> 0x0249 }
            r13.append(r8)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r6 = "-"
            r13.append(r6)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r6 = r13.toString()     // Catch:{ IOException -> 0x0249 }
            int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00cb
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x0249 }
            long r19 = r8 + r10
            r21 = 1
            long r4 = r19 - r21
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x0249 }
            int r13 = r13.length()     // Catch:{ IOException -> 0x0249 }
            r16 = 20
            int r13 = r13 + 20
            r16 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0249 }
            r8.<init>(r13)     // Catch:{ IOException -> 0x0249 }
            r8.append(r6)     // Catch:{ IOException -> 0x0249 }
            r8.append(r4)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r6 = r8.toString()     // Catch:{ IOException -> 0x0249 }
            goto L_0x00cd
        L_0x00cb:
            r16 = r8
        L_0x00cd:
            java.lang.String r4 = "Range"
            r0.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x0249 }
        L_0x00d2:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzber     // Catch:{ IOException -> 0x0249 }
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0249 }
            if (r12 != 0) goto L_0x00e2
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0249 }
        L_0x00e2:
            r4 = 0
            r0.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x0249 }
            if (r14 == 0) goto L_0x00ea
            r4 = 1
            goto L_0x00eb
        L_0x00ea:
            r4 = 0
        L_0x00eb:
            r0.setDoOutput(r4)     // Catch:{ IOException -> 0x0249 }
            if (r14 == 0) goto L_0x010a
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)     // Catch:{ IOException -> 0x0249 }
            int r4 = r14.length     // Catch:{ IOException -> 0x0249 }
            if (r4 == 0) goto L_0x010a
            int r4 = r14.length     // Catch:{ IOException -> 0x0249 }
            r0.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x0249 }
            r0.connect()     // Catch:{ IOException -> 0x0249 }
            java.io.OutputStream r4 = r0.getOutputStream()     // Catch:{ IOException -> 0x0249 }
            r4.write(r14)     // Catch:{ IOException -> 0x0249 }
            r4.close()     // Catch:{ IOException -> 0x0249 }
            goto L_0x010d
        L_0x010a:
            r0.connect()     // Catch:{ IOException -> 0x0249 }
        L_0x010d:
            int r4 = r0.getResponseCode()     // Catch:{ IOException -> 0x0249 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x01dc
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x01dc
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x01dc
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x01dc
            if (r14 != 0) goto L_0x012d
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x01dc
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x012d
            goto L_0x01dc
        L_0x012d:
            r1.zzbex = r0     // Catch:{ IOException -> 0x0249 }
            java.net.HttpURLConnection r0 = r1.zzbex     // Catch:{ IOException -> 0x01b6 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x01b6 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x019a
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x013e
            goto L_0x019a
        L_0x013e:
            if (r0 != r3) goto L_0x014b
            long r3 = r2.zzamq
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x014d
            long r4 = r2.zzamq
            goto L_0x014e
        L_0x014b:
            r5 = 0
        L_0x014d:
            r4 = r5
        L_0x014e:
            r1.zzbfa = r4
            r3 = 1
            boolean r0 = r2.zzaz(r3)
            if (r0 != 0) goto L_0x0176
            long r3 = r2.zzcb
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0164
            long r3 = r2.zzcb
            r1.zzbfb = r3
            goto L_0x017a
        L_0x0164:
            java.net.HttpURLConnection r0 = r1.zzbex
            long r3 = zzc(r0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0172
            long r5 = r1.zzbfa
            long r3 = r3 - r5
            goto L_0x0173
        L_0x0172:
            r3 = r5
        L_0x0173:
            r1.zzbfb = r3
            goto L_0x017a
        L_0x0176:
            long r3 = r2.zzcb
            r1.zzbfb = r3
        L_0x017a:
            java.net.HttpURLConnection r0 = r1.zzbex     // Catch:{ IOException -> 0x018f }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x018f }
            r1.zzbey = r0     // Catch:{ IOException -> 0x018f }
            r3 = 1
            r1.zzbez = r3
            com.google.android.gms.internal.ads.zzns<? super com.google.android.gms.internal.ads.zzazz> r0 = r1.zzbev
            if (r0 == 0) goto L_0x018c
            r0.zza(r1, r2)
        L_0x018c:
            long r2 = r1.zzbfb
            return r2
        L_0x018f:
            r0 = move-exception
            r23.zzic()
            com.google.android.gms.internal.ads.zznk r3 = new com.google.android.gms.internal.ads.zznk
            r4 = 1
            r3.<init>(r0, r2, r4)
            throw r3
        L_0x019a:
            java.net.HttpURLConnection r3 = r1.zzbex
            java.util.Map r3 = r3.getHeaderFields()
            r23.zzic()
            com.google.android.gms.internal.ads.zznj r4 = new com.google.android.gms.internal.ads.zznj
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x01b5
            com.google.android.gms.internal.ads.zzng r0 = new com.google.android.gms.internal.ads.zzng
            r8 = 0
            r0.<init>(r8)
            r4.initCause(r0)
        L_0x01b5:
            throw r4
        L_0x01b6:
            r0 = move-exception
            r23.zzic()
            com.google.android.gms.internal.ads.zznk r4 = new com.google.android.gms.internal.ads.zznk
            android.net.Uri r5 = r2.uri
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x01d1
            java.lang.String r3 = r3.concat(r5)
            goto L_0x01d7
        L_0x01d1:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x01d7:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
        L_0x01dc:
            r5 = 0
            r8 = 0
            r14 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r0.getHeaderField(r4)     // Catch:{ IOException -> 0x0249 }
            r0.disconnect()     // Catch:{ IOException -> 0x0249 }
            if (r4 == 0) goto L_0x0228
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0249 }
            r0.<init>(r7, r4)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ IOException -> 0x0249 }
            java.lang.String r7 = "https"
            boolean r7 = r7.equals(r4)     // Catch:{ IOException -> 0x0249 }
            if (r7 != 0) goto L_0x0220
            java.lang.String r7 = "http"
            boolean r7 = r7.equals(r4)     // Catch:{ IOException -> 0x0249 }
            if (r7 != 0) goto L_0x0220
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0249 }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0249 }
            int r6 = r4.length()     // Catch:{ IOException -> 0x0249 }
            if (r6 == 0) goto L_0x0217
            java.lang.String r4 = r5.concat(r4)     // Catch:{ IOException -> 0x0249 }
            goto L_0x021c
        L_0x0217:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0249 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0249 }
        L_0x021c:
            r0.<init>(r4)     // Catch:{ IOException -> 0x0249 }
            throw r0     // Catch:{ IOException -> 0x0249 }
        L_0x0220:
            r7 = r0
            r4 = r5
            r0 = r15
            r8 = r16
            r6 = 1
            goto L_0x0027
        L_0x0228:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x0249 }
            throw r0     // Catch:{ IOException -> 0x0249 }
        L_0x0230:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0249 }
            r4 = 31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0249 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = "Too many redirects: "
            r5.append(r4)     // Catch:{ IOException -> 0x0249 }
            r5.append(r15)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x0249 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0249 }
            throw r0     // Catch:{ IOException -> 0x0249 }
        L_0x0249:
            r0 = move-exception
            com.google.android.gms.internal.ads.zznk r4 = new com.google.android.gms.internal.ads.zznk
            android.net.Uri r5 = r2.uri
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0261
            java.lang.String r3 = r3.concat(r5)
            goto L_0x0267
        L_0x0261:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r3 = r5
        L_0x0267:
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazz.zza(com.google.android.gms.internal.ads.zznf):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws zznk {
        try {
            if (this.zzbfc != this.zzbfa) {
                byte[] bArr2 = (byte[]) zzben.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (this.zzbfc != this.zzbfa) {
                    int read = this.zzbey.read(bArr2, 0, (int) Math.min(this.zzbfa - this.zzbfc, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbfc += (long) read;
                        if (this.zzbev != null) {
                            this.zzbev.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzben.set(bArr2);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbfb != -1) {
                long j = this.zzbfb - this.zzcc;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbey.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcc += (long) read2;
                if (this.zzbev != null) {
                    this.zzbev.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbfb == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zznk(e, this.zzbew, 2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.p000v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zznk {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbey     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbex     // Catch:{ all -> 0x0093 }
            long r3 = r9.zzbfb     // Catch:{ all -> 0x0093 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbfb     // Catch:{ all -> 0x0093 }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbfb     // Catch:{ all -> 0x0093 }
            long r7 = r9.zzcc     // Catch:{ all -> 0x0093 }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ all -> 0x0093 }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzof.SDK_INT     // Catch:{ all -> 0x0093 }
            r8 = 20
            if (r7 != r8) goto L_0x006b
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006b }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006b }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r2 = r9.zzbey     // Catch:{ IOException -> 0x0071 }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zznk r3 = new com.google.android.gms.internal.ads.zznk     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zznf r4 = r9.zzbew     // Catch:{ all -> 0x0093 }
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch:{ all -> 0x0093 }
            throw r3     // Catch:{ all -> 0x0093 }
        L_0x007b:
            r9.zzbey = r0
            r9.zzic()
            boolean r0 = r9.zzbez
            if (r0 == 0) goto L_0x008d
            r9.zzbez = r1
            com.google.android.gms.internal.ads.zzns<? super com.google.android.gms.internal.ads.zzazz> r0 = r9.zzbev
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            java.util.Set<java.net.Socket> r0 = r9.zzebu
            r0.clear()
            return
        L_0x0093:
            r2 = move-exception
            r9.zzbey = r0
            r9.zzic()
            boolean r0 = r9.zzbez
            if (r0 == 0) goto L_0x00a6
            r9.zzbez = r1
            com.google.android.gms.internal.ads.zzns<? super com.google.android.gms.internal.ads.zzazz> r0 = r9.zzbev
            if (r0 == 0) goto L_0x00a6
            r0.zze(r9)
        L_0x00a6:
            java.util.Set<java.net.Socket> r0 = r9.zzebu
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazz.close():void");
    }

    /* access modifiers changed from: 0000 */
    public final void setReceiveBufferSize(int i) {
        this.zzebt = i;
        for (Socket socket : this.zzebu) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzebt);
                } catch (SocketException e) {
                    zzaug.zzd("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Socket socket) {
        this.zzebu.add(socket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L_0x0034
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0013 }
            goto L_0x0036
        L_0x0013:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzaug.zzes(r1)
        L_0x0034:
            r3 = -1
        L_0x0036:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x00c9
            java.util.regex.Pattern r1 = zzbem
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x00c9
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r7 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x006c
            r3 = r5
            goto L_0x00c9
        L_0x006c:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00c9
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1 + 26
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch:{ NumberFormatException -> 0x00a8 }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00a8 }
            int r1 = r1 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.<init>(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r1 = "Inconsistent headers ["
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r0 = "] ["
            r7.append(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r9)     // Catch:{ NumberFormatException -> 0x00a8 }
            r7.append(r2)     // Catch:{ NumberFormatException -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ NumberFormatException -> 0x00a8 }
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ NumberFormatException -> 0x00a8 }
            long r0 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x00a8 }
            r3 = r0
            goto L_0x00c9
        L_0x00a8:
            java.lang.String r0 = java.lang.String.valueOf(r9)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r9)
            r1.append(r2)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzaug.zzes(r9)
        L_0x00c9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazz.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzic() {
        HttpURLConnection httpURLConnection = this.zzbex;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzaug.zzc("Unexpected error while disconnecting", e);
            }
            this.zzbex = null;
        }
    }
}
