package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzalm {
    public static int zza(ErrorCode errorCode) {
        int i = zzalp.zzder[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zztx zztx, boolean z) {
        Gender gender;
        Set hashSet = zztx.zzcbz != null ? new HashSet(zztx.zzcbz) : null;
        Date date = new Date(zztx.zzcbx);
        int i = zztx.zzcby;
        if (i == 1) {
            gender = Gender.MALE;
        } else if (i != 2) {
            gender = Gender.UNKNOWN;
        } else {
            gender = Gender.FEMALE;
        }
        MediationAdRequest mediationAdRequest = new MediationAdRequest(date, gender, hashSet, z, zztx.zzng);
        return mediationAdRequest;
    }
}
