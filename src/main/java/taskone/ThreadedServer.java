package taskone;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {
    public static void main(String[] args) throws Exception {
        int port = 8000;
        StringList strings = new StringList();

        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started...");
        while (true) {
            Socket sock = null;
            System.out.println("Accepting a Request...");
            try {
                sock = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("close socket of client ");
                sock.close();
            }

            Socket finalSock = sock;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Performer performer = new Performer(finalSock, strings);
                    performer.doPerform();
                }
            }).start();

        }
    }
}
