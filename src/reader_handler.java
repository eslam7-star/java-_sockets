import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class reader_handler implements Runnable{


    private PrintStream printStream;

    public reader_handler(PrintStream pr) {
        this.printStream = pr;
    }


    @Override
    public void run() {
        Writer_handler();
    }

    public void Writer_handler(){
        while ( printStream != null ) {
            Scanner scanner = new Scanner(System.in);
            String str = "Server : " + scanner.nextLine();
            printStream.println(str);
        }
    }
}
