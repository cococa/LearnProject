package com.cocoa.weixin;

import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.impl.WxCpDefaultConfigImpl;
import me.chanjar.weixin.open.api.WxOpenComponentService;
import me.chanjar.weixin.open.api.impl.WxOpenComponentServiceImpl;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;


public class CPMain {
    public static void main(String[] args) throws Exception {


        WxCpDefaultConfigImpl wxCpDefaultConfig = new WxCpDefaultConfigImpl();
        wxCpDefaultConfig.setAgentId(1);
        wxCpDefaultConfig.setCorpId("");

        WxCpService wxCpService = new WxCpServiceImpl();


        wxCpService.setWxCpConfigStorage(wxCpDefaultConfig);



        wxCpService.getAgentService()


        WxOpenComponentService wxOpenComponentService = new WxOpenComponentServiceImpl(wxOpenService);

        String appId = "wx54c64fcc401892c0";
        boolean isExpired = wxOpenComponentService.getWxOpenConfigStorage().isAuthorizerAccessTokenExpired(appId);
        if (true || isExpired) {
            WxOpenAuthorizerInfoResult wxc2fe513a236a273a = wxOpenComponentService.getAuthorizerInfo(appId);
            String authorizerRefreshToken = wxc2fe513a236a273a.getAuthorizationInfo().getAuthorizerRefreshToken();
            System.out.println(authorizerRefreshToken);
            wxOpenComponentService.getWxOpenConfigStorage().setAuthorizerRefreshToken(appId, authorizerRefreshToken);
        }


    }
}
