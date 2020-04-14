package com.applovin.communicator;

public interface AppLovinCommunicatorSubscriber extends AppLovinCommunicatorEntity {
    void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage);
}
