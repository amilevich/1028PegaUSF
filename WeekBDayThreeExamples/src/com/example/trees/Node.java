package com.example.trees;

public class Node {
	// class containing the left and right child of current node and key value
	
	int key;
	Node left, right;
	
	//constructor
	public Node(int item) {
		key = item;
		left = right = null;
		
	}

}
class BinaryTree{
	//Root of my binary tree
	Node root;
	
	//constructor
	BinaryTree(int key){
		root= new Node(key);
	}
	
	BinaryTree(){
		root = null;
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		//create a root
		bt.root = new Node(72);
		
		/*
		 *   72 
		 *   / \
		 * null null
		 */
		bt.root.left = new Node(65);
		/*
		 *   72
		 *  /  \
		 * 65   null
		 */
		
		bt.root.right = new Node(48);
		/*   72
		 *  /   \
		 * 65   48
		 */ 
		 
	}

}



