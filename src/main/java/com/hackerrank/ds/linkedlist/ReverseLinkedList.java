package com.hackerrank.ds.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ReverseLinkedList {

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

	// Complete the reverse function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	 static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
		 Stack<SinglyLinkedListNode> stack = new Stack<>();
		 SinglyLinkedListNode currentNode = head, prevNode = null;

		 while(currentNode != null){
			 stack.push(currentNode);
			 currentNode = currentNode.next;
		 }
		 SinglyLinkedListNode result = stack.pop();
		 currentNode = result;
		 while(!stack.isEmpty()){
			 prevNode = stack.pop();
			 currentNode.next = prevNode;
			 currentNode = currentNode.next;
		 }
		 prevNode.next = null;
		 return result;
	 }

	 private static final Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) throws IOException {
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		 int tests = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		 for (int testsItr = 0; testsItr < tests; testsItr++) {
			 SinglyLinkedList llist = new SinglyLinkedList();

			 int llistCount = scanner.nextInt();
			 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			 for (int i = 0; i < llistCount; i++) {
				 int llistItem = scanner.nextInt();
				 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				 llist.insertNode(llistItem);
			 }

			 SinglyLinkedListNode llist1 = reverse(llist.head);

			 printSinglyLinkedList(llist1, " ", bufferedWriter);
			 bufferedWriter.newLine();
		 }

		 bufferedWriter.close();

		 scanner.close();
	 }
}
