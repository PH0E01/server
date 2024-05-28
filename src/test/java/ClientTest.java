
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {


    @Test
    public void testClientConnecting() {
        // given
        String localhost = "127.0.0.1";
        int port = 9090;

        // when
        boolean result;
        try (Socket clientSocket = new Socket(localhost, port)) {
            result = Client.clientConnecting(clientSocket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        assertTrue(result);
    }

    static boolean clientConnecting(Socket clientSocket) throws IOException {
        try (PrintWriter printOut = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            // не отправляем имя клиента, так как сервер ожидает его
            // printOut.println("clientName");

            String resp;
            while ((resp = in.readLine()) != null) {
                System.out.println(resp);
                return true;
            }
            return false;
        }
    }
}