package com.ludo.king.localnotification;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationAction implements Parcelable {
    public static final Creator CREATOR = new Creator();
    private String gameObject;
    private String handlerMethod;
    private String icon;
    private String identifier;
    private String title;

    private static class Creator implements android.os.Parcelable.Creator<NotificationAction> {
        private Creator() {
        }

        public NotificationAction createFromParcel(Parcel parcel) {
            NotificationAction notificationAction = new NotificationAction();
            notificationAction.setIdentifier(parcel.readString());
            notificationAction.setTitle(parcel.readString());
            notificationAction.setIcon(parcel.readString());
            notificationAction.setGameObject(parcel.readString());
            notificationAction.setHandlerMethod(parcel.readString());
            return notificationAction;
        }

        public NotificationAction[] newArray(int i) {
            return new NotificationAction[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getGameObject() {
        return this.gameObject;
    }

    public void setGameObject(String str) {
        this.gameObject = str;
    }

    public String getHandlerMethod() {
        return this.handlerMethod;
    }

    public void setHandlerMethod(String str) {
        this.handlerMethod = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getIdentifier());
        parcel.writeString(getTitle());
        parcel.writeString(getIcon());
        parcel.writeString(getGameObject());
        parcel.writeString(getHandlerMethod());
    }
}
