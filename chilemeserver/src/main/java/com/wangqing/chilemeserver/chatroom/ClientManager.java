package com.wangqing.chilemeserver.chatroom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientManager {
    public static final Logger logger = LoggerFactory.getLogger(ClientManager.class);

    private static Map<String, Socket> clientList = new HashMap<>();
    private static ServerThread serverThread = null;

    private static class ServerThread implements Runnable{

        private int port = 8090;
        private boolean isExit = false;
        private ServerSocket server;

        public ServerThread(){
            try {
                server = new ServerSocket(port);
                logger.info("吃喝聊天室服务端启动成功" + "port: " + port);
                //System.out.println("吃喝聊天室服务端启动成功" + "port: " + port);
            } catch (IOException e) {
                logger.info("吃喝聊天室服务端启动失败，错误原因：" + e.getMessage());
                //System.out.println("吃喝聊天室服务端启动失败，错误原因：" + e.getMessage());
            }
        }

        @Override
        public void run() {
            try{
                while (!isExit){
                    // 进入等待环节
                    logger.info("等待手机连接...");
                    //System.out.println("等待手机连接...");
                    final Socket socket = server.accept();
                    // 获取手机连接的地址及端口号
                    final  String address = socket.getRemoteSocketAddress().toString();
                    logger.info("连接成功，连接的手机为：" + address);
                    //System.out.println("连接成功，连接的手机为：" + address);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                // 单线程锁
                                synchronized (this){
                                    // 放进到Map中保存
                                    clientList.put(address, socket);
                                }
                                // 定义输入流
                                InputStream inputStream = socket.getInputStream();
                                byte[] buffer = new byte[1024];
                                int len;
                                while ((len = inputStream.read(buffer)) != -1){
                                    String text = new String(buffer, 0, len);
                                    logger.info("收到的数据为：" + text);
                                    //System.out.println("收到的数据为：" + text);
                                    // 在这里群发消息
                                    sendMsgAll(text);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void stop(){
            isExit = true;
            if (server != null){
                try {
                    server.close();
                    logger.info("已关闭Server");
                    //System.out.println("已关闭Server");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static ServerThread startServer(){
        logger.info("开启服务");
        //System.out.println("开启服务");
        if (serverThread != null){
            shutDown();
        }
        serverThread = new ServerThread();
        new Thread(serverThread).start();
        logger.info("开启服务成功");
        //System.out.println("开启服务成功");
        return serverThread;
    }

    // 关闭所有server socket 和 清空 Map
    public static void shutDown(){
        for (Socket socket : clientList.values()){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        serverThread.stop();
        clientList.clear();
    }

    // 群发的方法
    public static boolean sendMsgAll(String msg){
        PrintWriter pw;
        try {
            for (Socket socket: clientList.values()){
               pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
               pw.println(msg);
               pw.flush();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }







}
