
import java.util.*;
import java.io.*;
public class Charles {

	public static void main(String[] args) throws IOException{ 
		Scanner scan = new Scanner(new File("charles.dat"));
		int w = scan.nextInt();
		while (scan.hasNext()) {
			String o = "";
			int n = 0;
			String f = "";
			Integer a = scan.nextInt();
			for (int i = 1; i<=a; i++) {
				if(a%i == 0) {
					o += "+";
					n += i;
					o += i;
				
				}
			}
			for (int i = 1 ; i<o.length();i++) {
				f += o.charAt(i);
			}
			System.out.println(f+"="+n);
		}

	}

}
