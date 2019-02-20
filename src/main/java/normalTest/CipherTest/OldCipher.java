package normalTest.CipherTest;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.GeneralSecurityException;

/**
 * Created by jialei.zou on 2018/9/3 .
 */
public class OldCipher {

    /**
     * 加密
     */
    private Cipher encryptCipher;

    /**
     * 解密
     */
    private Cipher decryptCipher;

    /**
     * KeyFactory
     */
    private SecretKeyFactory keyFactory;

    public OldCipher() {
        try {
            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            keyFactory = SecretKeyFactory.getInstance("DES");
        } catch (GeneralSecurityException ex) {
            ex.printStackTrace();
        }

        init("CreditCloudRock!");
    }

    public void init(String salt) {
        try {
            SecretKey sk = keyFactory.generateSecret(new DESKeySpec(salt.getBytes()));
            encryptCipher.init(Cipher.ENCRYPT_MODE, sk);
            decryptCipher.init(Cipher.DECRYPT_MODE, sk);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String encrypt(String value) throws GeneralSecurityException {
        return new String(Base64.encodeBase64(encryptCipher.doFinal(value.getBytes())));
    }

    public String decrypt(String value) throws GeneralSecurityException {
        return new String(decryptCipher.doFinal(Base64.decodeBase64(value.getBytes())));
    }

    public static void main(String[] args) throws GeneralSecurityException {
        long start = System.currentTimeMillis();
        OldCipher cipher = new OldCipher();
        System.out.println(cipher.encrypt("610326198707031813"));
        OldCipher cipher1 = new OldCipher();
        System.out.println(cipher1.encrypt("310112197208240018"));
        OldCipher cipher2 = new OldCipher();
        System.out.println(cipher2.encrypt("430781198406294014"));
        OldCipher cipher3 = new OldCipher();
        System.out.println(cipher3.encrypt("142703198803052717"));
        OldCipher cipher4 = new OldCipher();
        System.out.println(cipher4.encrypt("6217001860005459029"));
        OldCipher cipher5 = new OldCipher();
        System.out.println(cipher5.encrypt("张红泽"));
        System.out.println(cipher.decrypt("7c6ZT/i6kdfGjtc8Qts39Q=="));
        System.out.println(cipher.decrypt("2H185x1/zxBJqHod401fQA=="));
        System.out.println(cipher.decrypt("cNTi8oMY1KKke/wLfDc6cMRCletQhexL"));
        System.out.println(cipher.decrypt("Yp4S+0aNAYGsXhowWVpaIghXFEIKwmNr"));
        long end = System.currentTimeMillis();
        System.out.println("cost=" + (end-start));



    }
}
