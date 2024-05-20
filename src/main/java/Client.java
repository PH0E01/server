import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws IOException {
        String localhost = "127.0.0.1";
        int port = 9090;
        try (Socket clientSocket = new Socket(localhost, port);

             PrintWriter printOut = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader
                     (new InputStreamReader(clientSocket.getInputStream()))) {
            printOut.println("GET / HTTP/1.1\n" + "Host: 127.0.0.1\n\n");

            String resp = in.readLine();
            System.out.println(resp);
        }


    }
}

