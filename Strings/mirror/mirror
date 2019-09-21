package compsci;
import java.util.*;
import java.io.*;
public class mirror {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("mirror"));
		scan.nextLine();
		int count = 0;
		while(scan.hasNextLine()) {
			String a = scan.nextLine();
			StringBuilder sb = new StringBuilder(a);
			System.out.println(a + "|" + sb.reverse());
			count++;
			if(count == 7) {
				System.out.println("***");
				count = 0;
			}
		}
	}
}
