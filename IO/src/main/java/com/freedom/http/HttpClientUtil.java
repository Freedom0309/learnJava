package com.freedom.http;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtil {

    public static String parseStr(String url){
        String str = null;

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);

        try {
            CloseableHttpResponse response = client.execute(get);

            int code = response.getStatusLine().getStatusCode();


            if(code == 200){
                HttpEntity entity = response.getEntity();

                str = EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
