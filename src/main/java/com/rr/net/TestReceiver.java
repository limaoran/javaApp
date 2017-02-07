package com.rr.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP，接收消息
 * Created by Limaoran on 2016/8/27.
 */
public class TestReceiver {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8989);
            byte [] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf,0,buf.length);
            socket.receive(packet);
            System.out.println(new String(buf));
        } catch (SocketException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
