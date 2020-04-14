package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzaq extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ int zzbd = 5;
    private final /* synthetic */ String zzbe;
    private final /* synthetic */ Object zzbf;
    private final /* synthetic */ Object zzbg;
    private final /* synthetic */ Object zzbh;

    zzaq(zzz zzz, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzaa = zzz;
        this.zzbe = str;
        this.zzbf = obj;
        this.zzbg = null;
        this.zzbh = null;
        super(false);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x0002: INVOKE  (r1v0 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (wrap: int
              0x0006: IGET  (r2v0 int) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzbd int), (wrap: java.lang.String
              0x0008: IGET  (r3v0 java.lang.String) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzbe java.lang.String), (wrap: com.google.android.gms.dynamic.IObjectWrapper
              0x000c: INVOKE  (r4v0 com.google.android.gms.dynamic.IObjectWrapper) = (wrap: java.lang.Object
              0x000a: IGET  (r0v1 java.lang.Object) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzbf java.lang.Object) com.google.android.gms.dynamic.ObjectWrapper.wrap(java.lang.Object):com.google.android.gms.dynamic.IObjectWrapper type: STATIC), (wrap: com.google.android.gms.dynamic.IObjectWrapper
              0x0012: INVOKE  (r5v0 com.google.android.gms.dynamic.IObjectWrapper) = (wrap: java.lang.Object
              0x0010: IGET  (r0v2 java.lang.Object) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzbg java.lang.Object) com.google.android.gms.dynamic.ObjectWrapper.wrap(java.lang.Object):com.google.android.gms.dynamic.IObjectWrapper type: STATIC), (wrap: com.google.android.gms.dynamic.IObjectWrapper
              0x0018: INVOKE  (r6v0 com.google.android.gms.dynamic.IObjectWrapper) = (wrap: java.lang.Object
              0x0016: IGET  (r0v3 java.lang.Object) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzbh java.lang.Object) com.google.android.gms.dynamic.ObjectWrapper.wrap(java.lang.Object):com.google.android.gms.dynamic.IObjectWrapper type: STATIC) com.google.android.gms.internal.measurement.zzk.logHealthData(int, java.lang.String, com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.dynamic.IObjectWrapper):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzaq.zzf():void, dex: classes2.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE  (r1v0 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r7v0 'this' com.google.android.gms.internal.measurement.zzaq A[THIS]) com.google.android.gms.internal.measurement.zzaq.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzaq.zzf():void, dex: classes2.dex
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
            com.google.android.gms.internal.measurement.zzz r0 = r7.zzaa
            com.google.android.gms.internal.measurement.zzk r1 = 
            // error: 0x0002: INVOKE  (r1 I:com.google.android.gms.internal.measurement.zzk) = (r0 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            int r2 = r7.zzbd
            java.lang.String r3 = r7.zzbe
            java.lang.Object r0 = r7.zzbf
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            java.lang.Object r0 = r7.zzbg
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            java.lang.Object r0 = r7.zzbh
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            r1.logHealthData(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaq.zzf():void");
    }
}
