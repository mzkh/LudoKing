package com.inmobi.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.inmobi.media.ai */
/* compiled from: AdPlacement */
public final class C2159ai implements Parcelable {
    public static final Creator<C2159ai> CREATOR = new Creator<C2159ai>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C2159ai[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new C2159ai(parcel, 0);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final long f4366a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f4367b;

    /* renamed from: c */
    private final String f4368c;

    /* renamed from: d */
    private String f4369d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, String> f4370e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f4371f;

    /* renamed from: g */
    private final String f4372g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f4373h;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: i */
    public String f4374i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f4375j;

    /* renamed from: com.inmobi.media.ai$a */
    /* compiled from: AdPlacement */
    public static class C2161a {

        /* renamed from: a */
        private long f4376a = Long.MIN_VALUE;

        /* renamed from: b */
        private long f4377b = Long.MIN_VALUE;

        /* renamed from: c */
        private String f4378c;

        /* renamed from: d */
        private Map<String, String> f4379d;

        /* renamed from: e */
        private String f4380e;

        /* renamed from: f */
        private String f4381f;

        /* renamed from: g */
        private String f4382g;

        /* renamed from: h */
        private String f4383h = "";

        /* renamed from: i */
        private String f4384i = "activity";

        public C2161a(String str, String str2) {
            this.f4381f = str;
            this.f4378c = str2;
            this.f4382g = UUID.randomUUID().toString();
        }

        /* renamed from: a */
        public final C2161a mo27863a(long j) {
            this.f4376a = j;
            return this;
        }

        /* renamed from: b */
        public final C2161a mo27868b(long j) {
            this.f4377b = j;
            return this;
        }

        /* renamed from: a */
        public final C2161a mo27864a(@NonNull C2159ai aiVar) {
            this.f4377b = aiVar.f4367b;
            this.f4376a = aiVar.f4366a;
            this.f4384i = aiVar.f4375j;
            this.f4379d = aiVar.f4370e;
            this.f4383h = aiVar.f4374i;
            return this;
        }

        /* renamed from: a */
        public final C2161a mo27865a(@NonNull String str) {
            this.f4383h = str;
            return this;
        }

        /* renamed from: b */
        public final C2161a mo27869b(String str) {
            this.f4384i = str;
            return this;
        }

        /* renamed from: a */
        public final C2161a mo27866a(@Nullable Map<String, String> map) {
            this.f4379d = map;
            return this;
        }

        /* renamed from: c */
        public final C2161a mo27870c(@Nullable String str) {
            this.f4380e = str;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.inmobi.media.C2159ai mo27867a() {
            /*
                r10 = this;
                java.lang.String r0 = r10.f4378c
                int r1 = r0.hashCode()
                r2 = -2101048242(0xffffffff82c48c4e, float:-2.8880143E-37)
                r3 = 2
                if (r1 == r2) goto L_0x001c
                r2 = 557596132(0x213c3de4, float:6.377879E-19)
                if (r1 == r2) goto L_0x0012
                goto L_0x0026
            L_0x0012:
                java.lang.String r1 = "AerServ"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = 2
                goto L_0x0027
            L_0x001c:
                java.lang.String r1 = "InMobi"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = 1
                goto L_0x0027
            L_0x0026:
                r0 = -1
            L_0x0027:
                r1 = -9223372036854775808
                if (r0 == r3) goto L_0x003a
                long r3 = r10.f4376a
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0032
                goto L_0x0040
            L_0x0032:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "When the integration type is IM, IM-Plc can't be empty"
                r0.<init>(r1)
                throw r0
            L_0x003a:
                long r3 = r10.f4377b
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x006f
            L_0x0040:
                com.inmobi.media.ai r0 = new com.inmobi.media.ai
                long r2 = r10.f4376a
                long r4 = r10.f4377b
                java.util.Map<java.lang.String, java.lang.String> r1 = r10.f4379d
                java.lang.String r6 = com.inmobi.media.C2159ai.m4292a(r1)
                java.lang.String r7 = r10.f4381f
                java.lang.String r8 = r10.f4378c
                r9 = 0
                r1 = r0
                r1.<init>(r2, r4, r6, r7, r8, r9)
                java.lang.String r1 = r10.f4380e
                r0.f4371f = r1
                java.util.Map<java.lang.String, java.lang.String> r1 = r10.f4379d
                r0.f4370e = r1
                java.lang.String r1 = r10.f4383h
                r0.f4374i = r1
                java.lang.String r1 = r10.f4384i
                r0.f4375j = r1
                java.lang.String r1 = r10.f4382g
                r0.f4373h = r1
                return r0
            L_0x006f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "When the integration type is AS, AS-Plc can't be empty"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2159ai.C2161a.mo27867a():com.inmobi.media.ai");
        }
    }

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ C2159ai(long j, long j2, String str, String str2, String str3, byte b) {
        this(j, j2, str, str2, str3);
    }

    /* synthetic */ C2159ai(Parcel parcel, byte b) {
        this(parcel);
    }

    private C2159ai(long j, long j2, String str, String str2, String str3) {
        String str4 = "";
        this.f4374i = str4;
        this.f4375j = "activity";
        this.f4366a = j;
        this.f4367b = j2;
        this.f4368c = str3;
        this.f4369d = str;
        this.f4372g = str2;
        if (this.f4369d == null) {
            this.f4369d = str4;
        }
    }

    private C2159ai(Parcel parcel) {
        this.f4374i = "";
        String str = "activity";
        this.f4375j = str;
        this.f4367b = parcel.readLong();
        this.f4366a = parcel.readLong();
        this.f4368c = parcel.readString();
        String readString = parcel.readString();
        String str2 = "others";
        if (readString != null) {
            char c = 65535;
            int hashCode = readString.hashCode();
            if (hashCode != -1655966961) {
                if (hashCode == -1006804125 && readString.equals(str2)) {
                    c = 2;
                }
            } else if (readString.equals(str)) {
                c = 1;
            }
            if (c == 2) {
                str = str2;
            }
        }
        this.f4375j = str;
        this.f4372g = parcel.readString();
    }

    @NonNull
    /* renamed from: a */
    public static String m4292a(Map<String, String> map) {
        String str = "";
        if (map == null) {
            return str;
        }
        String str2 = (String) map.get("tp");
        return str2 == null ? str : str2;
    }

    /* renamed from: a */
    public final String mo27841a() {
        return this.f4368c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo27843b() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f4368c
            int r1 = r0.hashCode()
            r2 = -2101048242(0xffffffff82c48c4e, float:-2.8880143E-37)
            r3 = 2
            if (r1 == r2) goto L_0x001c
            r2 = 557596132(0x213c3de4, float:6.377879E-19)
            if (r1 == r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "AerServ"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 2
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "InMobi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            if (r0 == r3) goto L_0x002c
            java.lang.String r0 = "im"
            return r0
        L_0x002c:
            java.lang.String r0 = "as"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2159ai.mo27843b():java.lang.String");
    }

    /* renamed from: b */
    public final void mo27845b(Map<String, String> map) {
        this.f4370e = map;
    }

    /* renamed from: c */
    public final Map<String, String> mo27846c() {
        return this.f4370e;
    }

    /* renamed from: d */
    public final String mo27847d() {
        return this.f4371f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo27849e() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f4368c
            int r1 = r0.hashCode()
            r2 = -2101048242(0xffffffff82c48c4e, float:-2.8880143E-37)
            r3 = 2
            if (r1 == r2) goto L_0x001c
            r2 = 557596132(0x213c3de4, float:6.377879E-19)
            if (r1 == r2) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r1 = "AerServ"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 2
            goto L_0x0027
        L_0x001c:
            java.lang.String r1 = "InMobi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = -1
        L_0x0027:
            if (r0 == r3) goto L_0x002c
            long r0 = r4.f4366a
            return r0
        L_0x002c:
            long r0 = r4.f4367b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2159ai.mo27849e():long");
    }

    /* renamed from: f */
    public final long mo27851f() {
        return this.f4367b;
    }

    /* renamed from: g */
    public final long mo27852g() {
        return this.f4366a;
    }

    /* renamed from: h */
    public final String mo27853h() {
        return this.f4369d;
    }

    /* renamed from: i */
    public final String mo27855i() {
        return this.f4372g;
    }

    /* renamed from: a */
    public final void mo27842a(@NonNull String str) {
        this.f4374i = str;
    }

    @NonNull
    /* renamed from: j */
    public final String mo27856j() {
        return this.f4374i;
    }

    /* renamed from: k */
    public final String mo27857k() {
        return this.f4375j;
    }

    /* renamed from: b */
    public final void mo27844b(String str) {
        this.f4375j = str;
    }

    @NonNull
    /* renamed from: l */
    public final String mo27858l() {
        return this.f4373h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2159ai aiVar = (C2159ai) obj;
            return this.f4366a == aiVar.f4366a && this.f4367b == aiVar.f4367b && this.f4368c.equals(aiVar.f4368c) && this.f4375j.equals(aiVar.f4375j) && this.f4369d.equals(aiVar.f4369d) && this.f4372g.equals(aiVar.f4372g);
        }
    }

    public final int hashCode() {
        long j = this.f4367b;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.f4366a;
        return ((((i + ((int) (j2 ^ (j2 >>> 31)))) * 30) + this.f4372g.hashCode()) * 29) + this.f4375j.hashCode();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r4 = this;
            java.lang.String r0 = r4.mo27841a()
            int r1 = r0.hashCode()
            r2 = -2101048242(0xffffffff82c48c4e, float:-2.8880143E-37)
            r3 = 2
            if (r1 == r2) goto L_0x001e
            r2 = 557596132(0x213c3de4, float:6.377879E-19)
            if (r1 == r2) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "AerServ"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 2
            goto L_0x0029
        L_0x001e:
            java.lang.String r1 = "InMobi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = -1
        L_0x0029:
            if (r0 == r3) goto L_0x0032
            long r0 = r4.f4366a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x0032:
            long r0 = r4.f4367b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2159ai.toString():java.lang.String");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4367b);
        parcel.writeLong(this.f4366a);
        parcel.writeString(this.f4368c);
        parcel.writeString(this.f4375j);
        parcel.writeString(this.f4372g);
    }
}
