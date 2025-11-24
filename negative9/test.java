package negative9;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入一个数字（输入-1退出）：");
            double number = scanner.nextDouble();

            if (number == -1) {
                System.out.println("退出程序");
                break;
            }
            try {
                if (number < 0) {
                    throw new NegativeNumberException("输入的数字不能为负数！");
                }
                System.out.println("输入的数字是：" + number);
            } catch (NegativeNumberException e) {
                System.out.println("发生异常：" + e.getMessage());
            }
        }

        scanner.close();
    }
}