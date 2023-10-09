class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; 
        }

        
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        Node secondHalf = reverse(slow.next);
        slow.next = null; 

        
        Node p1 = head;
        Node p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false; // Not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        
        slow.next = reverse(secondHalf);

        return true; 
    }

    
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
