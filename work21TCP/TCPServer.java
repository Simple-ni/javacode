package work21TCP;    
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        int port = 12345;
        System.out.println("服务器启动，等待客户端连接...");
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();                 
             BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out    = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String line = in.readLine();            
            System.out.println("收到客户端消息：" + line);
            out.println("服务器已收到：" + line);     
        }
        System.out.println("服务器退出。");
    }
}