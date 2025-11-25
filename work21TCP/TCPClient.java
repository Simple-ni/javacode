package work21TCP;
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(host, port);
             BufferedReader userBr = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out    = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.print("请输入要发送的消息：");
            String msg = userBr.readLine();
            out.println(msg);               
            String reply = in.readLine();   
            System.out.println("服务器回显：" + reply);
        }
    }
}