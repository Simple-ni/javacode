package work23MAOP;
import java.util.Arrays;
import java.util.Scanner;

public class maopao {

 
    public static void bubbleSort(int[] a) {
        int n = a.length;
        boolean swapped;                 
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {   
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;       
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组长度 n：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入 " + n + " 个整数：");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}