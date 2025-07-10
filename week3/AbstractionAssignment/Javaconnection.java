package week3.AbstractionAssignment;

public class Javaconnection implements Databaseconnection
{
	@Override
	public void connect()
	{
	System.out.println("connected to database");		
	}
	@Override
	public void disconnect()
	{
		System.out.println("disconnected from the database");
	}
	@Override
	public void excuteupdate() 
	{
	System.out.println("excuting and update the detail");
	}
 public static void main(String[]arg)
 {
	Javaconnection obj=new Javaconnection();
     obj.connect();
     obj.excuteupdate();
     obj.disconnect();
 }
}
