package interviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Assert;

public class TestLinkedList {
	
	@Test
	public void testInsertValue() {
		
		// create object of the class under test
		LinkedList list = new LinkedList();
		
		// create an object of random class to generate a random integer
		Random rn = new Random();
		
		// get a random integer
		int expected = rn.nextInt();
		// insert that random integer into linked list
		list.InsertValue(expected);
		
		// Receive all values present in the Linked List
		ArrayList<Integer> tempList = list.covertToArrayList(LinkedList.head);
		// Extract last element present in the Linked List (newest element)
		int actual = tempList.get(tempList.size()-1);

		System.out.println("Expected: " + expected);
		System.out.println("Actual:   " + actual);
		// Make sure that the element we tried to insert has been added to linked list
		Assert.assertEquals(expected, actual);
		
		System.out.println("Pass"); // This line executed only if above assert statement is executed successfully.
	}
	
	@Test
	public void testReverse() {
		
		LinkedList list = new LinkedList();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		Random rn = new Random();
		int number = rn.nextInt(10);
		
		/*
		 *  Generate random integers and insert them to linked list as well as 
		 *  our own arrayList
		 */
		int i=0;
		while(i<number) {
			int value = rn.nextInt();
			myList.add(value);
			list.InsertValue(value);
			i++;
		}
		
		// Reverse our own array list
		Collections.reverse(myList);
		// Reverse linked list (method under test)
		LinkedList.head = list.reverse(LinkedList.head);
		// Get the elements of Linked list after they are reversed
		ArrayList<Integer> actual = list.covertToArrayList(LinkedList.head);

		System.out.println("Expected: " + myList);
		System.out.println("Actual:   " + actual);
		// Check that reversed list matches our own reversed array list
		Assert.assertEquals(myList, actual);
		System.out.println("Pass");
	}
}

