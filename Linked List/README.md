## Linked List
### Introduction
Today I try to implement a singly linked list class and a doubly linked list class by myself. This is my first attempt to implement a data structure by myself. 
I do read some articles about the working principles of a linked list. Here is what I got after reading them.
#
A singly linked list is basically a node which contain a pointer to refer its neighbouring nodes. It is like a strip of LEDs with variety colors being linked together by a single conencting wire. While the electricity is on, the current will flow through the first LED, causing it to light up in its color. Then the current will flow to the next LED and the same things happen again until it reaches the end of the wire. Think of every LED in the strip is a node and their colors is the piece of data they store. <br>
__Singly Linked List__
![singlyLinkedList](https://cdn.programiz.com/sites/tutorial2program/files/linked-list-concept_0.png)
<br><br>
Well, for the case of a doubly linked list, the working principle behind is still the same, but this time the current can flow from the start to the end of strip and the other way around. Meaning that each LED has two connecting wire, one is linked to the next LED while the other is linked to its previous LED.<br>
![doublyLinkedList](https://cdn.programiz.com/sites/tutorial2program/files/doubly-linked-list-concept.png)
<br><br>
With these concepts in my mind, I can finally start implementing the class of a linked list, I will be using Java this time. Just for practicing.
#
### A Singly Linked List
A simple singly linked list is very easy to implement. We need to create a class, which contain only 1 attribute, 1 private class and a few methods for functionality.
```java
    class SinglyLinkedList{
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
To explain what I have done, I need to start with the private class declaration part first. The class is made private so that only the methods inside SinglyLinkedList are able to call te class and create an instance from it. This is to ensure that the linkage in linked list is always in control and reduce the chances of breaking. In the private class, we have a constructor there that will accepts one integer argument. The constructor will "build" a new node and store the integer in the node. The new node will always point to "null" by default as I am appending the new node to the end of the linked list. As a new node is always the last node in a singly linked list, the new node will always point ot "null". Voila, a basic singly linked list class is now created. I have add more methods into the class so that the linked list serves more functionality. If you are interested you can check it out on my GitHub Implementation repo. <br>
&nbsp;*p/s: null is a keyword, which basically means the empty or void value.*
#
### A Doubly Linked List
A doubly linked list works almost the same as the singly linked list, except that a doubly linked list can be iterate from both ends. To implement it, we just need to create a class with 2 attributes, 1 private class and a few methods for functionality.
```java
    class DoublyLinkedList{
        private Node head = null;
        private Node tail = null;
        
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
        
        public void printAll(){
            Node n = head;
            while (n.next != null){
                System.out.print(n.data+ " ");
                n= n.next;
            }
        }
        
        public void printAll(boolean reverse){
            Node n = tail;
            while (n.prev != null){
                System.out.print(n.data + " ");
                n = n.prev;
            }
        }
        
        public void add(int i){
            if (head = null){
                head = new Node(i);
                tail = head;
            }
            else{
                Node n = head;
                while (true){
                    if(n.next == null){
                        tail = new Node(i);
                        tail.prev = n;
                        n.next = tail;
                        break;
                    }
                    n = n.next;
                }
            }
        }
    }
    
```
For a doubly linked list, the class now has 2 private attributes, that are head and tail. Tail is introduced to reference the last node of linked list. Besides taht, each node now has a new attribute, which is the prev attribute. This is to store the reference to its previous nodes. With these new attributes, we now can iterate from the head tot the tail of the linked list or the other way around. Hence, more functionality can be realized with ease with this features of doubly linked list. For example, we can insert a new node at any position we want to, whether it is position from the tail or from the head. To insert at a position from the tail, we can create a method that takes in negative integer argument to indicates the node is to be inserted at a position counted from the tail. 
<br>
#
### Summary
For now, I think that linked list is the simplest array-like data structures compared to other data structures. Although i haven't implemented the Circular Linked List by myself, but i think its working principle is still the same. To achieve that, we just need to point the last node of a linked list to the head of the same linked list so that the linked list can form a close loop, rather than a long linear string.
<br><br>
*Edited 25/3/2022*




