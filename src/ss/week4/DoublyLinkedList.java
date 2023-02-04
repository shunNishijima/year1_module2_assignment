package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.get(index).equals(element);
    /*@ ensures (\forall int j; 0 <= j && j < index;
                         \old(this.get(j)).equals(this.get(j))); */
    /*@ ensures (\forall int j; index <= j && j < \old(size);
                         \old(this.get(j)).equals(this.get(j + 1))); */
    public void add(int index, Element element) {
        Node newNode = new Node(element);
        Node oldNode = getNode(index);
        newNode.previous = oldNode.previous;
        newNode.next = oldNode;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;

        size++;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    /*@ ensures (\forall int j; 0 <= j && j < index;
                         \old(this.get(j)).equals(this.get(j))); */
    /*@ ensures (\forall int j; index <= j && j < this.size;
                         this.get(j).equals(\old(this.get(j + 1)))); */
    public void remove(int index) {
         // TODO: implement
        Node rnode = getNode(index);
        rnode.previous.next = rnode.next;
        rnode.next.previous = rnode.previous;
        size--;
    }

    //@ requires 0 <= index && index < this.size;
    //@ pure
    public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    private Node getNode(int i) {
        Node p = head;
        if (i > size / 2) {
            int pos = size;
            while (pos > i) {
                p = p.previous;
                pos = pos - 1;
            }
        } else {
            int pos = -1;
            while (pos < i) {
                p = p.next;
                pos = pos + 1;
            }
        }
        return p;
    }

    //@ pure
    public int size() {
        return this.size;
    }

    private class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
