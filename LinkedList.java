package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class LinkedList {
	
	public  static Node head;
	 
    public class Node {
 
    	/*creating a value node */
    	 
        int value;         
        Node next;
 
        /* constructor for intializing the node*/
        Node(int d) {
            value = d;
            next = null;
        }
    }
 
     public void InsertValue(int new_value)
     {
         /* Allocate the Node, put in the value Set next as null */
         Node new_node = new Node(new_value);
  
         /* If the Linked List is empty, then make the new node as head */
         if (head == null)
         {
             head = new Node(new_value);
             return;
         }
  
         /*  This new node is going to be the last node, so
               make next of it as null */
         new_node.next = null;
  
         /*  Else traverse till the last node */
         Node last = head; 
         while (last.next != null)
             last = last.next;
  
         /* Change the next of last node */
         last.next = new_node;
         return;
     }
     
     
    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
 
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
    
    public ArrayList<Integer> covertToArrayList(Node node) {
    	ArrayList<Integer> myList = new ArrayList<Integer>();
        while (node != null) {
            myList.add(node.value);
            node = node.next;
        }
        return myList;
    }
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
        
        try {
        	
        	/* Uncomment this if you want to take input from command line*/
        
            /*for(int i=0; i<args.length;i++)
            	list.InsertValue(Integer.parseInt(args[i])); */
        	
        /* taking input from console*/
        System.out.println(" enter the size of the list:");
        int ListSize = Integer.parseInt(scan.nextLine());
        
        /* taking in list values */
         
			int ListElements[] = new int[ListSize]; 
			System.out.println("Enter the integer values to be inserted in the list:"  );
			for(int i=0; i<ListSize;i++){
				ListElements[i] = scan.nextInt();
				list.InsertValue(ListElements[i]);}
			
			
			System.out.println("Given list");
			list.printList(head);
			head = list.reverse(head);
			System.out.println("");
			System.out.println("Reversed list ");
			list.printList(head);
			System.out.println("Time Complexity: O(n),Space Complexity: O(1)");
			
		} catch (Exception e) {
			
			System.out.println("invalid input, please provide proper inputs");
			System.out.println("Size of the list should be a positive integer & all the elements in the list should be integers");
		}
    }
}
