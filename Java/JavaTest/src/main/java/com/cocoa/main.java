package com.cocoa;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tdmq.v20200217.TdmqClient;
import com.tencentcloudapi.tdmq.v20200217.models.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

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


    public static Date parseDate(String dateStr) {

        try {
            String fmtDateStr = dateStr.replaceAll("\\/", "-");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(fmtDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws ParseException, IOException {

        String str = "\uD83C\uDF49\uD83C\uDF47\uD83C\uDF51\uD83C\uDF53\uD83E\uDD5D";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(Integer.toHexString(b));

        }


//        String s =  "中";
//
//        for(Byte b : s.getBytes()) {
//            System.out.println(b);
//        }
//
//        String sss = new String(s.getBytes());
//
//        Long  a = new Long(123);
//        Long  b = new Long(123);
//
//        System.out.println(a.equals(b));


//        main main = new main();
//
//        String dateStr = "2019/12/12";
//
//        Date d = parseDate(dateStr);
//        System.out.println(d);
//        ;


//        File file  = new File("/Users/shenjun/Documents/a.txt");
//        file.createNewFile();
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        OutputStreamWriter bufferedOutputStream  = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
//
//        JSONObject  jsonObject = new JSONObject();
//        jsonObject.put("123123","收到回复水电费收到货");
//        bufferedOutputStream.write(jsonObject.toJSONString());
//        bufferedOutputStream.flush();
//        bufferedOutputStream.close();


//        System.out.println(Money.ofYuan(20000).getYuan());


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
//        String dateStr = "2020/06/12 11:00:00";
//        if (dateStr.contains(" ")) {
//            String[] dateArray = dateStr.split(" ");
//            if (dateArray != null && dateArray.length > 1) {
//                dateStr = dateArray[0];
//            }
//        }
//        System.out.println(dateStr);
//
//
//        String finalFileName = "/Users/shenjun/Desktop/20211201184219566.xlsx";
//
//        EasyExcel.read(finalFileName, ExcelDataOldCustomer.class, new AnalysisEventListener<ExcelDataOldCustomer>() {
//            @Override
//            public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//                super.invokeHeadMap(headMap, context);
//                // 判断excel 的数据是否发生变化
//                final int headerSize = ExcelDataOldCustomer.EXCEL_TEML_HEADER_NAMES.length;
//                for (int i = 0; i < headerSize; i++) {
//                    String itemTmplHeaderName = ExcelDataOldCustomer.EXCEL_TEML_HEADER_NAMES[i];
//                    if (!itemTmplHeaderName.equals(headMap.get(i))) {
//                        String errorMsg = String.format("导入失败, 解析excel 第 {%s} 列出错，模板字段= {%s}, 上传的字段= {%s}，请核对！", i, itemTmplHeaderName, headMap.get(i));
//                        throw new NullPointerException(errorMsg);
//                    }
//                }
//            }
//
//            @Override
//            public void onException(Exception exception, AnalysisContext context) throws Exception {
//                super.onException(exception, context);
//
//            }
//
//            @Override
//            public void invoke(ExcelDataOldCustomer data, AnalysisContext analysisContext) {
//                try {
//                    System.out.println("----");
//                    JSONObject jsonObject = new JSONObject();
//                    jsonObject.put("data",data);
//                    System.out.println(jsonObject.toJSONString());
//                    System.out.println(data.getRegisterTime());
//                    System.out.println(data.getVehicleInsuranceTime());
//                    System.out.println(data.getCompulsoryInsuranceTime());
//                } catch (Exception e) {
//
//                }
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//            }
//        }).sheet().doRead();


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
