package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzgn;

final class zzau extends zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzgn zzbk;

    zzau(zzz zzz, zzgn zzgn) {
        this.zzaa = zzz;
        this.zzbk = zzgn;
        super(zzz);
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() throws RemoteException {
        for (int i = 0; i < this.zzaa.zzaf.size(); i++) {
            if (this.zzbk.equals(((Pair) this.zzaa.zzaf.get(i)).first)) {
                Log.w(this.zzaa.zzu, "OnEventListener already registered.");
                return;
            }
        }
        zzd zzd = new zzd(this.zzbk);
        this.zzaa.zzaf.add(new Pair(this.zzbk, zzd));
        
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004f: INVOKE  (wrap: com.google.android.gms.internal.measurement.zzk
              0x004b: INVOKE  (r1v7 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0049: IGET  (r1v6 com.google.android.gms.internal.measurement.zzz) = (r4v0 'this' com.google.android.gms.internal.measurement.zzau A[THIS]) com.google.android.gms.internal.measurement.zzau.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC), (r0v2 'zzd' com.google.android.gms.internal.measurement.zzz$zzd) com.google.android.gms.internal.measurement.zzk.registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzq):void type: INTERFACE in method: com.google.android.gms.internal.measurement.zzau.zzf():void, dex: classes2.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  (r1v7 com.google.android.gms.internal.measurement.zzk) = (wrap: com.google.android.gms.internal.measurement.zzz
              0x0049: IGET  (r1v6 com.google.android.gms.internal.measurement.zzz) = (r4v0 'this' com.google.android.gms.internal.measurement.zzau A[THIS]) com.google.android.gms.internal.measurement.zzau.zzaa com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC in method: com.google.android.gms.internal.measurement.zzau.zzf():void, dex: classes2.dex
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
            r0 = 0
        L_0x0001:
            com.google.android.gms.internal.measurement.zzz r1 = r4.zzaa
            java.util.List r1 = r1.zzaf
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0032
            com.google.android.gms.measurement.internal.zzgn r1 = r4.zzbk
            com.google.android.gms.internal.measurement.zzz r2 = r4.zzaa
            java.util.List r2 = r2.zzaf
            java.lang.Object r2 = r2.get(r0)
            android.util.Pair r2 = (android.util.Pair) r2
            java.lang.Object r2 = r2.first
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.internal.measurement.zzz r0 = r4.zzaa
            java.lang.String r0 = r0.zzu
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r0, r1)
            return
        L_0x002f:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0032:
            com.google.android.gms.internal.measurement.zzz$zzd r0 = new com.google.android.gms.internal.measurement.zzz$zzd
            com.google.android.gms.measurement.internal.zzgn r1 = r4.zzbk
            r0.<init>(r1)
            com.google.android.gms.internal.measurement.zzz r1 = r4.zzaa
            java.util.List r1 = r1.zzaf
            android.util.Pair r2 = new android.util.Pair
            com.google.android.gms.measurement.internal.zzgn r3 = r4.zzbk
            r2.<init>(r3, r0)
            r1.add(r2)
            com.google.android.gms.internal.measurement.zzz r1 = r4.zzaa
            com.google.android.gms.internal.measurement.zzk r1 = 
            // error: 0x004b: INVOKE  (r1 I:com.google.android.gms.internal.measurement.zzk) = (r1 I:com.google.android.gms.internal.measurement.zzz) com.google.android.gms.internal.measurement.zzz.zzc(com.google.android.gms.internal.measurement.zzz):com.google.android.gms.internal.measurement.zzk type: STATIC
            r1.registerOnMeasurementEventListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzau.zzf():void");
    }
}
