package com.anTools.common;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

/**
 * AES加解密算法
 */
public class Aes {

    public static String KEY_ALGORITHM = "AES";
    //避免重复new生成多个BouncyCastleProvider对象，因为GC回收不了，会造成内存溢出
    //只在第一次调用decrypt()方法时才new 对象
    public static boolean initialized = false;

    /**
     * AES加密
     */
    public byte[] encrypt(byte[] encryptKey, byte[] originalContent, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(ivByte));

            byte[] encrypted = cipher.doFinal(originalContent);
            return encrypted;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * AES解密
     */
    public String decrypt(String decryptKey, String encryptedData, String iv) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key secretKeySpec = new SecretKeySpec(Base64.decode(decryptKey), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, generateIv(Base64.decode(iv)));

            byte[] decrypted = cipher.doFinal(Base64.decode(encryptedData));
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**BouncyCastle作为安全提供，防止加密解密时候因为jdk内置的不支持改模式运行报错。*/
    public static void initialize() {
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**生成iv*/
    public static AlgorithmParameters generateIv(byte[] iv) throws Exception {
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES");
        algorithmParameters.init(new IvParameterSpec(iv));
        return algorithmParameters;
    }

    public JSONObject domain(String decryptKey, String encryptedData, String iv){
        JSONObject jsonObject = JSONObject.parseObject(decrypt(decryptKey, encryptedData, iv));
        return jsonObject;
    }

}
