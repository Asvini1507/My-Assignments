package week4.day1;

public class Overriding extends Overloading
{
 public void reportStep(String msg1,String status1)
 {
	 System.out.println("message:" +msg1);
	 System.out.println("status:" +status1);
 }
 public static void main(String[]arg)
 {
	 Overriding obj1= new Overriding();
	 obj1.reportStep("hai", "hello");
	 obj1.reportStep("good", "day", false);
	
}
}
