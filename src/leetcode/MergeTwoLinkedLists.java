package leetcode;

public class MergeTwoLinkedLists {

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

    static Node mergeTwoLists(Node head1, Node head2) {

        //Node newHead;
        MergeTwoLinkedLists result = new MergeTwoLinkedLists();

        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                result.addNode(current1.data);
                current1 = current1.next;
            } else {
                result.addNode(current2.data);
                current2 = current2.next;
            }
        }

        while(current1 != null){
            result.addNode(current1.data);
            current1 = current1.next;
        }

        while(current2 != null){
            result.addNode(current2.data);
            current2 = current2.next;
        }

        return result.head;
    }

    static void printList(Node head) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoLinkedLists list1 = new MergeTwoLinkedLists();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(4);

        MergeTwoLinkedLists list2 = new MergeTwoLinkedLists();
        list2.addNode(1);
        list2.addNode(3);
        list2.addNode(4);
        list2.addNode(5);

        Node resultList = mergeTwoLists(list1.head, list2.head);
        printList(resultList);

    }
}
