public class MyLinkedList {
    Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void printOut() {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println(current.data);
    }
}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}


class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myLinkedList.printOut();

        myLinkedList.deleteWithValue(4);

        myLinkedList.printOut();

        myLinkedList.prepend(0);
        
        myLinkedList.printOut();
    }
}