/**
 * 
 * Find largest subtree sum in a tree
 * 
 * Given a binary tree, task is to find subtree with maximum sum in tree.
 * 
 * Examples:
 * 
 * Input : 1 / \ 2 3 / \ / \ 4 5 6 7 Output : 28 As all the tree elements are
 * positive, the largest subtree sum is equal to sum of all tree elements.
 * 
 * Input : 1 / \ -2 3 / \ / \ 4 5 -6 2 Output : 7 Subtree with largest sum is :
 * -2 / \ 4 5 Also, entire tree sum is also 7.
 * 
 */

public class MaxSubtree {
    private static int maxSum = 0;

    // Structure of a tree node.
    static class Node {
        int key;
        Node left, right;
    }

    // Function to create new tree node.
    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    // Driver Code
    public static void main(String args[]) {
        /*
         * 1 / \ / \ -2 3 / \ / \ / \ / \ 4 5 -6 2
         */

        // Node root = newNode(1);
        // root.left = newNode(-2);
        // root.right = newNode(3);
        // root.left.left = newNode(4);
        // root.left.right = newNode(5);
        // root.right.left = newNode(-6);
        // root.right.right = newNode(2);

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);

        System.out.println(findLargestSubtreeSum(root));
    }

    // Function to find
    // largest subtree sum.
    static int findLargestSubtreeSum(Node root) {
        if (root == null)
            return 0;

        int ans = traverse(root);

        if (ans > maxSum)
            return ans;
        else
            return maxSum;
    }

    static int traverse(Node root) {
        if (root == null)
            return 0;
        int sum = 0;
        sum += root.key + traverse(root.left) + traverse(root.right);
        if (sum > maxSum)
            maxSum = sum;
        return sum;
    }
}
