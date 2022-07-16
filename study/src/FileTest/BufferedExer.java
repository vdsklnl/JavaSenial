package FileTest;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author vdsklnl
 * @create 2022-04-22 15:14
 * @Description
 */

public class BufferedExer {
    // 图片加密
    @Test
    public void test1 () {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("beauty.jpg");
            fos = new FileOutputStream("beautysecret.jpg");

            int len;
            byte[] buffer = new byte[20];
            while ((len = fis.read(buffer)) != -1) {
                //foreach不行，不改变原数组内容
    //            for (byte b :buffer) {
    //                b = (byte) (b ^ 5);
    //            }
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 图片解密
    @Test
    public void test2 () {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("beautysecret.jpg");
            fos = new FileOutputStream("beauty2.jpg");

            int len;
            byte[] buffer = new byte[20];
            while ((len = fis.read(buffer)) != -1) {
                // m ^ n ^ n = m; 异或两次等于原值
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        //获取文本文件中，每个字符个数
        //Map(key, value) 存入文件
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("dbcp.txt");
            bw = new BufferedWriter(new FileWriter("count_dbcp.txt"));

            Map<Character, Integer> map = new HashMap<>();
            int c = 0;
            while ((c = fr.read()) != -1) {
                //int 转换为 char
                char ch = (char) c;

                //判断ch是否第一次出现
                //map.get(Key) == null
                if(map.containsKey(ch)) {
                    map.put(ch,map.get(ch) + 1);
                } else {
                    map.put(ch,1);
                }
            }

            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry:entrySet) {
                switch(entry.getKey()){
                    case ' ':
                        bw.write("空格：" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键：" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车：" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行：" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "：" + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
