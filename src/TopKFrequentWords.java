import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] input={"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(input,k).toString());
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), summingInt(e -> 1)));
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->hm.get(b).equals(hm.get(a))? b.compareTo(a):hm.get(a)-hm.get(b));
        for(String w:hm.keySet()){
            pq.add(w);
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        Collections.reverse(ans);
        return ans.subList(0,k);
    }
}
