/*
 * Node Implementation. Contains data and next.
 */
package lab2;

public class Node {
    private String data;
    private Node left;
    private Node right;

    /**
     * 
     * @param input Data for the node
     */
    public Node(String input) {
	data = input;
	left = null;
	right = null;
    }

    /**
     * 
     * @return Data in the node
     */
    public String getData() {
	return data;
    }

    /**
     * 
     * @return Data in the node
     */
    public void setData(String newData) {
	data = newData;
    }

    /**
     * 
     * @return Left node that this node is currently pointing to
     */
    public Node getLeft() {
	return left;
    }

    /**
     * 
     * @param Node pointer to left node
     */
    public void setLeft(Node leftNode) {
	left = leftNode;
    }

    /**
     * 
     * @return Right node that this node is currently pointing to
     */
    public Node getRight() {
	return right;
    }

    /**
     * 
     * @param Node pointer to right node
     */
    public void setRight(Node rightNode) {
	right = rightNode;
    }
}
