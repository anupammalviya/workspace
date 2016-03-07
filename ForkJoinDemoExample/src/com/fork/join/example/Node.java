package com.fork.join.example;

public class Node {
	int data;
    Node next;
    
   
	
	static Node Reverse(Node head) {
	    Node current,next,prev;
	    prev = null;
	    //next = head;
	    current = head;
	    while(current != null) {
	        next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	    }
	    head = prev;
	    return head;

	}
	
	static Node Insert(Node head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method.
		    if(head == null) {
		        Node d = new Node();
		        d.data = data;
		        d.next = null;
		        head = d;
		        return head;
		    }
		    Node temp = head;
		    while(temp.next != null) {
		        temp = temp.next;
		    }
		    Node insertingNode = new Node();
		    insertingNode.data = data;
		    insertingNode.next = null;
		    temp.next = insertingNode;
		    return head;
		  
		}
	
	static Node InsertNth(Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		    Node node = new Node();
		    node.data = data;
		    node.next = null;
		    
		    if(position == 0) {
		        node.next = head;
		        head = node;
		        return head;
		    }
		    
		    int j = 0;
		    Node temp = head;
		    Node prev = null;
		    while(j<position) {
		        prev = temp;
		       temp = temp.next; 
		       j = j + 1;
		    }
		    
		    node.next = temp;
		    prev.next = node;
		    
		    return head;
		    
		}
	
	static void Print(Node head) {
	    Node temp = head;
	  while(temp !=null) {
	      System.out.println(temp.data);
	      temp = temp.next;
	  }
	  
	}
	
	public static void main(String[] args) {
		Node head = new Node();
		head.data = 10;
		
		head = head.Insert(head, 20);
		
		head = head.Insert(head, 5);
		//Print(head);
		
		head = head.Insert(head, 5);
		
		head = head.Insert(head, -5);
		Print(head);
		head = head.InsertNth(head, 21, 2);
		
		System.out.println("####################After Inserting At Second position############");
		Print(head);
		
		head = Reverse(head);
		
		System.out.println("###################After reversing###################");
		
		Print(head);
	}

}
