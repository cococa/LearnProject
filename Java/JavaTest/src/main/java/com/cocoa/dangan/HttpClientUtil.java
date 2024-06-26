package com.cocoa.dangan;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
public class HttpClientUtil {


    public String doPost(String url, String json, String charset)
    {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try
        {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            StringEntity se = new StringEntity(json,"UTF-8");
            se.setContentType("application/json");
            se.setContentEncoding(new BasicHeader("text/json", "application/json"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null)
            {
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null)
                {
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }
}
