package work14FDMAX;
import java.util.Arrays;

public class tofindmax {

    /**
     * 真正的泛型工具：任何 Comparable 数组都能用
     * @param <T>
     * @param arr 
     * @return 
     */
    public static <T extends Comparable<T>> T max(T[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("数组不能为空");
        T max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i].compareTo(max) > 0) max = arr[i];
        return max;
    }

    
    public static void main(String[] args) throws Exception {
 
        java.io.BufferedReader br = new java.io.BufferedReader(
                                      new java.io.InputStreamReader(System.in));
        System.out.print("长度 n：");
        int n = Integer.parseInt(br.readLine().trim());
        String[] a = new String[n];
        System.out.println("请输入 " + n + " 个字符串：");
        for (int i = 0; i < n; i++) a[i] = br.readLine().trim();

        System.out.println("数组：" + Arrays.toString(a));
        System.out.println("最大值 = " + max(a));   
    }
}