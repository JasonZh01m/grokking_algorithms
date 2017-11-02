package recursion;

import java.util.Arrays;

/**
 * Created by JasonZh on 2017/11/2.
 */
public class RecursiveSum {

    private static int sum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }


    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4})); // 10
    }

}
