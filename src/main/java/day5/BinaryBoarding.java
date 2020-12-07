package day5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import common.Puzzle;

public class BinaryBoarding extends Puzzle
{
	public BinaryBoarding()
	{
		super("day5.txt");
	}

	public int getPartOneResult() throws IOException, URISyntaxException
	{
		int max = 0;
		List<Integer> ids = new ArrayList<>();

		for (String s : getInput())
		{
			int row;
			int col;

			row = IntStream.range(0, 7).filter(i -> s.charAt(i) == 'B').map(i -> (int) Math.pow(2, 6 - i)).sum();

			col = IntStream.range(7, 10).filter(i -> s.charAt(i) == 'R').map(i -> (int) Math.pow(2, 9 - i)).sum();

			int rowCol = (row * 8) + col;

			ids.add(rowCol);

			if (rowCol > max)
				max = rowCol;
		}

		return max;
	}

	public int getPartTwoResult() throws IOException, URISyntaxException
	{
		int result = 0;

		int max = 0;
		List<Integer> ids = new ArrayList<>();
		for (String s : getInput())
		{
			int row;
			int col;
			row = IntStream.range(0, 7).filter(i -> s.charAt(i) == 'B').map(i -> (int) Math.pow(2, 6 - i)).sum();

			col = IntStream.range(7, 10).filter(i -> s.charAt(i) == 'R').map(i -> (int) Math.pow(2, 9 - i)).sum();

			int rowCol = (row * 8) + col;
			ids.add(rowCol);
			if (rowCol > max)
				max = rowCol;
		}


		int lastID = -1;
		ids.sort(Integer::compareTo);
		for (int i : ids)
		{
			if (lastID != -1 && i - lastID == 2)
			{
				result = (i - 1);
				break;
			}
			lastID = i;
		}

		return result;
	}
}
