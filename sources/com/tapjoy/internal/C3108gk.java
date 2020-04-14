package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.gk */
public final class C3108gk {

    /* renamed from: a */
    public long f7343a;

    /* renamed from: b */
    public long f7344b;

    /* renamed from: c */
    public long f7345c;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30187a(java.lang.String r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = 0
            r2 = 0
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x00fd, all -> 0x00f4 }
            r3.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00f4 }
            r2 = r21
            r3.setSoTimeout(r2)     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r20)     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r4 = 48
            byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r7 = 123(0x7b, float:1.72E-43)
            r6.<init>(r5, r4, r2, r7)     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r2 = 27
            r5[r0] = r2     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r13 = r7 / r11
            java.lang.Long.signum(r13)
            long r15 = r13 * r11
            long r15 = r7 - r15
            r17 = 2208988800(0x83aa7e80, double:1.091385478E-314)
            long r13 = r13 + r17
            r2 = 24
            long r11 = r13 >> r2
            int r12 = (int) r11
            byte r11 = (byte) r12
            r12 = 40
            r5[r12] = r11     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r11 = 41
            r17 = 16
            r18 = r3
            long r2 = r13 >> r17
            int r3 = (int) r2
            byte r2 = (byte) r3
            r5[r11] = r2     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2 = 42
            r3 = 8
            long r0 = r13 >> r3
            int r1 = (int) r0
            byte r0 = (byte) r1
            r5[r2] = r0     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 43
            r1 = 0
            long r13 = r13 >> r1
            int r1 = (int) r13     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 4294967296(0x100000000, double:2.121995791E-314)
            long r15 = r15 * r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 / r0
            r0 = 44
            r1 = 24
            long r13 = r15 >> r1
            int r1 = (int) r13     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 45
            long r1 = r15 >> r17
            int r2 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r2     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 46
            long r1 = r15 >> r3
            int r2 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r2     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r0 = 47
            double r1 = java.lang.Math.random()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r13 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r1 = r1 * r13
            int r1 = (int) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            byte r1 = (byte) r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r5[r0] = r1     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r1 = r18
            r1.send(r6)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r0.<init>(r5, r4)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r1.receive(r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r9 = r2 - r9
            long r7 = r7 + r9
            r0 = 24
            long r13 = m7172b(r5, r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            r0 = 32
            long r15 = m7172b(r5, r0)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r4 = m7172b(r5, r12)     // Catch:{ Exception -> 0x00da, all -> 0x00d6 }
            long r17 = r4 - r15
            long r9 = r9 - r17
            long r15 = r15 - r13
            long r4 = r4 - r7
            long r15 = r15 + r4
            r4 = 2
            long r15 = r15 / r4
            long r7 = r7 + r15
            r4 = r19
            r4.f7343a = r7     // Catch:{ Exception -> 0x00ff, all -> 0x00d4 }
            r4.f7344b = r2     // Catch:{ Exception -> 0x00ff, all -> 0x00d4 }
            r4.f7345c = r9     // Catch:{ Exception -> 0x00ff, all -> 0x00d4 }
            r1.close()
            r0 = 1
            return r0
        L_0x00d4:
            r0 = move-exception
            goto L_0x00f7
        L_0x00d6:
            r0 = move-exception
            r4 = r19
            goto L_0x00f7
        L_0x00da:
            r4 = r19
            goto L_0x00ff
        L_0x00dd:
            r0 = move-exception
            r4 = r19
            goto L_0x00e6
        L_0x00e1:
            r4 = r19
            goto L_0x00ea
        L_0x00e4:
            r0 = move-exception
            r4 = r1
        L_0x00e6:
            r1 = r18
            goto L_0x00f7
        L_0x00e9:
            r4 = r1
        L_0x00ea:
            r1 = r18
            goto L_0x00ff
        L_0x00ed:
            r0 = move-exception
            r4 = r1
            r1 = r3
            goto L_0x00f7
        L_0x00f1:
            r4 = r1
            r1 = r3
            goto L_0x00ff
        L_0x00f4:
            r0 = move-exception
            r4 = r1
            r1 = r2
        L_0x00f7:
            if (r1 == 0) goto L_0x00fc
            r1.close()
        L_0x00fc:
            throw r0
        L_0x00fd:
            r4 = r1
            r1 = r2
        L_0x00ff:
            if (r1 == 0) goto L_0x0104
            r1.close()
        L_0x0104:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3108gk.mo30187a(java.lang.String, int):boolean");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v0, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r1v1, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v1, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r5v1, types: [byte] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m7171a(byte[] r5, int r6) {
        /*
            byte r0 = r5[r6]
            int r1 = r6 + 1
            byte r1 = r5[r1]
            int r2 = r6 + 2
            byte r2 = r5[r2]
            int r6 = r6 + 3
            byte r5 = r5[r6]
            r6 = r0 & 128(0x80, float:1.794E-43)
            r3 = 128(0x80, float:1.794E-43)
            if (r6 != r3) goto L_0x0018
            r6 = r0 & 127(0x7f, float:1.78E-43)
            int r0 = r6 + 128
        L_0x0018:
            r6 = r1 & 128(0x80, float:1.794E-43)
            if (r6 != r3) goto L_0x0020
            r6 = r1 & 127(0x7f, float:1.78E-43)
            int r1 = r6 + 128
        L_0x0020:
            r6 = r2 & 128(0x80, float:1.794E-43)
            if (r6 != r3) goto L_0x0028
            r6 = r2 & 127(0x7f, float:1.78E-43)
            int r2 = r6 + 128
        L_0x0028:
            r6 = r5 & 128(0x80, float:1.794E-43)
            if (r6 != r3) goto L_0x002f
            r5 = r5 & 127(0x7f, float:1.78E-43)
            int r5 = r5 + r3
        L_0x002f:
            long r3 = (long) r0
            r6 = 24
            long r3 = r3 << r6
            long r0 = (long) r1
            r6 = 16
            long r0 = r0 << r6
            long r3 = r3 + r0
            long r0 = (long) r2
            r6 = 8
            long r0 = r0 << r6
            long r3 = r3 + r0
            long r5 = (long) r5
            long r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3108gk.m7171a(byte[], int):long");
    }

    /* renamed from: b */
    private static long m7172b(byte[] bArr, int i) {
        return ((m7171a(bArr, i) - 2208988800L) * 1000) + ((m7171a(bArr, i + 4) * 1000) / 4294967296L);
    }
}
