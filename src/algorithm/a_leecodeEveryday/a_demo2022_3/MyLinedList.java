package algorithm.a_leecodeEveryday.a_demo2022_3;

public class MyLinedList {
    class Node{
        int val;
        Node next,prev;
        Node(int val){
            this.val = val;
        }
    }
    int n;
    Node head;
    Node tail;
    public MyLinedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        n = 0;
    }

    public int get(int index) {
        if(index >= n)return -1;
        Node cur = null;
        //if(index <= n / 2){
        cur = head;
        while(index-- > -1){
            cur = cur.next;
        }
        // }else{
        //     cur = tail;
        //     int a = (n - index);
        //     while( a -- > 0){
        //         cur = cur.prev;
        //     }
        // }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
        n++;
    }
    public void addAtTail(int val) {
        Node node = new Node(val);
        tail.prev.next = node;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        n++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 1){
            addAtHead(val);
        }else if(index == n){
            addAtTail(val);
        }else if(index < n){
            Node node = new Node(val);
            Node cur = head;
            while(index-- > -1){
                cur = cur.next;
            }
            cur.prev.next = node;
            node.next = cur;
            node.prev = cur.prev;
            cur.prev = node;
            n++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= n)return;
        // if(index >= 0 && index < n){
        Node cur = head;
        while(index-- > -1){
            cur = cur.next;
        }
        // cur.prev.next = cur.next;
        // cur.next.prev = cur.prev;
        Node nex = cur.next;
        Node pre = cur.prev;

        pre.next = nex;
        nex.prev = pre;
        n--;
    }
    //,"deleteAtIndex",[5]
    // }
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
