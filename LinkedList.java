
/**
* @author      Jiachao Chen <jc3345@cornell.edu>

*<p>
*5 classical linked list questions: 
* 1. Reverse a linked list recursively(in-place) and iteratively
* 2. Delete a node from linked list
* 3. Find the nth node
* 4. Find the nth node from the end
* 5. Test if a linked list has a cycle
*<p>


 */


public class SingleLinkedList<E> {
  class ListNode {
       E val;
       ListNode next;
      ListNode() {}

      ListNode(E val) {
           this.val = val;
       }
   }

  private ListNode dummyHead;
  private ListNode tail;
  private int size;

  public SingleLinkedList() {
       dummyHead = new ListNode();
       tail = dummyHead;
       size = 0;
   }

  public void add(E val) {
     tail.next = new ListNode(val);
     tail = tail.next;
     size++;
   }


  public ListNode reversedList() {
      ListNode head = dummyHead;
      if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        while(cur !=null){
            ListNode next = cur.next;
            cur.next= prev;
            prev =  cur;
            cur = next;      
        }
      
      return prev;
    }

  public void printReversedList(){
    ListNode test = reversedList();

    while(test != null){
      System.out.println(test.val);
      test = test.next;
    }

  }

  public void deleteNode(ListNode node) {
    if(node.next == null) return;
      node.val = node.next.val;
      node.next= node.next.next;
  }

  public ListNode findNthNode(int n){
      if(size == 0) return null;

      ListNode head = dummyHead.next;
      for(int i = 0; i<n && head != null; i++){
        head = head.next;
      }

      return head;
  }

  public void printFindNthNode(int n){
    ListNode test = findNthNode(n);
    System.out.println("size :" + size);
    System.out.println(test.val);

  }

  public ListNode findNthNodeFromEnd(int n) {
        if(size == 0) return null;

        ListNode head = dummyHead.next;
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0; i<n ; i++){
            fast =  fast.next;
            if(fast == null && i != n-1) return null;
        }
        
        if(fast == null){
            return head;
        }
        
        fast = fast.next;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.next;
  }


  public void printFindNthNodeFromEnd(int n){
    ListNode test = findNthNodeFromEnd(n);
    System.out.println("size :" + size);
    System.out.println(test.val);

  }

  public boolean hasCycle() {
      if(size == 0) return false;

      ListNode head = dummyHead.next;

      ListNode slow = head;
      ListNode fast = head;
  
      while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) 
                return true;
        }
  
        return false;
  }

  public void createCycle(){
    tail.next = dummyHead.next;

  }
  public void pirntHasCycle(){
    if(hasCycle()){
      System.out.println("list has cycle");
    }else{
      System.out.println("list doesn't have cycle");
    }
  }


  public static void main(String[] args) {
      SingleLinkedList<Integer> list = new SingleLinkedList<>();

      for(int i = 0; i< 10; i++){
        list.add(i);
      }


      //list.printReversedList();
      list.printFindNthNode(3);
      list.printFindNthNodeFromEnd(3);
      list.createCycle();
      list.pirntHasCycle();

  }


}



