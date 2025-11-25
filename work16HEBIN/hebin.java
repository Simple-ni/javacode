package work16HEBIN;
import java.util.Arrays;
public class hebin {


    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            c[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];

        while (i < a.length) c[k++] = a[i++];
        while (j < b.length) c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {
        int [] a = {1, 3, 5, 7, 9};
        int [] b = {2, 4, 6, 8, 10};

        int[] c = merge(a, b);
        System.out.println("合并后有序数组：");
        System.out.println(Arrays.toString(c));
    }
}