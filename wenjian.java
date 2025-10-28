import java.util.ArrayList;
import java.util.Scanner;

/*========== 商品 JavaBean ==========*/
class Product {
    private int id;
    private String name;
    private double price;

    public Product() {}

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = Math.max(price, 0);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("ID:%d  名称:%s  价格:¥%.2f", id, name, price);
    }
}

/*========== 管理类 ==========*/
public class wenjian {
    private static final ArrayList<Product> list = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int nextId = 1;   // 自增主键

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 商品管理系统 ===");
            System.out.println("1. 添加商品");
            System.out.println("2. 查询所有商品");
            System.out.println("0. 退出");
            System.out.print("请选择：");
          switch (sc.nextLine()) {
    case "1":
        addProduct();
        break;
    case "2":
        listProducts();
        break;
    case "0":
        System.out.println("再见！");
        return;
    default:
        System.out.println("输入错误，请重选！");
}
        }
    }

    private static void addProduct() {
        System.out.print("请输入商品名称：");
        String name = sc.nextLine();
        System.out.print("请输入价格：");
        double price = Double.parseDouble(sc.nextLine());
        list.add(new Product(nextId++, name, price));
        System.out.println("添加成功！");
    }

    private static void listProducts() {
        if (list.isEmpty()) {
            System.out.println("暂无商品！");
            return;
        }
        list.forEach(System.out::println);
    }
}