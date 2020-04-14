package com.unity3d.services.p040ar.configuration;

import com.unity3d.services.ads.configuration.IAdsModuleConfiguration;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.p040ar.ARCheck;
import com.unity3d.services.p040ar.ARUtils;
import com.unity3d.services.p040ar.api.C3415AR;
import com.unity3d.services.p040ar.view.ARViewHandler;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.unity3d.services.ar.configuration.ARModuleConfiguration */
public class ARModuleConfiguration implements IAdsModuleConfiguration {
    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public boolean initErrorState(Configuration configuration, String str, String str2) {
        return true;
    }

    public boolean resetState(Configuration configuration) {
        return true;
    }

    public Class[] getWebAppApiClassList() {
        return new Class[]{C3415AR.class};
    }

    public boolean initModuleState(Configuration configuration) {
        if (ARCheck.isFrameworkPresent()) {
            ARUtils.isSupported(ClientProperties.getApplicationContext());
        }
        return true;
    }

    public Map<String, Class> getAdUnitViewHandlers() {
        HashMap hashMap = new HashMap();
        hashMap.put("arview", ARViewHandler.class);
        return hashMap;
    }
}
