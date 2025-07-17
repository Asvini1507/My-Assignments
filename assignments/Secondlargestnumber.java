package week4.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Secondlargestnumber
{
	public static void main(String[] args)
	{
		 // Declare the array
        int[] numbers = {3, 2, 11, 4, 6, 7};

        // Convert array to list
        List<Integer> numberlist = new ArrayList<>();
        for (int num : numbers)
        {
            numberlist.add(num);
        }
        
        // Sort the list
        Collections.sort(numberlist);
        System.out.println("Sorted list: " + numberlist);

        // Get the second largest number
        int secondlargest = numberlist.get(numberlist.size() - 2);
        System.out.println("Second largest number: " + secondlargest);
	}
}
