package com.freedom.IO;

import org.junit.Test;

import java.io.File;

/**
 * @Author: Allen Liu
 * @Description:
 * @Date: Created in 13:12 2017/12/26
 * @Modified By:
 **/
public class ReadAndWriteFileTest {

    @Test
    public void readLineFromTxtTest(){
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.readLineFromTxt(3);
    }

    @Test
    public void writeToTxtTest(){
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        File filename = new File("D:\\output.txt");
        readAndWriteFile.writeToTxt(filename);
    }

//    @Test
//    public void readAndWriteToTxtTest(){
//        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//        String oldName = "D:\\input.txt";
//        String newName = "D:\\output.txt";
//        readAndWriteFile.readAndWriteToTxt(oldName,newName);
//    }
}
