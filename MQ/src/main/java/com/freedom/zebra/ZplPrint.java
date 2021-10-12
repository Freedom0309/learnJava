package com.freedom.zebra;

import javax.print.*;
import javax.print.attribute.standard.PrinterName;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;


public class ZplPrint {
    private String printerURI = null;//打印机完整路径
    private PrintService printService = null;//打印机服务
    //GB18030 ^CW1,E:SIMSUN.FNT  ARLRDBD.TTF SIMHEI
    private String begin = "^XA^SEE:GB18030.DAT^CWA,R:SIMHEI.FNT^PMN^MNY^MMT^MTD^MD20^LH10,10^JMA"; //标签格式以^XA开始
    private String end = "^XZ"; //标签格式以^XZ结束
    private String content = "";
    private int cnCharSize = 30;//中文字体大小？ 25
    private int charSize = 26;//英文字体高度？
    private int charSep = 15;//英文字体大小？
    private int lineSep = 10;//行间距？
    //打印纸宽度 x
    private int width = 500;
    //打印纸高度 y
    //小纸张 
    private int height = 400;
    //  private int height = 750;
    private int lableLength = 4 * cnCharSize;
    //label的起始位置
    private int labelx = 50;
    private int labely = 20;
    //条形码起始的x
    private int bqx = 105;
    //条形码起始的y
    private int bqy = height / 2 + 60;
    //底部内容起始的x
    private int bottomx = bqx - 30;
    //底部内容起始的y
    private int bottomy = 20;

    public void execute(LabelMessage message) {
        this.init("ZDesigner GT800 (ZPL)");
//        o.setMachineName("");
        // F0 x坐标，y坐标
        //BQ 二维码
//        String qrcode_t = "^FO%s,%s^BY3^B1N,N,100,Y,N^CI0^FD${data}^FS";
        String qrcode_t = "^FO%s,%s^BY3^BCN,100,Y,N,N^FD${data}^FS";
        qrcode_t = String.format(qrcode_t, bqx, bqy);//二维码位置
        this.setBarcode(message.getNumber(), qrcode_t);//设置二维码的内容
        //FW控制字体方向   N   R  I  B  和setCharR中的A0R的R，A1R的R
        content += "^FWN";
        int[] xy = new int[]{labelx, labely};
        //起始   100，50
        xy = setLabelTitle(this, xy, "陕西省农村信用社联合社");
        xy = setLabelValue(this, xy, "资产编号:", message.getNumber());
        xy = setLabelValue(this, xy, "资产名称:", message.getName());
        xy = setLabelValue(this, xy, "规格型号:", message.getType());
        xy = setLabelValue(this, xy, "启用时间:", LocalDate.now().toString());
        xy = setLabelValueNoWrapLine(this, xy, "领用人:", message.getOwnerName());
        xy = setLabelValue(this, xy, "存放地点:", message.getAddress());
        xy = setLabelValueNoWrapLine(this, xy, "使用部门:", message.getDepartment());
        content += "^CI0^PQ1";//打印1张

        String zpl2 = this.getZpl();
        System.out.println("zpl:" + zpl2);
        this.print(zpl2);
    }

    /**
     * 设置标签公司名
     * @param p
     * @param xy
     * @param company
     * @return
     */
    private int[] setLabelTitle(ZplPrint p, int[] xy, String company) {
        xy[0] = labelx;
        xy = p.setTitle(company, xy);
        xy[1] += cnCharSize + lineSep * 5;
        return xy;
    }

    private int[] setLabelValue(ZplPrint p, int[] xy, String label1, String value1) {
        xy[0] = labelx;
        xy = p.setText(label1, xy);
        xy[0] = labelx + lableLength - 10;
        xy = p.setText(value1, xy);
        xy[1] += cnCharSize;
        return xy;
    }

    private int[] setLabelValueNoWrapLine(ZplPrint p, int[] xy, String label1, String value1) {
        xy[0] = xy[0] + lableLength / 2 - 40;
        xy[1] -= cnCharSize;
        xy = p.setText(label1, xy);
        xy[0] += labelx - 50;
        xy = p.setText(value1, xy);
        xy[1] += cnCharSize;
        return xy;
    }

    private int[] setBottomLabelValue(ZplPrint p, int[] xy, String label1, String value1) {
        xy[1] = labely;
        xy = p.setText(label1, xy);
        xy[1] = labely + 180;
        xy = p.setText(value1, xy);
        xy[0] += cnCharSize + lineSep;
        return xy;
    }

    /**
     * 构造方法
     *
     * @param printerURI 打印机路径
     */
    private void init(String printerURI) {
        this.printerURI = printerURI;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        if (services != null && services.length > 0) {
            for (PrintService service : services) {
                if (printerURI.equals(service.getName())) {
                    printService = service;
                    break;
                }
            }
        }
        if (printService == null) {
            System.out.println("没有找到打印机：[" + printerURI + "]");
            //循环出所有的打印机  
            if (services != null && services.length > 0) {
                System.out.println("可用的打印机列表：");
                for (PrintService service : services) {
                    System.out.println("[" + service.getName() + "]");
                }
            }
        } else {
            System.out.println("找到打印机：[" + printerURI + "]");
            System.out.println("打印机名称：[" + printService.getAttribute(PrinterName.class).getValue() + "]");
        }
    }

    /**
     * 设置条形码
     *
     * @param barcode 条码字符
     * @param zpl     条码样式模板
     */
    private void setBarcode(String barcode, String zpl) {
        content += zpl.replace("${data}", barcode);
    }

    private boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return true;//英文
        } else {
            return false;//中文
        }
    }

    private int[] setText(String str, int[] xy) {
        int x = xy[0];
        int y = xy[1];
        if (str != null) {
            char[] charArray = str.toCharArray();
            int initX = x;
            for (int off = 0; off < charArray.length; ) {
                char c = charArray[off];
                if (!checkChar(c)) {//判断中英文  英true  中false
                    setCharR(String.valueOf(c), x, y, true);
                    x = x + cnCharSize - 5;
                } else {
                    setCharR(String.valueOf(c), x, y, false);
                    x = x + charSep;
                }

                if (x >= width + 180) {
                    x = initX;
                    y -= charSize + lineSep;
                }
                off++;
            }
        }

        return new int[]{x, y};
    }

    private int[] setTitle(String str, int[] xy) {
        int titleCharSize = 45;
        int x = xy[0];
        int y = xy[1];
        if (str != null) {
            char[] charArray = str.toCharArray();
            int initX = x;
            for (int off = 0; off < charArray.length; ) {
                char c = charArray[off];
                if (!checkChar(c)) {//判断中英文  英true  中false
                    setChar(String.valueOf(c), x, y, true, titleCharSize);
                    x = x + titleCharSize;
                } else {
                    setChar(String.valueOf(c), x, y, false, titleCharSize);
                    x = x + charSep;
                }

                if (x >= width + 180) {
                    x = initX;
                    y -= charSize + lineSep;
                }
                off++;
            }
        }

        return new int[]{x, y};
    }

    /**
     * 字符串(包含数字)
     *
     * @param str 字符串
     * @param x   x坐标
     * @param y   y坐标
     * @param h   高度
     * @param w   宽度
     */
    private void setChar(String str, int x, int y, int h, int w) {
        content += "^FO" + x + "," + y + "^A0," + h + "," + w + "^FD" + str + "^FS";
    }

    /**
     * 字符(包含数字)顺时针旋转90度
     *
     * @param str 字符串
     * @param x   x坐标
     * @param y   y坐标
     * @param cn  是否为中文
     */
    private void setCharR(String str, int x, int y, boolean cn) {
        if (cn) {
            //中文
            content += "^CI14";
            content += "^FO" + x + "," + y + "^A1," + cnCharSize + "," + cnCharSize + "^FD" + str + "^FS";
        } else {
            content += "^CI0";
            content += "^FO" + x + "," + y + "^A0," + charSize + "," + charSize + "^FD" + str + "^FS";
        }

    }

    private void setChar(String str, int x, int y, boolean cn, int charSize) {
        if (cn) {
            //中文
            content += "^CI14";
            content += "^FO" + x + "," + y + "^A1," + charSize + "," + charSize + "^FD" + str + "^FS";
        } else {
            content += "^CI0";
            content += "^FO" + x + "," + y + "^A0," + charSize + "," + charSize + "^FD" + str + "^FS";
        }

    }

    /**
     * 获取完整的ZPL
     *
     * @return
     */
    private String getZpl() {
        return begin + content + end;
    }

    /**
     * 重置ZPL指令，当需要打印多张纸的时候需要调用。
     */
    private void resetZpl() {
        begin = "^XA";
        end = "^XZ";
        content = "";
    }

    /**
     * 打印
     *
     * @param zpl 完整的ZPL
     */
    private boolean print(String zpl) {
        if (printService == null) {
            System.out.println("打印出错：没有找到打印机：[" + printerURI + "]");
            return false;
        }
        DocPrintJob job = printService.createPrintJob();
        byte[] by = null;
        try {
            by = zpl.getBytes("GB18030");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(by, flavor, null);
        try {
            job.print(doc, null);
            System.out.println("已打印");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}