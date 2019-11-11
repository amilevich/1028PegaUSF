package com.example.trees;

import javax.xml.soap.Node;

public class Nodes {

	//Class containing the left and right child of current node and key value
	
	int key;
	Nodes left, right;

	public Nodes(int item) {
		key= item;
		left = right = null;
	}
}

class BinaryTree{
	//Root of my binary tree
	Nodes root;
	
	BinaryTree(int key){
		root = new Nodes(key);
	}
	
	BinaryTree(){
		root = null;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		//create a root
		bt.root = new Nodes(72);
		/*
		 * 			72
		 * 		   /  \
		 *       null  null
		 *      /         \
		 */
		bt.root.left = new Nodes(65);
		/*
		 * 			72
		 * 		   /  \
		 *       null  null
		 *      /         \
		 *	  65           null
		 */
		bt.root.right = new Nodes(48);
		/*
		 * 			72
		 * 		   /  \
		 *       65     48
		 *      /         \
		 *	  null        null
		 */
	}
}
