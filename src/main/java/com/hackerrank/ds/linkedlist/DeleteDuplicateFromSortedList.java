package com.hackerrank.ds.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DeleteDuplicateFromSortedList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the removeDuplicates function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	 static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		 SinglyLinkedListNode currentNode = head;
		 if(head == null) return head;
		 while(currentNode.next != null){
			 if(currentNode.data == currentNode.next.data){
				 currentNode.next = currentNode.next.next;
				 continue;
			 }
			 
			 currentNode = currentNode.next;
		 }
		 return head;
	 }


	 public static void main(String[] args) throws IOException {
		 SinglyLinkedListNode node = new SinglyLinkedListNode(2);
		 node.next = new SinglyLinkedListNode(2);
		 node.next.next = new SinglyLinkedListNode(2);
		 node.next.next.next = new SinglyLinkedListNode(3);
		 node.next.next.next.next = new SinglyLinkedListNode(4);
		 node.next.next.next.next.next= new SinglyLinkedListNode(5);
		 node.next.next.next.next.next.next = new SinglyLinkedListNode(6);
		 node.next.next.next.next.next.next.next = new SinglyLinkedListNode(7);
		 SinglyLinkedListNode temp = removeDuplicates(node);
		 while(temp != null) {
			 System.out.println(temp.data + "");
			 temp = temp.next;
		 }
	 }
}
