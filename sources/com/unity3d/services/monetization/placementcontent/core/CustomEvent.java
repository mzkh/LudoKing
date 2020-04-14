package com.unity3d.services.monetization.placementcontent.core;

import java.util.HashMap;
import java.util.Map;

public class CustomEvent {
    private String category;
    private Map<String, Object> data;
    private String type;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String category;
        /* access modifiers changed from: private */
        public Map<String, Object> data;
        /* access modifiers changed from: private */
        public String type;

        private Builder() {
        }

        public Builder withCategory(String str) {
            this.category = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withData(Map<String, Object> map) {
            this.data = map;
            return this;
        }

        public Builder putAllData(Map<String, Object> map) {
            Map<String, Object> map2 = this.data;
            if (map2 == null) {
                this.data = new HashMap(map);
            } else {
                map2.putAll(map);
            }
            return this;
        }

        public Builder putData(String str, Object obj) {
            if (this.data == null) {
                this.data = new HashMap();
            }
            this.data.put(str, obj);
            return this;
        }

        public CustomEvent build() {
            return new CustomEvent(this);
        }
    }

    public CustomEvent() {
    }

    public CustomEvent(String str) {
        this.type = str;
    }

    public CustomEvent(String str, Map<String, Object> map) {
        this.type = str;
        this.data = map;
    }

    public CustomEvent(String str, String str2, Map<String, Object> map) {
        this.category = str;
        this.type = str2;
        this.data = map;
    }

    private CustomEvent(Builder builder) {
        setCategory(builder.category);
        setType(builder.type);
        setData(builder.data);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }
}
