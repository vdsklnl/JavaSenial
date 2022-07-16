package ProtocolTest;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author vdsklnl
 * @create 2022-04-25 16:52
 * @Description UDP通信测试
 */

public class UDPTest {

    @Test
    public void sender() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            byte[] buffer = "你好，我是UDP。".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, InetAddress.getLocalHost(), 4649);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void receiver() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(4649);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            socket.receive(packet);
            System.out.println(new String(packet.getData(),0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
