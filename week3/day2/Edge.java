package week3.day2;
public class Edge extends browser
{		public void takeSnap() 
		{ 
	     System.out.println("Screenshot taken in Edge.");
	    }
	    public void clearCookies() 
	    {
	     System.out.println("Edge cookies cleared.");
	    }
	public static void main(String[] args)
	{
	    Edge edgeobj= new Edge();	 
	    edgeobj.takeSnap();
	    edgeobj.clearCookies();
	    edgeobj.openURL();
	    edgeobj.closebrowser();
	    edgeobj.navigateBack();
	}
}
