package com.google.games.bridge;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class TokenResult implements Result {
    private String authCode;
    private String email;
    private String idToken;
    private Status status;

    public TokenResult() {
    }

    TokenResult(String str, String str2, String str3, int i) {
        this.status = new Status(i);
        this.authCode = str;
        this.idToken = str3;
        this.email = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: ");
        sb.append(this.status);
        sb.append(" email: ");
        String str = this.email;
        String str2 = "<null>";
        if (str == null) {
            str = str2;
        }
        sb.append(str);
        sb.append(" id:");
        String str3 = this.idToken;
        if (str3 == null) {
            str3 = str2;
        }
        sb.append(str3);
        sb.append(" access: ");
        String str4 = this.authCode;
        if (str4 == null) {
            str4 = str2;
        }
        sb.append(str4);
        return sb.toString();
    }

    public Status getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return this.status.getStatusCode();
    }

    public String getAuthCode() {
        String str = this.authCode;
        return str == null ? "" : str;
    }

    public String getIdToken() {
        String str = this.idToken;
        return str == null ? "" : str;
    }

    public String getEmail() {
        String str = this.email;
        return str == null ? "" : str;
    }

    public void setStatus(int i) {
        this.status = new Status(i);
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setIdToken(String str) {
        this.idToken = str;
    }
}
