import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordScore {

	static int value(String str) {
		int ans = 0;
		str = str.toLowerCase();
		Pattern vowels = Pattern.compile("[aeiou]"); 
		Matcher m1 = vowels.matcher(str);
		while(m1.find()){
			ans++;
		}
		Pattern z = Pattern.compile("z"); 
		Matcher m2 = z.matcher(str);
		while(m2.find()){
			ans+=2;
		}
		Pattern other = Pattern.compile("[xq]"); 
		Matcher m3 = other.matcher(str);
		while(m3.find()){
			ans+=3;
		}
		ans+=str.length()/2;
		return ans;
	}
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("wordScore.dat"));
		while(scan.hasNextLine()) {
			int value = 0;
			String ans = "";
			String[] arr = scan.nextLine().split("\\s+");
			for(String str: arr) {
				if(value(str)>value) {
					value = value(str);
					ans = str;
				}
			}
			System.out.println(ans+ "- "+ value);
			
			
		}

	}

}
