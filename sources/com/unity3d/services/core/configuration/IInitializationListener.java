package com.unity3d.services.core.configuration;

public interface IInitializationListener {
    void onSdkInitializationFailed(String str, int i);

    void onSdkInitialized();
}
