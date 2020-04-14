package com.inmobi.media;

import android.media.MediaMetadataRetriever;

/* renamed from: com.inmobi.media.bl */
/* compiled from: NativeTimer */
public final class C2228bl {

    /* renamed from: a */
    public C2229a f4603a;

    /* renamed from: b */
    public C2229a f4604b;

    /* renamed from: com.inmobi.media.bl$a */
    /* compiled from: NativeTimer */
    public static class C2229a {

        /* renamed from: a */
        private long f4605a;

        /* renamed from: b */
        private long f4606b;

        /* renamed from: c */
        private String f4607c;

        /* renamed from: d */
        private C2220bg f4608d;

        public C2229a(long j, long j2, String str, C2220bg bgVar) {
            this.f4605a = j;
            this.f4606b = j2;
            this.f4607c = str;
            this.f4608d = bgVar;
        }

        /* renamed from: a */
        public final long mo27968a() {
            long j = this.f4605a;
            C2214bc b = this.f4608d.mo27959b(this.f4607c);
            if (b instanceof C2235bp) {
                String b2 = ((C2235bp) b).mo27982b().mo28138b();
                if (b2 != null) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(b2);
                    long intValue = (long) Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue();
                    double d = (double) j;
                    double d2 = (double) this.f4606b;
                    Double.isNaN(d2);
                    double d3 = (d2 * 1.0d) / 100.0d;
                    double d4 = (double) (intValue / 1000);
                    Double.isNaN(d4);
                    double d5 = d3 * d4;
                    Double.isNaN(d);
                    j = (long) (d + d5);
                    mediaMetadataRetriever.release();
                }
            }
            if (j >= 0) {
                return j;
            }
            return 0;
        }
    }

    public C2228bl(C2229a aVar, C2229a aVar2) {
        this.f4603a = aVar;
        this.f4604b = aVar2;
    }
}
