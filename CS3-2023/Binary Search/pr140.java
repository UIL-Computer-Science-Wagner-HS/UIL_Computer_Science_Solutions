import java.io.*;
import java.util.*;

public class pr140 {
	Node root;
	static int leafs;
	static int inner;
	static int dep;
	
	Node addRec(char c, Node current) {
		if(current == null)
			return new Node(c,null,null);
		else if (c<=current.name)
			current.left=addRec(c,current.left);
		else if(c>current.name)
			current.right=addRec(c,current.right);
		return current;
	}
	
	void add(char c) {
		root = addRec(c, root);
		
	}
	void postOrd(Node current) {
		if(current!=null) {
			if(current.left==null &&current.right==null)
				leafs++;
			else inner++;
			postOrd(current.left);
			postOrd(current.right);
			System.out.print(current.name);
			
		}
		
	}
	
	
	void leafsEtc(Node current) {
		if(current!=null) {
			postOrd(current.left);
			postOrd(current.right);
			//System.out.print(current.name);
			
		}
		
	}
	
	void postOrd1(Node current, int depth) {
		if(current!=null) {
			if(current.left==null &&current.right==null)
				dep = Math.max(dep, depth+1);
			
			postOrd1(current.left, depth+1);
			postOrd1(current.right, depth+1);
			//System.out.print(current.name);
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr140.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
			leafs=inner=0;
			char[] inp = scan.nextLine().toCharArray();
			pr140 tree = new pr140();
			for(char c: inp)
				tree.add(c);
			
			//tree.postOrd(tree.root);
			//System.out.println();
			dep = 0;
			tree.postOrd1(tree.root, 0);
			System.out.println(dep-1);
			
			
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