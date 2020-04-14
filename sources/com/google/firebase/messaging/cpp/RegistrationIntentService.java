package com.google.firebase.messaging.cpp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileLock;

public class RegistrationIntentService extends IntentService {
    private static final String TAG = "FirebaseRegService";

    public RegistrationIntentService() {
        super(TAG);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String token = FirebaseInstanceId.getInstance().getToken();
        DebugLogging.log(TAG, String.format("onHandleIntent token=%s", new Object[]{token}));
        if (token != null) {
            writeTokenToInternalStorage(this, token);
        }
    }

    public static void writeTokenToInternalStorage(Context context, String str) {
        byte[] generateTokenByteBuffer = generateTokenByteBuffer(str);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(generateTokenByteBuffer.length);
        FileLock fileLock = null;
        try {
            fileLock = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCKFILE", 0).getChannel().lock();
            FileOutputStream openFileOutput = context.openFileOutput("FIREBASE_CLOUD_MESSAGING_LOCAL_STORAGE", 32768);
            openFileOutput.write(allocate.array());
            openFileOutput.write(generateTokenByteBuffer);
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
        } finally {
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private static byte[] generateTokenByteBuffer(String str) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(0);
        if (str == null) {
            str = "";
        }
        int createString = flatBufferBuilder.createString((CharSequence) str);
        SerializedTokenReceived.startSerializedTokenReceived(flatBufferBuilder);
        SerializedTokenReceived.addToken(flatBufferBuilder, createString);
        int endSerializedTokenReceived = SerializedTokenReceived.endSerializedTokenReceived(flatBufferBuilder);
        SerializedEvent.startSerializedEvent(flatBufferBuilder);
        SerializedEvent.addEventType(flatBufferBuilder, 2);
        SerializedEvent.addEvent(flatBufferBuilder, endSerializedTokenReceived);
        flatBufferBuilder.finish(SerializedEvent.endSerializedEvent(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }
}
