package LinkedList;

public class LinkNode {
  int value;
//  next是LinkNode对象 LinkNode对象本身就是地址 使用这个来找下一个节点 来组成链表
  LinkNode next;

  public LinkNode() {
  }

  public LinkNode(int value) {
    this.value = value;
  }

  public LinkNode(int value, LinkNode next) {
    this.value = value;
    this.next = next;
  }
}
