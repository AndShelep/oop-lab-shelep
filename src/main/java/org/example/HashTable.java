package org.example;

import java.util.ArrayList;

public class HashTable {
    private int capacity = 5;
    protected int size = 0;
    private class Node{
        private String key;
        private Device device;
        private Node next;

        Node(Device device){
            this.key = device.trademark+device.model;
            this.device = device;
            next = null;
        }
    }

    protected Node[] buckets = new Node[capacity];

    public void put(Device device){
        int i = getIndex(hashCode(device.trademark, device.model));
        Node newNode = new Node(device);
        if(size==capacity){
            capacity*=2;
            size = 0;
            resize();
        }
        if(buckets[i]==null){
            buckets[i] = newNode;
        } else {
            Node current = buckets[i];
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void get(String trademark, String model){
        String key = trademark+model;
        int i = getIndex(hashCode(trademark, model));
        if(buckets[i]==null){
            System.out.println("there is no this device");
        } else {
            Node current = buckets[i];
            while(!current.key.equals(key) && current.next!=null){
                current = current.next;
            }
            if(!current.key.equals(key)){
                System.out.println("there is no device with this name");
            } else {
                current.device.mainDescription();
            }
        }
    }

    public void remove(Device device){
        String key = device.trademark+device.model;
        int i = getIndex(hashCode(device.trademark, device.model));

        if(buckets[i]==null){
            System.out.println("there is no this device");
        } else {
            Node current = buckets[i];
            Node previous = buckets[i];

            while(current != null){
                if(current.key.equals(key)) break;
                previous = current;
                current = current.next;
            }
            if(current!=null){
                if(current==buckets[i]){
                    buckets[i] = current.next;
                    current = null;
                    size--;
                } else {
                    previous = current.next;
                    current = null;
                }
                System.out.println("device removed successfully");
            } else {
                System.out.println("there is no this device");
            }
        }
    }

    private int getIndex(long hash){
        int index = (int) (hash%capacity);
        return  index;
    }

    private long hashCode(String trademark, String model) {
        long hash = 0;
        for(int i = 0; i < trademark.length(); i++){
            hash += hash*31 + trademark.charAt(i);
        }
        for(int i = 0; i < model.length(); i++){
            hash += hash*31 + model.charAt(i);
        }
        return hash;
    }

    private void resize(){
        Node[] newBuckets = new Node[capacity];
        for(int i = 0; i < capacity/2; i++){
            Node node = buckets[i];
            while(node!=null){
                Node newNode = new Node(node.device);
                int j = getIndex(hashCode(node.device.trademark, node.device.model));
                if(newBuckets[j]==null){
                    newBuckets[j] = newNode;
                } else {
                    Node current = newBuckets[j];
                    while(current.next!=null){
                        current = current.next;
                    }
                    current.next = newNode;
                }
                node = node.next;
                size++;
            }
        }
        buckets = newBuckets;
    }
}
