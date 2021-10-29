import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Jamari {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("jamari.dat"));
		ArrayList <String> list = new ArrayList <String>();
		String str = "";
		int sum = 0;
		int n = 0;
		int c = 0;
		
		while (scan.hasNext()) {
			
			while (!str.equals(">>>")) {
			str = scan.next();
			n=0;
			if (str.matches("\\d+")) {
				n = Integer.parseInt(str);
			} else if (!str.equals(">>>")) {
				list.add(str);
				c++;
			}
			sum += n;
			}
			if (c!=0) {
				if (sum == c) {
					System.out.println("Everyone got a donut today.");
				} else {
					System.out.println("The last person to get a donut was " + list.get(c-(c-sum+1)));
					System.out.println((c-sum) + " customers did not get a donut today.");
				}
			} else {
				System.out.println("No one got a donut today.");
			}
			if (scan.hasNext()) {
			str=scan.next();
			sum+=3;
			}
		}
	}
}
