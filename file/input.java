package file;

import java.io.*;
import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "F:\\java\\java code\\javacode\\file\\filein.text";

        System.out.println("请输入要写入文件的内容：");
        String content = scanner.nextLine();

        // 将用户输入的内容写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("内容已写入文件：" + filename);
        } catch (IOException e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }

        // 从文件中读取内容并输出到控制台
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("文件中的内容如下：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件时发生错误：" + e.getMessage());
        }

        scanner.close();
    }
}