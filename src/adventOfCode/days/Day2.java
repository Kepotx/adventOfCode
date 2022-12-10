package adventOfCode.days;

import java.util.List;

import adventOfCode.helpers.InputHelper;

public class Day2 {
	    public static void main(String ... args) throws Exception 
	    {
	        List<String> lines = InputHelper.getInputAsListOfLines(2);

	        int total = 0;
	        int totalBis = 0;
	        
	        for (String line : lines)
	        {
	        	String opponent = line.split(" ")[0];
	        	String shape = line.split(" ")[1];

	        	// C'est moche mais ca marche
	        	if (shape.equals("X"))
	        	{
	        		total += 1;
	        		totalBis += 0;
	        		if (opponent.equals("A"))
	        		{
	        			total += 3;
		        		totalBis += 3;
	        		}
	        		else if (opponent.equals("B"))
	        		{
	        			total += 0;
		        		totalBis += 1;
	        		}
	        		else
	        		{
	        			total += 6;
		        		totalBis += 2;
	        		}
	        	}
	        	
	        	if (shape.equals("Y"))
	        	{
	        		total += 2;
	        		totalBis += 3;
	        		if (opponent.equals("A"))
	        		{
	        			total += 6;
		        		totalBis += 1;
	        		}
	        		else if (opponent.equals("B"))
	        		{
	        			total += 3;
		        		totalBis += 2;
	        		}
	        		else
	        		{
	        			total += 0;
		        		totalBis += 3;
	        		}
	        	}

	        	if (shape.equals("Z"))
	        	{
	        		total += 3;
	        		totalBis += 6;
	        		if (opponent.equals("A"))
	        		{
	        			total += 0;
	        			totalBis += 2;
	        		}
	        		else if (opponent.equals("B"))
	        		{
	        			total += 6;
	        			totalBis += 3;
	        		}
	        		else
	        		{
	        			total += 3;
	        			totalBis += 1;
	        		}
	        	}
	        }

	        System.out.printf("part 1: %d\n", total);
	        System.out.printf("part 2: %d\n", totalBis);
	        

	    }
	}