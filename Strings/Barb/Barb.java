import java.io.*;
import java.util.*;
public class barb {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("barb")); 
			while(scan.hasNext()) {
				String str = scan.nextLine();
				double length = (str.length()*1.0)/2.0;;
				int len = (int) (Math.ceil(length));
				int leg =(int) Math.floor(length);
				StringBuilder sb = new StringBuilder(str);
				String a = str.toUpperCase();
				StringBuilder ss = new StringBuilder(a);
				StringBuilder sa = new StringBuilder(str.substring(0, len));
				System.out.print(str + " ");
				System.out.print(ss.reverse() + " ");
				System.out.print(sa.reverse() + " ");
				System.out.print(str.substring(leg).toUpperCase());
				System.out.println();
			}
		}
	}

/*red
yellow
green
*/
