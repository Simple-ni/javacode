package properties24;
import java.io.*;
import java.util.Properties;

public class ReadConfig {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        // 方式1：类路径加载（推荐）
        try (InputStream in = ReadConfig.class.getResourceAsStream("config.properties")) {
            if (in == null) {
                System.out.println("❌ 配置文件不在类路径！");
                return;
            }
            props.load(in);
        }

        // 打印全部键值
        props.forEach((k, v) -> System.out.println(k + " = " + v));

        // 根据键取值
        String host = props.getProperty("db.host");
        String port = props.getProperty("db.port", "3306"); // 默认值
        System.out.println("\n单独取值 → db.host = " + host + ":" + port);
    }
}