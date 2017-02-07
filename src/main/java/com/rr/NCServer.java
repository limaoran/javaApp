package com.rr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 模拟linux下nc -lk 9999的使用
 * Created by Limaoran on 2016/7/10.
 */
public class NCServer implements Runnable{
    private ServerSocket server = null ;
    private Scanner scan = null;
    private List<Socket> clients = null;
    private String encoding = "UTF-8";
    public NCServer(int port,String encoding)throws IOException{
        server = new ServerSocket(port);
        System.out.println("Server在"+port+"端口上启动成功！");
        scan = new Scanner(System.in);
        clients = new ArrayList<>();
        if(encoding!=null && encoding.length()>0){
            this.encoding = encoding;
        }
    }
    public void start()throws IOException{
        new Thread(this).start();
        while(true){
            clients.add(server.accept());
        }
    }

    /**
     * 使用另一个线程处理
     * @throws IOException
     */
    public void run() {
        while(scan.hasNextLine()){
            if(clients.size()<1)return ;
            String str = scan.nextLine();
            System.out.println("给"+clients.size()+"个客户端发送信息！");
            for(int i=0;i<clients.size();i++){
                Socket socket = clients.get(i);
                try {
                    socket.getOutputStream().write(str.getBytes(encoding));
                }catch (Exception e){
                    System.out.println("发生错误，移除Client："+e.getMessage());
                    clients.remove(socket);
                    i --;
                }
            }
        }
    }
    public void stop()throws IOException{
        if(server!=null)
            server.close();
    }

    public static void main(String[] args) {
        int port = 9999;
        String encoding = "GBK";
        if(args.length>0){
            try {
                port = Integer.parseInt(args[0]);
            }catch (Exception e){
                //...
            }
            if(args.length>1){
                encoding = args[1];
            }
        }else{
            System.out.println("参数列表：第一个参数“端口号”，第二个参数“编码”");
            System.out.println("默认为9999端口，GBK编码");
        }
        try {
            new NCServer(port,encoding).start();
        } catch (IOException e) {
            System.out.println("Error:"+e.getMessage());
        }
    }
}
