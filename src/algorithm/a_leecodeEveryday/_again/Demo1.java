package algorithm.a_leecodeEveryday._again;

public class Demo1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
       // l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);
    }
    //2. 两数相加
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        while(l1 != null && l2 !=null){
            l1.val += l2.val;
            ListNode decate = l1;
            while(decate.val >= 10){
                decate.val = decate.val-10;
                if(decate.next == null){
                     ListNode node = new ListNode(1);
                     node.next = decate.next;
                     decate.next = node;
                }else{
                    decate.next.val+=1;
                }
                decate = decate.next;
            }
            //解决l1先结束的问题,没有next说明也没有进位
            if(l1.next == null && l2.next != null){
                l1.next = l2.next;
                break;
            }
            l1 = l1.next;
            l2= l2.next;
        }
        return curr;
    }
}
