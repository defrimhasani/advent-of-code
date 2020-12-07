package day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

import common.Puzzle;

public class TobogganTrajectory extends Puzzle
{
	List<String> input;

	public TobogganTrajectory() throws IOException, URISyntaxException
	{
		super("day3.txt");
		input = getInput();
	}


	private char[][] getData()
	{

		char[][] chars = new char[input.size()][31];

		IntStream.range(0, input.size()).forEach(i -> {
			char[] charArray = input.get(i).toCharArray();
			System.arraycopy(charArray, 0, chars[i], 0, charArray.length);
		});

		return chars;
	}

	public int getPartOneResult()
	{
		return countTotalTrees(getData(), 3, 1);
	}

	public long getPartTwoResult()
	{
		char[][] data = getData();

		long hits = countTotalTrees(data, 1, 1);

		hits *= countTotalTrees(data, 3, 1);
		hits *= countTotalTrees(data, 5, 1);
		hits *= countTotalTrees(data, 7, 1);
		hits *= countTotalTrees(data, 1, 2);

		return hits;
	}


	public int countTotalTrees(char[][] chars, int slopeX, int slopeY)
	{

		int totalTrees = 0;

		int x = 0;
		int y = 0;

		while (y < chars.length)
		{
			if (chars[y][x] == '#')
				totalTrees++;

			x = (x + slopeX) % 31;
			y += slopeY;

		}

		return totalTrees;

	}


}
