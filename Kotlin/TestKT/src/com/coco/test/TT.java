package com.coco.test;

import com.sun.tools.javac.util.ArrayUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TT {

//        //加密序号
//        public static int orderId;
//
//        //加密
//        public static byte[] encrypt(byte[] data, byte[] key){
//            try {
//                if (null == key) {
//                    return null;
//                }
//                byte[] raw = key;
//                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
//                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//                return cipher.doFinal(data);
//            } catch (Exception ex) {
//                return null;
//            }
//        }
//
//        //加密
//        public static byte[] encryptdata(byte[] sSrc, byte[] sKey){
//            orderId++;
//            if (orderId>=255){
//                orderId=1;
//            }
////        //如果自定义配置了固定的加密序号，则使用配置项
////        if(CustomConfig.getEncryptNumber() > 0){
////            orderId = CustomConfig.getEncryptNumber();
////        }
//
//            String toHexStr = String.format("%02X",orderId)+RadixTools.bytesToHexStr(sSrc);
//            sSrc=RadixTools.hexStringToBytes(toHexStr);
//            byte[] bytes1 = RadixTools.unsignedShortToByte(Builder.CRC_XModem(sSrc), false);
//            toHexStr = RadixTools.bytesToHexStr(sSrc) + RadixTools.bytesToHexStr(ArrayUtils.reverse(bytes1));
//            sSrc=RadixTools.hexStringToBytes(toHexStr);
//            try{
//                SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
//                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//                byte[] encrypted = cipher.doFinal(sSrc);
//                return encrypted;
//            }catch(Exception ex){
//                return null;
//            }
//        }
//
//        //解密
//        public static byte[] decryptdata(byte[] bytes, byte[] sKey){
//            try{
//                SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
//                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//                byte[] dncrypted = cipher.doFinal(bytes);
//                return dncrypted;
//            }catch(Exception ex){
//                return null;
//            }
//        }
//
//        //解密
//        public static byte[] decrypt(byte[] sSrc, byte[] sKey){
//            try{
//                SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
//                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//                cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//                byte[] dncrypted = cipher.doFinal(sSrc);
//                return dncrypted;
//            }catch(Exception ex){
//                return null;
//            }
//        }

        public static void main(String[] args) {
//            byte[] encrypt = AesUtils.encrypt(RadixTools.hexStringToBytes("01F353CD328F60B193C446940D0D61F2"), RadixTools.hexStringToBytes("766965777368696E652E636E00000000"));
//            byte[] decrypt = AesUtils.decrypt(RadixTools.hexStringToBytes("50C01C9B08E8BD7EB10D52730FD91123"), RadixTools.hexStringToBytes("01F353CD328F60B193C446940D0D61F2"));
//            // 68997706800134000AA23200502000 78A90853DCD0213086E4DA73364EABD786F067CC9B2867375CF38470430CCDEB A0BE16
////0000 00 080200040e0115 b8b8
//            System.out.println(RadixTools.bytesToHexStr(encrypt));
//            System.out.println(RadixTools.bytesToHexStr(decrypt));

         DidType[] values = DidType.values();
         int a = 0;
        for (DidType type : values) {

//
            System.out.println("var config"+a+" = CommandViewConfig(did = \""+type.getDid()+"\",writeKey = \"aa\"," +
                    "secret = true,title=\""+type+"\" , write="+type.getWrite()+" ,read="+type.getRead()+")");

//               System.out.println(type+"--"+type.getDid()+ "-"+ type.getRead()+ "-"+ type.getWrite() + "-"+ type.getUnit());
            a++;
        }



            //24fed17bfab20c86bf6bdc6e0dd2531f
            //24FED17BFAB20C86BF6BDC6E0DD2531F
        }


}
