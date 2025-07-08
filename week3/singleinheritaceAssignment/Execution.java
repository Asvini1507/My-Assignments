package week3.singleinheritaceAssignment;
public class Execution
{
		public static void main(String[] args) 
		{
	        // Create an object of superclass
	        TestData td = new TestData();
	        td.enterCredentials();
	        td.navigateToHomePage();
	        
	        // Create an object of subclass
	        LoginTestData ltd = new LoginTestData();
	        ltd.enterCredentials();       // from TestData
	        ltd.navigateToHomePage();     // from TestData
	        ltd.enterUsername();          // in LoginTestData
	        ltd.enterPassword();          // in LoginTestData
	    }

	}


