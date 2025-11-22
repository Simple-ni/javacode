package TCP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TCPDemoUsage {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== TCP 客户端/服务器 使用向导 ===");

        System.out.println("\n第一步：先启动服务器");
        System.out.println("  新建终端 → 执行：  javac -encoding UTF-8 TCPServer.java && java TCPServer");
        System.out.println("  看到“服务器启动，等待客户端连接...”即可");

        System.out.println("\n第二步：再启动客户端");
        System.out.println("  再新建终端 → 执行：javac -encoding UTF-8 TCPClient.java && java TCPClient");
        System.out.println("  按提示输入消息，回车发送");

        System.out.println("\n第三步：想停就关两个终端即可");
        System.out.print("\n按回车键退出向导...");
        br.readLine();
    }
}