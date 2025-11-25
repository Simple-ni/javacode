package work29SimpleSystem;
import java.util.*;

/* 1. 图形接口 */
interface Shape {
    double calculateArea();
    double calculatePerimeter();
    String getShapeName();
    default void displayInfo() {
        System.out.printf("%s  面积=%.2f  周长=%.2f%n",
                getShapeName(), calculateArea(), calculatePerimeter());
    }
}

/* 2. 圆形 */
class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double calculateArea() { return Math.PI * radius * radius; }
    public double calculatePerimeter() { return 2 * Math.PI * radius; }
    public String getShapeName() { return "Circle"; }
}

/* 3. 矩形 */
class Rectangle implements Shape {
    private double width, height;
    public Rectangle(double width, double height) {
        this.width = width; this.height = height;
    }
    public double calculateArea() { return width * height; }
    public double calculatePerimeter() { return 2 * (width + height); }
    public String getShapeName() { return "Rectangle"; }
}

/* 4. 三角形（三边） */
class Triangle implements Shape {
    private double a, b, c;
    public Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public double calculatePerimeter() { return a + b + c; }
    public String getShapeName() { return "Triangle"; }
}

/* 5. 统一管理类：录入 + 测试 */
public class ShapeManager {
    private static final Scanner sc = new Scanner(System.in);
    private final List<Shape> shapes = new ArrayList<>();

    private void addShape() {
        System.out.print("1-圆 2-矩形 3-三角形 0-结束录入\n请选择：");
        int opt = sc.nextInt();
        if (opt == 0) return;
       switch (opt) {
    case 1:
        System.out.print("半径：");
        shapes.add(new Circle(sc.nextDouble()));
        break;
    case 2:
        System.out.print("宽 高：");
        shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble()));
        break;
    case 3:
        System.out.print("三边：");
        shapes.add(new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
        break;
    default:
        System.out.println("无效选择！");
}
    }

    private void showAll() {
        System.out.println("\n===== 图形计算结果 =====");
        shapes.forEach(Shape::displayInfo);
    }

    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        while (true) {
            manager.addShape();
            if (manager.shapes.isEmpty()) break;
            System.out.print("继续添加？(y/n):");
            if (!sc.next().equalsIgnoreCase("y")) break;
        }
        manager.showAll();
    }
}