package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzgk;

final class zzal extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzgk zzbc;

    zzal(zzz zzz, zzgk zzgk) {
        this.zzaa = zzz;
        this.zzbc = zzgk;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x0002: INVOKE  (r0v1 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r3v0 'this' com.google.android.gms.internal.measurement.zzal A[THIS]) com.google.android.gms.internal.measurement.zzal.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (wrap: com.google.android.gms.internal.measurement.zzz$zza
              0x000a: CONSTRUCTOR  (r1v0 com.google.android.gms.internal.measurement.zzz$zza) = (wrap: com.google.android.gms.measurement.internal.zzgk
              0x0008: IGET  (r2v0 com.google.android.gms.measurement.internal.zzgk) = (r3v0 'this' com.google.android.gms.internal.measurement.zzal A[THIS]) com.google.android.gms.internal.measurement.zzal.zzbc com.google.android.gms.measurement.internal.zzgk) com.google.android.gms.internal.measurement.zzz.zza.<init>(com.google.android.gms.measurement.internal.zzgk):void CONSTRUCTOR) com.google.android.gms.internal.measurement.zzk.setEventInterceptor(com.google.android.gms.internal.measurement.zzq):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzal.zzf():void, dex: classes2.dex
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
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r3v0 'this' com.google.android.gms.internal.measurement.zzal A[THIS]) com.google.android.gms.internal.measurement.zzal.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzal.zzf():void, dex: classes2.dex
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
            com.google.android.gms.internal.measurement.zzz r0 = r3.zzaa
            com.google.android.gms.internal.measurement.zzk r0 = 
            // error: 0x0002: INVOKE  (r0 I:com.google.android.gms.internal.measurement.zzk) = (r0 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            com.google.android.gms.internal.measurement.zzz$zza r1 = new com.google.android.gms.internal.measurement.zzz$zza
            com.google.android.gms.measurement.internal.zzgk r2 = r3.zzbc
            r1.<init>(r2)
            r0.setEventInterceptor(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzal.zzf():void");
    }
}
