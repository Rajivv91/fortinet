package interviews;

//A Java program to count all subsets with given sum.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class SubSet_sum_problem
{
 // vector[i][j] is going to store true if sum j is
 // possible with array elements from 0 to i.
 static boolean[][] vector;
 
 public static int x=0;
 
 //public static List<List<Integer>> tileRows= new ArrayList<List<Integer>>();
//public static  ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
 public static  List<int[]> listOfLists = new ArrayList<int[]>();
public static ArrayList<Integer> temp = new ArrayList<Integer>();
   
 static void display(ArrayList<Integer> vctr)
 {
	
    System.out.println(vctr);
 /* listOfLists.get(x).addAll(vctr);
    x++;*/
 }
   
 /* A recursive function to print all subsets with the help of vector[][]. 
  * Vector CurrentSubset[] stores current subset. */
 static void Seperate(int arr[], int i, int sum, 
                                      ArrayList<Integer> CurrentSubset)
 {

	 
     // If we reached end and sum is non-zero. We print
     // p[] only if arr[0] is equal to sun OR vector[0][sum]
     // is true.
     if (i == 0 && sum != 0 && vector[0][sum])
     {
    	 CurrentSubset.add(arr[i]);
    	 temp.add(arr[i]);
    	// listOfLists.add(arr[i]);
         display(CurrentSubset);
         CurrentSubset.clear();
         return;
     }
   
     // If sum becomes 0
     if (i == 0 && sum == 0)
     {
         display(CurrentSubset);
         //listOfLists.add(CurrentSubset);
         CurrentSubset.clear();
         return;
     }
   
     // If given sum can be achieved after ignoring
     // current element.
     if (vector[i-1][sum])
     {
         // Create a new vector to store path
         ArrayList<Integer> b = new ArrayList<>();
         b.addAll(CurrentSubset);
      
         
         Seperate(arr, i-1, sum, b);
     }
   
     // If given sum can be achieved after considering
     // current element.
     if (sum >= arr[i] && vector[i-1][sum-arr[i]])
     {
    	 CurrentSubset.add(arr[i]);
    	 temp.add(arr[i]);
    	// listOfLists.add(temp);
         Seperate(arr, i-1, sum-arr[i], CurrentSubset);
     }
 }
   
 // Prints all subsets of arr[0..n-1] with sum 0.
 ArrayList<Integer> Subsets(int arr[], int n, int sum)
 {
	 System.out.println("The combinations when  sum is "+ sum + " are:" );
     if (n == 0 || sum < 0)
        return temp;
   
     // Sum 0 can always be achieved with 0 elements
     vector = new boolean[n][sum + 1];
     for (int i=0; i<n; ++i)
     {
         vector[i][0] = true;  
     }
   
     // Sum arr[0] can be achieved with single element
     if (arr[0] <= sum)
        vector[0][arr[0]] = true;
   
     // Fill rest of the entries in vector[][]
     for (int i = 1; i < n; ++i)
         for (int j = 0; j < sum + 1; ++j)
             vector[i][j] = (arr[i] <= j) ? (vector[i-1][j] ||
                                        vector[i-1][j-arr[i]])
                                      : vector[i - 1][j];
     if (vector[n-1][sum] == false)
     {
         System.out.println("There are no subsets with" + 
                                               " sum "+ sum);
         return temp;
     }
   
     // Now recursively traverse vector[][] to find all
     // paths from vector[n-1][sum]
     ArrayList<Integer> p = new ArrayList<>();
     Seperate(arr, n-1, sum, p);
     return temp;
 }
  
 //Driver Program to test above functions
 public static void main(String args[])
 {
	     
     Scanner scan = new Scanner(System.in);
     Scanner scan2 = new Scanner(System.in);
     
     
     try {
		System.out.println(" enter the size of the set:");
		 int SetSize = Integer.parseInt(scan.nextLine());
		 System.out.println("Setsize =" + SetSize );
		 
		 int SetElements[] = new int[SetSize]; 
			System.out.println("Enter the integer values to be inserted in the set:"  );
			for(int i=0; i<SetSize;i++){
				SetElements[i] = scan.nextInt();
				}
			System.out.println(" array elements "+Arrays.toString(SetElements));
		
			
			
			 /*to find a sum of all elements in an array
		      * because thats the max value of the sum that can be given*/
			int MaxSum = 0;
			for( int num : SetElements) {
				MaxSum = MaxSum+num;
		     }
			
			System.out.println("The max value for sum is " +MaxSum +", make sure sum is below this and non negative");

			
			System.out.println("Enter the Sum (for which you want the subset)");
			int sum = scan2.nextInt();
			System.out.println("sum =" + sum );
			
			SubSet_sum_problem SubsetObj = new SubSet_sum_problem();
			
			ArrayList<Integer> SubsetArraylist = new ArrayList<Integer>();
			SubsetArraylist = SubsetObj.Subsets(SetElements, SetSize, sum);
	 
		 System.out.println("list has");
		 System.out.println(x);
		 
		 
		 System.out.println(SubsetArraylist);
		
		 
	} catch (Exception e) {
		
		System.out.println("input not valid");
		
	}
     
     
     }
}
