package LinkedList;

public class DesignLinkedList_SimplyNode {
  //  1. 单向链表节点node, 作为工具类
  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }
  // dummynode在增删节点是比较有用的, dummy node本身不能为null,否则的话取不到next属性, 也就没有意义了
  // 避免处理空链表或者链表边界
  public ListNode dummyHead;
  public int size;

  public DesignLinkedList_SimplyNode() {
    this.size = 0;
    this.dummyHead = new ListNode(0);
  }

  public int get(int index) {

    if (index < 0 || index >= size) {
      return -1;
    }

    ListNode cur = dummyHead;
    for (int i = 0; i <= index; i++) {
      cur = cur.next;
    }

    return cur.val;
  }

  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);

    newNode.next = dummyHead.next;
    dummyHead.next = newNode;
    size++;

  }

  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    ListNode cur = dummyHead;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = newNode;
    size++;
  }

  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    ListNode newNode = new ListNode(val);
    ListNode last = dummyHead;
    for (int i = 0; i < index; i++) {
      last = last.next;
    }
    newNode.next = last.next;
    last.next = newNode;
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    ListNode last = dummyHead;
    for (int i = 0; i < index; i++) {
      last = last.next;
    }
    last.next = last.next.next;
    size--;
  }
}
