package com.unity3d.services.monetization.core.configuration;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.monetization.core.api.MonetizationListener;
import com.unity3d.services.monetization.core.api.PlacementContents;

public class MonetizationModuleConfiguration implements IModuleConfiguration {
    private static final Class[] WEB_APP_API_CLASS_LIST = {MonetizationListener.class, PlacementContents.class};

    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public boolean initErrorState(Configuration configuration, String str, String str2) {
        return true;
    }

    public boolean initModuleState(Configuration configuration) {
        return true;
    }

    public boolean resetState(Configuration configuration) {
        return true;
    }

    public Class[] getWebAppApiClassList() {
        return WEB_APP_API_CLASS_LIST;
    }
}
