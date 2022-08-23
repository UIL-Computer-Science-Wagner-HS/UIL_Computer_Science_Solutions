import java.io.*;
import java.util.*;

public class Manos {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("manos.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int p1 = scan.nextInt();
			int p2 = scan.nextInt();
			if(p1==0||p2==0) {
				System.out.println("P1");
			
			}
			else if(p1==p2)
				System.out.println("P2");
			else if(p1>p2&&(p1-p2)%2==1)
				System.out.println("P1");
			else if(p2>p1&&(p2-p1)%2==1)
				System.out.println("P1");	
			else System.out.println("P2");	
			}
		}
		

	}

