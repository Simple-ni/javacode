package USERrole18;
import java.util.Scanner;

public class use {

    /* 1. 枚举定义 */
    enum UserRole {
        ADMIN("所有后台管理权限"),
        USER ("读写自己数据的权限"),
        GUEST("只读公开数据");

        private final String permission;
        UserRole(String permission) { this.permission = permission; }
        public String getPermission() { return permission; }
    }

    /* 2. 交互主程序 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRole role;

        while (true) {
            System.out.print("请输入角色（ADMIN / USER / GUEST）：");
            String input = sc.nextLine().trim().toUpperCase(); // 忽略大小写
            try {
                role = UserRole.valueOf(input); // 反查枚举
                break; // 成功则跳出
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 无效角色，请重新输入！");
            }
        }

        System.out.println("角色 [" + role + "] 的权限：" + role.getPermission());
        sc.close();
    }
}