import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Eugene {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("eugene.dat"));
		int num = Integer.parseInt(scan.nextLine());
		Set<String> takenUsernames = new HashSet<>();
		while(num-->0) {
			String first = scan.next(), second = scan.next();
			char firstInitial = Character.toLowerCase(first.charAt(0));
			char secondInitial = Character.toLowerCase(second.charAt(0));
			String ascii = ""+(int)first.charAt(0)+(int)second.charAt(0);
			String username = ""+firstInitial+secondInitial+ascii;
			int toAdd = 1;
			while(takenUsernames.contains(username)) {
				username = ""+firstInitial+secondInitial+""+(first.charAt(0)+toAdd)+(int)second.charAt(0);
				toAdd += 1;
			}
			takenUsernames.add(username);
			
			System.out.println(first+" "+second+" "+username);
				
		}
	}
}
