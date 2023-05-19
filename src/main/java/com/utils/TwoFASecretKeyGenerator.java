package com.utils;

import org.jboss.aerogear.security.otp.Totp;

public class TwoFASecretKeyGenerator {

        public static String getTwoFactorCode(){
        /*2FA secret key*/
        Totp totp = new Totp("res4b6mujp2zfkr2eckw7nvc2v2bxkdq");
        /*Generated 2FA code here*/
        String twoFactorCode = totp.now();
        return twoFactorCode;
    }

}
