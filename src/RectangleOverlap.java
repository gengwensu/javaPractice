public class RectangleOverlap {
    public static void main(String[] args) {

        // int[] rec1 = { 0, 0, 2, 2 }, rec2 = { 1, 1, 3, 3 };
        int[] rec1 = { 0, 0, 1, 1 }, rec2 = { 1, 0, 2, 1 };
        RectangleOverlap sol = new RectangleOverlap();
        System.out.println(sol.isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2])
            return false;
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3])
            return false;

        return true;
    }
}