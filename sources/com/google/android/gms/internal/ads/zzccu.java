package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzccu extends Exception {
    private final int errorCode;

    public static int zzd(Throwable th) {
        if (th instanceof zzccu) {
            return ((zzccu) th).errorCode;
        }
        if (th instanceof zzavp) {
            return ((zzavp) th).getErrorCode();
        }
        return 0;
    }

    public zzccu(int i) {
        this.errorCode = i;
    }

    public zzccu(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public zzccu(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
