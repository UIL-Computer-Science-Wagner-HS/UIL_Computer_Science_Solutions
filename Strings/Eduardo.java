import java.io.*;
import java.util.*;

public class Eduardo {
	static char code(char c, int shift){
	if(c+shift<=122)
		return (char) ((c+shift)%122);
	else
		return (char) ((c+shift)%122+96);
		
		
		
	}
public static void main(String[] args) throws FileNotFoundException {
	Scanner scan = new Scanner(new File("eduardo.dat"));
	while(scan.hasNextLine()){
	String str = scan.nextLine();
	int shift = str.indexOf(" ");
	String ans = "";
	for(int i = 0; i<str.length(); i++){
		if(str.charAt(i)>=97&&str.charAt(i)<=122)
			ans+=code(str.charAt(i), shift);
		else
			ans+=str.charAt(i);
		
	}
	System.out.println(ans);
			
	}
}
}