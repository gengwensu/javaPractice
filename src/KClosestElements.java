import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

public class KClosestElements {
    public static void main(String[] args) {

        // int[] input = { 1, 2, 3, 4, 5 };
        // int k = 4, x = -1;

        int[] input = { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };
        int k = 9, x = 4;
        KClosestElements sol = new KClosestElements();
        List<Integer> result = sol.findClosestElements(input, k, x);
        System.out.println(result);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {// can't use value as key to handle duplicates
            hm.put(i, Math.abs(arr[i] - x));
        }
        hm.forEach((key, value) -> System.out.println("hm key " + key + " : " + value));
        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for (Map.Entry entry : hm.entrySet()) {
            List<Integer> list = sortedMap.getOrDefault(entry.getValue(), new ArrayList<>());
            list.add((Integer) entry.getKey());
            sortedMap.put((Integer) entry.getValue(), list);
        }
        sortedMap.forEach((key, value) -> System.out.println("Sortedmap key " + key + " : " + value));
        List<Integer> result = new ArrayList<Integer>();
        sortedMap.forEach((key, value) -> {
            for (int i : value) {
                if (result.size() < k) {
                    result.add(arr[i]);
                }
            }
        });

        Collections.sort(result);
        return result;
    }
}
