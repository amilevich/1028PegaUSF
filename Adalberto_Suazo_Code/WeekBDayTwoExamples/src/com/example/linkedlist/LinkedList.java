package com.example.linkedlist;
public class LinkedList {
    /*
     * In Java, LinkedList can be represented as a class and a Node as a
     * separate class. The LinkedList class contains a reference of Node class
     * type. 
     * Singly Linked List.
     */
    Node head; //head of list
    
    static class Node {
        int data;
        Node next;
        
        //Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    //method to insert a new node
    public static LinkedList insert(LinkedList list, int data) {
        //create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
        //if the Linked List is empty, then make the new node as a head
        if(list.head == null) {
            list.head = new_node;
        } else {
            //else traverse till the last node and insert new_node there
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            //insert the new_node at last node
            last.next = new_node;
        }
        return list;
    }
    
    public static void printList(LinkedList list) {
    	Node currNode = list.head;
    	System.out.println("LinkedList: ");
    	while(currNode != null) { //traverse through the linkedlist
    		//print the data at the current node
    		System.out.print(currNode.data + " ");
    		currNode = currNode.next;
    	}
    }
    public static void main(String[] args) {
    	LinkedList list = new LinkedList();
    	list = insert(list, 77);
    	list = insert(list, 42);
    	list = insert(list, 5);
    	list = insert(list, 23);
    	list = insert(list, 78);
    	list = insert(list, 79);
    	list = insert(list, 49);
    	printList(list);
    }
}