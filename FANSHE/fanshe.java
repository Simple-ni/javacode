package FANSHE;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class  fanshe {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入类全名（例：java.util.ArrayList）：");
        String className = br.readLine().trim();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\n========== FIELDS ==========");
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                System.out.printf("%-10s %-15s %s%n",
                        Modifier.toString(f.getModifiers()),
                        f.getType().getSimpleName(),
                        f.getName());
            }

            System.out.println("\n========== METHODS ==========");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.printf("%-10s %-15s %s(%s)%n",
                        Modifier.toString(m.getModifiers()),
                        m.getReturnType().getSimpleName(),
                        m.getName(),
                        Arrays.toString(m.getParameterTypes())
                                .replaceAll("^\\[|\\]$", ""));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ 类未找到，请检查类全名！");
        }
    }
}