import java.util.*;

import java.io.*;

 
/**
*Class to find max frequency of names from an input file.
*This solution uses a Map data structure to handle both a name and a frequency.
*/
public class CommonNames {

 

    public static void main(String[] args) throws IOException{

       Scanner scan  = new Scanner(new File("commonnames.dat"));

       int noSets = scan.nextInt();

       scan.nextLine();

       while(noSets-->0) {

           String string = scan.nextLine();

           String[] arr = string.split(" ");

           //this is unnecessary, you could just keep the array here.

           List<String> names =  Arrays.asList(arr);

           //map will store the name as a key and the frequency as the value

           TreeMap<String,Integer> map = new TreeMap<>();

           //Max stores max frequency.

           int max = 1;

           /*
           We load the names in map.  If they are not there put the name in
           and frequency 1.  If the name is already there, increment the frequency
           */

           for(String s: names) {

               if(!map.containsKey(s))

                  map.put(s, 1);

               else { map.put(s, map.get(s)+1);

               // now update max

               if (map.get(s)>max)

                  max=map.get(s);

               }

           }

          

           /*
            We will load the names that have the max frequency into ans.
            ans is a treeset so they will be stored in alphabetic order
           */

           TreeSet<String> ans= new TreeSet<String>();

           for(String s:names)

               if(map.get(s)==max)

                  ans.add(s);

           //now print out the answer
           
          /* Iterator<String> it = ans.iterator();
           while(it.hasNext())
        	   System.out.print(it.next()+" ");
           System.out.println();*/
           
           
           String[]printThis = ans.toArray(new String[0]);
           Arrays.sort(printThis,Collections.reverseOrder());

           for(String s:printThis)
        	   System.out.print(s+" ");

           System.out.println("\n-------------------");

          

       }

          

              

 

    }

 

}
