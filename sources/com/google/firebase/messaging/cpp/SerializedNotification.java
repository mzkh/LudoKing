package com.google.firebase.messaging.cpp;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SerializedNotification extends Table {
    public static SerializedNotification getRootAsSerializedNotification(ByteBuffer byteBuffer) {
        return getRootAsSerializedNotification(byteBuffer, new SerializedNotification());
    }

    public static SerializedNotification getRootAsSerializedNotification(ByteBuffer byteBuffer, SerializedNotification serializedNotification) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return serializedNotification.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        this.bb_pos = i;
        this.f3927bb = byteBuffer;
        this.vtable_start = this.bb_pos - this.f3927bb.getInt(this.bb_pos);
        this.vtable_size = this.f3927bb.getShort(this.vtable_start);
    }

    public SerializedNotification __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String title() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer titleAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer titleInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String body() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bodyAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer bodyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public String icon() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer iconAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer iconInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public String sound() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer soundAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer soundInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String badge() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer badgeAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer badgeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String tag() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer tagAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer tagInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public String color() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer colorAsByteBuffer() {
        return __vector_as_bytebuffer(16, 1);
    }

    public ByteBuffer colorInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 1);
    }

    public String clickAction() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer clickActionAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer clickActionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public String bodyLocKey() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer bodyLocKeyAsByteBuffer() {
        return __vector_as_bytebuffer(20, 1);
    }

    public ByteBuffer bodyLocKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 1);
    }

    public String bodyLocArgs(int i) {
        int __offset = __offset(22);
        if (__offset != 0) {
            return __string(__vector(__offset) + (i * 4));
        }
        return null;
    }

    public int bodyLocArgsLength() {
        int __offset = __offset(22);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public String titleLocKey() {
        int __offset = __offset(24);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer titleLocKeyAsByteBuffer() {
        return __vector_as_bytebuffer(24, 1);
    }

    public ByteBuffer titleLocKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 24, 1);
    }

    public String titleLocArgs(int i) {
        int __offset = __offset(26);
        if (__offset != 0) {
            return __string(__vector(__offset) + (i * 4));
        }
        return null;
    }

    public int titleLocArgsLength() {
        int __offset = __offset(26);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public String androidChannelId() {
        int __offset = __offset(28);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer androidChannelIdAsByteBuffer() {
        return __vector_as_bytebuffer(28, 1);
    }

    public ByteBuffer androidChannelIdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 28, 1);
    }

    public static int createSerializedNotification(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        flatBufferBuilder.startObject(13);
        addAndroidChannelId(flatBufferBuilder, i13);
        addTitleLocArgs(flatBufferBuilder, i12);
        addTitleLocKey(flatBufferBuilder, i11);
        addBodyLocArgs(flatBufferBuilder, i10);
        addBodyLocKey(flatBufferBuilder, i9);
        addClickAction(flatBufferBuilder, i8);
        addColor(flatBufferBuilder, i7);
        addTag(flatBufferBuilder, i6);
        addBadge(flatBufferBuilder, i5);
        addSound(flatBufferBuilder, i4);
        addIcon(flatBufferBuilder, i3);
        addBody(flatBufferBuilder, i2);
        addTitle(flatBufferBuilder, i);
        return endSerializedNotification(flatBufferBuilder);
    }

    public static void startSerializedNotification(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startObject(13);
    }

    public static void addTitle(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addBody(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addIcon(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addSound(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addBadge(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addTag(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addColor(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addClickAction(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static void addBodyLocKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static void addBodyLocArgs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(9, i, 0);
    }

    public static int createBodyLocArgsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startBodyLocArgsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addTitleLocKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(10, i, 0);
    }

    public static void addTitleLocArgs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(11, i, 0);
    }

    public static int createTitleLocArgsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startTitleLocArgsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addAndroidChannelId(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(12, i, 0);
    }

    public static int endSerializedNotification(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endObject();
    }
}
