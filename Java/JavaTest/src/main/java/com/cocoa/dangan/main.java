package com.cocoa.dangan;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class main {

    public static void main ( String args[] )
    {
        //维修企业注册
        lcipproaccountcompany();

        //获取接口调用凭证
        //lcipprogetaccesstoken();

        //新增维修记录
        //lcipprocarfixrecordadd();
    }

    //维修企业账户注册
    public static  void  lcipproaccountcompany()
    {
        String method = "https://qcda.96520.com/restservices/lcipprodatarest/lcipproaccountcompany/query";
        try
        {
//

            String json1 ="{\"companyaddress\":\"三墩镇古墩路588号第一层hz1052号\",\"companyadministrativedivisioncode\":\"330106\"," +
                    "\"companybusinessscope\":\"服务：汽车维修、汽车美容、洗车；零售：汽车配件、汽车用品、轮胎。\",\"companycategory\":\"03\"," +
                    "\"companyeconomiccategory\":\"150\",\"companyemail\":\"wenguoliang@qccr.com\",\"companylinkmanname\":\"钱昆\"," +
                    "\"companylinkmantel\":\"13396526666\",\"companyname\":\"杭州帕丁顿汽车服务有限公司\",\"companyoperationstate\":\"1\"," +
                    "\"companypassword\":\"Pdd_1117\",\"companypostalcode\":\"310050\",\"companyroadtransportationlicense\":" +
                    "\"6243413143254525436\",\"companysuperintendentname\":\"钱昆\",\"companysuperintendenttel\":\"13396526111\"," +
                    "\"companyunifiedsocialcreditidentifier\":\"94630106MA2CDCP98B\",\"roadtransportationlicenseenddate\":\"99990909\",\"roadtransportationlicensestartdate\":\"20180727\"}";

            HttpClientUtil httpClientUtil = new HttpClientUtil();
            String httpOrgCreateTestRtn = httpClientUtil.doPost(method,json1,"utf-8");
            if(httpOrgCreateTestRtn != null)
            {
                System.out.println("返回结果： " +httpOrgCreateTestRtn);

            }
        }
        catch (Exception e)
        {
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
