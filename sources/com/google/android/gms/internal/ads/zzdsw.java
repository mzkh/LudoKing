package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
interface zzdsw {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException;

    <T> void zza(List<T> list, zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException;

    <K, V> void zza(Map<K, V> map, zzdrx<K, V> zzdrx, zzdqj zzdqj) throws IOException;

    long zzaxv() throws IOException;

    long zzaxw() throws IOException;

    int zzaxx() throws IOException;

    long zzaxy() throws IOException;

    int zzaxz() throws IOException;

    boolean zzaya() throws IOException;

    String zzayb() throws IOException;

    zzdpm zzayc() throws IOException;

    int zzayd() throws IOException;

    int zzaye() throws IOException;

    int zzayf() throws IOException;

    long zzayg() throws IOException;

    int zzayh() throws IOException;

    long zzayi() throws IOException;

    int zzays() throws IOException;

    boolean zzayt() throws IOException;

    @Deprecated
    <T> T zzb(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException;

    void zzk(List<Double> list) throws IOException;

    void zzl(List<Float> list) throws IOException;

    void zzm(List<Long> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Boolean> list) throws IOException;

    void zzs(List<String> list) throws IOException;

    void zzt(List<zzdpm> list) throws IOException;

    void zzu(List<Integer> list) throws IOException;

    void zzv(List<Integer> list) throws IOException;

    void zzw(List<Integer> list) throws IOException;

    void zzx(List<Long> list) throws IOException;

    void zzy(List<Integer> list) throws IOException;

    void zzz(List<Long> list) throws IOException;
}
