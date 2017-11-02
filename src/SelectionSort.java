import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JasonZh on 2017/11/2.
 * 选择排序(List)
 * O(n²)
 */
public class SelectionSort {

    public static List<Integer> selectionSort(List<Integer> arr) {

        List<Integer> newArr = new ArrayList<>(arr.size());

        int loop = arr.size();
        for (int i = 0; i < loop; i++) {
            int smallestIndex = findSmallest(arr);
            newArr.add(arr.get(smallestIndex));
            arr.remove(smallestIndex);
        }

        return newArr;
    }


    private static int findSmallest(List<Integer> arr) {

        int smallest = arr.get(0);
        int smallestIndex = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (smallest > arr.get(i)) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;

    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectionSort(arr)); //[2, 3, 5, 6, 10]
    }


}
