import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] input={{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(merge(input)));
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(arr->arr[0]));
        List<int[]> ans = new ArrayList<>();
        final int[] init = {-1,-1};
        int[] prev = init;
        for(int[] curr : intervals){
            if(prev[1]<curr[0]) {
                if(!prev.equals(init)) {
                    ans.add(prev);
                }
                prev=curr;
            } else if(prev[1]<curr[1]) prev[1]=curr[1];
        }
        if(!prev.equals(init)) ans.add(prev);
        return ans.stream().map(r -> r.clone()).toArray(int[][]::new);
    }
}
