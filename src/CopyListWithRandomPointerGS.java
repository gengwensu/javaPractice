
/**
 *   A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
 * 
 */

import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
public class CopyListWithRandomPointerGS {

    public static void main(String[] args) {

        RandomListNode head = new RandomListNode(0);
        RandomListNode next = new RandomListNode(1);
        head.next = next;
        head.random = next;

        CopyListWithRandomPointerGS sol = new CopyListWithRandomPointerGS();
        System.out.print("input: ");
        nodePrint(head);
        System.out.print("output: ");
        nodePrint(sol.copyRandomList(head));
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        RandomListNode head2 = new RandomListNode(head.label);

        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        hm.put(head, head2);
        for (RandomListNode p1 = head, p2 = head2; p1 != null; p1 = p1.next) {
            if (p1 != head) {
                RandomListNode tmp = new RandomListNode(p1.label);
                p2.next = tmp;
                hm.put(p1, tmp);
                p2 = p2.next;
            }
        }
        for (RandomListNode p1 = head, p2 = head2; p1 != null; p1 = p1.next, p2 = p2.next) {
            p2.random = p1.random == null ? null : hm.get(p1.random);
        }

        return head2;

    }

    private static void nodePrint(RandomListNode head) {
        for (RandomListNode p = head; p != null; p = p.next) {
            int r = p.random == null ? -9999 : p.random.label;
            int n = p.next == null ? -9999 : p.next.label;
            System.out.println("{ " + p.label + ", " + n + ", " + r + " }->");
        }
    }
}

/*
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}*/
