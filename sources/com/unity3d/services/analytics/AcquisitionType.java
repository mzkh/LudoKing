package com.unity3d.services.analytics;

public enum AcquisitionType {
    SOFT,
    PREMIUM;

    /* renamed from: com.unity3d.services.analytics.AcquisitionType$1 */
    static /* synthetic */ class C34131 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$analytics$AcquisitionType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.unity3d.services.analytics.AcquisitionType[] r0 = com.unity3d.services.analytics.AcquisitionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$services$analytics$AcquisitionType = r0
                int[] r0 = $SwitchMap$com$unity3d$services$analytics$AcquisitionType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.unity3d.services.analytics.AcquisitionType r1 = com.unity3d.services.analytics.AcquisitionType.SOFT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$unity3d$services$analytics$AcquisitionType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.unity3d.services.analytics.AcquisitionType r1 = com.unity3d.services.analytics.AcquisitionType.PREMIUM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.analytics.AcquisitionType.C34131.<clinit>():void");
        }
    }

    public String toString() {
        int i = C34131.$SwitchMap$com$unity3d$services$analytics$AcquisitionType[ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "premium";
        }
        return "soft";
    }
}
