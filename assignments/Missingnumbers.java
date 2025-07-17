package week4.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Missingnumbers 
{
	public static void main(String[] args) 
	{
		 //initialize the array
        int[] numbers = {1, 2, 3, 4, 10, 6, 8};

        // Convert array to list
        List<Integer> numlist = new ArrayList<>();
        for (int num : numbers)
        {
            numlist.add(num);
        }

        // Sort the list 
        Collections.sort(numlist);

        System.out.println("Sorted list: " + numlist);
        System.out.println("Missing numbers:");

        // Loop to find the missing numbers
        for (int i = 0; i < numlist.size() - 1; i++) 
        {
            int current = numlist.get(i);
            int next = numlist.get(i + 1);

            // Check for gap
                if (next != current + 1) 
            {
                for (int missing = current + 1; missing < next; missing++)
                {
                    System.out.println(missing);
                }
            }
        }
    }
	}

