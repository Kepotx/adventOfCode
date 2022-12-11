package adventOfCode.days;

import java.util.stream.IntStream;

import adventOfCode.helpers.InputHelper;

public class Day6 {
	
	    public static void main(String ... args) throws Exception 
	    {
	        String input = InputHelper.getInputAsString(6);

	        long part1 = getMarkerIndex(input, 4);

	        long part2 = getMarkerIndex(input, 14);
	        
	        System.out.println("part 1: " + part1);
	        System.out.println("part 2: " + part2);
	    }

	    public static int getMarkerIndex(String input, int len) 
	    {
	        return IntStream.range(0, input.length()-len)
	            .filter(i -> notEquals(input.substring(i, i + len)))
	            .findFirst()
	            .getAsInt() + len;
	    }

	    public static boolean notEquals(String input) 
	    {
	        return input.chars().distinct().count() == input.length();
	    }
	}