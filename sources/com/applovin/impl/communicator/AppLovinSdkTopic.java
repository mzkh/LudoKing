package com.applovin.impl.communicator;

import java.util.ArrayList;
import java.util.List;

public class AppLovinSdkTopic {
    public static final List<String> ALL_TOPICS = new ArrayList();
    public static final String HTTP_REQUEST = "send_http_request";
    public static final String TEST_MODE_NETWORK = "test_mode_network";

    static {
        ALL_TOPICS.add(HTTP_REQUEST);
    }

    private AppLovinSdkTopic() {
    }
}
