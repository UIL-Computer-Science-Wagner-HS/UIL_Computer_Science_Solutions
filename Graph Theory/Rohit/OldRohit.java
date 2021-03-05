import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2017 UIL Invitational A Computer Science Programming Contest
 * 
 * Implements a custom tree data structure with variable child quantities for
 * each level.
 * 
 * See program specifications more problem information.
 * 
 * @author Ian Fernandes
 *
 */
public class Rohit {

	/**
	 * Represents a node in the tree with a value and children nodes
	 *
	 */
	static class Node {
		int value;
		ArrayList<Node> children;

		public Node(int value, ArrayList<Node> children) {
			this.value = value;
			this.children = children;
		}

		public String toString() {
			return "" + value;
		}
	}

	/**
	 * Head of tree
	 */
	Node root;

	/**
	 * Next node value to use in construction of the tree
	 */
	int nodeNo;

	/**
	 * One of the helper methods that constructs the head of the tree and its
	 * immediate children.
	 * 
	 * @param value    value of head
	 * @param children
	 */
	public void set(int value, ArrayList<Node> children) {
		root = addNode(value, children);
	}

	/**
	 * Second helper method that helps to construct the head of the tree and its
	 * immediate children.
	 * 
	 * @param value    the value of the head (0)
	 * @param children the children of the head
	 * @return the node that represents the head of the tree
	 */
	public Node addNode(int value, ArrayList<Node> children) {
		root = new Node(value, children);
		return root;
	}

	/**
	 * Used for constructing the tree in a breadth-first manner.
	 */
	Queue<Pair> toVisit2 = new LinkedList<>();

	/**
	 * Constructs the rest of the tree after the head and its children have been
	 * added.
	 * 
	 * @param children         the list of the head's children
	 * @param childrenPerLevel array that holds the number of children a node at
	 *                         level [index i] should have
	 * @param arrIndex         the index to look at for accessing the appropriate
	 *                         number of children
	 */
	private void construct(ArrayList<Node> children, String[] childrenPerLevel, int arrIndex) {
		toVisit2.add(new Pair(children, arrIndex));
		while (!toVisit2.isEmpty()) {
			Pair removed = toVisit2.remove();
			ArrayList<Node> currentChildren = removed.list;

			if (removed.index >= childrenPerLevel.length)
				continue;

			for (int i = 0; i < currentChildren.size(); i++) {
				Node current = currentChildren.get(i);
				int currentChildrenPerLevel = Integer.parseInt(childrenPerLevel[removed.index]);
				current.children = new ArrayList<>();
				for (int j = 0; j < currentChildrenPerLevel; j++) {
					current.children.add(new Node(nodeNo++, null));
				}
			}

			for (Node current : currentChildren) {
				ArrayList<Node> curChild = current.children;
				toVisit2.add(new Pair(curChild, removed.index + 1));
			}
		}

	}

	/**
	 * Represents a list of children and its appropriate index number (which helps
	 * locate information pertinent to how many children each level should have)
	 * 
	 * Used to support breadth-first design of construct()
	 *
	 */
	static class Pair {
		ArrayList<Node> list = new ArrayList<>();
		int index;

		public Pair(ArrayList<Node> list, int index) {
			this.list = list;
			this.index = index;
		}
	}

	/**
	 * Queue to traverse through nodes of a tree
	 */
	Queue<Node> toVisit = new LinkedList<Node>();

	/**
	 * Finds and returns the list of nodes that represent the children of the node
	 * with the designated value parameter.
	 * 
	 * Runs in a breadth-first manner
	 * 
	 * @param current the node to start the traversal from
	 * @param value   the value of the parent
	 * @return the list of children of the parent specified; null if no children;
	 *         empty list if value is not a valid node
	 */
	private ArrayList<Node> getNoOfChildren(Node current, int value) {
		toVisit.add(current);
		while (!toVisit.isEmpty()) {
			Node currentNode = toVisit.remove();
			if (currentNode.value == value)
				return currentNode.children;
			if (currentNode.children != null) {
				for (Node a : currentNode.children)
					toVisit.add(a);
			}
		}
		return new ArrayList<>();
	}

	/**
	 * Process input accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rohit.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] childrenPerLevel = scan.nextLine().split(" ");

			// New search-tree
			Rohit ST = new Rohit();
			ST.toVisit.clear();
			ST.toVisit2.clear();

			int currentChildrenPerLevel = Integer.parseInt(childrenPerLevel[0]);
			int currentNodeNo = ST.nodeNo++;

			ArrayList<Node> children = new ArrayList<>();
			for (int i = 0; i < currentChildrenPerLevel; i++)
				children.add(new Node(ST.nodeNo++, null));

			ST.set(currentNodeNo, children);
			ST.construct(ST.root.children, childrenPerLevel, 1);

			int nodeToGetChildrenFrom = Integer.parseInt(scan.nextLine());

			// Print results accordingly.
			ArrayList<Node> childrenList = ST.getNoOfChildren(ST.root, nodeToGetChildrenFrom);
			if (childrenList == null) {
				System.out.println("NO CHILDREN");
			} else if (childrenList.size() == 0) {
				System.out.println("NOT IN TREE");
			} else {
				childrenList.forEach(x -> System.out.print(x + " "));
				System.out.println();
			}
		}
		scan.close();
	}
}
