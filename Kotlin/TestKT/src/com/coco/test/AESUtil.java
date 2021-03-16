package com.coco.test;




import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @version V1.0
 * @desc AES 加密工具类
 */
public class AESUtil {


    /**
     * @author: 秋刀
     * @Date: 2021/1/18 14:02
     * @Description: 密钥
     */
    private static String password = "abcdefg123456789";

    /**
     * AES加密
     *
     * @param text    要加密的数据
     * @param token   约定密串
     * @param charset 原数据字符集
     * @return 加密后的密文
     */
    private static String toAES(String text, String token, String charset) {
        if (token.length() % 16 != 0) {
            throw new RuntimeException("the key size not 16");
        }
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(token.getBytes(), "AES"));
            byte[] tempBts = cipher.doFinal(charset == null ? text.getBytes() : text.getBytes(charset));
            return base64Encode(tempBts).replace("\r", "").replace("\n", "");
        } catch (Exception e) {
            throw new RuntimeException("encryption or Decrypt exception", e);
        }
    }

    /**
     * AES加密
     *
     * @param text  要加密的数据
     * @return 加密后的密文
     */
    public static String AESEncode(String text) {
        return toAES(text, password, "utf-8");
    }

    /**
     * AES加密
     *
     * @param text    要加密的数据
     * @param token   约定密串
     * @param charset 字符集
     * @return 加密后的密文
     */
    public static String AESEncode(String text, String token, String charset) {
        return toAES(text, token, charset);
    }

    /**
     * AES解密
     *
     * @param text    要加密的数据
     * @param token   约定密串
     * @param charset 原数据字符集
     * @return 解密后的原文
     */
    private static String AESToString(String text, String token, String charset) {
        if (token.length() % 16 != 0) {
            throw new RuntimeException("the key size not 16");
        }
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(token.getBytes(), "AES"));
            byte[] bts = cipher.doFinal(base64ToByte(text));
            return charset == null ? new String(bts) : new String(bts, charset);
        } catch (Exception e) {
            throw new RuntimeException("encryption or Decrypt exception", e);
        }
    }

    /**
     * AES解密
     *
     * @param text  要加密的数据
     * @return 解密后的原文
     */
    public static String AESDecode(String text) {
        return AESToString(text, password, "utf-8");
    }

    /**
     * AES解密
     *
     * @param text    要加密的数据
     * @param token   约定密串
     * @param charset 原数据字符集
     * @return 解密后的原文
     */
    public static String AESDecode(String text, String token, String charset) {
        return AESToString(text, token, charset);
    }


    /**
     * 将base64字符串处理成String字节<br/>
     *
     * @param str base64的字符串
     * @return 原字节数据
     * @throws IOException
     */
    public static byte[] base64ToByte(String str) {
        try {
            if (str == null) {
                return null;
            }
            return Base64.getDecoder().decode(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将base64字符串处理成String<br/>
     * (用默认的String编码集)
     *
     * @param str base64的字符串
     * @return 可显示的字符串
     * @throws IOException
     */
    public static String base64Decode(String str) {
        try {
            if (str == null) {
                return null;
            }
            return new String(base64ToByte(str), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将base64字符串处理成String<br/>
     * (用默认的String编码集)
     *
     * @param str     base64的字符串
     * @param charset 编码格式(UTF-8/GBK)
     * @return 可显示的字符串
     * @throws IOException
     */
    public static String base64Decode(String str, String charset) {
        try {
            if (str == null) {
                return null;
            }
            return new String(base64ToByte(str), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将字节数据处理成base64字符串<br/>
     *
     * @param bts 字节数据
     * @return base64编码后的字符串(用于传输)
     * @throws IOException
     */
    public static String base64Encode(byte[] bts) {
        if (bts == null || bts.length == 0) {
            return null;
        }
        String base64Str = Base64.getEncoder().encodeToString(bts);
        base64Str = base64Str.replace("\r", "").replace("\n", "");
        return base64Str;
    }

    /**
     * 将String处理成base64字符串<br/>
     * (用默认的String编码集) @param oldStr 原字符串 @return base64编码后的字符串(用于传输) @throws
     */
    public static String base64Encode(String oldStr) {
        if (oldStr == null) {
            return null;
        }
        try {
            byte[] bts = oldStr.getBytes("UTF-8");
            String base64Str = Base64.getEncoder().encodeToString(bts);
            base64Str = base64Str.replace("\r", "").replace("\n", "");
            return base64Str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将String处理成base64字符串<br/>
     * (用默认的String编码集)
     *
     * @param oldStr 原字符串
     * @return base64编码后的字符串(用于传输)
     * @throws UnsupportedEncodingException
     */
    public static String base64Encode(String oldStr, String charset) {
        try {
            if (oldStr == null) {
                return null;
            }
            byte[] bts = oldStr.getBytes(charset);
            return Base64.getEncoder().encodeToString(bts);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


        String s = "123456";

        String encrypt = AESEncode(s);


        System.out.println(encrypt);


        String decrypt = AESDecode("t5/QzLIaET6Grt6u9r0UUjUohU4sCaEUubuA12BtNMNQ+KmH158j0twG4bfmoC4M0OFaebR00c+qt88mYvOew188hWyPByf0Yh0wzee0NtivdyPKD55jlccQEfQFDHBnlTFMCLFECqFaJs0TMvq/l0Aphlw5bkTZSHPJKlTzKn4hXO71mhA9WpN5DLXvdDx/");


        System.out.println(decrypt);
    }


}
