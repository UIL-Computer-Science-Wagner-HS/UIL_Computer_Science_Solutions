import java.io.*;
import java.util.*;

public class Randy1 {

	static int addVal(char check1, char check2) {
		if (check2 == '/')
			return 10;
		if (check1 == 'X' && check2 == 'X')
			return 20;
		if (check1 == 'X' && check2 != 'X')
			return 10 + Integer.parseInt(check2 + "");
		
		if (check1 != 'X' && check2 == 'X')
			return 10 + Integer.parseInt(check1 + "");
		return Integer.parseInt(check1 + "") + Integer.parseInt(check2 + "");

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("randy.dat"));
		int n = scan.nextInt();
		scan.nextLine();

		while (n-- > 0) {
			int frame = 0;
			int score = 0;
			char[] str = scan.nextLine().toCharArray();
			//System.out.println(Arrays.toString(str));
							
			if(str[str.length-3]!='X')  
			{
			
			for (int i = 0; i < str.length; i++)
				if (str[i] >= 48 && str[i] <= 57)
					score += Integer.parseInt(str[i] + "");

			for (int i = 1; i < str.length; i++)
				if (str[i] == '/')
					score += 10 - Integer.parseInt(str[i - 1] + "");

			for (int i = 1; i < str.length ; i++)
				if (str[i] == '/')
					if (str[i + 1] >= 48 && str[i + 1] <= 57)
						score += Integer.parseInt(str[i + 1] + "");
					else
						score += 10;
			

			for(int i = 0; i<str.length-1; i++)  if(str[i]=='X') 
				  score+=10;
			
			for(int i = 0; i<str.length-2; i++)  
				if(str[i]=='X') 
				  score+=addVal(str[i+1],str[i+2]);
			}
			else {//this means frame 10 started with an X
				
				//count up to that X
				
				for (int i = 0; i < str.length-3; i++)
					if (str[i] >= 48 && str[i] <= 57)
						score += Integer.parseInt(str[i] + "");

				for (int i = 1; i < str.length-3; i++)
					if (str[i] == '/')
						score += 10 - Integer.parseInt(str[i - 1] + "");

				for (int i = 1; i < str.length-3 ; i++)
					if (str[i] == '/')
						if (str[i + 1] >= 48 && str[i + 1] <= 57)
							score += Integer.parseInt(str[i + 1] + "");
						else
							score += 10;
				

				for(int i = 0; i<str.length-3; i++)  if(str[i]=='X') 
					  score+=10;
				
				for(int i = 0; i<str.length-3; i++)  
					if(str[i]=='X') 
					  score+=addVal(str[i+1],str[i+2]);
				
				// now add that X plus the two remaining
				score+=10;
				score+=addVal(str[str.length-2],str[str.length-1]);
			}
			
			
			
			System.out.println(score);
		
		}
	}
}