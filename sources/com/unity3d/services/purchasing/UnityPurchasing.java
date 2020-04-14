package com.unity3d.services.purchasing;

import com.unity3d.services.purchasing.core.IPurchasingAdapter;
import com.unity3d.services.purchasing.core.properties.ClientProperties;

public class UnityPurchasing {
    public static void setAdapter(IPurchasingAdapter iPurchasingAdapter) {
        ClientProperties.setAdapter(iPurchasingAdapter);
    }

    public static IPurchasingAdapter getAdapter() {
        return ClientProperties.getAdapter();
    }
}
