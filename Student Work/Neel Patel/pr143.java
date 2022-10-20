import java.io.*;
import java.util.*;

public class pr143 {
	Node4 root;
	static int height;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr140.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		while (n-->0) {
			height = 0;
			char[] inp = scan.nextLine().toCharArray();
			pr143 tree = new pr143();
			for (char c : inp)
				tree.add(c);
			tree.getHeight(tree.root,height);
			System.out.println(height-1);
		}
	}

	void add(char c) {
		root = addRec(c,root);
		
	}

	Node4 addRec(char c, Node4 current) {
		if (current == null)
			return new Node4 (c, null, null);
		else if (c<=current.name)
			current.left = addRec(c,current.left);
		else if (c>current.name)
			current.right = addRec(c,current.right);
		return current;
		
	}
	
	void getHeight (Node4 current, int depth) {
		if (current!=null) {
			if (current.left==null&&current.right==null) 
				height = Math.max(height, depth+1);
			getHeight(current.left, depth+1);
			getHeight(current.right, depth+1);
			
		
		}
	}

}
class Node4{
	char name;
	Node4 left;
	Node4 right;
	public Node4(char name, Node4 left, Node4 right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}
	
}