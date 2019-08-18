import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] input={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newItvl = {4,8};

        System.out.println(Arrays.deepToString(insert(input, newItvl)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] merged = Arrays.copyOf(intervals, intervals.length+1);
        merged[merged.length-1]=newInterval; // add newInterval to the intervals
        Arrays.sort(merged, Comparator.comparingInt(arr->arr[0]));
        List<int[]> ans = new ArrayList<>();
        final int[] init = {-1,-1};
        int[] prev = init;
        for(int[] curr : merged){
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
