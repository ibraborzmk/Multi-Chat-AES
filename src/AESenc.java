import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESenc {

    private static final String ALGO = "AES";
    private static final int KEY_SIZE = 256;

    public static byte[] encrypt(String message, SecretKey key) throws Exception {
        try {
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            return c.doFinal(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(byte[] encryptedData, SecretKey key) throws Exception {
        try {
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decValue = c.doFinal(encryptedData);
            return new String(decValue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
        keyGen.init(KEY_SIZE);
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            SecretKey key = generateKey();

            String originalData = "Hello, World!";
            byte[] encryptedData = encrypt(originalData, key);

            System.out.println("Encrypted data: " + new String(encryptedData));

            String decryptedData = decrypt(encryptedData, key);
            System.out.println("Decrypted data: " + new String(decryptedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
