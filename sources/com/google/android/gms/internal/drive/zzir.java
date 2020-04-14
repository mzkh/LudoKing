package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzir;
import java.io.IOException;

public abstract class zzir<M extends zzir<M>> extends zzix {
    protected zzit zzmw;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzir zzir = (zzir) super.clone();
        zziv.zza(this, zzir);
        return zzir;
    }

    public void zza(zzip zzip) throws IOException {
        if (this.zzmw != null) {
            for (int i = 0; i < this.zzmw.size(); i++) {
                this.zzmw.zzs(i).zza(zzip);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzio zzio, int i) throws IOException {
        int position = zzio.getPosition();
        if (!zzio.zzk(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zziz zziz = new zziz(i, zzio.zza(position, zzio.getPosition() - position));
        zziu zziu = null;
        zzit zzit = this.zzmw;
        if (zzit == null) {
            this.zzmw = new zzit();
        } else {
            zziu = zzit.zzr(i2);
        }
        if (zziu == null) {
            zziu = new zziu();
            this.zzmw.zza(i2, zziu);
        }
        zziu.zza(zziz);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzaq() {
        if (this.zzmw == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzmw.size(); i2++) {
            i += this.zzmw.zzs(i2).zzaq();
        }
        return i;
    }

    public final /* synthetic */ zzix zzbi() throws CloneNotSupportedException {
        return (zzir) clone();
    }
}
