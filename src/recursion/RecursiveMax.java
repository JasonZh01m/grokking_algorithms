package recursion;

import java.util.Arrays;

/**
 * Created by JasonZh on 2017/11/2.
 */
public class RecursiveMax {

    private static int max(int[] arr) {
        if (arr.length == 2) {
            return arr[0] > arr[1] ? arr[0] : arr[1];
        } else {

            int subMax = max(Arrays.copyOfRange(arr, 1, arr.length));
            return subMax > arr[0] ? subMax : arr[0];

        }
    }


    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 5, 10, 25, 16, 1})); // 25
    }


}
