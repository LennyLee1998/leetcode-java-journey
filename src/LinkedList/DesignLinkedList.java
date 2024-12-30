package LinkedList;

public class DesignLinkedList {

}

class MyLinkedList {

  public MyLinkedList() {

  }

  public int get(int index) {

  }

  public void addAtHead(int val) {

  }

  public void addAtTail(int val) {

  }

  public void addAtIndex(int index, int val) {

  }

  public void deleteAtIndex(int index) {

  }
}

class DoublyLinkedListNode {
  int val;
  DoublyLinkedListNode next;
  DoublyLinkedListNode prev;

  public DoublyLinkedListNode() {
  }

  public DoublyLinkedListNode(int val) {
    this.val = val;
  }

  public DoublyLinkedListNode(int val, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
    this.val = val;
    this.next = next;
    this.prev = prev;
  }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

