import java.io.*;
import java.util.*;



public class pr147 {
	Trie1 root = new Trie1();
	
	void add(char[] inp,int index, Trie1 current ) {
		while(index<inp.length) {
		if(current.arr[inp[index]-65]==null) {
			current.arr[inp[index]-65] = new Trie1();
			current = current.arr[inp[index]-65]; 
			//System.out.println("add "+ inp[index]);
			}
		else {
			current=current.arr[inp[index]-65];
		}
		index++;
		
	}
	}
	void depthS(Trie1 current) {
		Queue<Trie1> queue = new LinkedList<>();
		queue.add(current);
		while(!queue.isEmpty()) {
			Trie1 check = queue.poll();
			for(int i = 0; i<26; i++) {
				if(check.arr[i]!=null) {
					System.out.print((char) (i+65) +" ");
				queue.add(check.arr[i]);
				}
			}
		
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr147.dat"));
		
	pr147 obj = new pr147();
		int noSets = scan.nextInt();
		while(noSets-->0) {
		char[] inp = scan.next().toCharArray();
		//System.out.println(Arrays.toString(inp));
		obj.add(inp, 0, obj.root);
		}
		obj.depthS(obj.root);
		//System.out.println(Arrays.toString(obj.root.arr));

	}
}

class Trie1{
	Trie1[] arr = new Trie1[26];
	
	
	
}