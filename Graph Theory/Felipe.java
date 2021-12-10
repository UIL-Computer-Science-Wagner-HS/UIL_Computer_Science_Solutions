import java.io.*;
import java.util.*;

;


public class Felipe {
	Node22 root;
	static String rev;
	Node22 addRec(char c, Node22 current) {
		if(current == null)
			return new Node22(c);
		else if (c<=current.name)
			current.left= addRec(c, current.left);
		else current.right=addRec(c, current.right);
		
		
		return current;
	}
	
	
	void add(char c) {
		root = addRec(c, root);
		
		
	}
	
	void inOrd(Node22 current) {
		if(current!=null) {
			inOrd(current.left);
			System.out.print(current.name);
			
			inOrd(current.right);
			
		}
		
		
	}
	
	void preOrd(Node22 current) {
		if(current!=null) {
			System.out.print(current.name);
			preOrd(current.left);
			preOrd(current.right);
			
		}
		
		
	}
	void postOrd(Node22 current) {
		if(current!=null) {
			postOrd(current.left);
			postOrd(current.right);
			System.out.print(current.name);
			
		}
		
		
	}
	void revOrd(Node22 current) {
		if(current!=null) {
			revOrd(current.left);
			rev=current.name+rev;
			//System.out.print(current.name);
			
			revOrd(current.right);
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("felipe.dat"));
	
	while(scan.hasNext()) {
		Felipe tree = new Felipe();
		char[] str = scan.next().toCharArray();
		String order = scan.next();
		for(char c: str)
			tree.add(c);
		String s = "";
		
		switch(order) {
		case "I": 
			
			tree.inOrd(tree.root);
			System.out.println(); 
				
		
		
		break;
		
		
		case "E":  tree.preOrd(tree.root); 
		System.out.println();
		break;
		case "O": tree.postOrd(tree.root); 
		System.out.println(); 
		break;
		case "R":
			rev = "";
			tree.revOrd(tree.root); 
		//StringBuilder sb = new StringBuilder(rev);
		//sb = sb.reverse();
		System.out.println(rev);
		
		
		
		}
	}
}
	
}
class Node22{
	char name;
	Node22 left;
	Node22 right;
	public Node22(char name) {
		super();
		this.name = name;
	}
	
	
	
}