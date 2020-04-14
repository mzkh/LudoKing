package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzay extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ Long zzbm;
    private final /* synthetic */ String zzbn;
    private final /* synthetic */ Bundle zzbo;
    private final /* synthetic */ boolean zzbp;
    private final /* synthetic */ boolean zzbq;
    private final /* synthetic */ String zzx;

    zzay(zzz zzz, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        this.zzaa = zzz;
        this.zzbm = l;
        this.zzx = str;
        this.zzbn = str2;
        this.zzbo = bundle;
        this.zzbp = z;
        this.zzbq = z2;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        Long l = this.zzbm;
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x000e: INVOKE  (r2v0 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x000c: IGET  (r0v2 com.google.android.gms.internal.measurement.zzz) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (wrap: java.lang.String
              0x0012: IGET  (r3v0 java.lang.String) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzx java.lang.String), (wrap: java.lang.String
              0x0014: IGET  (r4v0 java.lang.String) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzbn java.lang.String), (wrap: android.os.Bundle
              0x0016: IGET  (r5v0 android.os.Bundle) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzbo android.os.Bundle), (wrap: boolean
              0x0018: IGET  (r6v0 boolean) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzbp boolean), (wrap: boolean
              0x001a: IGET  (r7v0 boolean) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzbq boolean), (wrap: long
              ?: TERNARY(r0v1 long) = (wrap: long
              0x0004: IGET  (r0v4 long) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.timestamp long), (wrap: long
              0x0007: INVOKE  (r0v3 long) = (r0v0 'l' java.lang.Long) java.lang.Long.longValue():long type: VIRTUAL)) com.google.android.gms.internal.measurement.zzk.logEvent(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzay.zzf():void, dex: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  (r2v0 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x000c: IGET  (r0v2 com.google.android.gms.internal.measurement.zzz) = (r10v0 'this' com.google.android.gms.internal.measurement.zzay A[THIS]) com.google.android.gms.internal.measurement.zzay.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzay.zzf():void, dex: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:88)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:682)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
            	... 19 more
            Caused by: java.lang.ArrayIndexOutOfBoundsException: Index -2 out of bounds for length 2
            	at java.base/java.util.ArrayList.add(ArrayList.java:486)
            	at java.base/java.util.ArrayList.add(ArrayList.java:498)
            	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:82)
            	at jadx.core.dex.nodes.InsnNode.attachArg(InsnNode.java:87)
            	at jadx.core.dex.nodes.InsnNode.addArg(InsnNode.java:73)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:335)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:24)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:9)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:333)
            	at jadx.core.dex.nodes.InsnNode.copy(InsnNode.java:350)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:880)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:669)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
            	... 24 more
            */
        /*
            this = this;
            java.lang.Long r0 = r10.zzbm
            if (r0 != 0) goto L_0x0007
            long r0 = r10.timestamp
            goto L_0x000b
        L_0x0007:
            long r0 = r0.longValue()
        L_0x000b:
            r8 = r0
            com.google.android.gms.internal.measurement.zzz r0 = r10.zzaa
            com.google.android.gms.internal.measurement.zzk r2 = 
            // error: 0x000e: INVOKE  (r2 I:com.google.android.gms.internal.measurement.zzk) = (r0 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            java.lang.String r3 = r10.zzx
            java.lang.String r4 = r10.zzbn
            android.os.Bundle r5 = r10.zzbo
            boolean r6 = r10.zzbp
            boolean r7 = r10.zzbq
            r2.logEvent(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzay.zzf():void");
    }
}
