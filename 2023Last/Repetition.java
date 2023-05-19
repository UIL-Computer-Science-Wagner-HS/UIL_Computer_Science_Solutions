import java.io.*;
import java.util.*;
public class Repetition {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("Repetition"));
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine().replaceAll("(\\w)(\\1+)","$1"));
		
			
		}
}

}
