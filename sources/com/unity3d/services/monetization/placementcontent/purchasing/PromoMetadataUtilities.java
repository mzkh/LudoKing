package com.unity3d.services.monetization.placementcontent.purchasing;

import com.applovin.sdk.AppLovinEventTypes;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.unity3d.services.monetization.placementcontent.purchasing.PromoMetadata.Builder;
import com.unity3d.services.purchasing.core.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PromoMetadataUtilities {
    public static PromoMetadata createPromoMetadataFromParamsMap(Map<String, Object> map) {
        Builder newBuilder = PromoMetadata.newBuilder();
        String str = "impressionDate";
        if (map.containsKey(str)) {
            newBuilder.withImpressionDate(new Date(((Long) map.get(str)).longValue()));
        }
        String str2 = "offerDuration";
        if (map.containsKey(str2)) {
            newBuilder.withOfferDuration(Long.valueOf(map.get(str2).toString()).longValue());
        }
        String str3 = "costs";
        if (map.containsKey(str3)) {
            newBuilder.withCosts(getItemListFromList((List) map.get(str3)));
        }
        String str4 = "payouts";
        if (map.containsKey(str4)) {
            newBuilder.withPayouts(getItemListFromList((List) map.get(str4)));
        }
        String str5 = AppLovinEventTypes.USER_VIEWED_PRODUCT;
        if (map.containsKey(str5)) {
            newBuilder.withPremiumProduct(createProductFromMap((Map) map.get(str5)));
        }
        String str6 = "userInfo";
        if (map.containsKey(str6)) {
            newBuilder.withCustomInfo((Map) map.get(str6));
        }
        return newBuilder.build();
    }

    private static List<Item> getItemListFromList(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Map createItemFromMap : list) {
            arrayList.add(createItemFromMap(createItemFromMap));
        }
        return arrayList;
    }

    private static Item createItemFromMap(Map<String, Object> map) {
        Item.Builder newBuilder = Item.newBuilder();
        String str = "itemId";
        if (map.containsKey(str)) {
            newBuilder.withItemId((String) map.get(str));
        }
        String str2 = Param.QUANTITY;
        if (map.containsKey(str2)) {
            newBuilder.withQuantity(((Number) map.get(str2)).longValue());
        }
        String str3 = "type";
        if (map.containsKey(str3)) {
            newBuilder.withType((String) map.get(str3));
        }
        return newBuilder.build();
    }

    private static Product createProductFromMap(Map<String, Object> map) {
        Product.Builder newBuilder = Product.newBuilder();
        String str = "productId";
        if (map.containsKey(str)) {
            newBuilder.withProductId((String) map.get(str));
        }
        String str2 = "isoCurrencyCode";
        if (map.containsKey(str2)) {
            newBuilder.withIsoCurrencyCode((String) map.get(str2));
        }
        String str3 = "localizedPriceString";
        if (map.containsKey(str3)) {
            newBuilder.withLocalizedPriceString((String) map.get(str3));
        }
        String str4 = "localizedDescription";
        if (map.containsKey(str4)) {
            newBuilder.withLocalizedDescription((String) map.get(str4));
        }
        String str5 = "localizedTitle";
        if (map.containsKey(str5)) {
            newBuilder.withLocalizedTitle((String) map.get(str5));
        }
        String str6 = "localizedPrice";
        if (map.containsKey(str6)) {
            newBuilder.withLocalizedPrice(new Double(map.get(str6).toString()).doubleValue());
        }
        String str7 = "productType";
        if (map.containsKey(str7)) {
            newBuilder.withProductType((String) map.get(str7));
        }
        return newBuilder.build();
    }
}
