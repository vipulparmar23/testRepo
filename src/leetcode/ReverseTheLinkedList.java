package leetcode;

public class ReverseTheLinkedList {

    Node head;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node addNode(int data) {
        if (head == null)
            return head = new Node(data);

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        return current.next = new Node(data);
    }

    private static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private void reverseList(Node l) {
        if (l == null)
            return;

        Node prevNode = null;
        Node current = l;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;    // 2 3 4 5
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }

        head = prevNode;
        //return head;
    }

    public static void main(String[] args) {
        ReverseTheLinkedList reverse = new ReverseTheLinkedList();
        reverse.addNode(2);
        reverse.addNode(3);
        reverse.addNode(4);
        System.out.println("Original List: ");
        printList(reverse.head);
        reverse.reverseList(reverse.head);
        System.out.println("After Reversing the List: ");
        printList(reverse.head);
    }
}
