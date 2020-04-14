package com.google.firebase.messaging.cpp;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Map.Entry;

public class MessageWriter {
    private static final MessageWriter DEFAULT_INSTANCE = new MessageWriter();
    static final String LOCK_FILE = "FIREBASE_CLOUD_MESSAGING_LOCKFILE";
    static final String STORAGE_FILE = "FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE";
    private static final String TAG = "FIREBASE_MESSAGE_WRITER";

    private static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    private static String priorityToString(int i) {
        return i != 1 ? i != 2 ? "" : "normal" : "high";
    }

    public static MessageWriter defaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public void writeMessage(Context context, RemoteMessage remoteMessage, boolean z, Uri uri) {
        String str;
        String from = remoteMessage.getFrom();
        String to = remoteMessage.getTo();
        String messageId = remoteMessage.getMessageId();
        String messageType = remoteMessage.getMessageType();
        Map data = remoteMessage.getData();
        Notification notification = remoteMessage.getNotification();
        String collapseKey = remoteMessage.getCollapseKey();
        int priority = remoteMessage.getPriority();
        int originalPriority = remoteMessage.getOriginalPriority();
        long sentTime = remoteMessage.getSentTime();
        int ttl = remoteMessage.getTtl();
        Uri link = (uri != null || notification == null) ? uri : notification.getLink();
        String uri2 = link != null ? link.toString() : null;
        Object[] objArr = new Object[4];
        objArr[0] = from;
        objArr[1] = messageId;
        String str2 = "(null)";
        if (data == null) {
            str = str2;
        } else {
            str = data.toString();
        }
        objArr[2] = str;
        if (notification != null) {
            str2 = notification.toString();
        }
        objArr[3] = str2;
        DebugLogging.log(TAG, String.format("onMessageReceived from=%s message_id=%s, data=%s, notification=%s", objArr));
        writeMessageToInternalStorage(context, from, to, messageId, messageType, null, data, notification, z, uri2, collapseKey, priority, originalPriority, sentTime, ttl);
    }

    /* access modifiers changed from: 0000 */
    public void writeMessageEventToInternalStorage(Context context, String str, String str2, String str3) {
        writeMessageToInternalStorage(context, null, null, str, str2, null, null, null, false, null, null, 0, 0, 0, 0);
    }

    /* access modifiers changed from: 0000 */
    public void writeMessageToInternalStorage(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map, Notification notification, boolean z, String str6, String str7, int i, int i2, long j, int i3) {
        Context context2 = context;
        byte[] generateMessageByteBuffer = generateMessageByteBuffer(str, str2, str3, str4, str5, map, notification, z, str6, str7, i, i2, j, i3);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(generateMessageByteBuffer.length);
        FileLock fileLock = null;
        try {
            fileLock = context.openFileOutput(LOCK_FILE, 0).getChannel().lock();
            FileOutputStream openFileOutput = context.openFileOutput(STORAGE_FILE, 32768);
            openFileOutput.write(allocate.array());
            openFileOutput.write(generateMessageByteBuffer);
            openFileOutput.close();
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (fileLock != null) {
                fileLock.release();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th2;
        }
    }

    private static byte[] generateMessageByteBuffer(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Notification notification, boolean z, String str6, String str7, int i, int i2, long j, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        int createString = flatBufferBuilder.createString((CharSequence) emptyIfNull(str));
        int createString2 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str2));
        int createString3 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str3));
        int createString4 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str4));
        int createString5 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str5));
        int createString6 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str6));
        int createString7 = flatBufferBuilder.createString((CharSequence) emptyIfNull(str7));
        int createString8 = flatBufferBuilder.createString((CharSequence) priorityToString(i));
        int createString9 = flatBufferBuilder.createString((CharSequence) priorityToString(i2));
        if (map != null) {
            int[] iArr = new int[map.size()];
            int i19 = 0;
            for (Entry entry : map.entrySet()) {
                int i20 = i19 + 1;
                iArr[i19] = DataPair.createDataPair(flatBufferBuilder, flatBufferBuilder.createString((CharSequence) entry.getKey()), flatBufferBuilder.createString((CharSequence) entry.getValue()));
                i19 = i20;
            }
            i4 = SerializedMessage.createDataVector(flatBufferBuilder, iArr);
        } else {
            i4 = 0;
        }
        if (notification != null) {
            int createString10 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getTitle()));
            int createString11 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getBody()));
            int createString12 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getIcon()));
            int createString13 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getSound()));
            int createString14 = flatBufferBuilder.createString((CharSequence) "");
            i10 = createString6;
            int createString15 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getTag()));
            i9 = i4;
            int createString16 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getColor()));
            i8 = createString7;
            int createString17 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getClickAction()));
            i7 = createString5;
            int createString18 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getChannelId()));
            i6 = createString9;
            int createString19 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getBodyLocalizationKey()));
            i5 = createString8;
            String[] bodyLocalizationArgs = notification.getBodyLocalizationArgs();
            if (bodyLocalizationArgs != null) {
                i14 = createString4;
                int[] iArr2 = new int[bodyLocalizationArgs.length];
                i13 = createString3;
                int length = bodyLocalizationArgs.length;
                i12 = createString2;
                int i21 = 0;
                int i22 = 0;
                while (i21 < length) {
                    int i23 = length;
                    int i24 = i22 + 1;
                    iArr2[i22] = flatBufferBuilder.createString((CharSequence) bodyLocalizationArgs[i21]);
                    i21++;
                    length = i23;
                    i22 = i24;
                }
                i16 = SerializedNotification.createBodyLocArgsVector(flatBufferBuilder, iArr2);
            } else {
                i12 = createString2;
                i13 = createString3;
                i14 = createString4;
                i16 = 0;
            }
            int createString20 = flatBufferBuilder.createString((CharSequence) emptyIfNull(notification.getTitleLocalizationKey()));
            String[] titleLocalizationArgs = notification.getTitleLocalizationArgs();
            if (titleLocalizationArgs != null) {
                int[] iArr3 = new int[titleLocalizationArgs.length];
                i11 = createString;
                int length2 = titleLocalizationArgs.length;
                i17 = createString20;
                int i25 = 0;
                int i26 = 0;
                while (i25 < length2) {
                    int i27 = length2;
                    int i28 = i26 + 1;
                    iArr3[i26] = flatBufferBuilder.createString((CharSequence) titleLocalizationArgs[i25]);
                    i25++;
                    length2 = i27;
                    i26 = i28;
                }
                i18 = SerializedNotification.createTitleLocArgsVector(flatBufferBuilder, iArr3);
            } else {
                i11 = createString;
                i17 = createString20;
                i18 = 0;
            }
            SerializedNotification.startSerializedNotification(flatBufferBuilder);
            SerializedNotification.addTitle(flatBufferBuilder, createString10);
            SerializedNotification.addBody(flatBufferBuilder, createString11);
            SerializedNotification.addIcon(flatBufferBuilder, createString12);
            SerializedNotification.addSound(flatBufferBuilder, createString13);
            SerializedNotification.addBadge(flatBufferBuilder, createString14);
            SerializedNotification.addTag(flatBufferBuilder, createString15);
            SerializedNotification.addColor(flatBufferBuilder, createString16);
            SerializedNotification.addClickAction(flatBufferBuilder, createString17);
            SerializedNotification.addAndroidChannelId(flatBufferBuilder, createString18);
            SerializedNotification.addBodyLocKey(flatBufferBuilder, createString19);
            SerializedNotification.addBodyLocArgs(flatBufferBuilder, i16);
            SerializedNotification.addTitleLocKey(flatBufferBuilder, i17);
            SerializedNotification.addTitleLocArgs(flatBufferBuilder, i18);
            i15 = SerializedNotification.endSerializedNotification(flatBufferBuilder);
        } else {
            i11 = createString;
            i12 = createString2;
            i13 = createString3;
            i14 = createString4;
            i7 = createString5;
            i10 = createString6;
            i8 = createString7;
            i5 = createString8;
            i6 = createString9;
            i9 = i4;
            i15 = 0;
        }
        SerializedMessage.startSerializedMessage(flatBufferBuilder);
        SerializedMessage.addFrom(flatBufferBuilder, i11);
        SerializedMessage.addTo(flatBufferBuilder, i12);
        SerializedMessage.addMessageId(flatBufferBuilder, i13);
        SerializedMessage.addMessageType(flatBufferBuilder, i14);
        SerializedMessage.addPriority(flatBufferBuilder, i5);
        SerializedMessage.addOriginalPriority(flatBufferBuilder, i6);
        SerializedMessage.addSentTime(flatBufferBuilder, j);
        SerializedMessage.addTimeToLive(flatBufferBuilder, i3);
        SerializedMessage.addError(flatBufferBuilder, i7);
        SerializedMessage.addCollapseKey(flatBufferBuilder, i8);
        if (map != null) {
            SerializedMessage.addData(flatBufferBuilder, i9);
        }
        if (notification != null) {
            SerializedMessage.addNotification(flatBufferBuilder, i15);
        }
        SerializedMessage.addNotificationOpened(flatBufferBuilder, z);
        SerializedMessage.addLink(flatBufferBuilder, i10);
        int endSerializedMessage = SerializedMessage.endSerializedMessage(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, 1);
        SerializedEvent.addEvent(flatBufferBuilder, endSerializedMessage);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
