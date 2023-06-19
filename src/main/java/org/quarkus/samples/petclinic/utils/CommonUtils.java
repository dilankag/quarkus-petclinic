package org.quarkus.samples.petclinic.utils;

import java.util.Base64;
import java.util.Random;

public class CommonUtils {

    /**
     * We can strengthen the encoding algorithm using a strong cypher.
     * We follow Base64 basic encoding method here.
     */
    public static String encodeWithBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    /**
     * We can strengthen the OTP generating algorithm using an advanced strategy.
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
