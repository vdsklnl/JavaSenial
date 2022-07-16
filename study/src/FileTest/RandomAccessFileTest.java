package FileTest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author vdsklnl
 * @create 2022-04-23 17:02
 * @Description 对象流的应用
 */

public class RandomAccessFileTest {

    // 文件插入数据
    @Test
    public void test() {

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello1.txt","rw");

            // 指定指针位置
            raf.seek(15);
            // 将后面需保存数据存入数组
            StringBuilder str = new StringBuilder((int) new File("hello1.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf.read(buffer)) != -1) {
                str.append(new String(buffer,0,len));
            }

            // 调回指针位置
            raf.seek(15);
            raf.write(" That I will merry you!".getBytes());

            // 写入str中保存的数据（此时指针位置就是加入数据之后，不用更改）
            raf.write(str.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 文件插入数据(ByteArrayOutputStream替代StringBuilder)
    @Test
    public void test1() {

        RandomAccessFile raf = null;
        ByteArrayOutputStream baos = null;
        try {
            raf = new RandomAccessFile("hello1.txt","rw");
            baos = new ByteArrayOutputStream();

            // 指定指针位置
            raf.seek(15);
            // ByteArrayOutputStream写入缓冲区
            byte[] buffer = new byte[(int) new File("hello1.txt").length()];
            int len;
            while ((len = raf.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }

            // 调回指针位置
            raf.seek(15);
            raf.write(" That I will merry you!".getBytes());

            // 写入baos中保存的数据（此时指针位置就是加入数据之后，不用更改）
            raf.write(baos.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
