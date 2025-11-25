package work8arrange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请选择操作：1-添加商品 2-查询商品 3-退出");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("请输入商品ID：");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("请输入商品名称：");
                    String name = scanner.nextLine();
                    System.out.print("请输入商品价格：");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); 
                    Product product = new Product(id, name, price);
                    products.add(product);
                    System.out.println("商品添加成功！");
                    break;
                case 2:
                    System.out.print("请输入要查询的商品ID：");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); 
                    boolean found = false;
                    for (Product p : products) {
                        if (p.getId() == searchId) {
                            System.out.println("查询结果：" + p);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("未找到商品ID为 " + searchId + " 的商品");
                    }
                    break;
                case 3:
                    System.out.println("退出系统");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的选择，请重新输入");
            }
        }
    }
}