package likedriving.socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer{
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6000);
        Socket server = serverSocket.accept();

        System.out.println("I M A SOCKET SERVER");
        DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
        System.out.println("client says: "+dataInputStream.readUTF());

        DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
        dataOutputStream.writeUTF("Hey client, thank you for connecting");

        server.close();
    }
}
