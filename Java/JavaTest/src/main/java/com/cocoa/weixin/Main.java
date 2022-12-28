package com.cocoa.weixin;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaAuditMediaUploadResult;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeVersionInfo;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpMaterialServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import me.chanjar.weixin.mp.config.impl.WxMpMapConfigImpl;
import me.chanjar.weixin.open.api.*;
import me.chanjar.weixin.open.api.impl.*;
import me.chanjar.weixin.open.bean.result.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
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
        Byte b = new Byte("1");
        Byte a = new Byte("1");

        System.out.println(a.equals(b));

        String jss = "{name:\"ccccc\"}";
        Object js = JSON.toJSON(jss);
        System.out.println(JSON.toJSONString(js));




        WxOpenConfigStorage wxOpenConfigStorage = new WxOpenInMemoryConfigStorage();
        wxOpenConfigStorage.setComponentAppId("wx656730804c2c5291");
        wxOpenConfigStorage.setComponentAppSecret("93e53a39ac2148424aa18c694db8ced3");
        wxOpenConfigStorage.setComponentVerifyTicket("ticket@@@OY6bY6ct4x84Me8yxo_5RxhWCBYDmWhVLdXSpx5BdfFKveYDBedfhcrpUvpsRHVAstH9BpJ4ih0jsGZFfJ8emw");


        WxOpenService wxOpenService = new WxOpenServiceImpl();


        wxOpenService.setWxOpenConfigStorage(wxOpenConfigStorage);


        WxOpenComponentService wxOpenComponentService = new WxOpenComponentServiceImpl(wxOpenService);

        String appId = "wx68c591be932fa3b0";
        boolean isExpired = wxOpenComponentService.getWxOpenConfigStorage().isAuthorizerAccessTokenExpired(appId);
        if (true || isExpired) {
            WxOpenAuthorizerInfoResult wxc2fe513a236a273a = wxOpenComponentService.getAuthorizerInfo(appId);
            String authorizerRefreshToken = wxc2fe513a236a273a.getAuthorizationInfo().getAuthorizerRefreshToken();
            System.out.println(wxc2fe513a236a273a);
            wxOpenComponentService.getWxOpenConfigStorage().setAuthorizerRefreshToken(appId, authorizerRefreshToken);
        }

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
}
