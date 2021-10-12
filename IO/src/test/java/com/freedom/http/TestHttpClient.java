package com.freedom.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class TestHttpClient {

    @Test
    public void test(){
        DefaultHttpClient client = new DefaultHttpClient();

        String url = "https://www.baidu.com/";
//        String url = "http://localhost:8888/subject/selectOne?id=1";

        HttpGet get = new HttpGet(url);

        try {
            HttpResponse httpResponse = client.execute(get);

            StatusLine line = httpResponse.getStatusLine();


            int code = line.getStatusCode();

            if(code == 200){

                HttpEntity entity = httpResponse.getEntity();

                byte[] toByteArray = EntityUtils.toByteArray(entity);

                System.out.println(EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testHttpClientUtils(){
        String str = HttpClientUtil.parseStr("http://localhost:8888/subject/selectOne?id=1");

        System.out.println(str);
    }
}
