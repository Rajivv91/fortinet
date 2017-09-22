package interviews;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
public class SubSet_Sum_Test {
	
	@Test
public void TestCombination() {
		
		SubSet_sum_problem SubsetObj = new SubSet_sum_problem();
		int SetElements[] = {1,4};
		int sum =5;
		int size = SetElements.length;
		ArrayList<Integer> Expected = new ArrayList<Integer>();
		ArrayList<Integer> Actual = new ArrayList<Integer>();
		// here sum 5 has a combination of 
		Expected.add(4);
		Expected.add(1);
		
		Actual = SubsetObj.Subsets(SetElements, size, sum);
		assertArrayEquals(Actual.toArray(), Expected.toArray());
				
}
	
	@Test
	public void TestCombinationNegative() {
			
			SubSet_sum_problem SubsetObj = new SubSet_sum_problem();
			int SetElements[] = {1,4};
			int sum =5;
			int size = SetElements.length;
			ArrayList<Integer> ExpectedWrongAns = new ArrayList<Integer>();
			ArrayList<Integer> Actual = new ArrayList<Integer>();
			// here sum 5 has a combination of 
			ExpectedWrongAns.add(4);
			ExpectedWrongAns.add(7);
			
			Actual = SubsetObj.Subsets(SetElements, size, sum);
			Assert.assertThat(Actual.toArray(), IsNot.not(IsEqual.equalTo(ExpectedWrongAns.toArray())));	
					
	}	

}
