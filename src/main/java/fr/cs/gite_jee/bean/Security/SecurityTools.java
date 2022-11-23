package fr.cs.gite_jee.bean.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecurityTools {
    private static String algorithm = "AES";
    private static String key = "TheVerySecretK3Y";

    public static String encrypt(String data) {

        byte[] dataToSend = data.getBytes();
        Cipher c = null;
        try {
            c = Cipher.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), algorithm);
        try {
            c.init(Cipher.ENCRYPT_MODE, k);
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] encryptedData = "".getBytes();
        try {
            encryptedData = c.doFinal(dataToSend);
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] encryptedByteValue = Base64.getUrlEncoder().encode(encryptedData);
        return new String(encryptedByteValue);
    }

    public static String decrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        byte[] encryptedData = Base64.getUrlDecoder().decode(data); //Base64.getDecoder().decode(data);
        Cipher c = null;
        c = Cipher.getInstance(algorithm);
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), algorithm);
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] decrypted = null;
        decrypted = c.doFinal(encryptedData);
        return new String(decrypted);
    }

    public static Long checksum(String string) {
        long checksum = 0;
        for (int i = 0; i < string.length(); i++) {
            checksum += i * string.charAt(i);
        }
        return checksum;
    }
}
