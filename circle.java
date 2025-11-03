import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("圆的面积是：" + area);
        scanner.close();
    }
}