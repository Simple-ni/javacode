package work27TREE;
import java.util.*;

public class treeset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一组整数（空格分隔）：");
        String[] nums = sc.nextLine().trim().split("\\s+");

        TreeSet<Integer> set = new TreeSet<>();   
        for (String n : nums) {
            set.add(Integer.parseInt(n));         
        }

        System.out.println("升序排列结果：");
        set.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}