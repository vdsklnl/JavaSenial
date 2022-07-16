package FileTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author vdsklnl
 * @create 2022-04-21 21:34
 * @Description
 */

public class FileIOStreamTest {

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 文件资源
            File srcFile = new File("beauty.jpg");
            File destFile = new File("beauty1.jpg");

            // IO流资源
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制操作
            int len;
            byte[] buffer = new byte[5];
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // IO流资源关闭
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
