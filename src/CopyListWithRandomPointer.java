
/**
 *  105.Copy List with Random Pointer

带有随机指针的链表，做一次完全的拷贝。

下次尝试O(1)空间复杂度 
 * 
 */

import java.util.HashMap;

/**
 * 带有随机指针的链表，做一次完全的拷贝。
 * 
 * @author ning
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        RandomListNode copyNode = newHead;
        while (node != null) {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};