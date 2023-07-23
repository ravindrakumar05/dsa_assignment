import java.util.HashSet;

 class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesLinkedList {
    Node head;

    // Function to remove duplicates from the linked list
    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        HashSet<Integer> seenSet = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seenSet.contains(current.data)) {
                prev.next = current.next;
            } else {
                seenSet.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    // Function to insert data at the end of the linked list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Function to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example input linked list with duplicates
        RemoveDuplicatesLinkedList list = new RemoveDuplicatesLinkedList();
        list.insertEnd(5);
        list.insertEnd(2);
        list.insertEnd(8);
        list.insertEnd(2);
        list.insertEnd(5);
        list.insertEnd(3);
        list.insertEnd(8);

        System.out.println("Original Linked List:");
        list.printList();

        // Remove duplicates
        list.removeDuplicates();

        System.out.println("Linked List after removing duplicates:");
        list.printList();
    }
}
