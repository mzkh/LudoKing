package com.unity.purchasing.googleplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
    Map<String, Purchase> mConsumablePurchaseHistoryMap = new HashMap();
    Set<String> mPurchaseHistoryOfSub = new HashSet();
    Map<String, Purchase> mPurchaseMap = new HashMap();
    public Map<String, SkuDetails> mSkuMap = new HashMap();

    Inventory() {
    }

    public boolean hasPurchaseHistory(String str) {
        return this.mPurchaseHistoryOfSub.contains(str);
    }

    public List<String> getSubscriptionsWithHistory() {
        return new ArrayList(this.mPurchaseHistoryOfSub);
    }

    public SkuDetails getSkuDetails(String str) {
        return (SkuDetails) this.mSkuMap.get(str);
    }

    public Purchase getPurchase(String str) {
        return (Purchase) this.mPurchaseMap.get(str);
    }

    public Purchase getHistoryPurchase(String str) {
        return (Purchase) this.mConsumablePurchaseHistoryMap.get(str);
    }

    public boolean hasPurchase(String str) {
        return this.mPurchaseMap.containsKey(str);
    }

    public boolean hasConsumablePurchaseHistory(String str) {
        return this.mConsumablePurchaseHistoryMap.containsKey(str);
    }

    public boolean hasDetails(String str) {
        return this.mSkuMap.containsKey(str);
    }

    public void erasePurchase(String str) {
        if (this.mPurchaseMap.containsKey(str)) {
            this.mPurchaseMap.remove(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public List<String> getAllOwnedSkus() {
        return new ArrayList(this.mPurchaseMap.keySet());
    }

    /* access modifiers changed from: 0000 */
    public List<String> getAllSkus(String str) {
        ArrayList arrayList = new ArrayList();
        for (SkuDetails skuDetails : this.mSkuMap.values()) {
            if (skuDetails.getType().equals(str)) {
                arrayList.add(skuDetails.getSku());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public List<String> getAllOwnedSkus(String str) {
        ArrayList arrayList = new ArrayList();
        for (Purchase purchase : this.mPurchaseMap.values()) {
            if (purchase.getItemType().equals(str)) {
                arrayList.add(purchase.getSku());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public List<Purchase> getAllPurchases() {
        return new ArrayList(this.mPurchaseMap.values());
    }

    /* access modifiers changed from: 0000 */
    public void addSkuDetails(SkuDetails skuDetails) {
        this.mSkuMap.put(skuDetails.getSku(), skuDetails);
    }

    /* access modifiers changed from: 0000 */
    public void addPurchase(Purchase purchase) {
        this.mPurchaseMap.put(purchase.getSku(), purchase);
    }

    /* access modifiers changed from: 0000 */
    public void addPurchaseToSubscriptionPurchaseHistory(String str) {
        this.mPurchaseHistoryOfSub.add(str);
    }

    /* access modifiers changed from: 0000 */
    public void addPurchaseToConsumablePurchaseHistory(String str, Purchase purchase) {
        this.mConsumablePurchaseHistoryMap.put(str, purchase);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("skuDetails = ");
        String str3 = "[";
        sb.append(str3);
        Iterator it = this.mSkuMap.keySet().iterator();
        while (true) {
            str = ", ";
            str2 = " = ";
            if (!it.hasNext()) {
                break;
            }
            String str4 = (String) it.next();
            sb.append(str4);
            sb.append(str2);
            sb.append(getSkuDetails(str4));
            sb.append(str);
        }
        String str5 = "]";
        sb.append(str5);
        sb.append(", purchases = ");
        sb.append(str3);
        for (String str6 : this.mPurchaseMap.keySet()) {
            sb.append(str6);
            sb.append(str2);
            sb.append(getSkuDetails(str6));
            sb.append(str);
        }
        sb.append(str5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{Inventory: ");
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }
}
