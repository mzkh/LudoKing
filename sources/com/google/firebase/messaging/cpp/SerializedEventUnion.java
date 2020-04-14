package com.google.firebase.messaging.cpp;

public final class SerializedEventUnion {
    public static final byte NONE = 0;
    public static final byte SerializedMessage = 1;
    public static final byte SerializedTokenReceived = 2;
    public static final String[] names = {"NONE", "SerializedMessage", "SerializedTokenReceived"};

    private SerializedEventUnion() {
    }

    public static String name(int i) {
        return names[i];
    }
}
