package com.google.android.gms.drive.query;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zzd;
import com.google.android.gms.drive.query.internal.zzn;
import com.google.android.gms.drive.query.internal.zzp;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzv;
import com.google.android.gms.drive.query.internal.zzx;
import com.google.android.gms.drive.query.internal.zzz;

public class Filters {
    public static Filter and(@NonNull Filter filter, @NonNull Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmf, filter, filterArr);
    }

    public static Filter and(@NonNull Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmf, iterable);
    }

    public static Filter contains(@NonNull SearchableMetadataField<String> searchableMetadataField, @NonNull String str) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(str, "Value may not be null.");
        return new zzb(zzx.zzmi, searchableMetadataField, str);
    }

    /* renamed from: eq */
    public static Filter m3396eq(@NonNull CustomPropertyKey customPropertyKey, @NonNull String str) {
        Preconditions.checkNotNull(customPropertyKey, "Custom property key may not be null.");
        Preconditions.checkNotNull(str, "Custom property value may not be null.");
        return new zzn(SearchableField.zzlf, new zza().zza(customPropertyKey, str).zzat());
    }

    /* renamed from: eq */
    public static <T> Filter m3397eq(@NonNull SearchableMetadataField<T> searchableMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzma, searchableMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThan(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmd, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzme, searchableOrderedMetadataField, t);
    }

    /* renamed from: in */
    public static <T> Filter m3398in(@NonNull SearchableCollectionMetadataField<T> searchableCollectionMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableCollectionMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzp(searchableCollectionMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThan(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmb, searchableOrderedMetadataField, t);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(@NonNull SearchableOrderedMetadataField<T> searchableOrderedMetadataField, @NonNull T t) {
        Preconditions.checkNotNull(searchableOrderedMetadataField, "Field may not be null.");
        Preconditions.checkNotNull(t, "Value may not be null.");
        return new zzb(zzx.zzmc, searchableOrderedMetadataField, t);
    }

    public static Filter not(@NonNull Filter filter) {
        Preconditions.checkNotNull(filter, "Filter may not be null");
        return new zzv(filter);
    }

    public static Filter openedByMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.LAST_VIEWED_BY_ME);
    }

    /* renamed from: or */
    public static Filter m3399or(@NonNull Filter filter, @NonNull Filter... filterArr) {
        Preconditions.checkNotNull(filter, "Filter may not be null.");
        Preconditions.checkNotNull(filterArr, "Additional filters may not be null.");
        return new zzr(zzx.zzmg, filter, filterArr);
    }

    /* renamed from: or */
    public static Filter m3400or(@NonNull Iterable<Filter> iterable) {
        Preconditions.checkNotNull(iterable, "Filters may not be null");
        return new zzr(zzx.zzmg, iterable);
    }

    public static Filter ownedByMe() {
        return new zzz();
    }

    public static Filter sharedWithMe() {
        return new zzd((SearchableMetadataField<?>) SearchableField.zzle);
    }
}
