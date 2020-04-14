package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzaxi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class MediationServerParameters {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
    public @interface Parameter {
        String name();

        boolean required() default true;
    }

    public void load(Map<String, String> map) throws MappingException {
        Field[] fields;
        String str = "Server option \"";
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzaxi.zzeu("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException unused) {
                    String str2 = (String) entry.getKey();
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 49);
                    sb.append(str);
                    sb.append(str2);
                    sb.append("\" could not be set: Illegal Access");
                    zzaxi.zzeu(sb.toString());
                } catch (IllegalArgumentException unused2) {
                    String str3 = (String) entry.getKey();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 43);
                    sb2.append(str);
                    sb2.append(str3);
                    sb2.append("\" could not be set: Bad Type");
                    zzaxi.zzeu(sb2.toString());
                }
            } else {
                String str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str4).length() + 31 + String.valueOf(str5).length());
                sb3.append("Unexpected server option: ");
                sb3.append(str4);
                sb3.append(" = \"");
                sb3.append(str5);
                sb3.append("\"");
                zzaxi.zzdv(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                String str6 = "Required server option missing: ";
                String valueOf = String.valueOf(((Parameter) field3.getAnnotation(Parameter.class)).name());
                zzaxi.zzeu(valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
                if (sb4.length() > 0) {
                    sb4.append(", ");
                }
                sb4.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (sb4.length() > 0) {
            String str7 = "Required server option(s) missing: ";
            String valueOf2 = String.valueOf(sb4.toString());
            throw new MappingException(valueOf2.length() != 0 ? str7.concat(valueOf2) : new String(str7));
        }
    }
}
