public class ListaEncadeada {
    private Node base;
    private Node top;
    private int size;
    private int capacity;

    public ListaEncadeada(int capacity) {
        this.base = null;
        this.top = null;
        this.size = 0;
        this.capacity = capacity;

    }

    public boolean isEmpty(){
        if(this.base == null){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public int getSize() {
        return size;
    }

    public void addPos(int pos, int value) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node newNode = new Node(value);

        if (pos == 0) {
            if (base == null) {
                base = newNode;
                top = newNode;
            } else {
                newNode.next = base;
                base.previous = newNode;
                base = newNode;
            }
        }

        else if (pos == size) {
            if (top == null) {
                base = newNode;
                top = newNode;
            } else {
                top.next = newNode;
                newNode.previous = top;
                top = newNode;
            }
        }

        else {
            Node current = getNode(pos);
            Node previousNode = current.previous;

            newNode.next = current;
            newNode.previous = previousNode;

            if (previousNode != null) {
                previousNode.next = newNode;
            }
            current.previous = newNode;
        }
        size++;
    }

    public void add(int value) {
        Node node = new Node(value);

        if (isEmpty() == true) {
            this.base = node;
            this.top = node;
            size ++;
        }else{
            Node anterior = top;
            this.top.next=  node;
            this.top = node;
            size ++;
        }
    }

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = base;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = top;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;

    }

    public int remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current = getNode(pos);
        int data = current.data;

        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            base = current.next;
        }

        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            top = current.previous;
        }

        size--;
        return data;
    }

    public int remove(Node node) {

        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            base = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            top = node.previous;
        }

        size--;
        return node.data;
    }

    public Node getNodePos(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current;
        if (pos < size / 2) {
            current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = top;
            for (int i = size - 1; i > pos; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public void set(int pos, int value) {
        Node current = getNode(pos);
        current.data = value;
    }

    public int find(int value) {
        Node current = base;
        int position = 0;

        while (current != null) {
            if (current.data.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1;
    }


}
