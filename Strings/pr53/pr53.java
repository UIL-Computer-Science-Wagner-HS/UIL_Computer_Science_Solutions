import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class pr53 {
	
	private static void process(String[] input) {
		ArrayList<String> list = new ArrayList<>();
		for(String a: input)
			list.add(a);
		TreeSet<String> set = new TreeSet<String>();
		
		for(int i = list.size()-1; i>=0;i--) {
			if(list.get(i).length()==4) {
				set.add(list.get(i));
				list.remove(i);
			}
		}
		
		list.stream().forEach(x->System.out.print(x+" "));
		System.out.println();
		
		set.stream().forEach(x->System.out.println(x));
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("pr53.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while(no-->0) {
			process(scan.nextLine().split(" "));
			System.out.println();
		}
		
		scan.close();

	}

}
