import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class socket_handler extends Thread{

    private Socket socket;
    public socket_handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.handler();
    }

    void handler(){
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             Reader red = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(red);
             PrintStream w = new PrintStream(out);
        ){
            reader_handler readerHandler = new reader_handler(w);
            Thread t1 = new Thread(readerHandler);
            t1.start();
            while (socket.isConnected()) {
                String str2 = reader.readLine();
                System.out.println(socket.getInetAddress().getHostName()+" :" + str2);
            }
        }catch (Exception E)
        {
            System.err.println(E.getMessage());
        }finally {
            try {
                socket.close();
                System.out.println("socket closed");
            } catch (IOException e) {
                System.out.println( e.getMessage() );
            }
        }
    }
}
