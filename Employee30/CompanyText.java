package Employee30;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyText {
    private static final List<Employee> list = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 员工工资管理系统 ===");
        while (true) {
            System.out.print("\n1-添加 2-删除 3-总工资 4-排序 5-最值 0-退出\n选择：");
            int opt = sc.nextInt();
            if (opt == 0) break;
            switch (opt) {
                case 1:
                    addEmp();
                    break;
                case 2:
                    delEmp();
                    break;
                case 3:
                    totalSalary();
                    break;
                case 4:
                    sortBySalary();
                    break;
                case 5:
                    minMaxSalary();
                    break;
                default:
                    System.out.println("无效选择！");
            }
        }
        System.out.println("已退出，谢谢使用！");
    }

    /* ---------- 添加 ---------- */
    private static void addEmp() {
        System.out.print("类型 1-全职 2-兼职 3-销售\n选择：");
        int t = sc.nextInt();
        switch (t) {
            case 1:                       // 全职：基础工资 + 奖金
                System.out.print("ID 姓名 基础工资 奖金：");
                list.add(new FullTimeEmployee(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble()));
                break;
            case 2:                       // 兼职：时薪 × 小时
                System.out.print("ID 姓名 时薪 工作小时数：");
                list.add(new PartTimeEmployee(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt()));
                break;
            case 3:                       // 销售：基础工资 + 提成
                System.out.print("ID 姓名 基础工资 销售额：");
                list.add(new SalesEmployee(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble()));
                break;
            default:
                System.out.println("无效类型！");
                return;
        }
        System.out.println("添加成功！");
    }

    /* ---------- 删除 ---------- */
    private static void delEmp() {
        System.out.print("要删除的员工ID：");
        String id = sc.next();
        boolean removed = list.removeIf(e -> e.id.equals(id));
        System.out.println(removed ? "删除成功！" : "未找到该ID！");
    }

    /* ---------- 总工资 ---------- */
    private static void totalSalary() {
        double total = list.stream().mapToDouble(Employee::calculateSalary).sum();
        System.out.printf("公司总工资：%.2f%n", total);
    }

    /* ---------- 排序 ---------- */
    private static void sortBySalary() {
        list.sort(Comparator.comparingDouble(Employee::calculateSalary));
        System.out.println("按工资升序：");
        list.forEach(e -> System.out.println(e.getEmployeeInfo()));
    }

    /* ---------- 最值 ---------- */
    private static void minMaxSalary() {
        if (list.isEmpty()) return;
        Employee min = list.stream().min(Comparator.comparingDouble(Employee::calculateSalary)).orElse(null);
        Employee max = list.stream().max(Comparator.comparingDouble(Employee::calculateSalary)).orElse(null);
        System.out.println("工资最低：" + min.getEmployeeInfo());
        System.out.println("工资最高：" + max.getEmployeeInfo());
    }
}