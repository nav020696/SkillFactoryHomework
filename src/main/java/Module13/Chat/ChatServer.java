package Module13.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static List<Client> clientList = new ArrayList<>();
    ServerSocket server;

    public ChatServer(ServerSocket server) {
        this.server = server;
    }

    void sendAll(String message){
        for (Client client: clientList) {
            //отправляем всем сообщение;
            client.receive(message);
        }
    }
    public void run() {
        while (true) {
            System.out.println("Waiting...");
            // ждем клиента из сети
            try {
                Socket socket = server.accept();
                System.out.println("Client connected!");
                clientList.add(new Client(socket, this));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ChatServer chat = new ChatServer(new ServerSocket(1234));
        chat.run();
    }
}
