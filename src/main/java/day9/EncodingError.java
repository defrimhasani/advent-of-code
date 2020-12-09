package day9;

import static java.lang.Math.addExact;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.Puzzle;

public class EncodingError extends Puzzle
{

	public static final int MAX_NUMBER = 25;
	private final List<String> input;

	public EncodingError() throws IOException, URISyntaxException
	{
		super("day9.txt");
		input = getInput();
	}

	public SolutionResult getSolution()
	{
		SolutionResult.SolutionResultBuilder solutionResultBuilder =
				new SolutionResult.SolutionResultBuilder();

		int invalidNumber = 0;
		int invalidNumberIndex = 0;

		List<Long> collectedNumbers =
				IntStream.range(0, MAX_NUMBER)
						.mapToObj(index -> Long.parseLong(input.get(index)))
						.collect(Collectors.toList());

		{
			int i = MAX_NUMBER;

			while (i < input.size())
			{
				int currentNumber = Integer.parseInt(input.get(i));

				boolean numberFound = false;

				int j = 0;
				while (j < collectedNumbers.size())
				{
					if (numberFound)
						break;
					int k = j + 1;

					while (k < collectedNumbers.size())
					{
						if (addExact(collectedNumbers.get(j), collectedNumbers.get(k)) == currentNumber)
						{
							numberFound = true;
							break;
						}
						k++;
					}
					j++;
				}

				if (numberFound)
				{
					removeAndAdd(collectedNumbers, currentNumber);
				}
				else
				{
					invalidNumber = currentNumber;
					invalidNumberIndex = i;
					solutionResultBuilder.partOneResult(invalidNumber);
					break;
				}
				i++;
			}
		}


		boolean found = false;
		int i = 0;

		while (i < invalidNumberIndex - 2)
		{
			if (found)
				break;
			int j = i + 1;
			while (j < invalidNumberIndex)
			{
				int sum = 0;
				int smallest = Integer.MAX_VALUE;
				int largest = Integer.MIN_VALUE;
				int k = i;
				while (k <= j)
				{
					int number = Integer.parseInt(input.get(k));
					sum += number;
					if (number < smallest)
						smallest = number;
					else if (number > largest)
						largest = number;
					k++;
				}

				if (sum == invalidNumber)
				{
					found = true;
					solutionResultBuilder.partTwoResult(Math.addExact(smallest, largest));
					break;
				}
				j++;
			}
			i++;
		}

		return solutionResultBuilder.build();
	}

	private void removeAndAdd(List<Long> collection, int value)
	{
		collection.remove(0);
		collection.add((long) value);
	}

}
