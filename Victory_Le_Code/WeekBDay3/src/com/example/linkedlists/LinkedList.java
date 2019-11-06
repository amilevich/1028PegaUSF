package com.example.linkedlists;


public class LinkedList {
	
	/*
	 * In Java, LinkedList can be represented as a class and a Node as a separate class. The linkedList class contains a reference of Node class type.
	 * 
	 * Singly Linked List.
	 * Nested Class can use static
	 */
	
	Node head; //head of list
	static class Node {
		int data;
		Node next;
		
		
		//Constructor
		Node(int d){
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
		}else {
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
		while(currNode != null) {//traverse through the LinkedList
			//print the data at the current Node
			System.out.print(currNode.data +" ");
			currNode = currNode.next;
		}
	}
	
	
	//**************DELETION BY KEY******************
	//method to delete a node in the LinkedList by key
	public static LinkedList deleteByKey(LinkedList list, int key) {
		//store head node
		Node currNode = list.head, prev = null;
		
		//CASE 1
		//if head node itself holds the key to be deleted
		if(currNode != null && currNode.data == key) {
			list.head = currNode.next; //changing head
			System.out.println("\n");
			System.out.println(key + " found and deleted");
			
		}
		
		//CASE 2 
		//if the key is found somewhere else other than the head
		while(currNode != null && currNode.data != key) {
			//searching for the key to be deleted
			//keep track of the previous node as it is needed to change currNode.next
			//if currNode does not hold key, continue to the next node
			prev = currNode;
			currNode = currNode.next;
		}
		//if the key was present, it should be at currNode, therefore currNode shouldn't be null
		if(currNode != null) {
			//since the key is at currNode, unlink currNode from linked list
			prev.next = currNode.next;
			System.out.println("/n");
			System.out.println(key + " found and deleted");

		}
		
		//CASE 3
		//the key is not present
		//if the key was not present in the linked list, currNode should be null
		if (currNode == null) {
			System.out.println("/n");
			System.out.println(key+" found and deleted");
		}
		return list; //return updated list
	}
	
	
	
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list = insert(list,77);
		list = insert(list,42);
		list = insert(list,23);
		list = insert(list,78);
		list = insert(list,79);
		list = insert(list,49);
		printList(list);
		
		deleteByKey(list,77);
	}

}
