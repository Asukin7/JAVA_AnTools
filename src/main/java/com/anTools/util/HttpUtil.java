package com.anTools.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

    public static String doGet(String url) {
        //1.创建一个CloseableHttpClient的实例
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        //2.创建一个HttpGet请求实例
        HttpGet httpGet = new HttpGet(url);
        //请求的响应
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            //3.使用CloseableHttpClient的实例执行get请求
            closeableHttpResponse = closeableHttpClient.execute(httpGet);
            //请求的状态: 200 404 500
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {//请求成功 200
                HttpEntity entity = closeableHttpResponse.getEntity();
                String result = EntityUtils.toString(entity, "UTF-8");
                return result;
            } else {//请求失败 other
                System.out.println("[HttpUtil] - 请求失败statusCode: " + statusCode);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JSONObject code2Session(String code) {
        JSONObject jsonObject = JSONObject.parseObject("{'message': 'Error',}");
        jsonObject = JSONObject.parseObject(doGet("https://api.weixin.qq.com/sns/jscode2session?appid=wx4d29257ff29de851&secret=1e17bdcea1a00407a083b74de2395e83&js_code=" + code + "&grant_type=authorization_code"));
        System.out.println("[HttpUtil] - code2Session: " + jsonObject);
        return jsonObject;
    }

}
