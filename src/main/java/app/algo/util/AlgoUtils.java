package app.algo.util;

public class AlgoUtils {
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static TreeNode createTree() {
        TreeNode one = createT(1);
        TreeNode two = createT(2);
        TreeNode three = createT(3);
        TreeNode four = createT(4);
        TreeNode five = createT(5);
        TreeNode six = createT(6);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        return one;
    }

    static TreeNode createT(int val) {
        return new TreeNode(val, null, null);
    }

    public static ListNode createListNodeFromArray(int[] arr) {
        ListNode start = null;
        ListNode prev = null;
        for (int i : arr) {
            if(start==null) {
                start = createNode(i);
                prev = start;
                continue;
            }
            if(prev!=null) {
                prev.next = createNode(i);
                prev = prev.next;
            }
        }
        return start;
    }

    static ListNode createNode(int val) {
        return new ListNode(val);
    }
}
