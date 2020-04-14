package com.unity3d.services.store.core;

public class StoreException extends Exception {
    private int _resultCode;

    public StoreException() {
        super("Unknown store exception");
        this._resultCode = -1;
    }

    public StoreException(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Store exception with result code ");
        sb.append(i);
        super(sb.toString());
        this._resultCode = i;
    }

    public int getResultCode() {
        return this._resultCode;
    }
}
