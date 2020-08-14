package likedriving.socketprogramming;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Initiating socket connection from client");
        Socket client = new Socket("127.0.0.1", 6000);

        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hey this is your client");

        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println("Server says:" + dataInputStream.readUTF());

        client.close();
    }
}
