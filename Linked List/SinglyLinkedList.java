class SinglyLinkedList<T>{
    private Node<T> head = null;
    private int length = 0;

    private class Node<E>{
        T data;
        Node<T> next;
        Node(T i){
            this.data = i;
            this.next = null;
        }
    }

    public void add(T i){
        if(head == null){
            head = new Node<T>(i);
            // System.out.println("Added head");
        }
        else{
            Node<T> n = head;
            while (true){
                if(n.next == null){
                    n.next = new Node<T>(i);
                    // System.out.println("Added new elem");
                    break;
                }
                // moving the pointer forward
                n = n.next;
            }
        }
        length++;
    }
    
    public void insertBegin(T i){
        Node<T> newhead = new Node<>(i);
        Node<T> temp = head;
        head = newhead;
        newhead.next = temp;
        length++;

    }

    public void insertEnd(T i){
        Node<T> n = head;
        while (true){
            if(n.next == null){
                n.next = new Node<T>(i);
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

    public T shift(){
        if(head == null){
            System.out.println("Empty Linked list");
            return null;
        }
        T shifted = head.data;
        head = head.next;
        length--;
        return shifted;
    }

    public T pop(){
        Node<T> n = head;
        Node<T> prev = null;
        for (int i = 0 ; i < length-1 ; i++){
            prev = n;
            n = n.next;
        }
        T popped = n.data;
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
            Node<T> n = head;
            Node<T> prev = null;
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

    @Override
    public String toString(){
        Node<T> n = head;
        String returning = "";
        returning += "[";
        while(n != null){
            if(n.next == null){
                returning += n.data.toString();
            }
            else{
                returning += (n.data.toString() + ", ");
            }
            n = n.next;
        }
        returning += "]";
        return returning;
    }
    
}
