
public class Sign {
	private String message;
	private int width;
	
	public Sign(String message, int width) {
		this.message = message;
		this.width = width;
	}
	
	public int numberOfLines() {
		int len = message.length();
		if(len<=width)
			return 1;
		if(len%width == 0)
			return len/width;
		return len/width+1;
		
	}
	
	public String getLines() {
		String ans = "";
		int num = numberOfLines();
		int index = 0;
		for(int i = 0; i<num-1; i++){
			ans+=message.substring(index,index+width)+";";
			index+=width;
		}
		ans+=message.substring(index, message.length());
		return ans;
		
		
		
	}
	

}
