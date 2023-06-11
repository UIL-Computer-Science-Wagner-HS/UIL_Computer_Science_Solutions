public class coin {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("coins.dat"));
		int cases = file.nextInt();
		file.nextLine();
		while(cases-->0)
		{
			int a = file.nextInt();
			int c = file.nextInt();
			
			boolean[] l = new boolean[a+1];
			l[0]=true;
			while(c-->0)
			{
				int x = file.nextInt();
				for(int i = x; i<l.length;i++)
				{
					l[i]=l[i-x]||l[i];
				}
			}
			System.out.println(l[l.length-1]?"Possible":"Not Possible");
			
		}

	}
}
