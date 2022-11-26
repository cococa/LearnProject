package com.cocoa.dangan;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class main {

    public static void main(String args[]) {

        Long l = null;

        System.out.println(l == 0);


//        String s = "{\"words_result\":{\"社会信用代码\":{\"words\":\"10440119MA06M8503\",\"location\":{\"top\":296,\"left\":237,\"width\":178,\"height\":18}},\"组成形式\":{\"words\":\"无\",\"location\":{\"top\":-1,\"left\":-1,\"width\":0,\"height\":0}},\"经营范围\":{\"words\":\"商务服务业\",\"location\":{\"top\":587,\"left\":378,\"width\":91,\"height\":18}},\"成立日期\":{\"words\":\"2019年01月01日\",\"location\":{\"top\":482,\"left\":1045,\"width\":119,\"height\":19}},\"法人\":{\"words\":\"方平\",\"location\":{\"top\":534,\"left\":377,\"width\":39,\"height\":19}},\"注册资本\":{\"words\":\"200万元\",\"location\":{\"top\":429,\"left\":1043,\"width\":150,\"height\":19}},\"证件编号\":{\"words\":\"921MA190538210301\",\"location\":{\"top\":216,\"left\":298,\"width\":146,\"height\":16}},\"地址\":{\"words\":\"广州市\",\"location\":{\"top\":585,\"left\":1041,\"width\":55,\"height\":19}},\"单位名称\":{\"words\":\"有限公司\",\"location\":{\"top\":429,\"left\":382,\"width\":72,\"height\":19}},\"有效期\":{\"words\":\"长期\",\"location\":{\"top\":534,\"left\":1045,\"width\":0,\"height\":0}},\"核准日期\":{\"words\":\"2018年12月20日\",\"location\":{\"top\":534,\"left\":1045,\"width\":0,\"height\":0}},\"类型\":{\"words\":\"有限责任公司(自然人投资或控股)\",\"location\":{\"top\":482,\"left\":382,\"width\":260,\"height\":18}}},\"log_id\":1310106134421438464,\"words_result_num\":12,\"direction\":0}";//        JSONObject jsonObject = JSON.parseObject(s);
//        BaiduJson baiduJson = JSON.parseObject(s, BaiduJson.class);
//        System.out.println(baiduJson.getWordsResult());

        //维修企业注册
//        lcipproaccountcompany();

        //获取接口调用凭证
        //lcipprogetaccesstoken();

        //新增维修记录
        //lcipprocarfixrecordadd();
    }

    //维修企业账户注册
    public static void lcipproaccountcompany() {
        String method = "https://qcda.96520.com/restservices/lcipprodatarest/lcipproaccountcompany/query";
        try {
//

            String json1 = "{\"companyaddress\":\"三墩镇古墩路588号第一层hz1052号\",\"companyadministrativedivisioncode\":\"330106\"," +
                    "\"companybusinessscope\":\"服务：汽车维修、汽车美容、洗车；零售：汽车配件、汽车用品、轮胎。\",\"companycategory\":\"03\"," +
                    "\"companyeconomiccategory\":\"150\",\"companyemail\":\"wenguoliang@qccr.com\",\"companylinkmanname\":\"钱昆\"," +
                    "\"companylinkmantel\":\"13396526666\",\"companyname\":\"杭州帕丁顿汽车服务有限公司\",\"companyoperationstate\":\"1\"," +
                    "\"companypassword\":\"Pdd_1117\",\"companypostalcode\":\"310050\",\"companyroadtransportationlicense\":" +
                    "\"6243413143254525436\",\"companysuperintendentname\":\"钱昆\",\"companysuperintendenttel\":\"13396526111\"," +
                    "\"companyunifiedsocialcreditidentifier\":\"94630106MA2CDCP98B\",\"roadtransportationlicenseenddate\":\"99990909\",\"roadtransportationlicensestartdate\":\"20180727\"}";

            HttpClientUtil httpClientUtil = new HttpClientUtil();
            String httpOrgCreateTestRtn = httpClientUtil.doPost(method, json1, "utf-8");
            if (httpOrgCreateTestRtn != null) {
                System.out.println("返回结果： " + httpOrgCreateTestRtn);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //身份校验
//    public  static  void lcipprogetaccesstoken()
//    {
//        String method = "https://wiki.dev.qichedangan.cn/restservices/lcipprodatarest/lcipprogetaccesstoken/query";
//        try
//        {
//            JSONObject json1 = new JSONObject();
//            json1.put("companycode","");     //维修企业编码
//            json1.put("companypassword",""); //维修企业密码
//            HttpClientUtil httpClientUtil = new HttpClientUtil();
//            String httpOrgCreateTestRtn = httpClientUtil.doPost(method,json1,"utf-8");
//            if(httpOrgCreateTestRtn != null)
//            {
//
//                System.out.println("返回结果： " +httpOrgCreateTestRtn);
//
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    //新增汽车维修电子记录
//    public  static  void  lcipprocarfixrecordadd()
//    {
//        String method = "https://wiki.dev.qichedangan.cn/restservices/lcipprodatarest/lcipprocarfixrecordadd/query";
//        try
//        {
//            JSONObject json_ = new JSONObject();
//            json_.put("access_token","");     //接口调用凭证
//
//            JSONObject basicInfo = new JSONObject();
//            basicInfo.put("vehicleplatenumber", "");   //车牌号码
//            basicInfo.put("companyname", "");   //维修企业名称
//            basicInfo.put("vin", "");	  //车辆识别代码
//            basicInfo.put("repairdate", "");  //送修日期
//            basicInfo.put("repairmileage", ""); //送修里程
//            basicInfo.put("settledate", "");  //结算日期
//            basicInfo.put("faultdescription", ""); //故障描述
//            basicInfo.put("costlistcode", "");	//结算清单编号
//
//            json_.put("basicInfo",basicInfo.toString());
//
//            JSONArray jarr1 = new JSONArray();
//            JSONObject json1 = new JSONObject();
//            json1.put("partsname","");   //配件名称
//            json1.put("partsquantity","");  //配件数量
//            json1.put("partscode","");   //配件编码
//            jarr1.put(json1);
//            JSONObject json2 = new JSONObject();
//            json2.put("partsname","");    //配件名称
//            json2.put("partsquantity","");    //配件数量
//            json2.put("partscode","");     //配件编码
//            jarr1.put(json2);
//            //数组转为JSON字符串
//            String jarrStr1 = jarr1.toString();
//            json_.put("vehiclepartslist",jarrStr1);
//
//            JSONArray jarr2 = new JSONArray();
//            JSONObject json3 = new JSONObject();
//            json3.put("repairproject","");   //维修项目
//            json3.put("workinghours","");      //维修工时
//            jarr2.put(json3);
//            JSONObject json4 = new JSONObject();
//            json4.put("repairproject","");   //维修项目
//            json4.put("workinghours","");	//维修工时
//            jarr2.put(json4);
//            //数组转为JSON字符串
//            String jarrStr2 = jarr2.toString();
//            json_.put("repairprojectlist",jarrStr2);
//            HttpClientUtil httpClientUtil = new HttpClientUtil();
//            String httpOrgCreateTestRtn = httpClientUtil.doPost(method,json_,"utf-8");
//            if(httpOrgCreateTestRtn != null)
//            {
//                System.out.println("返回结果： " +httpOrgCreateTestRtn);
//                JSONObject json = new JSONObject(httpOrgCreateTestRtn);
//                if(!json.isNull("code"))
//                {
//                    String code = json.getString("code");
//                    String status = json.getString("status");
//                }
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }


}
