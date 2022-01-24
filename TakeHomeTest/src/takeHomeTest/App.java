package takeHomeTest;
import java.util.Scanner;

public class App { //driver class which allows user to call NumberRangeSummarizer on input

	public static void main(String[] args) {
		while(true) { //loop to allow user to infinitely make calls to the NumberRangeSummarizer
		Scanner getInput = new Scanner(System.in); //scanner initialization
		System.out.println("Please input your string of numbers to summarize, if you would like to close the app, hit enter or input any word/text :");
		String numberList = getInput.nextLine(); //collects user input
		if(numberList.isEmpty() || numberList.matches("[a-zA-Z]+") ) { //statement which exits driver class and terminates code on condition: user input is empty or user inputs any string of alphabet character
			System.out.println("You have terminated the app");
			getInput.close(); //closes scanner
			break;
			
		}
		    Summarizer Test = new Summarizer(); //creation of Summarizer object which does number range summarization
		    Test.collect(numberList);
		    Test.summarizeCollection(Test.collect(numberList));
		    System.out.println("Your string with summarized number ranges is:"+"\n"+ Test.summarizeCollection(Test.collect(numberList))); //print statement for readability
	}
	}
}
