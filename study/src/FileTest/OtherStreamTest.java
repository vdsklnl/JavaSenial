package FileTest;

import org.junit.Test;

import java.io.*;

/**
 * @author vdsklnl
 * @create 2022-04-22 17:19
 * @Description
 * 标准输入输出流
 * 打印流
 * 数据流
 */

public class OtherStreamTest {
    //System.in不能用unitTest，无法输入
    //标准输入输出流System.in/out
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束。");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 更改输出位置为文件而不是控制台
    @Test
    public void printTest() {
        PrintStream ps = null;

        try {
            // 设置为自动刷新模式，换行符或"\n"刷新
            ps = new PrintStream(new FileOutputStream("hello.txt"), true);

            if(ps != null){
                System.setOut(ps);
            }

            // 输出ASCII码表
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                try {
                    // 关闭资源
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void dataOutTest() {

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("胡任智");
            dos.flush(); //刷新，将数据写入文件
            dos.writeInt(22);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void dataInTest() {

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));
            // 读入顺序与写入相同
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyInput {

    public static String readString() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static int readInt() {return Integer.parseInt(readString());}

    public static double readDouble() {return Double.parseDouble(readString());}

    public static byte readByte() {return Byte.parseByte(readString());}

    public static short readShort() {return Short.parseShort(readString());}

    public static long readLong() {return Long.parseLong(readString());}

    public static float readFloat() {return Float.parseFloat(readString());}

}

