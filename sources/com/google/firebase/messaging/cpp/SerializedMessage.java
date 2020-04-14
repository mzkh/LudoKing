package com.google.firebase.messaging.cpp;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SerializedMessage extends Table {
    public static SerializedMessage getRootAsSerializedMessage(ByteBuffer byteBuffer) {
        return getRootAsSerializedMessage(byteBuffer, new SerializedMessage());
    }

    public static SerializedMessage getRootAsSerializedMessage(ByteBuffer byteBuffer, SerializedMessage serializedMessage) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return serializedMessage.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f3927bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f3927bb.getInt(this.bb_pos);
        this.vtable_size = this.f3927bb.getShort(this.vtable_start);
    }

    public SerializedMessage __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String from() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer fromAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer fromInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    /* renamed from: to */
    public String mo26372to() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer toAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer toInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String collapseKey() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer collapseKeyAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer collapseKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public DataPair data(int i) {
        return data(new DataPair(), i);
    }

    public DataPair data(DataPair dataPair, int i) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return dataPair.__assign(__indirect(__vector(__offset) + (i * 4)), this.f3927bb);
        }
        return null;
    }

    public int dataLength() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public String rawData() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer rawDataAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer rawDataInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String messageId() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageIdAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer messageIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public String messageType() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer messageTypeAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer messageTypeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String priority() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer priorityAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer priorityInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public int timeToLive() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return this.f3927bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public String error() {
        int __offset = __offset(22);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer errorAsByteBuffer() {
        return __vector_as_bytebuffer(22, 1);
    }

    public ByteBuffer errorInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 22, 1);
    }

    public String errorDescription() {
        int __offset = __offset(24);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer errorDescriptionAsByteBuffer() {
        return __vector_as_bytebuffer(24, 1);
    }

    public ByteBuffer errorDescriptionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 24, 1);
    }

    public SerializedNotification notification() {
        return notification(new SerializedNotification());
    }

    public SerializedNotification notification(SerializedNotification serializedNotification) {
        int __offset = __offset(26);
        if (__offset != 0) {
            return serializedNotification.__assign(__indirect(__offset + this.bb_pos), this.f3927bb);
        }
        return null;
    }

    public boolean notificationOpened() {
        int __offset = __offset(28);
        return (__offset == 0 || this.f3927bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public String link() {
        int __offset = __offset(30);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer linkAsByteBuffer() {
        return __vector_as_bytebuffer(30, 1);
    }

    public ByteBuffer linkInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 30, 1);
    }

    public long sentTime() {
        int __offset = __offset(32);
        if (__offset != 0) {
            return this.f3927bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public String originalPriority() {
        int __offset = __offset(34);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer originalPriorityAsByteBuffer() {
        return __vector_as_bytebuffer(34, 1);
    }

    public ByteBuffer originalPriorityInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 34, 1);
    }

    public static int createSerializedMessage(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z, int i13, long j, int i14) {
        FlatBufferBuilder flatBufferBuilder2 = flatBufferBuilder;
        flatBufferBuilder.startObject(16);
        addSentTime(flatBufferBuilder, j);
        addOriginalPriority(flatBufferBuilder, i14);
        addLink(flatBufferBuilder, i13);
        int i15 = i12;
        addNotification(flatBufferBuilder, i12);
        int i16 = i11;
        addErrorDescription(flatBufferBuilder, i11);
        int i17 = i10;
        addError(flatBufferBuilder, i10);
        int i18 = i9;
        addTimeToLive(flatBufferBuilder, i9);
        int i19 = i8;
        addPriority(flatBufferBuilder, i8);
        int i20 = i7;
        addMessageType(flatBufferBuilder, i7);
        int i21 = i6;
        addMessageId(flatBufferBuilder, i6);
        int i22 = i5;
        addRawData(flatBufferBuilder, i5);
        int i23 = i4;
        addData(flatBufferBuilder, i4);
        int i24 = i3;
        addCollapseKey(flatBufferBuilder, i3);
        int i25 = i2;
        addTo(flatBufferBuilder, i2);
        addFrom(flatBufferBuilder, i);
        addNotificationOpened(flatBufferBuilder, z);
        return endSerializedMessage(flatBufferBuilder);
    }

    public static void startSerializedMessage(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(16);
    }

    public static void addFrom(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addTo(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addCollapseKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addData(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createDataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startDataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addRawData(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addMessageId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addMessageType(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addPriority(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static void addTimeToLive(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(8, i, 0);
    }

    public static void addError(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(9, i, 0);
    }

    public static void addErrorDescription(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(10, i, 0);
    }

    public static void addNotification(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(11, i, 0);
    }

    public static void addNotificationOpened(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(12, z, false);
    }

    public static void addLink(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(13, i, 0);
    }

    public static void addSentTime(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(14, j, 0);
    }

    public static void addOriginalPriority(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(15, i, 0);
    }

    public static int endSerializedMessage(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
