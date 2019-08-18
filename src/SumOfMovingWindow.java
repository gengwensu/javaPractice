import java.util.ArrayList;
import java.util.List;

public class SumOfMovingWindow {
    public static void main(String[] args) {

        int[] input = { 1, 2, 7, 8, 5 };
        SumOfMovingWindow sol = new SumOfMovingWindow();
        System.out.println(sol.windowSum(input, 3));
    }

    public List<Integer> windowSum(int[] arr, int width) {

        List<Integer> list = new ArrayList<>();

        if (arr.length < width) {
            list.add(0);
            return list;
        }

        int sum = 0;
        for (int i = 0; i < width; i++) {
            sum += arr[i];
        }

        for (int j = 0; j < arr.length - width + 1; j++) {
            if (j > 0) {
                sum -= arr[j - 1];
                sum += arr[j + width - 1];
            }
            list.add(sum);
        }
        return list;
    }
}