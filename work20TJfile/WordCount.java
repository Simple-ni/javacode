package work20TJfile;
import java.io.*;
import java.util.StringTokenizer;

public class WordCount {
    public static void main(String[] args) throws Exception {
        String filePath;
        if (args.length > 0) {
            filePath = args[0];          
        } else {
            System.out.print("请输入文本文件路径：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            filePath = br.readLine().trim();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int total = 0;
            String line;
            while ((line = reader.readLine()) != null) {
             
                StringTokenizer st = new StringTokenizer(line);
                total += st.countTokens();
            }
            System.out.println("单词总数：" + total);
        } catch (FileNotFoundException e) {
            System.out.println("❌ 文件未找到，请检查路径！");
        }
    }
}