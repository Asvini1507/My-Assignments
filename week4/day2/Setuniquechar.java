package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class Setuniquechar 
{
    public static void main(String[] args)
    {
        String companyName = "google";
        
            char[] charArray= companyName.toCharArray();
             Set<Character> obj1 = new LinkedHashSet<Character>();
                         
               for (int i=0; i<charArray.length ; i++) 
               {
                obj1.add(charArray[i]);
        }
                System.out.println("the unique char are;" +obj1);
    }
    }



