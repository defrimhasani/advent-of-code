package day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

import common.Puzzle;

public class PasswordPhilosophy extends Puzzle
{
	List<String> input;

	public PasswordPhilosophy() throws IOException, URISyntaxException
	{
		super("day2.txt");

		input = getInput();
	}

	public static boolean accepted(String word, int least, int most, char c)
	{

		boolean leastMatch = false;


		try
		{
			leastMatch = word.charAt(least - 1) == c;
		}
		catch (Exception ignored)
		{

		}

		boolean mostMatch = false;
		try
		{
			mostMatch = word.charAt(most - 1) == c;
		}
		catch (Exception ignored)
		{
		}

		return (leastMatch || mostMatch) && !(leastMatch && mostMatch);
	}

	public int getPartTwoResult()
	{
		int total = 0;

		for (String record : input)
		{
			final Policy policy = new Policy(record);

			if (accepted(policy.getPassword(), policy.getLeast(), policy.getMost(), policy.getLetter()))
			{
				total++;
			}

		}

		return total;
	}

	public int getPartOneResult()
	{
		int total = 0;

		for (String record : input)
		{
			final Policy policy = new Policy(record);

			final int characters = countCharacters(policy.getPassword(), policy.getLetter());

			if (characters >= policy.getLeast() && characters <= policy.getMost())
				total++;


		}

		return total;

	}

	public int countCharacters(String word, char c)
	{
		return (int) IntStream.range(0, word.length()).filter(i -> word.charAt(i) == c).count();
	}


}
