package leetcode;

public class DeleteNodeLinkedList {

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

    public Node deleteNode(Node l, int deleteValue){
        if(l == null)
            return head;

        if(l.data == deleteValue) {
            l = l.next;
            head = l;
        }

        Node current = l;

        while(current.next != null){
            if(current.next.data == deleteValue){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return l;
    }

    public static void main(String[] args){
        DeleteNodeLinkedList del = new DeleteNodeLinkedList();
        del.addNode(2);
        del.addNode(9);
        del.addNode(3);
        del.addNode(5);
        del.addNode(8);
        System.out.println(" Original List : ");
        printList(del.head);
        del.deleteNode(del.head, 1);
        System.out.println("\n After deletion : ");
        printList(del.head);
    }
}
