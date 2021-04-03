package app.algo.basic.linklists.flattenlst;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenNode {
    Node tail;

    public static Node flatten(Node head) {
        if (head == null) return null;
        Node pseudoHead = new Node(-1, null, head, null);
        Node curr, prev;
        prev = pseudoHead;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;
            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public static void main(String[] args) {
    }

    Node flattenNodeRecursive(Node root) {
        if (root == null) return null;
        Node pseudoNode = new Node(-1, null, root, null);
        flattenDfs(pseudoNode, root);
        pseudoNode.next.prev = null;
        return pseudoNode.next;
    }

    Node flattenDfs(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        Node tempNextNode = curr.next;

        Node tail = flattenDfs(curr, curr.child);
        curr.child = null;

        return flattenDfs(tail, tempNextNode);
    }

    Node flattenDfsV2(Node head) {
        if (head == null) return null;
        head.prev = tail;
        tail = head;
        Node nextNode = head.next;
        head.next = flattenDfsV2(head.child);
        head.child = null;
        tail.next = flattenDfsV2(nextNode);
        return head;
    }
}
