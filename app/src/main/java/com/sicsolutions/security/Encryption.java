package com.sicsolutions.security;

import java.security.MessageDigest;

public class Encryption {

    public static byte [] encryptSHA(byte[] data, String shaN) throws Exception{

        MessageDigest sha = MessageDigest.getInstance((shaN));
        sha.update(data);
        return sha.digest();
    }
}
