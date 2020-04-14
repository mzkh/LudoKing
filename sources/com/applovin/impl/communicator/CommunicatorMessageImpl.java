package com.applovin.impl.communicator;

import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import java.lang.ref.WeakReference;
import java.util.UUID;

public abstract class CommunicatorMessageImpl extends Intent {

    /* renamed from: a */
    private final String f1629a = UUID.randomUUID().toString();
    protected final Bundle data;
    protected final WeakReference<AppLovinCommunicatorPublisher> publisherRef;
    protected boolean sticky;

    public CommunicatorMessageImpl(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z) {
        super(str);
        this.publisherRef = new WeakReference<>(appLovinCommunicatorPublisher);
        this.sticky = z;
        this.data = bundle;
    }

    public static AppLovinCommunicatorMessage create(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z) {
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, str, appLovinCommunicatorPublisher);
        appLovinCommunicatorMessage.sticky = z;
        return appLovinCommunicatorMessage;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo9246a() {
        return this.sticky;
    }

    public abstract Bundle getMessageData();

    public abstract String getPublisherId();

    public abstract String getTopic();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinCommunicatorMessage{publisherId=");
        sb.append(getPublisherId());
        sb.append(", topic=");
        sb.append(getTopic());
        sb.append('\'');
        sb.append(", uniqueId='");
        sb.append(this.f1629a);
        sb.append('\'');
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", sticky=");
        sb.append(this.sticky);
        sb.append('}');
        return sb.toString();
    }
}
