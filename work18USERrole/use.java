package work18USERrole;
import java.util.Scanner;

public class use {

    enum UserRole {
        ADMIN("所有后台管理权限"),
        USER ("读写自己数据的权限"),
        GUEST("只读公开数据");

        private final String permission;
        UserRole(String permission) { this.permission = permission; }
        public String getPermission() { return permission; }
    }

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRole role;

        while (true) {
            System.out.print("请输入角色（ADMIN / USER / GUEST）：");
            String input = sc.nextLine().trim().toUpperCase(); 
            try {
                role = UserRole.valueOf(input); 
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println("❌ 无效角色，请重新输入！");
            }
        }

        System.out.println("角色 [" + role + "] 的权限：" + role.getPermission());
        sc.close();
    }
}