package com.rgt.utils;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;



public class CommonUntils {
	private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private static Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    static SecretKey key;
//   
//    public CommonUntils() throws Exception {
//        myEncryptionKey = "ThisIsSpartaThisIsSparta";
//        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
//        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
//        ks = new DESedeKeySpec(arrayBytes);
//        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
//        cipher = Cipher.getInstance(myEncryptionScheme);
//        key = skf.generateSecret(ks);
//    }
//	public String encrypt(String unencryptedString) {
//        String encryptedString = null;
//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
//            byte[] encryptedText = cipher.doFinal(plainText);
//            encryptedString = new String(Base64.encodeBase64(encryptedText));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedString;
//    }
//
//
//    public static String decrypt(String encryptedString) {
//        String decryptedText=null;
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString);
//            byte[] plainText = cipher.doFinal(encryptedText);
//            decryptedText= new String(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptedText;
//    }

	public static String decrypt(String strToDecrypt, String secKey) {
		
		String salt = "ssshhhhhhhhhhhh!!!!";
		try {
			byte[] iv = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			IvParameterSpec ivspec = new IvParameterSpec(iv);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secKey.toCharArray(),salt.getBytes(),65536,256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec sec = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, sec, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		}catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
}
