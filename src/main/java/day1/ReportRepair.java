package day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import common.Puzzle;

public class ReportRepair extends Puzzle
{
	protected static List<Integer> source;

	public ReportRepair() throws IOException, URISyntaxException
	{
		super("day1.txt");

		source = getInput().stream().map(s -> s.replace(",", "").trim())
				.map(Integer::parseInt).collect(Collectors.toList());
	}

	public int getPartOneResult()
	{
		AtomicInteger result = new AtomicInteger();

		source.forEach(firstNumber -> source.forEach(secondNumber -> {

			if (firstNumber + secondNumber == 2020)
			{
				result.set(firstNumber * secondNumber);
			}

		}));

		return result.get();
	}


	public int getPartTwoResult()
	{
		AtomicInteger result = new AtomicInteger();

		source.forEach(firstNumber ->
				source.forEach(secondNumber -> source.forEach(thirdNumber -> {

					if (firstNumber + secondNumber + thirdNumber == 2020)
					{
						result.set(firstNumber * secondNumber * thirdNumber);
					}

				})));

		return result.get();
	}


}
