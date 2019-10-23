import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wally {
	
	public static void main(String[]args)throws IOException{
		Scanner scan = new Scanner(new File("wally.dat"));
		ArrayList<String> reservedWords = new ArrayList<>();
		
		String next = scan.next();
		while(!next.equals("999")) {
			reservedWords.add(next);
			next = scan.next();
		}

		ArrayList<String> wordsToCheck = new ArrayList<String>();
		
		while(scan.hasNext())
			wordsToCheck.add(scan.next());
		
		wordsToCheck.stream().filter(x-> {
				return
						!reservedWords.contains(x) &&
						x.matches("[\\w$]+")&&
						x.substring(0,1).matches("[a-zA-Z$_]")&&
						!x.equals("true")&&
						!x.equals("false")&&
						!x.equals("null");
		}).sorted().forEach(y->System.out.println(y));
		
		scan.close();
	}

}
