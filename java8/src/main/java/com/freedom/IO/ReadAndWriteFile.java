package com.freedom.IO;

import java.io.*;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 13:08 2017/12/26
 * @Modified By:
 **/
public class ReadAndWriteFile {


    /**
     * 读取txt文件中的某一行的内容
     * @param number
     */
    public void readLineFromTxt(int number){

        long startTime = System.currentTimeMillis();
        try {
            //文件的路径
            File file = new File("D:\\input.txt");
            //将文件放入FileReader流中
            FileReader reader = new FileReader(file);
            //一行一行的进行读取
            LineNumberReader lineNumberReader = new LineNumberReader(reader);
            String txt = "";
            int lines = 0;
            while (txt != null) {
                lines++;
                //读取一行的内容
                txt = lineNumberReader.readLine();
                if (lines == number) {
                    System.out.println("No." + lineNumberReader.getLineNumber() + " the context is " + txt + "\n");
                    long endTime = System.currentTimeMillis();
                    System.out.println("total read time is : " + (endTime - startTime) + "ms");
                    System.exit(0);
                }
            }
            //关闭输入流
            lineNumberReader.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
    }

    /**
     * 向文件中写数据
     * @param fileName
     */
    public void writeToTxt(File fileName){

        try {
            //文件的路径
//            File fileName = new File("D:\\output.txt");
            //创建一个文件
            fileName.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            //将内容写入文件
            out.write("this is my world\r\n");
            //将缓存区的内容压入文件
            out.flush();
            //关闭文件
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void readAndWriteToTxt(String oldFileName, String newFileName){
//        try {
//            File oldName = new File(oldFileName);
//            File newName = new File(newFileName);
//            if (!newName.exists()) {
//                newName.createNewFile();
//            }
//            FileOutputStream fileOutputStream = new FileOutputStream(newName);
//            RandomAccessFile randomAccessFile = new RandomAccessFile(oldName, "rw");
////            Byte buf[] = randomAccessFile.read(new byte[8]);
//            fileOutputStream.write(randomAccessFile.read(new byte[8]));
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            randomAccessFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
