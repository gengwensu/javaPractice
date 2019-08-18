import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 616.course-schedule-ii There are a total of n courses you have to take,
 * labeled from 0 to n - 1. Some courses may have prerequisites, for example to
 * take course 0 you have to first take course 1, which is expressed as a pair:
 * [0,1] Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses. There
 * may be multiple correct orders, you just need to return one of them. If it is
 * impossible to finish all courses, return an empty array. For example: 2,
 * [[1,0]] There are a total of 2 courses to take. To take course 1 you should
 * have finished course 0. So the correct course order is [0,1] 4,
 * [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */

public class CourseScheduleIIStream {
    public static void main(String[] args) {

        int ncourse = 4;
        int[][] prereqArr = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        // int ncourse = 2;
        // int[][] prereqArr = { { 1, 0 } };
        CourseScheduleIIStream sol = new CourseScheduleIIStream();
        System.out.println("To schedule courses from 0 ... " + ncourse);
        System.out.println("with pre-req:" + Arrays.deepToString(prereqArr));
        System.out.println("\n\nThe recommended schedule is ");
        int[] result = sol.findOrder(ncourse, prereqArr);
        System.out.println(Arrays.toString(result));
    }

    // using stream
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        IntStream.range(0, numCourses).forEach(i -> adjMap.put(i, new ArrayList<Integer>()));// initialize adjcent map
        Arrays.stream(prerequisites).forEach(arr -> adjMap.get(arr[0]).add(arr[1]));

        Queue<Integer> courseQ = new LinkedList<>();
        adjMap.entrySet().stream().filter(e -> e.getValue().size() == 0).forEach(e -> courseQ.add(e.getKey()));

        int[] result = new int[numCourses];
        int k = 0;
        while (!courseQ.isEmpty()) {
            int node = courseQ.poll();
            result[k++] = node;

            adjMap.entrySet().stream().filter(e -> e.getValue().contains(node)).forEach(e -> {
                e.getValue().remove(Integer.valueOf(node)); // remove object not remove index
                if (e.getValue().size() == 0)
                    courseQ.add(e.getKey());
            });
        }

        if (k == numCourses) {
            return result;
        } else
            return new int[0];

    }
}