package com.hackerrank.ds.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GetNodeValue {

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

	// Complete the getNode function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	 static int getNode(SinglyLinkedListNode head, int positionFromTail) {
		 SinglyLinkedListNode temp = head;
		 Stack<SinglyLinkedListNode> stack = new Stack<SinglyLinkedListNode>(); 
		 while(temp != null){
			 stack.push(temp);
			 temp = temp.next;
		 }
		 if(positionFromTail == 0) return stack.pop().data;
		 while(positionFromTail != 0){
			 stack.pop();
			 positionFromTail--;      }
		 return stack.pop().data;
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

			 int position = scanner.nextInt();
			 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			 int result = getNode(llist.head, position);

			 bufferedWriter.write(String.valueOf(result));
			 bufferedWriter.newLine();
		 }

		 bufferedWriter.close();

		 scanner.close();
	 }
}
