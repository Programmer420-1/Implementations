class SLinkedList{
    private Node head = null;
    private int length = 0;

    private class Node{
        int data;
        Node next;
        Node(int i){
            this.data = i;
            this.next = null;
        }
    }

    public void add(int i){
        if(head == null){
            head = new Node(i);
            // System.out.println("Added head");
        }
        else{
            Node n = head;
            while (true){
                if(n.next == null){
                    n.next = new Node(i);
                    // System.out.println("Added new elem");
                    break;
                }
                // moving the pointer forward
                n = n.next;
            }
        }
        length++;
    }
    
    public void insertBegin(int i){
        Node newhead = new Node(i);
        Node temp = head;
        head = newhead;
        newhead.next = temp;
        length++;

    }

    public void insertEnd(int i){
        Node n = head;
        while (true){
            if(n.next == null){
                n.next = new Node(i);
                break;
            }
            n=n.next;
        }
        length++;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    }

    public int shift(){
        if(head == null){
            System.out.println("Empty Linked list");
            return 0;
        }
        int shifted = head.data;
        head = head.next;
        length--;
        return shifted;
    }

    public int pop(){
        Node n = head;
        Node prev = null;
        for (int i = 0 ; i < length-1 ; i++){
            prev = n;
            n = n.next;
        }
        int popped = n.data;
        prev.next = null;
        length--;
        return popped;
    }

    public void deleteAt(int position){
        if (position > length-1){
            System.out.println("Position is greater than the length of the linked list");
        }
        else if(head == null){
            System.out.println("Empty Linked list");
        }
        else if (position < 0){
            System.out.println("Position is always a positive integer");
        }
        else if(position == length-1){
            pop();
        }
        else if(position == 0){
            shift();
        }
        else{
            Node n = head;
            Node prev = null;
            for (int i = 0 ; i < position ; i++){
                prev = n;
                n = n.next;
            }
            prev.next = n.next;
            length--;
        }
    }
    
    public int length(){
        return length;
    }

    public void printAll(){
        Node n = head;
        System.out.print("< ");
        while(n != null){
            if(n.next == null){
                System.out.print(n.data + "");
            }
            else{
                System.out.print(n.data + ", ");
            }
            n = n.next;
        }
        System.out.print(" >\n");
    }
    
}

class DLinkedList{
    private Node head = null;
    private Node tail = null;
    private int length = 0;

    private class Node{
        int data;
        Node next;
        Node prev;
        Node(int i){
            this.data = i;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(int i){
        if(head == null){
            head = new Node(i);
            tail = head;
            // System.out.println("Added head");
        }
        else{
            Node n = head;
            while (true){
                if(n.next == null){
                    n.next = new Node(i);
                    tail = n.next;
                    tail.prev = n;
                    // System.out.println("Added new elem");
                    break;
                }
                // moving the pointer forward
                n = n.next;
            }
        }
        length++;
        // System.out.println(length);
    }

    public void insertBegin(int i){
        Node newhead  = new Node(i);
        head.prev = newhead;
        newhead.next =  head;
        head = newhead;
        length++;
    }

    public void insertEnd(int i){
        Node newtail = new Node(i);
        newtail.prev = tail;
        tail.next = newtail;
        tail = newtail;
        length++;
    }

    public void insertAt(int i,int position){
        if (position >= length){
            System.out.println("Out of Index");
            return;
        }
        else if (position == 0){
            insertBegin(i);
        }
        // insert from tail
        else if(position < 0){
            if (-(position) >= length+1){
                System.out.println("Out of Index");
                return;
            }
            else if(position == -1){
                insertEnd(i);
            }
            else{
                Node n = tail;
                for (int k = 0; k < -(position+1) ; k++){
                    n = n.prev;
                }
                Node newNode = new Node(i);
                newNode.next = n.next;
                n.next.prev = newNode;
                newNode.prev = n;
                n.next = newNode;
            }
        }
        else{
            Node n = head;
            for (int k = 0; k < position-1 ; k++){
                n = n.next;
            }
            Node newNode = new Node(i);
            newNode.next = n.next;
            n.next.prev = newNode;
            newNode.prev = n;
            n.next = newNode;
        }
        length++;
    }

    public int pop(){
        int popped = tail.data;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        length--;
        return popped;
    }

    public int shift(){
        int shifted = head.data;
        head = head.next;
        head.prev.next = null;
        head.prev = null;
        length--;
        return shifted;
    }

    public void deleteAt(int position){
        if (position > length-1){
            System.out.println("Out of Index");
        }
        else if(head == null){
            System.out.println("Empty Linked list");
        }
        else if(position == length-1 || position == -1){
            pop();
        }
        else if(position == 0 || position == -length){
            shift();
        }
        else if (position < 0){
            Node n = tail;
            for (int i = 0; i < -(-position+1) ; i++ ){
                n = n.prev;
            }
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n.next = null;
            n.prev = null;
        }
        else{
            Node n = head;
            for (int i = 0 ; i < position ; i++){
                n = n.next;
            }
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n.next = null;
            n.prev = null;
        length--;
        }
    }

    public int length(){
        return length;
    }

    public void printAll(){
        Node n = head;
        System.out.print("< ");
        while(n != null){
            if(n.next == null){
                System.out.print(n.data + "");
            }
            else{
                System.out.print(n.data + ", ");
            }
            n = n.next;
        }
        System.out.print(" >\n");
    }
    
    // method overriding
    public void printAll(boolean reverse){
        if (reverse){
            Node n = tail;
            System.out.print("< ");
            while(n != null){
                if(n.prev == null){
                    System.out.print(n.data + "");
                }
                else{
                    System.out.print(n.data + ", ");
                }
                n = n.prev;
            }
            System.out.print(" >\n");
        }
        else { 
            printAll();
        }
    }
}

class Main{
    public static void main(String[] args){
        DLinkedList dlist = new DLinkedList();
        SLinkedList slist = new SLinkedList();
    }
}