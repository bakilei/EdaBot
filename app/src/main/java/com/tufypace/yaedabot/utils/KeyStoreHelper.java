package com.tufypace.yaedabot.utils;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

public class KeyStoreHelper {
    private static final String ALIAS = "CourierAlias";
    private static final String BLOCKING_MODE = "ECB";
    public static final Companion Companion = new Companion();
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String TYPE_ALGORITHM = "RSA";
    private static final String TYPE_PADDING = "PKCS1Padding";
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public Companion(Companion companion) {
            this();
        }
    }

    public KeyStoreHelper(Context context) {
        this.context = context;
    }

    private final void generateKeyPair() throws Exception {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.add(1, 10);
        KeyPairGeneratorSpec.Builder serialNumber = new KeyPairGeneratorSpec.Builder(this.context).setAlias("CourierAlias").setKeySize(2048).setSubject(new X500Principal("CN=CourierAlias")).setSerialNumber(BigInteger.ONE);
        Intrinsics.areEqual((Object) instance, "start");
        KeyPairGeneratorSpec.Builder startDate = serialNumber.setStartDate(instance.getTime());
        Intrinsics.areEqual((Object) instance2, "end");
        KeyPairGeneratorSpec build = startDate.setEndDate(instance2.getTime()).build();
        KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        instance3.initialize(build);
        instance3.generateKeyPair();
    }

    public final String decrypt(String str) throws Exception {
        Intrinsics.areEqual(str, "input");
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        Key key = instance.getKey("CourierAlias", (char[]) null);
        if (key != null) {
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(2, (PrivateKey) key);
            byte[] doFinal = instance2.doFinal(Base64.decode(str, 2));
            Intrinsics.areEqual((Object) doFinal, "bytes");
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.areEqual((Object) charset, "StandardCharsets.UTF_8");
            return new String(doFinal, charset);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.security.PrivateKey");
    }

    public final String encrypt(String str) throws Exception {
        Intrinsics.areEqual(str, "input");
        if (!(str.length() == 0)) {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            if (!instance.containsAlias("CourierAlias")) {
                generateKeyPair();
            }
            Certificate certificate = instance.getCertificate("CourierAlias");
            Intrinsics.areEqual((Object) certificate, "keyStore.getCertificate(ALIAS)");
            PublicKey publicKey = certificate.getPublicKey();
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(1, publicKey);
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.areEqual((Object) charset, "StandardCharsets.UTF_8");
            Intrinsics.areEqual((Object) charset, "StandardCharsets.UTF_8");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.areEqual((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(instance2.doFinal(bytes), 2);
            Intrinsics.areEqual((Object) encodeToString, "Base64.encodeToString(en…tedBytes, Base64.NO_WRAP)");
            return encodeToString;
        }
        throw new Exception("input must not be empty");
    }
}
