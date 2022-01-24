# TakeHomeTest
Creation of program which takes a string of comma seperated numbers and when applicable summarizes them into sequential ranges.

        Input: "1,2,3,4,5,10,34,30"

        Expected output: "1->5,10,30,34"

Program consists of:

-A NumberRangeSummarizer interface containing two abstract methods:

        +Collection<Integer> collect(String input);
        
        +String summarizeCollection(Collection<Integer> input);

-A Summarizer class which extends said interface containing two methods:
        
        +Summarizer.collect() /*Collects string input and returns a ordered unique integer collection of said input stripped of unwanted characters( "," "\\s*")
        
        +Summarizer.summarizeCollection() /* Takes collects() integer collection and performs the range summation and returns it as a string 
        
-A driver class, App, which provides a simple loop to test the program

-A Junit test class, which performs the following unit tests:
        
       +A test to see if Summarizer.collect() collects all input integers from string
       
       +A test to see if Summarizer.collect() performs as expected
       
       +A test to see if Summarizer.summarizeCollection() performs as expected
        
       +A test to see whether Summarizer.collect() can return a null value
       
       +A test to see whether Summarizer.summarizeCollection() can return a null value
       
       +A test on Summarizer.collect() to see if it will throw a specific parse exception
       
       +A test on Summarizer.summarizeCollection() to see if it throws any exception
