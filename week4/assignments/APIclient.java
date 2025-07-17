package week4.assignments;

public class APIclient
{
	 // Method 1: sendrequest with one argument
    public void sendrequest(String endpoint) 
    {
        System.out.println("Sending request to: " + endpoint);
    }

    // Method 2:sendrequest with three arguments
    public void sendrequest(String endpoint, String requestbody, boolean requeststatus) 
    {
        System.out.println("Sending request to: " + endpoint);
        System.out.println("Request Body: " + requestbody);
        if (requeststatus) 
        {
            System.out.println("Request sent successfully.");
        }
        else
        {
            System.out.println("Request failed to send.");
        }
    }

    // Method overloading
    public static void main(String[] args) 
    {
        // Creating object
        APIclient client = new APIclient();

        System.out.println("sendrequest with 1 argument");
        client.sendrequest("data");

        System.out.println("sendrequest with 3 arguments");
        client.sendrequest("name", "DOB", false);
    }
}
