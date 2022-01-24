package takeHomeTest;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;

/*
Assumptions made:
1.)The program will always output the expected result when user inputs a 
   comma delimited string containing numbers, otherwise it will handle the 
   input accordingly.
2.)Program should never return a null value, it will always return a empty 
   value corresponding with that methods output.
3.)In the event of a Exception, the program should handle it accordingly 
   so as to mitigate it.
*/
public class UnitTest {
	private Summarizer dummySummarizer = new Summarizer(); //Initialization of dummy Summarizer object

	@Test
	public void testCollectCorrectSize() { //test that collected input list contains all the elements from the input string
		String input = "2,2,2,3,1,4,5,8,7,9,100,134,124,101,10";
		Collection<Integer> actualOutput = dummySummarizer.collect(input);
		assertEquals(actualOutput.size(),13); //test if method collects list of expected size
	}

	@Test
	public void testCollect() { //test that method Summarizer.collect() performs its function correctly
		List<Integer> expectedOutput = Arrays.asList(1,2,3,4,5,7,8,9,10,100,101,124,134);
		String input = "2,2,2,3,1,4,5,8,7,9,100,134,124,101,10";
		Collection<Integer> actualOutput = dummySummarizer.collect(input);
		assertEquals(actualOutput,expectedOutput); //test if method returns the expected result
	}

	@Test
	public void testSummarizeCollection() { //test that method Summarizer.summarizeCollection() performs its function correctly
		String expectedOutput = "1->8,10->13,23,25,100";
		Collection<Integer> inputList = dummySummarizer.collect("1,2,2,2,3,4,5,6,7,8,10,11,12,12,13,23,25,100");
		assertEquals(dummySummarizer.summarizeCollection(inputList),expectedOutput); //test if method returns the expected result
	}
	
	@Test
	public void testNulloutputCollect() { //test to ensure assumption 1.) holds 
		String input = " ";
		Collection<Integer> actualOutput = dummySummarizer.collect(input);
		assertNotNull(actualOutput); //test if given empty string input for Summarizer.collect() will it return a null value
	}
	
	@Test
	public void testNulloutputSummarizeCollection() { //test to ensure assumption 1.) holds 
		List<Integer> input = Arrays.asList( );
		String actualOutput = dummySummarizer.summarizeCollection(input);
		assertNotNull(actualOutput); //test if given empty input collection for Summarizer.SummarizeCollection() will it return a null value
	}
	
	@Test
	public void testNumberFormatExceptionCollect() { //test for Exception when a empty string is passed to Summarizer.Collect()
		boolean throwException = false;
		String input = "";
		try {
			dummySummarizer.collect(input);
		} catch (NumberFormatException e) {
			throwException = true;	
		}
		assertTrue(throwException);
	}
	
	@Test
	public void testExceptionSummarizeCollection() { //test for Exception when a empty collection is passed to Summarizer.summarizeCollection();
		boolean throwException = false;
		List<Integer> input = Arrays.asList( );
		try {
			dummySummarizer.summarizeCollection(input);
		} catch (Exception e) {
			throwException = true;	
		}
		assertFalse(throwException);
	}
}

/*
Mitigation for testNumberFormatExceptionCollect()
Driver Class App; has a conditional statement that breaks out of code 
when empty string input is collected, in which case a empty string is returned.
*/