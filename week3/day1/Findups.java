package week3.day1;

public class Findups
{
	public static void main(String[] args) 
	{
	 int[] num = {2,5,7,7,5,9,2,3};
	 System.out.println("the duplicate arrays are:");
     for (int i = 0; i < num.length; i++) 
     {
    	 for (int j = i + 1; j < num.length; j++)
    	 {        
             if (num[i] == num[j] && num[i] != -1)  
             {
                 System.out.println(num[i]);
             }
         }
     }
	}
}
     
