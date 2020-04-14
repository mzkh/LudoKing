package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdko;
    private String zzeip;
    private List<Image> zzeiq;
    private Image zzeir;
    private String zzeis;
    private double zzeit;
    private String zzeiu;
    private String zzeiv;

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

    public final void setStarRating(double d) {
        this.zzeit = d;
    }

    public final void setStore(String str) {
        this.zzeiu = str;
    }

    public final void setPrice(String str) {
        this.zzeiv = str;
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

    public final double getStarRating() {
        return this.zzeit;
    }

    public final String getStore() {
        return this.zzeiu;
    }

    public final String getPrice() {
        return this.zzeiv;
    }
}
