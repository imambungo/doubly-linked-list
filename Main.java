// M. Imam Pratama
// 09021281722063
// IF REG A '17

// append       22
// insertFirst  37
// insertAfter  44
// delFirst     70
// delAfter     79
// delLast      106
// print        125

class DoublyLinkedList {
    // Spesifikasi tugas: hanya head tanpa tail
    private ListNode head;

    // Konstruktor
    public DoublyLinkedList() {
        this.head = null;
    }

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
        // return boolean -> mengikuti LinkedList bawaan java -> boolean add(value)
    }

    public void insertFirst(float value) {
        ListNode newNode = new ListNode(value, null);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    // Masukkan value setelah index ke-n
    public void insertAfter(float value, int index) {
        if (index < 0) {// karena length/size tidak masuk spesifikasi tugas, pengecekan index melebihi
                        // batas tidak dilakukan disini.
            System.out.println("Error: Index out of bound");
            System.out.println("\tvoid insertAfter(" + index + "," + value + ") -> Minimum index is 0");
            return;
        } else {
            ListNode nodeBaru;
            ListNode pointer = this.head;
            while (index > 0) {
                pointer = pointer.getNext();
                if (pointer == null) {// Cek jika index melewati batas
                    System.out.println("Error: Index out of bound");
                    return;
                }
                index--;
            }
            nodeBaru = new ListNode(value, pointer);
            if (pointer.getNext() != null) { // Cegah null pointer exception jika sudah di ujung list
                pointer.getNext().setPrev(nodeBaru);
            }
            nodeBaru.setNext(pointer.getNext());
            pointer.setNext(nodeBaru);
        }
    }

    public ListNode delFirst() {
        ListNode returnNode = this.head;
        if (this.head != null) {
            this.head = this.head.getNext();
        }
        return returnNode;
    }

    // Hapus node setelah node pada index ke-n
    public ListNode delAfter(int index) {
        ListNode returnNode = null;
        if (index < 0) {
            System.out.println("Error: Index out of bound");
            System.out.println("\tvoid delAfter(" + index + ") -> Minimum index is 0");
            return null;
        } else {
            ListNode pointer = head;
            while (index > 0) {
                pointer = pointer.getNext();
                if (pointer == null) {// Cek jika index melewati batas
                    System.out.println("Error: Index out of bound");
                    return null;
                }
                index--;
            }
            returnNode = pointer.getNext();
            if (pointer.getNext() != null) {// Cegah null pointer exception jika sudah di lastNode
                if (pointer.getNext().getNext() != null) {// Cegah null pointer exception jika sudah di lastNode
                    pointer.getNext().getNext().setPrev(pointer);// prev harus diganti dari node yg dihapus ke pointer
                }
                pointer.setNext(pointer.getNext().getNext());
            }
        }
        return returnNode;
    }

    public ListNode delLast() {
        ListNode returnNode = null;
        if (this.head != null) {
            if (head.getNext() == null) {
                returnNode = this.head;
                this.head = null;
            } else {
                // Karena tidak pakai tail, traverse
                ListNode pointer = this.head;
                while (pointer.getNext() != null) {
                    pointer = pointer.getNext();
                }
                returnNode = pointer;
                pointer.getPrev().setNext(null);
            }
        }
        return returnNode;
    }
    
    public void print() {
        System.out.print("[");
        ListNode pointer = this.head;
        if (this.head != null) {
            System.out.print(this.head.getValue());
            pointer = pointer.getNext();
        }
        while (pointer != null) {
            System.out.print(", " + pointer.getValue());
            pointer = pointer.getNext();
        }
        System.out.println("]");
    }
}

class ListNode {
    private float value;
    private ListNode next;
    private ListNode prev;

    // Konstruktor
    public ListNode(float value, ListNode prev) {
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

class Main {
    public static void main(String[] args) {
        DoublyLinkedList a = new DoublyLinkedList();
        System.out.println("Deklarasi");
        a.print();

        System.out.println("\nappend 4 kali");
        for (int i = 0; i < 4; i++) {
            a.append(i);
            a.print();
        }

        System.out.println("\ndelLast 4 kali");
        for (int i = 0; i < 4; i++) {
            a.delLast();
            a.print();
        }

        System.out.println("\ninsertFirst 4 kali");
        for (int i = 0; i < 4; i++) {
            a.insertFirst(i);
            a.print();
        }

        System.out.println("\ndelFirst 4 kali");
        for (int i = 0; i < 4; i++) {
            a.delFirst();
            a.print();
        }

        System.out.println("\ninsertFirst");
        a.insertFirst(34);
        a.print();

        System.out.println("\ninsertAfter 4 kali");
        for (int i = 0; i < 4; i++) {
            a.insertAfter(3.2f*i,i);
            a.print();
        }

        System.out.println("\ninsert 99 After index 0");
        a.insertAfter(99,0);
        a.print();

        System.out.println("\ninsert 99 After index 2");
        a.insertAfter(99,2);
        a.print();

        System.out.println("\ninsert 99 After index 6");
        a.insertAfter(99,6);
        a.print();

        System.out.println("\ndelAfter index 6");
        a.delAfter(6);
        a.print();
        
        System.out.println("\ndelAfter index 6 lagi");
        a.delAfter(6);
        a.print();
        System.out.println("(index 7 == null)");

        System.out.println("\ndelAfter index 0");
        a.delAfter(0);
        a.print();
        
        System.out.println("\ndelAfter index 3");
        a.delAfter(3);
        a.print();
    }
}