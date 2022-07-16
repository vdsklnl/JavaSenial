package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author vdsklnl
 * @create 2022-04-21 20:33
 * @Description
 */

public class FileReaderWriterTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        File file1 = new File("hello.txt");
        try {
            System.out.println(file1.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file1,true);
            fw.write("I have a dream!\n");
            fw.write("You have a dream too!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // File类对象创建
//        File srcFile = new File("hello.txt");
        FileReader fr1 = null;
        FileWriter fw1 = null;
        try {
            File destFile = new File("hello1.txt");

            // IO流资源创建
            fr1 = new FileReader(file1);
            fw1 = new FileWriter(destFile);

            // 复制操作
            int len;
            char[] cbuf = new char[5];
            while((len = fr1.read(cbuf)) != -1){
                fw1.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 流资源关闭
            try {
                if(fw1 != null)
                    fw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr1 != null)
                    fr1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
