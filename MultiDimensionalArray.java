package interviews;

import java.lang.reflect.Array;
import java.util.*;

public class MultiDimensionalArray {

	static int sum =0;
    public static int[] tail(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length);
    }
 
    
    public static void sum(Object array, int... sizes) {
        Random r = new Random();
        
    	for (int i = 0; i < sizes[0]; i++)
        { if (sizes.length == 1)
                {((Integer[]) array)[i] =  r.nextInt();
                sum = sum + i;}
            else
            { sum(Array.get(array, i), tail(sizes));
           
            }
        }
        }
    

	
    
    

    public static void main(String[] args) {

        // Randomly choose number of dimensions (1, 2 or 3) at runtime.
        Random r = new Random();
        int dims = 0;
        
        // Randomly choose array lengths (1, 2 or 3) at runtime.
        /*int[] sizes = new int[dims];
        for (int i = 0; i < sizes.length; i++)
            sizes[i] = 1 + r.nextInt(3);
      
*/      
        
        try {
			System.out.println("Enter the number of Dimensions");
			Scanner input=new Scanner(System.in);
    
			 dims = input.nextInt();
			
			 int sizes[] = new int[dims];
			 
			 Scanner input2=new Scanner(System.in);
			System.out.println("Enter induvidual dimensions");
			for (int i = 0; i < dims; i++) {
				sizes[i]=input2.nextInt();
			   }
			
			
      // int sizes[] = {4,3};
			
			// Creating multi dimensional array array
			System.out.println("Creating array with dimensions: " +
			        Arrays.toString(sizes).replaceAll(", ", "]["));
			Object multiDimArray = Array.newInstance(Integer.class, sizes);

			//fills the array with random values and find the sum
			
			sum(multiDimArray, sizes);
			System.out.println(Arrays.deepToString((Object[]) multiDimArray));
			System.out.println("sum of the array is "+ sum);
			
		} catch (Exception e) {
			System.out.println("Invalid input");
		} 
        
         
    }




	
}
