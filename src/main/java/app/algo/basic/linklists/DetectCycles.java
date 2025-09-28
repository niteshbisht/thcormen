package app.algo.basic.linklists;

import static app.algo.util.AlgoUtils.createListNodeFromArray;

import app.algo.util.ListNode;
import java.util.HashSet;
import java.util.Set;

public class DetectCycles {
  public static boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
      if (nodesSeen.contains(head)) {
        return true;
      } else {
        nodesSeen.add(head);
      }
      head = head.next;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode listNodeFromArray = createListNodeFromArray(new int[] {1, 2, 3, 4, 5, 6});
    ListNode start = listNodeFromArray;
    while (start.next != null) {
      start = start.next;
    }
    start.next = listNodeFromArray.next;
    boolean hasCycle = hasCycle(listNodeFromArray);
    System.out.println(hasCycle);
  }
}
