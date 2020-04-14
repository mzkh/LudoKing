package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@Immutable
@Class(creator = "StrategyCreator")
public class Strategy extends AbstractSafeParcelable {
    public static final Strategy BLE_ONLY;
    public static final Creator<Strategy> CREATOR = new zzg();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    private static final Strategy zzfm;
    @VersionField(mo15157id = 1000)
    private final int zzex;
    @Field(mo15151id = 1)
    @Deprecated
    private final int zzfn;
    @Field(mo15151id = 2)
    private final int zzfo;
    @Field(mo15151id = 3)
    private final int zzfp;
    @Field(mo15151id = 4)
    @Deprecated
    private final boolean zzfq;
    @Field(getter = "getDiscoveryMedium", mo15151id = 5)
    private final int zzfr;
    @Field(getter = "getDiscoveryMode", mo15151id = 6)
    private final int zzfs;
    @Field(getter = "getBackgroundScanMode", mo15151id = 7)
    private final int zzft;

    public static class Builder {
        private int zzfu = 3;
        private int zzfv = Strategy.TTL_SECONDS_DEFAULT;
        private int zzfw = 0;
        private int zzfx = -1;
        private int zzfy = 0;

        public Strategy build() {
            if (this.zzfx == 2 && this.zzfw == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            Strategy strategy = new Strategy(2, 0, this.zzfv, this.zzfw, false, this.zzfx, this.zzfu, 0);
            return strategy;
        }

        public Builder setDiscoveryMode(int i) {
            this.zzfu = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.zzfw = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            Preconditions.checkArgument(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzfv = i;
            return this;
        }

        public final Builder zze(int i) {
            this.zzfx = 2;
            return this;
        }
    }

    static {
        Strategy build = new Builder().zze(2).setTtlSeconds(Integer.MAX_VALUE).build();
        BLE_ONLY = build;
        zzfm = build;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Strategy(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 1000) int r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 1) int r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 2) int r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 3) int r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 4) boolean r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 5) int r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 6) int r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo15154id = 7) int r9) {
        /*
            r1 = this;
            r1.<init>()
            r1.zzex = r2
            r1.zzfn = r3
            r2 = 1
            r0 = 2
            if (r3 != 0) goto L_0x000e
        L_0x000b:
            r1.zzfs = r8
            goto L_0x0019
        L_0x000e:
            if (r3 == r0) goto L_0x0017
            r8 = 3
            if (r3 == r8) goto L_0x0014
            goto L_0x000b
        L_0x0014:
            r1.zzfs = r0
            goto L_0x0019
        L_0x0017:
            r1.zzfs = r2
        L_0x0019:
            r1.zzfp = r5
            r1.zzfq = r6
            if (r6 == 0) goto L_0x0027
            r1.zzfr = r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r1.zzfo = r2
            goto L_0x0038
        L_0x0027:
            r1.zzfo = r4
            r3 = -1
            if (r7 == r3) goto L_0x0036
            if (r7 == 0) goto L_0x0036
            if (r7 == r2) goto L_0x0036
            r2 = 6
            if (r7 == r2) goto L_0x0036
            r1.zzfr = r7
            goto L_0x0038
        L_0x0036:
            r1.zzfr = r3
        L_0x0038:
            r1.zzft = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.Strategy.<init>(int, int, int, int, boolean, int, int, int):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zzex == strategy.zzex && this.zzfs == strategy.zzfs && this.zzfo == strategy.zzfo && this.zzfp == strategy.zzfp && this.zzfr == strategy.zzfr && this.zzft == strategy.zzft;
    }

    public int hashCode() {
        return (((((((((this.zzex * 31) + this.zzfs) * 31) + this.zzfo) * 31) + this.zzfp) * 31) + this.zzfr) * 31) + this.zzft;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        int i = this.zzfo;
        int i2 = this.zzfp;
        String str4 = "UNKNOWN:";
        String str5 = MessengerShareContentUtility.PREVIEW_DEFAULT;
        if (i2 == 0) {
            str = str5;
        } else if (i2 != 1) {
            StringBuilder sb = new StringBuilder(19);
            sb.append(str4);
            sb.append(i2);
            str = sb.toString();
        } else {
            str = "EARSHOT";
        }
        int i3 = this.zzfr;
        if (i3 == -1) {
            str2 = str5;
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append(str4);
                sb2.append(i3);
                str2 = sb2.toString();
            } else {
                str2 = arrayList.toString();
            }
        }
        int i4 = this.zzfs;
        if (i4 == 3) {
            str3 = str5;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                StringBuilder sb3 = new StringBuilder(19);
                sb3.append(str4);
                sb3.append(i4);
                str3 = sb3.toString();
            } else {
                str3 = arrayList2.toString();
            }
        }
        int i5 = this.zzft;
        if (i5 != 0) {
            if (i5 != 1) {
                StringBuilder sb4 = new StringBuilder(20);
                sb4.append("UNKNOWN: ");
                sb4.append(i5);
                str5 = sb4.toString();
            } else {
                str5 = "ALWAYS_ON";
            }
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 102 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb5.append("Strategy{ttlSeconds=");
        sb5.append(i);
        sb5.append(", distanceType=");
        sb5.append(str);
        sb5.append(", discoveryMedium=");
        sb5.append(str2);
        sb5.append(", discoveryMode=");
        sb5.append(str3);
        sb5.append(", backgroundScanMode=");
        sb5.append(str5);
        sb5.append('}');
        return sb5.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzfn);
        SafeParcelWriter.writeInt(parcel, 2, this.zzfo);
        SafeParcelWriter.writeInt(parcel, 3, this.zzfp);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzfq);
        SafeParcelWriter.writeInt(parcel, 5, this.zzfr);
        SafeParcelWriter.writeInt(parcel, 6, this.zzfs);
        SafeParcelWriter.writeInt(parcel, 7, this.zzft);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzae() {
        return this.zzft;
    }
}
