package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcen;
    private String zzdko;
    private String zzeip;
    private List<Image> zzeiq;
    private Image zzeir;
    private String zzeis;
    private String zzeiu;
    private String zzeiv;
    private View zzeiw;
    private boolean zzeix;
    private String zzeiz;
    private Double zzeja;
    private View zzejb;
    private Object zzejc;
    private boolean zzejd;
    private boolean zzeje;
    private float zzejf;

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void setHeadline(String str) {
        this.zzeip = str;
    }

    public final void setImages(List<Image> list) {
        this.zzeiq = list;
    }

    public final void setBody(String str) {
        this.zzdko = str;
    }

    public final void setIcon(Image image) {
        this.zzeir = image;
    }

    public final void setCallToAction(String str) {
        this.zzeis = str;
    }

    public final void setAdvertiser(String str) {
        this.zzeiz = str;
    }

    public final void setStarRating(Double d) {
        this.zzeja = d;
    }

    public final void setStore(String str) {
        this.zzeiu = str;
    }

    public final void setPrice(String str) {
        this.zzeiv = str;
    }

    public final void zza(VideoController videoController) {
        this.zzcen = videoController;
    }

    public void setHasVideoContent(boolean z) {
        this.zzeix = z;
    }

    public void setAdChoicesContent(View view) {
        this.zzejb = view;
    }

    public void setMediaView(View view) {
        this.zzeiw = view;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzejf = f;
    }

    public final void zzn(Object obj) {
        this.zzejc = obj;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzejd = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzeje = z;
    }

    public final String getHeadline() {
        return this.zzeip;
    }

    public final List<Image> getImages() {
        return this.zzeiq;
    }

    public final String getBody() {
        return this.zzdko;
    }

    public final Image getIcon() {
        return this.zzeir;
    }

    public final String getCallToAction() {
        return this.zzeis;
    }

    public final String getAdvertiser() {
        return this.zzeiz;
    }

    public final Double getStarRating() {
        return this.zzeja;
    }

    public final String getStore() {
        return this.zzeiu;
    }

    public final String getPrice() {
        return this.zzeiv;
    }

    public final VideoController getVideoController() {
        return this.zzcen;
    }

    public boolean hasVideoContent() {
        return this.zzeix;
    }

    public View getAdChoicesContent() {
        return this.zzejb;
    }

    public final View zzaba() {
        return this.zzeiw;
    }

    public float getMediaContentAspectRatio() {
        return this.zzejf;
    }

    public final Object zzji() {
        return this.zzejc;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzejd;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzeje;
    }
}
