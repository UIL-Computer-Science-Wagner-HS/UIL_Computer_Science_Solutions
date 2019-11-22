import java.util.ArrayList;

public class Perm4 {
	
	//perm inputs a string and an integer n
	// it outputs a list with all n letter permuations of the string
	static ArrayList<String> perm(String str, int n){
		ArrayList<String> list = new ArrayList();
		if(str.length()==2) {
			list.add(str);
			return list;
			}
		
		for(int i=0; i<str.length(); i++) {
			String pre = str.substring(0,i);
			String post = str.substring(i+1);
			String check = pre+post;
			for(String s: perm(check,n)) { 
				 list.add((str.charAt(i)+s).substring(0,n));
				
			}
			
		}
	return list;
		
	}

	public static void main(String[] args) {
		System.out.println(perm("1234",3));
	}

}
