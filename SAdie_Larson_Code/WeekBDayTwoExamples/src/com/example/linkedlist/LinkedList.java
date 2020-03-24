package com.example.linkedlist;

public class LinkedList {

	/*
	 * In java, LinkedList cna be represented as a class and a Node as a seperate
	 * class. The LinkedList class contains a referene of Node class type. Singly
	 * Linked List
	 * 
	 */
	Node head; // head of list

	static class Node {
		int data;
		Node next;

		// Constructor
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// method to insert a new node
	public static LinkedList insert(LinkedList list, int data) {
		// create a new node with the given data
		Node new_node = new Node(data);
		new_node.next = null;

		// if the linked list is empty, we then make the new node as a head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// else we have to traverse till the last node and insert the new node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
public static void printList(LinkedList list) {
	Node currNode = list.head;
	System.out.println("Linked List: ");
	while(currNode.next != null) {
		System.out.print(currNode.data + " ");
		currNode = currNode.next; // goes to the next node
		if(currNode.next == null) {
			System.out.println(currNode.data);
		}
	}
}

// ************DELETION BY KEY *************
//method to delete a node in the LinkedList by key

public static LinkedList deleteByKey(LinkedList list, int key) {
	//store head node
	Node currNode = list.head, prev = null;
	
	//CASE 1
	//if head node itself holds the key to be deleted
	if(currNode != null && currNode.data == key) {
		list.head = currNode.next; // changing the head
		System.out.println();
		System.out.println(key + " found and deleted");
		return list; // return updated list
	}
	
	//CASE 2
	// if the key is found somewhere else other than the head
	while(currNode != null && currNode.data != key) {
		//searching for the key to be deleted
		//keep track of the previous node as is need to change the actual pointer 
		//if the current node does not hold the key, 
		//continue to the next node
		prev = currNode;
		currNode = currNode.next;
	}
	//if the key was present, it should be at currNode
	//therefore currNode shouldn't be null
	if(currNode != null) {
		//since the key is at currNode, unlink currNode from linked list
		prev.next = currNode.next;
		System.out.println();
		System.out.println(key + " found key and delted");
		return list;
	}
	
	//CASE 3
	//the key is not present
	//if the key is not present in the linked list, currNode should be null
	if(currNode == null) {
		System.out.println();
		System.out.println(key  + " not found");
	}
	return list;
}
	public static void main(String[] args) {

		LinkedList list = new LinkedList(); //can have no angular brackets if we defined the contents within the class
		list = insert(list, 77);
		list = insert(list, 85);
		list = insert(list, 3);
		list = insert(list, 100);
		System.out.println(list); // will print out object location since toString not overridden
		printList(list);
	//	deleteByKey(list, 77); //key at head
	//	deleteByKey(list, 3); //key inside list
	//	deleteByKey(list, 100); //key at end
		deleteByKey(list, 42); //key not there
		printList(list);
	}

}
