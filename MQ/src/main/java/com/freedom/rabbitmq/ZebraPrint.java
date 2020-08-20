package com.freedom.rabbitmq;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Copyright: Copyright (c) 2020 TD
 *
 * <p> Description:
 *
 * @author liufeng
 * @version 2020/8/18 9:17
 * @since
 */
public class ZebraPrint {
    public static void main(String[] args) throws Exception {
        String host = "10.17.50.105";
        host = "localhost";
        // The line below illustrates the default port
        // 6101 for mobile printers 9100 is the default host number
        // for desktop and tabletop printers
        Socket clientSocket = new Socket(host, 6101);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //The data being sent in the lines below illustrate CPCL  one can change the data for the corresponding
        //language being used (ZPL, EPL)

        outToServer.writeBytes("! 0 200 200 203 1" + 'n' + "CENTER" + 'n');
        outToServer.writeBytes("TEXT 0 3 10 50 JAVA TEST" + 'n' + "PRINT" + 'n');

        clientSocket.close();
    }
}
