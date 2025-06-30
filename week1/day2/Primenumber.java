package week1.day2;

public class Primenumber {

	public static void main(String[] args)
	{
	   int number=13; 
	  boolean isprime=true;
	   if(number<=1)
	   {
		   isprime=false;
	   }
	   else
	   {
	   for(int i=2;i<number;i++)
	   		   if(number%i==0) 	   		  
	   	    {  
			   isprime=false; 
			   break;
		   }	   
	   }
	  if(isprime) 
	  {
	     System.out.println(number+"is a prime number");
	  }
	  else
	  {	   
		 System.out.println(number+"is not a prime number");
	   }
	}
}

	

