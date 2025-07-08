package week3.assignment;

import java.util.Arrays;

public class MissingelementArray 
{
	public static void main(String[] args) 
	{
		int[] numbers = {31, 34, 33, 32, 38, 36, 37};
        Arrays.sort(numbers); 
        for (int i = 0; i < numbers.length - 1; i++) 
        {
             if (numbers[i + 1] != numbers[i] + 1) 
             {
                int missingNumber = numbers[i] + 1;
                System.out.println("Missing number is: " + missingNumber);
                break;
            }
        }	

	}

}
