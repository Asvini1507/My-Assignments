package week3.assignment;

import java.util.Arrays;

public class AnagramString 
{
	public static void main(String[] args)
	{
		String text1 = "taste";
        String text2 = "state";
        if (text1.length() != text2.length()) 
        {
        System.out.println("Lengths mismatch:the strings are not an Anagram.");
        }
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if (Arrays.equals(charArray1, charArray2))
        {
            System.out.println("The given strings are Anagram.");
        } 
        else 
        {
            System.out.println("The given strings are not an Anagram.");
        }


	}

}
