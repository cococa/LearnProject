package com.cocoa;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author chenjinlong
 */
@Slf4j
public class HttpUtils {
    private static final CloseableHttpClient httpClient;
    private static final RequestConfig requestConfig;
    private static final String ENCODING = Consts.UTF_8.name();

    static {
        try {
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

            ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Consts.UTF_8).build();
            connManager.setDefaultConnectionConfig(connectionConfig);

            connManager.setMaxTotal(300);// 最大连接数
            connManager.setDefaultMaxPerRoute(300);// 路由最大连接数

            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            connManager.setDefaultSocketConfig(socketConfig);

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();

            httpClient = HttpClients.custom().setConnectionManager(connManager)
                    .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext)).build();

            requestConfig = RequestConfig.custom()
                    // 获取manager中连接 超时时间 0.5s
                    .setConnectionRequestTimeout(2500)
                    // 连接服务器 超时时间 1.5s
                    .setConnectTimeout(3500)
                    // 服务器处理 超时时间 3s
                    .setSocketTimeout(8000).build();
        } catch (Exception e) {
            throw new RuntimeException("创建httpClient失败", e);
        }
    }

    public static final String simpleGet(final String addr) {
        HttpGet get = new HttpGet(addr);
        CloseableHttpResponse response = null;
        try {
            get.setConfig(requestConfig);
            response = httpClient.execute(get);
            // 成功
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), ENCODING);
            }
        } catch (Exception e) {
//           //log.error("invoke target error", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
//               //log.error("response close error", e);
            }
        }
        return null;
    }

    public static final String simplePost(final String body, final String url) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost(url);
        post.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity entity = new StringEntity(body, ENCODING);
        post.setEntity(entity);
        entity.setContentType("text/json");
        CloseableHttpResponse response = null;
        try {
            post.setConfig(requestConfig);
            response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {// 成功

                return EntityUtils.toString(response.getEntity(), ENCODING);
            }
        } catch (Exception e) {
           //log.error("invoke post error", e);
        } finally {
            try {
                if (response != null) {
                        response.close();
                    }
            } catch (IOException e) {
               //log.error("response close error", e);
            }
        }
        return null;
    }

    /**
     * 根据传入的HttpPost/HttpGet发起请求
     *
     * @param request
     * @return 正常返回结果字符串，200以外状态码或异常返回null
     */
    public static final String excute(final HttpRequestBase request) {
        CloseableHttpResponse response = null;
        try {
            request.setConfig(requestConfig);
            response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {// 成功
                return EntityUtils.toString(response.getEntity(), ENCODING);
            }
        } catch (Exception e) {
           //log.error("invoke post error", e);
        } finally {
            try {
                if (response != null){
                    response.close();
                }
            } catch (IOException e) {
               //log.error("response close error", e);
            }
        }
        return null;
    }



}
