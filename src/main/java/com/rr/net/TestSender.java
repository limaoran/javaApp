package com.rr.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP，发送消息
 * Created by Limaoran on 2016/8/27.
 */
public class TestSender {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9999);
            byte [] buf = "Hello".getBytes();
            DatagramPacket packet = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",8989));
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
