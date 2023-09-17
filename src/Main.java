import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try (ServerSocket server = new ServerSocket(7777);)
        {
            while (true) {
                System.out.println("server is waiting for clients .....");
                Socket socket = server.accept();
                System.out.println("socket connected ");
                socket_handler socketh = new socket_handler(socket);
                socketh.start();
                System.out.println("------------------------------------------");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}