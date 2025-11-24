package HASHI22;  
import java.util.*;

public class haxi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String str = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        // 逐字符统计
        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);   // 若存在 +1，不存在置 1
        }

        // 输出
        map.forEach((ch, cnt) -> 
            System.out.println("'" + ch + "' 出现 " + cnt + " 次"));
    }
}