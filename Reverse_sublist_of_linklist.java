import java.util.*;

public class DLL {
    Node head;

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public DLL() {
        head = null;
    }

    public DLL create(int data, DLL list) {
        Node nn = new Node(data);
        if (list.head == null) {
            list.head = nn;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = nn;
            nn.prev = last;
        }
        return list;
    }

    public void display(DLL list) {
        if (list.head == null) {
            System.out.print("List is empty");
        }
        Node last = list.head;
        while (last != null) {
            System.out.print(last.data + " ---> ");
            last = last.next;
        }
        System.out.println("NULL");
    }

    public void reverseSublist(DLL list) {
        if (list.head == null) {
            System.out.println("List is empty");
            return;
        }

        int m = 1; // starting position
        int n = 8; // ending position

        Node current = list.head;
        Node prevM = null;
        Node nextN = null;

        // Traverse to the (m-1)th node
        for (int i = 1; i < m && current != null; i++) {
            prevM = current;
            current = current.next;
        }

        Node mNode = current;

        // Traverse to the nth node
        for (int i = m; i < n && current != null; i++) {
            current = current.next;
        }

        Node nNode = current;
        nextN = nNode.next;

        // Reverse the sublist
        Node prev = null;
        Node next = null;
        current = mNode;

        while (current != nextN) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }

        // Connect the reversed sublist to the surrounding nodes
        if (prevM != null) {
            prevM.next = nNode;
        } else {
            list.head = nNode;
        }

        mNode.next = nextN;
        if (nextN != null) {
            nextN.prev = mNode;
        }
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        int data;
        int ch;

        // Add some elements to the linked list
        list = list.create(1, list);
        list = list.create(7, list);
        list = list.create(5, list);
        list = list.create(3, list);
        list = list.create(9, list);
        list = list.create(8, list);
        list = list.create(10, list);
        list = list.create(2, list);
        list = list.create(2, list);
        list = list.create(5, list);

        list.display(list);

        // Reverse the sublist
        list.reverseSublist(list);
        list.display(list);
    }
}
