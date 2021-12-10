import java.io.*;
import java.util.*;

public class Gary {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("gary.dat"));
	while (scan.hasNextLine()) {
		Stack<Boolean> stack = new Stack<>();
		String[] arr = scan.nextLine().split("\\s+");
		
		//System.out.println(Arrays.toString(arr));
		for(int i = 0; i<arr.length; i++) {
			//System.out.println(arr[i]);
			if(arr[i].equals("true")) {
				stack.push(true);
				
				continue;
			}
			else if(arr[i].equals("false")) {
				stack.push(false);
			continue;	
			}
			else if(arr[i].equals("or")){
				boolean top = stack.pop();
				boolean next = stack.pop();
				stack.push(top||next);
				continue;
			}
			else if(arr[i].equals("and")){
				boolean top = stack.pop();
				boolean next = stack.pop();
				stack.push(top&&next);
				continue;
			}
			
			else if(arr[i].equals("xor")){
				boolean top = stack.pop();
				boolean next = stack.pop();
				stack.push(top^next);
				continue;
			}
			
			else if(arr[i].equals("not")){
				boolean top = stack.pop();
				//boolean next = stack.pop();
				stack.push(!top);
				continue;
			}
			
			
		}
		System.out.println(stack.pop());
		
		
	}
	
	
}
}
