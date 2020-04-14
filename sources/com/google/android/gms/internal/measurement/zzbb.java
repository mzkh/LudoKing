package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzbb extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzbn;
    private final /* synthetic */ boolean zzbp;
    private final /* synthetic */ Object zzbr;
    private final /* synthetic */ String zzx;

    zzbb(zzz zzz, String str, String str2, Object obj, boolean z) {
        this.zzaa = zzz;
        this.zzx = str;
        this.zzbn = str2;
        this.zzbr = obj;
        this.zzbp = z;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x0002: INVOKE  (r1v0 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (wrap: java.lang.String
              0x0006: IGET  (r2v0 java.lang.String) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzx java.lang.String), (wrap: java.lang.String
              0x0008: IGET  (r3v0 java.lang.String) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzbn java.lang.String), (wrap: com.google.android.gms.dynamic.IObjectWrapper
              0x000c: INVOKE  (r4v0 com.google.android.gms.dynamic.IObjectWrapper) = (wrap: java.lang.Object
              0x000a: IGET  (r0v1 java.lang.Object) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzbr java.lang.Object) com.google.android.gms.dynamic.ObjectWrapper.wrap(java.lang.Object):com.google.android.gms.dynamic.IObjectWrapper type: STATIC), (wrap: boolean
              0x0010: IGET  (r5v0 boolean) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzbp boolean), (wrap: long
              0x0012: IGET  (r6v0 long) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.timestamp long) com.google.android.gms.internal.measurement.zzk.setUserProperty(java.lang.String, java.lang.String, com.google.android.gms.dynamic.IObjectWrapper, boolean, long):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzbb.zzf():void, dex: classes2.dex
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
              0x0000: IGET  (r0v0 com.google.android.gms.internal.measurement.zzz) = (r8v0 'this' com.google.android.gms.internal.measurement.zzbb A[THIS]) com.google.android.gms.internal.measurement.zzbb.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzbb.zzf():void, dex: classes2.dex
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
            com.google.android.gms.internal.measurement.zzz r0 = r8.zzaa
            com.google.android.gms.internal.measurement.zzk r1 = 
            // error: 0x0002: INVOKE  (r1 I:com.google.android.gms.internal.measurement.zzk) = (r0 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            java.lang.String r2 = r8.zzx
            java.lang.String r3 = r8.zzbn
            java.lang.Object r0 = r8.zzbr
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            boolean r5 = r8.zzbp
            long r6 = r8.timestamp
            r1.setUserProperty(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zzf():void");
    }
}
