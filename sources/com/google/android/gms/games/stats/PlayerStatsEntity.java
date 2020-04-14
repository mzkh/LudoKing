package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "PlayerStatsEntityCreator")
@Reserved({1000})
public class PlayerStatsEntity extends zzd implements PlayerStats {
    public static final Creator<PlayerStatsEntity> CREATOR = new zza();
    @Field(getter = "getAverageSessionLength", mo15151id = 1)
    private final float zzsi;
    @Field(getter = "getChurnProbability", mo15151id = 2)
    private final float zzsj;
    @Field(getter = "getDaysSinceLastPlayed", mo15151id = 3)
    private final int zzsk;
    @Field(getter = "getNumberOfPurchases", mo15151id = 4)
    private final int zzsl;
    @Field(getter = "getNumberOfSessions", mo15151id = 5)
    private final int zzsm;
    @Field(getter = "getSessionPercentile", mo15151id = 6)
    private final float zzsn;
    @Field(getter = "getSpendPercentile", mo15151id = 7)
    private final float zzso;
    @Field(getter = "getRawValues", mo15151id = 8)
    private final Bundle zzsp;
    @Field(getter = "getSpendProbability", mo15151id = 9)
    private final float zzsq;
    @Field(getter = "getHighSpenderProbability", mo15151id = 10)
    private final float zzsr;
    @Field(getter = "getTotalSpendNext28Days", mo15151id = 11)
    private final float zzss;

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.zzsi = playerStats.getAverageSessionLength();
        this.zzsj = playerStats.getChurnProbability();
        this.zzsk = playerStats.getDaysSinceLastPlayed();
        this.zzsl = playerStats.getNumberOfPurchases();
        this.zzsm = playerStats.getNumberOfSessions();
        this.zzsn = playerStats.getSessionPercentile();
        this.zzso = playerStats.getSpendPercentile();
        this.zzsq = playerStats.getSpendProbability();
        this.zzsr = playerStats.getHighSpenderProbability();
        this.zzss = playerStats.getTotalSpendNext28Days();
        this.zzsp = playerStats.zzdu();
    }

    public /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    @Constructor
    PlayerStatsEntity(@Param(mo15154id = 1) float f, @Param(mo15154id = 2) float f2, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) int i2, @Param(mo15154id = 5) int i3, @Param(mo15154id = 6) float f3, @Param(mo15154id = 7) float f4, @Param(mo15154id = 8) Bundle bundle, @Param(mo15154id = 9) float f5, @Param(mo15154id = 10) float f6, @Param(mo15154id = 11) float f7) {
        this.zzsi = f;
        this.zzsj = f2;
        this.zzsk = i;
        this.zzsl = i2;
        this.zzsm = i3;
        this.zzsn = f3;
        this.zzso = f4;
        this.zzsp = bundle;
        this.zzsq = f5;
        this.zzsr = f6;
        this.zzss = f7;
    }

    public float getAverageSessionLength() {
        return this.zzsi;
    }

    public float getChurnProbability() {
        return this.zzsj;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzsk;
    }

    public int getNumberOfPurchases() {
        return this.zzsl;
    }

    public int getNumberOfSessions() {
        return this.zzsm;
    }

    public float getSessionPercentile() {
        return this.zzsn;
    }

    public float getSpendPercentile() {
        return this.zzso;
    }

    public final Bundle zzdu() {
        return this.zzsp;
    }

    public float getSpendProbability() {
        return this.zzsq;
    }

    public float getHighSpenderProbability() {
        return this.zzsr;
    }

    public float getTotalSpendNext28Days() {
        return this.zzss;
    }

    public int hashCode() {
        return zza(this);
    }

    static int zza(PlayerStats playerStats) {
        return Objects.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return Objects.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && Objects.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && Objects.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && Objects.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && Objects.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && Objects.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public String toString() {
        return zzb(this);
    }

    static String zzb(PlayerStats playerStats) {
        return Objects.toStringHelper(playerStats).add("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).add("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).add("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).add("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).add("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).add("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).add("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).add("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).add("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability())).add("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel, 2, getChurnProbability());
        SafeParcelWriter.writeInt(parcel, 3, getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel, 4, getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel, 5, getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel, 6, getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel, 7, getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel, 8, this.zzsp, false);
        SafeParcelWriter.writeFloat(parcel, 9, getSpendProbability());
        SafeParcelWriter.writeFloat(parcel, 10, getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel, 11, getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
