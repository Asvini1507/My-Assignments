package week1.day2;

public class Palindrome {

	public static void main(String[] args) 
	{
	   int original=12345;
	   int reversed=0;
	   int output=original;
	   while(output>0)
	   {
		   int rem=output%10;
		   reversed=(reversed*10)+rem;
		   output=output/10;
	   }
		  if(original==reversed)
		  {
			  System.out.println(original+"is a palindrome");
		  }
		  else
		  {
			  System.out.println(original+ "is not a palindrome");
		  }

	}

}
