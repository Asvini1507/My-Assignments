package week1.day2;

public class Browser {
	public String LaunchBrowser(String browserName)
	{
		System.out.println("Browser launched suceessfully");
		return browserName;
	}
	public void loadurl()
	{
		System.out.println("Application url loaded sucessfully");
	}
		public static void main(String[] args)
		{
		Browser br=new Browser();
		String Name=br.LaunchBrowser("chrome");
	    System.out.println("Browser name:" +Name);
	    br.loadurl();
		}
}
