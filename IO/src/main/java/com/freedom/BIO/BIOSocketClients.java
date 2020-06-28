package com.freedom.BIO;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author: liufeng
 * @version: v1.0 2020/6/19 18:35
 * @since: v1.0
 */
public class BIOSocketClients {

    public void initBIOClient(String host, int port) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        Socket socket = null;
        String inputContent;
        int count = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(host, port);

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("clientSocket started: " + stringNowTime());
            while (((inputContent = reader.readLine()) != null) && count < 2) {
                inputContent = stringNowTime() + ": 第" + count + "条消息: " + inputContent + "\n";
                writer.write(inputContent);//将消息发送给服务端
                writer.flush();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String stringNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static void main(String[] args) {
        BIOSocketClients client = new BIOSocketClients();
        client.initBIOClient("127.0.0.1", 8888);
    }
}
