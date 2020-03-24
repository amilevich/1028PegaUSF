package com.example.trees;

public class Node {

	// class containing the left and right child of current node and key
	// value

	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null; // when node is first created we will say it has no children
	}

}

class BinaryTree { // has to be default because if both have static method and in another
	// class trying to access the method then not sure which one to choose since in
	// the same file

	// Root of my Binary tree
	Node root;

	BinaryTree(int key) {
		root = new Node(key);
	}

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		// create a root
		bt.root = new Node(72);
		/*
		 * 72
		 *  / \
		 * 
		 * null null
		 */
		bt.root.left = new Node(65);
		/*
		 * 72 
		 * / \
		 * 
		 * 65 null
		 */
		bt.root.right = new Node(48);
		/*
		 * 72 
		 * / \
		 * 
		 * 65 48
		 */
		bt.root.left.left = new Node(27);
		/*
		 * 		72
		 *  	/ \
		 * 
		 * 	65 48 
		 * / 
		 * 27
		 * 
		 */
		bt.root.left.right = new Node(384);
		/*
		 * 			72 
		 * 			/ \
		 * 
		 * 		65	 	48
		 *  	/\ 
		 *    27 384
		 * 
		 */

	}
}
