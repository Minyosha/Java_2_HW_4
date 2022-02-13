public class LinkedList<Element> {
    private long size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    private class Node {
        Element data;
        Node next;

        public Node(Element data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNodeToTail(Element data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addByIndex(int index, Element data) {
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = null;

        if ((index > size) | (index < 0)) {
            System.out.println("Размер индекса больше, чем размер списка или индекс отрицательный");
            System.out.println("Добавление элемента " + data + " с индексом " + index + " не может быть произведено.");
            return;
        }
        if (head != null && index == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        Node current = this.head;
        Node previous = null;

        int i = 0;
        while (i < index) {
            previous = current;
            current = current.next;
            if (current == null) {
                break;
            }
            i++;

        }
        newNode.next = current;
        assert previous != null;
        previous.next = newNode;
    }

    public void deleteByIndex(int index) {
        if ((index > size) | (index < 0)) {
            System.out.println("Размер индекса больше, чем размер списка или индекс отрицательный.");
            System.out.println("Удаление элемента с индексом " + index + " не может быть произведено.");
            return;
        }
        Node current = head;
        if (index > 0) {
            for (int i = 1; i <= index - 1; i++) {
                current = current.next;
            }
        } else {
            head = current.next;
        }
        current.next = current.next.next;
        System.out.println("Удаление элемента с индексом " + index + " произведено.");
    }


    public void print() {
        System.out.println("Печать связанного списка начинается с нулевого элемента:");
        Node current = head;
        if (head == null) {
            return;
        }
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}