package takeHomeTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


class Summarizer implements NumberRangeSummarizer {

	@Override
	public final Collection<Integer> collect(String input) { //methods are keywordded final to avoid being overridden
		List<String> listOfInput = new ArrayList<> (Arrays.asList(input.split("\\s*,\\s*"))); //passes input string into list for processing, splits each element on , and removes whitespaces
		List<Integer> colOfInput = listOfInput.stream() //creates a sequential stream which collects the elements of the list created from the string input
											.filter(nums -> nums.matches("^[0-9]*$")) //lambda expression which filters each element if it is not a integer
											.map(num -> Integer.parseInt(num)) //lambda expression which converts the elements of the input list to a integer and then returns the element to the stream
											.sorted() //function to sort the list in ascending order
											.distinct() //function which removes duplicate elements
											.collect(Collectors.toList()); //finally, concatenates the elements mapped and collects it into a list for output
		return colOfInput;
	}

	@Override
	public final String summarizeCollection(Collection<Integer> input) {
		List<Integer> listOfNums = new ArrayList<>(input); //passes the input into a new list with type Integer for processing
		String outputStr = ""; //initialization of empty string for output
		if(listOfNums.isEmpty()) { //statement to make sure a IndexOutofBoundsexception is not thrown when input list is empty
			return outputStr; //returns a empty string
		}
		else {
			int listsize = listOfNums.size(); //variable used to initialize input list size
			int prevnum =listOfNums.get(0); //variable to keep track of previous number in list
			int firstnum = prevnum; //variable to keep track of first number in the list
			if(listsize==1) { //statement to check if list contains only one element
				outputStr+= firstnum;
				return outputStr;
			}
			for(int index=1; index<listsize; index++){ //for loop to iterate over list
				if(listOfNums.get(index)==prevnum+1){ //statement to check if two elements are sequential
					if(index==listsize-1) { //statement that adds the range to the output string if elements are the first and last number of a range
						outputStr+=firstnum+"->"+listOfNums.get(index);
					}
				}else{
					if(firstnum == prevnum) { //statement that checks if elements are not sequential
						outputStr+=firstnum+",";
					}else {
						outputStr+=firstnum+"->"+prevnum+","; //else it means elements are sequential and represent the range (firstnumber -> lastnumber of range)
					}
					if(index==listsize-1) { //statement to check whether iteration has reached the end of the input list
						outputStr+=listOfNums.get(index)+"";
					}
					firstnum=listOfNums.get(index); // variable assignment that assigns new element to check via index
				}
				prevnum = listOfNums.get(index); //variable assignment that assigns new element to ensure statements are checkable
			}
		}return outputStr;
	}
}
