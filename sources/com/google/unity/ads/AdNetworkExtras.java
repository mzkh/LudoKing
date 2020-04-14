package com.google.unity.ads;

import android.os.Bundle;
import java.util.HashMap;

public interface AdNetworkExtras {
    Bundle buildExtras(HashMap<String, String> hashMap);

    Class getAdapterClass();
}
