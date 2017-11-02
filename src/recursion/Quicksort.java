package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by JasonZh on 2017/11/2.
 * 快速排序 （两种方式)
 */
public class Quicksort {

    /**
     * JAVA8 Stream
     * @param list
     * @return
     */
    private static List<Integer> quickSort1(List<Integer> list) {

        if (list.size() < 2) {
            return list;
        } else {
            // recursive case
            Integer pivot = list.get(0);

            // sub-arrays of all the elements less than the pivot
            List<Integer> lessList = list.stream().skip(1).filter(e -> e <= pivot).collect(Collectors.toList());
            List<Integer> greaterList = list.stream().skip(1).filter(e -> e > pivot).collect(Collectors.toList());

            return Stream.of(quickSort1(lessList).stream(),
                    Stream.of(pivot),
                    quickSort1(greaterList).stream())
                    .flatMap(Function.identity())
                    .collect(Collectors.toList());

        }
    }


    /**
     * 交换数组
     * @param array
     * @param low
     * @param high
     */
    private static void quickSort2(int[] array, int low, int high) {
        int i = low, j = high;
        int pivot = array[(low + high)/2];//中间位置值
        while (i <= j){
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot){
                j--;
            }

            if(i <= j){
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if(i < high){
            quickSort2(array, i, high);
        }
        if(j > low){
            quickSort2(array, low, j);
        }

    }


    /**
     * 交换数组值
     * @param i, j
     * @param arr
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        System.out.println(quickSort1(Arrays.asList(10, 5, 2, 3))); // [2, 3, 5, 10]

        int[] arr = {10, 5, 2, 3};
        quickSort2(arr, 0, arr.length - 1); // [2, 3, 5, 10]
        System.out.println(Arrays.toString(arr));
    }


}
