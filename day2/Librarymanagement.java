package week1.day2;

public class Librarymanagement {

	public static void main(String[] args) 
	{
	Library lib=new Library();
	String title=lib.addbook("java programming");
	System.out.println("booktitle:"+title);
    lib.issuebook();
	}

}
