package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f1630a;

    /* renamed from: b */
    private final ScheduledThreadPoolExecutor f1631b;

    /* renamed from: c */
    private final Queue<CommunicatorMessageImpl> f1632c = new LinkedList();

    /* renamed from: d */
    private final Object f1633d = new Object();

    public MessagingServiceImpl(Context context) {
        this.f1630a = context;
        this.f1631b = m1389a();
    }

    /* renamed from: a */
    private Queue<CommunicatorMessageImpl> m1388a(String str) {
        LinkedList linkedList;
        synchronized (this.f1633d) {
            linkedList = new LinkedList();
            for (CommunicatorMessageImpl communicatorMessageImpl : this.f1632c) {
                if (communicatorMessageImpl.mo9246a() && communicatorMessageImpl.getTopic().equals(str)) {
                    linkedList.add(communicatorMessageImpl);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m1389a() {
        return new ScheduledThreadPoolExecutor(16, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    /* renamed from: a */
    private void m1390a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f1631b.execute(new Runnable() {
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f1630a).sendBroadcastSync(communicatorMessageImpl);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl a : m1388a(str)) {
            m1390a(a);
        }
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        m1390a((CommunicatorMessageImpl) appLovinCommunicatorMessage);
        synchronized (this.f1633d) {
            this.f1632c.add(appLovinCommunicatorMessage);
        }
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}
