package leetcode;

public class SwapPairNodes {

    Node head;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public Node addNode(int data) {
        if (head == null)
            return head = new Node(data);

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current.next = new Node(data);
    }

    public Node swapPairs(Node head){
        if (head == null)
            return head;

        if(head.next == null)
            return head;

        Node current = head.next;
        Node nextNode = current.next;
        current.next = head;
        head.next = swapPairs(nextNode);
        return current;
    }

    public static void main(String[] args){

    }

}
