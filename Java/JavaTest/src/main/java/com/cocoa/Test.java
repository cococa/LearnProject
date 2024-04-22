package com.cocoa;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024 * 2];
        int len = 0;
        try {
            while ((len = is.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }

    public static void main(String[] args) throws IOException {

//        String _fileName = "http:://abadasc.cxcjpcm/aaaa.png";
//        String _extensionName = _fileName.substring(_fileName.lastIndexOf(".") + 1);
//        System.out.printf("extensionName: %s\n", _extensionName);
//
//        String a = "自卑感";
//        byte[] bytes = a.getBytes();
//        System.out.println(bytes.length);

//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("222");
//
//
//        LinkedList collect = list.stream().collect(Collectors.toCollection(LinkedList::new));
//
//
//        System.out.println(collect.peek());
//        System.out.println(collect.removeFirst());
//        System.out.println(collect.peek());
//        System.out.println(collect.removeFirst());
//        System.out.println(collect.peek());

        String url = "https://cdn.discordapp.com/attachments/1222931334259806355/1231894256206217238/mbiam45calivou_icon__with_jun_keywords_7d6d3ad0-0e88-4431-8839-fc2dd30b3150.png?ex=66277a6e&is=662628ee&hm=1141bd1b0fa8cf814fbc6a2539622f7cc12b27f49a3116d6a28daea4b280c8fa&";

        String rootDir = "/Users/shenjun/Documents/";
        String fileName = new Date().getTime() +
                ".png";
        File filePath = new File(rootDir + fileName);
        if (!filePath.exists()) {
            filePath.createNewFile();
        }

        OkHttpClient client = new OkHttpClient();
        System.out.println(url);
        Request req = new Request.Builder().url(url).build();
        okhttp3.Response resp = null;
        try {
            resp = client.newCall(req).execute();
            System.out.println(resp.isSuccessful());

            if (resp.isSuccessful()) {
                ResponseBody body = resp.body();
                InputStream is = body.byteStream();
                byte[] data = readInputStream(is);
                FileOutputStream fops = new FileOutputStream(filePath);
                fops.write(data);
                fops.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unexpected code " + resp);
        }

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "2_OXoYecQER51rTzh7RRMDySTtX2zjCkaFyNNdQA";
        String secretKey = "bZaajpEknrAcp7Lt6nnzlEAKxpOZN_vbkVUZNtlH";
        String bucket = "peppa";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "/Users/shenjun/Documents/aaaa.png";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            ex.printStackTrace();

            if (ex.response != null) {
                System.err.println(ex.response);
                try {
                    String body = ex.response.toString();
                    System.err.println(body);
                } catch (Exception ignored) {
                }
            }
        }


    }

}
