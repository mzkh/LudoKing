package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zznk extends IOException {
    private final int type;
    private final zznf zzbew;

    public zznk(String str, zznf zznf, int i) {
        super(str);
        this.zzbew = zznf;
        this.type = 1;
    }

    public zznk(IOException iOException, zznf zznf, int i) {
        super(iOException);
        this.zzbew = zznf;
        this.type = i;
    }

    public zznk(String str, IOException iOException, zznf zznf, int i) {
        super(str, iOException);
        this.zzbew = zznf;
        this.type = 1;
    }
}
