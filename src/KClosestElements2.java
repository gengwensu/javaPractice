import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4]
 * 
 * Note:
 * 
 * The value k is positive and will always be smaller than the length of the
 * sorted array. Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */

public class KClosestElements2 {
    public static void main(String[] args) {

        // int[] input = { 1, 2, 3, 4, 5 };
        // int k = 4, x = -1;

        // int[] input = { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };
        // int k = 9, x = 4;
        int[] input = { 1, 2, 3, 4, 5 };
        int k = 4, x = 3;
        List<Integer> inList = Arrays.stream(input).boxed().collect(Collectors.toList());
        KClosestElements2 sol = new KClosestElements2();
        List<Integer> result = sol.findClosestElements(inList, k, x);
        System.out.println(result);
    }

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }
}
