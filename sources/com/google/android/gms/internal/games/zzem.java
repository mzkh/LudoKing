package com.google.android.gms.internal.games;

import java.util.HashMap;

public final class zzem {
    private int statusCode = 0;
    private HashMap<String, Integer> zzns = new HashMap<>();

    public final zzem zzh(String str, int i) {
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
            z = false;
        }
        if (z) {
            this.zzns.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public final zzem zzo(int i) {
        this.statusCode = i;
        return this;
    }

    public final zzek zzdh() {
        return new zzek(this.statusCode, this.zzns);
    }
}
