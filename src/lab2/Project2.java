/*
 * Contains the main class and has logic to process 2 or 3 arguments when calling prefix to postfix converter. 
 */
package lab2;

public class Project2 {

    public static void main(String[] args) throws Exception {

	if (args.length != 2) {
	    System.out.println("Invalid Number of Arguments");
	    System.exit(1);
	}

	PrefixToPostfixConverter p2PC = new PrefixToPostfixConverter(args[0], args[1]);

	p2PC.preToPost();
    }

}
