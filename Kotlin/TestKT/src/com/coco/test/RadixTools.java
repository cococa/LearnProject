package com.coco.test;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * radix tools
 * Created by vincent on 2018/10/6
 */
public class RadixTools {

    /************************************** BinaryString **********************************************/

    public static String binaryToString(byte b){
        return Long.toBinaryString((b & 0xFF) + 0x100).substring(1);
    }

    public static String binaryToString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Long.toBinaryString((aByte & 0xFF) + 0x100).substring(1));
        }
        return sb.toString();
    }

    public static byte binaryStringToByte(String bString){
        byte result=0;
        for(int i=bString.length()-1,j=0;i>=0;i--,j++){
            result+=(Byte.parseByte(bString.charAt(i)+"")*Math.pow(2, j));
        }
        return result;
    }

    /************************************** HexString **********************************************/

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static String bytesToHexStr(byte[] bytes){
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) {
            buf.append(String.format("%02x", b & 0xff));
        }

        return buf.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


    /************************************** String **********************************************/

    public static String bytesToStr(byte[] bytes){
        return bytesToStr(bytes, Charset.forName("gbk"));
    }

    public static String bytesToStr(byte[] bytes, Charset charset){
        return new String(bytes, charset).trim().toUpperCase();
    }

    public static byte[] strToBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("gbk");
    }

    /************************************** long **********************************************/

    public static byte[] longToBytes(long number) {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    public static long bytesToLong(byte[] bytes) {
        long s = 0;
        long s0 = bytes[0] & 0xff;// 最低位
        long s1 = bytes[1] & 0xff;
        long s2 = bytes[2] & 0xff;
        long s3 = bytes[3] & 0xff;
        long s4 = bytes[4] & 0xff;// 最低位
        long s5 = bytes[5] & 0xff;
        long s6 = bytes[6] & 0xff;
        long s7 = bytes[7] & 0xff;

        // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }


    /************************************** int **********************************************/

    public static byte[] intToBytes(int number) {
        int temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }


    public static int bytesToInt(byte[] b) {
        int s = 0;
        int s0 = b[0] & 0xff;// 最低位
        int s1 = b[1] & 0xff;
        int s2 = b[2] & 0xff;
        int s3 = b[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        return s;
    }

    public static long bytesToUnsignedInt(byte[] b) {
        int i = bytesToInt(b);
        return Integer.toUnsignedLong(i);
    }

    public static byte[] unsignedIntToBytes(long l, boolean littleEndian) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            int i1 = (littleEndian ? i : (3 - i)) << 3;
            bytes[i] = (byte) ((l >> i1) & 0xff);
        }
        return bytes;
    }

    /************************************** short **********************************************/

    public static byte[] shortToByte(short number) {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();//将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    public static short byteToShort(byte[] b) {
        short l = 0;
        for (int i = 0; i < 2; i++) {
            l<<=8; //<<=和我们的 +=是一样的，意思就是 l = l << 8
            l |= (b[i] & 0xff); //和上面也是一样的  l = l | (b[i]&0xff)
        }
        return l;
    }

    public static int bytesToUnsignedShort(byte[] b) {
        short i = byteToShort(b);
        return Short.toUnsignedInt(i);
    }

    public static byte[] unsignedShortToByte(int l, boolean littleEndian) {
        byte[] bytes = new byte[2];
        for (int i = 0; i < 2; i++) {
            int i1 = (littleEndian ? i : (1 - i)) << 3;
            bytes[i] = (byte) ((l >> i1) & 0xff);
        }
        return bytes;
    }







    // 十进制转十六进制字符串
    public static String intToHex(int n) {
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        return a;
    }



    /**
     * 10 ===>> 16
     */
    public static String decToHex(String dec) {
        int data = Integer.parseInt(dec, 10);
        return Integer.toString(data, 16).toUpperCase();
    }
    /**
     * 16 ==>> 10
     */
    public static String hexToDec(String hex) {
        int data = Integer.parseInt(hex, 16);
        return Integer.toString(data, 10);
    }

    /**
     * 将String转成BCD码
     */
    public static byte[] strToBcd(String s) {
        if(s.length () % 2 != 0) {
            s = "0" + s;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        char [] cs = s.toCharArray ();
        for (int i = 0;i < cs.length;i += 2) {
            int high = cs [i] - 48;
            int low = cs [i + 1] - 48;
            baos.write (high << 4 | low);
        }
        return baos.toByteArray ();
    }


    /**
     * 将BCD码转成String
     */
    public static String bcdToString(byte[] b){
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            int h = ((value & 0xff) >> 4) + 48;
            sb.append((char) h);
            int l = (value & 0x0f) + 48;
            sb.append((char) l);
        }
        return sb.toString () ;
    }

    //字符串转换为ascii
    public static byte[] strToAscii(String content){
        try {
            return content.getBytes(StandardCharsets.US_ASCII);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //ascii转换为string
    public static String asciiToStr(byte[] bytes) {
//        StringBuilder sbu = new StringBuilder();
//        for (byte aByte : bytes) {
//            sbu.append((char) aByte);
//        }
//        return sbu.toString();

        return new String(bytes, StandardCharsets.UTF_8);

    }

    //补0
    public static String strAdd0(String str,int size){
        int len = str.length() / 2;
        if(len>=size){
            return str;
        }
        for (int i=0;i<size-len;i++){
            str+="00";
        }
        return str;
    }
}
