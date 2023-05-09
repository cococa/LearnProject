package com.cocoa.weixin;

import me.chanjar.weixin.common.bean.subscribemsg.PubTemplateKeyword;
import me.chanjar.weixin.mp.api.WxMpSubscribeMsgService;
import me.chanjar.weixin.open.api.WxOpenComponentService;
import me.chanjar.weixin.open.api.WxOpenConfigStorage;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.api.impl.WxOpenComponentServiceImpl;
import me.chanjar.weixin.open.api.impl.WxOpenInMemoryConfigStorage;
import me.chanjar.weixin.open.api.impl.WxOpenServiceImpl;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static final String DOWNLOAD_PATH = "../";
    private static final String DEFUALT_DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    public static String downloadFile(String fileurl, String defaultFilename) throws Exception {
        String outfilePath = "";

        File dirFile = new File(DOWNLOAD_PATH);
        System.out.println(dirFile);
        //文件路径不存在时，自动创建目录
        if (!dirFile.exists()) {
            boolean result = dirFile.mkdirs();
            System.out.println(result);
        }

        String[] splitArray = fileurl.split("\\.");

        String filename = defaultFilename;
//        if (splitArray != null && splitArray.length >= 2) {
//            filename = splitArray[splitArray.length - 1];
//        }

        //从服务器上获文件并保存
        outfilePath = DOWNLOAD_PATH + "DR" + System.currentTimeMillis() + "." + filename;

        URL theURL = new URL(fileurl);

        URLConnection connection = theURL.openConnection();
        InputStream in = connection.getInputStream();
        FileOutputStream os = new FileOutputStream(outfilePath);
        byte[] buffer = new byte[4 * 1024];
        int read;
        while ((read = in.read(buffer)) > 0) {
            os.write(buffer, 0, read);
        }
        os.close();
        in.close();

        return outfilePath;
    }

    private static void savePic(InputStream inputStream, String fileName) {

        OutputStream os = null;
        try {
            String path = "/Users/shenjun/Documents/cocoa/LearnProject/Java/JavaTest";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
//        Byte b = new Byte("1");
//        Byte a = new Byte("1");
//
//        System.out.println(a.equals(b));
//
//        String jss = "{name:\"ccccc\"}";
//        Object js = JSON.toJSON(jss);
//        System.out.println(JSON.toJSONString(js));


        WxOpenConfigStorage wxOpenConfigStorage = new WxOpenInMemoryConfigStorage();
        wxOpenConfigStorage.setComponentAppId("wx656730804c2c5291");
        wxOpenConfigStorage.setComponentAppSecret("93e53a39ac2148424aa18c694db8ced3");
        wxOpenConfigStorage.setComponentVerifyTicket("ticket@@@5BywfW01VHquMZFalzj4j5FvswCvHQhjRV6vfRG_eJnCyIrOXwwj53egWsaYLyASDMAO1XnsYlATj1xb4EB3sg");


        WxOpenService wxOpenService = new WxOpenServiceImpl();


        wxOpenService.setWxOpenConfigStorage(wxOpenConfigStorage);


        WxOpenComponentService wxOpenComponentService = new WxOpenComponentServiceImpl(wxOpenService);


        String appId = "wx558e6f83438f7873";
        boolean isExpired = wxOpenComponentService.getWxOpenConfigStorage().isAuthorizerAccessTokenExpired(appId);
        if (true) {
            WxOpenAuthorizerInfoResult wxc2fe513a236a273a = wxOpenComponentService.getAuthorizerInfo(appId);
            String authorizerRefreshToken = wxc2fe513a236a273a.getAuthorizationInfo().getAuthorizerRefreshToken();
            System.out.println(wxc2fe513a236a273a);
            wxOpenComponentService.getWxOpenConfigStorage().setAuthorizerRefreshToken(appId, authorizerRefreshToken);
        }


        WxMpSubscribeMsgService subscribeMsgService = wxOpenComponentService.getWxMpServiceByAppid(appId).getSubscribeMsgService();

//        System.out.println(subscribeMsgService.getPubTemplateKeyWordsById("OPENTM410086463"));

        List<PubTemplateKeyword> opentm418136928 = subscribeMsgService.getPubTemplateKeyWordsById("42633");

        opentm418136928.stream().forEach((item) -> System.out.println(item.getKid() + " " + item.getName() + " " + item.getExample()));



//        675   GzbiiwgLxgc7yVj3EXlrJ2Pf3N2U6HYwucfpwCV4RmQ

//        String tid = "675";
//        WxMaSubscribeService subscribeService = wxOpenComponentService.getWxMaServiceByAppid(appId).getSubscribeService();
//        boolean b = subscribeService.delTemplate("30540");
//        System.out.println(b);
//        b = subscribeService.delTemplate("675");
//        System.out.println(b);
//        b = subscribeService.delTemplate("1874");
//        System.out.println(b);
//        b = subscribeService.delTemplate("30602");
//        System.out.println(b);


//        List<PubTemplateKeyword> pubTemplateKeyWordsById = subscribeService.getPubTemplateKeyWordsById(tid);
//        pubTemplateKeyWordsById.stream().forEach((item) -> System.out.print(item.getKid() + "-" + item.getName() + " "));
//        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(pubTemplateKeyWordsById)) {
//            List<Integer> collect = pubTemplateKeyWordsById.stream().map(PubTemplateKeyword::getKid).limit(5).collect(Collectors.toList());
//            collect.clear();
//            collect.addAll(getKidList(tid));
//            System.out.println(subscribeService.addTemplate(tid, collect, "123"));
//        }

//


//        WxMaSubscribeMessage wxMaSubscribeMessage = new WxMaSubscribeMessage();
//        wxMaSubscribeMessage.setToUser("of0wJ5J6HFWM7Hd6q1ncYnFeGeKY");
//        wxMaSubscribeMessage.setTemplateId("rHRBcZ7u9-kaJPV7KJhDKGXhlv8REjHdg_nAouUEeuo");
//
//        List<WxMaSubscribeMessage.MsgData> data = new ArrayList<>();
//        data.add(new WxMaSubscribeMessage.MsgData("thing1","汽车年卡"));
//        data.add(new WxMaSubscribeMessage.MsgData("thing2","汽车10次"));
//        data.add(new WxMaSubscribeMessage.MsgData("amount3","123"));
//        data.add(new WxMaSubscribeMessage.MsgData("phrase4","已付款"));
//        data.add(new WxMaSubscribeMessage.MsgData("thing5","xxx门店"));
//
//        wxMaSubscribeMessage.setData(data);
//        WxMaSubscribeService subscribeService = wxOpenComponentService.getWxMaServiceByAppid(appId).getSubscribeService();
//        subscribeService.sendSubscribeMsg(wxMaSubscribeMessage);


//        File file = wxOpenComponentService.getWxMaServiceByAppid(appId).getTestQrcode(null, null);
//        savePic(new FileInputStream(file),"aa.jpg");

//        Boolean aBoolean = wxOpenComponentService.getWxMaServiceByAppid(appId).speedAudit(438770365L);
//        System.out.println(
//                aBoolean
//        );
//        WxOpenMaQueryQuotaResult wxOpenMaQueryQuotaResult = wxOpenComponentService.getWxMaServiceByAppid(appId).queryQuota();
//        System.out.println(
//                wxOpenMaQueryQuotaResult
//        );

//        WxMpUserList wxMpUserList = wxOpenComponentService.getWxMpServiceByAppid(appId).getUserService().userList(null);
//        System.out.println(wxMpUserList);


//        WxOpenResult wxc8dc912ce6f78d37 = wxOpenComponentService.getWxMaServiceByAppid(appId)
//                .wxAmpLink("wxc8dc912ce6f78d37", "1", "1");
//        System.out.println(wxc8dc912ce6f78d37);

//        WxOpenResult wxd674d3151e7259bf = wxOpenComponentService.getWxMaServiceByAppid(appId)
//                .wxAmpUnLink("wxd674d3151e7259bf");
//        System.out.println(wxd674d3151e7259bf);


//         获取授权列表
//        WxOpenQueryAuthResult queryAuth = wxOpenComponentService.getQueryAuth("queryauthcode@@@Xu5dIKd44NXLeJ1jpVpPyGWfGpUq4NE9-lP5WBs7N-N5oGtuQzJwgSaC44nm-p5yt1W6W-kO63p0rx9hI8LGTw");
//        System.out.println(
//                queryAuth
//        );


//        WxOpenMaQueryAuditResult wx684b71dc51c79a94 = wxOpenComponentService.getWxMaServiceByAppid(appId).getAuditStatus(422814145L);
//        System.out.println(wx684b71dc51c79a94);


//         获取授权列表
//        WxOpenAuthorizerListResult authorizerList = wxOpenComponentService.getAuthorizerList(0, 100);
//        System.out.println(   //authorizerRefreshToken
//                authorizerList
//        );
//
//        WxOpenAuthorizerInfoResult wx49445c40059f4524 = wxOpenComponentService.getAuthorizerInfo("wx73af589ad8423f90");
//        System.out.println(   //authorizerRefreshToken
//                wx49445c40059f4524
//        );

//        WxOpenQueryAuthResult queryAuth = wxOpenComponentService.getQueryAuth("queryauthcode@@@xI6TFBs8J12vfpPZvtFgG8vbFfc2exQMY88bahsRPeJampKbXSCjfJf3J1QtBhSOaygiDoa6DjY_6Qg95okahA");
//        System.out.println(   //authorizerRefreshToken
//                queryAuth
//        );


//        List<String> list = new ArrayList<>();
//        list.add("https://sale00.qichechaoren.com");
//        list.add("https://oss1.qccr.com");
//        list.add("https://icrm.qccr.com");
//        list.add("https://sale.qccr.com");
//        WxOpenAuthorizerInfoResult authorizerInfo = wxOpenComponentService.getAuthorizerInfo(appId);
//        System.out.println(JSON.toJSONString(authorizerInfo));

//
//        String accountBasicInfo = wxOpenComponentService.getWxMaServiceByAppid(appId).getAccountBasicInfo();
//        System.out.println(accountBasicInfo);

//
//        WxOpenRegisterPersonalWeappResult wxOpenRegisterPersonalWeappResult = wxOpenComponentService.fastRegisterPersonalWeapp("温国良", "wxid_az642al9mxbs12", "13623839679");
//        System.out.println(JSON.toJSONString(wxOpenRegisterPersonalWeappResult));


        //获取所有类目
//        WxFastMaBeenSetCategoryResult category = wxOpenComponentService.getWxFastMaServiceByAppid(appId).getAccessToken();
//        System.out.println(category);


        //获取版本信息
//        WxOpenVersioninfoResult wxc2fe513a236a273a = wxOpenComponentService.getWxMaServiceByAppid(appId).getVersionInfo();
//        System.out.println(wxc2fe513a236a273a.getExpInfo());
//        System.out.println(wxc2fe513a236a273a.getReleaseInfo());

//        // 获取体验版二维码
//        File wxc2fe513a236a273a = wxOpenComponentService.getWxMaServiceByAppid(appId).getTestQrcode("", null);
//        System.out.println(wxc2fe513a236a273a);


//        WxMpConfigStorage wxMpConfigStorage = new WxMpDefaultConfigImpl();
//        WxMpService wxMpService  =new WxOpenMpServiceImpl(wxOpenComponentService,"wxc2fe513a236a273a",wxMpConfigStorage);
//        WxMpMaterialService wxMpMaterialService = new WxMpMaterialServiceImpl(wxMpService);
//        WxMediaUploadResult image = wxMpMaterialService.mediaUpload("image", new File("https://wx.qlogo.cn/mmhead/Q3auHgzwzM6wLB6HLfN7FFG13yP8cFVicvoicAJqnTMew3ibMkwNibltKw/0"));
//

//        WxMpConfigStorage wxMpConfigStorage = wxOpenConfigStorage.getWxMpConfigStorage("wx656730804c2c5291");
//        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
//        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
//
//        WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload("image", new File("20220803164431839.jpeg"));


//        String name = "12312";
//        String code = "91330183MA2J0Y4226";
//        String codeType = "1";
//        String legalPersonaWechat = "cocoasj";
//        String legalPersonaName = "沈军";
//        String componentPhone = "133656657386";
//
//        WxOpenResult wxOpenResult = wxOpenComponentService.fastRegisterWeapp(name, code, codeType, legalPersonaWechat, legalPersonaName, componentPhone);
//        System.out.println(wxOpenResult);

//        WxOpenMpService wxc2fe513a236a273a = wxOpenComponentService.getWxMpServiceByAppid("wxc2fe513a236a273a");


        //超人小程序appid : wx4a8c1f2a3f1506e3
        //wxc2fe513a236a273a

        // 上传资源

//        String ss = downloadFile("https://wx.qlogo.cn/mmhead/Q3auHgzwzM6wLB6HLfN7FFG13yP8cFVicvoicAJqnTMew3ibMkwNibltKw/0","png");
////        String ss = "/Users/shenjun/Documents/cocoa/LearnProject/Java/JavaTest/src/main/java/com/cocoa/weixin/20220803164431839.jpeg";
////        WxMaAuditMediaUploadResult wxMaAuditMediaUploadResult = wxOpenComponentService.getWxMaServiceByAppid(appId).uploadMedia(new File(ss));
//        WxMediaUploadResult mediaResult = wxOpenComponentService.getWxMaServiceByAppid(appId).getMediaService().uploadMedia("image", new File(ss));
//
//        System.out.println(
//                mediaResult
//        );
//
//        WxOpenFastMaService wxMaServiceByAppid = wxOpenComponentService.getWxFastMaServiceByAppid(appId);
//        WxOpenResult wxOpenResult = wxMaServiceByAppid.modifyHeadImage(mediaResult.getMediaId(), 0.0F, 0.0f,1.0f,1.0f);
//        System.out.println(
//                wxOpenResult
//        );


        // 上传资源 test
//        String ss = downloadFile("https://oss1.qccr.com/qccr/storemanager/2022/08/20220803164431839.jpg","gif");
//        WxMediaUploadResult image = wxOpenComponentService.getWxMaServiceByAppid(appId).getMediaService().uploadMedia("image", new File(ss));
//        System.out.println(
//                image
//        );
//        WxOpenFastMaService wxMaServiceByAppid = wxOpenComponentService.getWxFastMaServiceByAppid(appId);
//        WxOpenResult wxOpenResult = wxMaServiceByAppid.modifyHeadImage(image.getMediaId(), 0.0F, 0.0f,1.0f,1.0f);
//        System.out.println(
//                wxOpenResult
//        );


//

//        WxOpenFastMaService wxMaServiceByAppid = wxOpenComponentService.getWxFastMaServiceByAppid("wxc2fe513a236a273a");
//        WxFastMaSetNickameResult wxFastMaSetNickameResult = wxMaServiceByAppid.setNickname("数字门店", null, "bdvT97OUr_3kfUETTkD1R5oeKXOakz_g1OAhr-UE-fq18EoJhDCupxVprtI4pu_Y08QRCmRWrDBhtIft0Xa4aA", null, null);
//        System.out.println(JSON.toJSONString(wxFastMaSetNickameResult));


//        // 获取授权列表
//        WxOpenAuthorizerListResult authorizerList = wxOpenComponentService.getAuthorizerList(0, 100);
//        System.out.println(   //authorizerRefreshToken
//                authorizerList
//        );


//        WxOpenAuthorizerInfoResult wx843520c99185384f = wxOpenComponentService.getAuthorizerInfo("wx843520c99185384f");
//        System.out.println(
//                wx843520c99185384f
//        );


        //  获取app详情
//        WxOpenAuthorizerInfoResult wxc2fe513a236a273a = wxOpenComponentService.getAuthorizerInfo("wxc2fe513a236a273a");
//        System.out.println(JSON.toJSONString(wxc2fe513a236a273a));

//        // 上传图片资源
//        WxMpConfigStorage wxMpConfigStorage = new WxMpDefaultConfigImpl();
//        WxMpService wxMpService = new WxOpenMpServiceImpl(wxOpenComponentService, "wx656730804c2c5291", wxMpConfigStorage);
//        WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(WxConsts.MediaFileType.IMAGE, new File(""));
//        System.out.println(wxMediaUploadResult);


        //WxMaCodeVersionInfo versionInfo = wxService.getCodeService().getVersionInfo();

//        WxMaDefaultConfigImpl wxMaConfig = new WxMaDefaultConfigImpl();
//        wxMaConfig.setAppid("wx656730804c2c5291"); // 微信小程序的appid
//        wxMaConfig.setSecret("93e53a39ac2148424aa18c694db8ced3"); // 微信小程序的Secret
//        wxMaConfig.setToken(...); // 微信小程序消息服务器配置的token,如果程序不涉及相关功能，可以忽略
//        wxMaConfig.setAesKey(...); // 微信小程序消息服务器配置的EncodingAESKey，同上，如果不涉及，可以忽略
//        wxMaConfig.setOriginalId();
//        wxMaConfig.setAccessToken("123");

//        WxMaService wxMaService = new WxMaServiceImpl();
//        wxMaService.setWxMaConfig(wxMaConfig);
//
//
//        WxMaCodeVersionInfo versionInfo = wxMaService.getCodeService().getVersionInfo();


//        String authorizerAccessToken = wxOpenComponentService.getAuthorizerAccessToken("wx09e4e0d02bd8ff95", false);
//        System.out.println(String.format("authorizerAccessToken=%s ", authorizerAccessToken));


//        WxOpenResult wxOpenResult = wxOpenComponentService.fastRegisterWeapp(name, code, codeType, legalPersonaWechat, legalPersonaName, componentPhone);
//        System.out.println(wxOpenResult);

//        WxOpenResult wxOpenResult = wxOpenComponentService.fastRegisterWeappSearch(name, legalPersonaWechat, legalPersonaName);
//        System.out.println(wxOpenResult);

        //authType 默认写死小程序，防止商家误选公众号等， bizAppid 不传
//        String res = wxOpenComponentService.getPreAuthUrl("https://third.qccr.com","2",null);
//        System.out.println(res);


//        wxOpenComponentService.getQueryAuth()


//        WxOpenComponentService.getWxMaServiceByAppid("").getBasicService()

//        WxOpenMaService wxOpenMaService = wxOpenComponentService.getWxMaServiceByAppid("wx656730804c2c5291");
//        wxOpenMaService.getExpressService().getQuota()


//        wxOpenMaService.submitAudit()


//        WxOpenMaBasicService wxOpenMaBasicService = wxOpenMaService.getBasicService();

//        wxOpenMaService.submitAudit()


//        WxOpenComponentServiceNewImpl wxOpenComponentServiceNew1 = new WxOpenComponentServiceNewImpl(wxOpenService);
//        wxOpenComponentServiceNew1.getWxMaServiceByAppid("").getVersioninfo();


    }


    //        data.add(new WxMaSubscribeMessage.MsgData("thing1","汽车年卡"));
//        data.add(new WxMaSubscribeMessage.MsgData("thing2","汽车10次"));
//        data.add(new WxMaSubscribeMessage.MsgData("amount3","123"));
//        data.add(new WxMaSubscribeMessage.MsgData("phrase4","已付款"));
//        data.add(new WxMaSubscribeMessage.MsgData("thing5","xxx门店"));

    private static List<Integer> getKidList(String tid) {
        if ("1874".equals(tid)) {  // 服务完成
            // 1-工单状态 2-服务项目 3-日期 4-预计完工时间 5-订单编号 6-完成时间 7-服务地址 8-备注 9-服务门店 10-消费站点 11-结束时间 12-订单金额 13-原因 14-订单名称
            return Arrays.asList(5, 6, 9, 12);
        }
        if ("30602".equals(tid)) {
            //1-权益名称 2-券剩余数量 3-温馨提示 4-到期时间
            return Arrays.asList(1, 4, 3);
        }
        if ("30540".equals(tid)) {
            //1-卡名称 2-项目 3-实付金额 4-状态 5-门店名称
            return Arrays.asList(1, 2, 3, 4);
        }
        if ("675".equals(tid)) {
            //1-订单编号 2-订单金额 3-下单时间 4-温馨提示 5-车牌号 6-订单类型 7-预约时间 8-服务地址 9-取货地址 10-车型 11-下单店铺 12-订单内容 13-送货地址 14-支付方式 15-支付时间 16-支付金额 17-物品名称 18-店铺地址 19-VIN码 20-服务技师 21-服务门店 22-服务项目 23-门店地址
            return Arrays.asList(15, 21, 16, 17);
        }
        return null;
    }


}


