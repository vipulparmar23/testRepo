package leetcode;

public class RemoveNthNode {

    Node head;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public Node addNode(int data) {
        if (head == null) {
            return head = new Node(data);
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current.next = new Node(data);
    }

    public Node removeNthNodeFromEnd(Node head, int k) {

        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNode rNode = new RemoveNthNode();
        rNode.addNode(1);
//        rNode.addNode(2);
//        rNode.addNode(3);
//        rNode.addNode(4);
//        rNode.addNode(5);

        Node result = rNode.removeNthNodeFromEnd(rNode.head, 1);
        //System.out.println(result.data);
    }
}
