// M. Imam Pratama
// 09021281722063
// IF REG A '17

class Main {
    public static void main(String[] args) {
        DoublyLinkedList a = new DoublyLinkedList();

    }
}

class DoublyLinkedList {
    // Spesifikasi tugas: hanya head tanpa tail
    private ListNode head;

    public boolean append(int value) {
        if (this.head == null) {
            head = new ListNode(value, null);
        } else {
            // Karena tidak pakai tail, traverse ke lastNode
            ListNode pointer = this.head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(new ListNode(value, pointer));
        }
        return true;
        // return boolean -> mengikuti LinkedList bawaan java
    }

    public void insertFirst(int value) {
        if (this.head == null) {
            this.head = new ListNode(value, null);
        } else {
            ListNode newNode = new ListNode(value, null);
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    public ListNode delFirst() {
        ListNode returnNode = this.head;
        if (this.head != null) {
            this.head = this.head.getNext();
        }
        return returnNode;
    }

    public void insertAfter(int index, int nilai) {
        if (index < 0) {
            /*
             * karena length/size tidak masuk spesifikasi, pengecekan index melewati batas
             * tidak dilakukan disini.
             */
            System.out.println("Error: Index out of bound");
            System.out.println("\tvoid insertAfter(" + index + "," + nilai + ") -> Minimum index is 0");
            System.exit(0);
        } else if (index == 0) {
            insertFirst(nilai);
        } else {
            ListNode nodeBaru;
            ListNode pointer = this.head;
            while (index > 0) {
                pointer = pointer.getNext();
                index--;
            }
            nodeBaru = new ListNode(nilai, pointer.getPrev());
            pointer.getPrev().setNext(nodeBaru);
            pointer.setPrev(nodeBaru);
            nodeBaru.setNext(pointer);
        }
    }

    public void print() {
        System.out.print("[");
        ListNode pointer = this.head;
        if (this.head != null) {
            System.out.print(this.head.getValue());
            pointer = pointer.getNext();
        }
        while (pointer != null) {
            System.out.print("," + pointer.getValue());
            pointer = pointer.getNext();
        }
        System.out.println("]");
    }

    public ListNode removeLast() {
        ListNode temp = null;
        if (next != null) {
            if (next.next == null) {
                temp = next;
                this.sum -= next.getValue();
                next = null;
            } else {
                temp = tail;
                this.sum -= temp.getValue();
                tail.prev.next = null;
                tail = tail.prev;
            }
            this.size--;
        }
        return temp;
    }

    public ListNode remove(int index) {
        ListNode temp = null;
        if (index < 0 || index >= size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index >= size())
                System.out.println("\tvoid remove(" + index + ") -> Maximum index is " + (size() - 1));
            if (index < 0)
                System.out.println("\tvoid remove(" + index + ") -> Minimum index is 0");
            System.exit(0);
        } else if (index == 0) {
            temp = delFirst();
        } else if (index == size() - 1) {
            temp = removeLast();
        } else {
            ListNode pointer = next;
            while (index > 1) {
                pointer = pointer.next;
                index--;
            }
            temp = pointer.next;// !
            pointer.next.next.prev = pointer;
            pointer.next = pointer.next.next;
            this.sum -= temp.getValue();
            this.size--;
        }
        return temp;
    }
}

class ListNode {
    private float value;
    private ListNode next;
    private ListNode prev;

    public ListNode(int value, ListNode prev) {
        this.value = value;
        this.prev = prev;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return this.prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
}