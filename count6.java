import java.util.Scanner;

public class count6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个数字：");
        double num1 = scanner.nextDouble();

        System.out.print("请输入运算符 (+, -, *, /)：");
        char operator = scanner.next().charAt(0);

        System.out.print("请输入第二个数字：");
        double num2 = scanner.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("除数不能为0");
                    return;
                }
                break;
            default:
                System.out.println("无效的运算符");
                return;
        }

        System.out.println("结果是：" + result);

        scanner.close();
    }
}
