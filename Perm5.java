import java.util.ArrayList;

public class Perm5 {

	static ArrayList<String> perm(String str){
		ArrayList<String> list = new ArrayList();
		if(str.length()==1) {
			list.add(str);
			return list;
			
		}
		for(int i = 0; i<str.length(); i++) {
			String check = str.substring(0,i)+ str.substring(i+1);
			for(String s: perm(check)) {
				
					list.add(str.charAt(i)+s);
			}
		}
			return list;
			
			
			
	}
	public static void main(String[] args) {
		System.out.println(perm("abc"));

	}

}
