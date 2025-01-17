package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import com.facebook.internal.CollectionMapper.ValueMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode = DEFAULT_GRAPH_NODE;
    private String message;
    private final ShareContent shareContent;

    public static void share(ShareContent shareContent2, FacebookCallback<Result> facebookCallback) {
        new ShareApi(shareContent2).share(facebookCallback);
    }

    public ShareApi(ShareContent shareContent2) {
        this.shareContent = shareContent2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getGraphNode() {
        return this.graphNode;
    }

    public void setGraphNode(String str) {
        this.graphNode = str;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public boolean canShare() {
        if (getShareContent() == null) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            return false;
        }
        Set permissions = currentAccessToken.getPermissions();
        if (permissions == null || !permissions.contains("publish_actions")) {
            Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
        }
        return true;
    }

    public void share(FacebookCallback<Result> facebookCallback) {
        if (!canShare()) {
            ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
            return;
        }
        ShareContent shareContent2 = getShareContent();
        try {
            ShareContentValidation.validateForApiShare(shareContent2);
            if (shareContent2 instanceof ShareLinkContent) {
                shareLinkContent((ShareLinkContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof SharePhotoContent) {
                sharePhotoContent((SharePhotoContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof ShareVideoContent) {
                shareVideoContent((ShareVideoContent) shareContent2, facebookCallback);
            } else if (shareContent2 instanceof ShareOpenGraphContent) {
                shareOpenGraphContent((ShareOpenGraphContent) shareContent2, facebookCallback);
            }
        } catch (FacebookException e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    /* access modifiers changed from: private */
    public String getGraphPath(String str) {
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, new Object[]{URLEncoder.encode(getGraphNode(), DEFAULT_CHARSET), str});
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent2) {
        List peopleIds = shareContent2.getPeopleIds();
        if (!Utility.isNullOrEmpty((Collection<T>) peopleIds)) {
            bundle.putString("tags", TextUtils.join(", ", peopleIds));
        }
        if (!Utility.isNullOrEmpty(shareContent2.getPlaceId())) {
            bundle.putString("place", shareContent2.getPlaceId());
        }
        if (!Utility.isNullOrEmpty(shareContent2.getPageId())) {
            bundle.putString("page", shareContent2.getPageId());
        }
        if (!Utility.isNullOrEmpty(shareContent2.getRef())) {
            bundle.putString("ref", shareContent2.getRef());
        }
    }

    private void shareOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, final FacebookCallback<Result> facebookCallback) {
        final C16111 r4 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                String str;
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(facebookCallback, str, graphResponse);
            }
        };
        final ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        Bundle bundle = action.getBundle();
        addCommonParameters(bundle, shareOpenGraphContent);
        if (!Utility.isNullOrEmpty(getMessage())) {
            bundle.putString("message", getMessage());
        }
        final Bundle bundle2 = bundle;
        final FacebookCallback<Result> facebookCallback2 = facebookCallback;
        C16152 r0 = new OnMapperCompleteListener() {
            public void onComplete() {
                try {
                    ShareApi.handleImagesOnAction(bundle2);
                    GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.this.getGraphPath(URLEncoder.encode(action.getActionType(), ShareApi.DEFAULT_CHARSET)), bundle2, HttpMethod.POST, r4);
                    graphRequest.executeAsync();
                } catch (UnsupportedEncodingException e) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e);
                }
            }

            public void onError(FacebookException facebookException) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback2, facebookException);
            }
        };
        stageOpenGraphAction(bundle, r0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        putImageInBundleWithArrayFormat(r10, 0, new org.json.JSONObject(r1));
        r10.remove(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void handleImagesOnAction(android.os.Bundle r10) {
        /*
            java.lang.String r0 = "image"
            java.lang.String r1 = r10.getString(r0)
            if (r1 == 0) goto L_0x0049
            r2 = 0
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x003e }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x003e }
            r4 = 0
        L_0x000f:
            int r5 = r3.length()     // Catch:{ JSONException -> 0x003e }
            if (r4 >= r5) goto L_0x003a
            org.json.JSONObject r5 = r3.optJSONObject(r4)     // Catch:{ JSONException -> 0x003e }
            if (r5 == 0) goto L_0x001f
            putImageInBundleWithArrayFormat(r10, r4, r5)     // Catch:{ JSONException -> 0x003e }
            goto L_0x0037
        L_0x001f:
            java.lang.String r5 = r3.getString(r4)     // Catch:{ JSONException -> 0x003e }
            java.util.Locale r6 = java.util.Locale.ROOT     // Catch:{ JSONException -> 0x003e }
            java.lang.String r7 = "image[%d][url]"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ JSONException -> 0x003e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)     // Catch:{ JSONException -> 0x003e }
            r8[r2] = r9     // Catch:{ JSONException -> 0x003e }
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch:{ JSONException -> 0x003e }
            r10.putString(r6, r5)     // Catch:{ JSONException -> 0x003e }
        L_0x0037:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x003a:
            r10.remove(r0)     // Catch:{ JSONException -> 0x003e }
            return
        L_0x003e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0049 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x0049 }
            putImageInBundleWithArrayFormat(r10, r2, r3)     // Catch:{ JSONException -> 0x0049 }
            r10.remove(r0)     // Catch:{ JSONException -> 0x0049 }
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.ShareApi.handleImagesOnAction(android.os.Bundle):void");
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", new Object[]{Integer.valueOf(i), str}), jSONObject.get(str).toString());
        }
    }

    private void sharePhotoContent(SharePhotoContent sharePhotoContent, FacebookCallback<Result> facebookCallback) {
        ArrayList arrayList;
        FacebookCallback<Result> facebookCallback2 = facebookCallback;
        Mutable mutable = new Mutable(Integer.valueOf(0));
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final Mutable mutable2 = mutable;
        final FacebookCallback<Result> facebookCallback3 = facebookCallback;
        C16163 r1 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject != null) {
                    arrayList3.add(jSONObject);
                }
                if (graphResponse.getError() != null) {
                    arrayList4.add(graphResponse);
                }
                Mutable mutable = mutable2;
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() - 1);
                if (((Integer) mutable2.value).intValue() != 0) {
                    return;
                }
                if (!arrayList4.isEmpty()) {
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback3, null, (GraphResponse) arrayList4.get(0));
                } else if (!arrayList3.isEmpty()) {
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback3, ((JSONObject) arrayList3.get(0)).optString("id"), graphResponse);
                }
            }
        };
        try {
            for (SharePhoto sharePhoto : sharePhotoContent.getPhotos()) {
                try {
                    Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(sharePhoto, sharePhotoContent);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    Uri imageUrl = sharePhoto.getImageUrl();
                    String caption = sharePhoto.getCaption();
                    if (caption == null) {
                        caption = getMessage();
                    }
                    String str = caption;
                    String str2 = PHOTOS_EDGE;
                    if (bitmap != null) {
                        arrayList = arrayList2;
                        arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(str2), bitmap, str, sharePhotoCommonParameters, (Callback) r1));
                    } else {
                        arrayList = arrayList2;
                        if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(str2), imageUrl, str, sharePhotoCommonParameters, (Callback) r1));
                        }
                    }
                    arrayList2 = arrayList;
                } catch (JSONException e) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e);
                    return;
                }
            }
            ArrayList arrayList5 = arrayList2;
            mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList5.size());
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).executeAsync();
            }
        } catch (FileNotFoundException e2) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback2, e2);
        }
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, final FacebookCallback<Result> facebookCallback) {
        C16174 r5 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                String str;
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    str = null;
                } else {
                    str = jSONObject.optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(facebookCallback, str, graphResponse);
            }
        };
        Bundle bundle = new Bundle();
        addCommonParameters(bundle, shareLinkContent);
        bundle.putString("message", getMessage());
        bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
        bundle.putString("picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        bundle.putString("name", shareLinkContent.getContentTitle());
        bundle.putString("description", shareLinkContent.getContentDescription());
        bundle.putString("ref", shareLinkContent.getRef());
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, r5);
        graphRequest.executeAsync();
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Result> facebookCallback) {
        try {
            VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
        } catch (FileNotFoundException e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        Bundle parameters = sharePhoto.getParameters();
        String str = "place";
        if (!parameters.containsKey(str) && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
            parameters.putString(str, sharePhotoContent.getPlaceId());
        }
        String str2 = "tags";
        if (!parameters.containsKey(str2) && !Utility.isNullOrEmpty((Collection<T>) sharePhotoContent.getPeopleIds())) {
            List<String> peopleIds = sharePhotoContent.getPeopleIds();
            if (!Utility.isNullOrEmpty((Collection<T>) peopleIds)) {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : peopleIds) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("tag_uid", str3);
                    jSONArray.put(jSONObject);
                }
                parameters.putString(str2, jSONArray.toString());
            }
        }
        String str4 = "ref";
        if (!parameters.containsKey(str4) && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
            parameters.putString(str4, sharePhotoContent.getRef());
        }
        return parameters;
    }

    /* access modifiers changed from: private */
    public void stageArrayList(final ArrayList arrayList, final OnMapValueCompleteListener onMapValueCompleteListener) {
        final JSONArray jSONArray = new JSONArray();
        stageCollectionValues(new CollectionMapper.Collection<Integer>() {
            public Iterator<Integer> keyIterator() {
                final int size = arrayList.size();
                final Mutable mutable = new Mutable(Integer.valueOf(0));
                return new Iterator<Integer>() {
                    public void remove() {
                    }

                    public boolean hasNext() {
                        return ((Integer) mutable.value).intValue() < size;
                    }

                    public Integer next() {
                        Integer num = (Integer) mutable.value;
                        Mutable mutable = mutable;
                        mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + 1);
                        return num;
                    }
                };
            }

            public Object get(Integer num) {
                return arrayList.get(num.intValue());
            }

            public void set(Integer num, Object obj, OnErrorListener onErrorListener) {
                try {
                    jSONArray.put(num.intValue(), obj);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging object.";
                    }
                    onErrorListener.onError(new FacebookException(localizedMessage));
                }
            }
        }, new OnMapperCompleteListener() {
            public void onComplete() {
                onMapValueCompleteListener.onComplete(jSONArray);
            }

            public void onError(FacebookException facebookException) {
                onMapValueCompleteListener.onError(facebookException);
            }
        });
    }

    private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, OnMapperCompleteListener onMapperCompleteListener) {
        CollectionMapper.iterate(collection, new ValueMapper() {
            public void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener) {
                if (obj instanceof ArrayList) {
                    ShareApi.this.stageArrayList((ArrayList) obj, onMapValueCompleteListener);
                } else if (obj instanceof ShareOpenGraphObject) {
                    ShareApi.this.stageOpenGraphObject((ShareOpenGraphObject) obj, onMapValueCompleteListener);
                } else if (obj instanceof SharePhoto) {
                    ShareApi.this.stagePhoto((SharePhoto) obj, onMapValueCompleteListener);
                } else {
                    onMapValueCompleteListener.onComplete(obj);
                }
            }
        }, onMapperCompleteListener);
    }

    private void stageOpenGraphAction(final Bundle bundle, OnMapperCompleteListener onMapperCompleteListener) {
        stageCollectionValues(new CollectionMapper.Collection<String>() {
            public Iterator<String> keyIterator() {
                return bundle.keySet().iterator();
            }

            public Object get(String str) {
                return bundle.get(str);
            }

            public void set(String str, Object obj, OnErrorListener onErrorListener) {
                if (!Utility.putJSONValueInBundle(bundle, str, obj)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected value: ");
                    sb.append(obj.toString());
                    onErrorListener.onError(new FacebookException(sb.toString()));
                }
            }
        }, onMapperCompleteListener);
    }

    /* access modifiers changed from: private */
    public void stageOpenGraphObject(final ShareOpenGraphObject shareOpenGraphObject, final OnMapValueCompleteListener onMapValueCompleteListener) {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        final String str = string;
        if (str == null) {
            onMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        C16239 r0 = new CollectionMapper.Collection<String>() {
            public Iterator<String> keyIterator() {
                return shareOpenGraphObject.keySet().iterator();
            }

            public Object get(String str) {
                return shareOpenGraphObject.get(str);
            }

            public void set(String str, Object obj, OnErrorListener onErrorListener) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging object.";
                    }
                    onErrorListener.onError(new FacebookException(localizedMessage));
                }
            }
        };
        final C161210 r5 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                String str = "Error staging Open Graph object.";
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = str;
                    }
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, str));
                    return;
                }
                String optString = jSONObject.optString("id");
                if (optString == null) {
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, str));
                } else {
                    onMapValueCompleteListener.onComplete(optString);
                }
            }
        };
        final OnMapValueCompleteListener onMapValueCompleteListener2 = onMapValueCompleteListener;
        C161311 r1 = new OnMapperCompleteListener() {
            public void onComplete() {
                String jSONObject = jSONObject.toString();
                Bundle bundle = new Bundle();
                bundle.putString("object", jSONObject);
                try {
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    ShareApi shareApi = ShareApi.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("objects/");
                    sb.append(URLEncoder.encode(str, ShareApi.DEFAULT_CHARSET));
                    GraphRequest graphRequest = new GraphRequest(currentAccessToken, shareApi.getGraphPath(sb.toString()), bundle, HttpMethod.POST, r5);
                    graphRequest.executeAsync();
                } catch (UnsupportedEncodingException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Error staging Open Graph object.";
                    }
                    onMapValueCompleteListener2.onError(new FacebookException(localizedMessage));
                }
            }

            public void onError(FacebookException facebookException) {
                onMapValueCompleteListener2.onError(facebookException);
            }
        };
        stageCollectionValues(r0, r1);
    }

    /* access modifiers changed from: private */
    public void stagePhoto(final SharePhoto sharePhoto, final OnMapValueCompleteListener onMapValueCompleteListener) {
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
            return;
        }
        C161412 r2 = new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                String str = "Error staging photo.";
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = str;
                    }
                    onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    onMapValueCompleteListener.onError(new FacebookException(str));
                    return;
                }
                String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
                if (optString == null) {
                    onMapValueCompleteListener.onError(new FacebookException(str));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("url", optString);
                    jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, sharePhoto.getUserGenerated());
                    onMapValueCompleteListener.onComplete(jSONObject2);
                } catch (JSONException e) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = str;
                    }
                    onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
                }
            }
        };
        if (bitmap != null) {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, (Callback) r2).executeAsync();
            return;
        }
        try {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, (Callback) r2).executeAsync();
        } catch (FileNotFoundException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
        }
    }
}
