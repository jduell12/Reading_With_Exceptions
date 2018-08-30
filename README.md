# Reading_With_Exceptions
Create a package named "reading_with_exceptions". Write a class named: Reading_With_Exceptions with the following method:
void process(String inputFilename)

Your program will encounter errors, and we want you to gracefully handle them in such a way that you print out informative information and continue executing.
1. Your process routine will try to open a file with the name of inputFilename for input. If there is any problem (i.e. the file doesn't exist), then you should catch the exception, give an appropriate error and then return. Otherwise, your program reads the file for instructions.
2. Your process routine will read the first line of the file looking for an outputFilename String followed by an integer. i.e.:
     outputFilename     number_to_read
Your program will want to write output to a file having the name outputFilename. Your program will try to read from "inputFilename" the number of integers found in "number_to_read".
3. Your process method will copy the integers read from inputFilename and write them to your output file(i.e. outputFilename). There should contain 10 numbers per line of output in your output file.
4. If you encounter bad input, your program should not die with an exception. For example:
* If the count of the numbers to be read is bad or < 0 you will print out a complaint message and then read as many integers as you find.  
* If any of the other numbers are bad, print a complaint message and skip over the data
* If you don't have enough input numbers, complain but do not abort 5. After you have processed inputFilename, I would like your program to then close the output file and tell the user that the file is created. Then Open up the output file and copy it to the Screen.