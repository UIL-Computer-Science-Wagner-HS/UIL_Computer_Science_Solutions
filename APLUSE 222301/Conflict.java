import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Conflict {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("conflict.dat"));
		int noSets = scan.nextInt();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		while(noSets-->0) {
			
			LocalDate d1 = LocalDate.parse(scan.next(), fmt);
			d1 = d1.plusDays(scan.nextInt());
			System.out.println(d1.format(fmt));
			
			
		}
		
		
}
}