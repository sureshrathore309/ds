package com.suresh.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {
	Node head;
	// Implementation of Floyd’s Cycle-Finding Algorithm:

	void removeDuplicateFromUnsortedList() {
		// Hash to store seen values
		Set<Integer> hs = new HashSet<>();
		// pich elements one by one
		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;
			if (hs.contains(curval)) {
				prev.next=current.next;
			}
			else {
				hs.add(curval);
				prev = current;
			}
			current=current.next;
		}
	}
	void removeDuplicates() {
		Node current = head;
		// traverse list till the last node
		while (current != null) {
			Node temp = current;
			/*
			 * compare current node with the next node and keep on deleting them until it
			 * matches the current node data
			 */
			while (temp != null && temp.data == current.data) {
				temp = temp.next;
			}
			// set current node next to the next different element denoted by temp
			current.next = temp;
			current = current.next;
		}
	}

	boolean isPalindrome(Node head) {
		Node slow = head;
		boolean isPalin = true;
		Stack<Integer> stack = new Stack<>();
		while (slow != null) {
			stack.push(slow.data);
			slow = slow.next;
		}

		while (head != null) {
			int i = stack.pop();
			if (head.data != i) {
				isPalin = false;
				break;
			}
			head = head.next;
		}
		return isPalin;
	}

	void detectLoop() {
		Node slowP = head;
		Node fastP = head;
		while (slowP != null & fastP != null && fastP.next != null) {
			slowP = slowP.next;
			fastP = fastP.next.next;
			if (slowP == fastP) {
				System.out.println("Fount Loop");
				return;
			}
		}
		System.out.println("No loop found");
	}

	/*
	 * This function detects and counts loop nodes in the list. If loop is not there
	 * in then returns 0
	 */
	int countNodesinLoop(Node list) {
		Node slow_p = list, fast_p = list;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			/*
			 * If slow_p and fast_p meet at some point then there is a loop
			 */
			if (slow_p == fast_p)
				return countNodes(slow_p);
		}
		/* Return 0 to indicate that there is no loop */
		return 0;
	}

//Returns count of nodes present in loop.  
	private int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.next != n) {
			res++;
			temp = temp.next;
		}
		return res;
	}

	/*
	 * counts the number of occurences of a node search for in a linked list
	 */
	int count(int searchFor) {
		Node currentNode = head;
		int count = 0;
		while (currentNode != null) {
			if (currentNode.data == searchFor)
				count++;
			currentNode = currentNode.next;
		}
		return count;
	}

	/* Function to print middle of linkedlist */
	void printMiddle() {
		Node slowPtr = head;
		Node fastPtr = head;
		if (head != null) {
			while (fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			System.out.println("The middle element is : " + slowPtr.data);
		}
	}

	/*
	 * function to get the nth node from the last of a linkedlist
	 */
	void printNthFromLast(int n) {
		int length = getLengtht();
		Node temp = head;
		// check if value of n is not more than length of the linkedlist
		if (length < n)
			return;
		for (int i = 1; i < length - n + 1; i++)
			temp = temp.next;
		System.out.println(temp.data);
	}

	/* Takes index as argument and return data at index */
	public int getNth(int index) {
		Node current = head;
		int count = 1;/* index of Node we are currently looking at */
		while (current != null) {
			if (count == index)
				return current.data;
			count++;
			current = current.next;
		}
		return 0;
	}

	/*
	 * check whether the value x is present in linked list
	 */
	public boolean search(Node head, int n) {
		Node current = head; // initalize count
		while (current != null) {
			if (current.data == n)
				return true; // data found
			current = current.next;
		}
		return false; // data not found
	}

	/* Returns count of nodes in linked list */
	public int getLengtht() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/* Function deletes the entire linked list */
	void deleteList() {
		head = null;
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(int key) {
		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key) {
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a position,
	 * deletes the node at the given position
	 */
	void deleteNodeByPosition(int position) {
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		Node temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of ndoes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above Time
	 * complexity of push() is O(1) as it does constant amount of work.
	 */
	public void insertFirst(int newData) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node newNode = new Node(newData);
		/* 3. Make next of new Node as head */
		newNode.next = head;
		/* 4. Move the head to point to new Node */
		head = newNode;
	}

	/*
	 * Appends a new node at the end. This method is defined inside LinkedList class
	 * shown above Time complexity of append is O(n) where n is the number of nodes
	 * in linked list. Since there is a loop from head to end, the function does
	 * O(n) work.
	 */
	public void append(int new_data) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		Node new_node = new Node(new_data);
		new_node.next = null;
		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		if (head == null) {
			head = new Node(new_data);
			return;
		}

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.println(tNode.data + " ");
			tNode = tNode.next;
		}
	}

	/*
	 * This function is in LinkedList class. Inserts a new node after the given
	 * prev_node. This method is defined inside LinkedList class shown above Time
	 * complexity of insertAfter() is O(1) as it does constant amount of work.
	 */
	public void insertAfter(Node prev_node, int new_data) {
		/* 1. Check if the given Node is null */
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		/*
		 * 2. Allocate the Node & 3. Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

}
