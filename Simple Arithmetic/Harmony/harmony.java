package compsci;
import java.io.*;
import java.util.*;
public class harmony {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("harmony"));
		scan.nextLine();
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			ArrayList<String> arr = new ArrayList<String>();
			int lastdig = 0;
			for(int i = 0; i < str.length(); i++) {
				if(i < str.length()-1) {
				arr.add(str.substring(i,i+1));
				}
				else {
					lastdig = Integer.parseInt(str.substring(i,i+1));
				}
			}
			//System.out.println(lastdig);
			int odd = 0;
			int highs = 0;
			for(int i = 0; i < arr.size(); i+=2) {
				odd+= Integer.parseInt(arr.get(i));
				if(Integer.parseInt(arr.get(i)) > 4) {
					highs++;
				}
			}
			//System.out.println(odd);
			int even = 0;
			for(int i = 1; i < arr.size(); i+=2) {
				even+= Integer.parseInt(arr.get(i));
			}
			//System.out.println(even);
			int check = ((odd*3) + even + highs)%10;
			//System.out.println(check);
			int x;
			if(check > 0) {
				x = 10-check;
			}
			else {
				x = 0;
			}
			if(x == lastdig) {
				System.out.println(str + " VALID");
			}
			else {
				System.out.println(str + " INVALID " + x);
			}
		}
	}
}
