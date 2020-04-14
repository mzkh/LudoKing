package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.utils.r */
public class C1284r {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1227o f3230a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Stack<C1286a> f3231b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StringBuilder f3232c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f3233d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1286a f3234e;

    /* renamed from: com.applovin.impl.sdk.utils.r$a */
    private static class C1286a extends C1283q {
        C1286a(String str, Map<String, String> map, C1283q qVar) {
            super(str, map, qVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo10467a(C1283q qVar) {
            if (qVar != null) {
                this.f3226c.add(qVar);
                return;
            }
            throw new IllegalArgumentException("None specified.");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo10468d(String str) {
            this.f3225b = str;
        }
    }

    C1284r(C1192i iVar) {
        if (iVar != null) {
            this.f3230a = iVar.mo10249v();
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    public static C1283q m3130a(String str, C1192i iVar) throws SAXException {
        return new C1284r(iVar).mo10455a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m3133a(Attributes attributes) {
        if (attributes == null) {
            return Collections.emptyMap();
        }
        int length = attributes.getLength();
        HashMap hashMap = new HashMap(length);
        for (int i = 0; i < length; i++) {
            hashMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public C1283q mo10455a(String str) throws SAXException {
        if (str != null) {
            this.f3232c = new StringBuilder();
            this.f3231b = new Stack<>();
            this.f3234e = null;
            Xml.parse(str, new ContentHandler() {
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (C1277l.m3042b(trim)) {
                        C1284r.this.f3232c.append(trim);
                    }
                }

                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - C1284r.this.f3233d;
                    C1227o a = C1284r.this.f3230a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Finished parsing in ");
                    sb.append(seconds);
                    sb.append(" seconds");
                    a.mo10378b("XmlParser", sb.toString());
                }

                public void endElement(String str, String str2, String str3) {
                    C1284r rVar = C1284r.this;
                    rVar.f3234e = (C1286a) rVar.f3231b.pop();
                    C1284r.this.f3234e.mo10468d(C1284r.this.f3232c.toString().trim());
                    C1284r.this.f3232c.setLength(0);
                }

                public void endPrefixMapping(String str) {
                }

                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                public void processingInstruction(String str, String str2) {
                }

                public void setDocumentLocator(Locator locator) {
                }

                public void skippedEntity(String str) {
                }

                public void startDocument() {
                    C1284r.this.f3230a.mo10378b("XmlParser", "Begin parsing...");
                    C1284r.this.f3233d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
                    C1286a aVar = null;
                    try {
                        if (!C1284r.this.f3231b.isEmpty()) {
                            aVar = (C1286a) C1284r.this.f3231b.peek();
                        }
                        C1286a aVar2 = new C1286a(str2, C1284r.this.m3133a(attributes), aVar);
                        if (aVar != null) {
                            aVar.mo10467a(aVar2);
                        }
                        C1284r.this.f3231b.push(aVar2);
                    } catch (Exception e) {
                        C1227o a = C1284r.this.f3230a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to process element <");
                        sb.append(str2);
                        sb.append(">");
                        a.mo10379b("XmlParser", sb.toString(), e);
                        throw new SAXException("Failed to start element", e);
                    }
                }

                public void startPrefixMapping(String str, String str2) {
                }
            });
            C1286a aVar = this.f3234e;
            if (aVar != null) {
                return aVar;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
