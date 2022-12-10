package adventOfCode.days;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import adventOfCode.helpers.InputHelper;

public class Day3 {
	    public static void main(String ... args) throws Exception 
	    {
	        List<String> lines = InputHelper.getInputAsListOfLines(3);

	        int firstPart = lines.stream()
	        	.map(Day3::getCommonCharFromString)
	        	.mapToInt(commonChar -> getCharScore(commonChar))
                .sum();

	        var counter = IntStream.range(0, lines.size()).iterator();
	        var sum2 = lines.stream()
	            .collect(Collectors.groupingBy(c -> counter.nextInt()/3)).values().stream()
	            .map(foo -> foo.stream().reduce((s1, s2) -> getCommonChar(s1, s2)).get().charAt(0))
	            .mapToInt(l -> getCharScore(l)).sum();
	        
	        
	        System.out.printf("part 1: %d\n", firstPart);
	        System.out.printf("part 2: %d\n", sum2);

	    }
	    
	    public static int getCharScore(char commonChar)
	    {
	    	return commonChar < 'a' ? commonChar - 'A' + 27 : commonChar - 'a' + 1;
	    }

	    public static char getCommonCharFromString(String line)
	    {
        	String firstPart = line.substring(0, line.length()/2);
        	String secondPart = line.substring(line.length()/2, line.length());
        	return getCommonChar(firstPart, secondPart).charAt(0);
	    }
	    
	    public static String getCommonChar(String firstPart, String secondPart)
	    {
        	return firstPart.chars().filter(i1 -> secondPart.chars().anyMatch(i2 -> i1 == i2)).distinct()
                    .mapToObj(c -> Character.toString(c)).collect(Collectors.joining());
	    }
	}