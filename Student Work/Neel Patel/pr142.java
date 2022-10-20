import java.io.*;
import java.util.*;

public class pr142 {
	Node3 root;
	static int inner_leafs;
	static int outer_leafs;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr142.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		while (n-->0) {
			inner_leafs = 0;
			outer_leafs = 0;
			char[] inp = scan.nextLine().toCharArray();
			pr142 tree = new pr142();
			for (char c : inp)
				tree.add(c);
			tree.countLeafs(tree.root);
			System.out.println(inner_leafs + " " + outer_leafs);
		}
	}

	void add(char c) {
		root = addRec(c,root);
		
	}

	Node3 addRec(char c, Node3 current) {
		if (current == null)
			return new Node3 (c, null, null);
		else if (c<=current.name)
			current.left = addRec(c,current.left);
		else if (c>current.name)
			current.right = addRec(c,current.right);
		return current;
		
	}
	
	void countLeafs (Node3 current) {
		if (current!=null) {
			if (current.left==null&&current.right==null) 
				outer_leafs++;
			else
				inner_leafs++;
			countLeafs(current.left);
			countLeafs(current.right);
		}
	}

}
class Node3{
	char name;
	Node3 left;
	Node3 right;
	public Node3(char name, Node3 left, Node3 right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}
