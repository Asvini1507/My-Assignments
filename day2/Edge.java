package week1.day2;

public class Edge {

	public static void main(String[] args)
	{
		Browser br= new Browser();
		String Name=br.LaunchBrowser("Edge");
		System.out.println("Edge:" +Name);
	    br.loadurl();

	}

}
