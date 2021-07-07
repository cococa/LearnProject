package com.cocoa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class main {


    /**
     * @param v1
     * @param v2
     * @return 0代表相等，1代表左边大，-1代表右边大
     */
    public int checkVersionName(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }

    }



    public static void main(String[] args) throws ParseException {

        main  main = new main();


        System.out.println(Money.ofYuan(20000).getYuan());


//        try {
////            new main().test();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // 砂夹石的
//        System.out.println("can 胜多负少的 any more!");
//
//        TestParent  parent = new TestParent();
//        parent.setAge(12);
//        parent.setName("parent");
//        TestChild child = new TestChild();
//        child.setAddr("address");
//        parent.setChild(child);
//
//        System.out.println(parent.getName());
//
//        try {
//            TestParent parent1 = (TestParent) parent.clone();
//            parent1.setChild(null);
//            parent1.setName(null);
//
//            System.out.println(parent.getChild().toString());
//            System.out.println(parent.getName().toString());
//
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }


//        String strDateFormat = "yyyy-MM-dd";
//        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//        Date date = sdf.parse("2017-1-1");
//        System.out.println(date.getDate());
//
//        String str1="2018-7-5";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime parse = LocalDateTime.parse(str1, dtf);
//        System.out.println(parse);



    }


//    public void test() throws Exception{
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
//        HttpPost httpPost = new HttpPost(url);
//
//        String appKey = "dd87cd68fa15d7499e98ea7f0d2c061b";
//        String appSecret = "10d14d4d6a2a";
//        String nonce =  "12345";
//        String curTime = String.valueOf((new Date()).getTime() / 1000L);
//        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);
//
//        httpPost.addHeader("AppKey", appKey);
//        httpPost.addHeader("Nonce", nonce);
//        httpPost.addHeader("CurTime", curTime);
//        httpPost.addHeader("CheckSum", checkSum);
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("accid", "testqccr2"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//        HttpResponse response = httpClient.execute(httpPost);
//
//        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
//    }

}
