package FileTest;

import org.junit.Test;

import java.io.*;

/**
 * @author vdsklnl
 * @create 2022-04-21 22:05
 * @Description
 */

public class BufferedTest {
    @Test
    public void speed() {
        File srcFile = new File("copyvideo.avi");
        File destIOFile = new File("copyvideo1.avi");
        File destBufferedFile = new File("copyvideo2.avi");

        long startIO = System.currentTimeMillis();
        copyIO(srcFile, destIOFile);
        long endIO = System.currentTimeMillis();

        long startBuffered = System.currentTimeMillis();
        copyBuffered(srcFile, destBufferedFile);
        long endBuffered = System.currentTimeMillis();

        System.out.println((endIO - startIO) + "----" + (endBuffered - startBuffered));
    }

    public void copyIO(File srcFile, File destFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 文件资源
//            File sFile = new File(srcFile);
//            File dFile = new File(destFile);

            // IO流资源
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 复制操作
            int len;
            byte[] buffer = new byte[1024];
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

    public void copyBuffered(File srcFile, File destFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // IO流资源创建
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            // 缓冲流创建
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 复制操作
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
                // 刷新缓冲区
//                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 缓冲流资源关闭 (自动关闭内层流资源)
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
