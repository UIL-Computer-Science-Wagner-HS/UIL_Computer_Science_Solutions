import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Program #11 of 2019 UIL Invitational A Programming Contest
 * 
 * Class represents a ternary search tree
 * 
 * @author Ian Fernandes
 *
 */
public class Lucia {

	// Root Node
	Node root;

	/**
	 * Definition of a node in a tree
	 */
	class Node {
		int value;
		Node left, middle, right;

		public Node(int data) {
			left = middle = right = null;
			value = data;
		}
	}

	/**
	 * Add a new node
	 * 
	 * @param value
	 */
	private void insert(int value) {
		root = addNode(root, value);
	}

	/**
	 * Recursively adds new node with value a to the TST
	 * 
	 * @param current the current node to look from
	 * @param a       the value of the new node to add
	 * @return the updated subtree with the added node
	 */
	private Node addNode(Node current, int a) {
		if (current == null) {
			current = new Node(a);
			return current;
		}

		int currentValue = current.value;
		if (a < currentValue - 5) {
			current.left = addNode(current.left, a);
		} else if (a > currentValue + 5) {
			current.right = addNode(current.right, a);
		} else {
			current.middle = addNode(current.middle, a);
		}
		return current;
	}

	/**
	 * Pre-order traversal of TST
	 * 
	 * Root, left, middle, right
	 * 
	 * @param current node to start traversal from
	 */
	private void preOrder(Node current) {
		if (current == null)
			return;

		System.out.print(current.value + " ");

		preOrder(current.left);
		preOrder(current.middle);
		preOrder(current.right);
	}

	/**
	 * Post-order traversal of TST
	 * 
	 * Left, middle, right, root
	 * 
	 * @param current node to start traversal from
	 */
	private void postOrder(Node current) {
		if (current == null)
			return;

		postOrder(current.left);
		postOrder(current.middle);
		postOrder(current.right);

		System.out.print(current.value + " ");

	}

	/**
	 * Process input, construct TST, and run traversals.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("lucia.dat"));

		String[] valueArr = scan.nextLine().split(" ");
		List<Integer> values = new ArrayList<>();

		for (String a : valueArr)
			values.add(Integer.parseInt(a));

		Lucia tst = new Lucia();

		values.forEach(x -> tst.insert(x));

		System.out.print("Preorder: ");
		tst.preOrder(tst.root);
		System.out.println();

		System.out.print("Postorder: ");
		tst.postOrder(tst.root);

		scan.close();
	}
}
