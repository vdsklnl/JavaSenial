package ProtocolTest;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author vdsklnl
 * @create 2022-04-25 15:40
 * @Description  TCP网络通信
 */

public class TCPTest {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket("127.0.0.1", 6494);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("beauty.jpg"));

            int len;
            byte[] buffer = new byte[10];
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }

            System.out.println("传输完成！");
            // 传输完成后，需关闭传输通道，防止一直等待
            socket.shutdownOutput();

            // 接收服务器端的反馈
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            int lens;
            byte[] buffers = new byte[10];
            while ((lens = is.read(buffers)) != -1) {
                baos.write(buffers,0,lens);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 文本文件考虑ByteArrayOutputStream进行输出，防止乱码
    @Test
    public void server() {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(6494);
            socket = ss.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("beauty3.jpg"));

            int len;
            byte[] buffer = new byte[10];
            // read为阻塞方法，需告知什么时候结束
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            System.out.println("接收完成！");

            // 服务器端给与客户端反馈
            os = socket.getOutputStream();
            os.write("我已收到，图片很漂亮！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
