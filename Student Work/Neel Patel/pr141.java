import java.io.*;
import java.util.*;

public class pr141 {
	NodeTwo root;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr141.dat"));
		
		int n = scan.nextInt();
		scan.nextLine();
		while (n-->0) {
			char[] inp = scan.nextLine().toCharArray();
			pr141 tree = new pr141();
			for (char c : inp)
				tree.add(c);
			tree.postOrd(tree.root);
			System.out.println();
		}
	}

	void add(char c) {
		root = addRec(c,root);
		
	}

	NodeTwo addRec(char c, NodeTwo current) {
		if (current == null)
			return new NodeTwo (c, null, null);
		else if (c<=current.name)
			current.left = addRec(c,current.left);
		else if (c>current.name)
			current.right = addRec(c,current.right);
		return current;
		
	}
	
	void postOrd (NodeTwo current) {
		if (current!=null) {
			System.out.print(current.name);
			postOrd(current.left);
			postOrd(current.right);
		}
	}

}
class NodeTwo{
	char name;
	NodeTwo left;
	NodeTwo right;
	public NodeTwo(char name, NodeTwo left, NodeTwo right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}

