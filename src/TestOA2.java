import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class TestOA2 {
    public static void main(String[] args) {

        // int[] input = { 1, 2, 3, 4, 5 };
        // int k = 4, x = -1;

        // int[] input = { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };
        // int k = 9, x = 4;
        int[] input = { 1, 2, 3, 4, 5 };
        int k = 4, x = 3;
        List<Integer> inList = Arrays.stream(input).boxed().collect(Collectors.toList());
        TestOA2 sol = new TestOA2();
        // List<Integer> result = sol.findClosestElements(inList, k, x);
        // System.out.println(result);
        int[] b = Arrays.copyOf(input, input.length);
        Arrays.stream(input).boxed().collect(Collectors.toList());
    }
}