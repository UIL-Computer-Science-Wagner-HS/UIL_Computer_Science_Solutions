
public class BoxoOfCandy {
	private Candy[][] box;
	
	public boolean moveCandyToFirstRow(int col) {
		if(box[0][col]!=null)
			return true;
		Candy test = null;
		int row = 1;
		while (test==null && row<box.length) {
			test = box[row++][col];
			
		}
		if (test == null)
			return false;
		box[0][col]= test;
		box[row-1][col]= null;
		return true;
		
	}
	public Candy removeNextByFlavor(String flavor) {
		for(int row = box.length-1; row>=0; row--) {
			for(int col = 0; col<box[0].length; col++) {
				if(box[row][col].getFlavor().equals(flavor)) {
					Candy toReturn = box[row][col];
					box[row][col]= null;
					return toReturn;
				}
					
				
			}
			
			
		}
		return null;
		
	}
	   

}
