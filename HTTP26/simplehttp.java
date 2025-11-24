package HTTP26;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class simplehttp {
    public static void main(String[] args) throws Exception {
        int port = 8082;
        System.out.println("HTTP 服务器启动，端口 " + port);
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket client = server.accept();          // 阻塞等待
                new Thread(() -> handle(client)).start(); // 一线程一请求
            }
        }
    }

    private static void handle(Socket client) {
        try (BufferedReader in  = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out     = new PrintWriter(client.getOutputStream(), true)) {

            String line = in.readLine();                // 读取请求行
            if (line == null) return;
            StringTokenizer st = new StringTokenizer(line);
            String method = st.nextToken();             // GET
            String path   = st.nextToken();             // / 或 /hello

            // 只支持 GET
            if (!"GET".equalsIgnoreCase(method)) {
                out.println("HTTP/1.1 405 Method Not Allowed\r\n\r\n");
                return;
            }

            String body;
            switch (path) {
                case "/":
                    body = "Welcome to Simple Java HTTP Server!";
                    break;
                case "/hello":
                    body = "Hello World from Java!";
                    break;
                default:
                    body = "404 Not Found";
            }

            // 发送响应
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain; charset=utf-8");
            out.println("Content-Length: " + body.getBytes().length);
            out.println();                 // 空行
            out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { client.close(); } catch (IOException ignore) {}
        }
    }
}