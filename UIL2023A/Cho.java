import java.io.*;
import java.util.*;
public class Cho {
	static List<Character> list = new ArrayList<>();
	static char[] arr;
	static Comparator<Character> comp = (a,b)->count(b)-count(a);
	static int count(Character a){
		int ans = 0;
		for(char ch: arr)
			if( ch==a)
				ans++;
		//System.out.println(ans);
		return ans;
		
		
	}
	public static void main(String...args) throws IOException{
		Scanner scan = new Scanner(new File("cho.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0){
			 arr = scan.nextLine().replaceAll("[^A-Z-a-z]", "").toCharArray();
			list = new ArrayList<>();
			for(char c: arr)
				list.add(c);
			Collections.sort(list);
			//System.out.println(list);
			list.sort(comp);
			System.out.println(list.get(0));
			
		}
			
			
			
		}

}
