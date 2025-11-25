package work19FANSHELEI;
import java.lang.reflect.*;
import java.io.*;
import java.util.Arrays;

public class fanshelei {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入类全名（例：java.util.ArrayList）：");
        String name = br.readLine().trim();

        try {
            Class<?> c = Class.forName(name);
            System.out.println("\n========== 属性 ==========");
            for (Field f : c.getDeclaredFields()) {
                System.out.printf("%-10s %-15s %s%n",
                        Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName());
            }

            System.out.println("\n========== 方法 ==========");
            for (Method m : c.getDeclaredMethods()) {
                System.out.printf("%-10s %-15s %s(%s)%n",
                        Modifier.toString(m.getModifiers()),
                        m.getReturnType().getSimpleName(),
                        m.getName(),
                        Arrays.toString(m.getParameterTypes())
                             .replaceAll("^\\[|\\]$", ""));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ 类未找到！");
        }
    }
}