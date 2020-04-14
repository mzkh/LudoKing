package com.google.android.gms.internal.drive;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import java.util.Locale;

public final class zze implements zzk {
    private final zzm zzct;
    private final long zzcu;
    private final long zzcv;

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.drive.events.zzm, com.google.android.gms.internal.drive.zzf] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0, types: [com.google.android.gms.drive.events.zzm, com.google.android.gms.internal.drive.zzf]
      assigns: [com.google.android.gms.internal.drive.zzf]
      uses: [com.google.android.gms.drive.events.zzm]
      mth insns count: 7
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zze(com.google.android.gms.internal.drive.zzh r3) {
        /*
            r2 = this;
            r2.<init>()
            com.google.android.gms.internal.drive.zzf r0 = new com.google.android.gms.internal.drive.zzf
            r0.<init>(r3)
            r2.zzct = r0
            long r0 = r3.zzcu
            r2.zzcu = r0
            long r0 = r3.zzcv
            r2.zzcv = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zze.<init>(com.google.android.gms.internal.drive.zzh):void");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zze zze = (zze) obj;
            return Objects.equal(this.zzct, zze.zzct) && this.zzcu == zze.zzcu && this.zzcv == zze.zzcv;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzcv), Long.valueOf(this.zzcu), Long.valueOf(this.zzcv));
    }

    public final String toString() {
        return String.format(Locale.US, "FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", new Object[]{this.zzct.toString(), Long.valueOf(this.zzcu), Long.valueOf(this.zzcv)});
    }
}
