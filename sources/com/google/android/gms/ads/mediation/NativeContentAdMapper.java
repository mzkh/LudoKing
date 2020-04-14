package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzdko;
    private String zzeip;
    private List<Image> zzeiq;
    private String zzeis;
    private Image zzeiy;
    private String zzeiz;

    public final void setHeadline(String str) {
        this.zzeip = str;
    }

    public final void setImages(List<Image> list) {
        this.zzeiq = list;
    }

    public final void setBody(String str) {
        this.zzdko = str;
    }

    public final void setLogo(Image image) {
        this.zzeiy = image;
    }

    public final void setCallToAction(String str) {
        this.zzeis = str;
    }

    public final void setAdvertiser(String str) {
        this.zzeiz = str;
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

    public final Image getLogo() {
        return this.zzeiy;
    }

    public final String getCallToAction() {
        return this.zzeis;
    }

    public final String getAdvertiser() {
        return this.zzeiz;
    }
}
