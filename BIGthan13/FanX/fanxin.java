package BIGthan13.FanX;

public class fanxin {
 public static <T extends Comparable<T>> T max(T[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("数组不能为空");

        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 使用 Comparable 接口定义的自然顺序比较
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
    // 测试
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] words = {"songhaolin", "ligao", "lvcen", "shiyinhuan"};

        System.out.println(max(nums));  // 9
        System.out.println(max(words)); // pear（字典序最大）
    }
}
