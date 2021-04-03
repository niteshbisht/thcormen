package app.algo.easy;

import app.algo.util.AlgoUtils;
import app.algo.util.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CheckLinkedListPallindrome {

    private ListNode frontPointer;

    public boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPallindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    boolean findPalindrome(ListNode node) {
        List<Integer> valList = new ArrayList<>();
        ListNode curr = node;
        while (curr != null) {
            valList.add(curr.val);
            curr = curr.next;
        }
        int start = 0, end = valList.size() - 1;
        while (start < end) {
            if (!valList.get(start).equals(valList.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode arrayNode = AlgoUtils.createListNodeFromArray(new int[]{1, 2, 3, 2, 1});
        CheckLinkedListPallindrome clp = new CheckLinkedListPallindrome();
        // log.info("is palindrome: {}", clp.isPallindrome(arrayNode));
        log.info("is palindrome: {}", clp.findPalindrome(arrayNode));
    }
}
