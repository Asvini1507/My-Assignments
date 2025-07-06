package week3.day1;

public class Reversestring 
{
	public static void main(String[] args)
	{
		String companyName = "TestLeaf";
        char[] charArray = companyName.toCharArray();
        System.out.println("Reversed String:");
        for (int i = charArray.length - 1; i >= 0; i--)
        {
            System.out.print(charArray[i]);
        }
        System.out.println();
        }
}
