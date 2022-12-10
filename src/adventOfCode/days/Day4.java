package adventOfCode.days;

import java.util.List;

import adventOfCode.helpers.InputHelper;

public class Day4 {
	    public static void main(String ... args) throws Exception 
	    {
	        List<String> lines = InputHelper.getInputAsListOfLines(4);

	        long fullyContains = lines.stream()
	        	.filter(Day4::fullyContains)
                .count();

	        long overlap = lines.stream()
	        	.filter(Day4::overlap)
                .count();

	        System.out.printf("part 1: %d\n", fullyContains);
	        System.out.printf("part 2: %d\n", overlap);
	        
	    }

	    public static boolean fullyContains(String line)
	    {
        	String firstElf = line.split(",")[0];
        	String secondElf = line.split(",")[1];

        	Integer firstElfStart = Integer.valueOf(firstElf.split("-")[0]);
        	Integer firstElfEnd = Integer.valueOf(firstElf.split("-")[1]);
        	
        	Integer secondElfStart = Integer.valueOf(secondElf.split("-")[0]);
        	Integer secondElfEnd = Integer.valueOf(secondElf.split("-")[1]);

        	boolean firstContainsSecond = firstElfStart <= secondElfStart && firstElfEnd >= secondElfEnd;
        	boolean secondContainsFirst = secondElfStart <= firstElfStart && secondElfEnd >= firstElfEnd;
	    	return firstContainsSecond || secondContainsFirst;
	    }
	    
	    public static boolean overlap(String line)
	    {
        	String firstElf = line.split(",")[0];
        	String secondElf = line.split(",")[1];

        	Integer firstElfStart = Integer.valueOf(firstElf.split("-")[0]);
        	Integer firstElfEnd = Integer.valueOf(firstElf.split("-")[1]);
        	
        	Integer secondElfStart = Integer.valueOf(secondElf.split("-")[0]);
        	Integer secondElfEnd = Integer.valueOf(secondElf.split("-")[1]);

        	boolean firstOverlapSecond = firstElfStart <= secondElfStart && firstElfEnd >= secondElfStart;
        	boolean secondOverlapFirst = secondElfStart <= firstElfStart && secondElfEnd >= firstElfStart;
	    	return firstOverlapSecond || secondOverlapFirst;
	    }

	}