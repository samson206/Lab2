/*
 * This class will take in an input, run through the method to convert an prefix string and produce an 
 * postfix string. The postfix string will then be written to an output file.
 */
package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrefixToPostfixConverter {
    private String prefixInput;
    private String postfixOutput;
    private int pos;
    private String error;

    /*
     * The constructor will take in an input path, output path, and enhancements
     * that will be used by the preToPost method.
     */
    public PrefixToPostfixConverter(String inputPath, String outputPath) {
	prefixInput = inputPath;
	postfixOutput = outputPath;

    }

    /*
     * Method to convert prefix string to postfix string.
     */
    public void preToPost() throws Exception {
	String prefixString;
	String postfixString;
	BufferedReader input = null;
	BufferedWriter output = null;
	BinaryTree p2pTree = null;

	// Use bufferedreader and writer to read and write to files defined in
	// constructor.
	try {
	    input = new BufferedReader(new FileReader(prefixInput));
	    output = new BufferedWriter(new FileWriter(postfixOutput));
	} catch (Exception e) {
	    System.out.println("Error Opening File");
	}

	// Set first line of input file
	prefixString = readInputLine(input);

	// Loop through each line in input file
	while (prefixString != null) {
	    pos = 0;
	    error = "";
	    prefixString = removeWhitespaces(prefixString);

	    if (prefixString == "") {

	    } else if (isValidOperator(prefixString.charAt(pos))) {

		p2pTree = new BinaryTree();
		postfixString = convert(p2pTree.getRoot(), prefixString).getData();

		// Determine if follow on character exist in the prefix string
		try {
		    if (!Character.isWhitespace(prefixString.charAt(++pos))) {
			postfixString = "Invalid prefix String";
		    }
		} catch (Exception e) {
		}
		writeToFile(prefixString + " -> " + postfixString, output);
	    } else {
		postfixString = "Invalid prefix String";
		writeToFile(prefixString + " -> " + postfixString, output);
	    }

	    prefixString = readInputLine(input);
	}
	output.close();

    }

    public Node convert(Node node, String prefixString) {
	try {
	    if (isValidOperator(prefixString.charAt(pos))) {
		node.setData(Character.toString(prefixString.charAt(pos)));
		node.setLeft(convert(new Node(Character.toString(prefixString.charAt(pos++))), prefixString));
		node.setRight(convert(new Node(Character.toString(prefixString.charAt(pos++))), prefixString));
	    } else if (isValidOperand(prefixString.charAt(pos))) {
		return new Node(Character.toString(prefixString.charAt(pos)));
	    } else if (Character.isWhitespace(prefixString.charAt(pos))) {
		error = "Contains Whitespace";
	    } else {
		error = "Invalid Char";
	    }
	    if (error != "") {
		return new Node(error);
	    } else {
		node.setData(node.getLeft().getData() + node.getRight().getData() + node.getData());
		return node;
	    }
	} catch (Exception e) {
	    error = "Invalid prefix String";
	    return new Node(error);
	}
    }

    /**
     * This method is used to determine if an operator is valid.
     * 
     * @param operator - prefix operator
     * @return True if input is a valid operator
     */
    private boolean isValidOperator(char operator) {
	char[] validOperators = new char[] { '+', '-', '/', '*', '$' };

	for (int i = 0; i < validOperators.length; i++) {
	    if (operator == validOperators[i]) {
		return true;
	    }
	}
	return false;
    }

    /**
     * This method is used to determine if an operand is valid
     * 
     * @param operand - prefix operand
     * @return True if input is a valid operand
     */
    private boolean isValidOperand(char operand) {
	if ((int) operand >= 65 && (int) operand <= 90) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * This method is used to remove all whitespace in the prefix String
     * 
     * @param prefixString
     * @return prefix string with all whitespace removed
     */
    private String removeWhitespaces(String prefixString) {
	String resultString = "";

	for (int i = 0; i < prefixString.length(); i++) {
	    if (!Character.isWhitespace(prefixString.charAt(i))) {
		resultString += prefixString.charAt(i);
	    }
	}

	return resultString;
    }

    /**
     * Method to write string to output file
     * 
     * @param outputString  String to be written to output file
     * @param postfixOutput output file
     */
    private void writeToFile(String outputString, BufferedWriter postfixOutput) {
	try {
	    System.out.println(outputString);
	    postfixOutput.write(outputString, 0, outputString.length());
	    postfixOutput.newLine();
	} catch (IOException iox) {
	    System.err.println(iox.toString());
	    System.exit(2);
	}
    }

    /**
     * Method to read each line of the input file
     * 
     * @param prefixInput input file
     * @return Current line of input file
     */
    private String readInputLine(BufferedReader prefixInput) {
	String text = "";

	try {
	    text = prefixInput.readLine();
	} catch (IOException iox) {
	    System.err.println(iox.toString());
	    System.exit(2);
	}

	return text;
    }
}
