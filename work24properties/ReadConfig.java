package work24properties;
import java.io.*;
import java.util.Properties;

public class ReadConfig {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

     
        try (InputStream in = ReadConfig.class.getResourceAsStream("config.properties")) {
            if (in == null) {
                System.out.println("❌ 配置文件不在类路径！");
                return;
            }
            props.load(in);
        }

      
        props.forEach((k, v) -> System.out.println(k + " = " + v));


        String host = props.getProperty("db.host");
        String port = props.getProperty("db.port", "3306"); 
        System.out.println("\n单独取值 → db.host = " + host + ":" + port);
    }
}