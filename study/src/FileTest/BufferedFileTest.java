package FileTest;

import org.junit.Test;

import java.io.*;

/**
 * @author vdsklnl
 * @create 2022-04-22 14:38
 * @Description
 */

public class BufferedFileTest {
    @Test
    public void speedFile() {
        File srcFile = new File("dbcp.txt");
        File destIOFile = new File("dbcp1.txt");
        File destBufferedFile = new File("dbcp2.txt");

        long startIO = System.currentTimeMillis();
        copyFile(srcFile, destIOFile);
        long endIO = System.currentTimeMillis();

        long startBuffered = System.currentTimeMillis();
        copyBufferedFile(srcFile, destBufferedFile);
        long endBuffered = System.currentTimeMillis();

        System.out.println((endIO - startIO) + "----" + (endBuffered - startBuffered));
    }

    public void copyFile(File srcFile, File destFile) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 文件资源
//            File sFile = new File(srcFile);
//            File dFile = new File(destFile);

            // IO流资源
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // 复制操作
            int len;
            char[] buffer = new char[1024];
            while((len = fr.read(buffer)) != -1){
                fw.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // IO流资源关闭
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyBufferedFile(File srcFile, File destFile) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // IO流资源创建
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            // 缓冲流创建
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            // 复制操作 (BufferReader 独有readline())
            //方式一
//            int len;
//            char[] buffer = new char[1024];
//            while ((len = br.read(buffer)) != -1) {
//                bw.write(buffer,0,len);
//                // 刷新缓冲区
////                bos.flush();
//            }
            //方式二
            String data;
            while ((data = br.readLine()) != null) {
                //data中不包含换行符
                //方法一
//                bw.write(data + "\n");
                //方法二
                bw.write(data);
                bw.newLine(); //提供换行操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 缓冲流资源关闭 (自动关闭内层流资源)
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
