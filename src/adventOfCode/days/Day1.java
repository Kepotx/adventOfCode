package adventOfCode.days;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import adventOfCode.helpers.InputHelper;
import adventOfCode.helpers.Parser;

public class Day1 {
	    public static void main(String ... args) throws Exception 
	    {
	        List<Integer> calories = InputHelper.getInputWithSeparatorTrim(1, "\r\n\r\n").stream()
	        		.map(calorie -> Parser.parseInput(calorie, "\r\n", Integer::valueOf))
	                .map(l -> l.stream().reduce(0, Integer::sum))
	                .collect(Collectors.toList());

	        Collections.sort(calories);
	        Collections.reverse(calories);

	        System.out.printf("part 1: %d\n", calories.get(0));

	        System.out.printf("part 2: %d\n", calories.stream()
	        		.limit(3)
	                .flatMapToInt(IntStream::of)
	                .sum());
	    }
	}