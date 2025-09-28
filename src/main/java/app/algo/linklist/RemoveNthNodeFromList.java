package app.algo.linklist;

public class RemoveNthNodeFromList {

  public static void main(String[] args) {}

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode start = new ListNode(0);
    start.next = head;
    ListNode first = start;
    ListNode second = start;

    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return start.next;
  }
}
