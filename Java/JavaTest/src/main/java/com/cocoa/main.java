package com.cocoa;


import com.alibaba.fastjson.JSON;
import com.cocoa.model.Platform;
import com.cocoa.model.dataoke.DouyinGoodsDetail;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tdmq.v20200217.TdmqClient;
import com.tencentcloudapi.tdmq.v20200217.models.*;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.collections4.ListUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    static class Person {
        private Long id;
        private String name;
        private String addrss;
        private String aaaa;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddrss() {
            return addrss;
        }

        public void setAddrss(String addrss) {
            this.addrss = addrss;
        }

        public String getAaaa() {
            return aaaa;
        }

        public void setAaaa(String aaaa) {
            this.aaaa = aaaa;
        }
    }


    private Integer getMpUser() {
        int retry = 0;
        while (retry != 3) {
            System.out.println(retry + "---");
            try {
                return 1;
            } catch (Exception e) {
                System.out.println("getMpUser error message:{} e");
                retry++;
            }
        }
        return null;
    }

    private static Stream<Object> getList(List<Object> list) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return list.stream();
    }


    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static Date getDateAfterMonth(int month) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, month);
        return calendar.getTime();
    }


    static void test1(String pageindex) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", "b253a26d80fc9e3a");
        map.put("appsecret", "a188d216d08c47228493b2e11a42e9c2");
        map.put("pageindex", pageindex);
        map.put("pagesize", "1000");  //最大 5000
        String s = HttpUtils.simplePost(JSON.toJSONString(map), "http://sdmsync.dat881.com/api/Cycle/CycleBatch/Post");
        System.out.println(s);
    }


    public static void main(String[] args) throws ParseException, IOException {
        test1("");





//        Boolean a = null;
//        System.out.println(a == true);

//        String s1 = new String("{\"appkey\": \"b253a26d80fc9e3a\",\"appsecret\": \"a188d216d08c47228493b2e11a42e9c2\",\"pageindex\": \"\",\"pagesize\": \"100\"}");
//        String s = HttpUtils.simplePost(s1, "http://sdmsync.dat881.com/api/Cycle/CycleBatch/Post");
//        System.out.println(s);


//        Map<Integer,Long> map = new HashMap<>();
//        map.put(1,2L);
//        System.out.println(map.get(222));


//        System.out.println(new Date().after(getDateAfterMonth(12)));
//
//
//        Person p = new Person();
////        change(p);
//        System.out.println(p.getName());


//        List<Object> list = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            Person p = new Person();
//            p.setAaaa("123123123123sdasdas");
//            p.setAddrss("hjasddahskdjhaskjdhjkh");
//            p.setId((long) i);
//            p.setName("1231232131");
//            list.add(p);
//        }
//
//        List<List<Object>> partition = ListUtils.partition(list, 100);
//        System.out.println(partition);
//
//
//        List<Object> collect = partition.stream().parallel().flatMap((item) -> {
//            return getList(item);
//        }).collect(Collectors.toList());
//
//
//        System.out.println(collect);


//        System.out.println(Platform.DDX);


//        String str = "\uD83C\uDF49\uD83C\uDF47\uD83C\uDF51\uD83C\uDF53\uD83E\uDD5D";
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//        for (byte b : bytes) {
//            System.out.println(Integer.toHexString(b));
//
//        }

//        Person person1 = new Person(1L, "1111");
//        Person person2 = new Person(1L, "11111");
//        Person person3 = new Person(2L, "222");
//        Person person4 = new Person(4L, "444");
//
//        List<Person> list = new ArrayList<>();
////        list.add(person1);
////        list.add(person2);
////        list.add(person3);
////        list.add(person4);
//
//        Map<Long, List<Person>> collect = list.stream().
//                collect(Collectors.groupingBy(Person::getId));
//        System.out.println(collect.get(1));

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


}
