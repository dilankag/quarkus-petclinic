package org.quarkus.samples.petclinic.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HexFormat;
import java.util.Random;

public class CommonUtils {

    /**
     * We can strengthen the encoding algorithm using a strong cipher (such as SHA256).
     * We follow Base64 basic encoding method here.
     */
    private static String encodeWithBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * We can strengthen the encoding algorithm using a much stronger cipher (such as SHA2-256 or SHA3-256).
     * We follow SHA-256 one-way encoding method here.
     */
    public static String encodeWithSHA256Hex(String value) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha256.digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder hash = new StringBuilder(2 * digest.length);
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(digest[i]);
                if (hex.length() == 1) {
                    hash.append('x');
                }
                hash.append(hex);
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return encodeWithBase64(value);
        }
    }

    /**
     * We can strengthen the OTP generating algorithm using an advanced strategy (such as user specific).
     * We generate OTP with randomised numbers here.
     */
    public static String generateOTP() {
        int SIZE = 6;
        String DIGITS = "0123456789";
        Random random = new Random();
        char[] OTP = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            OTP[i] = DIGITS.charAt(random.nextInt(DIGITS.length()));
        }
        return new String(OTP);
    }

}
