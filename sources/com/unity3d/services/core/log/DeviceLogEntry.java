package com.unity3d.services.core.log;

class DeviceLogEntry {
    private DeviceLogLevel _logLevel = null;
    private String _originalMessage = null;
    private StackTraceElement _stackTraceElement = null;

    public DeviceLogEntry(DeviceLogLevel deviceLogLevel, String str, StackTraceElement stackTraceElement) {
        this._logLevel = deviceLogLevel;
        this._originalMessage = str;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        int i;
        String str;
        String str2;
        String str3 = this._originalMessage;
        StackTraceElement stackTraceElement = this._stackTraceElement;
        if (stackTraceElement != null) {
            str2 = stackTraceElement.getClassName();
            str = this._stackTraceElement.getMethodName();
            i = this._stackTraceElement.getLineNumber();
        } else {
            str2 = "UnknownClass";
            str = "unknownMethod";
            i = -1;
        }
        if (str3 != null && !str3.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" :: ");
            sb.append(str3);
            str3 = sb.toString();
        }
        if (str3 == null) {
            str3 = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" (line:");
        sb2.append(i);
        sb2.append(")");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(".");
        sb4.append(str);
        sb4.append("()");
        sb4.append(sb3);
        sb4.append(str3);
        return sb4.toString();
    }
}
