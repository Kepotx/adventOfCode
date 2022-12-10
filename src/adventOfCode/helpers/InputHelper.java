package adventOfCode.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputHelper 
{

	public static List<String> getInputAsListOfLines(int day) throws IOException
	{
        return getInputAsListOfLines(day, false);
	}
	
	public static List<String> getInputAsListOfLines(int day, boolean test) throws IOException
	{
        return Files.readAllLines(Path.of("inputs/day" + day + (test ? "test" : "") + ".txt"));
	}
	
	public static String getInputAsString(int day) throws IOException
	{
		return Files.readString(Path.of("inputs/day" + day + ".txt"));
	}
	
	public static <T> List<T> parseInput(String input, String separatorRegex, Function<String, T> mapToEntry) 
	{
        if (input == null || input.isBlank()) 
        {
            return List.of();
        }
        return Stream.of(input.split(separatorRegex))
                .map(String::trim)
                .map(mapToEntry)
                .collect(Collectors.toList());
    }

	/**
	 * @day day the day to parse
	 * @day separatorRegex the regex separator to use to split the inputs
	 */
	public static List<String> getInputWithSeparator(int day, String separatorRegex) throws IOException 
	{
        return Parser.parseInput(getInputAsString(1), separatorRegex);
    }
	
	/**
	 * @day day the day to parse
	 * @day separatorRegex the regex separator to use to split the inputs
	 */
	public static List<String> getInputWithSeparatorTrim(int day, String separatorRegex) throws IOException 
	{
        return Stream.of(getInputAsString(1).split(separatorRegex))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
