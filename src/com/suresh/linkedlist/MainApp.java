package com.suresh.linkedlist;

public class MainApp {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
//		list.append(10);
//		list.insertFirst(60);
//		list.append(20);
//		list.append(20);
//		list.append(20);
//		list.append(20);
//		list.insertAfter(list.head.next, 6);
//		list.append(50);
//		System.out.println("Before Deleting");
//		list.deleteNode(10);
//		System.out.println("After Deleting");		
//		System.out.println("After Deleting by pos "+1);		
//		list.deleteNodeByPosition(0);
//		list.printList();
//		System.out.println(list.getLengtht());
//		System.out.println("2nd node from linkedlist : "+list.getNth(2));
//		System.out.println("last 2nd node : ");
//		list.printNthFromLast(2);
//		list.printMiddle();	
//		System.out.println("Number count is : "+list.count(20));
//      list.head.next.next = list.head; 
//      list.detectLoop();
//      System.out.println(list.countNodesinLoop(list.head));
		list.append(10);
		list.append(10);
		list.append(20);
		list.append(20);
		list.append(30);
		list.append(10);
		list.append(20);
//		System.out.println(list.isPalindrome(list.head));
		System.out.println("before removing duplicate ");
		list.printList();
		System.out.println("After removing duplicate ");
//		list.removeDuplicates();
		list.removeDuplicateFromUnsortedList();
		list.printList();
	}
}
