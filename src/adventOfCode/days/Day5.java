package adventOfCode.days;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import adventOfCode.helpers.InputHelper;

public class Day5 {
	
	    public static void main(String ... args) throws Exception 
	    {
//	    	List<String> crates = new ArrayList<String>(List.of("ZN", "MCD", "P"));
	    	List<String> crates = new ArrayList<String>(List.of("FHBVRQDP", "LDZQWV", "HLZQGRPC", "RDHFJVB", "ZWLC", "JRPNTGVM", "JRLVMBS", "DPJ", "DCNWV"));
	    	List<String> cratesPartTwo = new ArrayList<String>(List.of("FHBVRQDP", "LDZQWV", "HLZQGRPC", "RDHFJVB", "ZWLC", "JRPNTGVM", "JRLVMBS", "DPJ", "DCNWV"));

	        List<String> lines = InputHelper.getInputAsListOfLines(5);

	        for (String line : lines)
	        {
	        	var match = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)").matcher(line);
	        	match.matches();

	        	Integer numberOfCrates = Integer.parseInt(match.group(1));
	        	Integer fromStack = Integer.parseInt(match.group(2));
	        	Integer toStack = Integer.parseInt(match.group(3));
	        	
	        	for (int i = 0; i < numberOfCrates; i++)
	        	{
	        		String fromCrates = crates.get(fromStack - 1);
	        		String toCrates = crates.get(toStack - 1);
	        		toCrates = toCrates + getLastChars(fromCrates);
	        		fromCrates = fromCrates.substring(0, fromCrates.length() - 1);
	        		crates.set(fromStack - 1, fromCrates);
	        		crates.set(toStack - 1, toCrates);
	        	}
	        }

	        for (String line : lines)
	        {
	        	var match = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)").matcher(line);
	        	match.matches();

	        	Integer numberOfCrates = Integer.parseInt(match.group(1));
	        	Integer fromStack = Integer.parseInt(match.group(2));
	        	Integer toStack = Integer.parseInt(match.group(3));
	        	
        		String fromCrates = cratesPartTwo.get(fromStack - 1);
        		String toCrates = cratesPartTwo.get(toStack - 1);
        		toCrates = toCrates + getLastChars(fromCrates, numberOfCrates);
        		fromCrates = fromCrates.substring(0, fromCrates.length() - numberOfCrates);
        		cratesPartTwo.set(fromStack - 1, fromCrates);
        		cratesPartTwo.set(toStack - 1, toCrates);
	        }

	        String part1 = "";

        	for (String crate : crates)
        	{
        		part1 += getLastChars(crate);
        	}
        	
	        String part2 = "";

        	for (String crate : cratesPartTwo)
        	{
        		part2 += getLastChars(crate);
        	}
	        
	        System.out.println("part 1: " + part1);
	        System.out.println("part 2: " + part2);
	        
	    }

	    public static String getLastChars(String string)
	    {
	    	return getLastChars(string, 1);
	    }
	    
	    public static String getLastChars(String string, int numberOfChar)
	    {
	    	return string.substring(string.length() - numberOfChar);
	    }
	}