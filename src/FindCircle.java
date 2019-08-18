import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindCircle {
    static int N;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] input={{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(input));
    }

    public static int findCircleNum(int[][] M) {
        N = M[0].length;
        visited = new boolean[N];
        Map<Integer, List> circles = new HashMap<>();

        for(int i=0; i<N; i++) {
            if(!visited[i]){
                List<Integer> list = new LinkedList<>();
                list.add(i);

                visited[i]=true;
                list.addAll(DFS(M, i));
                circles.put(i,list);
            }
        }
        //circles.forEach((k,v)->System.out.println("key - "+k.toString()+" : value - "+v.toString()));
        return circles.keySet().size();
    }

    static List<Integer> DFS(int[][] M, int idx) {
        List<Integer> list = new LinkedList<>();
        for(int j=0; j < N; j++) {
            if(M[idx][j]==1 && !visited[j]) {
                list.add(j);
                visited[j]=true;
                list.addAll(DFS(M,j));
            }
        }
        return list;
    }
}
