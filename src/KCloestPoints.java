
/**
 * k closest points 找到离目标点最近的k个点
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找到离目标点最近的k个点
 * 
 * @author ning
 */
public class KCloestPoints {

    public Point[] kClosest(Point[] points, Point origin, int k) {
        final Point origin_temp;
        // write your code here
        origin_temp = origin;
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                // a点到origin的距离
                int disa = (int) (Math.pow((a.x - origin_temp.x), 2) + Math.pow((a.y - origin_temp.y), 2));

                // b点到origin的距离
                int disb = (int) (Math.pow((b.x - origin_temp.x), 2) + Math.pow((b.y - origin_temp.y), 2));
                int diff = disb - disa;
                if (diff == 0) {
                    diff = b.x - a.x;
                    if (diff == 0) {
                        diff = b.y - a.y;
                    }
                }
                return diff;
            }
        });
        for (int i = 0; i < points.length; i++) {
            // 向队列添加元素
            queue.offer(points[i]);

            if (queue.size() > k) {
                queue.poll(); // 移除并返问队列头部的元素
            }
        }
        Point[] result = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }

        return result;
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}