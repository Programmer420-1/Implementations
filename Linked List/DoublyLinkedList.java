public class DoublyLinkedList<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    private class Node<E>{
        T data;
        Node<T> next;
        Node<T> prev;
        Node(T i){
            this.data = i;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(T i){
        if(head == null){
            head = new Node<T>(i);
            tail = head;
            // System.out.println("Added head");
        }
        else{
            Node<T> n = head;
            while (true){
                if(n.next == null){
                    n.next = new Node<T>(i);
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

    public void insertBegin(T i){
        Node<T> newhead  = new Node<>(i);
        head.prev = newhead;
        newhead.next =  head;
        head = newhead;
        length++;
    }

    public void insertEnd(T i){
        Node<T> newtail = new Node<>(i);
        newtail.prev = tail;
        tail.next = newtail;
        tail = newtail;
        length++;
    }

    public void insertAt(T i,int position){
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
                Node<T> n = tail;
                for (int k = 0; k < -(position+1) ; k++){
                    n = n.prev;
                }
                Node<T> newNode = new Node<>(i);
                newNode.next = n.next;
                n.next.prev = newNode;
                newNode.prev = n;
                n.next = newNode;
            }
        }
        else{
            Node<T> n = head;
            for (int k = 0; k < position-1 ; k++){
                n = n.next;
            }
            Node<T> newNode = new Node<>(i);
            newNode.next = n.next;
            n.next.prev = newNode;
            newNode.prev = n;
            n.next = newNode;
        }
        length++;
    }

    public T pop(){
        T popped = tail.data;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        length--;
        return popped;
    }

    public T shift(){
        T shifted = head.data;
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
            Node<T> n = tail;
            for (int i = 0; i < -(-position+1) ; i++ ){
                n = n.prev;
            }
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n.next = null;
            n.prev = null;
        }
        else{
            Node<T> n = head;
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
    
    // method overloading
    public String toString(boolean reverse){
        if (reverse){
            Node<T> n = tail;
            String returning = "";
            returning += "[";
            while(n != null){
                if(n.prev == null){
                    returning += n.data.toString();
                }
                else{
                    returning += (n.data.toString() + ", ");
                }
                n = n.prev;
            }
            returning += "]";
            return returning;
        }
        else { 
            return toString();
        }
    }

    
}
