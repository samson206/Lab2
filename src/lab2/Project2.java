/*
 * Contains the main class and has logic to process 2 or 3 arguments when calling prefix to postfix converter. 
 */
package lab2;

public class Project2 {

    public static void main(String[] args) throws Exception {

//	PrefixToPostfixConverter p2PC = null;
//
//	if (args.length > 3 || args.length < 2) {
//	    System.out.println("Invalid Number of Arguments");
//	    System.exit(1);
//	} else if (args.length == 3) {
//	    p2PC = new PrefixToPostfixConverter(args[0], args[1], args[2]);
//	} else {
//	    p2PC = new PrefixToPostfixConverter(args[0], args[1], "");
//	}

	String inputPath = "C:\\Users\\samso\\Desktop\\School\\Data Structures\\Lab\\Lab2\\Custom Input1.txt";
	String outputPath = "C:\\Users\\samso\\Desktop\\School\\Data Structures\\Lab\\Lab2\\Custom Output1.txt";
	String enhancement = "c";

	PrefixToPostfixConverter p2PC = new PrefixToPostfixConverter(inputPath, outputPath, enhancement);

	p2PC.preToPost();
    }

}
