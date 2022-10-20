import java.io.*;
import java.util.*;

public class pr140 {
	Node root;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr140.dat"));
		
		int n = scan.nextInt();
		scan.nextLine();
		while (n-->0) {
			char[] inp = scan.nextLine().toCharArray();
			pr140 tree = new pr140();
			for (char c : inp)
				tree.add(c);
			tree.postOrd(tree.root);
			System.out.println();
		}
	}

	void add(char c) {
		root = addRec(c,root);
		
	}

	Node addRec(char c, Node current) {
		if (current == null)
			return new Node (c, null, null);
		else if (c<=current.name)
			current.left = addRec(c,current.left);
		else if (c>current.name)
			current.right = addRec(c,current.right);
		return current;
		
	}
	
	void postOrd (Node current) {
		if (current!=null) {
			postOrd(current.left);
			postOrd(current.right);
			System.out.print(current.name);
		}
	}

}
class Node{
	char name;
	Node left;
	Node right;
	public Node(char name, Node left, Node right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}

