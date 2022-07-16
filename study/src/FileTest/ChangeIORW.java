package FileTest;

import org.junit.Test;

import java.io.*;

/**
 * @author vdsklnl
 * @create 2022-04-22 16:47
 * @Description 转换流
 */

public class ChangeIORW {
    @Test
    public void test() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 字节流
            FileInputStream fis = new FileInputStream("dbcp.txt");
            FileOutputStream fos = new FileOutputStream("dbcp_gbk.txt");
            //处理流
            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");
            //具体操作
            int len;
            char[] cbuf =new char[20];
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
