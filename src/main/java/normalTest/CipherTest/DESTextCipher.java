package normalTest.CipherTest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.GeneralSecurityException;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by jialei.zou on 2018/9/3 .
 */
public class DESTextCipher {
    /**
     * 加密
     */
    private static Cipher encryptCipher;

    /**
     * 解密
     */
    private static Cipher decryptCipher;

    /**
     * KeyFactory
     */
    private static SecretKeyFactory keyFactory;

    static  {
        try {
            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            keyFactory = SecretKeyFactory.getInstance("DES");
        } catch (GeneralSecurityException ex) {
            ex.printStackTrace();
        }

        init("CreditCloudRock!");
    }

    private static void init(String salt) {
        try {
            SecretKey sk = keyFactory.generateSecret(new DESKeySpec(salt.getBytes()));
            encryptCipher.init(Cipher.ENCRYPT_MODE, sk);
            decryptCipher.init(Cipher.DECRYPT_MODE, sk);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String encrypt(String value) throws GeneralSecurityException {
        return new String(Base64.encodeBase64(encryptCipher.doFinal(value.getBytes())));
    }

    public static String decrypt(String value) throws GeneralSecurityException {
        return new String(decryptCipher.doFinal(Base64.decodeBase64(value.getBytes())));
    }

    public static void main(String[] args) throws GeneralSecurityException {
        long start = System.currentTimeMillis();
        System.out.println(DESTextCipher.encrypt("610326198707031813"));
        long start1 = System.currentTimeMillis();
        System.out.println(DESTextCipher.encrypt("310112197208240018"));
        System.out.println(DESTextCipher.encrypt("430781198406294014"));
        System.out.println(DESTextCipher.encrypt("142703198803052717"));
        System.out.println(DESTextCipher.encrypt("6217001860005459029"));
        System.out.println(DESTextCipher.encrypt("张红泽"));
        System.out.println(DESTextCipher.decrypt("7c6ZT/i6kdfGjtc8Qts39Q=="));
        System.out.println(DESTextCipher.decrypt("QFWTWOi58OlbAwo03dtXvQ=="));
        System.out.println(DESTextCipher.decrypt("MYfWn1W8duTc+N96mUp4+HuPjihoaHw2"));
        System.out.println(DESTextCipher.decrypt("n+QbjPlV5WOuJAurT2xMEKMtgEMsfdd/"));
        long end = System.currentTimeMillis();
        System.out.println("cost1=" + (start1-start));
        System.out.println("cost=" + (end-start));


//       System.out.println(cipher.decrypt("7wFt1uczQc/9huuqhTIMLw=="));
//       System.out.println(cipher.decrypt("fHZbCmxA5MB7rcReEEVQCg=="));
    }
}
