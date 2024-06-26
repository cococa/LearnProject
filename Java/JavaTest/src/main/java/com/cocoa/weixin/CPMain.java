package com.cocoa.weixin;

import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.bean.WxCpTpDepart;
import me.chanjar.weixin.cp.bean.WxCpUser;
import me.chanjar.weixin.cp.bean.license.WxCpTpLicenseAccountCount;
import me.chanjar.weixin.cp.bean.license.WxCpTpLicenseAccountDuration;
import me.chanjar.weixin.cp.bean.license.order.WxCpTpLicenseCreateOrderResp;
import me.chanjar.weixin.cp.bean.license.order.WxCpTpLicenseNewOrderRequest;
import me.chanjar.weixin.cp.config.impl.WxCpTpDefaultConfigImpl;
import me.chanjar.weixin.cp.tp.service.WxCpTpDepartmentService;
import me.chanjar.weixin.cp.tp.service.WxCpTpLicenseService;
import me.chanjar.weixin.cp.tp.service.WxCpTpUserService;
import me.chanjar.weixin.cp.tp.service.impl.WxCpTpServiceImpl;

import java.lang.reflect.Field;
import java.util.List;


public class CPMain {
    public static void main(String[] args) throws Exception {


//        WxCpTpDefaultConfigImpl wxCpTpConfigStorage = new WxCpTpDefaultConfigImpl();
//        wxCpTpConfigStorage.setSuiteId();
//
//        WxCpTpServiceApacheHttpClientImpl wxCpTpServiceApacheHttpClient = new WxCpTpServiceApacheHttpClientImpl();
//        wxCpTpServiceApacheHttpClient.setWxCpTpConfigStorage(wxCpTpConfigStorage);
//        String preAuthUrl = wxCpTpServiceApacheHttpClient.getPreAuthUrl("", "");


        WxCpTpDefaultConfigImpl wxCpTpConfigStorage = new WxCpTpDefaultConfigImpl();
        wxCpTpConfigStorage.setCorpId("ww5c3411f2eb07755b");
        wxCpTpConfigStorage.setCorpSecret("rsxgU0XcoztVtkN-AIF3jAPY1ZKgrPBomTTh1NcUfJg");
        wxCpTpConfigStorage.setToken("bDNrVMZZeL");
        wxCpTpConfigStorage.setAesKey("dpWRzVw2Ma21Mr5G9KFRwicat0tSN8Y5rp7D4Gzcin5");
        wxCpTpConfigStorage.setSuiteId("ww8c9af5748d66b63c");
        wxCpTpConfigStorage.setSuiteSecret("rsxgU0XcoztVtkN-AIF3jAPY1ZKgrPBomTTh1NcUfJg");


        try {
            Field field = WxCpTpDefaultConfigImpl.class.getDeclaredField("providerSecret");
            field.setAccessible(true);
            field.set(wxCpTpConfigStorage, "Jss8OpYHJJsZJewROL99s8bt_auFtdecBeV97LkXNiiMnBvncsA2GbM9jbMU3ciP");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

//        wxCpTpConfigStorage
//        wxCpTpConfigStorage.setSuiteTicket("IEf3nTf_AqKpUdG2eevNLpQFvmVJBjnGr-nCT31LobGxXd5zKzqG901DyleKC_a-");
//        wxCpTpConfigStorage.setSuiteAccessToken("sl3CUykCqwo5rtl8nRppqJ-LtUXSZ5RQ-S060LmczxNZuRbwZhsw5vYy2IJKtK4eGeR7rRWSXGUQHpQt74fzWve6bwaLJCkQCXc9gcFyZ70X1C48KtpH-J-YWqxpy9RK7AulST3oR2LThXhkyXrwET1ZhFWcI_fGRICJLEI07ITqayPdb9Wf9Bw7tWpsLzvwVL6vzTmlc_FvHdfT9kVypw");


        WxCpTpServiceImpl wxCpTpService = new WxCpTpServiceImpl();
        wxCpTpService.setWxCpTpConfigStorage(wxCpTpConfigStorage);
        wxCpTpService.setSuiteTicket("IEf3nTf_AqKpUdG2eevNLkrR6UkUy0w61snxkGEBzMLF-LMVNmbVKqXiLy7G5JAs");
//        wxCpTpService.setS

//        'Mc4GngArVlU02PoaR2cEXVedRvrCthPx44NsuCXDeV0', 'ww5c3411f2eb07755b',
//        final String corpId = "ww5c3411f2eb07755b";
//        authCorpId=wphn_jEQAAFYhwvqH5dRVyvOGzi4QeYg&permanentCode=f42GZcNXEIkbyljM1lJyRdR0Xmx1DakiaNWpsStONus
//        WxAccessToken wxAccessToken = wxCpTpService.getCorpToken(corpId, "YKQscuLdp36jGdbZbYFCg1dTU1YnEcpuCIqUX_f9y1Q", true);
//        System.out.println(wxAccessToken);
//        System.out.println("----------");

//        WxCpTpUserService wxCpTpUserService = wxCpTpService.getWxCpTpUserService();
//        List<WxCpUser> wxCpUsers = wxCpTpUserService.listByDepartment(1L, true, null, corpId);
//        System.out.println(wxCpUsers);
//        oRs-c5n_tgJVvgOf3tQyypMoUPW8
//        idconvert/unionid_to_external_userid
//        WxCpTpUnionidToExternalUseridResult wxCpTpUnionidToExternalUseridResult = wxCpTpService.getWxCpTpIdConverService()
//                .unionidToExternalUserid(corpId,"oRs-c5n_tgJVvgOf3tQyypMoUPW8", "oURuJ1EbYPi3zyAJfZhQFWZmZSDM", null);
//        System.out.println(wxCpTpUnionidToExternalUseridResult.getExternalUserid());
        String cropId= "wphn_jEQAAFYhwvqH5dRVyvOGzi4QeYg";


//        8ucI4h_2_DxXSbO03naqEMezHCscpJe2JdX1Yd91zLg

        WxAccessToken corpToken = wxCpTpService.getCorpToken(cropId, "NNr07pL8Ck7-j21-h6GAn8AxzNFKp_HeF3NgNyMu2-c", true);

//        String suiteAccessToken = wxCpTpService.getSuiteAccessToken();
//        System.out.println(suiteAccessToken);
//        wxCpTpConfigStorage.setSuiteAccessToken(suiteAccessToken);
//        wxCpTpConfigStorage.updateAccessToken(cropId,suiteAccessToken,3600);


//        WxCpTpDepartmentService wxCpTpDepartmentService = wxCpTpService.getWxCpTpDepartmentService();
//        List<WxCpTpDepart> list = wxCpTpDepartmentService.list(cropId);
//        System.out.println(list);
//        System.out.println("----------");



//        wxCpTpService.

        WxCpTpDepartmentService wxCpTpDepartmentService = wxCpTpService.getWxCpTpDepartmentService();
        List<WxCpTpDepart> list = wxCpTpDepartmentService.list(null, cropId);
        System.out.println(list);


        list.forEach(item->{

        WxCpTpUserService wxCpTpUserService = wxCpTpService.getWxCpTpUserService();
            try {
                List<WxCpUser>   wxCpUsers = wxCpTpUserService.listByDepartment(item.getId().longValue(), true, null, cropId);
                System.out.println(wxCpUsers);
            } catch (WxErrorException e) {
                throw new RuntimeException(e);
            }

        });

        WxCpTpLicenseNewOrderRequest wxCpTpLicenseNewOrderRequest = new WxCpTpLicenseNewOrderRequest();
        wxCpTpLicenseNewOrderRequest.setCorpId(cropId);
        wxCpTpLicenseNewOrderRequest.setBuyerUserId("03569");


        WxCpTpLicenseAccountCount wxCpTpLicenseAccountCount = new WxCpTpLicenseAccountCount();
        wxCpTpLicenseAccountCount.setBaseCount(1);
        wxCpTpLicenseAccountCount.setExternalContactCount(null);
        wxCpTpLicenseNewOrderRequest.setAccountCount(wxCpTpLicenseAccountCount);

        WxCpTpLicenseAccountDuration wxCpTpLicenseAccountDuration = new WxCpTpLicenseAccountDuration();
        wxCpTpLicenseAccountDuration.setMonths(1);
        wxCpTpLicenseNewOrderRequest.setAccountDuration(wxCpTpLicenseAccountDuration);

        WxCpTpLicenseService wxCpTpLicenseService = wxCpTpService.getWxCpTpLicenseService();

        WxCpTpLicenseCreateOrderResp newOrder = wxCpTpLicenseService.createNewOrder(wxCpTpLicenseNewOrderRequest);



        //createJsapiSignature
//        WxJsapiSignature authCorpJsApiTicketSignature = wxCpTpService.createAuthCorpJsApiTicketSignature("", "");


//        String userId = wxCpTpUserService.getUserId("13656657386");
//        System.out.println(userId);
//        System.out.println("----------");


//        WxCpTpUserInfo userInfo3rd = wxCpTpService.getUserInfo3rd("5vKOk9--1FdwV-ieTQP1y_PzV0JSJGQ68Y3lD5JtjkU");
//        System.out.println(userInfo3rd);
//        System.out.println("----------");


//        WxCpTpDepartmentService wxCpTpDepartmentService = wxCpTpService.getWxCpTpDepartmentService();
//        List<WxCpTpDepart> list = wxCpTpDepartmentService.list("wphn_jEQAAFYhwvqH5dRVyvOGzi4QeYg");
//        System.out.println(list);
//        System.out.println("----------");
//        wohn_jEQAAkAhmQsF9Mx1RV_QrG5Re6A     32


//        WxCpTpUserInfo userInfo3rd = wxCpTpService.getUserInfo3rd("RyRX5nyGT5c7JuTElx2klu_eMbcp_nrOTQ679Mk0vD0");
//        System.out.println(userInfo3rd);
//        System.out.println("----------");
//
//        WxCpTpUserService wxCpTpUserService = wxCpTpService.getWxCpTpUserService();
//        WxCpUser byId = wxCpTpUserService.getById(userInfo3rd.getUserId(), userInfo3rd.getCorpId());
//        System.out.println(byId);
//        System.out.println("----------");


//        WxCpTpUserService wxCpTpUserService = wxCpTpService.getWxCpTpUserService();
//        String userId = wxCpTpUserService.getUserId("13623839679");
//        System.out.println(userId);
//        System.out.println("----------");
//        WxCpService wxCpService = new WxCpServiceImpl();
//
//
//        wxCpService.setWxCpConfigStorage(wxCpDefaultConfig);

//        WxOpenComponentService wxOpenComponentService = new WxCpServiceImpl(wxCpService);

//        wxCpDefaultConfig.


//        String appId = "wx54c64fcc401892c0";
//        boolean isExpired = wxOpenComponentService.getWxOpenConfigStorage().isAuthorizerAccessTokenExpired(appId);
//        if (true || isExpired) {
//            WxOpenAuthorizerInfoResult wxc2fe513a236a273a = wxOpenComponentService.getAuthorizerInfo(appId);
//            String authorizerRefreshToken = wxc2fe513a236a273a.getAuthorizationInfo().getAuthorizerRefreshToken();
//            System.out.println(authorizerRefreshToken);
//            wxOpenComponentService.getWxOpenConfigStorage().setAuthorizerRefreshToken(appId, authorizerRefreshToken);
//        }


//        wxOpenComponentService.


    }
}
