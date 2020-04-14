package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzar extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ boolean zzbi;
    private final /* synthetic */ String zzx;

    zzar(zzz zzz, String str, String str2, boolean z, zzl zzl) {
        this.zzaa = zzz;
        this.zzx = str;
        this.zzas = str2;
        this.zzbi = z;
        this.zzat = zzl;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x0002: INVOKE  (r0v1 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (wrap: java.lang.String
              0x0006: IGET  (r1v0 java.lang.String) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzx java.lang.String), (wrap: java.lang.String
              0x0008: IGET  (r2v0 java.lang.String) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzas java.lang.String), (wrap: boolean
              0x000a: IGET  (r3v0 boolean) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzbi boolean), (wrap: com.google.android.gms.internal.measurement.zzl
              0x000c: IGET  (r4v0 com.google.android.gms.internal.measurement.zzl) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzat com.google.android.gms.internal.measurement.zzl) com.google.android.gms.internal.measurement.zzk.getUserProperties(java.lang.String, java.lang.String, boolean, com.google.android.gms.internal.measurement.zzp):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzar.zzf():void, dex: classes2.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE  (r0v1 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r5v0 'this' com.google.android.gms.internal.measurement.zzar A[THIS]) com.google.android.gms.internal.measurement.zzar.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzar.zzf():void, dex: classes2.dex
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
            com.google.android.gms.internal.measurement.zzz r0 = r5.zzaa
            com.google.android.gms.internal.measurement.zzk r0 = 
            // error: 0x0002: INVOKE  (r0 I:com.google.android.gms.internal.measurement.zzk) = (r0 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            java.lang.String r1 = r5.zzx
            java.lang.String r2 = r5.zzas
            boolean r3 = r5.zzbi
            com.google.android.gms.internal.measurement.zzl r4 = r5.zzat
            r0.getUserProperties(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzar.zzf():void");
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
