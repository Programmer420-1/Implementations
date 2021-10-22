## Linked List
### Introduction
Today I try to implement a singly linked list class and a doubly linked list class by myself. This is my first attempt to implement a data structure by myself. 
I do read some articles about the working principles of a linked list. Here is what I got after reading them.
#
A singly linked list is basically a node which contain a pointer to refer its neighbouring nodes. It is like a strip of LEDs with variety colors being linked together by a single conencting wire. While the electricity is on, the current will flow through the first LED, causing it to light up in its color. Then the current will flow to the next LED and the same things happen again until it reaches the end of the wire. Think of every LED in the strip is a node and their colors is the piece of data they store. 
<br><br>
Well, for the case of a doubly linked list, the working principle behind is still the same, but this time the current can flow from the start to the end of strip and the other way around. Meaning that each LED has two connecting wire, one is linked to the next LED while the other is linked to its previous LED.
<br><br>
With these concepts in my mind, I can finally start implementing the class of a linked list, I will be using Java this time. Just for practicing.
#
### A Singly Linked List
A simple singly linked list is very easy to implement. We need to create a class, which contain only 1 attribute, 1 private class and a few methods for functionality.
```
    class SinglyLinekedList{
    private Node head = null;
        
        private class Node{
            Node next = null;
            int data;
            Node(int i){
                this.next = null;
                this.data = i;
            }
        }
        
        public void printAll(){
            Node n = head;
            while(n.next != null){
                System.out.print(n.data + " ");
                n = n.next;
            }
        }
        
        public void add(int i){
            if (head == null){
                head = new Node(i);
            }
            else{
                Node n = head;
                while (true){
                    if(n.next == null){
                        n.next = new Node(i);
                        break
                    }
                    n = n.next;
                }         
            }            
        }
    }
```


