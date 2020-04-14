package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqd implements zzdsw {
    private int tag;
    private final zzdpy zzhgu;
    private int zzhgv;
    private int zzhgw = 0;

    public static zzdqd zza(zzdpy zzdpy) {
        if (zzdpy.zzhgm != null) {
            return zzdpy.zzhgm;
        }
        return new zzdqd(zzdpy);
    }

    private zzdqd(zzdpy zzdpy) {
        this.zzhgu = (zzdpy) zzdqx.zza(zzdpy, "input");
        this.zzhgu.zzhgm = this;
    }

    public final int zzays() throws IOException {
        int i = this.zzhgw;
        if (i != 0) {
            this.tag = i;
            this.zzhgw = 0;
        } else {
            this.tag = this.zzhgu.zzaxu();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzhgv) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzayt() throws IOException {
        if (!this.zzhgu.zzayk()) {
            int i = this.tag;
            if (i != this.zzhgv) {
                return this.zzhgu.zzfq(i);
            }
        }
        return false;
    }

    private final void zzfv(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzdrg.zzbah();
        }
    }

    public final double readDouble() throws IOException {
        zzfv(1);
        return this.zzhgu.readDouble();
    }

    public final float readFloat() throws IOException {
        zzfv(5);
        return this.zzhgu.readFloat();
    }

    public final long zzaxv() throws IOException {
        zzfv(0);
        return this.zzhgu.zzaxv();
    }

    public final long zzaxw() throws IOException {
        zzfv(0);
        return this.zzhgu.zzaxw();
    }

    public final int zzaxx() throws IOException {
        zzfv(0);
        return this.zzhgu.zzaxx();
    }

    public final long zzaxy() throws IOException {
        zzfv(1);
        return this.zzhgu.zzaxy();
    }

    public final int zzaxz() throws IOException {
        zzfv(5);
        return this.zzhgu.zzaxz();
    }

    public final boolean zzaya() throws IOException {
        zzfv(0);
        return this.zzhgu.zzaya();
    }

    public final String readString() throws IOException {
        zzfv(2);
        return this.zzhgu.readString();
    }

    public final String zzayb() throws IOException {
        zzfv(2);
        return this.zzhgu.zzayb();
    }

    public final <T> T zza(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        zzfv(2);
        return zzc(zzdsv, zzdqj);
    }

    public final <T> T zzb(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        zzfv(3);
        return zzd(zzdsv, zzdqj);
    }

    private final <T> T zzc(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        int zzayd = this.zzhgu.zzayd();
        if (this.zzhgu.zzhgj < this.zzhgu.zzhgk) {
            int zzfr = this.zzhgu.zzfr(zzayd);
            T newInstance = zzdsv.newInstance();
            this.zzhgu.zzhgj++;
            zzdsv.zza(newInstance, this, zzdqj);
            zzdsv.zzak(newInstance);
            this.zzhgu.zzfp(0);
            this.zzhgu.zzhgj--;
            this.zzhgu.zzfs(zzfr);
            return newInstance;
        }
        throw new zzdrg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        int i = this.zzhgv;
        this.zzhgv = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzdsv.newInstance();
            zzdsv.zza(newInstance, this, zzdqj);
            zzdsv.zzak(newInstance);
            if (this.tag == this.zzhgv) {
                return newInstance;
            }
            throw zzdrg.zzbai();
        } finally {
            this.zzhgv = i;
        }
    }

    public final zzdpm zzayc() throws IOException {
        zzfv(2);
        return this.zzhgu.zzayc();
    }

    public final int zzayd() throws IOException {
        zzfv(0);
        return this.zzhgu.zzayd();
    }

    public final int zzaye() throws IOException {
        zzfv(0);
        return this.zzhgu.zzaye();
    }

    public final int zzayf() throws IOException {
        zzfv(5);
        return this.zzhgu.zzayf();
    }

    public final long zzayg() throws IOException {
        zzfv(1);
        return this.zzhgu.zzayg();
    }

    public final int zzayh() throws IOException {
        zzfv(0);
        return this.zzhgu.zzayh();
    }

    public final long zzayi() throws IOException {
        zzfv(0);
        return this.zzhgu.zzayi();
    }

    public final void zzk(List<Double> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqi) {
            zzdqi zzdqi = (zzdqi) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzdqi.zzd(this.zzhgu.readDouble());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfw(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdqi.zzd(this.zzhgu.readDouble());
                } while (this.zzhgu.zzayl() < zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzhgu.readDouble()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfw(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Double.valueOf(this.zzhgu.readDouble()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzl(List<Float> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqs) {
            zzdqs zzdqs = (zzdqs) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfx(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdqs.zzh(this.zzhgu.readFloat());
                } while (this.zzhgu.zzayl() < zzayl);
            } else if (i == 5) {
                do {
                    zzdqs.zzh(this.zzhgu.readFloat());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfx(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Float.valueOf(this.zzhgu.readFloat()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzhgu.readFloat()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzm(List<Long> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdru.zzfl(this.zzhgu.zzaxv());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdru.zzfl(this.zzhgu.zzaxv());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxv()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxv()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdru.zzfl(this.zzhgu.zzaxw());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdru.zzfl(this.zzhgu.zzaxw());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxw()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxw()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzaxx());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdqy.zzgp(this.zzhgu.zzaxx());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaxx()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaxx()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzdru.zzfl(this.zzhgu.zzaxy());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfw(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdru.zzfl(this.zzhgu.zzaxy());
                } while (this.zzhgu.zzayl() < zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxy()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfw(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Long.valueOf(this.zzhgu.zzaxy()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzq(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfx(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdqy.zzgp(this.zzhgu.zzaxz());
                } while (this.zzhgu.zzayl() < zzayl);
            } else if (i == 5) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzaxz());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfx(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaxz()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaxz()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzr(List<Boolean> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdpk) {
            zzdpk zzdpk = (zzdpk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdpk.addBoolean(this.zzhgu.zzaya());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdpk.addBoolean(this.zzhgu.zzaya());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzhgu.zzaya()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Boolean.valueOf(this.zzhgu.zzaya()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzs(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzaxu;
        int zzaxu2;
        if ((this.tag & 7) != 2) {
            throw zzdrg.zzbah();
        } else if (!(list instanceof zzdrn) || z) {
            do {
                list.add(z ? zzayb() : readString());
                if (!this.zzhgu.zzayk()) {
                    zzaxu = this.zzhgu.zzaxu();
                } else {
                    return;
                }
            } while (zzaxu == this.tag);
            this.zzhgw = zzaxu;
        } else {
            zzdrn zzdrn = (zzdrn) list;
            do {
                zzdrn.zzdb(zzayc());
                if (!this.zzhgu.zzayk()) {
                    zzaxu2 = this.zzhgu.zzaxu();
                } else {
                    return;
                }
            } while (zzaxu2 == this.tag);
            this.zzhgw = zzaxu2;
        }
    }

    public final <T> void zza(List<T> list, zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        int zzaxu;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzdsv, zzdqj));
                if (!this.zzhgu.zzayk() && this.zzhgw == 0) {
                    zzaxu = this.zzhgu.zzaxu();
                } else {
                    return;
                }
            } while (zzaxu == i);
            this.zzhgw = zzaxu;
            return;
        }
        throw zzdrg.zzbah();
    }

    public final <T> void zzb(List<T> list, zzdsv<T> zzdsv, zzdqj zzdqj) throws IOException {
        int zzaxu;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzdsv, zzdqj));
                if (!this.zzhgu.zzayk() && this.zzhgw == 0) {
                    zzaxu = this.zzhgu.zzaxu();
                } else {
                    return;
                }
            } while (zzaxu == i);
            this.zzhgw = zzaxu;
            return;
        }
        throw zzdrg.zzbah();
    }

    public final void zzt(List<zzdpm> list) throws IOException {
        int zzaxu;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzayc());
                if (!this.zzhgu.zzayk()) {
                    zzaxu = this.zzhgu.zzaxu();
                } else {
                    return;
                }
            } while (zzaxu == this.tag);
            this.zzhgw = zzaxu;
            return;
        }
        throw zzdrg.zzbah();
    }

    public final void zzu(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzayd());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdqy.zzgp(this.zzhgu.zzayd());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayd()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayd()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzv(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzaye());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdqy.zzgp(this.zzhgu.zzaye());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaye()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzaye()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzw(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfx(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdqy.zzgp(this.zzhgu.zzayf());
                } while (this.zzhgu.zzayl() < zzayl);
            } else if (i == 5) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzayf());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfx(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayf()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayf()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzx(List<Long> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzdru.zzfl(this.zzhgu.zzayg());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayd = this.zzhgu.zzayd();
                zzfw(zzayd);
                int zzayl = this.zzhgu.zzayl() + zzayd;
                do {
                    zzdru.zzfl(this.zzhgu.zzayg());
                } while (this.zzhgu.zzayl() < zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzhgu.zzayg()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayd2 = this.zzhgu.zzayd();
                zzfw(zzayd2);
                int zzayl2 = this.zzhgu.zzayl() + zzayd2;
                do {
                    list.add(Long.valueOf(this.zzhgu.zzayg()));
                } while (this.zzhgu.zzayl() < zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzy(List<Integer> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdqy) {
            zzdqy zzdqy = (zzdqy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdqy.zzgp(this.zzhgu.zzayh());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdqy.zzgp(this.zzhgu.zzayh());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayh()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Integer.valueOf(this.zzhgu.zzayh()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zzaxu;
        int zzaxu2;
        if (list instanceof zzdru) {
            zzdru zzdru = (zzdru) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdru.zzfl(this.zzhgu.zzayi());
                    if (!this.zzhgu.zzayk()) {
                        zzaxu2 = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu2 == this.tag);
                this.zzhgw = zzaxu2;
            } else if (i == 2) {
                int zzayl = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    zzdru.zzfl(this.zzhgu.zzayi());
                } while (this.zzhgu.zzayl() < zzayl);
                zzfy(zzayl);
            } else {
                throw zzdrg.zzbah();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhgu.zzayi()));
                    if (!this.zzhgu.zzayk()) {
                        zzaxu = this.zzhgu.zzaxu();
                    } else {
                        return;
                    }
                } while (zzaxu == this.tag);
                this.zzhgw = zzaxu;
            } else if (i2 == 2) {
                int zzayl2 = this.zzhgu.zzayl() + this.zzhgu.zzayd();
                do {
                    list.add(Long.valueOf(this.zzhgu.zzayi()));
                } while (this.zzhgu.zzayl() < zzayl2);
                zzfy(zzayl2);
            } else {
                throw zzdrg.zzbah();
            }
        }
    }

    private static void zzfw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdrg.zzbai();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzayt() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.ads.zzdrg(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzdrx<K, V> r9, com.google.android.gms.internal.ads.zzdqj r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzfv(r0)
            com.google.android.gms.internal.ads.zzdpy r1 = r7.zzhgu
            int r1 = r1.zzayd()
            com.google.android.gms.internal.ads.zzdpy r2 = r7.zzhgu
            int r1 = r2.zzfr(r1)
            K r2 = r9.zzhmu
            V r3 = r9.zzcfq
        L_0x0014:
            int r4 = r7.zzays()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.ads.zzdpy r5 = r7.zzhgu     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzayk()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzayt()     // Catch:{ zzdrf -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.ads.zzdrg r4 = new com.google.android.gms.internal.ads.zzdrg     // Catch:{ zzdrf -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzdrf -> 0x004e }
            throw r4     // Catch:{ zzdrf -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.ads.zzdue r4 = r9.zzhmv     // Catch:{ zzdrf -> 0x004e }
            V r5 = r9.zzcfq     // Catch:{ zzdrf -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzdrf -> 0x004e }
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch:{ zzdrf -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.ads.zzdue r4 = r9.zzhmt     // Catch:{ zzdrf -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch:{ zzdrf -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzayt()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.ads.zzdrg r8 = new com.google.android.gms.internal.ads.zzdrg     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads.zzdpy r8 = r7.zzhgu
            r8.zzfs(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzdpy r9 = r7.zzhgu
            r9.zzfs(r1)
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqd.zza(java.util.Map, com.google.android.gms.internal.ads.zzdrx, com.google.android.gms.internal.ads.zzdqj):void");
    }

    private final Object zza(zzdue zzdue, Class<?> cls, zzdqj zzdqj) throws IOException {
        switch (zzdqc.zzhgt[zzdue.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzaya());
            case 2:
                return zzayc();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzaye());
            case 5:
                return Integer.valueOf(zzaxz());
            case 6:
                return Long.valueOf(zzaxy());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzaxx());
            case 9:
                return Long.valueOf(zzaxw());
            case 10:
                zzfv(2);
                return zzc(zzdsr.zzbbf().zzh(cls), zzdqj);
            case 11:
                return Integer.valueOf(zzayf());
            case 12:
                return Long.valueOf(zzayg());
            case 13:
                return Integer.valueOf(zzayh());
            case 14:
                return Long.valueOf(zzayi());
            case 15:
                return zzayb();
            case 16:
                return Integer.valueOf(zzayd());
            case 17:
                return Long.valueOf(zzaxv());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzfx(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzdrg.zzbai();
        }
    }

    private final void zzfy(int i) throws IOException {
        if (this.zzhgu.zzayl() != i) {
            throw zzdrg.zzbac();
        }
    }
}
