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
        try (Socket clientSocket = new Socket(localhost, port)){
            clientConnecting(clientSocket);
        }
    }

    static boolean clientConnecting(Socket clientSocket) throws IOException {
        try (PrintWriter printOut = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            // Не отправляем имя клиента, так как сервер ожидает его
            // printOut.println("ClientName");

            String resp;
            while ((resp = in.readLine()) != null) {
                System.out.println(resp);
                return true;
            }
            return false;
        }
    }
}



