package org.example;

public class List {
    class Node{
        Order order;
        Node next;
        Node(Order order){
            this.order = order;
            next = null;
        }
    }
    Node head;
    Node tail;

    public List(){
        head = null;
        tail = null;
    }

    public void push(Order order){
        Node newNode = new Node(order);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void pop(){
        if(head == null){
            System.out.println("There is nothing to delete");
        } else if(head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            head = current.next;
            current = null;
        }
    }

    public void delete(Order order){
        Node prev = null;
        Node current = head;
        while(current!=null){
            if(current.order == order){
                if(current == head){
                    pop();
                } else if(current == tail){
                    prev.next = current.next;
                    current = null;
                    tail = prev;
                } else {
                    prev.next = current.next;
                    current = null;
                }
                break;
            }
            prev = current;
            current = current.next;
        }
    }

    public void showList(){
        if(head == null){
            System.out.println("List is empty");
        } else {
            Node current = head;
            while(current != null){
                current.order.showDetails();
                current = current.next;
            }
        }
    }
}
