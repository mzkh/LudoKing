package com.unity.purchasing.common;

public class ProductDefinition {

    /* renamed from: id */
    public String f7789id;
    public String storeSpecificId;
    public ProductType type;

    public ProductDefinition(String str, String str2, ProductType productType) {
        this.f7789id = str;
        this.storeSpecificId = str2;
        this.type = productType;
    }

    public ProductDefinition(String str, ProductType productType) {
        this(str, str, productType);
    }
}
