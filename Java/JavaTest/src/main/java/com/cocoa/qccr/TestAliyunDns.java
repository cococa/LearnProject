package com.cocoa.qccr;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.aliyun.alidns20150109.models.AddDomainRecordResponse;
import com.aliyun.alidns20150109.models.AddDomainRecordResponseBody;
import com.aliyun.alidns20150109.models.DeleteSubDomainRecordsResponse;
import com.aliyun.tea.*;


public class TestAliyunDns {
//    public static com.aliyun.alidns20150109.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
//        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
//                // 必填，您的 AccessKey ID
//                .setAccessKeyId(accessKeyId)
//                // 必填，您的 AccessKey Secret
//                .setAccessKeySecret(accessKeySecret);
//        // 访问的域名
//        config.endpoint = "alidns.cn-hangzhou.aliyuncs.com";
//        return new com.aliyun.alidns20150109.Client(config);
//    }
//
//    public static void main(String[] args_) throws Exception {
////        delDomain("807442365867280384");
//        addDomain("test1");
//    }
//
//    public static void addDomain(String domain) throws Exception {
//        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
//        com.aliyun.alidns20150109.Client client = createClient("", "");
//        com.aliyun.alidns20150109.models.AddDomainRecordRequest addDomainRecordRequest = new com.aliyun.alidns20150109.models.AddDomainRecordRequest();
//
//        //域名名称
//        addDomainRecordRequest.setDomainName("szmdsaas.com");
//        //主机记录.szmdsaas.com
//        addDomainRecordRequest.setRR(domain);
//        //解析记录类型
//        addDomainRecordRequest.setType("A");
//        //记录值
//        addDomainRecordRequest.setValue("121.40.202.23");
//
//        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
//            // 复制代码运行请自行打印 API 的返回值
//        AddDomainRecordResponse addDomainRecordResponse = client.addDomainRecordWithOptions(addDomainRecordRequest, runtime);
//
//        AddDomainRecordResponseBody body = addDomainRecordResponse.getBody();
//
//        //
//        body.getRecordId()
//
//
////        System.out.println(new Gson().toJson(body));
//
//    }
//
//    public static void delDomain(String domain) throws Exception {
//        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
//        com.aliyun.alidns20150109.Client client = createClient("", "");
//        com.aliyun.alidns20150109.models.DeleteSubDomainRecordsRequest deleteSubDomainRecordsRequest = new com.aliyun.alidns20150109.models.DeleteSubDomainRecordsRequest();
//        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
//                //域名名称
//        deleteSubDomainRecordsRequest.setDomainName("szmdsaas.com");
//        //主机记录.szmdsaas.com
//        deleteSubDomainRecordsRequest.setRR("test1");
//        try {
//            // 复制代码运行请自行打印 API 的返回值
//            DeleteSubDomainRecordsResponse deleteSubDomainRecordsResponse = client.deleteSubDomainRecordsWithOptions(deleteSubDomainRecordsRequest, runtime);
//            String totalCount = deleteSubDomainRecordsResponse.getBody().getTotalCount();
//            if("0".equals(totalCount)){
//                throw new NullPointerException("");
//            }
//        }  catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
