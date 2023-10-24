package com.cocoa;


import com.alibaba.fastjson.JSON;
import org.apache.dubbo.common.utils.MD5Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
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


    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static Date getDateAfterMonth(int month) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }


    static String test1(String pageindex) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", "b253a26d80fc9e3a");
        map.put("appsecret", "a188d216d08c47228493b2e11a42e9c2");
        map.put("pageindex", pageindex);
        map.put("pagesize", "1000");  //最大 5000
        String s = HttpUtils.simplePost(JSON.toJSONString(map), "http://sdmsync.dat881.com/api/Cycle/CycleBatch/Post");
        return s;
    }


    public static void main(String[] args) throws ParseException, IOException {

//        P p = new P();
//        p.setA(0);
//        System.out.println(Objects.equals(p.getA(), 0));
//


//     String ss = "[{\"abbreviation\":\"浙\",\"areaCode\":\"330000000000\",\"areaId\":21,\"areaInnerLevel\":\"1\",\"areaName\":\"浙江省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"沪\",\"areaCode\":\"310000000000\",\"areaId\":30,\"areaInnerLevel\":\"1\",\"areaName\":\"上海市\",\"carnoPre\":\"沪A\",\"parentId\":0,\"status\":0,\"warningLevel\":3},{\"areaCode\":\"500000000000\",\"areaId\":123,\"areaInnerLevel\":\"1\",\"areaName\":\"重庆市\",\"carnoPre\":\"渝A\",\"parentId\":0,\"status\":0,\"warningLevel\":3},{\"abbreviation\":\"冀\",\"areaCode\":\"130000000000\",\"areaId\":124,\"areaInnerLevel\":\"1\",\"areaName\":\"河北省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"晋\",\"areaCode\":\"140000000000\",\"areaId\":125,\"areaInnerLevel\":\"1\",\"areaName\":\"山西省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"豫\",\"areaCode\":\"410000000000\",\"areaId\":126,\"areaInnerLevel\":\"1\",\"areaName\":\"河南省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"辽\",\"areaCode\":\"210000000000\",\"areaId\":127,\"areaInnerLevel\":\"1\",\"areaName\":\"辽宁省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"吉\",\"areaCode\":\"220000000000\",\"areaId\":128,\"areaInnerLevel\":\"1\",\"areaName\":\"吉林省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"黑\",\"areaCode\":\"230000000000\",\"areaId\":129,\"areaInnerLevel\":\"1\",\"areaName\":\"黑龙江省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"蒙\",\"areaCode\":\"150000000000\",\"areaId\":130,\"areaInnerLevel\":\"1\",\"areaName\":\"内蒙古自治区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"苏\",\"areaCode\":\"320000000000\",\"areaId\":131,\"areaInnerLevel\":\"1\",\"areaName\":\"江苏省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"鲁\",\"areaCode\":\"370000000000\",\"areaId\":132,\"areaInnerLevel\":\"1\",\"areaName\":\"山东省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"皖\",\"areaCode\":\"340000000000\",\"areaId\":133,\"areaInnerLevel\":\"1\",\"areaName\":\"安徽省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"闽\",\"areaCode\":\"350000000000\",\"areaId\":135,\"areaInnerLevel\":\"1\",\"areaName\":\"福建省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"鄂\",\"areaCode\":\"420000000000\",\"areaId\":136,\"areaInnerLevel\":\"1\",\"areaName\":\"湖北省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"湘\",\"areaCode\":\"430000000000\",\"areaId\":137,\"areaInnerLevel\":\"1\",\"areaName\":\"湖南省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"粤\",\"areaCode\":\"440000000000\",\"areaId\":138,\"areaInnerLevel\":\"1\",\"areaName\":\"广东省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"桂\",\"areaCode\":\"450000000000\",\"areaId\":139,\"areaInnerLevel\":\"1\",\"areaName\":\"广西壮族自治区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"赣\",\"areaCode\":\"360000000000\",\"areaId\":140,\"areaInnerLevel\":\"1\",\"areaName\":\"江西省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"川\",\"areaCode\":\"510000000000\",\"areaId\":141,\"areaInnerLevel\":\"1\",\"areaName\":\"四川省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"琼\",\"areaCode\":\"460000000000\",\"areaId\":142,\"areaInnerLevel\":\"1\",\"areaName\":\"海南省\",\"carnoPre\":\"琼A\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"贵\",\"areaCode\":\"520000000000\",\"areaId\":143,\"areaInnerLevel\":\"1\",\"areaName\":\"贵州省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"云\",\"areaCode\":\"530000000000\",\"areaId\":144,\"areaInnerLevel\":\"1\",\"areaName\":\"云南省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"藏\",\"areaCode\":\"540000000000\",\"areaId\":145,\"areaInnerLevel\":\"1\",\"areaName\":\"西藏自治区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"陕\",\"areaCode\":\"610000000000\",\"areaId\":146,\"areaInnerLevel\":\"1\",\"areaName\":\"陕西省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"甘\",\"areaCode\":\"620000000000\",\"areaId\":147,\"areaInnerLevel\":\"1\",\"areaName\":\"甘肃省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"青\",\"areaCode\":\"630000000000\",\"areaId\":148,\"areaInnerLevel\":\"1\",\"areaName\":\"青海省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"宁\",\"areaCode\":\"640000000000\",\"areaId\":149,\"areaInnerLevel\":\"1\",\"areaName\":\"宁夏回族自治区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"新\",\"areaCode\":\"650000000000\",\"areaId\":150,\"areaInnerLevel\":\"1\",\"areaName\":\"新疆维吾尔自治区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"abbreviation\":\"台\",\"areaCode\":\"710000000000\",\"areaId\":151,\"areaInnerLevel\":\"1\",\"areaName\":\"台湾省\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"areaCode\":\"810000000000\",\"areaId\":152,\"areaInnerLevel\":\"1\",\"areaName\":\"香港特别行政区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"areaCode\":\"820000000000\",\"areaId\":153,\"areaInnerLevel\":\"1\",\"areaName\":\"澳门特别行政区\",\"parentId\":0,\"status\":0,\"warningLevel\":0},{\"areaCode\":\"120000000000\",\"areaId\":207,\"areaInnerLevel\":\"1\",\"areaName\":\"天津市\",\"carnoPre\":\"津A\",\"parentId\":0,\"status\":0,\"warningLevel\":3},{\"areaCode\":\"110000000000\",\"areaId\":208,\"areaInnerLevel\":\"1\",\"areaName\":\"北京市\",\"carnoPre\":\"京A\",\"parentId\":0,\"status\":0,\"warningLevel\":3}]";
//
//        List<AreaDo> areaDos = JSON.parseArray(ss, AreaDo.class);
//        System.out.println(areaDos.size());
//
//        areaDos.add(areaDos.get(0));
//        System.out.println(areaDos.size());
//        Map<String, AreaDo> collect1 = areaDos.stream().filter(item -> {
//                    System.out.println(item.getStatus());
//                    System.out.println(Objects.equals(item.getStatus(), (byte)0));
//                    return  Objects.equals(item.getStatus(), (byte)0);
//                })
//                .collect(Collectors.toMap(AreaDo::getAreaCode, Function.identity(), (k1, k2) -> k1));
////        Map<String, AreaDo> collect = (Map<String, AreaDo>) collect1
//
//        System.out.println("collect1   "+collect1.isEmpty());
//        System.out.println("collect1   "+collect1);

//        110000000000
//        SxOHY9jW7eVk7cYIcpMyVBtYidUIsJqR
//        RB5BZ-XQXKI-I6PGN-UIQFL-DDPK2-KJBES
//        https://apis.map.qq.com/ws/district/v1/getchildren?id=330100&key=46WBZ-GBORZ-RRMXA-Z436B-MRWI2-NUBS5
//        320282000000
        String origin = "/ws/district/v1/getchildren?id=110000&key=RB5BZ-XQXKI-I6PGN-UIQFL-DDPK2-KJBES" + "SxOHY9jW7eVk7cYIcpMyVBtYidUIsJqR";
        String sig = new MD5Utils().getMd5(origin);
        System.out.println(sig);
        String s = HttpUtils.simpleGet("https://apis.map.qq.com/ws/district/v1/getchildren?id=110000&key=RB5BZ-XQXKI-I6PGN-UIQFL-DDPK2-KJBES&sig=" + sig);
        System.out.printf(s);
//        {
//            "id": "370000",
//                "name": "山东",
//                "fullname": "山东省",
//                "pinyin": [
//            "shan",
//                    "dong"
//                ],
//            "location": {
//            "lat": 36.670201,
//                    "lng": 117.020725
//        }
//        },


//        System.out.printf(s);

//        P p = new P();
//        p.setaByte((byte) 1);
//        System.out.println(p.getaByte() == 1);
//
//
//        String ss = test1("a739wcHTKXaI7zd9yGwPeQ==");
//        System.out.println(ss);
//        LyUpkeepImportResult lyUpkeepImportResult = JSON.parseObject(ss, LyUpkeepImportResult.class);
//        System.out.println(lyUpkeepImportResult.getResult());
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

//class P {
//    Byte aByte;
//
//    Integer a ;
//
//    public Integer getA() {
//        return a;
//    }
//
//    public void setA(Integer a) {
//        this.a = a;
//    }
//
//    public Byte getaByte() {
//        return aByte;
//    }
//
//    public void setaByte(Byte aByte) {
//        this.aByte = aByte;
//    }
//}
