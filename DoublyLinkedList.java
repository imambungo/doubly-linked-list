// M. Imam Pratama
// 09021281722063
// IF REG A '17

public class DoublyLinkedList{
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
            pointer.setNext(new ListNode(value,pointer));
        }
        return true;
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
        ListNode untukReturn = this.head;
        if (this.head != null) {
            this.head = this.head.getNext();
            untukReturn.next = null;// apakah harus pakai ini?
        }
        return untukReturn;
    }

    public void add(int index, int nilai) {
        if (index < 0 || index > size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index > size())
                System.out.println("\tvoid add(" + index + "," + nilai + ") -> Max index allowed: " + (size()-1));
            if (index < 0)
                System.out.println("\tvoid add(" + index + "," + nilai + ") -> Minimum index is 0");
            System.exit(0);
        } else if (index == 0) {
            insertFirst(nilai);
        } else if (index == size()) {
            add(nilai);
        } else {
            ListNode nodeBaru;
            ListNode pointer = next;
            while (index > 0) {
                pointer = pointer.next;
                index--;
            }
            nodeBaru = new ListNode(nilai,pointer.prev);
            pointer.prev.next = nodeBaru;
            pointer.prev = nodeBaru;
            nodeBaru.next = pointer;
            this.size++;
            this.sum += nilai;
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
            System.out.print(","+pointer.getValue());
            pointer = pointer.getNext();
        }
        System.out.println("]");
    }

    public float get(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Error: Index out of bound gan :v");
            if (index >= size())
                System.out.println("\tfloat get(" + index + ") -> Maximum index is " + (size()-1));
            if (index < 0)
                System.out.println("\tfloat get(" + index + ") -> Minimum index is 0");
            System.exit(0);
        } else {
            ListNode pointer = next;
            while (index > 0) {
                pointer = pointer.next;
                index--;
            }
            return pointer.getValue();
        }
        return -1;
    }

    public ListNode removeLast() {
        ListNode temp = null;
        if (next != null){
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
        } else if (index == size()-1) {
            temp = removeLast();
        } else {
            ListNode pointer = next;
            while (index > 1) {
                pointer = pointer.next;
                index--;
            }
            temp = pointer.next;//!
            pointer.next.next.prev = pointer;
            pointer.next = pointer.next.next;
            this.sum -= temp.getValue();
            this.size--;
        }
        return temp;
    }
}
class ListNode{
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