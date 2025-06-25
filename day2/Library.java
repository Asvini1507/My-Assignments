package week1.day2;

public class Library 
{
	public String addbook(String bookTitle)
	{
		System.out.println("book added sucessfully");
		return bookTitle;
	}
	public void issuebook()
	{
	System.out.println("book issued successfully");	
	}
    public static void main(String[] args) 
    {
	Library lib=new Library();
	String Title=lib.addbook("java coding");
	System.out.println("bookTitle:" +Title);
	lib.issuebook();
	}
}
