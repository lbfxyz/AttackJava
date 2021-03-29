package com.lxyz.attackjava.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lbf
 * @date 2021/3/19
 */
public class SocketIoServer {


    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(7001)) {
            System.out.println("Server start , port is 7001 , listening .... ");
            Socket socket =  server.accept();
            System.out.println("client connect + " + socket.getPort());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (bufferedReader.read() != -1) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
