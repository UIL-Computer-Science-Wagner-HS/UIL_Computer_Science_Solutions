import java.io.*;
import java.util.*;

public class Randy {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("randy.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n > 0) {
			String str = scan.nextLine();
			int score = 0;
			int frame = 1;
			int frameUp = 0;
			for (int i = 0; i < str.length(); i++) {
				if (frameUp == 2) {
					frame++;
				}
				
				if (frame != 10 && !str.substring(i,i+1).matches("[0-9]")) {
					if (str.substring(i,i+1).equals("X")) {
						score += 10;
						frame++;
						
						if (i < str.length()-1 && !str.substring(i+1,i+2).equals("X")) {
							score += Integer.parseInt(str.substring(i+1,i+2));
						} else if (i < str.length()-1) {
							score += 10;
						}
						if (i < str.length()-2 && str.substring(i+2,i+3).equals("X")) {
							score += 10;
						} else if (i < str.length()-2 && str.substring(i+2,i+3).equals("/")) {
							score += (10-Integer.parseInt(str.substring(i+1,i+2)));
						} else if (i < str.length()-2) {
							score += (Integer.parseInt(str.substring(i+2,i+3)));
						}
					} else if (str.substring(i,i+1).equals("/")) {
						score += 10-Integer.parseInt(str.substring(i-1,i));
						frame++;
						frameUp=0;
						if (i < str.length()-2 && !str.substring(i+1,i+2).equals("X")) {
							score +=  Integer.parseInt(str.substring(i+1,i+2));
						} else if (i < str.length()-2) {
							score += 10;
						}
					}
				} else if (frame != 10){
					frameUp++;
					score += Integer.parseInt(str.substring(i,i+1));
					
				} else {
					if (str.substring(i,i+1).equals("X")) {
						score += 10;
					} else if (str.substring(i,i+1).equals("/")) {
						score += 10-Integer.parseInt(str.substring(i-1,i));
					} else {
						score += Integer.parseInt(str.substring(i,i+1));
					}
				}
			}
			n--;
			System.out.println(score);
		}
		
	}
	
}
